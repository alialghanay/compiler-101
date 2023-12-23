import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class optionyouwant extends javax.swing.JFrame {
    private File originalcode;
    private File CommentRemovercode;
    private File tokencode;
    private File Symboltablecode;
    
    public optionyouwant() {
         initComponents();
         this.setTitle("Welcom");
         this.setSize(735,450);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setLocationRelativeTo(null);
         this.setVisible(true); 
         this.setResizable(false);
    }
    optionyouwant(String filePath) {
        this();
        String currentPath = System.getProperty("user.dir");
        originalcode = new File(filePath);
        CommentRemovercode = new File( currentPath + "\\CommentRemovercode");
        tokencode = new File(currentPath + "\\tokencode");
        Symboltablecode = new File(currentPath + "\\SymbolTablecode");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Choiceoptionslabel = new javax.swing.JLabel();
        chooseFileButton = new javax.swing.JButton();
        chooseFileButton1 = new javax.swing.JButton();
        chooseFileButton2 = new javax.swing.JButton();
        Choiceoptionslabel1 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        packground1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Choiceoptionslabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Choiceoptionslabel.setForeground(new java.awt.Color(0, 0, 0));
        Choiceoptionslabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Choiceoptionslabel.setText("ما الذي تريد القيام به");
        getContentPane().add(Choiceoptionslabel);
        Choiceoptionslabel.setBounds(250, 120, 220, 60);

        chooseFileButton.setBackground(new java.awt.Color(0, 102, 102));
        chooseFileButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chooseFileButton.setForeground(new java.awt.Color(255, 255, 255));
        chooseFileButton.setText("تحويل الكود الى جدول الرموز");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButtonActionPerformed(evt);
            }
        });
        getContentPane().add(chooseFileButton);
        chooseFileButton.setBounds(20, 280, 210, 40);

        chooseFileButton1.setBackground(new java.awt.Color(0, 102, 102));
        chooseFileButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chooseFileButton1.setForeground(new java.awt.Color(255, 255, 255));
        chooseFileButton1.setText("ازالة التعليقات الموجودة في الكود");
        chooseFileButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(chooseFileButton1);
        chooseFileButton1.setBounds(470, 280, 240, 40);

        chooseFileButton2.setBackground(new java.awt.Color(0, 102, 102));
        chooseFileButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chooseFileButton2.setForeground(new java.awt.Color(255, 255, 255));
        chooseFileButton2.setText("تحويل الكود الى Token");
        chooseFileButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(chooseFileButton2);
        chooseFileButton2.setBounds(260, 280, 180, 40);

        Choiceoptionslabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Choiceoptionslabel1.setForeground(new java.awt.Color(0, 0, 0));
        Choiceoptionslabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Choiceoptionslabel1.setText("مرحبا بك");
        getContentPane().add(Choiceoptionslabel1);
        Choiceoptionslabel1.setBounds(310, 70, 100, 60);

        BackButton.setBackground(new java.awt.Color(51, 51, 255));
        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        BackButton.setForeground(new java.awt.Color(204, 204, 255));
        BackButton.setText("رجوع");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(10, 10, 90, 30);

        packground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/photo_2023-07-01_16-51-21.jpg"))); // NOI18N
        getContentPane().add(packground1);
        packground1.setBounds(0, 0, 720, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButtonActionPerformed
        SymbolTable.SymbolTable();
    }//GEN-LAST:event_chooseFileButtonActionPerformed

    private void chooseFileButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButton1ActionPerformed
        GetRidOfComments.removeCommentsAndSpaces(originalcode, CommentRemovercode);
    }//GEN-LAST:event_chooseFileButton1ActionPerformed

    private void chooseFileButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButton2ActionPerformed
        CodeTokenizer.CodeTokenizer(CommentRemovercode, tokencode);         
    }//GEN-LAST:event_chooseFileButton2ActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(optionyouwant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(optionyouwant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(optionyouwant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(optionyouwant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new optionyouwant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel Choiceoptionslabel;
    private javax.swing.JLabel Choiceoptionslabel1;
    private javax.swing.JButton chooseFileButton;
    private javax.swing.JButton chooseFileButton1;
    private javax.swing.JButton chooseFileButton2;
    private javax.swing.JLabel packground1;
    // End of variables declaration//GEN-END:variables
}
