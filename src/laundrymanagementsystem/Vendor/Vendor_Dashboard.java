/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laundrymanagementsystem.Vendor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import laundrymanagementsystem.Login;

/**
 *
 * @author Bajwa
 */
public class Vendor_Dashboard extends javax.swing.JFrame {
    
    private JPanel panel = new JPanel();

    /**
     * Creates new form Vendor_Dashboard
     */
    public Vendor_Dashboard() {
        initComponents();
        scaleImage();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("AdminDashboardLogo.png")));
        showVendors();
    }
    private JPanel createVendorPanel(String vendorName, String rating, String location, String phone, String deliveryAvailable) {
    JPanel vendorPanel = new JPanel();
    vendorPanel.setBackground(new java.awt.Color(255, 255, 255, 170));
    vendorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    JLabel edtVendorName = new JLabel();
    edtVendorName.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36));
    edtVendorName.setText(vendorName);
    edtVendorName.setBorder(null);
    edtVendorName.setBackground(new Color(0, 0, 0, 0));
    vendorPanel.add(edtVendorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 12, 260, -1));

    JTextField jTextField1 = new JTextField();
    jTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18));
    jTextField1.setText(rating);
    jTextField1.setBorder(null);
    jTextField1.setBackground(new Color(0, 0, 0, 0));
    
    vendorPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 64, 173, 33));

    JTextField jTextField2 = new JTextField();
    jTextField2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18));
    jTextField2.setText(location);
    jTextField2.setBorder(null);
    jTextField2.setBackground(new Color(0, 0, 0, 0));
    
    vendorPanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 103, 173, 33));

    JTextField jTextField3 = new JTextField();
    jTextField3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18));
    jTextField3.setText(phone);
    jTextField3.setBorder(null);
    jTextField3.setBackground(new Color(0, 0, 0, 0));
    
    vendorPanel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 142, 173, 33));

    JTextField jTextField4 = new JTextField();
    jTextField4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18));
    jTextField4.setText(deliveryAvailable);
    jTextField4.setBorder(null);
    jTextField4.setBackground(new Color(0, 0, 0, 0));
    
    vendorPanel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 181, 173, 33));

    JLabel jLabel5 = new JLabel();
    jLabel5.setBackground(new java.awt.Color(255, 255, 255));
    jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18));
    jLabel5.setText("Rating");
    vendorPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 64, 106, 33));

    JLabel jLabel6 = new JLabel();
    jLabel6.setBackground(new java.awt.Color(255, 255, 255));
    jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18));
    jLabel6.setText("Location");
    vendorPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 103, 106, 33));

    JLabel jLabel7 = new JLabel();
    jLabel7.setBackground(new java.awt.Color(255, 255, 255));
    jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18));
    jLabel7.setText("Phone");
    vendorPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 142, 106, 33));

    JLabel jLabel8 = new JLabel();
    jLabel8.setBackground(new java.awt.Color(255, 255, 255));
    jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18));
    jLabel8.setText("Delivery Available");
    vendorPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 181, -1, 33));

    JButton viewButton = new JButton();
    viewButton.setBackground(new java.awt.Color(0, 181, 204));
    viewButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24));
    viewButton.setForeground(new java.awt.Color(255, 255, 255));
    viewButton.setText("View");
    viewButton.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Vendor_CheckVendors vendorCheckVendors = new Vendor_CheckVendors();
            vendorCheckVendors.setVisible(true);
        }
    });
    
    vendorPanel.add(viewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 230, -1, -1));

    return vendorPanel;
}

    
    
    
    private void showVendors() {
    panel.removeAll();

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/laundry", "root", "salad123");
        String query = "SELECT v.Name AS VendorName, s.Rates, v.Location, v.Phone, v.DeliveryAvailable FROM vendor v "
                + "JOIN specialization s ON v.SpecializationID = s.SpecializationID";

        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String vendorName = rs.getString("VendorName");
            String rating = rs.getString("Rates");
            String location = rs.getString("Location");
            String phone = rs.getString("Phone");
            String deliveryAvailable = rs.getString("DeliveryAvailable");

            JPanel vendorPanel = createVendorPanel(vendorName, rating, location, phone, deliveryAvailable);
            panel.add(vendorPanel);
        }

        rs.close();
        pst.close();
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    jScrollPane1.setViewportView(panel);
}

    
    


    public void scaleImage() {
        String imagePath1 = "6.png"; // Relative path to the first image file
        String imagePath2 = "logout1.png"; // Relative path to the second image file
        String imagePath3 = "AdminDashboardLogo.png"; // Relative path to the third image file
        String imagePath4 = "logout1.png"; // Relative path to the fourth image file
        String imagePath5 = "2.jpg"; // Relative path to the fifth image file

// Load the first image file as a resource from the classpath
//        URL imageUrl1 = getClass().getResource(imagePath1);
//
//        if (imageUrl1 != null) {
//            // Create an ImageIcon using the loaded resource
//            ImageIcon icon1 = new ImageIcon(imageUrl1);
//
//            // Scale the image and set it to the jLabel9 component
//            Image img1 = icon1.getImage();
//            Image imgScale1 = img1.getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
//            jLabel9.setIcon(scaledIcon1);
//        } else {
//            System.out.println("Image not found: " + imagePath1);
//        }

// Load the second image file as a resource from the classpath
//        URL imageUrl2 = getClass().getResource(imagePath2);
//
//        if (imageUrl2 != null) {
//            // Create an ImageIcon using the loaded resource
//            ImageIcon icon2 = new ImageIcon(imageUrl2);
//
//            // Scale the image and set it to the jLabel10 component
//            Image img2 = icon2.getImage();
//            Image imgScale2 = img2.getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
//            jLabel10.setIcon(scaledIcon2);
//        } else {
//            System.out.println("Image not found: " + imagePath2);
//        }

// Load the third image file as a resource from the classpath
        URL imageUrl3 = getClass().getResource(imagePath3);

        if (imageUrl3 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon3 = new ImageIcon(imageUrl3);

            // Scale the image and set it to the jLabel2 component
            Image img3 = icon3.getImage();
            Image imgScale3 = img3.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
            jLabel2.setIcon(scaledIcon3);
        } else {
            System.out.println("Image not found: " + imagePath3);
        }

// Load the fourth image file as a resource from the classpath
        URL imageUrl4 = getClass().getResource(imagePath4);

        if (imageUrl4 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon4 = new ImageIcon(imageUrl4);

            // Scale the image and set it to the jLabel3 component
            Image img4 = icon4.getImage();
            Image imgScale4 = img4.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
            jLabel3.setIcon(scaledIcon4);
        } else {
            System.out.println("Image not found: " + imagePath4);
        }

// Load the fifth image file as a resource from the classpath
        URL imageUrl5 = getClass().getResource(imagePath5);

        if (imageUrl5 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon5 = new ImageIcon(imageUrl5);

            // Scale the image and set it to the jLabel4 component
            Image img5 = icon5.getImage();
            Image imgScale5 = img5.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
            jLabel4.setIcon(scaledIcon5);
        } else {
            System.out.println("Image not found: " + imagePath5);
        }

    }

    /**
     *
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new RoundedPanel(100);
        edtVendorName = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new RoundedPanel(100);
        edtVendorName1 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new RoundedPanel(100);
        edtVendorName2 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 181, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vendor Dashboard");

        jButton1.setBackground(new java.awt.Color(0, 181, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Edit Profile");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(366, 366, 366)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)))
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 181, 204));
        // Add the vendorPanel to the jScrollPane1

        jPanel2.setBackground(new java.awt.Color(255, 255, 255,170));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edtVendorName.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        edtVendorName.setText("XYZ SHOP");
        edtVendorName.setBorder(null);
        edtVendorName.setBackground(new Color(0, 0, 0, 0));
        jPanel2.add(edtVendorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 12, 260, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField1.setText("4.9");
        jTextField1.setBorder(null);
        jTextField1.setBackground(new Color(0, 0, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 64, 173, 33));

        jTextField2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField2.setText("Gulshan Iqbal");
        jTextField2.setBorder(null);
        jTextField2.setBackground(new Color(0, 0, 0, 0));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 103, 173, 33));

        jTextField3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField3.setText("+9234240-61959");
        jTextField3.setBorder(null);
        jTextField3.setBackground(new Color(0, 0, 0, 0));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 142, 173, 33));

        jTextField4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField4.setText("Yes");
        jTextField4.setBorder(null);
        jTextField4.setBackground(new Color(0, 0, 0, 0));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 181, 173, 33));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel5.setText("Rating");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 64, 106, 33));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel6.setText("Location");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 103, 106, 33));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel7.setText("Phone");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 142, 106, 33));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel8.setText("Delivery Available");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 181, -1, 33));

        jButton2.setBackground(new java.awt.Color(0, 181, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 90, 33));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255,170));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edtVendorName1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        edtVendorName1.setText("XYZ SHOP");
        edtVendorName1.setBorder(null);
        edtVendorName.setBackground(new Color(0, 0, 0, 0));
        jPanel5.add(edtVendorName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 12, 260, -1));

        jTextField5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField5.setText("4.9");
        jTextField5.setBorder(null);
        jTextField1.setBackground(new Color(0, 0, 0, 0));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 64, 173, 33));

        jTextField6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField6.setText("Gulshan Iqbal");
        jTextField6.setBorder(null);
        jTextField2.setBackground(new Color(0, 0, 0, 0));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 103, 173, 33));

        jTextField7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField7.setText("+9234240-61959");
        jTextField7.setBorder(null);
        jTextField3.setBackground(new Color(0, 0, 0, 0));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 142, 173, 33));

        jTextField8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField8.setText("Yes");
        jTextField8.setBorder(null);
        jTextField4.setBackground(new Color(0, 0, 0, 0));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 181, 173, 33));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel12.setText("Rating");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 64, 106, 33));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel13.setText("Location");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 103, 106, 33));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel14.setText("Phone");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 142, 106, 33));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel15.setText("Delivery Available");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 181, -1, 33));

        jButton4.setBackground(new java.awt.Color(0, 181, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 90, 33));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255,170));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edtVendorName2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        edtVendorName2.setText("XYZ SHOP");
        edtVendorName2.setBorder(null);
        edtVendorName.setBackground(new Color(0, 0, 0, 0));
        jPanel6.add(edtVendorName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 12, 260, -1));

        jTextField9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField9.setText("4.9");
        jTextField9.setBorder(null);
        jTextField1.setBackground(new Color(0, 0, 0, 0));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 64, 173, 33));

        jTextField10.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField10.setText("Gulshan Iqbal");
        jTextField10.setBorder(null);
        jTextField2.setBackground(new Color(0, 0, 0, 0));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 103, 173, 33));

        jTextField11.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField11.setText("+9234240-61959");
        jTextField11.setBorder(null);
        jTextField3.setBackground(new Color(0, 0, 0, 0));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 142, 173, 33));

        jTextField12.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jTextField12.setText("Yes");
        jTextField12.setBorder(null);
        jTextField4.setBackground(new Color(0, 0, 0, 0));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 181, 173, 33));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel16.setText("Rating");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 64, 106, 33));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel17.setText("Location");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 103, 106, 33));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel18.setText("Phone");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 142, 106, 33));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel19.setText("Delivery Available");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 181, -1, 33));

        jButton6.setBackground(new java.awt.Color(0, 181, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("View");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 90, 33));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(696, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 181, 204));
        jLabel11.setText("Vendors");

        jButton3.setBackground(new java.awt.Color(0, 181, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 181, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Specialization");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(457, 457, 457))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(435, 435, 435))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1388, 1388, 1388))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        Vendor_EditProfile vend_EditProf = new Vendor_EditProfile();
        vend_EditProf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        Vendor_AddVendors vend_add = new Vendor_AddVendors();
        vend_add.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        Vendor_Specialization vend_dash = new Vendor_Specialization();
        vend_dash.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        Vendor_CheckVendors vend_check = new Vendor_CheckVendors();
        vend_check.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vendor_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendor_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendor_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendor_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendor_Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edtVendorName;
    private javax.swing.JTextField edtVendorName1;
    private javax.swing.JTextField edtVendorName2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
 class RoundedPanel extends JPanel {

        private int cornerRadius = 15;

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
            setOpaque(false); // Make the panel transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D graphics = (Graphics2D) g.create();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();

            // Create a rounded rectangle shape
            Shape shape = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);

            // Set the desired background color with transparency
            Color bgColor = new Color(255, 255, 255, 140); // White with transparency
            graphics.setColor(bgColor);

            // Fill the shape with the background color
            graphics.fill(shape);

            graphics.dispose();
        }
    }
}
