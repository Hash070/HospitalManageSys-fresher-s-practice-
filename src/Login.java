import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Jun 15 10:01:30 CST 2021
 */


/**
 * @author a
 */
public class Login extends JFrame {
    public static String user=null;
    public Login() {
        initComponents();
    }
    private static boolean isAccountValid(String username,String password) {
        Connection conn = null;
        PreparedStatement pst=null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from Account where username=? and password=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            rs=pst.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JdbcUtils.release(conn,pst,rs);
        }
        return false;
    }
    private void loginActionPerformed(ActionEvent e) {
        // TODO add your code here
        String password=new String(pw.getPassword());
        if(isAccountValid(username.getText(),password)){
            err.setText("Ok");
            err.setForeground(Color.green);
            user=username.getText();
            this.dispose();
            Menu m = new Menu();
            m.setDefaultCloseOperation(3);
            m.setVisible(true);
        }else{
            err.setText("Wrong username or password");
            err.setForeground(Color.red);
        }
    }

    private void regActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Register reg = new Register();
        reg.setDefaultCloseOperation(3);
        reg.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        reg = new JButton();
        l1 = new JLabel();
        l2 = new JLabel();
        username = new JTextField();
        pw = new JPasswordField();
        login = new JButton();
        title = new JLabel();
        err = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- reg ----
            reg.setText("Register");
            reg.addActionListener(e -> regActionPerformed(e));
            panel1.add(reg);
            reg.setBounds(new Rectangle(new Point(430, 10), reg.getPreferredSize()));

            //---- l1 ----
            l1.setText("UserName");
            panel1.add(l1);
            l1.setBounds(new Rectangle(new Point(105, 115), l1.getPreferredSize()));

            //---- l2 ----
            l2.setText("Password");
            panel1.add(l2);
            l2.setBounds(new Rectangle(new Point(105, 175), l2.getPreferredSize()));
            panel1.add(username);
            username.setBounds(225, 110, 175, 30);
            panel1.add(pw);
            pw.setBounds(225, 165, 175, 30);

            //---- login ----
            login.setText("Login");
            login.addActionListener(e -> loginActionPerformed(e));
            panel1.add(login);
            login.setBounds(new Rectangle(new Point(220, 255), login.getPreferredSize()));

            //---- title ----
            title.setText("Welcome to Hostipal Manage Sys");
            title.setHorizontalTextPosition(SwingConstants.CENTER);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(title);
            title.setBounds(130, 35, 255, 45);

            //---- err ----
            err.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(err);
            err.setBounds(150, 300, 225, 40);

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
        panel1.setBounds(0, 0, 525, 360);

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
    private JButton reg;
    private JLabel l1;
    private JLabel l2;
    private JTextField username;
    private JPasswordField pw;
    private JButton login;
    private JLabel title;
    private JLabel err;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
