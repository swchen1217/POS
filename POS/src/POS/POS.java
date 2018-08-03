package POS;  // 這行是我測試用的 不用理他

import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POS implements ActionListener{
        
        private static final Color blue = null;
		JLabel label_7;
        int num=1;
        int qty[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int price[]={140,190,160,160,210,210,180,230,120,155,140,140,175,175,160,195,120,155,140,140,175,175,160,195,60,140,120,120,50,80,50,80,50,80,50,80,50,80,50,50,50,50,50,0,0,0,0,0,70,160,140,140,50,80,50,80,50,80,50,80,50,50,50,50,50};
        int small_total[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String item_name[]={"異想牛漢堡","異想牛漢堡(肉)","異想牛漢堡(培)","異想牛漢堡(起)","異想牛漢堡(肉培)","異想牛漢堡(肉起)","異想牛漢堡(培起)","異想牛漢堡(肉培起)",
                                    "異想豬漢堡","異想豬漢堡(肉)","異想豬漢堡(培)","異想豬漢堡(起)","異想豬漢堡(肉培)","異想豬漢堡(肉起)","異想豬漢堡(培起)","異想豬漢堡(肉培起)",
                                    "異想雞漢堡","異想雞漢堡(肉)","異想雞漢堡(培)","異想雞漢堡(起)","異想雞漢堡(肉培)","異想雞漢堡(肉起)","異想雞漢堡(培起)","異想雞漢堡(肉培起)",
                                    "實驗咖哩飯","實驗牛咖哩飯","實驗豬咖哩飯","實驗雞咖哩飯",
                                    "成長的回憶","成長的回憶(套)","草原上的青雞","草原上的青雞(套)","低調中的高貴","低調中的高貴(套)","親子間的南瓜","親子間的南瓜(套)","牛奶海洋裡的鮭魚","牛奶海洋裡的鮭魚(套)",
                                    "憂愁的藥水","炙烈的藥水","高貴的藥水","典雅的藥水","魔性的藥水",
                                    "憂愁的藥水(贈)","炙烈的藥水(贈)","高貴的藥水(贈)","典雅的藥水(贈)","魔性的藥水(贈)"};
        int total=0, pay, change;
        
        JPanel pn_order[]=new JPanel[48];
        JButton btn_remove[]=new JButton[48];
        JLabel lb_qty[]=new JLabel[48];
        JLabel lb_small_total[]=new JLabel[48];

        JFrame frame;
        JTextField tf_total;
        JTextField tf_pay;
        JTextField tf_change;
        JButton btn_add_1, btn_add_2, btn_add_3, btn_add_4, btn_add_5, btn_add_6, btn_add_7, btn_add_8,btn_add_9, btn_add_10, btn_add_11, btn_add_12,btn_add_13, btn_add_14, btn_add_15, btn_add_16;  //全域變數
        JLabel lb_qty_0;
        JLabel small_total_0;
        
        JCheckBox cb_1,cb_2,cb_3,cb_4,cb_5,cb_6,cb_7,cb_8,cb_9,cb_10;
        JPanel panel_page1,panel_page2,panel_page3;
        JPanel panel_order;
        JTabbedPane tabbedPane_items;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        POS window = new POS();
                                        window.frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        /**
         * Create the application.
         */
        public POS() {
                initialize();
        }

        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
                
                try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {}
                
                frame = new JFrame();
                frame.setBounds(100, 100, 870, 563);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);
                
                JTabbedPane tabbedPane_main = new JTabbedPane(JTabbedPane.TOP);
                tabbedPane_main.setBounds(0, 0, 1179, 525);
                frame.getContentPane().add(tabbedPane_main);
                
                ButtonGroup bg=new ButtonGroup();
                
                String n[]={"桌號","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
                
                panel_order = new JPanel();
                tabbedPane_main.addTab("點餐系統", null, panel_order, null);
                panel_order.setLayout(null);
                
                tabbedPane_items = new JTabbedPane(JTabbedPane.LEFT);
                tabbedPane_items.setBounds(10, 46, 330, 329);
                panel_order.add(tabbedPane_items);
                
                panel_page1 = new JPanel();
                tabbedPane_items.addTab("1", null, panel_page1, null);
                panel_page1.setLayout(null);
                
                panel_page2 = new JPanel();
                tabbedPane_items.addTab("2", null, panel_page2, null);
                panel_page2.setLayout(null);
                
                panel_page3 = new JPanel();
                tabbedPane_items.addTab("3", null, panel_page3, null);
                panel_page3.setLayout(null);
                
                JRadioButton radioButton1 = new JRadioButton("\u5916\u5E36");
                radioButton1.setFont(new Font("新細明體", Font.PLAIN, 16));
                radioButton1.setBounds(367, 7, 65, 34);
                panel_order.add(radioButton1);
                
                JRadioButton radioButton2 = new JRadioButton("\u5167\u7528");
                radioButton2.setFont(new Font("新細明體", Font.PLAIN, 16));
                radioButton2.setBounds(434, 7, 65, 34);
                panel_order.add(radioButton2);
                bg.add(radioButton1);
                bg.add(radioButton2);
                
                JComboBox comboBox = new JComboBox(n);
                comboBox.setMaximumRowCount(20);
                comboBox.setFont(new Font("新細明體", Font.PLAIN, 16));
                comboBox.setBounds(505, 7, 65, 34);
                panel_order.add(comboBox);
                
                JPanel panel = new JPanel();
                panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                panel.setBackground(Color.ORANGE);
                panel.setBounds(350, 46, 289, 205);
                panel_order.add(panel);
                panel.setLayout(null);
                
                JLabel lb_menu_1 = new JLabel("\u7570\u60F3\u725B\u6F22\u5821");
                lb_menu_1.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_1.setBackground(new Color(255, 255, 204));
                lb_menu_1.setBounds(0, 28, 86, 31);
                panel.add(lb_menu_1);
                
                cb_1 = new JCheckBox("\u8089");
                cb_1.setBackground(Color.ORANGE);
                cb_1.setBounds(93, 34, 46, 23);
                panel.add(cb_1);
                
                cb_2 = new JCheckBox("\u57F9");
                cb_2.setBackground(Color.ORANGE);
                cb_2.setBounds(141, 34, 46, 23);
                panel.add(cb_2);
                
                cb_3 = new JCheckBox("\u8D77");
                cb_3.setBackground(Color.ORANGE);
                cb_3.setBounds(189, 34, 46, 23);
                panel.add(cb_3);
                
                btn_add_1 = new JButton("+");
                btn_add_1.addActionListener(this);
                btn_add_1.setBounds(241, 34, 39, 23);
                panel.add(btn_add_1);
                
                JLabel lb_menu_2 = new JLabel("\u7570\u60F3\u8C6C\u6F22\u5821");
                lb_menu_2.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_2.setBackground(new Color(255, 255, 204));
                lb_menu_2.setBounds(0, 87, 86, 31);
                panel.add(lb_menu_2);
                
                cb_4 = new JCheckBox("\u8089");
                cb_4.setBackground(Color.ORANGE);
                cb_4.setBounds(93, 91, 46, 23);
                panel.add(cb_4);
                
                cb_5 = new JCheckBox("\u57F9");
                cb_5.setBackground(Color.ORANGE);
                cb_5.setBounds(141, 91, 46, 23);
                panel.add(cb_5);
                
                cb_6 = new JCheckBox("\u8D77");
                cb_6.setBackground(Color.ORANGE);
                cb_6.setBounds(189, 91, 46, 23);
                panel.add(cb_6);
                
                btn_add_2 = new JButton("+");
                btn_add_2.addActionListener(this);
                btn_add_2.setBounds(241, 91, 39, 23);
                panel.add(btn_add_2);
                
                JLabel lb_menu_3 = new JLabel("\u7570\u60F3\u96DE\u6F22\u5821");
                lb_menu_3.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_3.setBackground(new Color(255, 255, 204));
                lb_menu_3.setBounds(0, 146, 86, 31);
                panel.add(lb_menu_3);
                
                cb_7 = new JCheckBox("\u8089");
                cb_7.setBackground(Color.ORANGE);
                cb_7.setBounds(93, 148, 46, 23);
                panel.add(cb_7);
                
                cb_8 = new JCheckBox("\u57F9");
                cb_8.setBackground(Color.ORANGE);
                cb_8.setBounds(141, 148, 46, 23);
                panel.add(cb_8);
                
                cb_9 = new JCheckBox("\u8D77");
                cb_9.setBackground(Color.ORANGE);
                cb_9.setBounds(189, 148, 46, 23);
                panel.add(cb_9);
                
                btn_add_3 = new JButton("+");
                btn_add_3.addActionListener(this);
                btn_add_3.setBounds(241, 148, 39, 23);
                panel.add(btn_add_3);
                
                JPanel panel_1 = new JPanel();
                panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                panel_1.setBackground(Color.GREEN);
                panel_1.setBounds(649, 46, 193, 205);
                panel_order.add(panel_1);
                panel_1.setLayout(null);
                
                JLabel lb_menu_4 = new JLabel("\u5BE6\u9A57\u5496\u54E9\u98EF");
                lb_menu_4.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_4.setBackground(new Color(255, 255, 204));
                lb_menu_4.setBounds(0, 16, 103, 31);
                panel_1.add(lb_menu_4);
                
                btn_add_4 = new JButton("+");
                btn_add_4.setBounds(144, 21, 39, 23);
                panel_1.add(btn_add_4);
                btn_add_4.addActionListener(this);
                
                
                JLabel lb_menu_5 = new JLabel("\u5BE6\u9A57\u725B\u5496\u54E9\u98EF");
                lb_menu_5.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_5.setBackground(new Color(255, 255, 204));
                lb_menu_5.setBounds(0, 63, 103, 31);
                panel_1.add(lb_menu_5);
                
                btn_add_5 = new JButton("+");
                btn_add_5.setBounds(144, 67, 39, 23);
                panel_1.add(btn_add_5);
                btn_add_5.addActionListener(this);
                
                JLabel lb_menu_6 = new JLabel("\u5BE6\u9A57\u8C6C\u5496\u54E9\u98EF");
                lb_menu_6.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_6.setBackground(new Color(255, 255, 204));
                lb_menu_6.setBounds(0, 110, 103, 31);
                panel_1.add(lb_menu_6);
                
                btn_add_6 = new JButton("+");
                btn_add_6.setBounds(144, 112, 39, 23);
                panel_1.add(btn_add_6);
                btn_add_6.addActionListener(this);
                
                JLabel lb_menu_7 = new JLabel("\u5BE6\u9A57\u96DE\u5496\u54E9\u98EF");
                lb_menu_7.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_7.setBackground(new Color(255, 255, 204));
                lb_menu_7.setBounds(0, 157, 103, 31);
                panel_1.add(lb_menu_7);
                
                btn_add_7 = new JButton("+");
                btn_add_7.setBounds(144, 157, 39, 23);
                panel_1.add(btn_add_7);
                btn_add_7.addActionListener(this);                
                
                JPanel panel_2 = new JPanel();
                panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                panel_2.setBackground(Color.CYAN);
                panel_2.setBounds(350, 261, 258, 171);
                panel_order.add(panel_2);
                panel_2.setLayout(null);
                
                JLabel lb_menu_8 = new JLabel("\u6210\u9577\u7684\u56DE\u61B6");
                lb_menu_8.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_8.setBackground(new Color(255, 255, 204));
                lb_menu_8.setBounds(0, 9, 103, 31);
                panel_2.add(lb_menu_8);
                
                cb_10 = new JCheckBox("\u5957");
                cb_10.setBounds(132, 15, 46, 23);
                panel_2.add(cb_10);
                cb_10.setBackground(Color.CYAN);
                
                btn_add_8 = new JButton("+");
                btn_add_8.setBounds(209, 14, 39, 23);
                panel_2.add(btn_add_8);
                btn_add_8.addActionListener(this);
                
                JLabel lb_menu_9 = new JLabel("\u8349\u539F\u4E0A\u7684\u9752\u96DE");
                lb_menu_9.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_9.setBackground(new Color(255, 255, 204));
                lb_menu_9.setBounds(0, 49, 103, 31);
                panel_2.add(lb_menu_9);

                btn_add_9 = new JButton("+");
                btn_add_9.setBounds(209, 53, 39, 23);
                panel_2.add(btn_add_9);
                btn_add_9.addActionListener(this);                
                
                JLabel lb_menu_10 = new JLabel("\u4F4E\u8ABF\u4E2D\u7684\u9AD8\u8CB4");
                lb_menu_10.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_10.setBackground(new Color(255, 255, 204));
                lb_menu_10.setBounds(0, 89, 103, 31);
                panel_2.add(lb_menu_10);
                
                btn_add_10 = new JButton("+");
                btn_add_10.setBounds(209, 91, 39, 23);
                panel_2.add(btn_add_10);
                btn_add_10.addActionListener(this);
                
                JLabel lb_menu_11 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A");
                lb_menu_11.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_11.setBackground(new Color(255, 255, 204));
                lb_menu_11.setBounds(0, 129, 136, 31);
                panel_2.add(lb_menu_11);
                
                btn_add_11 = new JButton("+");
                btn_add_11.setBounds(209, 129, 39, 23);
                panel_2.add(btn_add_11);
                
                JCheckBox cb_11 = new JCheckBox("\u5957");
                cb_11.setBackground(Color.CYAN);
                cb_11.setBounds(132, 53, 46, 23);
                panel_2.add(cb_11);
                
                JCheckBox cb_12 = new JCheckBox("\u5957");
                cb_12.setBackground(Color.CYAN);
                cb_12.setBounds(132, 91, 46, 23);
                panel_2.add(cb_12);
                
                JCheckBox cb_13 = new JCheckBox("\u5957");
                cb_13.setBackground(Color.CYAN);
                cb_13.setBounds(132, 129, 46, 23);
                panel_2.add(cb_13);
                btn_add_11.addActionListener(this);
                
                JPanel panel_3 = new JPanel();
                panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                panel_3.setBackground(Color.MAGENTA);
                panel_3.setBounds(615, 261, 227, 171);
                panel_order.add(panel_3);
                panel_3.setLayout(null);
                
                JLabel lb_menu_12 = new JLabel("\u6182\u6101\u7684\u85E5\u6C34");
                lb_menu_12.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_12.setBackground(new Color(255, 255, 204));
                lb_menu_12.setBounds(0, 2, 103, 31);
                panel_3.add(lb_menu_12);
                
                btn_add_12 = new JButton("+");
                btn_add_12.setBounds(178, 40, 39, 23);
                panel_3.add(btn_add_12);
                btn_add_12.addActionListener(this);
                
                JLabel lb_menu_13 = new JLabel("\u7099\u70C8\u7684\u85E5\u6C34");
                lb_menu_13.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_13.setBackground(new Color(255, 255, 204));
                lb_menu_13.setBounds(0, 35, 103, 31);
                panel_3.add(lb_menu_13);
                
                btn_add_13 = new JButton("+");
                btn_add_13.setBounds(178, 7, 39, 23);
                panel_3.add(btn_add_13);
                btn_add_13.addActionListener(this);
                
                JLabel lb_menu_14 = new JLabel("\u9AD8\u8CB4\u7684\u85E5\u6C34");
                lb_menu_14.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_14.setBackground(new Color(255, 255, 204));
                lb_menu_14.setBounds(0, 68, 103, 31);
                panel_3.add(lb_menu_14);
                
                btn_add_14 = new JButton("+");
                btn_add_14.setBounds(178, 73, 39, 23);
                panel_3.add(btn_add_14);
                btn_add_14.addActionListener(this);
                
                JLabel lb_menu_15 = new JLabel("\u5178\u96C5\u7684\u85E5\u6C34");
                lb_menu_15.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_15.setBackground(new Color(255, 255, 204));
                lb_menu_15.setBounds(0, 101, 103, 31);
                panel_3.add(lb_menu_15);
               
                btn_add_15 = new JButton("+");
                btn_add_15.setBounds(178, 105, 39, 23);
                panel_3.add(btn_add_15);
                btn_add_15.addActionListener(this);
                
                JLabel lb_menu_16 = new JLabel("\u9B54\u6027\u7684\u85E5\u6C34");
                lb_menu_16.setFont(new Font("新細明體", Font.PLAIN, 16));
                lb_menu_16.setBackground(new Color(255, 255, 204));
                lb_menu_16.setBounds(0, 134, 103, 31);
                panel_3.add(lb_menu_16);
                
                btn_add_16 = new JButton("+");
                btn_add_16.setBounds(178, 137, 39, 23);
                panel_3.add(btn_add_16);
                btn_add_16.addActionListener(this);         
                
                JLabel label_4 = new JLabel("\u7E3D\u5171");
                label_4.setFont(new Font("新細明體", Font.PLAIN, 16));
                label_4.setBounds(21, 388, 46, 15);
                panel_order.add(label_4);
                
                tf_total = new JTextField();
                tf_total.setFont(new Font("新細明體", Font.PLAIN, 16));
                tf_total.setBounds(63, 385, 56, 21);
                panel_order.add(tf_total);
                tf_total.setColumns(10);
                
                JLabel label_5 = new JLabel("\u6536");
                label_5.setFont(new Font("新細明體", Font.PLAIN, 16));
                label_5.setBounds(21, 418, 46, 15);
                panel_order.add(label_5);
                
                tf_pay = new JTextField();
                tf_pay.setFont(new Font("新細明體", Font.PLAIN, 16));
                tf_pay.setColumns(10);
                tf_pay.setBounds(63, 415, 56, 21);
                panel_order.add(tf_pay);
                
                JLabel label_6 = new JLabel("\u627E");
                label_6.setFont(new Font("新細明體", Font.PLAIN, 16));
                label_6.setBounds(21, 446, 46, 15);
                panel_order.add(label_6);
                
                tf_change = new JTextField();
                tf_change.setFont(new Font("新細明體", Font.PLAIN, 16));
                tf_change.setColumns(10);
                tf_change.setBounds(63, 443, 56, 21);
                panel_order.add(tf_change);
                
                JButton btn_checkout = new JButton("\u7D50\u5E33");
                btn_checkout.setToolTipText("");
                btn_checkout.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {                                
                                pay=Integer.parseInt(tf_pay.getText());
                                change=pay-total;
                                tf_change.setText(change+"");        
                        }
                });
                btn_checkout.setIcon(null);
                btn_checkout.setBounds(138, 388, 77, 76);
                panel_order.add(btn_checkout);
                
                JButton btn_next = new JButton("\u4E0B\u4E00\u7B46");
                btn_next.setToolTipText("");
                btn_next.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                
                                total=0;
                                tf_change.setText("");
                                tf_pay.setText("");
                                tf_total.setText("");
                                
                                for(int i=0; i<24; i++)
                                {
                                        qty[i]=0;
                                        small_total[i]=0;
                                }
                                
                                num++;
                                if(num<10)
                                    label_7.setText("單號：00"+num);
                                else if(num<100)
                                    label_7.setText("單號：0"+num);
                                else
                                        label_7.setText("單號："+num);
                                
                                locate();
                        }
                });
                btn_next.setIcon(null);
                btn_next.setBounds(225, 388, 77, 76);
                panel_order.add(btn_next);
                
                label_7 = new JLabel("\u55AE\u865F\uFF1A001");
                label_7.setFont(new Font("新細明體", Font.PLAIN, 16));
                label_7.setBounds(36, 17, 106, 15);
                panel_order.add(label_7);
                
                JPanel panel_manage = new JPanel();
                tabbedPane_main.addTab("庫存管理", null, panel_manage, null);
                panel_manage.setLayout(null);
                                                
/* 所有的 order panel */                
                for(int i=0; i<24; i++)
                {
                        JLabel item=new JLabel(item_name[i]);
                        item.setBounds(10, 5, 160, 44);
                        item.setFont(new Font("新細明體", Font.PLAIN, 16));
                        
                        JLabel lbX=new JLabel("x");
                        lbX.setBounds(160, 5, 10, 44);
                                        
                        lb_qty[i]=new JLabel("");
                        lb_qty[i].setBounds(180, 5, 60, 44);
                        lb_qty[i].setFont(new Font("新細明體", Font.PLAIN, 16));
                        
                        JLabel lbIs=new JLabel("=");
                        lbIs.setBounds(200, 5, 10, 44);
                        
                        lb_small_total[i]=new JLabel(small_total[i]+"");
                        lb_small_total[i].setBounds(220, 5, 60, 44);
                        lb_small_total[i].setFont(new Font("新細明體", Font.PLAIN, 16));
                        
                        btn_remove[i]=new JButton("-");
                        btn_remove[i].setBounds(250, 12, 40, 30);
                        btn_remove[i].addActionListener(this);
                        
                        pn_order[i]=new JPanel();
                        pn_order[i].setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                        pn_order[i].setBounds(860, 20+i*50, 310, 54);
                        pn_order[i].setBackground(new Color(255, 255, 204));
                        pn_order[i].setLayout(null);
                        pn_order[i].add(item);
                        pn_order[i].add(lbX);
                        pn_order[i].add(lbIs);
                        pn_order[i].add(lb_qty[i]);
                        pn_order[i].add(lb_small_total[i]);                
                        pn_order[i].add(btn_remove[i]);
                        frame.add(pn_order[i]);
                }        
        }
                
        void locate()
        {
                btn_add_1.setEnabled(true);
                btn_add_2.setEnabled(true);
                btn_add_3.setEnabled(true);
                btn_add_4.setEnabled(true);
                btn_add_5.setEnabled(true);
                btn_add_6.setEnabled(true);
                btn_add_7.setEnabled(true);
                btn_add_8.setEnabled(true);
                btn_add_9.setEnabled(true);
                btn_add_10.setEnabled(true);
                btn_add_11.setEnabled(true);
                btn_add_12.setEnabled(true);
                btn_add_13.setEnabled(true);
                btn_add_14.setEnabled(true);
                btn_add_15.setEnabled(true);
                btn_add_16.setEnabled(true);
              
                
                panel_page1.removeAll();
                panel_page2.removeAll();
                panel_page3.removeAll();
                panel_order.updateUI();
                
                int n=-1;
                for(int i=0; i<24; i++)
                {
                        if(qty[i]>0)
                        {
                                n++;
                                
                                if(n<6)
                                {
                                        pn_order[i].setLocation(0, n*54);
                                        panel_page1.add(pn_order[i]);        
                                        tabbedPane_items.setSelectedIndex(0);
                                        
                                }
                                else if(n<12)        
                                {
                                        pn_order[i].setLocation(0, (n-6)*54);
                                        panel_page2.add(pn_order[i]);
                                        tabbedPane_items.setSelectedIndex(1);
                                }
                                else if(n<17)        
                                {
                                        pn_order[i].setLocation(0, (n-12)*54);
                                        panel_page3.add(pn_order[i]);                        
                                        tabbedPane_items.setSelectedIndex(2);
                                }else
                                {
                                        pn_order[i].setLocation(0, (n-12)*54);
                                        panel_page3.add(pn_order[i]);                        
                                        tabbedPane_items.setSelectedIndex(2);
                                        btn_add_1.setEnabled(false);
                                        btn_add_2.setEnabled(false);
                                        btn_add_3.setEnabled(false);
                                        btn_add_4.setEnabled(false);
                                        btn_add_5.setEnabled(false);
                                        btn_add_6.setEnabled(false);
                                        btn_add_7.setEnabled(false);
                                        btn_add_8.setEnabled(false);
                                        btn_add_9.setEnabled(false);
                                        btn_add_10.setEnabled(false);
                                        btn_add_11.setEnabled(false);
                                        btn_add_12.setEnabled(false);
                                        btn_add_13.setEnabled(false);
                                        btn_add_14.setEnabled(false);
                                        btn_add_15.setEnabled(false);
                                        btn_add_16.setEnabled(false);
                                }
                        }        
                }        
        }
        void add(int i){
        	qty[24]++;
        	small_total[24]=qty[24]*price[24];
			lb_qty[24].setText(qty[24]+"");
			lb_small_total[23].setText(small_total[23]+"");
			total=0;
            for(int i1=0; i1<small_total.length; i1++)
                      total+=small_total[i1];
            tf_total.setText(total+"");
            locate();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

                if(e.getSource()==btn_add_1)
                {
                        if(!cb_1.isSelected() && !cb_2.isSelected() && !cb_3.isSelected() )
                        	add(0);
                        if(cb_1.isSelected() && !cb_2.isSelected() && !cb_3.isSelected() )
                            add(1);
                        if(!cb_1.isSelected() && cb_2.isSelected() && !cb_3.isSelected() )
                            add(2);
                        if(!cb_1.isSelected() && !cb_2.isSelected() && cb_3.isSelected() )
                            add(3);
                        if(cb_1.isSelected() && cb_2.isSelected() && !cb_3.isSelected() )
                            add(4);
                        if(cb_1.isSelected() && !cb_2.isSelected() && cb_3.isSelected() )
                            add(5);
                        if(!cb_1.isSelected() && cb_2.isSelected() && cb_3.isSelected() )
                            add(6);
                        if(cb_1.isSelected() && cb_2.isSelected() && cb_3.isSelected() )
                            add(7);
                }
                        
                if(e.getSource()==btn_add_2)
                {
                        if(!cb_4.isSelected() && !cb_5.isSelected() && !cb_6.isSelected() )
                            add(8);
                        if(cb_4.isSelected() && !cb_5.isSelected() && !cb_6.isSelected() )
                            add(9);
                        if(!cb_4.isSelected() && cb_5.isSelected() && !cb_6.isSelected() )
                            add(10);
                        if(!cb_4.isSelected() && !cb_5.isSelected() && cb_6.isSelected() )
                            add(11);
                        if(cb_4.isSelected() && cb_5.isSelected() && !cb_6.isSelected() )
                            add(12);
                        if(cb_4.isSelected() && !cb_5.isSelected() && cb_6.isSelected() )
                            add(13);
                        if(!cb_4.isSelected() && cb_5.isSelected() && cb_6.isSelected() )
                            add(14);
                        if(cb_4.isSelected() && cb_5.isSelected() && cb_6.isSelected() )
                            add(15);        
                }
                if(e.getSource()==btn_add_3)
                {
                        if(!cb_7.isSelected() && !cb_8.isSelected() && !cb_9.isSelected() )
                            add(16);
                        if(cb_7.isSelected() && !cb_8.isSelected() && !cb_9.isSelected() )
                            add(17);
                        if(!cb_7.isSelected() && cb_8.isSelected() && !cb_9.isSelected() )
                            add(18);
                        if(!cb_7.isSelected() && !cb_8.isSelected() && cb_9.isSelected() )
                            add(19);
                        if(cb_7.isSelected() && cb_8.isSelected() && !cb_9.isSelected() )
                            add(20);
                        if(cb_7.isSelected() && !cb_8.isSelected() && cb_9.isSelected() )
                            add(21);
                        if(!cb_7.isSelected() && cb_8.isSelected() && cb_9.isSelected() )
                            add(22);
                        if(cb_7.isSelected() && cb_8.isSelected() && cb_9.isSelected() )
                            add(23);                     
                }
                if(e.getSource()==btn_add_4)                
                	add(24);                
                if(e.getSource()==btn_add_5)                
                	add(25);                
                if(e.getSource()==btn_add_6)                
                	add(26);               
                if(e.getSource()==btn_add_7)               
                	add(27);                
                if(e.getSource()==btn_add_8)
                {
                	if(!cb_10.isSelected())
                		add(28);
                	if(cb_10.isSelected())
                		add(29);
                }
                if(e.getSource()==btn_add_9)
                {
                	if(!cb_10.isSelected())
                		add(30);
                	if(cb_10.isSelected())
                		add(31);
                }
                if(e.getSource()==btn_add_10)
                {
                	if(!cb_10.isSelected())
                		add(32);
                	if(cb_10.isSelected())
                		add(33);
                }
                if(e.getSource()==btn_add_11)
                {
                	if(!cb_10.isSelected())
                		add(34);
                	if(cb_10.isSelected())
                		add(35);               
        		}
                if(e.getSource()==btn_add_12)                
                	add(36);                
                if(e.getSource()==btn_add_13)                
                	add(37);                
                if(e.getSource()==btn_add_14)                
                	add(38);                
                if(e.getSource()==btn_add_15)                
                	add(39);           
                if(e.getSource()==btn_add_16)                
                	add(40);                
                for(int i=0; i<41; i++)
                {
                        if(e.getSource()==btn_remove[i])
                        {
                            if(qty[i]>0)
                                qty[i]--;     
                            small_total[i]=price[i]*qty[i];
                            lb_qty[i].setText(qty[i]+"");
                            lb_small_total[i].setText(small_total[i]+"");
                            total=0;
                            for(int i1=0; i1<qty.length; i1++)
                                       total+=small_total[i1];
                            tf_total.setText(total+"");
                            
                            locate();
                        }
                }                
        }
}