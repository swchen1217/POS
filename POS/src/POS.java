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
	
	/* main */
	JFrame fm_poa_main;
	Thread th_nowtime;
	JTabbedPane tab_menu,tab_order_list;
	JPanel pn_menu_1,pn_menu_2,pn_menu_3,pn_menu_4,pn_menu_5,pn_list_1,pn_list_2,pn_list_3,pn_list_4,pn_list_5;
	JLabel lb_note;
	JTextField tf_note;
	File f;
	BufferedWriter bw;
	BufferedReader br;
	String oldordernum="";
	int pay, change, order_sum=0, smalltotal=0, off=0, all_off=0, item_sum2=0, order_list_sum=0, m=0 ,n=0 ,tmp=-1;
	int list[]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	boolean isOrder[]=new boolean[53];
	double total=0 ,discount=100;
	
	/* main end*/
	
	/* info */
	JPanel pn_info;
	JLabel lb_info_nowtime,lb_info_user_num,lb_info_order_num,lb_info_table,lb_info_user_name,lb_info_status,lb_info_order_sum;
	JTextField tf_info_user_num,tf_info_order_num,tf_info_table,tf_info_user_name,tf_info_status,tf_info_order_sum;
	/* info end */
	
	/* meals */
	int qty[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int small_total[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int price[]={140,190,160,160,210,210,180,230,120,155,140,140,175,175,160,195,120,155,140,140,175,175,160,195,60,140,120,120,50,80,50,80,50,80,50,80,50,80,50,0,50,0,50,0,50,0,50,0,0,0,0,0,0,0};
	String item_name[]={"異想牛漢堡","異想牛漢堡(肉)","異想牛漢堡(培)","異想牛漢堡(起)","異想牛漢堡(肉培)","異想牛漢堡(肉起)","異想牛漢堡(培起)","異想牛漢堡(肉培起)",
            			"異想豬漢堡","異想豬漢堡(肉)","異想豬漢堡(培)","異想豬漢堡(起)","異想豬漢堡(肉培)","異想豬漢堡(肉起)","異想豬漢堡(培起)","異想豬漢堡(肉培起)",
            			"異想雞漢堡","異想雞漢堡(肉)","異想雞漢堡(培)","異想雞漢堡(起)","異想雞漢堡(肉培)","異想雞漢堡(肉起)","異想雞漢堡(培起)","異想雞漢堡(肉培起)",
            			"實驗咖哩飯","實驗牛咖哩飯","實驗豬咖哩飯","實驗雞咖哩飯",
            			"成長的回憶","成長的回憶(套)","草原上的青雞","草原上的青雞(套)","低調中的高貴","低調中的高貴(套)","親子間的南瓜","親子間的南瓜(套)","牛奶海洋裡的鮭魚","牛奶海洋裡的鮭魚(套)",
            			"憂愁的藥水","憂愁的藥水(贈)","炙烈的藥水","炙烈的藥水(贈)","高貴的藥水","高貴的藥水(贈)","典雅的藥水","典雅的藥水(贈)","魔性的藥水","魔性的藥水(贈)",
            			"每日特餐","其他-","其他-","其他-","其他-"};
	
	/* meals end */
	/* item */
	
	JPanel pn_item[]=new JPanel[53];
	JLabel lb_item_name[]=new JLabel[53], lb_x[]=new JLabel[53], lb_e[]=new JLabel[53], lb_qty[]=new JLabel[53], lb_small_total[]=new JLabel[53];
	JButton btn_del[]=new JButton[53];
	
	/*item end*/
	/* menu */
	
	JLabel lb_menu_name[]=new JLabel[22],lb_menu_x[]=new JLabel[22];
	JTextField tf_menu_qty[]=new JTextField[22];
	JCheckBox cb[]=new JCheckBox[19];
	JButton btn_add[]=new JButton[22];
	JPanel pn_menu_1_1,pn_menu_1_2,pn_menu_1_3,pn_menu_2_1,pn_menu_2_2,pn_menu_2_3,pn_menu_2_4,pn_menu_3_1,pn_menu_3_2,pn_menu_3_3,pn_menu_3_4,pn_menu_3_5,pn_menu_4_1,pn_menu_4_2,pn_menu_4_3,pn_menu_4_4,pn_menu_4_5,pn_menu_5_1,pn_menu_5_2,pn_menu_5_3,pn_menu_5_4,pn_menu_5_5;
	
	/* menu end */
	/* checkout */
	
	JPanel pn_checkout;
	JTextField tf_ch_small_total,tf_ch_all_off,tf_ch_discount,tf_ch_off,tf_ch_total,tf_ch_pay,tf_ch_change;
	JLabel lb_ch_total,lb_ch_pay,lb_ch_change,lb_ch_small_total,lb_ch_discount,lb_ch_off,lb_ch_all_off;
	
	/* checkout end */
	/* manege */
	
	JPanel pn_manage;
	JButton btn_man_clear,btn_man_re_print,btn_man_printer_set,btn_man_menu_5_set,btn_ch_chechout,btn_ch_off_set,btn_ch_next,btn_man_table,btn_man_stock,btn_man_user_change,btn_man_look,btn_man_exit,btn_man_order_num_reset;
	
	/* manage end */
	
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
		startRecord();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		/* main */
		
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
		
		lb_note = new JLabel("\u5099\u8A3B");
		lb_note.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_note.setBounds(520, 550, 50, 33);
		fm_poa_main.getContentPane().add(lb_note);
		
		tf_note = new JTextField();
		tf_note.setFont(new Font("新細明體", Font.PLAIN, 25));
		tf_note.setBounds(573, 550, 315, 30);
		fm_poa_main.getContentPane().add(tf_note);
		tf_note.setColumns(10);
		
		for(int i=0;i<53;i++)
			isOrder[i]=false;
		
		/* main end */
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
		tf_info_user_name.setBounds(290, 47, 65, 25);
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
		
		/* info end */
		/* checkout */
		
		pn_checkout = new JPanel();
		pn_checkout.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7D50\u5E33", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_checkout.setBounds(10, 580, 880, 130);
		fm_poa_main.getContentPane().add(pn_checkout);
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
		
		/* checkout end */
		/* manage */
		
		btn_ch_chechout = new JButton("\u7D50\u5E33");
		btn_ch_chechout.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_ch_chechout.setBounds(430, 25, 90, 90);
		pn_checkout.add(btn_ch_chechout);
		
		btn_ch_off_set = new JButton("\u512A\u60E0");
		btn_ch_off_set.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_ch_off_set.setBounds(580, 25, 90, 90);
		pn_checkout.add(btn_ch_off_set);
		
		btn_ch_next = new JButton("\u4E0B\u4E00\u7B46");
		btn_ch_next.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_ch_next.setBounds(730, 25, 110, 90);
		pn_checkout.add(btn_ch_next);
		
		pn_manage = new JPanel();
		pn_manage.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_manage.setBounds(510, 140, 390, 345);
		fm_poa_main.getContentPane().add(pn_manage);
		pn_manage.setLayout(null);
		
		btn_man_table = new JButton("\u684C\u4F4D\u7BA1\u7406");
		btn_man_table.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_table.setBounds(10, 20, 100, 80);
		pn_manage.add(btn_man_table);
		
		btn_man_stock = new JButton("\u5EAB\u5B58\u7BA1\u7406");
		btn_man_stock.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_stock.setBounds(10, 100, 100, 80);
		pn_manage.add(btn_man_stock);
		
		btn_man_user_change = new JButton("\u5207\u63DB\u4F7F\u7528\u8005");
		btn_man_user_change.setFont(new Font("新細明體", Font.PLAIN, 13));
		btn_man_user_change.setBounds(150, 101, 100, 80);
		pn_manage.add(btn_man_user_change);
		
		btn_man_look = new JButton("\u9396\u5B9A");
		btn_man_look.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_look.setBounds(150, 19, 100, 82);
		pn_manage.add(btn_man_look);
		
		btn_man_exit = new JButton("\u96E2\u958B");
		btn_man_exit.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_exit.setBounds(280, 20, 100, 160);
		pn_manage.add(btn_man_exit);
		btn_man_exit.addActionListener(this);
		
		btn_man_clear = new JButton("\u5168\u90E8\u6E05\u9664");
		btn_man_clear.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_clear.setBounds(10, 180, 100, 80);
		pn_manage.add(btn_man_clear);
		btn_man_clear.addActionListener(this);
		
		btn_man_menu_5_set = new JButton("\u5176\u4ED6\u985E \u8A2D\u5B9A");
		btn_man_menu_5_set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_man_menu_5_set.setFont(new Font("新細明體", Font.PLAIN, 13));
		btn_man_menu_5_set.setBounds(280, 180, 100, 80);
		pn_manage.add(btn_man_menu_5_set);
		
		btn_man_re_print = new JButton("\u518D\u5217\u5370");
		btn_man_re_print.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_re_print.setBounds(10, 260, 100, 80);
		pn_manage.add(btn_man_re_print);
		
		btn_man_printer_set = new JButton("\u5370\u8868\u6A5F\u8A2D\u5B9A");
		btn_man_printer_set.setFont(new Font("新細明體", Font.PLAIN, 13));
		btn_man_printer_set.setBounds(150, 260, 100, 80);
		pn_manage.add(btn_man_printer_set);
		
		btn_man_order_num_reset = new JButton("\u55AE\u865F\u91CD\u8A2D");
		btn_man_order_num_reset.setFont(new Font("新細明體", Font.PLAIN, 15));
		btn_man_order_num_reset.setBounds(150, 180, 100, 80);
		pn_manage.add(btn_man_order_num_reset);
		
		/* manage end */
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
			btn_del[i].addActionListener(this);
			btn_del[i].setFont(new Font("新細明體", Font.BOLD, 26));
			btn_del[i].setBounds(405, 20, 60, 40);
			pn_item[i].add(btn_del[i]);
			btn_del[i].addActionListener(this);
					
		}
		
	}
	void add(int i) {
		
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
	private void del(int i) {
		
		qty[i]--;
		small_total[i]=qty[i]*price[i];
		lb_qty[i].setText(qty[i]+"");
		lb_small_total[i].setText(small_total[i]+"");
		smalltotal-=price[i];
		tf_ch_small_total.setText(smalltotal+"");
		order_sum--;
		tf_info_order_sum.setText(order_sum+"");
		total();
		for(int w=0;w<40;w++)
		{
			if(list[w]==i && qty[i]==0){
				list[w]=-1;
				break;
			}
		}
		m=0;
		for(int q=0;q<order_list_sum;q++)
		{
			if(list[q]!=-1)
				m++;
			else
				break;
		}
		for(int e=m;e<order_list_sum;e++)
		{
			tmp=list[e+1];
			list[e]=tmp;
			
		}
		order_list_sum--;
		sort();
		tab_order_list.updateUI();
		
	}
	void sort()  {
		
		pn_list_1.removeAll();
		pn_list_2.removeAll();
		pn_list_3.removeAll();
		pn_list_4.removeAll();
		pn_list_5.removeAll();
		tab_order_list.updateUI();
		n=0;
		for(int i=0;i<order_list_sum;i++)
		{
			if(list[i]!=-1)
				n++;
			else
				break;
		}
		item_sum2=0;
		for(int j=0;j<n;j++)
		{
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
				check();
			}
		}
		tab_order_list.updateUI();
	}
	void check() {
		
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
	void total()
	{
		total=smalltotal*(discount/100)-off;
		tf_ch_total.setText(total+"");
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
		tf_ch_pay.setText(pay+"");
		tf_ch_change.setText(change+"");
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
		check();
		sort();
	}
	void startRecord()
	{
		
		f=new File("C:/Madhouse POS/system/system.txt");
		if(!f.exists())
		{
			try{
				f.getParentFile().mkdirs();
				bw=new BufferedWriter(new FileWriter(f.getAbsolutePath()));
				bw.write("0");
				bw.newLine();
				bw.flush();
			}catch(Exception e){}
		}else
		{
			try{
	            br=new BufferedReader(new FileReader(f.getAbsolutePath()));
	            int linenumber = 0;
	    		String txt = "";
	    		int lines = 0;
	    		while (txt != null) {
	    			txt = br.readLine();
	    			if (lines == linenumber) {
	    				oldordernum=txt;
	    			}
	    			lines++;
	    		}
	    		br.close();
	    		System.out.println(oldordernum);
			}catch(Exception e){}	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<qty.length; i++)
		{
			if(e.getSource()==btn_del[i] && qty[i]>0)
				del(i);	
		}
		if(e.getSource()==btn_man_exit)
			fm_poa_main.dispose();
		if(e.getSource()==btn_man_clear)
		{
			reset();
		}
	}
}
