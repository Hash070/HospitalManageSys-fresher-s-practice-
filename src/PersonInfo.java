import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Jun 15 19:09:46 CST 2021
 */



/**
 * @author a
 */
public class PersonInfo extends JFrame {
    public PersonInfo() {
        initComponents();
        initInfo();
    }
    public void initInfo() {
        Connection conn = null;
        PreparedStatement pst=null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from Account where username=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,Login.user);
            rs = pst.executeQuery();
            rs.next();
            //don't forget that if you want to get the info in the rs
            //you need to try 'next' method once
            System.out.println(rs.getString("username"));
            username.setText(rs.getString("username"));
            password.setText(rs.getString("password"));
            tel.setText(rs.getString("tel"));
            mail.setText(rs.getString("mail"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            err.setText("Un,Some error occurred,Please try to login again");
            err.setForeground(Color.red);
        }finally{
            JdbcUtils.release(conn,pst,rs);
        }
    }

    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Menu m = new Menu();
        m.setVisible(true);
        m.setDefaultCloseOperation(3);
    }

    private void saveActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection conn = null;
        PreparedStatement del = null;
        PreparedStatement pst=null;
        ResultSet rs = null;
        try {
            conn=JdbcUtils.getConnection();
            del = conn.prepareStatement("DELETE FROM `HostipalDB`.`Account` WHERE `username` = ?");
            del.setString(1,Login.user);
            del.executeUpdate();
            del.close();
            String sql ="insert into HostipalDB.Account (username, password, tel, mail) " +
                    "VALUES (?, ?, ?, ?);";
            pst = conn.prepareStatement(sql);
            pst.setString(1,username.getText());
            pst.setString(2,password.getText());
            pst.setString(3,tel.getText());
            pst.setString(4,mail.getText());
            pst.executeUpdate();
            err.setText("Success");
            Login.user=username.getText();
            err.setForeground(Color.green);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            err.setForeground(Color.red);
            err.setText("Error");
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        back = new JButton();
        save = new JButton();
        err = new JLabel();
        username = new JTextField();
        password = new JTextField();
        tel = new JTextField();
        mail = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u4e2a\u4eba\u4fe1\u606f");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(290, 20), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("\u7528\u6237\u540d");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(140, 80), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u5bc6\u7801");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(140, 120), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u7535\u8bdd\u53f7\u7801");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(140, 160), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("\u90ae\u7bb1");
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(140, 200), label5.getPreferredSize()));

            //---- back ----
            back.setText("\u8fd4\u56de");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

            //---- save ----
            save.setText("\u4fdd\u5b58");
            save.addActionListener(e -> saveActionPerformed(e));
            panel1.add(save);
            save.setBounds(new Rectangle(new Point(280, 300), save.getPreferredSize()));

            //---- err ----
            err.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(err);
            err.setBounds(90, 345, 460, 45);
            panel1.add(username);
            username.setBounds(260, 75, 200, username.getPreferredSize().height);
            panel1.add(password);
            password.setBounds(260, 115, 200, password.getPreferredSize().height);
            panel1.add(tel);
            tel.setBounds(260, 155, 200, tel.getPreferredSize().height);
            panel1.add(mail);
            mail.setBounds(260, 200, 200, mail.getPreferredSize().height);

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
        panel1.setBounds(0, 0, 640, 400);

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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton back;
    private JButton save;
    private JLabel err;
    private JTextField username;
    private JTextField password;
    private JTextField tel;
    private JTextField mail;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
