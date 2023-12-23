import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {
    private String filePath;
    
 public Home() {
     initComponents();
    this.setTitle("Welcom");
    this.setSize(735,450);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
       this.setVisible(true); 
       this.setResizable(false);
       chooseFileButton.setEnabled(false);
       Folderfield.requestFocus(); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        helpbutton = new javax.swing.JButton();
        Folderfield = new javax.swing.JTextField();
        orignalcodelabel = new javax.swing.JLabel();
        chooseFileButton = new javax.swing.JButton();
        chooseFileButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        packground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        helpbutton.setBackground(new java.awt.Color(0, 102, 102));
        helpbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        helpbutton.setForeground(new java.awt.Color(255, 255, 255));
        helpbutton.setText("ماهو الملف المصدري ؟");
        helpbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(helpbutton);
        helpbutton.setBounds(250, 310, 190, 23);

        Folderfield.setBackground(new java.awt.Color(187, 187, 187));
        Folderfield.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Folderfield.setForeground(new java.awt.Color(0, 0, 0));
        Folderfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FolderfieldActionPerformed(evt);
            }
        });
        Folderfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FolderfieldKeyPressed(evt);
            }
        });
        getContentPane().add(Folderfield);
        Folderfield.setBounds(150, 200, 390, 40);

        orignalcodelabel.setBackground(new java.awt.Color(0, 0, 0));
        orignalcodelabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        orignalcodelabel.setForeground(new java.awt.Color(0, 0, 0));
        orignalcodelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orignalcodelabel.setText(" ادخل الملف المصدري :");
        getContentPane().add(orignalcodelabel);
        orignalcodelabel.setBounds(550, 210, 170, 19);

        chooseFileButton.setBackground(new java.awt.Color(0, 102, 102));
        chooseFileButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chooseFileButton.setForeground(new java.awt.Color(255, 255, 255));
        chooseFileButton.setText("OK");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButtonActionPerformed(evt);
            }
        });
        getContentPane().add(chooseFileButton);
        chooseFileButton.setBounds(290, 250, 110, 40);

        chooseFileButton1.setBackground(new java.awt.Color(0, 102, 102));
        chooseFileButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chooseFileButton1.setForeground(new java.awt.Color(255, 255, 255));
        chooseFileButton1.setText("اختيار الملف");
        chooseFileButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(chooseFileButton1);
        chooseFileButton1.setBounds(30, 200, 110, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("مرحبا بك في برنامجي المتواضع");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 70, 380, 60);

        packground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/photo_2023-07-01_16-51-21.jpg"))); // NOI18N
        getContentPane().add(packground);
        packground.setBounds(0, 0, 720, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpbuttonActionPerformed
      String fullMessage = "الملف المصدري هو الملف الذي يوجد به الكود الذي سيتم العمل عليه";
      JOptionPane.showMessageDialog(null, fullMessage, "المساعدة", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpbuttonActionPerformed

    private void FolderfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FolderfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FolderfieldActionPerformed

    private void FolderfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FolderfieldKeyPressed

    }//GEN-LAST:event_FolderfieldKeyPressed

    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButtonActionPerformed
        new optionyouwant(filePath).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_chooseFileButtonActionPerformed

    private void chooseFileButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButton1ActionPerformed
    
        JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(this);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        if (selectedFile != null) {
            filePath = selectedFile.getAbsolutePath().toString();
            Folderfield.setText(filePath);
            // enable the button and add necessary code
            chooseFileButton.setEnabled(true);
            }
        }    
    }//GEN-LAST:event_chooseFileButton1ActionPerformed
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        }
      );
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Folderfield;
    private javax.swing.JButton chooseFileButton;
    private javax.swing.JButton chooseFileButton1;
    private javax.swing.JButton helpbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel orignalcodelabel;
    private javax.swing.JLabel packground;
    // End of variables declaration//GEN-END:variables
}
