/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class withdraw extends javax.swing.JFrame {

    /**
     * Creates new form withdraw
     */
    String s,p,d;
    public static int getno(){
       int tid=0;
         tid=tid++;
        return tid;
    }
    public withdraw(String s1,String p1,String d1) {
        initComponents();
        getConnection();
        s=s1;
        p=p1;
        d=d1;
    }

    private withdraw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Connection getConnection(){
     String URL="jdbc:oracle:thin:@localhost:1521:XE";
     Connection con=null;
     String user="sample";
     String pass="sample";    
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con=DriverManager.getConnection(URL,user,pass);
            return con;
     }
     catch(Exception se){
         System.out.println(se);
         return null;
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

        jLabel1 = new javax.swing.JLabel();
        withamt = new javax.swing.JTextField();
        withbut = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        error = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ENTER THE AMOUNT FOR WITHDRAWAL");

        withamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                withamtKeyReleased(evt);
            }
        });

        withbut.setText("withdraw");
        withbut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                withbutMouseClicked(evt);
            }
        });

        jButton2.setText("BACK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        error.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                errorKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(withbut)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(withamt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(116, 116, 116))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(error)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(withamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(withbut)
                    .addComponent(jButton2))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void withbutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withbutMouseClicked
                 String cid[]=new String[20];
                 String id[]=new String[20];
                 String pass[]=new String[20];
                 String SYSDATE="18/1/2018";
                 
       int e1=0;
        Connection con = getConnection();
        //String user="sample";
        //String pass="sample";    
        try{
            Statement st=con.createStatement();
            ResultSet m=st.executeQuery("SELECT * FROM account2 ");
            //System.out.println(m);
            int i=0;
            while(m.next())
            {  
                cid[i]=m.getString(1).toString();
                pass[i]=m.getString(3).toString();
                id[i]=m.getString(4).toString();
                i++;
            }
            
            //username=accnumtext.getText().toString();
            //passwd=pintext.getText().toString();
            String amt=withamt.getText().toString();
            //int tid=7;
            System.out.println(s);
            for(int j=0;j<cid.length;j++){
                if(s.equals(cid[j])&&p.equals(pass[j])&&d.equals(id[j])){ 
                   //System.out.println(s);
                   int l=st.executeUpdate("insert into transaction values("+getno()+",'WITHDRAW','"+SYSDATE+"',"+amt+",'"+d+"',"+s+")");
                  Thank t=new Thank();
                  t.setVisible(true);
                  this.dispose();
                   e1=1;
// TODO add your handling code here:
    }//GEN-LAST:event_withbutMouseClicked
            
            }
            
            if(e1==0){
                JOptionPane.showMessageDialog(null,"Account number or PIN is incorrect");
            
        }
        }
        catch(Exception se){
         System.out.println(se);
         }
    }
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
                Login l=new Login();
                l.setVisible(true);
                 this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void errorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_errorKeyReleased
          // r handling code here:
    }//GEN-LAST:event_errorKeyReleased

    private void withamtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_withamtKeyReleased
            String PATTERN="^[0-9]{1,9}$";
        Pattern patt=Pattern.compile(PATTERN);
        Matcher match=patt.matcher(withamt.getText());
        if(!match.matches()){
            error.setText("TYPE IT IN NUMBER");
        }
        else{
            error.setText(null);
        }        // TODO add you// TODO add your handling code here:
    }//GEN-LAST:event_withamtKeyReleased

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
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new withdraw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField error;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField withamt;
    private javax.swing.JButton withbut;
    // End of variables declaration//GEN-END:variables
}
