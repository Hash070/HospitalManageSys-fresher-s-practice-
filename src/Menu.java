import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Jun 15 15:24:51 CST 2021
 */



/**
 * @author a
 */
public class Menu extends JFrame {
    public static void main(String[] args) {
        //debug check point
        Menu m = new Menu();
        m.setDefaultCloseOperation(3);
        m.setVisible(true);
    }
    public Menu() {
        initComponents();
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        //take a note to the picture's size you use ,make it suit to your button's size
    }

    private void exitActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Login l = new Login();
        l.setDefaultCloseOperation(3);
        l.setVisible(true);
    }

    private void personalActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        PersonInfo p=new PersonInfo();
        p.setDefaultCloseOperation(3);
        p.setVisible(true);
    }

    private void usermanageActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        DrManage d= new DrManage();
        d.setDefaultCloseOperation(3);
        d.setVisible(true);
    }

    private void druginfoActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        DrugManage d=new DrugManage();
        d.setDefaultCloseOperation(3);
        d.setVisible(true);
    }

    private void patientActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Patient d=new Patient();
        d.setDefaultCloseOperation(3);
        d.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        druginfo = new JButton();
        patient = new JButton();
        usermanage = new JButton();
        personal = new JButton();
        button5 = new JButton();
        title = new JLabel();
        exit = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- druginfo ----
            druginfo.setText("\u836f\u54c1\u4fe1\u606f\u7ba1\u7406");
            druginfo.addActionListener(e -> druginfoActionPerformed(e));
            panel1.add(druginfo);
            druginfo.setBounds(new Rectangle(new Point(50, 40), druginfo.getPreferredSize()));

            //---- patient ----
            patient.setText("\u60a3\u8005\u4fe1\u606f\u7ba1\u7406");
            patient.addActionListener(e -> patientActionPerformed(e));
            panel1.add(patient);
            patient.setBounds(new Rectangle(new Point(50, 90), patient.getPreferredSize()));

            //---- usermanage ----
            usermanage.setText("\u533b\u751f\u4fe1\u606f\u7ba1\u7406\u6a21\u5757");
            usermanage.addActionListener(e -> usermanageActionPerformed(e));
            panel1.add(usermanage);
            usermanage.setBounds(new Rectangle(new Point(40, 140), usermanage.getPreferredSize()));

            //---- personal ----
            personal.setText("\u4e2a\u4eba\u4fe1\u606f");
            personal.addActionListener(e -> personalActionPerformed(e));
            panel1.add(personal);
            personal.setBounds(new Rectangle(new Point(65, 190), personal.getPreferredSize()));

            //---- button5 ----
            button5.setText("\u5e2e\u52a9");
            panel1.add(button5);
            button5.setBounds(new Rectangle(new Point(70, 240), button5.getPreferredSize()));

            //---- title ----
            title.setText("Menu");
            panel1.add(title);
            title.setBounds(new Rectangle(new Point(90, 15), title.getPreferredSize()));

            //---- exit ----
            exit.setIcon(new ImageIcon(getClass().getResource("/Pictures/back.png")));
            exit.addActionListener(e -> exitActionPerformed(e));
            panel1.add(exit);
            exit.setBounds(75, 370, 65, 65);

            //---- label1 ----
            label1.setText("LogOut");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(85, 440), label1.getPreferredSize()));

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
        panel1.setBounds(0, 0, 220, 505);

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
    private JButton druginfo;
    private JButton patient;
    private JButton usermanage;
    private JButton personal;
    private JButton button5;
    private JLabel title;
    private JButton exit;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
