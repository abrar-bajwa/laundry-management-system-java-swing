/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laundrymanagementsystem;

import laundrymanagementsystem.Admin_OrderComplete.Admin_OrdersComplete;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import laundrymanagementsystem.Admin_PendingOrders.Admin_PendingOrders;
import laundrymanagementsystem.Admin_Vendors.Admin_Vendors;
import laundrymanagementsystem.OrdersDetails.Admin_OrderDetails;

/**
 *
 * @author Bajwa
 */
public class AdminDashboard extends javax.swing.JFrame {

    private Admin_OrdersComplete adminOrderscomplete;

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        scaleImage();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("AdminDashboardLogo.png")));
    }

    public void scaleImage() {
        /**
         * for 1
         */

        String imagePath = "1.png";  // Relative path to the image file

// Load the image file as a resource from the classpath
        URL imageUrl = getClass().getResource(imagePath);

        if (imageUrl != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon2 = new ImageIcon(imageUrl);

            // Scale the image and set it to the jLabel3 component
            Image img2 = icon2.getImage();
            Image imgScale2 = img2.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
            jLabel3.setIcon(scaledIcon2);
        } else {
            System.out.println("Image not found: " + imagePath);
        }

        /**
         * for 2
         */
        String imagePath2 = "2.jpg"; // Relative path to the image file

// Load the image file as a resource from the classpath
        URL imageUrl2 = getClass().getResource(imagePath2);

        if (imageUrl2 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon2 = new ImageIcon(imageUrl2);

            // Scale the image and set it to the jLabel4 component
            Image img2 = icon2.getImage();
            Image imgScale2 = img2.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
            jLabel4.setIcon(scaledIcon2);
        } else {
            System.out.println("Image not found: " + imagePath2);
        }

        /**
         * for 3
         */
        String imagePath3 = "3.png"; // Relative path to the image file

// Load the image file as a resource from the classpath
        URL imageUrl3 = getClass().getResource(imagePath3);

        if (imageUrl3 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon3 = new ImageIcon(imageUrl3);

            // Scale the image and set it to the jLabel5 component
            Image img3 = icon3.getImage();
            Image imgScale3 = img3.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
            jLabel5.setIcon(scaledIcon3);
        } else {
            System.out.println("Image not found: " + imagePath3);
        }

        /**
         * for 4
         */
        String imagePath4 = "4.png"; // Relative path to the image file

// Load the image file as a resource from the classpath
        URL imageUrl4 = getClass().getResource(imagePath4);

        if (imageUrl4 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon4 = new ImageIcon(imageUrl4);

            // Scale the image and set it to the jLabel6 component
            Image img4 = icon4.getImage();
            Image imgScale4 = img4.getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
            jLabel6.setIcon(scaledIcon4);
        } else {
            System.out.println("Image not found: " + imagePath4);
        }

        /**
         * for 5
         */
        String imagePath5 = "5.png"; // Relative path to the image file

// Load the image file as a resource from the classpath
        URL imageUrl5 = getClass().getResource(imagePath5);

        if (imageUrl5 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon5 = new ImageIcon(imageUrl5);

            // Scale the image and set it to the jLabel7 component
            Image img5 = icon5.getImage();
            Image imgScale5 = img5.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
            jLabel7.setIcon(scaledIcon5);
        } else {
            System.out.println("Image not found: " + imagePath5);
        }

        /**
         * for 6
         */
        String imagePath6 = "6.png"; // Relative path to the image file

// Load the image file as a resource from the classpath
        URL imageUrl6 = getClass().getResource(imagePath6);

        if (imageUrl6 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon6 = new ImageIcon(imageUrl6);

            // Scale the image and set it to the jLabel8 component
            Image img6 = icon6.getImage();
            Image imgScale6 = img6.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon6 = new ImageIcon(imgScale6);
            jLabel8.setIcon(scaledIcon6);
        } else {
            System.out.println("Image not found: " + imagePath6);
        }

        /**
         * for exit.png
         */
        String imagePath9 = "exit.png"; // Relative path to the image file

// Load the image file as a resource from the classpath
        URL imageUrl9 = getClass().getResource(imagePath9);

        if (imageUrl9 != null) {
            // Create an ImageIcon using the loaded resource
            ImageIcon icon9 = new ImageIcon(imageUrl9);

            // Scale the image and set it to the jLabel9 component
            Image img9 = icon9.getImage();
            Image imgScale9 = img9.getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon9 = new ImageIcon(imgScale9);
            jLabel9.setIcon(scaledIcon9);
        } else {
            System.out.println("Image not found: " + imagePath9);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 181, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laundrymanagementsystem/AdminDashboardLogo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 610, 610));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 660));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 181, 204));
        jLabel2.setText("Admin Dashboard");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 150, 130));

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 90, 150, 130));

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 150, 140));

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 280, 150, 130));

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 150, 130));

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 470, 150, 130));

        jButton1.setBackground(new java.awt.Color(0, 112, 192));
        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pending Orders");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 112, 192));
        jButton2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Customer");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 230, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 112, 192));
        jButton4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Orders Complete");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, -1, -1));

        jButton5.setBackground(new java.awt.Color(0, 112, 192));
        jButton5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Staff");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 410, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 112, 192));
        jButton3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Order Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 610, -1, -1));

        jButton6.setBackground(new java.awt.Color(0, 112, 192));
        jButton6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Vendors");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 610, -1, -1));

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, 40, 40));

        jButton7.setBackground(new java.awt.Color(255, 0, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 10)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 70, 70, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
        Admin_PendingOrders adm_pend = new Admin_PendingOrders();
        adm_pend.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        Admin_PendingOrders adm_pend = new Admin_PendingOrders();
        adm_pend.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        Admin_OrderDetails adm_OrderDetails = new Admin_OrderDetails();
        adm_OrderDetails.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        // Close the current AdminDashboard instance
        dispose();

        // Show the Login page
        Login log = new Login();
        log.setVisible(true);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        dispose();

        // Show the Login page
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        Admin_CustomerPage adm_cust = new Admin_CustomerPage();

        adm_cust.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
        Admin_CustomerPage adm_cust = new Admin_CustomerPage();

        adm_cust.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

    }//GEN-LAST:event_jButton4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        dispose();
        Admin_OrdersComplete adm_orderscomplete = new Admin_OrdersComplete();

        adm_orderscomplete.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
        Admin_OrdersComplete adm_orderscomplete = new Admin_OrdersComplete();

        adm_orderscomplete.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        Admin_LaundryStaff adm_laundrystaff = new Admin_LaundryStaff();
        adm_laundrystaff.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dispose();
        Admin_LaundryStaff adm_laundrystaff = new Admin_LaundryStaff();
        adm_laundrystaff.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        dispose();
        Admin_OrderDetails adm_OrderDetails = new Admin_OrderDetails();
        adm_OrderDetails.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        dispose();
        Admin_Vendors adm_vend = new Admin_Vendors();
        adm_vend.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dispose();
        Admin_Vendors adm_vend = new Admin_Vendors();
        adm_vend.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
