/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laundrymanagementsystem.Customer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import laundrymanagementsystem.Login;
import laundrymanagementsystem.Vendor.Vendor_CheckVendors;

/**
 *
 * @author Bajwa
 */
public class Customer_Dashboard extends javax.swing.JFrame {
    
    private JPanel panel = new JPanel();

    /**
     * Creates new form Customer_Dashboard
     */
    public Customer_Dashboard() {
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

    JButton jButton2 = new JButton();
    jButton2.setBackground(new java.awt.Color(0, 181, 204));
    jButton2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24));
    jButton2.setForeground(new java.awt.Color(255, 255, 255));
    jButton2.setText("View");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Customer_CheckVendor vendorCheckVendors = new Customer_CheckVendor();
            vendorCheckVendors.setVisible(true);
        }
    });
    
    vendorPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 230, -1, -1));

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
        String imagePath = "2.jpg"; // Relative path to the first image file
        String imagePath10 = "logout1.png"; // Relative path to the second image file
        String imagePath2 = "AdminDashboardLogo.png"; // Relative path to the third image file
        String imagePath3 = "logout1.png"; // Relative path to the fourth image file
        String imagePath4 = "2.jpg"; // Relative path to the fifth image file

// Load the first image file as a resource from the classpath
//        URL imageUrl = getClass().getResource(imagePath);
//
//        if (imageUrl != null) {
//            // Create an ImageIcon using the loaded resource
//            ImageIcon icon = new ImageIcon(imageUrl);
//
//            // Scale the image and set it to the jLabel9 component
//            Image img = icon.getImage();
//            Image imgScale = img.getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon scaledIcon = new ImageIcon(imgScale);
//            jLabel9.setIcon(scaledIcon);
//        } else {
//            System.out.println("Image not found: " + imagePath);
//        }

// Load the second image file as a resource from the classpath
//        URL imageUrl10 = getClass().getResource(imagePath10);
//
//        if (imageUrl10 != null) {
//            // Create an ImageIcon using the loaded resource
//            ImageIcon icon10 = new ImageIcon(imageUrl10);
//
//            // Scale the image and set it to the jLabel10 component
//            Image img10 = icon10.getImage();
//            Image imgScale10 = img10.getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon scaledIcon10 = new ImageIcon(imgScale10);
//            jLabel10.setIcon(scaledIcon10);
//        } else {
//            System.out.println("Image not found: " + imagePath10);
//        }

// Load the third image file as a resource from the classpath
        URL imageUrl2 = getClass().getResource(imagePath2);

        if (imageUrl2 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon2 = new ImageIcon(imageUrl2);

            // Scale the image and set it to the jLabel2 component
            Image img2 = icon2.getImage();
            Image imgScale2 = img2.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
            jLabel2.setIcon(scaledIcon2);
        } else {
            System.out.println("Image not found: " + imagePath2);
        }

// Load the fourth image file as a resource from the classpath
        URL imageUrl3 = getClass().getResource(imagePath3);

        if (imageUrl3 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon3 = new ImageIcon(imageUrl3);

            // Scale the image and set it to the jLabel3 component
            Image img3 = icon3.getImage();
            Image imgScale3 = img3.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
            jLabel3.setIcon(scaledIcon3);
        } else {
            System.out.println("Image not found: " + imagePath3);
        }

// Load the fifth image file as a resource from the classpath
        URL imageUrl4 = getClass().getResource(imagePath4);

        if (imageUrl4 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon4 = new ImageIcon(imageUrl4);

            // Scale the image and set it to the jLabel4 component
            Image img4 = icon4.getImage();
            Image imgScale4 = img4.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
            jLabel4.setIcon(scaledIcon4);
        } else {
            System.out.println("Image not found: " + imagePath4);
        }

    }

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
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 181, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Dashboard");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
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
        jPanel2.add(edtVendorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 12, 410, -1));

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
        jButton2.setText("Order Now");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 220, 160, 45));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(646, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 181, 204));
        jLabel11.setText("Available Vendors");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(240, 682, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        Customer_CheckVendor cust_vendor = new Customer_CheckVendor();
        cust_vendor.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        Customer_EditProfile cust_editprofile = new Customer_EditProfile();
        cust_editprofile.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edtVendorName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
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
