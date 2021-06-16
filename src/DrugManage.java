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

    public DrugManage() {
        initComponents();
    }

    public void initTable() {
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
        info.setVisible(true);
        initTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        title = new JLabel();
        back = new JButton();
        menupanel = new JPanel();
        druginfo = new JButton();
        search = new JButton();
        purchase = new JButton();
        info = new JPanel();
        scrollPane1 = new JScrollPane();
        infotable = new JTable();

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
                search.setText("Search");
                menupanel.add(search);
                search.setBounds(0, 140, 100, search.getPreferredSize().height);

                //---- purchase ----
                purchase.setText("Purchase");
                menupanel.add(purchase);
                purchase.setBounds(0, 220, 100, purchase.getPreferredSize().height);

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
                info.setVisible(false);
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
    private JButton purchase;
    private JPanel info;
    private JScrollPane scrollPane1;
    private JTable infotable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
