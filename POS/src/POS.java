import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class POS {
	
	/* pos main */
	JFrame fm_poa_main;
	Thread th_nowtime;
	JTabbedPane tab_menu,tab_order_list;
	JPanel pn_menu_1,pn_menu_2,pn_menu_3,pn_menu_4,pn_menu_5,pn_list_1,pn_list_2,pn_list_3,pn_list_4,pn_list_5;
	/*pos main end*/
	
	/* info */
	JPanel pn_info;
	JLabel lb_info_nowtime,lb_info_user_num,lb_info_order_num,lb_info_table,lb_info_user_name,lb_info_status;
	JTextField tf_info_user_num,tf_info_order_num,tf_info_table,tf_info_user_name,tf_info_status;
	/* info end */
	
	/* meals */
	int qty[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int price[]={140,190,160,160,210,210,180,230,120,155,140,140,175,175,160,195,120,155,140,140,175,175,160,195,60,140,120,120,50,80,50,80,50,80,50,80,50,80,50,50,50,50,50,0,0,0,0,0};
	int small_total[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	String item_name[]={"異想牛漢堡","異想牛漢堡(肉)","異想牛漢堡(培)","異想牛漢堡(起)","異想牛漢堡(肉培)","異想牛漢堡(肉起)","異想牛漢堡(培起)","異想牛漢堡(肉培起)",
			            "異想豬漢堡","異想豬漢堡(肉)","異想豬漢堡(培)","異想豬漢堡(起)","異想豬漢堡(肉培)","異想豬漢堡(肉起)","異想豬漢堡(培起)","異想豬漢堡(肉培起)",
			            "異想雞漢堡","異想雞漢堡(肉)","異想雞漢堡(培)","異想雞漢堡(起)","異想雞漢堡(肉培)","異想雞漢堡(肉起)","異想雞漢堡(培起)","異想雞漢堡(肉培起)",
			            "實驗咖哩飯","實驗牛咖哩飯","實驗豬咖哩飯","實驗雞咖哩飯",
			            "成長的回憶","成長的回憶(套)","草原上的青雞","草原上的青雞(套)","低調中的高貴","低調中的高貴(套)","親子間的南瓜","親子間的南瓜(套)","牛奶海洋裡的鮭魚","牛奶海洋裡的鮭魚(套)",
			            "憂愁的藥水","炙烈的藥水","高貴的藥水","典雅的藥水","魔性的藥水",
			            "憂愁的藥水(贈)","炙烈的藥水(贈)","高貴的藥水(贈)","典雅的藥水(贈)","魔性的藥水(贈)"};
	
	/* meals end */
	/* menu */
	
	JLabel lb_menu_name[]=new JLabel[50],lb_menu_x[]=new JLabel[50];
	JTextField tf_menu_qty[]=new JTextField[19];
	JCheckBox cb[]=new JCheckBox[19];
	JButton btn_add[]=new JButton[19];
	JPanel pn_menu_1_1,pn_menu_1_2,pn_menu_1_3;
	private JPanel panel;
	private JLabel pn_menu_2_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	
	/* menu end */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS window = new POS();
					window.fm_poa_main.setVisible(true);
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
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		/* pos main */
		
		fm_poa_main = new JFrame();
		fm_poa_main.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/icon.png")));
		fm_poa_main.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		fm_poa_main.setTitle("POS\u7CFB\u7D71");
		fm_poa_main.setResizable(false);
		fm_poa_main.setBounds(100, 100, 1300, 750);
		fm_poa_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm_poa_main.getContentPane().setLayout(null);
		
		tab_menu = new JTabbedPane(JTabbedPane.TOP);
		tab_menu.setFont(new Font("新細明體", Font.PLAIN, 18));
		tab_menu.setBounds(900, 10, 390, 700);
		tab_menu.setForeground(Color.BLACK);
		fm_poa_main.getContentPane().add(tab_menu);
		
		/* menu_1 */
		
		pn_menu_1 = new JPanel();
		pn_menu_1.setBackground(new Color(255, 182, 193));
		tab_menu.addTab("", new ImageIcon(POS.class.getResource("/pic/meum_1.png")), pn_menu_1, null);
		pn_menu_1.setLayout(null);
		
		/* 1-1 */
		
		pn_menu_1_1 = new JPanel();
		pn_menu_1_1.setBackground(new Color(255, 182, 193));
		pn_menu_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_1_1.setBounds(0, 0, 390, 140);
		pn_menu_1.add(pn_menu_1_1);
		pn_menu_1_1.setLayout(null);
		
		lb_menu_name[0] = new JLabel("\u7570\u60F3\u725B\u6F22\u5821");
		lb_menu_name[0].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[0].setBounds(20, 0, 210, 70);
		pn_menu_1_1.add(lb_menu_name[0]);
		
		lb_menu_x[0] = new JLabel("x");
		lb_menu_x[0].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[0].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[0].setBounds(270, 20, 30, 30);
		pn_menu_1_1.add(lb_menu_x[0]);
		
		tf_menu_qty[0] = new JTextField();
		tf_menu_qty[0].setBounds(300, 10, 70, 50);
		pn_menu_1_1.add(tf_menu_qty[0]);
		tf_menu_qty[0].setColumns(10);
		
		cb[0] = new JCheckBox("\u6F22\u5821\u8089");
		cb[0].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[0].setBackground(new Color(255, 182, 193));
		cb[0].setBounds(20, 80, 90, 30);
		pn_menu_1_1.add(cb[0]);
		
		cb[1] = new JCheckBox("\u57F9\u6839");
		cb[1].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[1].setBackground(new Color(255, 182, 193));
		cb[1].setBounds(115, 80, 70, 30);
		pn_menu_1_1.add(cb[1]);
		
		cb[2] = new JCheckBox("\u8D77\u58EB");
		cb[2].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[2].setBackground(new Color(255, 182, 193));
		cb[2].setBounds(185, 80, 70, 30);
		pn_menu_1_1.add(cb[2]);
		
		btn_add[0] = new JButton("+");
		btn_add[0].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[0].setBounds(300, 80, 50, 30);
		pn_menu_1_1.add(btn_add[0]);
		
		/* 1-2 */
		
		pn_menu_1_2 = new JPanel();
		pn_menu_1_2.setLayout(null);
		pn_menu_1_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_1_2.setBackground(new Color(255, 182, 193));
		pn_menu_1_2.setBounds(0, 140, 390, 140);
		pn_menu_1.add(pn_menu_1_2);
		
		lb_menu_name[1] = new JLabel("\u7570\u60F3豬\u6F22\u5821");
		lb_menu_name[1].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[1].setBounds(20, 0, 210, 70);
		pn_menu_1_2.add(lb_menu_name[1]);
		
		lb_menu_x[1] = new JLabel("x");
		lb_menu_x[1].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[1].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[1].setBounds(270, 20, 30, 30);
		pn_menu_1_2.add(lb_menu_x[1]);
		
		tf_menu_qty[1] = new JTextField();
		tf_menu_qty[1].setColumns(10);
		tf_menu_qty[1].setBounds(300, 10, 70, 50);
		pn_menu_1_2.add(tf_menu_qty[1]);
		
		cb[3] = new JCheckBox("\u6F22\u5821\u8089");
		cb[3].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[3].setBackground(new Color(255, 182, 193));
		cb[3].setBounds(20, 80, 90, 30);
		pn_menu_1_2.add(cb[3]);
		
		cb[4] = new JCheckBox("\u57F9\u6839");
		cb[4].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[4].setBackground(new Color(255, 182, 193));
		cb[4].setBounds(115, 80, 70, 30);
		pn_menu_1_2.add(cb[4]);
		
		cb[5] = new JCheckBox("\u8D77\u58EB");
		cb[5].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[5].setBackground(new Color(255, 182, 193));
		cb[5].setBounds(185, 80, 70, 30);
		pn_menu_1_2.add(cb[5]);
		
		btn_add[1] = new JButton("+");
		btn_add[1].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[1].setBounds(300, 80, 50, 30);
		pn_menu_1_2.add(btn_add[1]);
		
		/* 1-3 */
		
		pn_menu_1_3 = new JPanel();
		pn_menu_1_3.setLayout(null);
		pn_menu_1_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_1_3.setBackground(new Color(255, 182, 193));
		pn_menu_1_3.setBounds(0, 280, 390, 140);
		pn_menu_1.add(pn_menu_1_3);
		
		lb_menu_name[2] = new JLabel("\u7570\u60F3雞\u6F22\u5821");
		lb_menu_name[2].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[2].setBounds(20, 0, 210, 70);
		pn_menu_1_3.add(lb_menu_name[2]);
		
		lb_menu_x[2] = new JLabel("x");
		lb_menu_x[2].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[2].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[2].setBounds(270, 20, 30, 30);
		pn_menu_1_3.add(lb_menu_x[2]);
		
		tf_menu_qty[2] = new JTextField();
		tf_menu_qty[2].setColumns(10);
		tf_menu_qty[2].setBounds(300, 10, 70, 50);
		pn_menu_1_3.add(tf_menu_qty[2]);
		
		cb[6] = new JCheckBox("\u6F22\u5821\u8089");
		cb[6].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[6].setBackground(new Color(255, 182, 193));
		cb[6].setBounds(20, 80, 90, 30);
		pn_menu_1_3.add(cb[6]);
		
		cb[7] = new JCheckBox("\u57F9\u6839");
		cb[7].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[7].setBackground(new Color(255, 182, 193));
		cb[7].setBounds(115, 80, 70, 30);
		pn_menu_1_3.add(cb[7]);
		
		cb[8] = new JCheckBox("\u8D77\u58EB");
		cb[8].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[8].setBackground(new Color(255, 182, 193));
		cb[8].setBounds(185, 80, 70, 30);
		pn_menu_1_3.add(cb[8]);
		
		btn_add[2] = new JButton("+");
		btn_add[2].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[2].setBounds(300, 80, 50, 30);
		pn_menu_1_3.add(btn_add[2]);
		
		/* menu_1 */
		
		pn_menu_2 = new JPanel();
		pn_menu_2.setBackground(Color.YELLOW);
		tab_menu.addTab("", new ImageIcon(POS.class.getResource("/pic/meum_2.png")), pn_menu_2, null);
		pn_menu_2.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 390, 70);
		pn_menu_2.add(panel);
		panel.setLayout(null);
		
		pn_menu_2_1 = new JLabel("\u5BE6\u9A57\u725B\u5496\u54E9\u98EF");
		pn_menu_2_1.setFont(new Font("新細明體", Font.PLAIN, 26));
		pn_menu_2_1.setBounds(20, 0, 160, 70);
		panel.add(pn_menu_2_1);
		
		lblNewLabel = new JLabel("x");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel.setBounds(190, 20, 30, 30);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(210, 10, 70, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 26));
		btnNewButton.setBounds(310, 20, 50, 30);
		panel.add(btnNewButton);
		
		pn_menu_3 = new JPanel();
		pn_menu_3.setBackground(new Color(154, 205, 50));
		tab_menu.addTab("", new ImageIcon(POS.class.getResource("/pic/meum_3.png")), pn_menu_3, null);
		pn_menu_3.setLayout(null);
		
		pn_menu_4 = new JPanel();
		pn_menu_4.setBackground(new Color(0, 191, 255));
		tab_menu.addTab("", new ImageIcon(POS.class.getResource("/pic/meum_4.png")), pn_menu_4, null);
		pn_menu_4.setLayout(null);
		
		pn_menu_5 = new JPanel();
		pn_menu_5.setBackground(new Color(128, 128, 128));
		tab_menu.addTab("", new ImageIcon(POS.class.getResource("/pic/meum_5.png")), pn_menu_5, null);
		pn_menu_5.setLayout(null);
		
		tab_order_list = new JTabbedPane(JTabbedPane.LEFT);
		tab_order_list.setFont(new Font("新細明體", Font.PLAIN, 18));
		tab_order_list.setBounds(10, 10, 500, 560);
		fm_poa_main.getContentPane().add(tab_order_list);
		
		pn_list_1 = new JPanel();
		tab_order_list.addTab("1", null, pn_list_1, null);
		pn_list_1.setLayout(null);
		
		pn_list_2 = new JPanel();
		tab_order_list.addTab("2", null, pn_list_2, null);
		pn_list_2.setLayout(null);
		
		pn_list_3 = new JPanel();
		tab_order_list.addTab("3", null, pn_list_3, null);
		pn_list_3.setLayout(null);
		
		pn_list_4 = new JPanel();
		tab_order_list.addTab("4", null, pn_list_4, null);
		pn_list_4.setLayout(null);
		
		pn_list_5 = new JPanel();
		tab_order_list.addTab("5", null, pn_list_5, null);
		pn_list_5.setLayout(null);
		
		/* pos main end */
		/* info */
		
		pn_info = new JPanel();
		pn_info.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8CC7\u8A0A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_info.setBounds(510, 10, 390, 110);
		fm_poa_main.getContentPane().add(pn_info);
		pn_info.setLayout(null);
		
		lb_info_nowtime = new JLabel();
		lb_info_nowtime.setText("now_time");
		lb_info_nowtime.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_info_nowtime.setBounds(20, 20, 360, 20);
		pn_info.add(lb_info_nowtime);
		
		lb_info_user_num = new JLabel("\u4F7F\u7528\u8005\u7DE8\u865F :");
		lb_info_user_num.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_info_user_num.setBounds(20, 50, 120, 20);
		pn_info.add(lb_info_user_num);
		
		lb_info_order_num = new JLabel("\u55AE\u865F :");
		lb_info_order_num.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_info_order_num.setBounds(20, 75, 60, 20);
		pn_info.add(lb_info_order_num);
		
		lb_info_table = new JLabel("\u684C\u865F :");
		lb_info_table.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_info_table.setBounds(130, 75, 60, 20);
		pn_info.add(lb_info_table);
		
		lb_info_user_name = new JLabel("\u4F7F\u7528\u8005\u540D\u7A31 :");
		lb_info_user_name.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_info_user_name.setBounds(175, 50, 120, 20);
		pn_info.add(lb_info_user_name);
		
		lb_info_status = new JLabel("\u72C0\u614B :");
		lb_info_status.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_info_status.setBounds(240, 75, 55, 25);
		pn_info.add(lb_info_status);
		
		tf_info_user_num = new JTextField();
		tf_info_user_num.setEditable(false);
		tf_info_user_num.setHorizontalAlignment(SwingConstants.CENTER);
		tf_info_user_num.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_user_num.setText("88");
		tf_info_user_num.setBounds(135, 50, 30, 20);
		pn_info.add(tf_info_user_num);
		tf_info_user_num.setColumns(10);
		
		tf_info_order_num = new JTextField();
		tf_info_order_num.setHorizontalAlignment(SwingConstants.CENTER);
		tf_info_order_num.setEditable(false);
		tf_info_order_num.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_order_num.setText("9999");
		tf_info_order_num.setBounds(75, 75, 45, 20);
		pn_info.add(tf_info_order_num);
		tf_info_order_num.setColumns(10);
		
		tf_info_table = new JTextField();
		tf_info_table.setEditable(false);
		tf_info_table.setText("\u5916\u5E36");
		tf_info_table.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_table.setBounds(185, 75, 45, 25);
		pn_info.add(tf_info_table);
		tf_info_table.setColumns(10);
		
		tf_info_user_name = new JTextField();
		tf_info_user_name.setEditable(false);
		tf_info_user_name.setText("\u9673\u601D\u60DF");
		tf_info_user_name.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_user_name.setBounds(290, 50, 65, 25);
		pn_info.add(tf_info_user_name);
		tf_info_user_name.setColumns(10);
		
		tf_info_status = new JTextField();
		tf_info_status.setEditable(false);
		tf_info_status.setText("\u6E96\u5099\u4E2D");
		tf_info_status.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_status.setBounds(300, 75, 65, 25);
		pn_info.add(tf_info_status);
		tf_info_status.setColumns(10);
		
		/* info end */
		
	}
	
	void clock()
    {
            th_nowtime=new Thread()
            {
                public void run()
                {        
                        for(;;)
                        {
                                Date d=new Date();
                                SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd E a hh:mm:ss");
                                lb_info_nowtime.setText(sdf1.format(d));
                                try{
                                      sleep(1000);
                                } catch(InterruptedException e){}
                        }
                }
            };
            th_nowtime.start();
    }
}
