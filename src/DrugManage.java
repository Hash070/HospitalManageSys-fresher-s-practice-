import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/*
 * Created by JFormDesigner on Wed Jun 16 10:07:15 CST 2021
 */



/**
 * @author a
 */
public class DrugManage extends JFrame {
//    public Vector v1;
    int currentId=-1;
    public DrugManage() {
        initComponents();
        initTable();
    }

    public void initTable() {
//        infotable.setSelectionMode(0);
        //multiply line selection mode 2
        // interval single selection mode 1
        // single line selection Mode 0
        /*
        * System.out.println(ListSelectionModel.SINGLE_SELECTION);
            System.out.println(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            System.out.println(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            * Result:
            * 0
            * 1
            * 2
         */
        infotable.setEnabled(false);
        //this is the method to set it read-only Remember key word "Enable"
        String[] column = {"药品编号","药品名称","药品价格","仓库位置","药品数量","药品来源"};
        Object[][] rowData = new Object[100][6];
        String[][] temp = new String[100][6];
        Connection conn = null;
        Statement st=null;
        ResultSet rs = null;
        try {
            conn=JdbcUtils.getConnection();
            st=conn.createStatement();
            rs=st.executeQuery("SELECT * FROM `HostipalDB`.`Drug`");
            Vector v1=new Vector();
            Vector v2=new Vector();
            Vector v3=new Vector();
            Vector v4=new Vector();
            Vector v5=new Vector();
            Vector v6=new Vector();
            for (int i=0; rs.next(); i++) {
                v1.add(rs.getString("drugid"));
                v2.add(rs.getString("drugname"));
                v3.add(rs.getString("drugprice"));
                v4.add(rs.getString("quantity"));
                v5.add(rs.getString("location"));
                v6.add(rs.getString("origin"));
            }
            for(int i = 0;i<v1.size();i++){
                temp[i][0] = (String) v1.get(i);
                temp[i][1] = (String) v2.get(i);
                temp[i][2] = (String) v3.get(i);
                temp[i][3] = (String) v4.get(i);
                temp[i][4] = (String) v5.get(i);
                temp[i][5] = (String) v6.get(i);
                rowData=temp;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JdbcUtils.release(conn,st,rs);
        }
        TableModel data=new DefaultTableModel(rowData,column);
        infotable.setModel(data);
    }
    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Menu m = new Menu();
        m.setDefaultCloseOperation(3);
        m.setVisible(true);
    }

    private void druginfoActionPerformed(ActionEvent e) {
        // TODO add your code here
        finder.setVisible(false);
        info.setVisible(true);
        initTable();
    }

    private void searchActionPerformed(ActionEvent e) {
        // TODO add your code here
        result.setText("");
        err.setText("");
        finder.setVisible(true);
        info.setVisible(false);
//        drugid.setText("");
//        drugname.setText("");
//        drugprice.setText("");
//        quantity.setText("");
//        location.setText("");
//        origin.setText("");
//        searchtext.setText("");
    }

    private void doitActionPerformed(ActionEvent e) {
        // TODO add your code here
        result.setText("");
        int id=0;
        try{
            id = Integer.parseInt(searchtext.getText());
        }catch (NumberFormatException expect){
            expect.printStackTrace();
            result.setText("Please Enter Numbers");
            result.setForeground(Color.red);
        }
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=JdbcUtils.getConnection();
            pst=conn.prepareStatement("select * from Drug where drugid=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            if(rs.next()){
                drugid.setText(rs.getString("drugid"));
                currentId= Integer.parseInt(rs.getString("drugid"));
                drugname.setText(rs.getString("drugname"));
                drugprice.setText(rs.getString("drugprice"));
                quantity.setText(rs.getString("quantity"));
                location.setText(rs.getString("location"));
                origin.setText(rs.getString("origin"));
            }else{
                result.setText("Not Found");
                result.setForeground(Color.red);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JdbcUtils.release(conn,pst,rs);
        }
    }

    private void commitActionPerformed(ActionEvent e) {
        // TODO add your code here
        err.setText("");
        Connection conn = null;
        PreparedStatement pst=null;
        PreparedStatement st=null;
        ResultSet rs = null;
        try {
            conn=JdbcUtils.getConnection();
            st=conn.prepareStatement("DELETE FROM `HostipalDB`.`Drug` WHERE `drugid` = ?");
            //if drug id not found , no row will be affected.
            //so there is no errors.
            st.setInt(1,currentId);
            st.executeUpdate();
            pst = conn.prepareStatement("INSERT INTO `HostipalDB`.`Drug`(`drugid`, `drugname`, `drugprice`, `quantity`, `location`, `origin`) VALUES (?,?,?,?,?,?)");
            pst.setInt(1, Integer.parseInt(drugid.getText()));
            pst.setString(2,drugname.getText());
            pst.setDouble(3, Double.parseDouble(drugprice.getText()));
            pst.setInt(4, Integer.parseInt(quantity.getText()));
            pst.setString(5,location.getText());
            pst.setString(6,origin.getText());
            pst.executeUpdate();
            err.setText("Success");
            err.setForeground(Color.green);
            currentId = -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            err.setText("Error");
            err.setForeground(Color.red);
        }catch(NumberFormatException n){
            err.setText("Please Enter Valid Values");
            err.setForeground(Color.red);
        }finally{
            JdbcUtils.release(conn,pst,rs);
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void refreshActionPerformed(ActionEvent e) {
        // TODO add your code here
        drugid.setText("");
        drugname.setText("");
        drugprice.setText("");
        quantity.setText("");
        location.setText("");
        origin.setText("");
        searchtext.setText("");
        err.setText("");
        result.setText("");
        currentId=-1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        title = new JLabel();
        back = new JButton();
        menupanel = new JPanel();
        druginfo = new JButton();
        search = new JButton();
        info = new JPanel();
        scrollPane1 = new JScrollPane();
        infotable = new JTable();
        finder = new JPanel();
        searchtext = new JTextField();
        doit = new JButton();
        drugid = new JTextField();
        drugname = new JTextField();
        drugprice = new JTextField();
        quantity = new JTextField();
        location = new JTextField();
        origin = new JTextField();
        commit = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        err = new JLabel();
        label7 = new JLabel();
        result = new JLabel();
        refresh = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- title ----
            title.setText("Drug Manage");
            panel1.add(title);
            title.setBounds(new Rectangle(new Point(395, 20), title.getPreferredSize()));

            //---- back ----
            back.setText("Back");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

            //======== menupanel ========
            {
                menupanel.setLayout(null);

                //---- druginfo ----
                druginfo.setText("DrugInfo");
                druginfo.addActionListener(e -> druginfoActionPerformed(e));
                menupanel.add(druginfo);
                druginfo.setBounds(0, 60, 100, druginfo.getPreferredSize().height);

                //---- search ----
                search.setText("Purchase");
                search.addActionListener(e -> searchActionPerformed(e));
                menupanel.add(search);
                search.setBounds(0, 140, 100, search.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < menupanel.getComponentCount(); i++) {
                        Rectangle bounds = menupanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = menupanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    menupanel.setMinimumSize(preferredSize);
                    menupanel.setPreferredSize(preferredSize);
                }
            }
            panel1.add(menupanel);
            menupanel.setBounds(0, 70, 100, 455);

            //======== info ========
            {
                info.setLayout(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(infotable);
                }
                info.add(scrollPane1);
                scrollPane1.setBounds(new Rectangle(new Point(150, 25), scrollPane1.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < info.getComponentCount(); i++) {
                        Rectangle bounds = info.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = info.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    info.setMinimumSize(preferredSize);
                    info.setPreferredSize(preferredSize);
                }
            }
            panel1.add(info);
            info.setBounds(100, 50, 765, 515);

            //======== finder ========
            {
                finder.setVisible(false);
                finder.setLayout(null);
                finder.add(searchtext);
                searchtext.setBounds(235, 45, 185, searchtext.getPreferredSize().height);

                //---- doit ----
                doit.setText("Search");
                doit.addActionListener(e -> doitActionPerformed(e));
                finder.add(doit);
                doit.setBounds(new Rectangle(new Point(455, 45), doit.getPreferredSize()));
                finder.add(drugid);
                drugid.setBounds(340, 110, 160, drugid.getPreferredSize().height);
                finder.add(drugname);
                drugname.setBounds(340, 160, 160, drugname.getPreferredSize().height);
                finder.add(drugprice);
                drugprice.setBounds(340, 210, 160, drugprice.getPreferredSize().height);
                finder.add(quantity);
                quantity.setBounds(340, 260, 160, quantity.getPreferredSize().height);
                finder.add(location);
                location.setBounds(340, 310, 160, location.getPreferredSize().height);
                finder.add(origin);
                origin.setBounds(340, 360, 160, origin.getPreferredSize().height);

                //---- commit ----
                commit.setText("Commit");
                commit.addActionListener(e -> commitActionPerformed(e));
                finder.add(commit);
                commit.setBounds(new Rectangle(new Point(255, 410), commit.getPreferredSize()));

                //---- label1 ----
                label1.setText("DrugID");
                finder.add(label1);
                label1.setBounds(new Rectangle(new Point(200, 115), label1.getPreferredSize()));

                //---- label2 ----
                label2.setText("DrugName");
                finder.add(label2);
                label2.setBounds(new Rectangle(new Point(200, 165), label2.getPreferredSize()));

                //---- label3 ----
                label3.setText("Price");
                finder.add(label3);
                label3.setBounds(new Rectangle(new Point(200, 215), label3.getPreferredSize()));

                //---- label4 ----
                label4.setText("Quantity");
                finder.add(label4);
                label4.setBounds(new Rectangle(new Point(200, 265), label4.getPreferredSize()));

                //---- label5 ----
                label5.setText("Location");
                finder.add(label5);
                label5.setBounds(new Rectangle(new Point(200, 315), label5.getPreferredSize()));

                //---- label6 ----
                label6.setText("Origin");
                finder.add(label6);
                label6.setBounds(new Rectangle(new Point(200, 365), label6.getPreferredSize()));

                //---- err ----
                err.setHorizontalAlignment(SwingConstants.CENTER);
                finder.add(err);
                err.setBounds(80, 450, 540, 50);

                //---- label7 ----
                label7.setText("Please Enter Drug ID");
                finder.add(label7);
                label7.setBounds(new Rectangle(new Point(55, 50), label7.getPreferredSize()));

                //---- result ----
                result.setHorizontalAlignment(SwingConstants.CENTER);
                finder.add(result);
                result.setBounds(530, 45, 225, 30);

                //---- refresh ----
                refresh.setText("Refresh");
                refresh.addActionListener(e -> refreshActionPerformed(e));
                finder.add(refresh);
                refresh.setBounds(new Rectangle(new Point(425, 410), refresh.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < finder.getComponentCount(); i++) {
                        Rectangle bounds = finder.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = finder.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    finder.setMinimumSize(preferredSize);
                    finder.setPreferredSize(preferredSize);
                }
            }
            panel1.add(finder);
            finder.setBounds(100, 50, 765, 515);

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
        panel1.setBounds(0, 0, 865, 565);

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
    private JPanel menupanel;
    private JButton druginfo;
    private JButton search;
    private JPanel info;
    private JScrollPane scrollPane1;
    private JTable infotable;
    private JPanel finder;
    private JTextField searchtext;
    private JButton doit;
    private JTextField drugid;
    private JTextField drugname;
    private JTextField drugprice;
    private JTextField quantity;
    private JTextField location;
    private JTextField origin;
    private JButton commit;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel err;
    private JLabel label7;
    private JLabel result;
    private JButton refresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
