import com.mysql.jdbc.SocketMetadata;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Jun 17 09:02:35 CST 2021
 */



/**
 * @author a
 */
public class Help extends JFrame {
//    String helper="";
    Font font = new Font(".AppleSystemUIFont",Font.PLAIN,12);
    URL url = Help.class.getResource("Helper.html");
    public Help() {
        initComponents();
        System.out.println(url);
        info.setEditable(false);
        info.setFont(font);
        try {
            info.setPage(url);
        } catch (IOException e) {
            e.printStackTrace();
            info.setContentType("text/html");
            info.setText("<html>page not found</html>");
        }
//        info.setText(helper);
    }

    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        Menu m = new Menu();
        m.setVisible(true);
        m.setDefaultCloseOperation(3);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        back = new JButton();
        scrollPane1 = new JScrollPane();
        info = new JEditorPane();

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

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(info);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(40, 40, 715, 450);

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
        panel1.setBounds(0, 0, 790, 525);

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
    private JButton back;
    private JScrollPane scrollPane1;
    private JEditorPane info;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
