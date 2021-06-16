import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/*
 * Created by JFormDesigner on Wed Jun 16 21:26:29 CST 2021
 */



/**
 * @author a
 */
public class Patient extends JFrame {
    public Patient() {
        initComponents();

    }
    public void initTable() {
        infotable.setEnabled(false);
        //this is the method to set it read-only Remember key word "Enable"
        String[] column = {"病人编号","姓名","性别","疾病"};
        Object[][] rowData = new Object[100][4];
        String[][] temp = new String[100][4];
        Connection conn = null;
        Statement st=null;
        ResultSet rs = null;
        try {
            conn=JdbcUtils.getConnection();
            st=conn.createStatement();
            rs=st.executeQuery("SELECT * FROM `HostipalDB`.`Patient`");
            Vector v1=new Vector();
            Vector v2=new Vector();
            Vector v3=new Vector();
            Vector v4=new Vector();
            for (int i=0; rs.next(); i++) {
                v1.add(rs.getString("id"));
                v2.add(rs.getString("name"));
                v3.add(rs.getString("gender"));
                v4.add(rs.getString("disease"));
            }
            for(int i = 0;i<v1.size();i++){
                temp[i][0] = (String) v1.get(i);
                temp[i][1] = (String) v2.get(i);
                temp[i][2] = (String) v3.get(i);
                temp[i][3] = (String) v4.get(i);
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
        m.setVisible(true);
        m.setDefaultCloseOperation(3);
    }

    private void infoActionPerformed(ActionEvent e) {
        // TODO add your code here
        p1.setVisible(true);
        p2.setVisible(false);
        initTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        back = new JButton();
        info = new JButton();
        manage = new JButton();
        p1 = new JPanel();
        scrollPane2 = new JScrollPane();
        infotable = new JTable();
        label1 = new JLabel();
        p2 = new JPanel();
        search = new JButton();
        label2 = new JLabel();
        idInput = new JTextField();
        err = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        list1 = new JList();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- back ----
            back.setText("Back");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

            //---- info ----
            info.setText("PatientInfo");
            info.addActionListener(e -> infoActionPerformed(e));
            panel1.add(info);
            info.setBounds(5, 145, 100, info.getPreferredSize().height);

            //---- manage ----
            manage.setText("InfoManage");
            panel1.add(manage);
            manage.setBounds(5, 260, 100, manage.getPreferredSize().height);

            //======== p1 ========
            {
                p1.setVisible(false);
                p1.setLayout(null);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(infotable);
                }
                p1.add(scrollPane2);
                scrollPane2.setBounds(55, 20, 550, 430);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < p1.getComponentCount(); i++) {
                        Rectangle bounds = p1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = p1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    p1.setMinimumSize(preferredSize);
                    p1.setPreferredSize(preferredSize);
                }
            }
            panel1.add(p1);
            p1.setBounds(110, 50, 675, 480);

            //---- label1 ----
            label1.setText("Patient Manage");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(345, 15), label1.getPreferredSize()));

            //======== p2 ========
            {
                p2.setLayout(null);

                //---- search ----
                search.setText("Search");
                p2.add(search);
                search.setBounds(new Rectangle(new Point(420, 45), search.getPreferredSize()));

                //---- label2 ----
                label2.setText("Enter Patient ID");
                p2.add(label2);
                label2.setBounds(new Rectangle(new Point(45, 55), label2.getPreferredSize()));
                p2.add(idInput);
                idInput.setBounds(190, 45, 190, idInput.getPreferredSize().height);

                //---- err ----
                err.setHorizontalAlignment(SwingConstants.CENTER);
                p2.add(err);
                err.setBounds(510, 45, 120, 30);

                //---- label3 ----
                label3.setText("ID");
                p2.add(label3);
                label3.setBounds(new Rectangle(new Point(145, 100), label3.getPreferredSize()));

                //---- label4 ----
                label4.setText("Name");
                p2.add(label4);
                label4.setBounds(new Rectangle(new Point(145, 145), label4.getPreferredSize()));

                //---- label5 ----
                label5.setText("Gender");
                p2.add(label5);
                label5.setBounds(new Rectangle(new Point(140, 185), label5.getPreferredSize()));

                //---- label6 ----
                label6.setText("Disease");
                p2.add(label6);
                label6.setBounds(new Rectangle(new Point(140, 235), label6.getPreferredSize()));
                p2.add(textField1);
                textField1.setBounds(250, 95, 220, textField1.getPreferredSize().height);
                p2.add(textField2);
                textField2.setBounds(new Rectangle(new Point(250, 140), textField2.getPreferredSize()));
                p2.add(textField3);
                textField3.setBounds(new Rectangle(new Point(310, 190), textField3.getPreferredSize()));
                p2.add(textField4);
                textField4.setBounds(new Rectangle(new Point(340, 240), textField4.getPreferredSize()));

                //---- button1 ----
                button1.setText("text");
                p2.add(button1);
                button1.setBounds(new Rectangle(new Point(245, 355), button1.getPreferredSize()));

                //---- button2 ----
                button2.setText("text");
                p2.add(button2);
                button2.setBounds(new Rectangle(new Point(380, 360), button2.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < p2.getComponentCount(); i++) {
                        Rectangle bounds = p2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = p2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    p2.setMinimumSize(preferredSize);
                    p2.setPreferredSize(preferredSize);
                }
            }
            panel1.add(p2);
            p2.setBounds(110, 50, 675, 475);

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
        panel1.setBounds(0, 0, 785, 530);

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

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton back;
    private JButton info;
    private JButton manage;
    private JPanel p1;
    private JScrollPane scrollPane2;
    private JTable infotable;
    private JLabel label1;
    private JPanel p2;
    private JButton search;
    private JLabel label2;
    private JTextField idInput;
    private JLabel err;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
