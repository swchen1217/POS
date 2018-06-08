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
	JLabel lb_info_nowtime,lb_info_user_num,lb_info_order_num,lb_info_table,lb_info_user_name,lb_info_status,lb_info_order_sum;
	JTextField tf_info_user_num,tf_info_order_num,tf_info_table,tf_info_user_name,tf_info_status,tf_info_order_sum;
	/* info end */
	
	/* meals */
	int qty[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int price[]={140,190,160,160,210,210,180,230,120,155,140,140,175,175,160,195,120,155,140,140,175,175,160,195,60,140,120,120,50,80,50,80,50,80,50,80,50,80,50,50,50,50,50,0,0,0,0,0,0,0,0,0,0,0};
	int small_total[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	String item_name[]={"異想牛漢堡","異想牛漢堡(肉)","異想牛漢堡(培)","異想牛漢堡(起)","異想牛漢堡(肉培)","異想牛漢堡(肉起)","異想牛漢堡(培起)","異想牛漢堡(肉培起)",
			            "異想豬漢堡","異想豬漢堡(肉)","異想豬漢堡(培)","異想豬漢堡(起)","異想豬漢堡(肉培)","異想豬漢堡(肉起)","異想豬漢堡(培起)","異想豬漢堡(肉培起)",
			            "異想雞漢堡","異想雞漢堡(肉)","異想雞漢堡(培)","異想雞漢堡(起)","異想雞漢堡(肉培)","異想雞漢堡(肉起)","異想雞漢堡(培起)","異想雞漢堡(肉培起)",
			            "實驗咖哩飯","實驗牛咖哩飯","實驗豬咖哩飯","實驗雞咖哩飯",
			            "成長的回憶","成長的回憶(套)","草原上的青雞","草原上的青雞(套)","低調中的高貴","低調中的高貴(套)","親子間的南瓜","親子間的南瓜(套)","牛奶海洋裡的鮭魚","牛奶海洋裡的鮭魚(套)",
			            "憂愁的藥水","炙烈的藥水","高貴的藥水","典雅的藥水","魔性的藥水",
			            "憂愁的藥水(贈)","炙烈的藥水(贈)","高貴的藥水(贈)","典雅的藥水(贈)","魔性的藥水(贈)","每日特餐","其他-","其他-","其他-","其他-","其他-"};
	
	/* meals end */
	/* menu */
	
	JLabel lb_menu_name[]=new JLabel[54],lb_menu_x[]=new JLabel[54];
	JTextField tf_menu_qty[]=new JTextField[23];
	JCheckBox cb[]=new JCheckBox[19];
	JButton btn_add[]=new JButton[23];
	JPanel pn_menu_1_1,pn_menu_1_2,pn_menu_1_3,pn_menu_2_1,pn_menu_2_2,pn_menu_2_3,pn_menu_2_4,pn_menu_3_1,pn_menu_3_2,pn_menu_3_3,pn_menu_3_4,pn_menu_3_5,pn_menu_4_1,pn_menu_4_2,pn_menu_4_3,pn_menu_4_4,pn_menu_4_5,pn_menu_5_1,pn_menu_5_2,pn_menu_5_3,pn_menu_5_4,pn_menu_5_5;
	
	//private JPanel pn_menu_2_1;
	private JLabel qq455;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	//private JPanel pn_menu_3_2;
	private JLabel label_6;
	private JLabel label_7;
	private JTextField textField_5;
	private JCheckBox checkBox;
	private JButton button_3;
	//private JPanel pn_menu_3_3;
	private JLabel label_8;
	private JLabel label_9;
	private JTextField textField_6;
	private JCheckBox checkBox_1;
	private JButton button_4;
	//private JPanel pn_menu_3_4;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField textField_7;
	private JCheckBox checkBox_2;
	private JButton button_5;
	//private JPanel pn_menu_3_5;
	private JLabel label_12;
	private JLabel label_13;
	private JTextField textField_8;
	private JCheckBox checkBox_3;
	private JButton button_6;
	//private JPanel pn_menu_4_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_9;
	private JCheckBox chckbxNewCheckBox_1;
	private JButton btnNewButton_2;
	//private JPanel pn_menu_4_2;
	private JLabel label_14;
	private JLabel label_15;
	private JTextField textField_10;
	private JCheckBox checkBox_4;
	private JButton button_7;
	//private JPanel pn_menu_4_3;
	private JLabel label_16;
	private JLabel label_17;
	private JTextField textField_11;
	private JCheckBox checkBox_5;
	private JButton button_8;
	//private JPanel pn_menu_4_4;
	private JLabel label_18;
	private JLabel label_19;
	private JTextField textField_12;
	private JCheckBox checkBox_6;
	private JButton button_9;
	//private JPanel pn_menu_4_5;
	private JLabel label_20;
	private JLabel label_21;
	private JTextField textField_13;
	private JCheckBox checkBox_7;
	private JButton button_10;
	//private JLabel lb_info_order_sum;
	//private JTextField tf_info_order_sum;
	//private JPanel pn_menu_5_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_14;
	private JButton btnNewButton_3;
	//private JPanel pn_menu_5_2;
	private JLabel label_22;
	private JLabel label_23;
	private JTextField textField_15;
	private JButton button_11;
	//private JPanel pn_menu_5_3;
	private JLabel label_24;
	private JLabel label_25;
	private JTextField textField_16;
	private JButton button_12;
	//private JPanel pn_menu_5_4;
	private JLabel label_26;
	private JLabel label_27;
	private JTextField textField_17;
	private JButton button_13;
	//private JPanel pn_menu_5_5;
	private JLabel label_28;
	private JLabel label_29;
	private JTextField textField_18;
	private JButton button_14;
	
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
		
		/* menu_1 end */
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
		
		qq455 = new JLabel("\u5BE6\u9A57\u5496\u54E9\u98EF");
		qq455.setFont(new Font("新細明體", Font.PLAIN, 26));
		qq455.setBounds(20, 0, 160, 70);
		pn_menu_2_1.add(qq455);
		
		lblNewLabel = new JLabel("x");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel.setBounds(190, 20, 30, 30);
		pn_menu_2_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(220, 10, 70, 50);
		pn_menu_2_1.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 26));
		btnNewButton.setBounds(310, 20, 50, 30);
		pn_menu_2_1.add(btnNewButton);
		
		pn_menu_2_2 = new JPanel();
		pn_menu_2_2.setLayout(null);
		pn_menu_2_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_2_2.setBackground(Color.YELLOW);
		pn_menu_2_2.setBounds(0, 70, 390, 70);
		pn_menu_2.add(pn_menu_2_2);
		
		JLabel label = new JLabel("\u5BE6\u9A57\u725B\u5496\u54E9\u98EF");
		label.setFont(new Font("新細明體", Font.PLAIN, 26));
		label.setBounds(20, 0, 160, 70);
		pn_menu_2_2.add(label);
		
		JLabel label_1 = new JLabel("x");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_1.setBounds(190, 20, 30, 30);
		pn_menu_2_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(220, 10, 70, 50);
		pn_menu_2_2.add(textField_1);
		
		JButton button = new JButton("+");
		button.setFont(new Font("新細明體", Font.PLAIN, 26));
		button.setBounds(310, 20, 50, 30);
		pn_menu_2_2.add(button);
		
		pn_menu_2_3 = new JPanel();
		pn_menu_2_3.setLayout(null);
		pn_menu_2_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_2_3.setBackground(Color.YELLOW);
		pn_menu_2_3.setBounds(0, 140, 390, 70);
		pn_menu_2.add(pn_menu_2_3);
		
		JLabel label_2 = new JLabel("\u5BE6\u9A57\u8C6C\u5496\u54E9\u98EF");
		label_2.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_2.setBounds(20, 0, 160, 70);
		pn_menu_2_3.add(label_2);
		
		JLabel label_3 = new JLabel("x");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_3.setBounds(190, 20, 30, 30);
		pn_menu_2_3.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(220, 10, 70, 50);
		pn_menu_2_3.add(textField_2);
		
		JButton button_1 = new JButton("+");
		button_1.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_1.setBounds(310, 20, 50, 30);
		pn_menu_2_3.add(button_1);
		
		pn_menu_2_4 = new JPanel();
		pn_menu_2_4.setLayout(null);
		pn_menu_2_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_2_4.setBackground(Color.YELLOW);
		pn_menu_2_4.setBounds(0, 210, 390, 70);
		pn_menu_2.add(pn_menu_2_4);
		
		JLabel label_4 = new JLabel("\u5BE6\u9A57\u96DE\u5496\u54E9\u98EF");
		label_4.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_4.setBounds(20, 0, 160, 70);
		pn_menu_2_4.add(label_4);
		
		JLabel label_5 = new JLabel("x");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_5.setBounds(190, 20, 30, 30);
		pn_menu_2_4.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(220, 10, 70, 50);
		pn_menu_2_4.add(textField_3);
		
		JButton button_2 = new JButton("+");
		button_2.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_2.setBounds(310, 20, 50, 30);
		pn_menu_2_4.add(button_2);
		
		/* menu_2 end */
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
		
		JLabel lblNewLabel_1 = new JLabel("\u6210\u9577\u7684\u56DE\u61B6");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(15, 0, 210, 70);
		pn_menu_3_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("x");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(270, 15, 30, 30);
		pn_menu_3_1.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(300, 5, 70, 50);
		pn_menu_3_1.add(textField_4);
		textField_4.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u5957\u9910");
		chckbxNewCheckBox.setFont(new Font("新細明體", Font.PLAIN, 20));
		chckbxNewCheckBox.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox.setBounds(20, 70, 90, 30);
		pn_menu_3_1.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 26));
		btnNewButton_1.setBounds(300, 70, 50, 30);
		pn_menu_3_1.add(btnNewButton_1);
		
		pn_menu_3_2 = new JPanel();
		pn_menu_3_2.setLayout(null);
		pn_menu_3_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3_2.setBackground(new Color(154, 205, 50));
		pn_menu_3_2.setBounds(0, 120, 390, 120);
		pn_menu_3.add(pn_menu_3_2);
		
		label_6 = new JLabel("\u8349\u539F\u4E0A\u7684\u9752\u96DE");
		label_6.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_6.setBounds(15, 0, 210, 70);
		pn_menu_3_2.add(label_6);
		
		label_7 = new JLabel("x");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_7.setBounds(270, 15, 30, 30);
		pn_menu_3_2.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(300, 5, 70, 50);
		pn_menu_3_2.add(textField_5);
		
		checkBox = new JCheckBox("\u5957\u9910");
		checkBox.setFont(new Font("新細明體", Font.PLAIN, 20));
		checkBox.setBackground(new Color(154, 205, 50));
		checkBox.setBounds(20, 70, 90, 30);
		pn_menu_3_2.add(checkBox);
		
		button_3 = new JButton("+");
		button_3.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_3.setBounds(300, 70, 50, 30);
		pn_menu_3_2.add(button_3);
		
		pn_menu_3_3 = new JPanel();
		pn_menu_3_3.setLayout(null);
		pn_menu_3_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3_3.setBackground(new Color(154, 205, 50));
		pn_menu_3_3.setBounds(0, 240, 390, 120);
		pn_menu_3.add(pn_menu_3_3);
		
		label_8 = new JLabel("\u4F4E\u8ABF\u4E2D\u7684\u9AD8\u8CB4");
		label_8.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_8.setBounds(15, 0, 210, 70);
		pn_menu_3_3.add(label_8);
		
		label_9 = new JLabel("x");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_9.setBounds(270, 15, 30, 30);
		pn_menu_3_3.add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(300, 5, 70, 50);
		pn_menu_3_3.add(textField_6);
		
		checkBox_1 = new JCheckBox("\u5957\u9910");
		checkBox_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		checkBox_1.setBackground(new Color(154, 205, 50));
		checkBox_1.setBounds(20, 70, 90, 30);
		pn_menu_3_3.add(checkBox_1);
		
		button_4 = new JButton("+");
		button_4.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_4.setBounds(300, 70, 50, 30);
		pn_menu_3_3.add(button_4);
		
		pn_menu_3_4 = new JPanel();
		pn_menu_3_4.setLayout(null);
		pn_menu_3_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3_4.setBackground(new Color(154, 205, 50));
		pn_menu_3_4.setBounds(0, 360, 390, 120);
		pn_menu_3.add(pn_menu_3_4);
		
		label_10 = new JLabel("\u89AA\u5B50\u9593\u7684\u5357\u74DC");
		label_10.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_10.setBounds(15, 0, 210, 70);
		pn_menu_3_4.add(label_10);
		
		label_11 = new JLabel("x");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_11.setBounds(270, 15, 30, 30);
		pn_menu_3_4.add(label_11);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(300, 5, 70, 50);
		pn_menu_3_4.add(textField_7);
		
		checkBox_2 = new JCheckBox("\u5957\u9910");
		checkBox_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		checkBox_2.setBackground(new Color(154, 205, 50));
		checkBox_2.setBounds(20, 70, 90, 30);
		pn_menu_3_4.add(checkBox_2);
		
		button_5 = new JButton("+");
		button_5.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_5.setBounds(300, 70, 50, 30);
		pn_menu_3_4.add(button_5);
		
		pn_menu_3_5 = new JPanel();
		pn_menu_3_5.setLayout(null);
		pn_menu_3_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3_5.setBackground(new Color(154, 205, 50));
		pn_menu_3_5.setBounds(0, 480, 390, 120);
		pn_menu_3.add(pn_menu_3_5);
		
		label_12 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A");
		label_12.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_12.setBounds(15, 0, 210, 70);
		pn_menu_3_5.add(label_12);
		
		label_13 = new JLabel("x");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_13.setBounds(270, 15, 30, 30);
		pn_menu_3_5.add(label_13);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(300, 5, 70, 50);
		pn_menu_3_5.add(textField_8);
		
		checkBox_3 = new JCheckBox("\u5957\u9910");
		checkBox_3.setFont(new Font("新細明體", Font.PLAIN, 20));
		checkBox_3.setBackground(new Color(154, 205, 50));
		checkBox_3.setBounds(20, 70, 90, 30);
		pn_menu_3_5.add(checkBox_3);
		
		button_6 = new JButton("+");
		button_6.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_6.setBounds(300, 70, 50, 30);
		pn_menu_3_5.add(button_6);
		
		/* menu_3 end */
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
		
		lblNewLabel_3 = new JLabel("\u6182\u6101\u7684\u85E5\u6C34");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel_3.setBounds(15, 0, 210, 70);
		pn_menu_4_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("x");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(270, 15, 30, 30);
		pn_menu_4_1.add(lblNewLabel_4);
		
		textField_9 = new JTextField();
		textField_9.setBounds(300, 5, 70, 50);
		pn_menu_4_1.add(textField_9);
		textField_9.setColumns(10);
		
		chckbxNewCheckBox_1 = new JCheckBox("\u8D08\u9001");
		chckbxNewCheckBox_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		chckbxNewCheckBox_1.setBounds(20, 70, 90, 30);
		chckbxNewCheckBox_1.setBackground(new Color(0, 191, 255));
		pn_menu_4_1.add(chckbxNewCheckBox_1);
		
		btnNewButton_2 = new JButton("+");
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 26));
		btnNewButton_2.setBounds(300, 70, 50, 30);
		pn_menu_4_1.add(btnNewButton_2);
		
		pn_menu_4_2 = new JPanel();
		pn_menu_4_2.setLayout(null);
		pn_menu_4_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4_2.setBackground(new Color(0, 191, 255));
		pn_menu_4_2.setBounds(0, 120, 390, 120);
		pn_menu_4.add(pn_menu_4_2);
		
		label_14 = new JLabel("\u7099\u70C8\u7684\u85E5\u6C34");
		label_14.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_14.setBounds(15, 0, 210, 70);
		pn_menu_4_2.add(label_14);
		
		label_15 = new JLabel("x");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_15.setBounds(270, 15, 30, 30);
		pn_menu_4_2.add(label_15);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(300, 5, 70, 50);
		pn_menu_4_2.add(textField_10);
		
		checkBox_4 = new JCheckBox("\u8D08\u9001");
		checkBox_4.setFont(new Font("新細明體", Font.PLAIN, 20));
		checkBox_4.setBackground(new Color(0, 191, 255));
		checkBox_4.setBounds(20, 70, 90, 30);
		pn_menu_4_2.add(checkBox_4);
		
		button_7 = new JButton("+");
		button_7.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_7.setBounds(300, 70, 50, 30);
		pn_menu_4_2.add(button_7);
		
		pn_menu_4_3 = new JPanel();
		pn_menu_4_3.setLayout(null);
		pn_menu_4_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4_3.setBackground(new Color(0, 191, 255));
		pn_menu_4_3.setBounds(0, 240, 390, 120);
		pn_menu_4.add(pn_menu_4_3);
		
		label_16 = new JLabel("\u9AD8\u8CB4\u7684\u85E5\u6C34");
		label_16.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_16.setBounds(15, 0, 210, 70);
		pn_menu_4_3.add(label_16);
		
		label_17 = new JLabel("x");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_17.setBounds(270, 15, 30, 30);
		pn_menu_4_3.add(label_17);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(300, 5, 70, 50);
		pn_menu_4_3.add(textField_11);
		
		checkBox_5 = new JCheckBox("\u8D08\u9001");
		checkBox_5.setFont(new Font("新細明體", Font.PLAIN, 20));
		checkBox_5.setBackground(new Color(0, 191, 255));
		checkBox_5.setBounds(20, 70, 90, 30);
		pn_menu_4_3.add(checkBox_5);
		
		button_8 = new JButton("+");
		button_8.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_8.setBounds(300, 70, 50, 30);
		pn_menu_4_3.add(button_8);
		
		pn_menu_4_4 = new JPanel();
		pn_menu_4_4.setLayout(null);
		pn_menu_4_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4_4.setBackground(new Color(0, 191, 255));
		pn_menu_4_4.setBounds(0, 360, 390, 120);
		pn_menu_4.add(pn_menu_4_4);
		
		label_18 = new JLabel("\u5178\u96C5\u7684\u85E5\u6C34");
		label_18.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_18.setBounds(15, 0, 210, 70);
		pn_menu_4_4.add(label_18);
		
		label_19 = new JLabel("x");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_19.setBounds(270, 15, 30, 30);
		pn_menu_4_4.add(label_19);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(300, 5, 70, 50);
		pn_menu_4_4.add(textField_12);
		
		checkBox_6 = new JCheckBox("\u8D08\u9001");
		checkBox_6.setFont(new Font("新細明體", Font.PLAIN, 20));
		checkBox_6.setBackground(new Color(0, 191, 255));
		checkBox_6.setBounds(20, 70, 90, 30);
		pn_menu_4_4.add(checkBox_6);
		
		button_9 = new JButton("+");
		button_9.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_9.setBounds(300, 70, 50, 30);
		pn_menu_4_4.add(button_9);
		
		pn_menu_4_5 = new JPanel();
		pn_menu_4_5.setLayout(null);
		pn_menu_4_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4_5.setBackground(new Color(0, 191, 255));
		pn_menu_4_5.setBounds(0, 480, 390, 120);
		pn_menu_4.add(pn_menu_4_5);
		
		label_20 = new JLabel("\u9B54\u6027\u7684\u85E5\u6C34");
		label_20.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_20.setBounds(15, 0, 210, 70);
		pn_menu_4_5.add(label_20);
		
		label_21 = new JLabel("x");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_21.setBounds(270, 15, 30, 30);
		pn_menu_4_5.add(label_21);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(300, 5, 70, 50);
		pn_menu_4_5.add(textField_13);
		
		checkBox_7 = new JCheckBox("\u8D08\u9001");
		checkBox_7.setFont(new Font("新細明體", Font.PLAIN, 20));
		checkBox_7.setBackground(new Color(0, 191, 255));
		checkBox_7.setBounds(20, 70, 90, 30);
		pn_menu_4_5.add(checkBox_7);
		
		button_10 = new JButton("+");
		button_10.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_10.setBounds(300, 70, 50, 30);
		pn_menu_4_5.add(button_10);
		
		/* menu_4 end */
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
		
		lblNewLabel_5 = new JLabel("\u6BCF\u65E5\u7279\u9910");
		lblNewLabel_5.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel_5.setBounds(10, 0, 160, 70);
		pn_menu_5_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("x");
		lblNewLabel_6.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(190, 20, 30, 30);
		pn_menu_5_1.add(lblNewLabel_6);
		
		textField_14 = new JTextField();
		textField_14.setBounds(220, 10, 70, 50);
		pn_menu_5_1.add(textField_14);
		textField_14.setColumns(10);
		
		btnNewButton_3 = new JButton("+");
		btnNewButton_3.setFont(new Font("新細明體", Font.PLAIN, 26));
		btnNewButton_3.setBounds(310, 20, 50, 30);
		pn_menu_5_1.add(btnNewButton_3);
		
		pn_menu_5_2 = new JPanel();
		pn_menu_5_2.setLayout(null);
		pn_menu_5_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5_2.setBackground(Color.GRAY);
		pn_menu_5_2.setBounds(0, 70, 390, 70);
		pn_menu_5.add(pn_menu_5_2);
		
		label_22 = new JLabel("\u5176\u4ED6-");
		label_22.setFont(new Font("新細明體", Font.PLAIN, 19));
		label_22.setBounds(10, 0, 180, 70);
		pn_menu_5_2.add(label_22);
		
		label_23 = new JLabel("x");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_23.setBounds(190, 20, 30, 30);
		pn_menu_5_2.add(label_23);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(220, 10, 70, 50);
		pn_menu_5_2.add(textField_15);
		
		button_11 = new JButton("+");
		button_11.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_11.setBounds(310, 20, 50, 30);
		pn_menu_5_2.add(button_11);
		
		pn_menu_5_3 = new JPanel();
		pn_menu_5_3.setLayout(null);
		pn_menu_5_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5_3.setBackground(Color.GRAY);
		pn_menu_5_3.setBounds(0, 140, 390, 70);
		pn_menu_5.add(pn_menu_5_3);
		
		label_24 = new JLabel("\u5176\u4ED6-");
		label_24.setFont(new Font("新細明體", Font.PLAIN, 19));
		label_24.setBounds(10, 0, 180, 70);
		pn_menu_5_3.add(label_24);
		
		label_25 = new JLabel("x");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_25.setBounds(190, 20, 30, 30);
		pn_menu_5_3.add(label_25);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(220, 10, 70, 50);
		pn_menu_5_3.add(textField_16);
		
		button_12 = new JButton("+");
		button_12.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_12.setBounds(310, 20, 50, 30);
		pn_menu_5_3.add(button_12);
		
		pn_menu_5_4 = new JPanel();
		pn_menu_5_4.setLayout(null);
		pn_menu_5_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5_4.setBackground(Color.GRAY);
		pn_menu_5_4.setBounds(0, 210, 390, 70);
		pn_menu_5.add(pn_menu_5_4);
		
		label_26 = new JLabel("\u5176\u4ED6-");
		label_26.setFont(new Font("新細明體", Font.PLAIN, 19));
		label_26.setBounds(10, 0, 180, 70);
		pn_menu_5_4.add(label_26);
		
		label_27 = new JLabel("x");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_27.setBounds(190, 20, 30, 30);
		pn_menu_5_4.add(label_27);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(220, 10, 70, 50);
		pn_menu_5_4.add(textField_17);
		
		button_13 = new JButton("+");
		button_13.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_13.setBounds(310, 20, 50, 30);
		pn_menu_5_4.add(button_13);
		
		pn_menu_5_5 = new JPanel();
		pn_menu_5_5.setLayout(null);
		pn_menu_5_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5_5.setBackground(Color.GRAY);
		pn_menu_5_5.setBounds(0, 280, 390, 70);
		pn_menu_5.add(pn_menu_5_5);
		
		label_28 = new JLabel("\u5176\u4ED6-");
		label_28.setFont(new Font("新細明體", Font.PLAIN, 19));
		label_28.setBounds(10, 0, 180, 70);
		pn_menu_5_5.add(label_28);
		
		label_29 = new JLabel("x");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setFont(new Font("新細明體", Font.PLAIN, 26));
		label_29.setBounds(190, 20, 30, 30);
		pn_menu_5_5.add(label_29);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(220, 10, 70, 50);
		pn_menu_5_5.add(textField_18);
		
		button_14 = new JButton("+");
		button_14.setFont(new Font("新細明體", Font.PLAIN, 26));
		button_14.setBounds(310, 20, 50, 30);
		pn_menu_5_5.add(button_14);
		
		/* menu_5 end */
		/* info */
		
		pn_info = new JPanel();
		pn_info.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8CC7\u8A0A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_info.setBounds(510, 10, 390, 130);
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
		
		lb_info_order_sum = new JLabel("\u6578\u91CF :");
		lb_info_order_sum.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_info_order_sum.setBounds(20, 100, 60, 20);
		pn_info.add(lb_info_order_sum);
		
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
		tf_info_table.setBounds(185, 73, 45, 25);
		pn_info.add(tf_info_table);
		tf_info_table.setColumns(10);
		
		tf_info_user_name = new JTextField();
		tf_info_user_name.setEditable(false);
		tf_info_user_name.setText("\u9673\u601D\u60DF");
		tf_info_user_name.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_user_name.setBounds(290, 47, 65, 25);
		pn_info.add(tf_info_user_name);
		tf_info_user_name.setColumns(10);
		
		tf_info_status = new JTextField();
		tf_info_status.setEditable(false);
		tf_info_status.setText("\u6E96\u5099\u4E2D");
		tf_info_status.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_status.setBounds(300, 73, 65, 25);
		pn_info.add(tf_info_status);
		tf_info_status.setColumns(10);
		
		tf_info_order_sum = new JTextField();
		tf_info_order_sum.setHorizontalAlignment(SwingConstants.CENTER);
		tf_info_order_sum.setText("23");
		tf_info_order_sum.setFont(new Font("新細明體", Font.PLAIN, 19));
		tf_info_order_sum.setEditable(false);
		tf_info_order_sum.setBounds(75, 100, 30, 20);
		pn_info.add(tf_info_order_sum);
		tf_info_order_sum.setColumns(10);
		
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
