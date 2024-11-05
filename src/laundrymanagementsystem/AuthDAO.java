/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laundrymanagementsystem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthDAO {
    private static final String BASE_URL = "http://localhost:3000/api/user";

    public String registerUser(String payload) throws IOException {
        String registerUrl = BASE_URL + "/register";
        return sendRequest(registerUrl, "POST", payload);
    }

    public String loginUser(String payload) throws IOException {
        String loginUrl = BASE_URL + "/login";
        return sendRequest(loginUrl, "POST", payload);
    }

    public String logoutUser() throws IOException {
        String logoutUrl = BASE_URL + "/logout";
        return sendRequest(logoutUrl, "GET", null);
    }

    private String sendRequest(String url, String method, String payload) throws IOException {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL endpoint = new URL(url);
            connection = (HttpURLConnection) endpoint.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            if (payload != null) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(payload.getBytes());
                outputStream.flush();
                outputStream.close();
            }

            int responseCode = connection.getResponseCode();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return response.toString();
            } else {
                throw new IOException("Request failed with response code: " + responseCode);
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    public static void main(String[] args) {
        AuthDAO authDAO = new AuthDAO();

        try {
            // Register a user
            String registerPayload = "{\"fname\":\"John\",\"lname\":\"Doe\",\"email\":\"john@example.com\",\"address\":\"123 Street\",\"phone\":\"123456789\",\"username\":\"johndoe\",\"role\":\"user\",\"password\":\"password123\"}";
            String registerResponse = authDAO.registerUser(registerPayload);
            System.out.println("Register Response: " + registerResponse);

            // Login a user
            String loginPayload = "{\"username\":\"johndoe\",\"role\":\"user\",\"password\":\"password123\"}";
            String loginResponse = authDAO.loginUser(loginPayload);
            System.out.println("Login Response: " + loginResponse);

            // Logout a user
            String logoutResponse = authDAO.logoutUser();
            System.out.println("Logout Response: " + logoutResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
