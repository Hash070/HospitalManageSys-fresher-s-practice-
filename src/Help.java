import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Jun 17 09:02:35 CST 2021
 */



/**
 * @author a
 */
public class Help extends JFrame {
    String helper="## Jlist 学习\n" +
            "\n" +
            "### Java Vector 类\n" +
            "\n" +
            "Vector 类实现了一个动态数组。和 ArrayList 很相似，但是两者是不同的：\n" +
            "\n" +
            "- Vector 是同步访问的。\n" +
            "- Vector 包含了许多传统的方法，这些方法不属于集合框架。\n" +
            "\n" +
            "Vector 主要用在事先不知道数组的大小，或者只是需要一个可以改变大小的数组的情况。\n" +
            "\n" +
            "Vector 类支持 4 种构造方法。\n" +
            "\n" +
            "第一种构造方法创建一个默认的向量，默认大小为 10：\n" +
            "\n" +
            "```\n" +
            "Vector()\n" +
            "```\n" +
            "\n" +
            "第二种构造方法创建指定大小的向量。\n" +
            "\n" +
            "```\n" +
            "Vector(int size)\n" +
            "```\n" +
            "\n" +
            "第三种构造方法创建指定大小的向量，并且增量用 incr 指定。增量表示向量每次增加的元素数目。\n" +
            "\n" +
            "```\n" +
            "Vector(int size,int incr)\n" +
            "```\n" +
            "\n" +
            "第四种构造方法创建一个包含集合 c 元素的向量：\n" +
            "\n" +
            "```\n" +
            "Vector(Collection c)\n" +
            "```\n" +
            "\n" +
            "除了从父类继承的方法外 Vector 还定义了以下方法：\n" +
            "\n" +
            "| 序号 | 方法描述                                                     |\n" +
            "| :--- | :----------------------------------------------------------- |\n" +
            "| 1    | void add(int index, Object element)   在此向量的指定位置插入指定的元素。 |\n" +
            "| 2    | boolean add(Object o)   将指定元素添加到此向量的末尾。       |\n" +
            "| 3    | boolean addAll(Collection c)  将指定 Collection 中的所有元素添加到此向量的末尾，按照指定 collection 的迭代器所返回的顺序添加这些元素。 |\n" +
            "| 4    | boolean addAll(int index, Collection c)  在指定位置将指定 Collection 中的所有元素插入到此向量中。 |\n" +
            "| 5    | void addElement(Object obj)   将指定的组件添加到此向量的末尾，将其大小增加 1。 |\n" +
            "| 6    | int capacity()  返回此向量的当前容量。                       |\n" +
            "| 7    | void clear()  从此向量中移除所有元素。                       |\n" +
            "| 8    | Object clone()  返回向量的一个副本。                         |\n" +
            "| 9    | boolean contains(Object elem)  如果此向量包含指定的元素，则返回 true。 |\n" +
            "| 10   | boolean containsAll(Collection c)  如果此向量包含指定 Collection 中的所有元素，则返回 true。 |\n" +
            "| 11   | void copyInto(Object[] anArray)   将此向量的组件复制到指定的数组中。 |\n" +
            "| 12   | Object elementAt(int index)  返回指定索引处的组件。          |\n" +
            "| 13   | Enumeration elements()  返回此向量的组件的枚举。             |\n" +
            "| 14   | void ensureCapacity(int minCapacity)  增加此向量的容量（如有必要），以确保其至少能够保存最小容量参数指定的组件数。 |\n" +
            "| 15   | boolean equals(Object o)  比较指定对象与此向量的相等性。     |\n" +
            "| 16   | Object firstElement()  返回此向量的第一个组件（位于索引 0) 处的项）。 |\n" +
            "| 17   | Object get(int index)  返回向量中指定位置的元素。            |\n" +
            "| 18   | int hashCode()  返回此向量的哈希码值。                       |\n" +
            "| 19   | int indexOf(Object elem)   返回此向量中第一次出现的指定元素的索引，如果此向量不包含该元素，则返回 -1。 |\n" +
            "| 20   | int indexOf(Object elem, int index)   返回此向量中第一次出现的指定元素的索引，从 index 处正向搜索，如果未找到该元素，则返回 -1。 |\n" +
            "| 21   | void insertElementAt(Object obj, int index)  将指定对象作为此向量中的组件插入到指定的 index 处。 |\n" +
            "| 22   | boolean isEmpty()  测试此向量是否不包含组件。                |\n" +
            "| 23   | Object lastElement()  返回此向量的最后一个组件。             |\n" +
            "| 24   | int lastIndexOf(Object elem)   返回此向量中最后一次出现的指定元素的索引；如果此向量不包含该元素，则返回 -1。 |\n" +
            "| 25   | int lastIndexOf(Object elem, int index)  返回此向量中最后一次出现的指定元素的索引，从 index 处逆向搜索，如果未找到该元素，则返回 -1。 |\n" +
            "| 26   | Object remove(int index)   移除此向量中指定位置的元素。      |\n" +
            "| 27   | boolean remove(Object o)  移除此向量中指定元素的第一个匹配项，如果向量不包含该元素，则元素保持不变。 |\n" +
            "| 28   | boolean removeAll(Collection c)  从此向量中移除包含在指定 Collection 中的所有元素。 |\n" +
            "| 29   | void removeAllElements()  从此向量中移除全部组件，并将其大小设置为零。 |\n" +
            "| 30   | boolean removeElement(Object obj)  从此向量中移除变量的第一个（索引最小的）匹配项。 |\n" +
            "| 31   | void removeElementAt(int index)  删除指定索引处的组件。      |\n" +
            "| 32   | protected void removeRange(int fromIndex, int toIndex) 从此 List 中移除其索引位于 fromIndex（包括）与 toIndex（不包括）之间的所有元素。 |\n" +
            "| 33   | boolean retainAll(Collection c)  在此向量中仅保留包含在指定 Collection 中的元素。 |\n" +
            "| 34   | Object set(int index, Object element)  用指定的元素替换此向量中指定位置处的元素。 |\n" +
            "| 35   | void setElementAt(Object obj, int index)  将此向量指定 index 处的组件设置为指定的对象。 |\n" +
            "| 36   | void setSize(int newSize)   设置此向量的大小。               |\n" +
            "| 37   | int size()   返回此向量中的组件数。                          |\n" +
            "| 38   | List subList(int fromIndex, int toIndex)  返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。 |\n" +
            "| 39   | Object[] toArray()  返回一个数组，包含此向量中以恰当顺序存放的所有元素。 |\n" +
            "| 40   | Object[] toArray(Object[] a)  返回一个数组，包含此向量中以恰当顺序存放的所有元素；返回数组的运行时类型为指定数组的类型。 |\n" +
            "| 41   | String toString()  返回此向量的字符串表示形式，其中包含每个元素的 String 表示形式。 |\n" +
            "| 42   | void trimToSize()   对此向量的容量进行微调，使其等于向量的当前大小。 |\n" +
            "\n" +
            "### 实例\n" +
            "\n" +
            "下面的程序说明这个集合所支持的几种方法：\n" +
            "\n" +
            "```\n" +
            "import java.util.*;\n" +
            "\n" +
            "public class VectorDemo {\n" +
            "\n" +
            "   public static void main(String args[]) {\n" +
            "      // initial size is 3, increment is 2\n" +
            "      Vector v = new Vector(3, 2);\n" +
            "      System.out.println(\"Initial size: \" + v.size());\n" +
            "      System.out.println(\"Initial capacity: \" +\n" +
            "      v.capacity());\n" +
            "      v.addElement(new Integer(1));\n" +
            "      v.addElement(new Integer(2));\n" +
            "      v.addElement(new Integer(3));\n" +
            "      v.addElement(new Integer(4));\n" +
            "      System.out.println(\"Capacity after four additions: \" +\n" +
            "          v.capacity());\n" +
            "\n" +
            "      v.addElement(new Double(5.45));\n" +
            "      System.out.println(\"Current capacity: \" +\n" +
            "      v.capacity());\n" +
            "      v.addElement(new Double(6.08));\n" +
            "      v.addElement(new Integer(7));\n" +
            "      System.out.println(\"Current capacity: \" +\n" +
            "      v.capacity());\n" +
            "      v.addElement(new Float(9.4));\n" +
            "      v.addElement(new Integer(10));\n" +
            "      System.out.println(\"Current capacity: \" +\n" +
            "      v.capacity());\n" +
            "      v.addElement(new Integer(11));\n" +
            "      v.addElement(new Integer(12));\n" +
            "      System.out.println(\"First element: \" +\n" +
            "         (Integer)v.firstElement());\n" +
            "      System.out.println(\"Last element: \" +\n" +
            "         (Integer)v.lastElement());\n" +
            "      if(v.contains(new Integer(3)))\n" +
            "         System.out.println(\"Vector contains 3.\");\n" +
            "      // enumerate the elements in the vector.\n" +
            "      Enumeration vEnum = v.elements();\n" +
            "      System.out.println(\"\\nElements in vector:\");\n" +
            "      while(vEnum.hasMoreElements())\n" +
            "         System.out.print(vEnum.nextElement() + \" \");\n" +
            "      System.out.println();\n" +
            "   }\n" +
            "}\n" +
            "```\n" +
            "\n" +
            "以上实例编译运行结果如下：\n" +
            "\n" +
            "```\n" +
            "Initial size: 0\n" +
            "Initial capacity: 3\n" +
            "Capacity after four additions: 5\n" +
            "Current capacity: 5\n" +
            "Current capacity: 7\n" +
            "Current capacity: 9\n" +
            "First element: 1\n" +
            "Last element: 12\n" +
            "Vector contains 3.\n" +
            "\n" +
            "Elements in vector:\n" +
            "1 2 3 4 5.45 6.08 7 9.4 10 11 12\n" +
            "```\n" +
            "\n" +
            "> what I learnt form this\n" +
            ">\n" +
            "> Vector和Arryalist相似，用法相似，这样就差不多了。\n" +
            "\n" +
            "> 然后在Jlist对象创建时，将调好的Vector对象放进去就行了。\n" +
            "\n" +
            "### Jlist内容刷新的方法\n" +
            "\n" +
            "* 首先对相应的按钮加上监听，然后再使用Jlist中的setListData方法，传入更新过的Vector内容即可\n" +
            "\n" +
            "用户管理实现方法：\n" +
            "\n" +
            "1. 在初始化时，利用sql查询语句来查询所有的用户名，将查询到的结果集放到vector对象中，然后在利用vector对象来建立一个Jlist对象，实现了初次进入用户管理界面的程序运行逻辑\n" +
            "2. 选中某一个用户之后，就可以通过sql查询，在下面的区域现实出相应的用户数据，有保存按钮，可以实现用户数据的修改和保存。\n" +
            "3. 保存之后可以接到刷新方法上去。\n" +
            "4. 刷新方法就是通过再次查询sql数据库，然后将查询到的结果集覆盖到vector对象中，然后再通过Jlist中的setListData方法重新调整jlist中的内容。\n" +
            "5. Vector对象覆盖方法：可以使用Vector对象中的clear方法，将对象中所存储的信息清楚，便于重新读起内容。\n" +
            "\n" +
            "### JTextField\n" +
            "\n" +
            "```java\n" +
            "//      jText=new JTextField();\n" +
            "//      jText.setText(\"jfkdlsajfjdsafkdjsakjfldkjsakfjdklsajf\");\n" +
            "//      jText.setBounds(600,300,100,100);\n" +
            "//      jText.setAutoscrolls(true);\n" +
            "//      jText.setEditable(false);\n" +
            "        //学习了JTextField的使用方法。\n" +
            "        /*总结，\n" +
            "        JTF只能显示单行，而JTA可以显示多行\n" +
            "        JTS要设置文字可以使用setText，大多数的控件内的文字都是这样的。\n" +
            "        JTS还可以设置只读，用setEditable方法来设置。\n" +
            "```\n" +
            "\n" +
            "### JScrollPane\n" +
            "\n" +
            "* jsp创建时，应当把相应的组件直接当参数放进去\n" +
            "\n" +
            "  例如：\n" +
            "\n" +
            "  ```java\n" +
            "  JScrollPane jsp=new JScrollPane(jlist);//其中jlist时一个jlist对象。\n" +
            "  ```\n" +
            "\n" +
            "* 这样就可将jlist加上滚动条\n" +
            "\n" +
            "* jsp对象可以用setBounds设置位置和大小\n" +
            "\n" +
            "* jsp对象可以像如下这样设置竖直方向上和水平方向上是否有scrollbar\n" +
            "\n" +
            "* ```java\n" +
            "      jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);    //设置竖直方向上的滚动条一直出现    jscrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);\n" +
            "  ```\n" +
            "\n" +
            "### JOptionPane\n" +
            "\n" +
            "> 这个好像是一个很有意思的工具类，能很方便的弹出窗口并执行一个小功能。\n" +
            "\n" +
            "Example:\n" +
            "\n" +
            "```java\n" +
            "        String inputStr=JOptionPane.showInputDialog(\"请输入要添加的内容\");\n" +
            "```\n" +
            "\n" +
            "这句话执行之后会出现一个对话框来引导输入内容，然后将输入的内容赋值到左边。\n" +
            "\n" +
            "#### jlist添加内容\n" +
            "\n" +
            "利用上面的JOP来方便地请求用户输入相应的内容，然后将东西放到Vector对象内，再set一下jlist的data就行了。\n" +
            "\n" +
            "#### jlist删除选中内容\n" +
            "\n" +
            "> 可以使用jlist中的方法：getSelectedValues方法来获得一个对象数组，然后利用该对象数组和Vector对象中的remove方法来循环移除相应的东西，然后再重新setListData就行了。\n" +
            "\n" +
            "```java\n" +
            "if(jlist.getSelectedValues().lengeth>0){  Object[] ojbArr = jlist.getSelectedValues();  for(int i=0;i<objArr.length;i++){    v.remove(objArr[i]);  }  jlist.setListData(v);}\n" +
            "```\n" +
            "\n" +
            "通过这样的操作之后就可以实现删除Jlist中内容的功能了。\n" +
            "\n" +
            "总结：\n" +
            "\n" +
            "* 检查要删除的内容是否不为空\n" +
            "* 利用getSelectedValues方法将选中的元素放到Object数组中\n" +
            "* 利用for循环，一个一个删除Vector对象中相应的内容。\n" +
            "* 利用setListData方法重新设置相应Jlist中的内容\n" +
            "\n" +
            "我自己的练习结果：\n" +
            "\n" +
            "```java\n" +
            "    public void delThings(ActionEvent e){        if(jl.getSelectedValues().length>0){            Object[] objArr=jl.getSelectedValues();            for(int i = 0; objArr.length>i;i++){                v.remove(objArr[i]);            }            jl.setListData(v);        }else JOptionPane.showMessageDialog(null,\"没有选中内容\");    }\n" +
            "```\n" +
            "\n" +
            "#### jlist修改内容\n" +
            "\n" +
            "整体思路：\n" +
            "\n" +
            "* 首先创建一个按钮，添加监听\n" +
            "* 同样利用Object数组来通过getSelectedValues获取Jlist中的数据，这里要加上条件判断，以确保只修改一个值。\n" +
            "* 接收getSelectedValues必须使用Object数组来进行接收，不然会出错，不知道为什么，即使是要接受的值只有一个。\n" +
            "* 同理，利用JOP来创建一个弹窗来接收数据，将原数据删掉，然后再在Vector末尾添加，再重新设置JL的data即可。\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "```java\n" +
            "    public void changeThings(ActionEvent e){        if(jl.getSelectedValues().length==1){            Object[] objArr=jl.getSelectedValues();//这里必须使用数组吗？？            //这里只能使用对象数组来进行接收，不然会出现问题。            v.remove(objArr[0]);            String inputStr = JOptionPane.showInputDialog(\"请输入要修改的内容\",objArr[0]);            v.add(inputStr);            jl.setListData(v);        }else{            JOptionPane.showMessageDialog(null,\"只能选中一行数据来进行修改\");        }    }\n" +
            "```\n" +
            "\n" +
            "> 这个方法还可以改良：修改的话应该是将原位置的数据清空，然后将新数据放到原位置，而这个方法却将其放到了末尾，有点不合理\n" +
            "\n" +
            "java中Vector类的add还可以指定下标插入。\n" +
            "\n" +
            "```java\n" +
            "void add(int index, Object element) \n" +
            "```\n" +
            "\n" +
            "所以只要获取要修改的数据的下标，然后再指定下标插入就行了。\n" +
            "\n" +
            "获取Jlist所选中的下标的方法为getSelectedIndex，注意该方法只返回一个数字，是下标最小的那个数字，而不是数组。\n" +
            "\n" +
            "还有一个问题就是remove动作在对话框弹出之前就被删除了，非常的不自然。\n" +
            "\n" +
            "所以应当放在对话框执行之后\n" +
            "\n" +
            "下面就是改进后的方法\n" +
            "\n" +
            "```java\n" +
            "    public void changeThings(ActionEvent e){        if(jl.getSelectedValues().length==1){            int indexS=jl.getSelectedIndex();            Object[] objArr=jl.getSelectedValues();//这里必须使用数组吗？？            //这里只能使用对象数组来进行接收，不然会出现问题。            String inputStr = JOptionPane.showInputDialog(\"请输入要修改的内容\",objArr[0]);            v.remove(objArr[0]);            v.add(indexS,inputStr);            jl.setListData(v);        }else{            JOptionPane.showMessageDialog(null,\"只能选中一行数据来进行修改\");        }    }\n" +
            "```\n" +
            "\n" +
            "#### JList全选/全不选/反选\n" +
            "\n" +
            "**首先要了解一些Jlist选中模式**\n" +
            "\n" +
            "**JList一共有三种选中模式**\n" +
            "\n" +
            "```bash\n" +
            "MULTIPLE_INTERVAL_SELECTION=2可以选择不相邻的几项SINGLE_INTERVAL_SELECTION=1只能选择连续的几项SINGLE_SELECTION=0一次只能选择一项\n" +
            "```\n" +
            "\n" +
            "JList默认是第一种选择模式，就是限制最小的那种\n" +
            "\n" +
            "JList设置选择模式的方法为setSelectionMode(ListSelectionModel.[选中模式名称（就是上面的那三种）]/直接填入一个0-2的整数分别代表以上方法)\n" +
            "\n" +
            "**全选思路：**\n" +
            "\n" +
            "```java\n" +
            "            public void actionPerformed(ActionEvent e) {                jlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);                int[] allSelect = new int[v.size()];//获取JList的行数//即获取Vector对象所存储字符串的数目。                //获得Vector对象中的行数之后再创建一个这么长的整形数组                for (int i = 0; i < v.size(); i++) {                    allSelect[i] = i;//初始化这个数组，使这个数组中的元素包含所有想要选中的下标                }                jlist.setSelectedIndices(allSelect);//将一个存储着待选中行号整型数组当作参数放到JList中的setSelectedIndices方法中去,即可实现选中功能            }\n" +
            "```\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "1. 首先初始化Jlist的选中模式，将选中模式调整为符合功能需求的模式，由于该方法是全选，所以要选择MULTIPLY_INTERVAL_SELECTION模式。\n" +
            "2. 然后创建一个整型数组，数组的长度为Vector的长度（为什么要设置一个这么长的数组？因为JList选中方法setSelectedIndices需要一个整型数组，该方法会将每个元素内对应的行标记为选中状态）\n" +
            "3. 将所有的行标填入整形数组中\n" +
            "4. 利用setSelectedIndices方法选中所有行\n" +
            "\n" +
            "**全不选思路：**\n" +
            "\n" +
            "1. 初始化jlist选中模式\n" +
            "2. 创建一个jlist长度的整形数组，然后将这些数组全部赋值为-1\n" +
            "3. 将该数组放到setSelectedIndices方法中，即可实现全不选功能\n" +
            "\n" +
            "```java\n" +
            "    public void nsAll(ActionEvent e){        jl.setSelectionMode(2);        int[] s=new int[v.size()];        for(int i=0;i<s.length;i++){            s[i]=-1;        }        jl.setSelectedIndices(s);    }\n" +
            "```\n" +
            "\n" +
            "**反选思路**\n" +
            "\n" +
            "```java\n" +
            "    public void reverseSelectButton(ActionEvent e){        int[] all=new int[v.size()];        for(int i=0;i<all.length;i++){            all[i] = i;        }//创建全选数组        int[] sel=jl.getSelectedIndices();//获得已选择的数组        for(int i=0;i<sel.length;i++){//根据已选择的数组的下标来反选全选数组即可            int temp=sel[i];            for (int j=0;j<all.length;j++){//细心。。。这里写错了导致bug                if(temp==all[j]){                    all[j]=-1;                }            }        }//最后别忘记了set。。。        jl.setSelectedIndices(all);    }\n" +
            "```\n" +
            "\n";
    public Help() {
        initComponents();
        info.setText(helper);
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
        scrollPane1 = new JScrollPane();
        info = new JTextArea();
        back = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- info ----
                info.setEditable(false);
                scrollPane1.setViewportView(info);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(55, 40, 680, 430);

            //---- back ----
            back.setText("Back");
            back.addActionListener(e -> backActionPerformed(e));
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(5, 5), back.getPreferredSize()));

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
    private JScrollPane scrollPane1;
    private JTextArea info;
    private JButton back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
