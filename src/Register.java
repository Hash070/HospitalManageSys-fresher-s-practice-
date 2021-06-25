import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Jun 15 14:12:25 CST 2021
 */



/**
 * @author a
 */
public class Register extends JFrame {
    public Register() {
        initComponents();
    }

    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Login l=new Login();
        l.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        l.setVisible(true);
    }
    private void Reg(String username,String password,double tel,String mail) throws AccountEcho{
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs = null;
        try {
            conn=JdbcUtils.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql = "select * from Account where username=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            if(rs.next()){
                throw new AccountEcho(username);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JdbcUtils.release(conn,pst,rs);
        }
        //check whether the username input is valid
        try {
            conn=JdbcUtils.getConnection();
            String sqlIn = "INSERT INTO `HostipalDB`.`Account`(`username`, `password`, `tel`, `mail`) VALUES (?, ?, ?, ?)";
            pst=conn.prepareStatement(sqlIn);
            pst.setString(1,username);
            pst.setString(2,password);
            pst.setDouble(3,tel);
            pst.setString(4,mail);
            pst.executeUpdate();
            err.setText("Reg Success");
            err.setForeground(Color.green);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    private void confirmActionPerformed(ActionEvent e) {
        // TODO add your code here
        String verifycode = verify.getText();
        if (verifycode.equals("RJGC2002"))
        {
            err.setText("");
            //refresh label err every time
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            try {
                conn = JdbcUtils.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String pa = new String(pw1.getPassword());
            String pb = new String(pw2.getPassword());
            if (pa.equals(pb)) {
                try {
                    Reg(username.getText(), pa, Double.parseDouble(tel.getText()), mail.getText());
                } catch (AccountEcho accountEcho) {
                    accountEcho.printStackTrace();
                    String echo = AccountEcho.getEchoaccount();
                    err.setText("The username " + echo + " have been registered!");
                    err.setForeground(Color.red);
                }
            } else {
                err.setText("The password you have enter is inconsistent");
                err.setForeground(Color.red);
            }
        }else{
            err.setText("VerifyCode wrong,please turn to Admin for help");
            err.setForeground(Color.red);
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        title = new JLabel();
        back = new JButton();
        l1 = new JLabel();
        l2 = new JLabel();
        username = new JTextField();
        l3 = new JLabel();
        confirm = new JButton();
        pw1 = new JPasswordField();
        pw2 = new JPasswordField();
        l4 = new JLabel();
        l5 = new JLabel();
        tel = new JTextField();
        mail = new JTextField();
        label1 = new JLabel();
        err = new JLabel();
        verify = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- title ----
            title.setText("\u6ce8\u518c\u754c\u9762");
            panel1.add(title);
            title.setBounds(new Rectangle(new Point(245, 20), title.getPreferredSize()));

            //---- back ----
            back.setText("\u8fd4\u56de");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

            //---- l1 ----
            l1.setText("\u7528\u6237\u540d");
            panel1.add(l1);
            l1.setBounds(new Rectangle(new Point(110, 80), l1.getPreferredSize()));

            //---- l2 ----
            l2.setText("\u5bc6\u7801");
            panel1.add(l2);
            l2.setBounds(new Rectangle(new Point(110, 125), l2.getPreferredSize()));
            panel1.add(username);
            username.setBounds(240, 75, 165, username.getPreferredSize().height);

            //---- l3 ----
            l3.setText("\u786e\u8ba4\u5bc6\u7801");
            panel1.add(l3);
            l3.setBounds(new Rectangle(new Point(110, 170), l3.getPreferredSize()));

            //---- confirm ----
            confirm.setText("\u786e\u8ba4");
            confirm.addActionListener(e -> confirmActionPerformed(e));
            panel1.add(confirm);
            confirm.setBounds(new Rectangle(new Point(240, 345), confirm.getPreferredSize()));
            panel1.add(pw1);
            pw1.setBounds(240, 120, 165, pw1.getPreferredSize().height);
            panel1.add(pw2);
            pw2.setBounds(240, 165, 165, pw2.getPreferredSize().height);

            //---- l4 ----
            l4.setText("\u7535\u8bdd\u53f7\u7801");
            panel1.add(l4);
            l4.setBounds(new Rectangle(new Point(110, 215), l4.getPreferredSize()));

            //---- l5 ----
            l5.setText("\u90ae\u7bb1");
            panel1.add(l5);
            l5.setBounds(new Rectangle(new Point(110, 260), l5.getPreferredSize()));
            panel1.add(tel);
            tel.setBounds(240, 210, 165, tel.getPreferredSize().height);
            panel1.add(mail);
            mail.setBounds(240, 255, 165, mail.getPreferredSize().height);

            //---- label1 ----
            label1.setText("\u9a8c\u8bc1\u7801");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(110, 305), label1.getPreferredSize()));

            //---- err ----
            err.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(err);
            err.setBounds(145, 390, 255, 35);
            panel1.add(verify);
            verify.setBounds(240, 300, 165, verify.getPreferredSize().height);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 545, 435);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel title;
    private JButton back;
    private JLabel l1;
    private JLabel l2;
    private JTextField username;
    private JLabel l3;
    private JButton confirm;
    private JPasswordField pw1;
    private JPasswordField pw2;
    private JLabel l4;
    private JLabel l5;
    private JTextField tel;
    private JTextField mail;
    private JLabel label1;
    private JLabel err;
    private JTextField verify;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
class AccountEcho extends Exception{
    static String echoaccount;
    public AccountEcho(String ace){
        echoaccount=ace;
    }
    public static String getEchoaccount(){
        return echoaccount;
    }
}