import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.lang.String;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class POS implements ActionListener {
	boolean Engineeringmode=false;
	
	/* main */
	
	int qty[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int small_total[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int price[]=new int[53];
	String item_name[]=new String[53];
	Thread th_nowtime;
	File f_system,f_log_order,f_log_sale,f_system_table,f_log_table,f_system_menu5,f_login,f_system_stock,f_system_meals,f_system_ingredients,f_system_option;
	BufferedWriter bw_system,bw_log_order,bw_log_sale,bw_system_table,bw_log_table,bw_system_menu5,bw_login,bw_system_stock,bw_system_meals,bw_system_ingredients,bw_system_option;
	BufferedReader br_system,br_log_order,br_log_sale,br_system_table,br_log_table,br_system_menu5,br_login,br_system_stock,br_system_meals,br_system_ingredients,br_system_option;
	int pay, change, order_sum=0, smalltotal=0, off=0, all_off=0, item_sum2=0, order_list_sum=0, m=0 ,n=0 ,tmp=-1 ,order_num ,now_tablenum ,now_status ,o=0;
	int list[]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	int table_status[]=new int[16],table_ordernum[]=new int[16],menu5_price[]=new int[5];
	double total=0 ,discount=100;
	String oldordernum="",oldRecord_log_order="",oldRecord_log_sale="",oldrecord_table="" ,oldRecord_log_table="" ,oldRecord_menu5="" ,oldRecord_login="",oldRecord_stock="",oldRecord_meals="",oldRecord_ingredients="",oldRecord_option="";
	String status[]={"空桌","已結帳","清潔中"};
	String status2[]={"空桌","新單","已結帳","清潔中"};
	String menu5_name[]=new String[5];
	String user[]={"","","",""};
	boolean isOrder[]=new boolean[53], isChecked=false, notfirst=false;
	String default_stocklist_name[]={"漢堡麵包","牛漢堡肉","豬漢堡肉","雞漢堡肉","生菜","蕃茄","洋蔥","牛醬料","豬醬料","雞醬料","烤時蔬","沙拉","咖哩","飯","吐司","起司","培根","成長的回憶乳酪醬","草原上的青雞乳酪醬","低調中的高貴乳酪醬","親子間的南瓜乳酪醬","牛奶海洋裡的鮭魚乳酪醬","蝶豆花茶包","自製草莓果漿","自製藍莓果漿","自製蔓越莓果漿","自製烏龍茶","咖啡","",""};
	String default_stocklist_unit[]={"片","片","片","片","份","份","份","匙","匙","匙","份","份","份","碗","片","片","片","匙","匙","匙","匙","匙","包","10 ml","10 ml","10 ml","450ml","500ml","",""};
	String stocklist_name[]=new String[30];
	String stocklist_unit[]=new String[30];
	int stocklist_qty[]=new int[30];
	String default_item_name[]={"異想牛漢堡","異想牛漢堡(肉)","異想牛漢堡(培)","異想牛漢堡(起)","異想牛漢堡(肉培)","異想牛漢堡(肉起)","異想牛漢堡(培起)","異想牛漢堡(肉培起)",
			"異想豬漢堡","異想豬漢堡(肉)","異想豬漢堡(培)","異想豬漢堡(起)","異想豬漢堡(肉培)","異想豬漢堡(肉起)","異想豬漢堡(培起)","異想豬漢堡(肉培起)",
			"異想雞漢堡","異想雞漢堡(肉)","異想雞漢堡(培)","異想雞漢堡(起)","異想雞漢堡(肉培)","異想雞漢堡(肉起)","異想雞漢堡(培起)","異想雞漢堡(肉培起)",
			"實驗咖哩飯","實驗牛咖哩飯","實驗豬咖哩飯","實驗雞咖哩飯",
			"成長的回憶","成長的回憶(套)","草原上的青雞","草原上的青雞(套)","低調中的高貴","低調中的高貴(套)","親子間的南瓜","親子間的南瓜(套)","牛奶海洋裡的鮭魚","牛奶海洋裡的鮭魚(套)",
			"憂愁的藥水","憂愁的藥水(贈)","炙烈的藥水","炙烈的藥水(贈)","高貴的藥水","高貴的藥水(贈)","典雅的藥水","典雅的藥水(贈)","魔性的藥水","魔性的藥水(贈)",
			"每日特餐","其他-","其他-","其他-","其他-"};
	int default_price[]={140,190,160,160,210,210,180,230,120,155,140,140,175,175,160,195,120,155,140,140,175,175,160,195,60,140,120,120,50,80,50,80,50,80,50,80,50,80,50,0,50,0,50,0,50,0,50,0,0,0,0,0,0,0};
	int default_ingredients[][]={{0,1,4,5,6,7,10,11},{0,1,4,5,6,7,10,11,1},{0,1,4,5,6,7,10,11,16},{0,1,4,5,6,7,10,11,15},{0,1,4,5,6,7,10,11,1,16},{0,1,4,5,6,7,10,11,1,15},{0,1,4,5,6,7,10,11,16,15},{0,1,4,5,6,7,10,11,1,16,15},{0,2,4,5,6,8,10,11},{0,2,4,5,6,8,10,11,2},{0,2,4,5,6,8,10,11,16},{0,2,4,5,6,8,10,11,15},{0,2,4,5,6,8,10,11,2,16},{0,2,4,5,6,8,10,11,2,15},{0,2,4,5,6,8,10,11,16,15},{0,2,4,5,6,8,10,11,2,16,15},{0,3,4,5,6,9,10,11},{0,3,4,5,6,9,10,11,3},{0,3,4,5,6,9,10,11,16},{0,3,4,5,6,9,10,11,15},{0,3,4,5,6,9,10,11,3,16},{0,3,4,5,6,9,10,11,3,15},{0,3,4,5,6,9,10,11,16,15},{0,3,4,5,6,9,10,11,3,16,15},{12,13,10,11},{12,13,1,10,11},{12,13,2,10,11},{12,13,3,10,11},{14,15,17},{14,15,17,10,11},{14,15,18},{14,15,18,10,11},{14,15,19},{14,15,19,10,11},{14,15,20},{14,15,20,10,11},{14,15,21},{14,15,21,10,11},{22},{22},{23,23,23,23,23,26},{23,23,23,23,23,26},{24,24,24,24,24,26},{24,24,24,24,24,26},{23,23,24,24,25,26},{23,23,24,24,25,26},{27},{27},{},{},{},{},{}};
	int ingredients[][]=new int[53][50];
	int ingredients_sum[]=new int[53];
	String default_option1[]={"1_1_1","1_1_2","1_1_3","1_2_1","1_2_2","1_2_3","1_3_1","1_3_2","1_3_3","3_1","3_2","3_3","3_4","3_5","4_1","4_2","4_3","4_4","4_5"};
	String default_option2[]={"漢堡肉","培根","起士","漢堡肉","培根","起士","漢堡肉","培根","起士","套餐","套餐","套餐","套餐","套餐","贈送","贈送","贈送","贈送","贈送"};
	
	/* main */
	
	JFrame fm_pos_main;
	JTabbedPane tab_menu,tab_order_list;
	JPanel pn_menu_1,pn_menu_2,pn_menu_3,pn_menu_4,pn_menu_5,pn_list_1,pn_list_2,pn_list_3,pn_list_4,pn_list_5;
	JLabel lb_note;
	JTextField tf_note;
	
	/* info */
	JPanel pn_info;
	JLabel lb_info_nowtime,lb_info_user_num,lb_info_order_num,lb_info_table,lb_info_user_name,lb_info_status,lb_info_order_sum;
	JTextField tf_info_user_num,tf_info_order_num,tf_info_table,tf_info_user_name,tf_info_status,tf_info_order_sum;
	
	/* item */
	
	JPanel pn_item[]=new JPanel[53];
	JLabel lb_item_name[]=new JLabel[53], lb_x[]=new JLabel[53], lb_e[]=new JLabel[53], lb_qty[]=new JLabel[53], lb_small_total[]=new JLabel[53];
	JButton btn_del[]=new JButton[53];
	
	/* menu */
	
	JLabel lb_menu_name[]=new JLabel[22],lb_menu_x[]=new JLabel[22];
	JTextField tf_menu_qty[]=new JTextField[22];
	JCheckBox cb[]=new JCheckBox[19];
	JButton btn_add[]=new JButton[22];
	JPanel pn_menu_1_1,pn_menu_1_2,pn_menu_1_3,pn_menu_2_1,pn_menu_2_2,pn_menu_2_3,pn_menu_2_4,pn_menu_3_1,pn_menu_3_2,pn_menu_3_3,pn_menu_3_4,pn_menu_3_5,pn_menu_4_1,pn_menu_4_2,pn_menu_4_3,pn_menu_4_4,pn_menu_4_5,pn_menu_5_1,pn_menu_5_2,pn_menu_5_3,pn_menu_5_4,pn_menu_5_5;
	
	/* checkout */
	
	JPanel pn_checkout;
	JTextField tf_ch_small_total,tf_ch_all_off,tf_ch_discount,tf_ch_off,tf_ch_total,tf_ch_pay,tf_ch_change;
	JLabel lb_ch_total,lb_ch_pay,lb_ch_change,lb_ch_small_total,lb_ch_discount,lb_ch_off,lb_ch_all_off;
	
	/* manege */
	
	JPanel pn_manage;
	JButton btn_man_clear,btn_man_re_print,btn_man_printer_set,btn_man_menu_5_set,btn_ch_chechout,btn_ch_off_set,btn_ch_next,btn_man_table,btn_man_stock,btn_man_look,btn_man_exit,btn_man_order_num_reset;
	
	/* table */
	
	JFrame fm_man_table;
	JPanel pn_table_inside[]=new JPanel[16] ,pn_table_outside;
	JLabel lb_table_inside_tablenum[]=new JLabel[16] ,lb_table_inside_ordernum[]=new JLabel[16] ,lb_table_inside_status[]=new JLabel[16] ,lb_table_outside_tablenum;
	JTextField tf_table_inside_ordernum[]=new JTextField[16] ,tf_table_inside_status[]=new JTextField[16];
	JButton btn_table_inside_new[]=new JButton[16] ,btn_table_inside_out[]=new JButton[16] ,btn_table_inside_end[]=new JButton[16] ,btn_table_outside_new ,btn_table_exit ,btn_table_all_reset;
	
	/* discount */
	
	JFrame fm_discount;
	JLabel lb_discount_discount,lb_discount_off;
	JTextField tf_discount_discount,tf_discount_off;
	JButton btn_discount_ok,btn_discount_cancel;
	
	/* menu5_set */
	
	JFrame fm_man_menu_5_set;
	JLabel lb_manu5_set_name,lb_menu5_set_price;
	JTextField tf_menu5_set_name[]=new JTextField[5],tf_menu5_set_price[]=new JTextField[5];
	JButton btn_menu5_set_ok,btn_menu5_set_cancel;
	
	/* login */
	
	JFrame fm_login;
	JLabel lb_login_icon,lb_login_name1,lb_login_name2,lb_login_name3,lb_login_account,lb_login_pw;
	JTextField tf_login_account;
	JPasswordField tf_login_pw;
	JButton btn_login_login,btn_login_exit;
	
	/* stock */
	
	JFrame fm_stock;
	JLabel lb_stock_title1,lb_stock_title2,lb_stock_title3,lb_stock_title4,lb_stock_title5,lb_stock_title6,lb_stock_title7,lb_stock_title8;
	JLabel lb_stock_item[]=new JLabel[30],lb_stock_unit[]=new JLabel[30],lb_stock_qty[]=new JLabel[30];
	JTextField tf_stock_input[]=new JTextField[30];
	JButton btn_stock_exit,btn_stock_reset,btn_stock_replace,btn_stock_revise;
	JPanel pn_stock;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS window = new POS();
					window.fm_login.setVisible(true);
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
		login();
		file();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void login()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		fm_login = new JFrame();
		fm_login.setTitle("Madhouse POS-登入系統");
		fm_login.setResizable(false);
		fm_login.setBounds(625, 370, 250, 210);
		fm_login.getContentPane().setLayout(null);
		fm_login.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		fm_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm_login.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/Madhouse.png")));
		fm_login.setVisible(true);
		
		lb_login_icon = new JLabel("");
		lb_login_icon.setIcon(new ImageIcon(POS.class.getResource("/pic/Madhouse2.png")));
		lb_login_icon.setBounds(10, 10, 70, 70);
		fm_login.getContentPane().add(lb_login_icon);
		
		lb_login_name1 = new JLabel("Madhouse");
		lb_login_name1.setFont(new Font("新細明體", Font.BOLD, 20));
		lb_login_name1.setBounds(120, 7, 85, 25);
		fm_login.getContentPane().add(lb_login_name1);
		
		lb_login_name2 = new JLabel("\u7570\u60F3\u6599\u7406\u5BE6\u9A57\u5BA4");
		lb_login_name2.setFont(new Font("新細明體", Font.BOLD, 20));
		lb_login_name2.setBounds(90, 30, 150, 25);
		fm_login.getContentPane().add(lb_login_name2);
		
		lb_login_name3 = new JLabel("POS-\u767B\u5165\u7CFB\u7D71");
		lb_login_name3.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_login_name3.setBounds(100, 55, 120, 25);
		fm_login.getContentPane().add(lb_login_name3);
		
		lb_login_account = new JLabel("\u5E33\u865F : ");
		lb_login_account.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_login_account.setBounds(10, 90, 55, 25);
		fm_login.getContentPane().add(lb_login_account);
		
		lb_login_pw = new JLabel("\u5BC6\u78BC : ");
		lb_login_pw.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_login_pw.setBounds(10, 115, 55, 25);
		fm_login.getContentPane().add(lb_login_pw);
		
		tf_login_account = new JTextField();
		tf_login_account.setBounds(65, 90, 155, 25);
		fm_login.getContentPane().add(tf_login_account);
		tf_login_account.setColumns(10);
		tf_login_account.addActionListener(this);
		
		tf_login_pw = new JPasswordField();
		tf_login_pw.setEchoChar('*');
		tf_login_pw.setColumns(10);
		tf_login_pw.setBounds(65, 115, 155, 25);
		tf_login_pw.addActionListener(this);
		fm_login.getContentPane().add(tf_login_pw);
		
		btn_login_login = new JButton("\u767B\u5165");
		btn_login_login.setFont(new Font("新細明體", Font.PLAIN, 19));
		btn_login_login.setBounds(25, 150, 90, 25);
		fm_login.getContentPane().add(btn_login_login);
		btn_login_login.addActionListener(this);
		
		btn_login_exit = new JButton("\u96E2\u958B");
		btn_login_exit.setFont(new Font("新細明體", Font.PLAIN, 19));
		btn_login_exit.setBounds(125, 150, 90, 25);
		fm_login.getContentPane().add(btn_login_exit);
		btn_login_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}
	void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		/* main */
		
		fm_pos_main = new JFrame();
		fm_pos_main.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/Madhouse.png")));
		fm_pos_main.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		fm_pos_main.setTitle("Madhouse POS");
		fm_pos_main.setResizable(false);
		fm_pos_main.setBounds(100, 100, 1300, 750);
		fm_pos_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm_pos_main.getContentPane().setLayout(null);
		fm_pos_main.setVisible(false);
		
		tab_menu = new JTabbedPane(JTabbedPane.TOP);
		tab_menu.setFont(new Font("新細明體", Font.PLAIN, 18));
		tab_menu.setBounds(900, 10, 390, 700);
		tab_menu.setForeground(Color.BLACK);
		fm_pos_main.getContentPane().add(tab_menu);
		
		tab_order_list = new JTabbedPane(JTabbedPane.LEFT);
		tab_order_list.setFont(new Font("新細明體", Font.PLAIN, 18));
		tab_order_list.setBounds(10, 10, 500, 560);
		fm_pos_main.getContentPane().add(tab_order_list);
		
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
		
		lb_note = new JLabel("\u5099\u8A3B");
		lb_note.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_note.setBounds(520, 550, 50, 33);
		fm_pos_main.getContentPane().add(lb_note);
		
		tf_note = new JTextField();
		tf_note.setFont(new Font("新細明體", Font.PLAIN, 25));
		tf_note.setBounds(573, 550, 315, 30);
		fm_pos_main.getContentPane().add(tf_note);
		tf_note.setColumns(10);
		
		for(int i=0;i<53;i++)
			isOrder[i]=false;
		
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
		tf_menu_qty[0].setFont(new Font("新細明體", Font.PLAIN, 26));
		
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
		btn_add[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!cb[0].isSelected() && !cb[1].isSelected() && !cb[2].isSelected())
				{
					add(0);
				}
				if(cb[0].isSelected() && !cb[1].isSelected() && !cb[2].isSelected())
				{
					add(1);
				}
				if(!cb[0].isSelected() && cb[1].isSelected() && !cb[2].isSelected())
				{
					add(2);
				}
				if(!cb[0].isSelected() && !cb[1].isSelected() && cb[2].isSelected())
				{
					add(3);
				}
				if(cb[0].isSelected() && cb[1].isSelected() && !cb[2].isSelected())
				{
					add(4);
				}
				if(cb[0].isSelected() && !cb[1].isSelected() && cb[2].isSelected())
				{
					add(5);
				}
				if(!cb[0].isSelected() && cb[1].isSelected() && cb[2].isSelected())
				{
					add(6);
				}
				if(cb[0].isSelected() && cb[1].isSelected() && cb[2].isSelected())
				{
					add(7);
				}
			}
		});
		
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
		tf_menu_qty[1].setFont(new Font("新細明體", Font.PLAIN, 26));
		
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
		btn_add[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!cb[3].isSelected() && !cb[4].isSelected() && !cb[5].isSelected())
				{
					add(8);
				}
				if(cb[3].isSelected() && !cb[4].isSelected() && !cb[5].isSelected())
				{
					add(9);
				}
				if(!cb[3].isSelected() && cb[4].isSelected() && !cb[5].isSelected())
				{
					add(10);
				}
				if(!cb[3].isSelected() && !cb[4].isSelected() && cb[5].isSelected())
				{
					add(11);
				}
				if(cb[3].isSelected() && cb[4].isSelected() && !cb[5].isSelected())
				{
					add(12);
				}
				if(cb[3].isSelected() && !cb[4].isSelected() && cb[5].isSelected())
				{
					add(13);
				}
				if(!cb[3].isSelected() && cb[4].isSelected() && cb[5].isSelected())
				{
					add(14);
				}
				if(cb[3].isSelected() && cb[4].isSelected() && cb[5].isSelected())
				{
					add(15);
				}
			}
		});
		
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
		tf_menu_qty[2].setFont(new Font("新細明體", Font.PLAIN, 26));
		
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
		btn_add[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!cb[6].isSelected() && !cb[7].isSelected() && !cb[8].isSelected())
				{
					add(16);
				}
				if(cb[6].isSelected() && !cb[7].isSelected() && !cb[8].isSelected())
				{
					add(17);
				}
				if(!cb[6].isSelected() && cb[7].isSelected() && !cb[8].isSelected())
				{
					add(18);
				}
				if(!cb[6].isSelected() && !cb[7].isSelected() && cb[8].isSelected())
				{
					add(19);
				}
				if(cb[6].isSelected() && cb[7].isSelected() && !cb[8].isSelected())
				{
					add(20);
				}
				if(cb[6].isSelected() && !cb[7].isSelected() && cb[8].isSelected())
				{
					add(21);
				}
				if(!cb[6].isSelected() && cb[7].isSelected() && cb[8].isSelected())
				{
					add(22);
				}
				if(cb[6].isSelected() && cb[7].isSelected() && cb[8].isSelected())
				{
					add(23);
				}
			}
		});
		
		/* menu_2 */
		
		pn_menu_2 = new JPanel();
		pn_menu_2.setBackground(Color.YELLOW);
		tab_menu.addTab("", new ImageIcon(POS.class.getResource("/pic/meum_2.png")), pn_menu_2, null);
		pn_menu_2.setLayout(null);
		
		pn_menu_2_1 = new JPanel();
		pn_menu_2_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_2_1.setBackground(Color.YELLOW);
		pn_menu_2_1.setBounds(0, 0, 390, 70);
		pn_menu_2.add(pn_menu_2_1);
		pn_menu_2_1.setLayout(null);
		
		lb_menu_name[3] = new JLabel("\u5BE6\u9A57\u5496\u54E9\u98EF");
		lb_menu_name[3].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[3].setBounds(20, 0, 160, 70);
		pn_menu_2_1.add(lb_menu_name[3]);
		
		lb_menu_x[3] = new JLabel("x");
		lb_menu_x[3].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[3].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[3].setBounds(190, 20, 30, 30);
		pn_menu_2_1.add(lb_menu_x[3]);
		
		tf_menu_qty[3] = new JTextField();
		tf_menu_qty[3].setFont(new Font("新細明體", Font.PLAIN, 26));
		tf_menu_qty[3].setBounds(220, 10, 70, 50);
		pn_menu_2_1.add(tf_menu_qty[3]);
		tf_menu_qty[3].setColumns(10);
		tf_menu_qty[3].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		btn_add[3] = new JButton("+");
		btn_add[3].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[3].setBounds(310, 20, 50, 30);
		pn_menu_2_1.add(btn_add[3]);
		btn_add[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(24);
			}
		});
		
		pn_menu_2_2 = new JPanel();
		pn_menu_2_2.setLayout(null);
		pn_menu_2_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_2_2.setBackground(Color.YELLOW);
		pn_menu_2_2.setBounds(0, 70, 390, 70);
		pn_menu_2.add(pn_menu_2_2);
		
		lb_menu_name[4] = new JLabel("\u5BE6\u9A57\u725B\u5496\u54E9\u98EF");
		lb_menu_name[4].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[4].setBounds(20, 0, 160, 70);
		pn_menu_2_2.add(lb_menu_name[4]);
		
		lb_menu_x[4] = new JLabel("x");
		lb_menu_x[4].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[4].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[4].setBounds(190, 20, 30, 30);
		pn_menu_2_2.add(lb_menu_x[4]);
		
		tf_menu_qty[4] = new JTextField();
		tf_menu_qty[4].setColumns(10);
		tf_menu_qty[4].setBounds(220, 10, 70, 50);
		pn_menu_2_2.add(tf_menu_qty[4]);
		tf_menu_qty[4].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		btn_add[4] = new JButton("+");
		btn_add[4].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[4].setBounds(310, 20, 50, 30);
		pn_menu_2_2.add(btn_add[4]);
		btn_add[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(25);
			}
		});
		
		pn_menu_2_3 = new JPanel();
		pn_menu_2_3.setLayout(null);
		pn_menu_2_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_2_3.setBackground(Color.YELLOW);
		pn_menu_2_3.setBounds(0, 140, 390, 70);
		pn_menu_2.add(pn_menu_2_3);
		
		lb_menu_name[5] = new JLabel("\u5BE6\u9A57\u8C6C\u5496\u54E9\u98EF");
		lb_menu_name[5].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[5].setBounds(20, 0, 160, 70);
		pn_menu_2_3.add(lb_menu_name[5]);
		
		lb_menu_x[5] = new JLabel("x");
		lb_menu_x[5].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[5].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[5].setBounds(190, 20, 30, 30);
		pn_menu_2_3.add(lb_menu_x[5]);
		
		tf_menu_qty[5] = new JTextField();
		tf_menu_qty[5].setColumns(10);
		tf_menu_qty[5].setBounds(220, 10, 70, 50);
		pn_menu_2_3.add(tf_menu_qty[5]);
		tf_menu_qty[5].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		btn_add[5] = new JButton("+");
		btn_add[5].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[5].setBounds(310, 20, 50, 30);
		pn_menu_2_3.add(btn_add[5]);
		btn_add[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(26);
			}
		});
		
		pn_menu_2_4 = new JPanel();
		pn_menu_2_4.setLayout(null);
		pn_menu_2_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_2_4.setBackground(Color.YELLOW);
		pn_menu_2_4.setBounds(0, 210, 390, 70);
		pn_menu_2.add(pn_menu_2_4);
		
		lb_menu_name[6] = new JLabel("\u5BE6\u9A57\u96DE\u5496\u54E9\u98EF");
		lb_menu_name[6].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[6].setBounds(20, 0, 160, 70);
		pn_menu_2_4.add(lb_menu_name[6]);
		
		lb_menu_x[6] = new JLabel("x");
		lb_menu_x[6].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[6].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[6].setBounds(190, 20, 30, 30);
		pn_menu_2_4.add(lb_menu_x[6]);
		
		tf_menu_qty[6] = new JTextField();
		tf_menu_qty[6].setColumns(10);
		tf_menu_qty[6].setBounds(220, 10, 70, 50);
		pn_menu_2_4.add(tf_menu_qty[6]);
		tf_menu_qty[6].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		btn_add[6] = new JButton("+");
		btn_add[6].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[6].setBounds(310, 20, 50, 30);
		pn_menu_2_4.add(btn_add[6]);
		btn_add[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(27);
			}
		});
		
		/* menu_3 */
		
		pn_menu_3 = new JPanel();
		pn_menu_3.setBackground(new Color(154, 205, 50));
		tab_menu.addTab("", new ImageIcon(POS.class.getResource("/pic/meum_3.png")), pn_menu_3, null);
		pn_menu_3.setLayout(null);
		
		pn_menu_3_1 = new JPanel();
		pn_menu_3_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3_1.setBackground(new Color(154, 205, 50));
		pn_menu_3_1.setBounds(0, 0, 390, 120);
		pn_menu_3.add(pn_menu_3_1);
		pn_menu_3_1.setLayout(null);
		
		lb_menu_name[7] = new JLabel("\u6210\u9577\u7684\u56DE\u61B6");
		lb_menu_name[7].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[7].setBounds(15, 0, 210, 70);
		pn_menu_3_1.add(lb_menu_name[7]);
		
		lb_menu_x[7] = new JLabel("x");
		lb_menu_x[7].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[7].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[7].setBounds(270, 15, 30, 30);
		pn_menu_3_1.add(lb_menu_x[7]);
		
		tf_menu_qty[7] = new JTextField();
		tf_menu_qty[7].setBounds(300, 5, 70, 50);
		pn_menu_3_1.add(tf_menu_qty[7]);
		tf_menu_qty[7].setColumns(10);
		tf_menu_qty[7].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[9] = new JCheckBox("\u5957\u9910");
		cb[9].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[9].setBackground(new Color(154, 205, 50));
		cb[9].setBounds(20, 70, 90, 30);
		pn_menu_3_1.add(cb[9]);
		
		btn_add[7] = new JButton("+");
		btn_add[7].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[7].setBounds(300, 70, 50, 30);
		pn_menu_3_1.add(btn_add[7]);
		btn_add[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[9].isSelected())
				{
					add(28);
				}else
				{
					add(29);
					
				}
			}
		});
		
		pn_menu_3_2 = new JPanel();
		pn_menu_3_2.setLayout(null);
		pn_menu_3_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3_2.setBackground(new Color(154, 205, 50));
		pn_menu_3_2.setBounds(0, 120, 390, 120);
		pn_menu_3.add(pn_menu_3_2);
		
		lb_menu_name[8] = new JLabel("\u8349\u539F\u4E0A\u7684\u9752\u96DE");
		lb_menu_name[8].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[8].setBounds(15, 0, 210, 70);
		pn_menu_3_2.add(lb_menu_name[8]);
		
		lb_menu_x[8] = new JLabel("x");
		lb_menu_x[8].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[8].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[8].setBounds(270, 15, 30, 30);
		pn_menu_3_2.add(lb_menu_x[8]);
		
		tf_menu_qty[8] = new JTextField();
		tf_menu_qty[8].setColumns(10);
		tf_menu_qty[8].setBounds(300, 5, 70, 50);
		pn_menu_3_2.add(tf_menu_qty[8]);
		tf_menu_qty[8].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[10] = new JCheckBox("\u5957\u9910");
		cb[10].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[10].setBackground(new Color(154, 205, 50));
		cb[10].setBounds(20, 70, 90, 30);
		pn_menu_3_2.add(cb[10]);
		
		btn_add[8] = new JButton("+");
		btn_add[8].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[8].setBounds(300, 70, 50, 30);
		pn_menu_3_2.add(btn_add[8]);
		btn_add[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[10].isSelected())
				{
					add(30);
				}else
				{
					add(31);
					
				}
			}
		});
		
		pn_menu_3_3 = new JPanel();
		pn_menu_3_3.setLayout(null);
		pn_menu_3_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3_3.setBackground(new Color(154, 205, 50));
		pn_menu_3_3.setBounds(0, 240, 390, 120);
		pn_menu_3.add(pn_menu_3_3);
		
		lb_menu_name[9] = new JLabel("\u4F4E\u8ABF\u4E2D\u7684\u9AD8\u8CB4");
		lb_menu_name[9].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[9].setBounds(15, 0, 210, 70);
		pn_menu_3_3.add(lb_menu_name[9]);
		
		lb_menu_x[9] = new JLabel("x");
		lb_menu_x[9].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[9].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[9].setBounds(270, 15, 30, 30);
		pn_menu_3_3.add(lb_menu_x[9]);
		
		tf_menu_qty[9] = new JTextField();
		tf_menu_qty[9].setColumns(10);
		tf_menu_qty[9].setBounds(300, 5, 70, 50);
		pn_menu_3_3.add(tf_menu_qty[9]);
		tf_menu_qty[9].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[11] = new JCheckBox("\u5957\u9910");
		cb[11].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[11].setBackground(new Color(154, 205, 50));
		cb[11].setBounds(20, 70, 90, 30);
		pn_menu_3_3.add(cb[11]);
		
		btn_add[9] = new JButton("+");
		btn_add[9].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[9].setBounds(300, 70, 50, 30);
		pn_menu_3_3.add(btn_add[9]);
		btn_add[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[11].isSelected())
				{
					add(32);
				}else
				{
					add(33);
					
				}
			}
		});
		
		pn_menu_3_4 = new JPanel();
		pn_menu_3_4.setLayout(null);
		pn_menu_3_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3_4.setBackground(new Color(154, 205, 50));
		pn_menu_3_4.setBounds(0, 360, 390, 120);
		pn_menu_3.add(pn_menu_3_4);
		
		lb_menu_name[10] = new JLabel("\u89AA\u5B50\u9593\u7684\u5357\u74DC");
		lb_menu_name[10].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[10].setBounds(15, 0, 210, 70);
		pn_menu_3_4.add(lb_menu_name[10]);
		
		lb_menu_x[10] = new JLabel("x");
		lb_menu_x[10].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[10].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[10].setBounds(270, 15, 30, 30);
		pn_menu_3_4.add(lb_menu_x[10]);
		
		tf_menu_qty[10] = new JTextField();
		tf_menu_qty[10].setColumns(10);
		tf_menu_qty[10].setBounds(300, 5, 70, 50);
		pn_menu_3_4.add(tf_menu_qty[10]);
		tf_menu_qty[10].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[12] = new JCheckBox("\u5957\u9910");
		cb[12].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[12].setBackground(new Color(154, 205, 50));
		cb[12].setBounds(20, 70, 90, 30);
		pn_menu_3_4.add(cb[12]);
		
		btn_add[10] = new JButton("+");
		btn_add[10].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[10].setBounds(300, 70, 50, 30);
		pn_menu_3_4.add(btn_add[10]);
		btn_add[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[12].isSelected())
				{
					add(34);
				}else
				{
					add(35);
					
				}
			}
		});
		
		pn_menu_3_5 = new JPanel();
		pn_menu_3_5.setLayout(null);
		pn_menu_3_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3_5.setBackground(new Color(154, 205, 50));
		pn_menu_3_5.setBounds(0, 480, 390, 120);
		pn_menu_3.add(pn_menu_3_5);
		
		lb_menu_name[11] = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A");
		lb_menu_name[11].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[11].setBounds(15, 0, 210, 70);
		pn_menu_3_5.add(lb_menu_name[11]);
		
		lb_menu_x[11] = new JLabel("x");
		lb_menu_x[11].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[11].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[11].setBounds(270, 15, 30, 30);
		pn_menu_3_5.add(lb_menu_x[11]);
		
		tf_menu_qty[11] = new JTextField();
		tf_menu_qty[11].setColumns(10);
		tf_menu_qty[11].setBounds(300, 5, 70, 50);
		pn_menu_3_5.add(tf_menu_qty[11]);
		tf_menu_qty[11].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[13] = new JCheckBox("\u5957\u9910");
		cb[13].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[13].setBackground(new Color(154, 205, 50));
		cb[13].setBounds(20, 70, 90, 30);
		pn_menu_3_5.add(cb[13]);
		
		btn_add[11] = new JButton("+");
		btn_add[11].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[11].setBounds(300, 70, 50, 30);
		pn_menu_3_5.add(btn_add[11]);
		btn_add[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[13].isSelected())
				{
					add(36);
				}else
				{
					add(37);
					
				}
			}
		});
		
		/* menu_4 */
		
		pn_menu_4 = new JPanel();
		pn_menu_4.setBackground(new Color(0, 191, 255));
		tab_menu.addTab("", new ImageIcon(POS.class.getResource("/pic/meum_4.png")), pn_menu_4, null);
		pn_menu_4.setLayout(null);
		
		pn_menu_4_1 = new JPanel();
		pn_menu_4_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4_1.setBounds(0, 0, 390, 120);
		pn_menu_4_1.setBackground(new Color(0, 191, 255));
		pn_menu_4.add(pn_menu_4_1);
		pn_menu_4_1.setLayout(null);
		
		lb_menu_name[12] = new JLabel("\u6182\u6101\u7684\u85E5\u6C34");
		lb_menu_name[12].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[12].setBounds(15, 0, 210, 70);
		pn_menu_4_1.add(lb_menu_name[12]);
		
		lb_menu_x[12] = new JLabel("x");
		lb_menu_x[12].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[12].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[12].setBounds(270, 15, 30, 30);
		pn_menu_4_1.add(lb_menu_x[12]);
		
		tf_menu_qty[12] = new JTextField();
		tf_menu_qty[12].setBounds(300, 5, 70, 50);
		pn_menu_4_1.add(tf_menu_qty[12]);
		tf_menu_qty[12].setColumns(10);
		tf_menu_qty[12].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[14] = new JCheckBox("\u8D08\u9001");
		cb[14].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[14].setBounds(20, 70, 90, 30);
		cb[14].setBackground(new Color(0, 191, 255));
		pn_menu_4_1.add(cb[14]);
		
		btn_add[12] = new JButton("+");
		btn_add[12].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[12].setBounds(300, 70, 50, 30);
		pn_menu_4_1.add(btn_add[12]);
		btn_add[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[14].isSelected())
				{
					add(38);
				}else
				{
					add(39);	
				}					
			}
		});
		
		pn_menu_4_2 = new JPanel();
		pn_menu_4_2.setLayout(null);
		pn_menu_4_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4_2.setBackground(new Color(0, 191, 255));
		pn_menu_4_2.setBounds(0, 120, 390, 120);
		pn_menu_4.add(pn_menu_4_2);
		
		lb_menu_name[13] = new JLabel("\u7099\u70C8\u7684\u85E5\u6C34");
		lb_menu_name[13].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[13].setBounds(15, 0, 210, 70);
		pn_menu_4_2.add(lb_menu_name[13]);
		
		lb_menu_x[13] = new JLabel("x");
		lb_menu_x[13].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[13].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[13].setBounds(270, 15, 30, 30);
		pn_menu_4_2.add(lb_menu_x[13]);
		
		tf_menu_qty[13] = new JTextField();
		tf_menu_qty[13].setColumns(10);
		tf_menu_qty[13].setBounds(300, 5, 70, 50);
		pn_menu_4_2.add(tf_menu_qty[13]);
		tf_menu_qty[13].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[15] = new JCheckBox("\u8D08\u9001");
		cb[15].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[15].setBackground(new Color(0, 191, 255));
		cb[15].setBounds(20, 70, 90, 30);
		pn_menu_4_2.add(cb[15]);
		
		btn_add[13] = new JButton("+");
		btn_add[13].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[13].setBounds(300, 70, 50, 30);
		pn_menu_4_2.add(btn_add[13]);
		btn_add[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[15].isSelected())
				{
					add(40);
				}else
				{
					add(41);	
				}					
			}
		});
		
		pn_menu_4_3 = new JPanel();
		pn_menu_4_3.setLayout(null);
		pn_menu_4_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4_3.setBackground(new Color(0, 191, 255));
		pn_menu_4_3.setBounds(0, 240, 390, 120);
		pn_menu_4.add(pn_menu_4_3);
		
		lb_menu_name[14] = new JLabel("\u9AD8\u8CB4\u7684\u85E5\u6C34");
		lb_menu_name[14].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[14].setBounds(15, 0, 210, 70);
		pn_menu_4_3.add(lb_menu_name[14]);
		
		lb_menu_x[14] = new JLabel("x");
		lb_menu_x[14].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[14].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[14].setBounds(270, 15, 30, 30);
		pn_menu_4_3.add(lb_menu_x[14]);
		
		tf_menu_qty[14] = new JTextField();
		tf_menu_qty[14].setColumns(10);
		tf_menu_qty[14].setBounds(300, 5, 70, 50);
		pn_menu_4_3.add(tf_menu_qty[14]);
		tf_menu_qty[14].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[16] = new JCheckBox("\u8D08\u9001");
		cb[16].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[16].setBackground(new Color(0, 191, 255));
		cb[16].setBounds(20, 70, 90, 30);
		pn_menu_4_3.add(cb[16]);
		
		btn_add[14] = new JButton("+");
		btn_add[14].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[14].setBounds(300, 70, 50, 30);
		pn_menu_4_3.add(btn_add[14]);
		btn_add[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[16].isSelected())
				{
					add(42);
				}else
				{
					add(43);	
				}					
			}
		});
		
		pn_menu_4_4 = new JPanel();
		pn_menu_4_4.setLayout(null);
		pn_menu_4_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4_4.setBackground(new Color(0, 191, 255));
		pn_menu_4_4.setBounds(0, 360, 390, 120);
		pn_menu_4.add(pn_menu_4_4);
		
		lb_menu_name[15] = new JLabel("\u5178\u96C5\u7684\u85E5\u6C34");
		lb_menu_name[15].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[15].setBounds(15, 0, 210, 70);
		pn_menu_4_4.add(lb_menu_name[15]);
		
		lb_menu_x[15] = new JLabel("x");
		lb_menu_x[15].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[15].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[15].setBounds(270, 15, 30, 30);
		pn_menu_4_4.add(lb_menu_x[15]);
		
		tf_menu_qty[15] = new JTextField();
		tf_menu_qty[15].setColumns(10);
		tf_menu_qty[15].setBounds(300, 5, 70, 50);
		pn_menu_4_4.add(tf_menu_qty[15]);
		tf_menu_qty[15].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[17] = new JCheckBox("\u8D08\u9001");
		cb[17].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[17].setBackground(new Color(0, 191, 255));
		cb[17].setBounds(20, 70, 90, 30);
		pn_menu_4_4.add(cb[17]);
		
		btn_add[15] = new JButton("+");
		btn_add[15].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[15].setBounds(300, 70, 50, 30);
		pn_menu_4_4.add(btn_add[15]);
		btn_add[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[17].isSelected())
				{
					add(44);
				}else
				{
					add(45);	
				}					
			}
		});
		
		pn_menu_4_5 = new JPanel();
		pn_menu_4_5.setLayout(null);
		pn_menu_4_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4_5.setBackground(new Color(0, 191, 255));
		pn_menu_4_5.setBounds(0, 480, 390, 120);
		pn_menu_4.add(pn_menu_4_5);
		
		lb_menu_name[16] = new JLabel("\u9B54\u6027\u7684\u85E5\u6C34");
		lb_menu_name[16].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[16].setBounds(15, 0, 210, 70);
		pn_menu_4_5.add(lb_menu_name[16]);
		
		lb_menu_x[16] = new JLabel("x");
		lb_menu_x[16].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[16].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[16].setBounds(270, 15, 30, 30);
		pn_menu_4_5.add(lb_menu_x[16]);
		
		tf_menu_qty[16] = new JTextField();
		tf_menu_qty[16].setColumns(10);
		tf_menu_qty[16].setBounds(300, 5, 70, 50);
		pn_menu_4_5.add(tf_menu_qty[16]);
		tf_menu_qty[16].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		cb[18] = new JCheckBox("\u8D08\u9001");
		cb[18].setFont(new Font("新細明體", Font.PLAIN, 20));
		cb[18].setBackground(new Color(0, 191, 255));
		cb[18].setBounds(20, 70, 90, 30);
		pn_menu_4_5.add(cb[18]);
		
		btn_add[16] = new JButton("+");
		btn_add[16].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[16].setBounds(300, 70, 50, 30);
		pn_menu_4_5.add(btn_add[16]);
		btn_add[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!cb[18].isSelected())
				{
					add(46);
				}else
				{
					add(47);	
				}					
			}
		});
		
		/* menu_5 */
		
		pn_menu_5 = new JPanel();
		pn_menu_5.setBackground(new Color(128, 128, 128));
		tab_menu.addTab("", new ImageIcon(POS.class.getResource("/pic/meum_5.png")), pn_menu_5, null);
		pn_menu_5.setLayout(null);
		
		pn_menu_5_1 = new JPanel();
		pn_menu_5_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5_1.setBackground(new Color(128, 128, 128));
		pn_menu_5_1.setBounds(0, 0, 390, 70);
		pn_menu_5.add(pn_menu_5_1);
		pn_menu_5_1.setLayout(null);
		
		lb_menu_name[17] = new JLabel("\u6BCF\u65E5\u7279\u9910");
		lb_menu_name[17].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_name[17].setBounds(10, 0, 160, 70);
		pn_menu_5_1.add(lb_menu_name[17]);
		
		lb_menu_x[17] = new JLabel("x");
		lb_menu_x[17].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[17].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[17].setBounds(190, 20, 30, 30);
		pn_menu_5_1.add(lb_menu_x[17]);
		
		tf_menu_qty[17] = new JTextField();
		tf_menu_qty[17].setBounds(220, 10, 70, 50);
		pn_menu_5_1.add(tf_menu_qty[17]);
		tf_menu_qty[17].setColumns(10);
		tf_menu_qty[17].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		btn_add[17] = new JButton("+");
		btn_add[17].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[17].setBounds(310, 20, 50, 30);
		pn_menu_5_1.add(btn_add[17]);
		btn_add[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(48);
			}
		});
		
		pn_menu_5_2 = new JPanel();
		pn_menu_5_2.setLayout(null);
		pn_menu_5_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5_2.setBackground(Color.GRAY);
		pn_menu_5_2.setBounds(0, 70, 390, 70);
		pn_menu_5.add(pn_menu_5_2);
		
		lb_menu_name[18] = new JLabel("\u5176\u4ED6-");
		lb_menu_name[18].setFont(new Font("新細明體", Font.PLAIN, 19));
		lb_menu_name[18].setBounds(10, 0, 180, 70);
		pn_menu_5_2.add(lb_menu_name[18]);
		
		lb_menu_x[18] = new JLabel("x");
		lb_menu_x[18].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[18].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[18].setBounds(190, 20, 30, 30);
		pn_menu_5_2.add(lb_menu_x[18]);
		
		tf_menu_qty[18] = new JTextField();
		tf_menu_qty[18].setColumns(10);
		tf_menu_qty[18].setBounds(220, 10, 70, 50);
		pn_menu_5_2.add(tf_menu_qty[18]);
		tf_menu_qty[18].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		btn_add[18] = new JButton("+");
		btn_add[18].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[18].setBounds(310, 20, 50, 30);
		pn_menu_5_2.add(btn_add[18]);
		btn_add[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(49);
			}
		});
		
		pn_menu_5_3 = new JPanel();
		pn_menu_5_3.setLayout(null);
		pn_menu_5_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5_3.setBackground(Color.GRAY);
		pn_menu_5_3.setBounds(0, 140, 390, 70);
		pn_menu_5.add(pn_menu_5_3);
		
		lb_menu_name[19] = new JLabel("\u5176\u4ED6-");
		lb_menu_name[19].setFont(new Font("新細明體", Font.PLAIN, 19));
		lb_menu_name[19].setBounds(10, 0, 180, 70);
		pn_menu_5_3.add(lb_menu_name[19]);
		
		lb_menu_x[19] = new JLabel("x");
		lb_menu_x[19].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[19].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[19].setBounds(190, 20, 30, 30);
		pn_menu_5_3.add(lb_menu_x[19]);
		
		tf_menu_qty[19] = new JTextField();
		tf_menu_qty[19].setColumns(10);
		tf_menu_qty[19].setBounds(220, 10, 70, 50);
		pn_menu_5_3.add(tf_menu_qty[19]);
		tf_menu_qty[19].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		btn_add[19] = new JButton("+");
		btn_add[19].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[19].setBounds(310, 20, 50, 30);
		pn_menu_5_3.add(btn_add[19]);
		btn_add[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(50);
			}
		});
		
		pn_menu_5_4 = new JPanel();
		pn_menu_5_4.setLayout(null);
		pn_menu_5_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5_4.setBackground(Color.GRAY);
		pn_menu_5_4.setBounds(0, 210, 390, 70);
		pn_menu_5.add(pn_menu_5_4);
		
		lb_menu_name[20] = new JLabel("\u5176\u4ED6-");
		lb_menu_name[20].setFont(new Font("新細明體", Font.PLAIN, 19));
		lb_menu_name[20].setBounds(10, 0, 180, 70);
		pn_menu_5_4.add(lb_menu_name[20]);
		
		lb_menu_x[20] = new JLabel("x");
		lb_menu_x[20].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[20].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[20].setBounds(190, 20, 30, 30);
		pn_menu_5_4.add(lb_menu_x[20]);
		
		tf_menu_qty[20] = new JTextField();
		tf_menu_qty[20].setColumns(10);
		tf_menu_qty[20].setBounds(220, 10, 70, 50);
		pn_menu_5_4.add(tf_menu_qty[20]);
		tf_menu_qty[20].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		btn_add[20] = new JButton("+");
		btn_add[20].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[20].setBounds(310, 20, 50, 30);
		pn_menu_5_4.add(btn_add[20]);
		btn_add[20].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(51);
			}
		});
		
		pn_menu_5_5 = new JPanel();
		pn_menu_5_5.setLayout(null);
		pn_menu_5_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5_5.setBackground(Color.GRAY);
		pn_menu_5_5.setBounds(0, 280, 390, 70);
		pn_menu_5.add(pn_menu_5_5);
		
		lb_menu_name[21] = new JLabel("\u5176\u4ED6-");
		lb_menu_name[21].setFont(new Font("新細明體", Font.PLAIN, 19));
		lb_menu_name[21].setBounds(10, 0, 180, 70);
		pn_menu_5_5.add(lb_menu_name[21]);
		
		lb_menu_x[21] = new JLabel("x");
		lb_menu_x[21].setHorizontalAlignment(SwingConstants.CENTER);
		lb_menu_x[21].setFont(new Font("新細明體", Font.PLAIN, 26));
		lb_menu_x[21].setBounds(190, 20, 30, 30);
		pn_menu_5_5.add(lb_menu_x[21]);
		
		tf_menu_qty[21] = new JTextField();
		tf_menu_qty[21].setColumns(10);
		tf_menu_qty[21].setBounds(220, 10, 70, 50);
		pn_menu_5_5.add(tf_menu_qty[21]);
		tf_menu_qty[21].setFont(new Font("新細明體", Font.PLAIN, 26));
		
		btn_add[21] = new JButton("+");
		btn_add[21].setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_add[21].setBounds(310, 20, 50, 30);
		pn_menu_5_5.add(btn_add[21]);
		btn_add[21].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(52);
			}
		});
		
		/* info */
		
		pn_info = new JPanel();
		pn_info.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8CC7\u8A0A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_info.setBounds(510, 10, 390, 130);
		fm_pos_main.getContentPane().add(pn_info);
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
		
		lb_info_order_sum = new JLabel("\u6578\u91CF :");
		lb_info_order_sum.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_info_order_sum.setBounds(20, 100, 60, 20);
		pn_info.add(lb_info_order_sum);
		
		tf_info_user_num = new JTextField();
		tf_info_user_num.setEditable(false);
		tf_info_user_num.setHorizontalAlignment(SwingConstants.CENTER);
		tf_info_user_num.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_user_num.setBounds(135, 50, 30, 20);
		pn_info.add(tf_info_user_num);
		tf_info_user_num.setColumns(10);
		
		tf_info_order_num = new JTextField();
		tf_info_order_num.setHorizontalAlignment(SwingConstants.CENTER);
		tf_info_order_num.setEditable(false);
		tf_info_order_num.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_order_num.setBounds(75, 75, 45, 20);
		pn_info.add(tf_info_order_num);
		tf_info_order_num.setColumns(10);
		
		tf_info_table = new JTextField();
		tf_info_table.setEditable(false);
		tf_info_table.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_table.setBounds(185, 73, 45, 25);
		pn_info.add(tf_info_table);
		tf_info_table.setColumns(10);
		
		tf_info_user_name = new JTextField();
		tf_info_user_name.setEditable(false);
		tf_info_user_name.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_user_name.setBounds(290, 47, 90, 25);
		pn_info.add(tf_info_user_name);
		tf_info_user_name.setColumns(10);
		
		tf_info_status = new JTextField();
		tf_info_status.setEditable(false);
		tf_info_status.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_status.setBounds(300, 73, 65, 25);
		pn_info.add(tf_info_status);
		tf_info_status.setColumns(10);
		
		tf_info_order_sum = new JTextField();
		tf_info_order_sum.setText(order_sum+"");
		tf_info_order_sum.setHorizontalAlignment(SwingConstants.CENTER);
		tf_info_order_sum.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_order_sum.setEditable(false);
		tf_info_order_sum.setBounds(75, 100, 30, 20);
		pn_info.add(tf_info_order_sum);
		tf_info_order_sum.setColumns(10);
		
		/* checkout */
		
		pn_checkout = new JPanel();
		pn_checkout.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7D50\u5E33", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_checkout.setBounds(10, 580, 880, 130);
		fm_pos_main.getContentPane().add(pn_checkout);
		pn_checkout.setLayout(null);
		
		lb_ch_small_total = new JLabel("\u5C0F\u8A08");
		lb_ch_small_total.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_ch_small_total.setBounds(70, 25, 50, 20);
		pn_checkout.add(lb_ch_small_total);
		
		lb_ch_discount = new JLabel("\u6298\u6578");
		lb_ch_discount.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_ch_discount.setBounds(15, 55, 50, 20);
		pn_checkout.add(lb_ch_discount);
		
		lb_ch_off = new JLabel("% \u6E1B\u514D -");
		lb_ch_off.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_ch_off.setBounds(115, 55, 90, 20);
		pn_checkout.add(lb_ch_off);
		
		lb_ch_all_off = new JLabel("\u7E3D\u512A\u5F85 -");
		lb_ch_all_off.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_ch_all_off.setBounds(50, 85, 80, 20);
		pn_checkout.add(lb_ch_all_off);
		
		lb_ch_total = new JLabel("\u7E3D\u91D1\u984D");
		lb_ch_total.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_ch_total.setBounds(255, 25, 70, 20);
		pn_checkout.add(lb_ch_total);
		
		lb_ch_pay = new JLabel("\u4ED8");
		lb_ch_pay.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_ch_pay.setBounds(300, 55, 25, 20);
		pn_checkout.add(lb_ch_pay);
		
		lb_ch_change = new JLabel("\u627E");
		lb_ch_change.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_ch_change.setBounds(300, 85, 25, 20);
		pn_checkout.add(lb_ch_change);
		
		tf_ch_small_total = new JTextField();
		tf_ch_small_total.setText(smalltotal+"");
		tf_ch_small_total.setEditable(false);
		tf_ch_small_total.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_ch_small_total.setFont(new Font("新細明體", Font.PLAIN, 22));
		tf_ch_small_total.setBounds(130, 25, 60, 25);
		pn_checkout.add(tf_ch_small_total);
		tf_ch_small_total.setColumns(10);
		
		tf_ch_discount = new JTextField();
		tf_ch_discount.setText("100.0");
		tf_ch_discount.setEditable(false);
		tf_ch_discount.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_ch_discount.setFont(new Font("新細明體", Font.PLAIN, 22));
		tf_ch_discount.setBounds(65, 55, 50, 25);
		pn_checkout.add(tf_ch_discount);
		tf_ch_discount.setColumns(10);
		
		tf_ch_off = new JTextField();
		tf_ch_off.setText(off+"");
		tf_ch_off.setEditable(false);
		tf_ch_off.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_ch_off.setFont(new Font("新細明體", Font.PLAIN, 22));
		tf_ch_off.setBounds(200, 55, 50, 25);
		pn_checkout.add(tf_ch_off);
		tf_ch_off.setColumns(10);
		
		tf_ch_all_off = new JTextField();
		tf_ch_all_off.setText(all_off+"");
		tf_ch_all_off.setEditable(false);
		tf_ch_all_off.setFont(new Font("新細明體", Font.PLAIN, 22));
		tf_ch_all_off.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_ch_all_off.setBounds(130, 85, 60, 25);
		pn_checkout.add(tf_ch_all_off);
		tf_ch_all_off.setColumns(10);
		
		tf_ch_total = new JTextField();
		tf_ch_total.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_ch_total.setText(total+"");
		tf_ch_total.setEditable(false);
		tf_ch_total.setFont(new Font("新細明體", Font.PLAIN, 22));
		tf_ch_total.setBounds(330, 25, 60, 25);
		pn_checkout.add(tf_ch_total);
		tf_ch_total.setColumns(10);
		
		tf_ch_pay = new JTextField();
		tf_ch_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_ch_pay.setFont(new Font("新細明體", Font.PLAIN, 22));
		tf_ch_pay.setBounds(330, 55, 60, 25);
		pn_checkout.add(tf_ch_pay);
		tf_ch_pay.setColumns(10);
		
		tf_ch_change = new JTextField();
		tf_ch_change.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_ch_change.setEditable(false);
		tf_ch_change.setFont(new Font("新細明體", Font.PLAIN, 22));
		tf_ch_change.setBounds(330, 85, 60, 25);
		pn_checkout.add(tf_ch_change);
		tf_ch_change.setColumns(10);
		
		btn_ch_chechout = new JButton("\u7D50\u5E33");
		btn_ch_chechout.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_ch_chechout.setBounds(430, 25, 90, 90);
		pn_checkout.add(btn_ch_chechout);
		btn_ch_chechout.addActionListener(this);
		
		btn_ch_off_set = new JButton("\u512A\u60E0");
		btn_ch_off_set.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_ch_off_set.setBounds(580, 25, 90, 90);
		pn_checkout.add(btn_ch_off_set);
		btn_ch_off_set.addActionListener(this);
		
		btn_ch_next = new JButton("\u4E0B\u4E00\u7B46");
		btn_ch_next.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_ch_next.setBounds(730, 25, 110, 90);
		pn_checkout.add(btn_ch_next);
		btn_ch_next.addActionListener(this);
		
		/* manage */
		
		pn_manage = new JPanel();
		pn_manage.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_manage.setBounds(510, 140, 390, 345);
		fm_pos_main.getContentPane().add(pn_manage);
		pn_manage.setLayout(null);
		
		btn_man_table = new JButton("\u684C\u4F4D\u7BA1\u7406");
		btn_man_table.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_table.setBounds(10, 20, 100, 80);
		pn_manage.add(btn_man_table);
		btn_man_table.addActionListener(this);
		
		btn_man_stock = new JButton("\u5EAB\u5B58\u7BA1\u7406");
		btn_man_stock.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_stock.setBounds(150, 20, 100, 80);
		pn_manage.add(btn_man_stock);
		btn_man_stock.addActionListener(this);
		
		btn_man_look = new JButton("\u9396\u5B9A");
		btn_man_look.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_look.setBounds(150, 100, 100, 80);
		pn_manage.add(btn_man_look);
		btn_man_look.addActionListener(this);
		
		btn_man_exit = new JButton("\u96E2\u958B");
		btn_man_exit.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_exit.setBounds(280, 20, 100, 160);
		pn_manage.add(btn_man_exit);
		btn_man_exit.addActionListener(this);
		
		btn_man_clear = new JButton("\u5168\u90E8\u6E05\u9664");
		btn_man_clear.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_clear.setBounds(10, 100, 100, 80);
		pn_manage.add(btn_man_clear);
		btn_man_clear.addActionListener(this);
		
		btn_man_menu_5_set = new JButton("\u5176\u4ED6\u985E \u8A2D\u5B9A");
		btn_man_menu_5_set.addActionListener(this);
		btn_man_menu_5_set.setFont(new Font("新細明體", Font.PLAIN, 13));
		btn_man_menu_5_set.setBounds(10, 260, 100, 80);
		pn_manage.add(btn_man_menu_5_set);
		
		btn_man_re_print = new JButton("\u518D\u5217\u5370");
		btn_man_re_print.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_re_print.setBounds(10, 180, 100, 80);
		pn_manage.add(btn_man_re_print);
		
		btn_man_printer_set = new JButton("\u5370\u8868\u6A5F\u8A2D\u5B9A");
		btn_man_printer_set.setFont(new Font("新細明體", Font.PLAIN, 13));
		btn_man_printer_set.setBounds(150, 180, 100, 80);
		pn_manage.add(btn_man_printer_set);
		
		btn_man_order_num_reset = new JButton("\u55AE\u865F\u91CD\u8A2D");
		btn_man_order_num_reset.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_order_num_reset.setBounds(280, 180, 100, 80);
		pn_manage.add(btn_man_order_num_reset);
		btn_man_order_num_reset.addActionListener(this);
		
		/* menu */
		for(int i=0;i<22;i++)
			tf_menu_qty[i].setText("1");
		/* item set */
		
		for(int i=0; i<53; i++)
		{
			pn_item[i]=new JPanel();
			pn_item[i].setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			if(i<24)
			    pn_item[i].setBackground(new Color(255, 182, 193));
			else if(i<28)
				pn_item[i].setBackground(Color.YELLOW);
			else if(i<38)
				pn_item[i].setBackground(new Color(154, 205, 50));
			else if(i<48)
				pn_item[i].setBackground(new Color(0, 191, 255));
			else 
				pn_item[i].setBackground(new Color(128, 128, 128));
			
			pn_item[i].setLayout(null);
			pn_item[i].setSize(470, 70);
			
			lb_item_name[i]= new JLabel(item_name[i]);
			lb_item_name[i].setFont(new Font("新細明體", Font.BOLD, 26));
			lb_item_name[i].setBounds(10, 20, 255, 30);
			pn_item[i].add(lb_item_name[i]);
			
			lb_x[i] = new JLabel("x");
			lb_x[i].setBounds(270, 25, 15, 20);
			lb_x[i].setFont(new Font("新細明體", Font.BOLD, 20));
			pn_item[i].add(lb_x[i]);
			
			lb_e[i] = new JLabel("=");
			lb_e[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			lb_e[i].setBounds(325, 25, 20, 20);
			pn_item[i].add(lb_e[i]);
			
			lb_qty[i]= new JLabel("0");
			lb_qty[i].setFont(new Font("新細明體", Font.PLAIN, 26));
			lb_qty[i].setBounds(290, 25, 30, 20);
			pn_item[i].add(lb_qty[i]);
			
			lb_small_total[i]= new JLabel("0");
			lb_small_total[i].setFont(new Font("新細明體", Font.BOLD, 26));
			lb_small_total[i].setBounds(348, 25, 55, 20);
			pn_item[i].add(lb_small_total[i]);
			
			btn_del[i]= new JButton("-");
			btn_del[i].setFont(new Font("新細明體", Font.BOLD, 26));
			btn_del[i].setBounds(405, 20, 60, 40);
			pn_item[i].add(btn_del[i]);
			btn_del[i].addActionListener(this);
					
		}
		
		/* fm_man_table */
		
		fm_man_table = new JFrame();
		fm_man_table.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/Madhouse.png")));
		fm_man_table.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		fm_man_table.setTitle("Madhouse POS-桌位管理");
		fm_man_table.setResizable(false);
		fm_man_table.setBounds(247, 80, 1005, 790);
		fm_man_table.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fm_man_table.getContentPane().setLayout(null);
		fm_man_table.setVisible(false);
		
		for(int i=0;i<16;i++)
		{
			pn_table_inside[i] = new JPanel();
			fm_man_table.getContentPane().add(pn_table_inside[i]);
			pn_table_inside[i].setLayout(null);
			pn_table_inside[i].setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			
			lb_table_inside_tablenum[i] = new JLabel(i+1+"");
			lb_table_inside_tablenum[i].setBounds(10, 10, 40, 40);
			lb_table_inside_tablenum[i].setFont(new Font("新細明體", Font.PLAIN, 40));
			pn_table_inside[i].add(lb_table_inside_tablenum[i]);
			
			lb_table_inside_ordernum[i] = new JLabel("\u55AE\u865F : ");
			lb_table_inside_ordernum[i].setBounds(65, 40, 60, 20);
			lb_table_inside_ordernum[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			pn_table_inside[i].add(lb_table_inside_ordernum[i]);
			
			lb_table_inside_status[i] = new JLabel("\u72C0\u614B : ");
			lb_table_inside_status[i].setBounds(55, 65, 60, 20);
			lb_table_inside_status[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			pn_table_inside[i].add(lb_table_inside_status[i]);
			
			tf_table_inside_ordernum[i] = new JTextField();
			tf_table_inside_ordernum[i].setEditable(false);
			tf_table_inside_ordernum[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			tf_table_inside_ordernum[i].setBounds(120, 40, 35, 25);
			pn_table_inside[i].add(tf_table_inside_ordernum[i]);
			tf_table_inside_ordernum[i].setColumns(10);
			
			tf_table_inside_status[i] = new JTextField();
			tf_table_inside_status[i].setEditable(false);
			tf_table_inside_status[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			tf_table_inside_status[i].setBounds(115, 65, 65, 30);
			pn_table_inside[i].add(tf_table_inside_status[i]);
			tf_table_inside_status[i].setColumns(10);
			
			btn_table_inside_new[i] = new JButton("\u65B0\u55AE");
			btn_table_inside_new[i].setHorizontalAlignment(SwingConstants.LEFT);
			btn_table_inside_new[i].setFont(new Font("新細明體", Font.PLAIN, 19));
			btn_table_inside_new[i].setBounds(10, 100, 70, 40);
			pn_table_inside[i].add(btn_table_inside_new[i]);
			btn_table_inside_new[i].addActionListener(this);
			
			btn_table_inside_out[i] = new JButton("\u9910\u7562");
			btn_table_inside_out[i].setHorizontalAlignment(SwingConstants.LEFT);
			btn_table_inside_out[i].setFont(new Font("新細明體", Font.PLAIN, 19));
			btn_table_inside_out[i].setBounds(80, 100, 70, 40);
			pn_table_inside[i].add(btn_table_inside_out[i]);
			btn_table_inside_out[i].addActionListener(this);
			
			btn_table_inside_end[i] = new JButton("\u5B8C\u6210");
			btn_table_inside_end[i].setHorizontalAlignment(SwingConstants.LEFT);
			btn_table_inside_end[i].setFont(new Font("新細明體", Font.PLAIN, 19));
			btn_table_inside_end[i].setBounds(150, 100, 70, 40);
			pn_table_inside[i].add(btn_table_inside_end[i]);
			btn_table_inside_end[i].addActionListener(this);
			
		}
		
		pn_table_inside[0].setBounds(0, 0, 250, 150);
		pn_table_inside[1].setBounds(250, 0, 250, 150);
		pn_table_inside[2].setBounds(500, 0, 250, 150);
		pn_table_inside[3].setBounds(750, 0, 250, 150);
		pn_table_inside[4].setBounds(0, 150, 250, 150);
		pn_table_inside[5].setBounds(250, 150, 250, 150);
		pn_table_inside[6].setBounds(500, 150, 250, 150);
		pn_table_inside[7].setBounds(750, 150, 250, 150);
		pn_table_inside[8].setBounds(0, 300, 250, 150);
		pn_table_inside[9].setBounds(250, 300, 250, 150);
		pn_table_inside[10].setBounds(500, 300, 250, 150);
		pn_table_inside[11].setBounds(750, 300, 250, 150);
		pn_table_inside[12].setBounds(0, 450, 250, 150);
		pn_table_inside[13].setBounds(250, 450, 250, 150);
		pn_table_inside[14].setBounds(500, 450, 250, 150);
		pn_table_inside[15].setBounds(750, 450, 250, 150);
		
		pn_table_outside = new JPanel();
		pn_table_outside.setBounds(0, 600, 250, 150);
		fm_man_table.getContentPane().add(pn_table_outside);
		pn_table_outside.setLayout(null);
		pn_table_outside.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		lb_table_outside_tablenum = new JLabel("\u5916\u5E36");
		lb_table_outside_tablenum.setFont(new Font("新細明體", Font.PLAIN, 40));
		lb_table_outside_tablenum.setBounds(10, 10, 85, 40);
		pn_table_outside.add(lb_table_outside_tablenum);
		
		btn_table_outside_new = new JButton("\u65B0\u55AE");
		btn_table_outside_new.setHorizontalAlignment(SwingConstants.LEFT);
		btn_table_outside_new.setFont(new Font("新細明體", Font.PLAIN, 19));
		btn_table_outside_new.setBounds(80, 100, 70, 40);
		pn_table_outside.add(btn_table_outside_new);
		btn_table_outside_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				now_status=0;
				tf_info_status.setText("新單");
				now_tablenum=17;
				tf_info_table.setText("外帶");
				fm_man_table.dispose();
			}
		});
		
		btn_table_exit = new JButton("\u96E2\u958B");
		btn_table_exit.setFont(new Font("新細明體", Font.PLAIN, 50));
		btn_table_exit.setBounds(750, 600, 250, 150);
		fm_man_table.getContentPane().add(btn_table_exit);
		btn_table_exit.addActionListener(this);
		
		btn_table_all_reset = new JButton("全部重設");
		btn_table_all_reset.setFont(new Font("新細明體", Font.PLAIN, 50));
		btn_table_all_reset.setBounds(250, 600, 250, 150);
		fm_man_table.getContentPane().add(btn_table_all_reset);
		btn_table_all_reset.addActionListener(this);
		
		/* discount */
		
		fm_discount = new JFrame();
		fm_discount.setTitle("Madhouse POS-\u512A\u60E0");
		fm_discount.setResizable(false);
		fm_discount.setBounds(670, 405, 160, 140);
		fm_discount.getContentPane().setLayout(null);
		fm_discount.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/Madhouse.png")));
		fm_discount.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		fm_discount.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fm_discount.setVisible(false);
		
		lb_discount_discount = new JLabel("\u6298\u6578 :              %");
		lb_discount_discount.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_discount_discount.setBounds(10, 10, 140, 20);
		fm_discount.getContentPane().add(lb_discount_discount);
		
		lb_discount_off = new JLabel("\u6E1B\u514D : -           \u5143");
		lb_discount_off.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_discount_off.setBounds(10, 40, 140, 20);
		fm_discount.getContentPane().add(lb_discount_off);
		
		tf_discount_discount = new JTextField();
		tf_discount_discount.setFont(new Font("新細明體", Font.PLAIN, 20));
		tf_discount_discount.setBounds(75, 10, 50, 25);
		fm_discount.getContentPane().add(tf_discount_discount);
		tf_discount_discount.setColumns(10);
		tf_discount_discount.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_discount_discount.setText("100.0");
		
		tf_discount_off = new JTextField();
		tf_discount_off.setFont(new Font("新細明體", Font.PLAIN, 20));
		tf_discount_off.setBounds(75, 40, 50, 25);
		fm_discount.getContentPane().add(tf_discount_off);
		tf_discount_off.setColumns(10);
		tf_discount_off.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btn_discount_ok = new JButton("\u78BA\u5B9A");
		btn_discount_ok.setFont(new Font("PMingLiU", Font.PLAIN, 15));
		btn_discount_ok.setBounds(10, 70, 65, 25);
		fm_discount.getContentPane().add(btn_discount_ok);
		btn_discount_ok.addActionListener(this);
		
		btn_discount_cancel = new JButton("\u53D6\u6D88");
		btn_discount_cancel.setBounds(75, 70, 65, 25);
		fm_discount.getContentPane().add(btn_discount_cancel);
		btn_discount_cancel.addActionListener(this);
		
		/* menu5_set */
		
		fm_man_menu_5_set = new JFrame();
		fm_man_menu_5_set.setTitle("Madhouse POS-\u5176\u4ED6\u985E\u83DC\u55AE\u8A2D\u5B9A");
		fm_man_menu_5_set.setResizable(false);
		fm_man_menu_5_set.setBounds(600, 345, 300, 260);
		fm_man_menu_5_set.getContentPane().setLayout(null);
		fm_man_menu_5_set.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/Madhouse.png")));
		fm_man_menu_5_set.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		fm_man_menu_5_set.setVisible(false);
		fm_man_menu_5_set.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		lb_manu5_set_name = new JLabel("\u54C1\u540D");
		lb_manu5_set_name.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_manu5_set_name.setBounds(95, 10, 45, 20);
		fm_man_menu_5_set.getContentPane().add(lb_manu5_set_name);
		
		lb_menu5_set_price = new JLabel("\u55AE\u50F9");
		lb_menu5_set_price.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_menu5_set_price.setBounds(238, 10, 45, 20);
		fm_man_menu_5_set.getContentPane().add(lb_menu5_set_price);
		
		for(int i=0;i<5;i++)
		{
			tf_menu5_set_name[i] = new JTextField();
			tf_menu5_set_name[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			fm_man_menu_5_set.getContentPane().add(tf_menu5_set_name[i]);
			tf_menu5_set_name[i].setColumns(10);
			if(i==0)
			{
				tf_menu5_set_name[i].setText("\u6BCF\u65E5\u7279\u9910");
				tf_menu5_set_name[i].setEditable(false);
			}
		}
		for(int i=0;i<5;i++)
		{
			tf_menu5_set_price[i] = new JTextField();
			tf_menu5_set_price[i].setHorizontalAlignment(SwingConstants.RIGHT);
			fm_man_menu_5_set.getContentPane().add(tf_menu5_set_price[i]);
			tf_menu5_set_price[i].setColumns(10);
			tf_menu5_set_price[i].setFont(new Font("新細明體", Font.PLAIN, 20));
		}
		
		tf_menu5_set_name[0].setBounds(10, 35, 215, 27);
		tf_menu5_set_name[1].setBounds(10, 65, 215, 27);
		tf_menu5_set_name[2].setBounds(10, 95, 215, 27);
		tf_menu5_set_name[3].setBounds(10, 125, 215, 27);
		tf_menu5_set_name[4].setBounds(10, 155, 215, 27);
		tf_menu5_set_price[0].setBounds(235, 35, 50, 27);
		tf_menu5_set_price[1].setBounds(235, 65, 50, 27);
		tf_menu5_set_price[2].setBounds(235, 95, 50, 27);
		tf_menu5_set_price[3].setBounds(235, 125, 50, 27);
		tf_menu5_set_price[4].setBounds(235, 155, 50, 27);
		
		btn_menu5_set_ok = new JButton("\u78BA\u5B9A");
		btn_menu5_set_ok.setFont(new Font("新細明體", Font.PLAIN, 20));
		btn_menu5_set_ok.setBounds(48, 190, 75, 30);
		fm_man_menu_5_set.getContentPane().add(btn_menu5_set_ok);
		btn_menu5_set_ok.addActionListener(this);
		
		btn_menu5_set_cancel = new JButton("\u53D6\u6D88");
		btn_menu5_set_cancel.setFont(new Font("新細明體", Font.PLAIN, 20));
		btn_menu5_set_cancel.setBounds(171, 190, 75, 30);
		fm_man_menu_5_set.getContentPane().add(btn_menu5_set_cancel);
		btn_menu5_set_cancel.addActionListener(this);
		
		/* stock */
		
		fm_stock = new JFrame();
		fm_stock.setTitle("Madhouse POS-庫存管理");
		fm_stock.setResizable(false);
		fm_stock.setBounds(100, 100, 990, 575);
		fm_stock.getContentPane().setLayout(null);
		fm_stock.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/Madhouse.png")));
		fm_stock.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		fm_stock.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fm_stock.setVisible(false);
		
		pn_stock = new JPanel();
		pn_stock.setBackground(Color.WHITE);
		pn_stock.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_stock.setBounds(10, 40, 975, 455);
		fm_stock.add(pn_stock);
		pn_stock.setLayout(null);	
		
		lb_stock_title1 = new JLabel("\u9805\u76EE");
		lb_stock_title1.setForeground(Color.BLUE);
		lb_stock_title1.setBounds(20, 10, 45, 25);
		lb_stock_title1.setFont(new Font("新細明體", Font.PLAIN, 20));
		fm_stock.add(lb_stock_title1);
		
		lb_stock_title2 = new JLabel("\u55AE\u4F4D");
		lb_stock_title2.setBounds(275, 10, 45, 25);
		lb_stock_title2.setFont(new Font("新細明體", Font.PLAIN, 20));
		fm_stock.add(lb_stock_title2);
		lb_stock_title2.setForeground(Color.BLUE);
		
		lb_stock_title3 = new JLabel("\u5EAB\u5B58");
		lb_stock_title3.setBounds(355, 10, 45, 25);
		lb_stock_title3.setFont(new Font("新細明體", Font.PLAIN, 20));
		fm_stock.add(lb_stock_title3);
		lb_stock_title3.setForeground(Color.BLUE);
		
		lb_stock_title4 = new JLabel("\u8ABF\u6574");
		lb_stock_title4.setBounds(429, 10, 45, 25);
		lb_stock_title4.setFont(new Font("新細明體", Font.PLAIN, 20));
		fm_stock.add(lb_stock_title4);
		lb_stock_title4.setForeground(Color.BLUE);
		
		lb_stock_title5 = new JLabel("\u9805\u76EE");
		lb_stock_title5.setForeground(Color.BLUE);
		lb_stock_title5.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_stock_title5.setBounds(520, 10, 45, 25);
		fm_stock.add(lb_stock_title5);
		
		lb_stock_title6 = new JLabel("\u55AE\u4F4D");
		lb_stock_title6.setForeground(Color.BLUE);
		lb_stock_title6.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_stock_title6.setBounds(775, 10, 45, 25);
		fm_stock.add(lb_stock_title6);
		
		lb_stock_title7 = new JLabel("\u5EAB\u5B58");
		lb_stock_title7.setForeground(Color.BLUE);
		lb_stock_title7.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_stock_title7.setBounds(855, 10, 45, 25);
		fm_stock.add(lb_stock_title7);
		
		lb_stock_title8 = new JLabel("\u8ABF\u6574");
		lb_stock_title8.setForeground(Color.BLUE);
		lb_stock_title8.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_stock_title8.setBounds(929, 10, 45, 25);
		fm_stock.add(lb_stock_title8);
		
		btn_stock_exit = new JButton("\u96E2\u958B");
		btn_stock_exit.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_stock_exit.setBounds(885, 500, 87, 40);
		fm_stock.add(btn_stock_exit);
		btn_stock_exit.addActionListener(this);
		
		btn_stock_reset = new JButton("\u6B78\u96F6");
		btn_stock_reset.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_stock_reset.setBounds(795, 500, 87, 40);
		fm_stock.add(btn_stock_reset);
		btn_stock_reset.addActionListener(this);
		
		btn_stock_replace = new JButton("\u53D6\u4EE3");
		btn_stock_replace.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_stock_replace.setBounds(705, 500, 87, 40);
		fm_stock.add(btn_stock_replace);
		btn_stock_replace.addActionListener(this);
		
		btn_stock_revise = new JButton("\u8ABF\u6574");
		btn_stock_revise.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_stock_revise.setBounds(615, 500, 87, 40);
		fm_stock.add(btn_stock_revise);
		btn_stock_revise.addActionListener(this);
		
		for(int i=0;i<30;i++)
		{
			lb_stock_item[i] = new JLabel("");
			lb_stock_item[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			pn_stock.add(lb_stock_item[i]);
			
			lb_stock_unit[i] = new JLabel("");
			lb_stock_unit[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			pn_stock.add(lb_stock_unit[i]);
			
			lb_stock_qty[i] = new JLabel("");
			lb_stock_qty[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			pn_stock.add(lb_stock_qty[i]);
			
			tf_stock_input[i] = new JTextField();
			tf_stock_input[i].setFont(new Font("新細明體", Font.PLAIN, 20));
			pn_stock.add(tf_stock_input[i]);
			tf_stock_input[i].setColumns(10);
			
			if(i<15)
			{
				lb_stock_item[i].setBounds(10, 5+i*30, 230, 25);
				lb_stock_unit[i].setBounds(265, 5+i*30, 50, 25);
				lb_stock_qty[i].setBounds(345, 5+i*30, 50, 25);
				tf_stock_input[i].setBounds(420, 5+i*30, 50, 25);
			}
			else
			{
				int j=i-15;
				lb_stock_item[i].setBounds(505, 5+j*30, 230, 25);
				lb_stock_unit[i].setBounds(760, 5+j*30, 50, 25);
				lb_stock_qty[i].setBounds(840, 5+j*30, 50, 25);
				tf_stock_input[i].setBounds(915, 5+j*30, 50, 25);
			}
		}
		
	}
	void add(int i) {
		boolean ok=true;
		String str1="";
		String str2="";
		for(int y=0;y<ingredients_sum[i];y++)
		{
			if(stocklist_qty[ingredients[i][y]]-Integer.parseInt(tf_menu_qty[change(i)].getText())<5 && stocklist_qty[ingredients[i][y]]-Integer.parseInt(tf_menu_qty[change(i)].getText())>=0)
				//JOptionPane.showMessageDialog(null, stocklist_name[ingredients[i][y]]+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
				str1=str1+stocklist_name[ingredients[i][y]]+"\n";
			if(stocklist_qty[ingredients[i][y]]-Integer.parseInt(tf_menu_qty[change(i)].getText())<0)
			{
				//JOptionPane.showMessageDialog(null, stocklist_name[ingredients[i][y]]+"庫存量不足!!", "錯誤", JOptionPane.ERROR_MESSAGE);
				str2=str2+stocklist_name[ingredients[i][y]]+"\n";
				ok=false;
			}
		}
		if(ok==false)
		{
			JOptionPane.showMessageDialog(null, item_name[i]+"無法製作!!\n原因:\n"+str2+"庫存量不足!!", "錯誤", JOptionPane.ERROR_MESSAGE);
		}
		else{
			if(!str1.equals(""))
				JOptionPane.showMessageDialog(null, str1+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
			for(int j=0;j<Integer.parseInt(tf_menu_qty[change(i)].getText());j++)
				ingredients_del(i);
			if(isOrder[i]==false && qty[i]==0)
				isOrder[i]=true;
			qty[i]+=Integer.parseInt(tf_menu_qty[change(i)].getText());
			small_total[i]=qty[i]*price[i];
			lb_qty[i].setText(qty[i]+"");
			lb_small_total[i].setText(small_total[i]+"");
			smalltotal+=Integer.parseInt(tf_menu_qty[change(i)].getText())*price[i];
			tf_ch_small_total.setText(smalltotal+"");
			order_sum+=Integer.parseInt(tf_menu_qty[change(i)].getText());
			tf_info_order_sum.setText(order_sum+"");
			total();
			if(isOrder[i]==true)
			{
				order_list_sum++;
				list[order_list_sum-1]=i;
				sort();
			}
			isOrder[i]=false;
			tab_order_list.updateUI();
		}
	}
	void del(int i) {
			try{
				ingredients_add(i);
				qty[i]--;
				small_total[i]=qty[i]*price[i];
				lb_qty[i].setText(qty[i]+"");
				lb_small_total[i].setText(small_total[i]+"");
				smalltotal-=price[i];
				tf_ch_small_total.setText(smalltotal+"");
				order_sum--;
				tf_info_order_sum.setText(order_sum+"");
				total();
				if(qty[i]==0)
				{
					int k=0;
					for(int n=0;n<40;n++)
					{
						if(list[n]==i){
							list[n]=-1;
							k=n;
							break;
						}
					}
					order_list_sum--;
					if(order_list_sum!=0 && list[k+1]!=-1)
					{
						for(int e=k;e<order_list_sum+1;e++)
						{
							if(list[k+1]!=-1)
							{
								tmp=list[e+1];
								list[e]=tmp;
							}
							else
								break;
						}
						//list[order_list_sum]=-1;
					}
					sort();
				}
			}catch(Exception e){}
	}
	void sort()  {
		try{
//		tab_order_list.removeAll();
//		pn_list_1.removeAll();
//		pn_list_2.removeAll();
//		pn_list_3.removeAll();
//		pn_list_4.removeAll();
//		pn_list_5.removeAll();
//		tab_order_list.addTab("1", null, pn_list_1, null);
//		tab_order_list.addTab("2", null, pn_list_2, null);
//		tab_order_list.addTab("3", null, pn_list_3, null);
//		tab_order_list.addTab("4", null, pn_list_4, null);
//		tab_order_list.addTab("5", null, pn_list_5, null);
		//n=0;
		/*for(int i=0;i<order_list_sum;i++)
		{
			if(list[i]!=-1)
				n++;
			else
				break;
		}*/
		try{
		for(int a=0;a<53;a++)
		{
			pn_item[a].setVisible(false);
		}
		}catch(ArrayIndexOutOfBoundsException e10){}
		tab_order_list.updateUI();
		if(order_list_sum!=0)
		{
			item_sum2=0;
			for(int j=0;j<order_list_sum;j++)
			{
				pn_item[list[j]].setVisible(true);
				item_sum2++;
				if(item_sum2<=8)
				{
					pn_item[list[j]].setLocation(0, (item_sum2-1)*70);
					pn_list_1.add(pn_item[list[j]]);
					tab_order_list.setSelectedIndex(0);
				}else if(item_sum2<=16)
				{
					pn_item[list[j]].setLocation(0, (item_sum2-9)*70);
					pn_list_2.add(pn_item[list[j]]);
					tab_order_list.setSelectedIndex(1);
				}else if(item_sum2<=24)
				{
					pn_item[list[j]].setLocation(0, (item_sum2-17)*70);
					pn_list_3.add(pn_item[list[j]]);
					tab_order_list.setSelectedIndex(2);
				}else if(item_sum2<=32)
				{
					pn_item[list[j]].setLocation(0, (item_sum2-25)*70);
					pn_list_4.add(pn_item[list[j]]);
					tab_order_list.setSelectedIndex(3);
				}else if(item_sum2<40)
				{
					pn_item[list[j]].setLocation(0, (item_sum2-33)*70);
					pn_list_5.add(pn_item[list[j]]);
					tab_order_list.setSelectedIndex(4);
				}else if(item_sum2>=40)
				{
					pn_item[list[j]].setLocation(0, (item_sum2-33)*70);
					pn_list_5.add(pn_item[list[j]]);
					tab_order_list.setSelectedIndex(4);
					check_list_full();
				}
			}
			tab_order_list.updateUI();
		}
		}catch(Exception e){}
	}
	void total()
	{
		total=smalltotal*(discount/100)-off;
		tf_ch_total.setText(total+"");
	}
	void check_list_full() {
		
		if(item_sum2>=40)
		{
			for(int i=0;i<22;i++)
			{
				btn_add[i].setEnabled(false);
				tf_menu_qty[i].setEnabled(false);
			}
			for(int i=0;i<19;i++)
				cb[i].setEnabled(false);
		}
		else
		{
			for(int i=0;i<22;i++)
			{
				btn_add[i].setEnabled(true);
				tf_menu_qty[i].setEnabled(true);
			}
			for(int i=0;i<19;i++)
				cb[i].setEnabled(true);
		}
	}
	int change(int i)
	{
		int j = 0;
		if(i<8)
			j=0;
		else if(i<16)
			j=1;
		else if(i<24)
			j=2;
		else if(i>=24 && i<28)
			j=i-21;
		else if(i==28 || i==29)
			j=7;
		else if(i==30 || i==31)
			j=8;
		else if(i==32 || i==33)
			j=9;
		else if(i==34 || i==35)
			j=10;
		else if(i==36 || i==37)
			j=11;
		else if(i==38|| i==39)
			j=12;
		else if(i==40 || i==41)
			j=13;
		else if(i==42 || i==43)
			j=14;	
		else if(i==44 || i==45)
			j=15;
		else if(i==46 || i==47)
			j=16;
		else if(i>=48 || i<53)
			j=i-31;
		return j;
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
	void check_order_num()
	{
		if(order_num>999)
		{
			order_num=1;
			tf_info_order_num.setText(order_num+"");
			Date d=new Date();
			SimpleDateFormat  sdf2=new SimpleDateFormat("yyyyMMdd");
			String r_time2=sdf2.format(d);
			try{
				bw_system=new BufferedWriter(new FileWriter(f_system.getAbsolutePath()));
				bw_system.write(r_time2+","+order_num);
				bw_system.flush();
			}catch(Exception e1){}
			file();
		}
	}
	void reset()
	{
		pay=0;
		change=0;
		order_sum=0;
		smalltotal=0;
		off=0;
		all_off=0;
		total=0;
		discount=100;
		item_sum2=0;
		order_list_sum=0;
		m=0;
		n=0;
		tmp=-1;
		tf_ch_pay.setText("");
		tf_ch_change.setText("");
		tf_info_order_sum.setText(order_sum+"");
		tf_ch_small_total.setText(smalltotal+"");
		tf_ch_off.setText(off+"");
		tf_ch_all_off.setText(all_off+"");
		tf_ch_total.setText(total+"");
		tf_ch_discount.setText(discount+"");
		tf_note.setText("");
		tab_order_list.setSelectedIndex(0);
		tab_menu.setSelectedIndex(0);
		for(int i=0;i<40;i++)
			list[i]=-1;
		for(int j=0;j<53;j++)
		{
			isOrder[j]=false;
			qty[j]=0;
			small_total[j]=0;
		}
		for(int k=0;k<19;k++)
			cb[k].setSelected(false);
		for(int a=0;a<22;a++)
			tf_menu_qty[a].setText("1");
		check_list_full();
		sort();
	}
	void file()
	{
		
		Date d=new Date();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMM"), sdf2=new SimpleDateFormat("yyyyMMdd");
		String r_time1=sdf1.format(d), r_time2=sdf2.format(d);
		
		/* login */
		
		f_login=new File("C:/Madhouse POS/system/system_login.csv");
		if(!f_login.exists())
		{
			try{
				f_login.getParentFile().mkdirs();
				bw_login=new BufferedWriter(new FileWriter(f_login.getAbsolutePath()));
				bw_login.write("0,admin,admin,管理員");
				bw_login.newLine();
				bw_login.flush();
			}catch(Exception e1){}
		}
		
		/* ordernum */
		
		f_system=new File("C:/Madhouse POS/system/system.csv");
		if(!f_system.exists())
		{
			try{
				f_system.getParentFile().mkdirs();
				bw_system=new BufferedWriter(new FileWriter(f_system.getAbsolutePath()));
				bw_system.write(r_time2+",1");
				bw_system.newLine();
				bw_system.flush();
				order_num=1;
				tf_info_order_num.setText(order_num+"");
			}catch(Exception e){}
		}else
		{
			try{
	            br_system=new BufferedReader(new FileReader(f_system.getAbsolutePath()));
	            String str[]=br_system.readLine().split(",");
	            br_system.close();
	    		if(str[0].equals(r_time2))
				{
	    			order_num=Integer.parseInt(str[1]);
				}else
				{
					bw_system=new BufferedWriter(new FileWriter(f_system.getAbsolutePath()));
					bw_system.write(r_time2+",1");
					bw_system.flush();
					bw_system.close();
					order_num=1;
				}
	    		tf_info_order_num.setText(order_num+"");
			}catch(Exception e){}	
		}
		
		/* meals */
		
		f_system_meals=new File("C:/Madhouse POS/system/system_meals.csv");
		if(!f_system_meals.exists())
		{
			try{
				f_system_meals.getParentFile().mkdirs();
				bw_system_meals=new BufferedWriter(new FileWriter(f_system_meals.getAbsolutePath()));
				for(int i=0; i<53; i++)
				{
					bw_system_meals.write(default_item_name[i]+","+default_price[i]);
					bw_system_meals.newLine();
					item_name[i]=default_item_name[i];
					price[i]=default_price[i];
				}
				bw_system_meals.flush();
			}catch(Exception e){}
		}else
		{
			try{
	            for(int i=0;i<53;i++)
	            {
	            	br_system_meals=new BufferedReader(new FileReader(f_system_meals.getAbsolutePath()));
	            	String [] meals_record;
	            	int lines = 0;
		    		while (oldRecord_meals != null) {
		    			oldRecord_meals = br_system_meals.readLine();
		    			if (lines == i) {
		    				meals_record=oldRecord_meals.split(",");
		    				item_name[i]=meals_record[0];
		    				price[i]=Integer.parseInt(meals_record[1]);
		    			}
		    			lines++;
		    		}
		    		oldRecord_meals="";
		    		br_system_meals.close();
		    		lb_item_name[i].setText(item_name[i]);
    				if(i==0 || i==8 || i==16 || i==24 || i==25 || i==26 || i==27 || i==28 || i==30 || i==32 || i==34 || i==36 || i==40 || i==42 || i==44 || i==46 || i==48 || i==49 || i==50 || i==51 || i==52 || i==53)
    					lb_menu_name[change(i)].setText(item_name[i]);
    				pn_item[i].updateUI();
    				tab_menu.updateUI();
	            }
			}catch(Exception e){}	
		}
		
		/* menu_option */
		
		f_system_option=new File("C:/Madhouse POS/system/system_option.csv");
		if(!f_system_option.exists())
		{
			try{
				f_system_option.getParentFile().mkdirs();
				bw_system_option=new BufferedWriter(new FileWriter(f_system_option.getAbsolutePath()));
				for(int i=0; i<19; i++)
				{
					bw_system_option.write(default_option1[i]+","+default_option2[i]);
					bw_system_option.newLine();
					cb[i].setText(default_option2[i]);
				}
				bw_system_option.flush();
			}catch(Exception e){}
		}else
		{
			try{
	            for(int i=0;i<19;i++)
	            {
	            	br_system_option=new BufferedReader(new FileReader(f_system_option.getAbsolutePath()));
	            	String [] option_record;
	            	int lines = 0;
		    		while (oldRecord_option != null) {
		    			oldRecord_option = br_system_option.readLine();
		    			if (lines == i) {
		    				option_record=oldRecord_option.split(",");
		    				cb[i].setText(option_record[1]);
		    			}
		    			lines++;
		    		}
		    		oldRecord_option="";
		    		br_system_option.close();
    				tab_menu.updateUI();
	            }
			}catch(Exception e){}	
		}
		
		/* menu5 */
		
		f_system_menu5=new File("C:/Madhouse POS/system/system_menu5.csv");
		if(!f_system_menu5.exists())
		{
			try{
				f_system_menu5.getParentFile().mkdirs();
				bw_system_menu5=new BufferedWriter(new FileWriter(f_system_menu5.getAbsolutePath()));
				bw_system_menu5.write("每日特餐,0");
				bw_system_menu5.newLine();
				bw_system_menu5.write(",0");
				bw_system_menu5.newLine();
				bw_system_menu5.write(",0");
				bw_system_menu5.newLine();
				bw_system_menu5.write(",0");
				bw_system_menu5.newLine();
				bw_system_menu5.write(",0");
				bw_system_menu5.newLine();
				bw_system_menu5.flush();
				for(int i=0;i<5;i++)
				{
					if(i==0)
						menu5_name[i]="每日特餐";
					else
						menu5_name[i]="";
					menu5_price[i]=0;
				}
			}catch(Exception e){}
		}else
		{
			try{
	            for(int i=0;i<5;i++)
	            {
	            	br_system_menu5=new BufferedReader(new FileReader(f_system_menu5.getAbsolutePath()));
	            	String [] menu5_record;
	            	int lines = 0;
		    		while (oldRecord_menu5 != null) {
		    			oldRecord_menu5 = br_system_menu5.readLine();
		    			if (lines == i) {
		    				menu5_record=oldRecord_menu5.split(",");
	    					menu5_name[i]=menu5_record[0];
	    					menu5_price[i]=Integer.parseInt(menu5_record[1]);
	    					if(!menu5_record[1].equals(""))
	    						menu5_price[i]=Integer.parseInt(menu5_record[1]);
	    					else
	    						menu5_price[i]=0;
		    			}
		    			lines++;
		    		}
		    		oldRecord_menu5="";
		    		br_system_menu5.close();
		    		price[i+48]=menu5_price[i];
		    		if(i!=0)
		    		{
		    			lb_item_name[i+48].setText("其他-"+menu5_name[i]);
		    			lb_menu_name[i+17].setText("其他-"+menu5_name[i]);
		    		}
	            }
	            tab_menu.updateUI();
	    		tab_order_list.updateUI();
			}catch(Exception e){}	
		}
		
		/* table */
		
		f_system_table=new File("C:/Madhouse POS/system/system_table.csv");
		if(!f_system_table.exists())
		{
			try{
				f_system_table.getParentFile().mkdirs();
				bw_system_table=new BufferedWriter(new FileWriter(f_system_table.getAbsolutePath()));
				for(int i=0; i<16; i++)
				{
					bw_system_table.write(i+1+",0,0");
					bw_system_table.newLine();
				}
				bw_system_table.flush();
			}catch(Exception e){}
		}else
		{
			try{
	            for(int i=0;i<16;i++)
	            {
	            	br_system_table=new BufferedReader(new FileReader(f_system_table.getAbsolutePath()));
	            	String [] table_record;
	            	int lines = 0;
		    		while (oldrecord_table != null) {
		    			oldrecord_table = br_system_table.readLine();
		    			if (lines == i) {
		    				table_record=oldrecord_table.split(",");
		    				table_status[i]=Integer.parseInt(table_record[1]);
		    				table_ordernum[i]=Integer.parseInt(table_record[2]);
		    			}
		    			lines++;
		    		}
		    		oldrecord_table="";
		    		br_system_table.close();
	            }
			}catch(Exception e){}	
		}
		
		/* order log */
		
		f_log_order=new File("C:/Madhouse POS/紀錄/點餐紀錄/"+r_time1+"/"+r_time2+"點餐紀錄.csv");
		if(!f_log_order.exists())
		{
			try{
				f_log_order.getParentFile().mkdirs();
				bw_log_order=new BufferedWriter(new FileWriter(f_log_order.getAbsolutePath()));
				bw_log_order.write("點餐時間,點餐號碼,桌號,點餐人員,");
				for(int i=0; i<49; i++)
					bw_log_order.write(item_name[i]+",");
				for(int i=1; i<5; i++)
					bw_log_order.write("其他"+i+",");
				bw_log_order.write("小計,折數,減免,總優待,總金額,付,找,");
				bw_log_order.write("每日特餐品名,每日特餐價錢,");
				for(int i=1; i<5; i++)
				{
					bw_log_order.write("其他"+i+"品名,");
					bw_log_order.write("其他"+i+"價錢,");
				}
				for(int j=0; j<40; j++)
				{
					if(j!=39)
						bw_log_order.write("項目"+(j+1)+",");
					else
						bw_log_order.write("項目"+(j+1));
				}
				bw_log_order.newLine();
				bw_log_order.flush();
			}catch(Exception e){}
		}else
		{
			try{
				br_log_order=new BufferedReader(new FileReader(f_log_order.getAbsolutePath()));
				oldRecord_log_order+=br_log_order.readLine()+"\r\n";
				do{
                    String str=br_log_order.readLine();
                    if(str==null)
                        break;
                    oldRecord_log_order+=str+"\r\n";
	            }while(true);
				br_log_order.close();
				bw_log_order=new BufferedWriter(new FileWriter(f_log_order.getAbsolutePath()));
				bw_log_order.write(oldRecord_log_order);
				bw_log_order.flush();
			}catch(Exception e){}
		}
		
		/* sale log */
		
		if(notfirst==false)
		{
			f_log_sale=new File("C:/Madhouse POS/紀錄/銷售紀錄/"+r_time1+"/"+r_time2+"銷售紀錄.csv");
			if(!f_log_sale.exists())
			{
				try{
					f_log_sale.getParentFile().mkdirs();
					bw_log_sale=new BufferedWriter(new FileWriter(f_log_sale.getAbsolutePath()));
					bw_log_sale.write("點餐時間,");
					for(int i=0; i<item_name.length; i++)
						bw_log_sale.write(item_name[i]+",");
					bw_log_sale.write("小計,總優待,總金額");
					bw_log_sale.newLine();
					bw_log_sale.flush();
				}catch(Exception e){}
			}else
			{
				try{
					br_log_sale=new BufferedReader(new FileReader(f_log_sale.getAbsolutePath()));
					oldRecord_log_sale+=br_log_sale.readLine()+"\r\n";
					do{
						String str=br_log_sale.readLine();
						if(str==null)
							break;
						oldRecord_log_sale+=str+"\r\n";
					}while(true);
					br_log_sale.close();
					bw_log_sale=new BufferedWriter(new FileWriter(f_log_sale.getAbsolutePath()));
					bw_log_sale.write(oldRecord_log_sale);
					bw_log_sale.flush();
				}catch(Exception e){}
			}
			notfirst=true;
		}
		
		
		
		/* table log */
		
		f_log_table=new File("C:/Madhouse POS/紀錄/桌位紀錄/"+r_time1+"/"+r_time2+"桌位紀錄.csv");
		if(!f_log_table.exists())
		{
			try{
				f_log_table.getParentFile().mkdirs();
				bw_log_table=new BufferedWriter(new FileWriter(f_log_table.getAbsolutePath()));
				bw_log_table.write("變動時間,桌號,單號,狀態");
				bw_log_table.newLine();
				bw_log_table.flush();
			}catch(Exception e){}
		}else
		{
			try{
				br_log_table=new BufferedReader(new FileReader(f_log_table.getAbsolutePath()));
				oldRecord_log_table+=br_log_table.readLine()+"\r\n";
				do{
                    String str=br_log_table.readLine();
                    if(str==null)
                        break;
                    oldRecord_log_table+=str+"\r\n";
	            }while(true);
				br_log_table.close();
				bw_log_table=new BufferedWriter(new FileWriter(f_log_table.getAbsolutePath()));
				bw_log_table.write(oldRecord_log_table);
				bw_log_table.flush();
			}catch(Exception e){}
		}
		
		/* stock */
		
		f_system_stock=new File("C:/Madhouse POS/system/system_stock.csv");
		if(!f_system_stock.exists())
		{
			try{
				f_system_stock.getParentFile().mkdirs();
				bw_system_stock=new BufferedWriter(new FileWriter(f_system_stock.getAbsolutePath()));
				for(int i=0; i<30; i++)
				{
					bw_system_stock.write(i+","+default_stocklist_name[i]+","+default_stocklist_unit[i]+",0");
					bw_system_stock.newLine();
					stocklist_name[i]=default_stocklist_name[i];
    				stocklist_qty[i]=0;
    				stocklist_unit[i]=default_stocklist_unit[i];
				}
				bw_system_stock.flush();
			}catch(Exception e){}
		}else
		{
			try{
	            for(int i=0;i<30;i++)
	            {
	            	br_system_stock=new BufferedReader(new FileReader(f_system_stock.getAbsolutePath()));
	            	String [] stock_record;
	            	int lines = 0;
		    		while (oldRecord_stock != null) {
		    			oldRecord_stock = br_system_stock.readLine();
		    			if (lines == i) {
		    				stock_record=oldRecord_stock.split(",");
		    				stocklist_name[i]=stock_record[1];
		    				stocklist_unit[i]=stock_record[2];
		    				stocklist_qty[i]=Integer.parseInt(stock_record[3]);
		    			}
		    			lines++;
		    		}
		    		oldRecord_stock="";
		    		br_system_stock.close();
	            }
			}catch(Exception e){}	
		}
		
		
		/* ingredients */
		
		f_system_ingredients=new File("C:/Madhouse POS/system/system_ingredients.csv");
		if(!f_system_ingredients.exists())
		{
			try{
				f_system_ingredients.getParentFile().mkdirs();
				bw_system_ingredients=new BufferedWriter(new FileWriter(f_system_ingredients.getAbsolutePath()));
				for(int i=0; i<53; i++)
				{
					bw_system_ingredients.write(item_name[i]);
					for(int j=0;j<default_ingredients[i].length;j++)
					{
						bw_system_ingredients.write(","+default_ingredients[i][j]);
					}
					bw_system_ingredients.newLine();
				}
				bw_system_ingredients.flush();
			}catch(Exception e){}
		}
		else{
			for(int i=0;i<53;i++)
			{
				try{
					br_system_ingredients=new BufferedReader(new FileReader(f_system_ingredients.getAbsolutePath()));
		        	String [] ingredients_record;
		        	int lines = 0;
		    		while (oldRecord_ingredients != null) {
		    			oldRecord_ingredients = br_system_ingredients.readLine();
		    			if (lines == i) {
		    				ingredients_record=oldRecord_ingredients.split(",");
		    				ingredients_sum[i]=ingredients_record.length-1;
		    				for(int j=0;j<ingredients_record.length;j++)
		    				{
		    					ingredients[i][j]=Integer.parseInt(ingredients_record[j+1]);
		    				}
		    				
		    			}
		    			lines++;
		    		}
		    		oldRecord_ingredients="";
		    		br_system_ingredients.close();
				}catch(Exception e){}
			}
		}
	}
	void keepRecord_order_log()
	{
		try{
			Date d=new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm:ss");
			String r_time1=sdf1.format(d);
			bw_log_order.append(r_time1+","+order_num+","+now_tablenum+","+user[3]+",");
			for(int i=0; i<53; i++)
				bw_log_order.append(qty[i]+",");
			bw_log_order.append(smalltotal+","+discount+","+off+","+all_off+","+total+","+pay+","+change+",");
			for(int i=0; i<5; i++)
			{
				bw_log_order.append(menu5_name[i]+",");
				bw_log_order.append(menu5_price[i]+",");
			}
			for(int i=0; i<40; i++){
				if(list[i]!=-1)
					bw_log_order.append(list[i]+",");
				else if(i==39 && list[i]!=-1)
					bw_log_order.append(list[i]+"");
				else if(i==39 && list[i]==-1)
					bw_log_order.append("");
				else
					bw_log_order.append(""+",");
			}
			bw_log_order.newLine();
			bw_log_order.flush();
		}catch(Exception e){}	
		
		try{
			Date d=new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm:ss");
			String r_time1=sdf1.format(d);
			bw_log_sale.append(r_time1+",");
			for(int i=0; i<qty.length; i++)
				bw_log_sale.append(qty[i]+",");
			bw_log_sale.append(smalltotal+","+all_off+","+total);
			bw_log_sale.newLine();
			bw_log_sale.flush();
		}catch(Exception e){}	
	}
	void keepRecord_table_log(int i,int j)
	{
		try{
			Date d=new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm:ss");
			String r_time1=sdf1.format(d);
			bw_log_table.append(r_time1+","+(i+1)+","+table_ordernum[i]+","+status2[j]);
			bw_log_table.newLine();
			bw_log_table.flush();
		}catch(Exception e1){}
	}
	void renew_table()
	{
		try{
			bw_system_table=new BufferedWriter(new FileWriter(f_system_table.getAbsolutePath()));
			for(int i=0; i<16; i++)
			{
				bw_system_table.write(i+1+","+table_status[i]+","+table_ordernum[i]);
				bw_system_table.newLine();
			}
			bw_system_table.flush();
		}catch(Exception e1){}
		for(int i=0;i<16;i++)
		{
			tf_table_inside_status[i].setText(status[table_status[i]]);
			tf_table_inside_ordernum[i].setText(table_ordernum[i]+"");
			if(table_status[i]==0)
			{
				btn_table_inside_new[i].setEnabled(true);
				btn_table_inside_out[i].setEnabled(false);
				btn_table_inside_end[i].setEnabled(false);
			}
			else if(table_status[i]==1)
			{
				btn_table_inside_new[i].setEnabled(false);
				btn_table_inside_out[i].setEnabled(true);
				btn_table_inside_end[i].setEnabled(true);
			}
			else
			{
				btn_table_inside_new[i].setEnabled(false);
				btn_table_inside_out[i].setEnabled(false);
				btn_table_inside_end[i].setEnabled(true);
			}
		}
	}
	void renew_menu5()
	{
		try{
			bw_system_menu5=new BufferedWriter(new FileWriter(f_system_menu5.getAbsolutePath()));
			for(int i=0; i<5; i++)
			{
				bw_system_menu5.write(menu5_name[i]+","+menu5_price[i]);
				bw_system_menu5.newLine();
			}
			bw_system_menu5.flush();
		}catch(Exception e1){}
		for(int i=0;i<5;i++)
		{
			tf_menu5_set_name[i].setText(menu5_name[i]);
			tf_menu5_set_price[i].setText(menu5_price[i]+"");
			price[i+48]=menu5_price[i];
    		if(i!=0)
    		{
    			lb_item_name[i+48].setText("其他-"+menu5_name[i]);
    			lb_menu_name[i+17].setText("其他-"+menu5_name[i]);
    		}
		}
		tab_menu.updateUI();
		tab_order_list.updateUI();
	}
	void renew_stock()
	{
		try{
			f_system_stock.getParentFile().mkdirs();
			bw_system_stock=new BufferedWriter(new FileWriter(f_system_stock.getAbsolutePath()));
			for(int i=0; i<30; i++)
			{
				bw_system_stock.write(i+","+stocklist_name[i]+","+stocklist_unit[i]+","+stocklist_qty[i]);
				bw_system_stock.newLine();
			}
			bw_system_stock.flush();
		}catch(Exception e){}
		for(int i=0;i<30;i++)
		{
			lb_stock_item[i].setText(stocklist_name[i]);
			lb_stock_unit[i].setText(stocklist_unit[i]);
			lb_stock_qty[i].setText(stocklist_qty[i]+"");
			tf_stock_input[i].setText("");
		}
	}
	void ingredients_del(int i)
	{
		try{
            	br_system_ingredients=new BufferedReader(new FileReader(f_system_ingredients.getAbsolutePath()));
            	String [] ingredients_record = null;
            	int lines = 0;
	    		while (oldRecord_ingredients != null) {
	    			oldRecord_ingredients = br_system_ingredients.readLine();
	    			if (lines == i) {
	    				ingredients_record=oldRecord_ingredients.split(",");
	    				break;
	    			}
	    			lines++;
	    		}
	    		oldRecord_ingredients="";
	    		br_system_ingredients.close();
	    		for(int a=0;a<ingredients_record.length-1;a++)
	    		{
	    			stocklist_qty[Integer.parseInt(ingredients_record[a+1])]--;
	    		}
		}catch(Exception e){}
	}
	void ingredients_add(int i)
	{
		try{
            	br_system_ingredients=new BufferedReader(new FileReader(f_system_ingredients.getAbsolutePath()));
            	String [] ingredients_record = null;
            	int lines = 0;
	    		while (oldRecord_ingredients != null) {
	    			oldRecord_ingredients = br_system_ingredients.readLine();
	    			if (lines == i) {
	    				ingredients_record=oldRecord_ingredients.split(",");
	    				break;
	    			}
	    			lines++;
	    		}
	    		oldRecord_ingredients="";
	    		br_system_ingredients.close();
	    		for(int a=0;a<ingredients_record.length-1;a++)
	    		{
	    			stocklist_qty[Integer.parseInt(ingredients_record[a+1])]++;
	    		}
		}catch(Exception e){}
	}
	void check_stock()
	{
		String str1="",str2="";
		for(int i=0;i<30;i++)
		{
			if(stocklist_qty[i]>5)
			{
				lb_stock_item[i].setForeground(Color.black);
			}
			if(stocklist_qty[i]<5 && stocklist_qty[i]>0)
			{
				lb_stock_item[i].setForeground(Color.red);
				str1=str1+stocklist_name[i]+"\n";
				//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
			}
			if(stocklist_qty[i]<=0)
			{
				lb_stock_item[i].setForeground(Color.red);
				str2=str2+stocklist_name[i]+"\n";
				//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量不足!!", "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(!str1.equals(""))
			JOptionPane.showMessageDialog(null, str1+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
		if(!str2.equals(""))
		 JOptionPane.showMessageDialog(null, str2+"庫存量不足!!", "錯誤", JOptionPane.ERROR_MESSAGE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<53; i++)
		{
			if(e.getSource()==btn_del[i] && qty[i]>0)
				del(i);
		}
		if(e.getSource()==btn_man_exit)
		{
			 int opt2=JOptionPane.showConfirmDialog(null,"確定離開??","警告",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			 	if(opt2==0)
			 	{
			 		for(int i=0;i<53;i++)
					 {
						 if(qty[i]!=0)
							{
								for(int z=0;z<qty[i];z++)
									ingredients_add(i);
							}
					 }
			 		try {
						Thread.currentThread();
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			 		System.exit(0);
			 	}
		}
		if(e.getSource()==btn_man_clear)
		{
			 int opt=JOptionPane.showConfirmDialog(null,"確定全部清除??","警告",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			 if(opt==0)
			 {
				 for(int i=0;i<53;i++)
				 {
					 if(qty[i]!=0)
						{
							for(int z=0;z<qty[i];z++)
								ingredients_add(i);
						}
				 }
				 reset();
			 }
		}
		if(e.getSource()==btn_man_table)
		{
			fm_man_table.setVisible(true);
			renew_table();
		}
		if(e.getSource()==btn_man_order_num_reset)
		{
			int opt=JOptionPane.showConfirmDialog(null,"確定重設單號??","警告",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			 if(opt==0)
			 {
				 order_num=1;
					tf_info_order_num.setText(order_num+"");
					try{
						bw_system=new BufferedWriter(new FileWriter(f_system.getAbsolutePath()));
						bw_system.write(order_num+"");
						bw_system.flush();
					}catch(Exception e1){}
			 }
		}
		if(e.getSource()==btn_ch_chechout)
		{
			if(now_tablenum==0)
			{
				JOptionPane.showMessageDialog(null,"沒有選擇桌位!!","錯誤", JOptionPane.ERROR_MESSAGE);
				fm_man_table.setVisible(true);
				renew_table();
			}
			if(!tf_ch_pay.getText().equals(""))
			{
				pay=Integer.parseInt(tf_ch_pay.getText());
				int n=0;
				for(int i=0;i<53;i++)
				{
					if(qty[i]!=0)
						n++;
				}
				if(n==0)
					JOptionPane.showMessageDialog(null,"沒有商品!!","錯誤", JOptionPane.ERROR_MESSAGE);
				if(n!=0  &&  now_tablenum!=0 && pay>=total)
				{
					change=pay-(int)total;
					tf_ch_change.setText(change+"");
					isChecked=true;
					tf_ch_change.setForeground(Color.BLACK);
					keepRecord_order_log();
					now_status=1;
					if(now_tablenum<15)
						table_status[now_tablenum-1]=1;
					tf_info_status.setText(status[now_status]);
					renew_table();
					keepRecord_table_log(now_tablenum-1,2);
					
				}
				else if(pay<total)
				{
					tf_ch_change.setForeground(Color.RED);
					JOptionPane.showMessageDialog(null,"金額不足!!","錯誤", JOptionPane.ERROR_MESSAGE);
				}	
			}
			else
				JOptionPane.showMessageDialog(null,"沒有輸入金額!!","錯誤", JOptionPane.ERROR_MESSAGE);
		}
		if(e.getSource()==btn_ch_next)
		{
			
			if(isChecked==true)
			{
				tf_ch_change.setForeground(Color.BLACK);
				isChecked=false;
				reset();
				tf_info_status.setText("");
				tf_info_table.setText("");
				now_tablenum=0;
				order_num++;
				tf_info_order_num.setText(order_num+"");
				Date d=new Date();
				SimpleDateFormat  sdf2=new SimpleDateFormat("yyyyMMdd");
				String r_time2=sdf2.format(d);
				try{
					bw_system=new BufferedWriter(new FileWriter(f_system.getAbsolutePath()));
					bw_system.write(r_time2+","+order_num);
					bw_system.flush();
				}catch(Exception e1){}
				check_order_num();
				renew_table();
			}
			
		}
		if(e.getSource()==btn_ch_off_set)
			fm_discount.setVisible(true);
		if(e.getSource()==btn_table_exit)
			fm_man_table.dispose();
		if(e.getSource()==btn_table_all_reset)
		{
			int opt=JOptionPane.showConfirmDialog(null,"確定全部清除??","警告",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			 if(opt==0)
			 {
				 for(int i=0;i<16;i++)
					{
						table_ordernum[i]=0;
						if(table_status[i]!=0)
							keepRecord_table_log(i,0);
						table_status[i]=0;
					}
					renew_table();
			 }
		}
		for(int i=0;i<16;i++)
		{
			if(e.getSource()==btn_table_inside_new[i])
			{
				if(table_status[i]==0)
				{
					now_status=0;
					tf_info_status.setText("新單");
					now_tablenum=i+1;
					tf_info_table.setText(now_tablenum+"");
					table_ordernum[i]=order_num;
					fm_man_table.dispose();
					renew_table();
					keepRecord_table_log(i,1);
				}
			}
		}
		for(int i=0;i<16;i++)
		{
			if(e.getSource()==btn_table_inside_out[i])
			{
				if(table_status[i]==1)
				{
					table_status[i]=2;
					renew_table();
					keepRecord_table_log(i,3);
				}
			}
		}
		for(int i=0;i<16;i++)
		{
			if(e.getSource()==btn_table_inside_end[i])
			{
				if(table_status[i]==1 || table_status[i]==2)
				{
					table_status[i]=0;
					table_ordernum[i]=0;
					renew_table();
					keepRecord_table_log(i,0);
				}
			}
		}
		if(e.getSource()==btn_discount_ok)
		{
			if(!tf_discount_discount.getText().equals(""))
				discount=Double.parseDouble(tf_discount_discount.getText());
			else
				discount=100.0;
			if(!tf_discount_off.getText().equals(""))
				off=Integer.parseInt(tf_discount_off.getText());
			else
				off=0;
			tf_ch_discount.setText(discount+"");
			tf_ch_off.setText(off+"");
			total();
			all_off=smalltotal-(int)total;
			tf_ch_all_off.setText(all_off+"");
			fm_discount.dispose();
		}
		if(e.getSource()==btn_discount_cancel)
			fm_discount.dispose();
		if(e.getSource()==btn_man_menu_5_set)
		{
			fm_man_menu_5_set.setVisible(true);
			renew_menu5();
		}
		if(e.getSource()==btn_menu5_set_ok)
		{
			for(int i=0;i<5;i++)
			{
				if(!tf_menu5_set_price[i].getText().equals(""))
					menu5_price[i]=Integer.parseInt(tf_menu5_set_price[i].getText());
				else
					menu5_price[i]=0;
				menu5_name[i]=tf_menu5_set_name[i].getText();
			}
			renew_menu5();
			fm_man_menu_5_set.dispose();
		}
		if(e.getSource()==btn_menu5_set_cancel)
			fm_man_menu_5_set.dispose();
		if(e.getSource()==btn_man_look)
		{
			fm_pos_main.dispose();
			o=0;
			login();
		}
		if(e.getSource()==tf_login_account || e.getSource()==tf_login_pw || e.getSource()==btn_login_login)
		{
			if(Engineeringmode==true)
			{
				String str = new String(tf_login_pw.getPassword());
				if(tf_login_account.getText().equals("") && str.equals(""))
				{
					user[0]=-1+"";
		    		user[3]="工程模式";
					tf_info_user_num.setText("-1");
		    		tf_info_user_name.setText("工程模式");
		    		fm_pos_main.setVisible(true);
		    		fm_login.setVisible(false);
		    		JOptionPane.showMessageDialog(null,"使用工程模式登入!!","警告",JOptionPane.WARNING_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null,"無法使用工程模式登入!!","錯誤",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
			else
			{
				try{
					br_login=new BufferedReader(new FileReader(f_login.getAbsolutePath()));
	            	String [] login_record;
	            	for(;;)
	            	{
		    			oldRecord_login = br_login.readLine();
		    			if(oldRecord_login == null)
		    				break;
		    			login_record=oldRecord_login.split(",");
		    			String str = new String(tf_login_pw.getPassword());
		    			if(tf_login_account.getText().equals(login_record[1]) && str.equals(login_record[2]))
		    			{
		    				user[0]=login_record[0];
				    		user[1]=login_record[1];
				    		user[2]=login_record[2];
				    		user[3]=login_record[3];
				    		tf_info_user_num.setText(login_record[0]);
				    		tf_info_user_name.setText(login_record[3]);
				    		fm_pos_main.setVisible(true);
				    		fm_login.setVisible(false);
				    		tf_login_account.setText("");
			    			tf_login_pw.setText("");
			    			break;
		    			}
		    			
	            	}
		    		if(fm_pos_main.isVisible()==false)
		    		{
		    			o++;
		    			if(o==3){
		    				JOptionPane.showMessageDialog(null,"帳號或密碼錯誤且超過3次!!","錯誤", JOptionPane.ERROR_MESSAGE);
		    				System.exit(0);
		    			}
		    			JOptionPane.showMessageDialog(null,"帳號或密碼錯誤!!\r\n      剩下"+(3-o)+"次","錯誤", JOptionPane.ERROR_MESSAGE);
		    			tf_login_account.setText("");
		    			tf_login_pw.setText("");
		    		}
		    		oldRecord_login="";
		    		br_login.close();
				}catch(Exception e1){}	
			}
		}
		if(e.getSource()==btn_man_stock)
		{
			renew_stock();
			fm_stock.setVisible(true);
			check_stock();
		}
		if(e.getSource()==btn_stock_exit)
			fm_stock.dispose();
		if(e.getSource()==btn_stock_reset)
		{
			int opt=JOptionPane.showConfirmDialog(null,"確定全部歸零??","警告",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			 if(opt==0)
			 {
				 for(int i=0;i<30;i++)
					{
						lb_stock_qty[i].setText("");
						stocklist_qty[i]=0;
					}
					renew_stock();
			 }
		}
		if(e.getSource()==btn_stock_revise)
		{
			String str1="",str2="";
			for(int i=0;i<30;i++)
			{
				if(!tf_stock_input[i].getText().equals(""))
				{
					try{
						if(stocklist_qty[i]+Integer.parseInt(tf_stock_input[i].getText())>0)
						{
							stocklist_qty[i]+=Integer.parseInt(tf_stock_input[i].getText());
							if(stocklist_qty[i]<5)
							{
								lb_stock_item[i].setForeground(Color.red);
								str1=str1+stocklist_name[i]+"\n";
								//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
							}
							else
							{
								lb_stock_item[i].setForeground(Color.black);
							}
						}
						else if(stocklist_qty[i]+Integer.parseInt(tf_stock_input[i].getText())<=0)
						{
							//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量不足!!", "錯誤", JOptionPane.ERROR_MESSAGE);
							lb_stock_item[i].setForeground(Color.red);
							str2=str2+stocklist_name[i]+"\n";
						}
					}catch(Exception ex){
						if(!tf_stock_input[i].getText().equals(""))
						{
						    JOptionPane.showMessageDialog(null, stocklist_name[i]+"輸入需為整數!!", "錯誤", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				else
				{
					if(stocklist_qty[i]<5 && stocklist_qty[i]>0)
					{
						lb_stock_item[i].setForeground(Color.red);
						str1=str1+stocklist_name[i]+"\n";
						//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
					}
					else if(stocklist_qty[i]<=0)
					{
						//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量不足!!", "錯誤", JOptionPane.ERROR_MESSAGE);
						lb_stock_item[i].setForeground(Color.red);
						str2=str2+stocklist_name[i]+"\n";
					}
					
				}
			}
			if(!str1.equals(""))
				JOptionPane.showMessageDialog(null, str1+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
			if(!str2.equals(""))
			 JOptionPane.showMessageDialog(null, str2+"庫存量不足!!", "錯誤", JOptionPane.ERROR_MESSAGE);
			renew_stock();
		}
		if(e.getSource()==btn_stock_replace)
		{
			String str1="",str2="";
			for(int i=0;i<30;i++)
			{
				if(!tf_stock_input[i].getText().equals(""))
				{
					try{
						if(Integer.parseInt(tf_stock_input[i].getText())>0)
						{
							stocklist_qty[i]=Integer.parseInt(tf_stock_input[i].getText());
							if(stocklist_qty[i]<5)
							{
								lb_stock_item[i].setForeground(Color.red);
								str1=str1+stocklist_name[i]+"\n";
								//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
							}
							else
							{
								lb_stock_item[i].setForeground(Color.black);
							}
						}
						else if(Integer.parseInt(tf_stock_input[i].getText())<=0)
						{
							//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量低不足!!", "錯誤", JOptionPane.ERROR_MESSAGE);
							lb_stock_item[i].setForeground(Color.red);
							str2=str2+stocklist_name[i]+"\n";
						}
					}catch(Exception ex){
						if(!tf_stock_input[i].getText().equals(""))
						{
						    JOptionPane.showMessageDialog(null, stocklist_name[i]+"輸入需為整數!!", "錯誤", JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
				else
				{
					if(stocklist_qty[i]<5 && stocklist_qty[i]>0)
					{
						lb_stock_item[i].setForeground(Color.red);
						str1=str1+stocklist_name[i]+"\n";
						//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
					}
					else if(stocklist_qty[i]<=0)
					{
						//JOptionPane.showMessageDialog(null, stocklist_name[i]+"庫存量不足!!", "錯誤", JOptionPane.ERROR_MESSAGE);
						lb_stock_item[i].setForeground(Color.red);
						str2=str2+stocklist_name[i]+"\n";
					}
				}
			}
			if(!str1.equals(""))
				JOptionPane.showMessageDialog(null, str1+"庫存量低於5!!", "警告", JOptionPane.WARNING_MESSAGE);
			if(!str2.equals(""))
			 JOptionPane.showMessageDialog(null, str2+"庫存量不足!!", "錯誤", JOptionPane.ERROR_MESSAGE);
			renew_stock();
		}
	}
}
