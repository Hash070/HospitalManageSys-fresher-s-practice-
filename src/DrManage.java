import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Tue Jun 15 20:21:59 CST 2021
 */



/**
 * @author a
 */
public class DrManage extends JFrame {
    Vector<String> v=null;
    String selecteduser=null;
    int selectedIndex=-1;
    public DrManage() {
        initComponents();
        initJlist();
    }
    public void initJlist(){
        v=new Vector<String>();
        // the elder v info will be cleaned by java
        // make sure the v is always new when init
        selectedIndex=-1;
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql=null;
        try {
            sql = "select * from Account";
            conn = JdbcUtils.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            for (int i=0; rs.next();i++){
                v.add(rs.getString("username"));
            }
            aclist.setListData(v);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            err.setText("Un,some err occurred");
            err.setForeground(Color.red);
        }finally{
            JdbcUtils.release(conn,pst,rs);
        }
    }
    private void refresh(){
        username.setText("");
        password.setText("");
        tel.setText("");
        mail.setText("");
        err.setText("");
        unselectList();
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
    public void unselectList(){
        int[] s=new int[v.size()];
        for(int i=0;i<s.length;i++){
            s[i]=-1;
        }
        aclist.setSelectedIndices(s);
        selecteduser=null;
        selectedIndex=-1;
    }
    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Menu m = new Menu();
        m.setDefaultCloseOperation(3);
        m.setVisible(true);
    }

    private void aclistValueChanged(ListSelectionEvent e) {
        // TODO add your code here
        if(aclist.getValueIsAdjusting()){
            err.setText("");
            Object[] selected = aclist.getSelectedValues();
            selecteduser=selected[0].toString();
            selectedIndex=aclist.getSelectedIndex();
            //experience get :
            //if you directly use Object array "selected" without "[0]"
            //then you will have a bug to fix
            Connection conn = null;
            PreparedStatement pst=null;
            ResultSet rs = null;
            try {
                conn = JdbcUtils.getConnection();
                String sql = "select * from Account where username=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1,selecteduser);
                rs = pst.executeQuery();
                rs.next();
//                System.out.println(rs.getString("username"));
//                System.out.println(selecteduser);//for debug
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
    }

    private void delActionPerformed(ActionEvent e) {
        // TODO add your code here
    Object[] selected = aclist.getSelectedValues();
    selecteduser=selected[0].toString();
    Connection conn = null;
    PreparedStatement pst=null;
    ResultSet rs = null;
    try {
        conn=JdbcUtils.getConnection();
        String sql="DELETE FROM Account WHERE username=?";
        pst=conn.prepareStatement(sql);
        pst.setString(1,selecteduser);
        pst.executeUpdate();
        err.setText("Delete success!");
        err.setForeground(Color.green);
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }finally{
        JdbcUtils.release(conn,pst,rs);
        initJlist();
        refresh();
    }
    }

    private void refreshActionPerformed(ActionEvent e) {
        // TODO add your code here
        refresh();
    }

    private void saveActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(selecteduser!=null){
            Connection conn = null;
            PreparedStatement pst = null;
            try {
                String sql = "update HostipalDB.Account set username=?,password=?,tel=?,mail=? where username =?";
                //the use age of update in sql
                //update [table name] set [column 1]=[value 1],[column 2]=[value 2]...... where....
                conn = JdbcUtils.getConnection();
                pst = conn.prepareStatement(sql);
                pst.setString(1, username.getText());
                pst.setString(2, password.getText());
                pst.setString(3, tel.getText());
                pst.setString(4, mail.getText());
                pst.setString(5, selecteduser);
                pst.executeUpdate();
                if(selecteduser.equals(Login.user)){
                    Login.user=username.getText();
                }
                v.remove(selectedIndex);
                v.add(selectedIndex,username.getText());
                aclist.setListData(v);
                //don't forget to set list data
                //or the list will not get changed
                err.setText("Success");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                err.setForeground(Color.red);
                err.setText("Error");
            } finally {
                JdbcUtils.release(conn, pst, null);
            }
        }else{
            //reg
            try {
                Reg(username.getText(),password.getText(), Double.parseDouble(tel.getText()),mail.getText());
                initJlist();
                selecteduser=username.getText();
                selectedIndex=v.indexOf(username.getText());
            } catch (AccountEcho accountEcho) {
                accountEcho.printStackTrace();
                err.setText(accountEcho.getEchoaccount()+" has already registered!");
                err.setForeground(Color.red);
            }
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        aclist = new JList();
        back = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        username = new JTextField();
        password = new JTextField();
        tel = new JTextField();
        mail = new JTextField();
        save = new JButton();
        refresh = new JButton();
        del = new JButton();
        err = new JLabel();
        notice = new JLabel();
        label6 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u533b\u751f\u7ba1\u7406");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(300, 10), label1.getPreferredSize()));

            //======== scrollPane1 ========
            {

                //---- aclist ----
                aclist.addListSelectionListener(e -> aclistValueChanged(e));
                scrollPane1.setViewportView(aclist);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(45, 60, 155, 320);

            //---- back ----
            back.setText("\u8fd4\u56de");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

            //---- label2 ----
            label2.setText("\u7528\u6237\u540d");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(265, 100), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u5bc6\u7801");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(265, 140), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u7535\u8bdd\u53f7\u7801");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(265, 180), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("\u90ae\u7bb1");
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(265, 220), label5.getPreferredSize()));
            panel1.add(username);
            username.setBounds(360, 95, 160, username.getPreferredSize().height);
            panel1.add(password);
            password.setBounds(360, 135, 160, password.getPreferredSize().height);
            panel1.add(tel);
            tel.setBounds(360, 175, 160, tel.getPreferredSize().height);
            panel1.add(mail);
            mail.setBounds(360, 215, 160, mail.getPreferredSize().height);

            //---- save ----
            save.setText("\u4fdd\u5b58");
            save.addActionListener(e -> saveActionPerformed(e));
            panel1.add(save);
            save.setBounds(new Rectangle(new Point(300, 350), save.getPreferredSize()));

            //---- refresh ----
            refresh.setText("\u5237\u65b0");
            refresh.addActionListener(e -> refreshActionPerformed(e));
            panel1.add(refresh);
            refresh.setBounds(new Rectangle(new Point(420, 350), refresh.getPreferredSize()));

            //---- del ----
            del.setText("\u5220\u9664");
            del.addActionListener(e -> delActionPerformed(e));
            panel1.add(del);
            del.setBounds(new Rectangle(new Point(80, 400), del.getPreferredSize()));

            //---- err ----
            err.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(err);
            err.setBounds(205, 390, 440, 60);

            //---- notice ----
            notice.setText("\u63d0\u793a\uff1a\u82e5\u9700\u6dfb\u52a0\u65b0\u7528\u6237");
            notice.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(notice);
            notice.setBounds(220, 270, 390, 30);

            //---- label6 ----
            label6.setText("\u8bf7\u70b9\u8fdb\u5237\u65b0\u6309\u94ae");
            panel1.add(label6);
            label6.setBounds(new Rectangle(new Point(365, 310), label6.getPreferredSize()));

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
        panel1.setBounds(0, 0, 660, 480);

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
    private JScrollPane scrollPane1;
    private JList aclist;
    private JButton back;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField username;
    private JTextField password;
    private JTextField tel;
    private JTextField mail;
    private JButton save;
    private JButton refresh;
    private JButton del;
    private JLabel err;
    private JLabel notice;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
