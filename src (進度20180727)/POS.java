import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class POS implements ActionListener{
	
	int balance[]={100,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,500,500,500,3000,5000};
	JLabel lb_balance[]=new JLabel[28];
	JTextField tf_update[]=new JTextField[28];
	
	String num_time="";
	File f,f_num,f_monthly,f_receipt,f_balance;
	BufferedWriter bw,bw_monthly,bw_balance;
	BufferedReader br;
	String oldRecord="";
	int current_num=1;
	JLabel lb_current_num;
	JFrame frmMadhousePos;
	JTabbedPane tabbedPane, tabbedPane_list;
	JPanel pn_order, pn_manage, pn_list_1, pn_list_2, pn_list_3, pn_menu_1, pn_menu_2, pn_menu_3, pn_menu_4, pn_menu_5;
	JButton btn_checkout, btn_next;
	JButton btn_add_1, btn_add_2, btn_add_3, btn_add_4, btn_add_5, btn_add_6, btn_add_7, btn_add_8, btn_add_9, btn_add_10,
	                btn_add_11, btn_add_12, btn_add_13, btn_add_14, btn_add_15, btn_add_16, btn_add_17, btn_add_18, btn_add_19;
	JPanel pn_item[]=new JPanel[50];
	JLabel lb_item[]=new JLabel[50], lbx[]=new JLabel[50], lbe[]=new JLabel[50], lb_qty[]=new JLabel[50], lb_small_total[]=new JLabel[50];
	JButton btn_del[]=new JButton[50];
	JRadioButton rb1,rb2;
    ButtonGroup bg1;
	JComboBox<Object> comboBox;
	JCheckBox checkBox_1, checkBox_2, checkBox_3, checkBox_4, checkBox_5, checkBox_6, checkBox_7, checkBox_8, checkBox_9, checkBox_10,
	                  checkBox_11, checkBox_12, checkBox_13, checkBox_14, checkBox_15, checkBox_16, checkBox_17, checkBox_18, checkBox_19;
	JTextField tf_comment, tf_total, tf_pay, tf_change, tf_other_name, tf_other_price;
	int qty[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int price[]={140,190,160,160,210,210,180,230,120,155,140,140,175,175,160,195,120,155,140,140,175,175,160,195,60,140,120,120,50,80,50,80,50,80,50,80,50,80,50,50,50,50,50,0,0,0,0,0,250,0};
	int small_total[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	String item_name[]={"異想牛漢堡          ","異想牛漢堡(肉)      ","異想牛漢堡(培)      ","異想牛漢堡(起)      ","異想牛漢堡(肉培)    ","異想牛漢堡(肉起)    ","異想牛漢堡(培起)    ","異想牛漢堡(肉培起)  ",
			            "異想豬漢堡          ","異想豬漢堡(肉)      ","異想豬漢堡(培)      ","異想豬漢堡(起)      ","異想豬漢堡(肉培)    ","異想豬漢堡(肉起)    ","異想豬漢堡(培起)    ","異想豬漢堡(肉培起)  ",
			            "異想雞漢堡          ","異想雞漢堡(肉)      ","異想雞漢堡(培)      ","異想雞漢堡(起)      ","異想雞漢堡(肉培)    ","異想雞漢堡(肉起)    ","異想雞漢堡(培起)    ","異想雞漢堡(肉培起)  ",
			            "實驗咖哩飯          ","實驗牛咖哩飯        ","實驗豬咖哩飯        ","實驗雞咖哩飯        ",
			            "成長的回憶          ","成長的回憶(套)      ","草原上的青雞        ","草原上的青雞(套)    ","低調中的高貴        ","低調中的高貴(套)    ","親子間的南瓜        ","親子間的南瓜(套)    ","牛奶海洋裡的鮭魚    ","牛奶海洋裡的鮭魚(套)",
			            "憂愁的藥水          ","炙烈的藥水          ","高貴的藥水          ","典雅的藥水          ","魔性的藥水          ",
			            "憂愁的藥水(贈)      ","炙烈的藥水(贈)      ","高貴的藥水(贈)      ","典雅的藥水(贈)      ","魔性的藥水(贈)      ",
			            "當日特餐            ","其它                "};
	int total=0, pay, change;
	boolean isChecked=false;
	int y=0;
	private JPanel pn_balance_1, pn_balance_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS window = new POS();
					window.frmMadhousePos.setVisible(true);
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
		startRecord();
		startRecordMonthly();
		checkCurrentNumber();
		startBalanceManagement();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		pn_order=new JPanel();
		pn_manage=new JPanel();
		pn_list_1=new JPanel();
		pn_list_2=new JPanel();
		pn_list_3=new JPanel();
		
		frmMadhousePos = new JFrame();
		frmMadhousePos.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/icon.png")));
		frmMadhousePos.setResizable(false);
		frmMadhousePos.setTitle("Madhouse - POS");
		frmMadhousePos.setBounds(100, 100, 1333, 750);
		frmMadhousePos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMadhousePos.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1380, 725);
		tabbedPane.addTab("點餐系統", pn_order);
		pn_order.setLayout(null);

/* 第 1 區  */
		pn_menu_1 = new JPanel();
		pn_menu_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_1.setBackground(new Color(255, 255, 204));
		pn_menu_1.setBounds(594, 50, 417, 238);
		pn_order.add(pn_menu_1);
		pn_menu_1.setLayout(null);
  /* 1-1 */
		JLabel lb1 = new JLabel("異想牛漢堡");
		lb1.setToolTipText("");
		lb1.setFont(new Font("新細明體", Font.BOLD, 26));
		lb1.setBounds(14, 13, 143, 42);
		pn_menu_1.add(lb1);
		
		checkBox_1 = new JCheckBox("\u8089");
		checkBox_1.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_1.setBackground(new Color(255, 255, 204));
		checkBox_1.setBounds(166, 21, 50, 27);
		pn_menu_1.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("\u57F9");
		checkBox_2.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_2.setBackground(new Color(255, 255, 204));
		checkBox_2.setBounds(220, 21, 50, 27);
		pn_menu_1.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("\u8D77");
		checkBox_3.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_3.setBackground(new Color(255, 255, 204));
		checkBox_3.setBounds(273, 21, 50, 27);
		pn_menu_1.add(checkBox_3);
				
		btn_add_1 = new JButton("+");
		btn_add_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!checkBox_1.isSelected() && !checkBox_2.isSelected() && !checkBox_3.isSelected())
				{
					qty[0]++;
					small_total[0]=qty[0]*price[0];
					lb_qty[0].setText(qty[0]+"");
					lb_small_total[0].setText(small_total[0]+"");
					
					balance[0]--;balance[1]--;balance[4]--;balance[5]--;balance[6]--;balance[7]--;balance[10]--;balance[11]--;
					
				}
				if(checkBox_1.isSelected() && !checkBox_2.isSelected() && !checkBox_3.isSelected())
				{
					qty[1]++;
					small_total[1]=qty[1]*price[1];
					lb_qty[1].setText(qty[1]+"");
					lb_small_total[1].setText(small_total[1]+"");
					
					balance[0]--;balance[1]--;balance[4]--;balance[5]--;balance[6]--;balance[7]--;balance[10]--;balance[11]--;balance[1]--;
					
				}
				if(!checkBox_1.isSelected() && checkBox_2.isSelected() && !checkBox_3.isSelected())
				{
					qty[2]++;
					small_total[2]=qty[2]*price[2];
					lb_qty[2].setText(qty[2]+"");
					lb_small_total[2].setText(small_total[2]+"");
					
					balance[0]--;balance[1]--;balance[4]--;balance[5]--;balance[6]--;balance[7]--;balance[10]--;balance[11]--;balance[16]--;
					
				}
				if(!checkBox_1.isSelected() && !checkBox_2.isSelected() && checkBox_3.isSelected())
				{
					qty[3]++;
					small_total[3]=qty[3]*price[3];
					lb_qty[3].setText(qty[3]+"");
					lb_small_total[3].setText(small_total[3]+"");
					
					balance[0]--;balance[1]--;balance[4]--;balance[5]--;balance[6]--;balance[7]--;balance[10]--;balance[11]--;balance[15]--;
					
				}
				if(checkBox_1.isSelected() && checkBox_2.isSelected() && !checkBox_3.isSelected())
				{
					qty[4]++;
					small_total[4]=qty[4]*price[4];
					lb_qty[4].setText(qty[4]+"");
					lb_small_total[4].setText(small_total[4]+"");
					
					balance[0]--;balance[1]--;balance[4]--;balance[5]--;balance[6]--;balance[7]--;balance[10]--;balance[11]--;balance[1]--;balance[16]--;
					
				}
				if(checkBox_1.isSelected() && !checkBox_2.isSelected() && checkBox_3.isSelected())
				{
					qty[5]++;
					small_total[5]=qty[5]*price[5];
					lb_qty[5].setText(qty[5]+"");
					lb_small_total[5].setText(small_total[5]+"");
					
					balance[0]--;balance[1]--;balance[4]--;balance[5]--;balance[6]--;balance[7]--;balance[10]--;balance[11]--;balance[1]--;balance[15]--;
					
				}
				if(!checkBox_1.isSelected() && checkBox_2.isSelected() && checkBox_3.isSelected())
				{
					qty[6]++;
					small_total[6]=qty[6]*price[6];
					lb_qty[6].setText(qty[6]+"");
					lb_small_total[6].setText(small_total[6]+"");
					
					balance[0]--;balance[1]--;balance[4]--;balance[5]--;balance[6]--;balance[7]--;balance[10]--;balance[11]--;balance[15]--;balance[16]--;
					
				}
				if(checkBox_1.isSelected() && checkBox_2.isSelected() && checkBox_3.isSelected())
				{
					qty[7]++;
					small_total[7]=qty[7]*price[7];
					lb_qty[7].setText(qty[7]+"");
					lb_small_total[7].setText(small_total[7]+"");
					
					balance[0]--;balance[1]--;balance[4]--;balance[5]--;balance[6]--;balance[7]--;balance[10]--;balance[11]--;balance[1]--;balance[15]--;balance[16]--;
					
				}
				
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_1.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_1.setBounds(346, 13, 57, 42);
		pn_menu_1.add(btn_add_1);
		
  /* 1-2 */		
		JLabel lb2 = new JLabel("異想豬漢堡");
		lb2.setFont(new Font("新細明體", Font.BOLD, 26));
		lb2.setBounds(14, 68, 143, 42);
		pn_menu_1.add(lb2);
		
		checkBox_4 = new JCheckBox("\u8089");
		checkBox_4.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_4.setBackground(new Color(255, 255, 204));
		checkBox_4.setBounds(166, 76, 50, 27);
		pn_menu_1.add(checkBox_4);
		
		checkBox_5 = new JCheckBox("\u57F9");
		checkBox_5.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_5.setBackground(new Color(255, 255, 204));
		checkBox_5.setBounds(220, 76, 50, 27);
		pn_menu_1.add(checkBox_5);
		
		checkBox_6 = new JCheckBox("\u8D77");
		checkBox_6.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_6.setBackground(new Color(255, 255, 204));
		checkBox_6.setBounds(273, 76, 50, 27);
		pn_menu_1.add(checkBox_6);
		
		btn_add_2 = new JButton("+");
		btn_add_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!checkBox_4.isSelected() && !checkBox_5.isSelected() && !checkBox_6.isSelected())
				{
					qty[8]++;
					small_total[8]=qty[8]*price[8];
					lb_qty[8].setText(qty[8]+"");
					lb_small_total[8].setText(small_total[8]+"");
					
					balance[0]--;balance[2]--;balance[4]--;balance[5]--;balance[6]--;balance[8]--;balance[10]--;balance[11]--;
					
				}
				if(checkBox_4.isSelected() && !checkBox_5.isSelected() && !checkBox_6.isSelected())
				{
					qty[9]++;
					small_total[9]=qty[9]*price[9];
					lb_qty[9].setText(qty[9]+"");
					lb_small_total[9].setText(small_total[9]+"");
					
					balance[0]--;balance[2]--;balance[4]--;balance[5]--;balance[6]--;balance[8]--;balance[10]--;balance[11]--;balance[2]--;
					
				}
				if(!checkBox_4.isSelected() && checkBox_5.isSelected() && !checkBox_6.isSelected())
				{
					qty[10]++;
					small_total[10]=qty[10]*price[10];
					lb_qty[10].setText(qty[10]+"");
					lb_small_total[10].setText(small_total[10]+"");
					
					balance[0]--;balance[2]--;balance[4]--;balance[5]--;balance[6]--;balance[8]--;balance[10]--;balance[11]--;balance[16]--;
					
				}
				if(!checkBox_4.isSelected() && !checkBox_5.isSelected() && checkBox_6.isSelected())
				{
					qty[11]++;
					small_total[11]=qty[11]*price[11];
					lb_qty[11].setText(qty[11]+"");
					lb_small_total[11].setText(small_total[11]+"");
					
					balance[0]--;balance[2]--;balance[4]--;balance[5]--;balance[6]--;balance[8]--;balance[10]--;balance[11]--;balance[15]--;
					
				}
				if(checkBox_4.isSelected() && checkBox_5.isSelected() && !checkBox_6.isSelected())
				{
					qty[12]++;
					small_total[12]=qty[12]*price[12];
					lb_qty[12].setText(qty[12]+"");
					lb_small_total[12].setText(small_total[12]+"");
					
					balance[0]--;balance[2]--;balance[4]--;balance[5]--;balance[6]--;balance[8]--;balance[10]--;balance[11]--;balance[2]--;balance[16]--;
					
				}
				if(checkBox_4.isSelected() && !checkBox_5.isSelected() && checkBox_6.isSelected())
				{
					qty[13]++;
					small_total[13]=qty[13]*price[13];
					lb_qty[13].setText(qty[13]+"");
					lb_small_total[13].setText(small_total[13]+"");
					
					balance[0]--;balance[2]--;balance[4]--;balance[5]--;balance[6]--;balance[8]--;balance[10]--;balance[11]--;balance[2]--;balance[15]--;
					
				}
				if(!checkBox_4.isSelected() && checkBox_5.isSelected() && checkBox_6.isSelected())
				{
					qty[14]++;
					small_total[14]=qty[14]*price[14];
					lb_qty[14].setText(qty[14]+"");
					lb_small_total[14].setText(small_total[14]+"");
					
					balance[0]--;balance[2]--;balance[4]--;balance[5]--;balance[6]--;balance[8]--;balance[10]--;balance[11]--;balance[15]--;balance[16]--;
					
				}
				if(checkBox_4.isSelected() && checkBox_5.isSelected() && checkBox_6.isSelected())
				{
					qty[15]++;
					small_total[15]=qty[15]*price[15];
					lb_qty[15].setText(qty[15]+"");
					lb_small_total[15].setText(small_total[15]+"");
					
					balance[0]--;balance[2]--;balance[4]--;balance[5]--;balance[6]--;balance[8]--;balance[10]--;balance[11]--;balance[2]--;balance[15]--;balance[16]--;
					
				}
				
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_2.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_2.setBounds(346, 68, 57, 42);
		pn_menu_1.add(btn_add_2);

  /* 1-3 */			
		JLabel lb3 = new JLabel("異想雞漢堡");
		lb3.setFont(new Font("新細明體", Font.BOLD, 26));
		lb3.setBounds(14, 123, 143, 42);
		pn_menu_1.add(lb3);
		
		checkBox_7 = new JCheckBox("\u8089");
		checkBox_7.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_7.setBackground(new Color(255, 255, 204));
		checkBox_7.setBounds(166, 131, 50, 27);
		pn_menu_1.add(checkBox_7);
		
		checkBox_8 = new JCheckBox("\u57F9");
		checkBox_8.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_8.setBackground(new Color(255, 255, 204));
		checkBox_8.setBounds(220, 131, 50, 27);
		pn_menu_1.add(checkBox_8);
		
		checkBox_9 = new JCheckBox("\u8D77");
		checkBox_9.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_9.setBackground(new Color(255, 255, 204));
		checkBox_9.setBounds(273, 131, 50, 27);
		pn_menu_1.add(checkBox_9);
		
		btn_add_3 = new JButton("+");
		btn_add_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkBox_7.isSelected() && !checkBox_8.isSelected() && !checkBox_9.isSelected())
				{
					qty[16]++;
					small_total[16]=qty[16]*price[16];
					lb_qty[16].setText(qty[16]+"");
					lb_small_total[16].setText(small_total[16]+"");
					
					balance[0]--;balance[3]--;balance[4]--;balance[5]--;balance[6]--;balance[9]--;balance[10]--;balance[11]--;
					
				}
				if(checkBox_7.isSelected() && !checkBox_8.isSelected() && !checkBox_9.isSelected())
				{
					qty[17]++;
					small_total[17]=qty[17]*price[17];
					lb_qty[17].setText(qty[17]+"");
					lb_small_total[17].setText(small_total[17]+"");
					
					balance[0]--;balance[3]--;balance[4]--;balance[5]--;balance[6]--;balance[9]--;balance[10]--;balance[11]--;balance[3]--;
					
				}
				if(!checkBox_7.isSelected() && checkBox_8.isSelected() && !checkBox_9.isSelected())
				{
					qty[18]++;
					small_total[18]=qty[18]*price[18];
					lb_qty[18].setText(qty[18]+"");
					lb_small_total[18].setText(small_total[18]+"");
					
					balance[0]--;balance[3]--;balance[4]--;balance[5]--;balance[6]--;balance[9]--;balance[10]--;balance[11]--;balance[16]--;
					
				}
				if(!checkBox_7.isSelected() && !checkBox_8.isSelected() && checkBox_9.isSelected())
				{
					qty[19]++;
					small_total[19]=qty[19]*price[19];
					lb_qty[19].setText(qty[19]+"");
					lb_small_total[19].setText(small_total[19]+"");
					
					balance[0]--;balance[3]--;balance[4]--;balance[5]--;balance[6]--;balance[9]--;balance[10]--;balance[11]--;balance[15]--;
					
				}
				if(checkBox_7.isSelected() && checkBox_8.isSelected() && !checkBox_9.isSelected())
				{
					qty[20]++;
					small_total[20]=qty[20]*price[20];
					lb_qty[20].setText(qty[20]+"");
					lb_small_total[20].setText(small_total[20]+"");
					
					balance[0]--;balance[3]--;balance[4]--;balance[5]--;balance[6]--;balance[9]--;balance[10]--;balance[11]--;balance[3]--;balance[16]--;
					
				}
				if(checkBox_7.isSelected() && !checkBox_8.isSelected() && checkBox_9.isSelected())
				{
					qty[21]++;
					small_total[21]=qty[21]*price[21];
					lb_qty[21].setText(qty[21]+"");
					lb_small_total[21].setText(small_total[21]+"");
					
					balance[0]--;balance[3]--;balance[4]--;balance[5]--;balance[6]--;balance[9]--;balance[10]--;balance[11]--;balance[3]--;balance[15]--;
					
				}
				if(!checkBox_7.isSelected() && checkBox_8.isSelected() && checkBox_9.isSelected())
				{
					qty[22]++;
					small_total[22]=qty[22]*price[22];
					lb_qty[22].setText(qty[22]+"");
					lb_small_total[22].setText(small_total[22]+"");
					
					balance[0]--;balance[3]--;balance[4]--;balance[5]--;balance[6]--;balance[9]--;balance[10]--;balance[11]--;balance[15]--;balance[16]--;
					
				}
				if(checkBox_7.isSelected() && checkBox_8.isSelected() && checkBox_9.isSelected())
				{
					qty[23]++;
					small_total[23]=qty[23]*price[23];
					lb_qty[23].setText(qty[23]+"");
					lb_small_total[23].setText(small_total[23]+"");
					
					balance[0]--;balance[3]--;balance[4]--;balance[5]--;balance[6]--;balance[9]--;balance[10]--;balance[11]--;balance[3]--;balance[15]--;balance[16]--;
					
				}
				
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_3.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_3.setBounds(346, 123, 57, 42);
		pn_menu_1.add(btn_add_3);
		
/* 第 2 區  */
		pn_menu_2 = new JPanel();
		pn_menu_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_2.setBackground(new Color(204, 255, 204));
		pn_menu_2.setBounds(1022, 50, 292, 238);
		pn_order.add(pn_menu_2);
		pn_menu_2.setLayout(null);
		
		JLabel lb4 = new JLabel("\u5BE6\u9A57\u5496\u54E9\u98EF");
		lb4.setBounds(14, 13, 143, 42);
		pn_menu_2.add(lb4);
		lb4.setToolTipText("");
		lb4.setFont(new Font("新細明體", Font.BOLD, 26));
		
		btn_add_4 = new JButton("+");
		btn_add_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				qty[24]++;
				small_total[24]=qty[24]*price[24];
				lb_qty[24].setText(qty[24]+"");
				lb_small_total[24].setText(small_total[24]+"");
				
				balance[12]--;balance[13]--;balance[10]--;balance[11]--;
			
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_4.setBounds(220, 13, 57, 42);
		pn_menu_2.add(btn_add_4);
		btn_add_4.setFont(new Font("新細明體", Font.BOLD, 20));
		
		JLabel lb5 = new JLabel("\u5BE6\u9A57\u725B\u5496\u54E9\u98EF");
		lb5.setToolTipText("");
		lb5.setFont(new Font("新細明體", Font.BOLD, 26));
		lb5.setBounds(14, 68, 192, 42);
		pn_menu_2.add(lb5);
		
		btn_add_5 = new JButton("+");
		btn_add_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				qty[25]++;
				small_total[25]=qty[25]*price[25];
				lb_qty[25].setText(qty[25]+"");
				lb_small_total[25].setText(small_total[25]+"");
				
				balance[12]--;balance[13]--;balance[10]--;balance[11]--;balance[1]--;
			
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_5.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_5.setBounds(220, 68, 57, 42);
		pn_menu_2.add(btn_add_5);
		
		JLabel lb6 = new JLabel("\u5BE6\u9A57\u8C6C\u5496\u54E9\u98EF");
		lb6.setToolTipText("");
		lb6.setFont(new Font("新細明體", Font.BOLD, 26));
		lb6.setBounds(14, 123, 192, 42);
		pn_menu_2.add(lb6);
		
		btn_add_6 = new JButton("+");
		btn_add_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				qty[26]++;
				small_total[26]=qty[26]*price[26];
				lb_qty[26].setText(qty[26]+"");
				lb_small_total[26].setText(small_total[26]+"");
				
				balance[12]--;balance[13]--;balance[10]--;balance[11]--;balance[2]--;
			
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_6.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_6.setBounds(220, 123, 57, 42);
		pn_menu_2.add(btn_add_6);
		
		JLabel lb7 = new JLabel("\u5BE6\u9A57\u96DE\u5496\u54E9\u98EF");
		lb7.setToolTipText("");
		lb7.setFont(new Font("新細明體", Font.BOLD, 26));
		lb7.setBounds(14, 178, 192, 42);
		pn_menu_2.add(lb7);
		
		btn_add_7 = new JButton("+");
		btn_add_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				qty[27]++;
				small_total[27]=qty[27]*price[27];
				lb_qty[27].setText(qty[27]+"");
				lb_small_total[27].setText(small_total[27]+"");
				
				balance[12]--;balance[13]--;balance[10]--;balance[11]--;balance[3]--;
			
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_7.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_7.setBounds(220, 178, 57, 42);
		pn_menu_2.add(btn_add_7);
		
/* 第3區  */
		pn_menu_3 = new JPanel();
		pn_menu_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_3.setBackground(new Color(204, 204, 255));
		pn_menu_3.setBounds(594, 295, 399, 293);
		pn_order.add(pn_menu_3);
		pn_menu_3.setLayout(null);
		
		JLabel lb8 = new JLabel("\u6210\u9577\u7684\u56DE\u61B6");
		lb8.setToolTipText("");
		lb8.setFont(new Font("新細明體", Font.BOLD, 26));
		lb8.setBounds(14, 13, 143, 42);
		pn_menu_3.add(lb8);
		
		checkBox_10 = new JCheckBox("\u5957");
		checkBox_10.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_10.setBackground(new Color(204, 204, 255));
		checkBox_10.setBounds(168, 21, 50, 27);
		pn_menu_3.add(checkBox_10);
		
		btn_add_8 = new JButton("+");
		btn_add_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_10.isSelected())
				{
					qty[28]++;
					small_total[28]=qty[28]*price[28];
					lb_qty[28].setText(qty[28]+"");
					lb_small_total[28].setText(small_total[28]+"");
					
					balance[14]--;balance[15]--;balance[17]--;
				}else
				{
					qty[29]++;
					small_total[29]=qty[29]*price[29];
					lb_qty[29].setText(qty[29]+"");
					lb_small_total[29].setText(small_total[29]+"");
					
					balance[14]--;balance[15]--;balance[17]--;balance[10]--;balance[11]--;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_8.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_8.setBounds(328, 13, 57, 42);
		pn_menu_3.add(btn_add_8);
		
		JLabel lb9 = new JLabel("\u8349\u539F\u4E0A\u7684\u9752\u96DE");
		lb9.setToolTipText("");
		lb9.setFont(new Font("新細明體", Font.BOLD, 26));
		lb9.setBounds(14, 68, 174, 42);
		pn_menu_3.add(lb9);
		
		checkBox_11 = new JCheckBox("\u5957");
		checkBox_11.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_11.setBackground(new Color(204, 204, 255));
		checkBox_11.setBounds(195, 76, 50, 27);
		pn_menu_3.add(checkBox_11);
		
		btn_add_9 = new JButton("+");
		btn_add_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_11.isSelected())
				{
					qty[30]++;
					small_total[30]=qty[30]*price[30];
					lb_qty[30].setText(qty[30]+"");
					lb_small_total[30].setText(small_total[30]+"");
					
					balance[14]--;balance[15]--;balance[18]--;
				}else
				{
					qty[31]++;
					small_total[31]=qty[31]*price[31];
					lb_qty[31].setText(qty[31]+"");
					lb_small_total[31].setText(small_total[31]+"");
					
					balance[14]--;balance[15]--;balance[18]--;balance[10]--;balance[11]--;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");	
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_9.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_9.setBounds(328, 68, 57, 42);
		pn_menu_3.add(btn_add_9);
		
		JLabel lb10 = new JLabel("\u4F4E\u8ABF\u4E2D\u7684\u9AD8\u8CB4");
		lb10.setToolTipText("");
		lb10.setFont(new Font("新細明體", Font.BOLD, 26));
		lb10.setBounds(14, 123, 174, 42);
		pn_menu_3.add(lb10);
		
		checkBox_12 = new JCheckBox("\u5957");
		checkBox_12.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_12.setBackground(new Color(204, 204, 255));
		checkBox_12.setBounds(195, 131, 50, 27);
		pn_menu_3.add(checkBox_12);
		
		btn_add_10 = new JButton("+");
		btn_add_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_12.isSelected())
				{
					qty[32]++;
					small_total[32]=qty[32]*price[32];
					lb_qty[32].setText(qty[32]+"");
					lb_small_total[32].setText(small_total[32]+"");
					
					balance[14]--;balance[15]--;balance[19]--;
				}else
				{
					qty[33]++;
					small_total[33]=qty[33]*price[33];
					lb_qty[33].setText(qty[33]+"");
					lb_small_total[33].setText(small_total[33]+"");
					
					balance[14]--;balance[15]--;balance[19]--;balance[10]--;balance[11]--;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_10.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_10.setBounds(328, 123, 57, 42);
		pn_menu_3.add(btn_add_10);
		
		JLabel lb11 = new JLabel("\u89AA\u5B50\u9593\u7684\u5357\u74DC");
		lb11.setToolTipText("");
		lb11.setFont(new Font("新細明體", Font.BOLD, 26));
		lb11.setBounds(14, 178, 174, 42);
		pn_menu_3.add(lb11);
		
		checkBox_13 = new JCheckBox("\u5957");
		checkBox_13.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_13.setBackground(new Color(204, 204, 255));
		checkBox_13.setBounds(195, 186, 50, 27);
		pn_menu_3.add(checkBox_13);
		
		btn_add_11 = new JButton("+");
		btn_add_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_13.isSelected())
				{
					qty[34]++;
					small_total[34]=qty[34]*price[34];
					lb_qty[34].setText(qty[34]+"");
					lb_small_total[34].setText(small_total[34]+"");
					
					balance[14]--;balance[15]--;balance[20]--;
				}else
				{
					qty[35]++;
					small_total[35]=qty[35]*price[35];
					lb_qty[35].setText(qty[35]+"");
					lb_small_total[35].setText(small_total[35]+"");
					
					balance[14]--;balance[15]--;balance[20]--;balance[10]--;balance[11]--;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_11.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_11.setBounds(328, 178, 57, 42);
		pn_menu_3.add(btn_add_11);
		
		JLabel lb12 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A");
		lb12.setToolTipText("");
		lb12.setFont(new Font("新細明體", Font.BOLD, 26));
		lb12.setBounds(14, 233, 231, 42);
		pn_menu_3.add(lb12);
		
		checkBox_14 = new JCheckBox("\u5957");
		checkBox_14.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_14.setBackground(new Color(204, 204, 255));
		checkBox_14.setBounds(248, 241, 50, 27);
		pn_menu_3.add(checkBox_14);
		
		btn_add_12 = new JButton("+");
		btn_add_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_14.isSelected())
				{
					qty[36]++;
					small_total[36]=qty[36]*price[36];
					lb_qty[36].setText(qty[36]+"");
					lb_small_total[36].setText(small_total[36]+"");
					
					balance[14]--;balance[15]--;balance[21]--;
				}else
				{
					qty[37]++;
					small_total[37]=qty[37]*price[37];
					lb_qty[37].setText(qty[37]+"");
					lb_small_total[37].setText(small_total[37]+"");
					
					balance[14]--;balance[15]--;balance[21]--;balance[10]--;balance[11]--;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_12.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_12.setBounds(328, 233, 57, 42);
		pn_menu_3.add(btn_add_12);
		
/* 第4區  */
		pn_menu_4 = new JPanel();
		pn_menu_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_4.setBackground(new Color(255, 204, 255));
		pn_menu_4.setBounds(1007, 295, 307, 293);
		pn_order.add(pn_menu_4);
		pn_menu_4.setLayout(null);
		
		JLabel lb13 = new JLabel("\u6182\u6101\u7684\u85E5\u6C34");
		lb13.setToolTipText("");
		lb13.setFont(new Font("新細明體", Font.BOLD, 26));
		lb13.setBounds(14, 13, 147, 42);
		pn_menu_4.add(lb13);
		
		checkBox_15 = new JCheckBox("\u8D08");
		checkBox_15.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_15.setBackground(new Color(255, 204, 255));
		checkBox_15.setBounds(168, 21, 50, 27);
		pn_menu_4.add(checkBox_15);
		
		btn_add_13 = new JButton("+");
		btn_add_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_15.isSelected())
				{
					qty[38]++;
					small_total[38]=qty[38]*price[38];
					lb_qty[38].setText(qty[38]+"");
					lb_small_total[38].setText(small_total[38]+"");
					
					balance[22]--;
				}else
				{
					qty[43]++;
					small_total[43]=qty[43]*price[43];
					lb_qty[43].setText(qty[43]+"");
					lb_small_total[43].setText(small_total[43]+"");
					
					balance[22]--;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");	
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_13.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_13.setBounds(235, 13, 57, 42);
		pn_menu_4.add(btn_add_13);
		
		JLabel lb14 = new JLabel("\u7099\u70C8\u7684\u85E5\u6C34");
		lb14.setToolTipText("");
		lb14.setFont(new Font("新細明體", Font.BOLD, 26));
		lb14.setBounds(14, 68, 147, 42);
		pn_menu_4.add(lb14);
		
		checkBox_16 = new JCheckBox("\u8D08");
		checkBox_16.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_16.setBackground(new Color(255, 204, 255));
		checkBox_16.setBounds(168, 76, 50, 27);
		pn_menu_4.add(checkBox_16);
		
		btn_add_14 = new JButton("+");
		btn_add_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_16.isSelected())
				{
					qty[39]++;
					small_total[39]=qty[39]*price[39];
					lb_qty[39].setText(qty[39]+"");
					lb_small_total[39].setText(small_total[39]+"");
					
					balance[23]-=50;balance[26]-=450;
				}else
				{
					qty[44]++;
					small_total[44]=qty[44]*price[44];
					lb_qty[44].setText(qty[44]+"");
					lb_small_total[44].setText(small_total[44]+"");
					
					balance[23]-=50;balance[26]-=450;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_14.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_14.setBounds(235, 68, 57, 42);
		pn_menu_4.add(btn_add_14);
		
		JLabel lb15 = new JLabel("\u9AD8\u8CB4\u7684\u85E5\u6C34");
		lb15.setToolTipText("");
		lb15.setFont(new Font("新細明體", Font.BOLD, 26));
		lb15.setBounds(14, 123, 147, 42);
		pn_menu_4.add(lb15);
		
		checkBox_17 = new JCheckBox("\u8D08");
		checkBox_17.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_17.setBackground(new Color(255, 204, 255));
		checkBox_17.setBounds(168, 131, 50, 27);
		pn_menu_4.add(checkBox_17);
		
		btn_add_15 = new JButton("+");
		btn_add_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_17.isSelected())
				{
					qty[40]++;
					small_total[40]=qty[40]*price[40];
					lb_qty[40].setText(qty[40]+"");
					lb_small_total[40].setText(small_total[40]+"");
					
					balance[24]-=50;balance[26]-=450;
				}else
				{
					qty[45]++;
					small_total[45]=qty[45]*price[45];
					lb_qty[45].setText(qty[45]+"");
					lb_small_total[45].setText(small_total[45]+"");
					
					balance[24]-=50;balance[26]-=450;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_15.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_15.setBounds(235, 123, 57, 42);
		pn_menu_4.add(btn_add_15);
		
		JLabel lb16 = new JLabel("\u5178\u96C5\u7684\u85E5\u6C34");
		lb16.setToolTipText("");
		lb16.setFont(new Font("新細明體", Font.BOLD, 26));
		lb16.setBounds(14, 178, 147, 42);
		pn_menu_4.add(lb16);
		
		checkBox_18 = new JCheckBox("\u8D08");
		checkBox_18.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_18.setBackground(new Color(255, 204, 255));
		checkBox_18.setBounds(168, 186, 50, 27);
		pn_menu_4.add(checkBox_18);
		
		btn_add_16 = new JButton("+");
		btn_add_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_18.isSelected())
				{
					qty[41]++;
					small_total[41]=qty[41]*price[41];
					lb_qty[41].setText(qty[41]+"");
					lb_small_total[41].setText(small_total[41]+"");
					
					balance[23]-=20;balance[24]-=20;balance[25]-=10;balance[26]-=450;
				}else
				{
					qty[46]++;
					small_total[46]=qty[46]*price[46];
					lb_qty[46].setText(qty[46]+"");
					lb_small_total[46].setText(small_total[46]+"");
					
					balance[23]-=20;balance[24]-=20;balance[25]-=10;balance[26]-=450;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_16.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_16.setBounds(235, 178, 57, 42);
		pn_menu_4.add(btn_add_16);
		
		JLabel lb17 = new JLabel("\u9B54\u6027\u7684\u85E5\u6C34");
		lb17.setToolTipText("");
		lb17.setFont(new Font("新細明體", Font.BOLD, 26));
		lb17.setBounds(14, 233, 147, 42);
		pn_menu_4.add(lb17);
		
		checkBox_19 = new JCheckBox("\u8D08");
		checkBox_19.setFont(new Font("新細明體", Font.BOLD, 18));
		checkBox_19.setBackground(new Color(255, 204, 255));
		checkBox_19.setBounds(168, 241, 50, 27);
		pn_menu_4.add(checkBox_19);
		
		btn_add_17 = new JButton("+");
		btn_add_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox_19.isSelected())
				{
					qty[42]++;
					small_total[42]=qty[42]*price[42];
					lb_qty[42].setText(qty[42]+"");
					lb_small_total[42].setText(small_total[42]+"");
					
					balance[27]-=500;
				}else
				{
					qty[47]++;
					small_total[47]=qty[47]*price[47];
					lb_qty[47].setText(qty[47]+"");
					lb_small_total[47].setText(small_total[47]+"");
					
					balance[27]-=500;
				}
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
				
				updateBalanceLabel();
				
				checkBalance();
			}
		});
		btn_add_17.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_17.setBounds(235, 233, 57, 42);
		pn_menu_4.add(btn_add_17);
		
		

/* 第5區  */
		pn_menu_5 = new JPanel();
		pn_menu_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_menu_5.setBackground(new Color(224, 255, 255));
		pn_menu_5.setBounds(594, 596, 720, 79);
		pn_order.add(pn_menu_5);
		pn_menu_5.setLayout(null);
		
		JLabel lb18 = new JLabel("\u7576\u65E5\u7279\u9910");
		lb18.setFont(new Font("新細明體", Font.BOLD, 26));
		lb18.setBounds(14, 14, 120, 50);
		pn_menu_5.add(lb18);
		
		btn_add_18 = new JButton("+");
		btn_add_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				qty[48]++;
				small_total[48]=qty[48]*price[48];
				lb_qty[48].setText(qty[48]+"");
				lb_small_total[48].setText(small_total[48]+"");
			
				total=0;
				for(int i=0; i<qty.length; i++)
					total+=small_total[i];
				tf_total.setText(total+"");
				
				locate();
			}
		});
		btn_add_18.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_18.setBounds(145, 18, 57, 42);
		pn_menu_5.add(btn_add_18);
		
		JLabel lb19 = new JLabel("\u5176\u4ED6");
		lb19.setFont(new Font("新細明體", Font.BOLD, 26));
		lb19.setBounds(251, 14, 57, 50);
		pn_menu_5.add(lb19);
		
		btn_add_19 = new JButton("+");
		btn_add_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					if(tf_other_name.getText().equals(""))
					    lb_item[49].setText("其它");
					else
					    lb_item[49].setText(tf_other_name.getText());
					price[49]=Integer.parseInt(tf_other_price.getText());
					
					qty[49]++;
					small_total[49]=qty[49]*price[49];
					lb_qty[49].setText(qty[49]+"");
					lb_small_total[49].setText(small_total[49]+"");
				
					total=0;
					for(int i=0; i<qty.length; i++)
						total+=small_total[i];
					tf_total.setText(total+"");
					
					locate();
					
				}catch(Exception ex){}
				
			}
		});
		btn_add_19.setFont(new Font("新細明體", Font.BOLD, 20));
		btn_add_19.setBounds(649, 18, 57, 42);
		pn_menu_5.add(btn_add_19);
		
		tf_other_name = new JTextField();
		tf_other_name.setFont(new Font("新細明體", Font.BOLD, 24));
		tf_other_name.setColumns(10);
		tf_other_name.setBounds(322, 18, 236, 42);
		pn_menu_5.add(tf_other_name);
		
		tf_other_price = new JTextField();
		tf_other_price.setFont(new Font("新細明體", Font.BOLD, 24));
		tf_other_price.setColumns(10);
		tf_other_price.setBounds(566, 18, 64, 42);
		pn_menu_5.add(tf_other_price);
				
/* 單號外帶內用 */		

		lb_current_num = new JLabel();
		
		if(current_num<10)
		    lb_current_num.setText("單號：00"+current_num);
		else if(current_num<100)
			lb_current_num.setText("單號：0"+current_num);
		else
			lb_current_num.setText("單號："+current_num);
		
		lb_current_num.setFont(new Font("新細明體", Font.PLAIN, 22));
		lb_current_num.setBounds(45, 11, 108, 30);
		pn_order.add(lb_current_num);
		
		rb1 = new JRadioButton("\u5916\u5E36");
		rb1.setFont(new Font("新細明體", Font.PLAIN, 22));
		rb1.setBounds(594, 11, 80, 30);
		rb1.addActionListener(this);
		pn_order.add(rb1);
		
		rb2 = new JRadioButton("\u5167\u7528");
		rb2.setFont(new Font("新細明體", Font.PLAIN, 22));
		rb2.setBounds(690, 11, 80, 30);
		rb2.addActionListener(this);
		rb2.setSelected(true);
		pn_order.add(rb2);
		
		bg1=new ButtonGroup();
		bg1.add(rb1);
		bg1.add(rb2);
		
		String[] table_num = {"桌號","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};		
		comboBox = new JComboBox<Object>(table_num);
		comboBox.setMaximumRowCount(17);
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("新細明體", Font.PLAIN, 22));
		comboBox.setBounds(785, 11, 80, 30);	
		pn_order.add(comboBox);
		
		JLabel lb_total = new JLabel("\u7E3D\u5171");
		lb_total.setFont(new Font("新細明體", Font.PLAIN, 24));
		lb_total.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_total.setBounds(14, 548, 57, 24);
		pn_order.add(lb_total);
		
		JLabel lb_pay = new JLabel("\u6536");
		lb_pay.setFont(new Font("新細明體", Font.PLAIN, 24));
		lb_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_pay.setBounds(14, 596, 57, 24);
		pn_order.add(lb_pay);
		
		JLabel lb_change = new JLabel("\u627E");
		lb_change.setFont(new Font("新細明體", Font.PLAIN, 24));
		lb_change.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_change.setBounds(14, 643, 57, 24);
		pn_order.add(lb_change);
		
		tf_total = new JTextField();
		tf_total.setText("0");
		tf_total.setEditable(false);
		tf_total.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_total.setFont(new Font("新細明體", Font.BOLD, 26));
		tf_total.setBounds(86, 540, 89, 40);
		pn_order.add(tf_total);
		tf_total.setColumns(10);
		
		tf_pay = new JTextField();
		tf_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_pay.setFont(new Font("新細明體", Font.BOLD, 26));
		tf_pay.setBounds(85, 588, 89, 40);
		pn_order.add(tf_pay);
		tf_pay.setColumns(10);
		
		tf_change = new JTextField();
		tf_change.setText("0");
		tf_change.setEditable(false);
		tf_change.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_change.setFont(new Font("新細明體", Font.BOLD, 26));
		tf_change.setBounds(85, 635, 89, 40);
		pn_order.add(tf_change);
		tf_change.setColumns(10);
		
		btn_checkout = new JButton("");
		btn_checkout.addActionListener(this);
		btn_checkout.setToolTipText("\u7D50\u5E33");
		btn_checkout.setIcon(new ImageIcon(POS.class.getResource("/pic/checkout.png")));
		btn_checkout.setBounds(290, 580, 95, 95);
		pn_order.add(btn_checkout);
		
		btn_next = new JButton("");
		btn_next.addActionListener(this);
		btn_next.setToolTipText("\u4E0B\u4E00\u7B46");
		btn_next.setIcon(new ImageIcon(POS.class.getResource("/pic/clear.png")));
		btn_next.setBounds(401, 580, 95, 95);
		pn_order.add(btn_next);
		
		JLabel lb_comment = new JLabel("\u5099\u8A3B");
		lb_comment.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_comment.setFont(new Font("新細明體", Font.PLAIN, 24));
		lb_comment.setBounds(219, 542, 57, 24);
		pn_order.add(lb_comment);
		
		tf_comment = new JTextField();
		tf_comment.setFont(new Font("新細明體", Font.BOLD, 24));
		tf_comment.setBounds(290, 539, 290, 30);
		pn_order.add(tf_comment);
		tf_comment.setColumns(10);
		
		
/* 所有餐點項目 */		
		
		for(int i=0; i<50; i++)
		{
			pn_item[i]=new JPanel();
			pn_item[i].setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			if(i<24)
			    pn_item[i].setBackground(new Color(255, 255, 204));
			else if(i<28)
				pn_item[i].setBackground(new Color(204, 255, 204));
			else if(i<38)
				pn_item[i].setBackground(new Color(204, 204, 255));
			else if(i<48)
				pn_item[i].setBackground(new Color(255, 204, 255));
			else
				pn_item[i].setBackground(new Color(224, 255, 255));
			
			pn_item[i].setBounds(1350, i*60, 547, 68);
			pn_order.add(pn_item[i]);
			pn_item[i].setLayout(null);
			
			lb_item[i]= new JLabel(item_name[i]);
			lb_item[i].setFont(new Font("新細明體", Font.BOLD, 26));
			lb_item[i].setBounds(10, 13, 263, 42);
			pn_item[i].add(lb_item[i]);
			
			lbx[i] = new JLabel("x");
			lbx[i].setBounds(293, 25, 14, 19);
			pn_item[i].add(lbx[i]);
			
			lbe[i] = new JLabel("=");
			lbe[i].setBounds(361, 25, 14, 19);
			pn_item[i].add(lbe[i]);
			
			lb_qty[i]= new JLabel("0");
			lb_qty[i].setFont(new Font("新細明體", Font.BOLD, 26));
			lb_qty[i].setBounds(318, 13, 36, 42);
			pn_item[i].add(lb_qty[i]);
			
			lb_small_total[i]= new JLabel("0");
			lb_small_total[i].setFont(new Font("新細明體", Font.BOLD, 26));
			lb_small_total[i].setBounds(389, 13, 57, 42);
			pn_item[i].add(lb_small_total[i]);
			
			btn_del[i]= new JButton("-");
			
			btn_del[i].addActionListener(this);
			
			btn_del[i].setFont(new Font("新細明體", Font.BOLD, 26));
			btn_del[i].setBounds(476, 13, 57, 42);
			pn_item[i].add(btn_del[i]);			
		}
		
		tabbedPane_list = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_list.setBounds(5, 49, 575, 481);
		tabbedPane_list.add("1",pn_list_1);
		pn_list_1.setLayout(null);	
		tabbedPane_list.add("2",pn_list_2);
		pn_list_2.setLayout(null);
		tabbedPane_list.add("3",pn_list_3);
		pn_list_3.setLayout(null);
		pn_order.add(tabbedPane_list);

		tabbedPane.addTab("庫存管理", pn_manage);
		pn_manage.setLayout(null);
		
		pn_balance_1 = new JPanel();
		pn_balance_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_balance_1.setBackground(new Color(255, 255, 255));
		pn_balance_1.setBounds(26, 37, 538, 642);
		pn_manage.add(pn_balance_1);
		pn_balance_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u6F22\u5821\u9EB5\u5305");
		label_1.setFont(new Font("新細明體", Font.BOLD, 20));
		label_1.setBounds(14, 13, 150, 25);
		pn_balance_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u725B\u6F22\u5821\u8089");
		label_2.setFont(new Font("新細明體", Font.BOLD, 20));
		label_2.setBounds(14, 55, 150, 25);
		pn_balance_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u8C6C\u6F22\u5821\u8089");
		label_3.setFont(new Font("新細明體", Font.BOLD, 20));
		label_3.setBounds(14, 97, 150, 25);
		pn_balance_1.add(label_3);
		
		JLabel label_4 = new JLabel("\u96DE\u6F22\u5821\u8089");
		label_4.setFont(new Font("新細明體", Font.BOLD, 20));
		label_4.setBounds(14, 139, 150, 25);
		pn_balance_1.add(label_4);
		
		JLabel label_5 = new JLabel("\u751F\u83DC");
		label_5.setFont(new Font("新細明體", Font.BOLD, 20));
		label_5.setBounds(14, 181, 150, 25);
		pn_balance_1.add(label_5);
		
		JLabel label_6 = new JLabel("\u8543\u8304");
		label_6.setFont(new Font("新細明體", Font.BOLD, 20));
		label_6.setBounds(14, 223, 150, 25);
		pn_balance_1.add(label_6);
		
		JLabel label_7 = new JLabel("\u6D0B\u8525");
		label_7.setFont(new Font("新細明體", Font.BOLD, 20));
		label_7.setBounds(14, 265, 150, 25);
		pn_balance_1.add(label_7);
		
		JLabel label_8 = new JLabel("\u725B\u91AC\u6599");
		label_8.setFont(new Font("新細明體", Font.BOLD, 20));
		label_8.setBounds(14, 307, 150, 25);
		pn_balance_1.add(label_8);
		
		JLabel label_9 = new JLabel("\u8C6C\u91AC\u6599");
		label_9.setFont(new Font("新細明體", Font.BOLD, 20));
		label_9.setBounds(14, 349, 150, 25);
		pn_balance_1.add(label_9);
		
		JLabel label_10 = new JLabel("\u96DE\u91AC\u6599");
		label_10.setFont(new Font("新細明體", Font.BOLD, 20));
		label_10.setBounds(14, 391, 150, 25);
		pn_balance_1.add(label_10);
		
		JLabel label_11 = new JLabel("\u70E4\u6642\u852C");
		label_11.setFont(new Font("新細明體", Font.BOLD, 20));
		label_11.setBounds(14, 433, 150, 25);
		pn_balance_1.add(label_11);
		
		JLabel label_12 = new JLabel("\u6C99\u62C9");
		label_12.setFont(new Font("新細明體", Font.BOLD, 20));
		label_12.setBounds(14, 475, 150, 25);
		pn_balance_1.add(label_12);
		
		JLabel label_13 = new JLabel("\u5496\u54E9");
		label_13.setFont(new Font("新細明體", Font.BOLD, 20));
		label_13.setBounds(14, 517, 150, 25);
		pn_balance_1.add(label_13);
		
		JLabel label_14 = new JLabel("\u98EF");
		label_14.setFont(new Font("新細明體", Font.BOLD, 20));
		label_14.setBounds(14, 559, 150, 25);
		pn_balance_1.add(label_14);
		
		JLabel label_15 = new JLabel("\u5410\u53F8");
		label_15.setFont(new Font("新細明體", Font.BOLD, 20));
		label_15.setBounds(14, 601, 150, 25);
		pn_balance_1.add(label_15);
		
		JLabel label_16 = new JLabel("\u7247");
		label_16.setFont(new Font("新細明體", Font.BOLD, 20));
		label_16.setBounds(178, 13, 58, 25);
		pn_balance_1.add(label_16);
		
		JLabel label_17 = new JLabel("\u7247");
		label_17.setFont(new Font("新細明體", Font.BOLD, 20));
		label_17.setBounds(178, 55, 58, 25);
		pn_balance_1.add(label_17);
		
		JLabel label_18 = new JLabel("\u7247");
		label_18.setFont(new Font("新細明體", Font.BOLD, 20));
		label_18.setBounds(178, 97, 58, 25);
		pn_balance_1.add(label_18);
		
		JLabel label_19 = new JLabel("\u7247");
		label_19.setFont(new Font("新細明體", Font.BOLD, 20));
		label_19.setBounds(178, 139, 58, 25);
		pn_balance_1.add(label_19);
		
		JLabel label_20 = new JLabel("\u4EFD");
		label_20.setFont(new Font("新細明體", Font.BOLD, 20));
		label_20.setBounds(178, 181, 58, 25);
		pn_balance_1.add(label_20);
		
		JLabel label_21 = new JLabel("\u4EFD");
		label_21.setFont(new Font("新細明體", Font.BOLD, 20));
		label_21.setBounds(178, 223, 58, 25);
		pn_balance_1.add(label_21);
		
		JLabel label_22 = new JLabel("\u4EFD");
		label_22.setFont(new Font("新細明體", Font.BOLD, 20));
		label_22.setBounds(178, 265, 58, 25);
		pn_balance_1.add(label_22);
		
		JLabel label_23 = new JLabel("\u5319");
		label_23.setFont(new Font("新細明體", Font.BOLD, 20));
		label_23.setBounds(178, 307, 58, 25);
		pn_balance_1.add(label_23);
		
		JLabel label_24 = new JLabel("\u5319");
		label_24.setFont(new Font("新細明體", Font.BOLD, 20));
		label_24.setBounds(178, 349, 58, 25);
		pn_balance_1.add(label_24);
		
		JLabel label_25 = new JLabel("\u5319");
		label_25.setFont(new Font("新細明體", Font.BOLD, 20));
		label_25.setBounds(178, 391, 58, 25);
		pn_balance_1.add(label_25);
		
		JLabel label_26 = new JLabel("\u4EFD");
		label_26.setFont(new Font("新細明體", Font.BOLD, 20));
		label_26.setBounds(178, 433, 58, 25);
		pn_balance_1.add(label_26);
		
		JLabel label_27 = new JLabel("\u4EFD");
		label_27.setFont(new Font("新細明體", Font.BOLD, 20));
		label_27.setBounds(178, 475, 58, 25);
		pn_balance_1.add(label_27);
		
		JLabel label_28 = new JLabel("\u4EFD");
		label_28.setFont(new Font("新細明體", Font.BOLD, 20));
		label_28.setBounds(178, 517, 58, 25);
		pn_balance_1.add(label_28);
		
		JLabel label_29 = new JLabel("\u7897");
		label_29.setFont(new Font("新細明體", Font.BOLD, 20));
		label_29.setBounds(178, 559, 58, 25);
		pn_balance_1.add(label_29);
		
		JLabel label_30 = new JLabel("\u7247");
		label_30.setFont(new Font("新細明體", Font.BOLD, 20));
		label_30.setBounds(178, 601, 58, 25);
		pn_balance_1.add(label_30);
		
		pn_balance_2 = new JPanel();
		pn_balance_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_balance_2.setBackground(new Color(255, 255, 255));
		pn_balance_2.setBounds(682, 37, 538, 558);
		pn_manage.add(pn_balance_2);
		pn_balance_2.setLayout(null);
		
		JLabel label_34 = new JLabel("\u5496\u5561");
		label_34.setFont(new Font("新細明體", Font.BOLD, 20));
		label_34.setBounds(14, 517, 150, 25);
		pn_balance_2.add(label_34);
		
		JLabel label_62 = new JLabel("ml");
		label_62.setFont(new Font("新細明體", Font.BOLD, 20));
		label_62.setBounds(178, 517, 58, 25);
		pn_balance_2.add(label_62);
		
		JLabel label_61 = new JLabel("ml");
		label_61.setFont(new Font("新細明體", Font.BOLD, 20));
		label_61.setBounds(178, 475, 58, 25);
		pn_balance_2.add(label_61);
		
		JLabel label_37 = new JLabel("\u70CF\u9F8D\u8336");
		label_37.setFont(new Font("新細明體", Font.BOLD, 20));
		label_37.setBounds(14, 475, 150, 25);
		pn_balance_2.add(label_37);
		
		JLabel label_38 = new JLabel("\u8513\u8D8A\u8393\u679C\u6F3F");
		label_38.setFont(new Font("新細明體", Font.BOLD, 20));
		label_38.setBounds(14, 433, 150, 25);
		pn_balance_2.add(label_38);
		
		JLabel label_60 = new JLabel("ml");
		label_60.setFont(new Font("新細明體", Font.BOLD, 20));
		label_60.setBounds(178, 433, 58, 25);
		pn_balance_2.add(label_60);
		
		JLabel label_40 = new JLabel("\u85CD\u8393\u679C\u6F3F");
		label_40.setFont(new Font("新細明體", Font.BOLD, 20));
		label_40.setBounds(14, 391, 150, 25);
		pn_balance_2.add(label_40);
		
		JLabel label_59 = new JLabel("ml");
		label_59.setFont(new Font("新細明體", Font.BOLD, 20));
		label_59.setBounds(178, 391, 58, 25);
		pn_balance_2.add(label_59);
		
		JLabel label_42 = new JLabel("\u8349\u8393\u679C\u6F3F");
		label_42.setFont(new Font("新細明體", Font.BOLD, 20));
		label_42.setBounds(14, 349, 150, 25);
		pn_balance_2.add(label_42);
		
		JLabel label_58 = new JLabel("ml");
		label_58.setFont(new Font("新細明體", Font.BOLD, 20));
		label_58.setBounds(178, 349, 58, 25);
		pn_balance_2.add(label_58);
		
		JLabel label_44 = new JLabel("\u8776\u8C46\u82B1\u8336\u5305");
		label_44.setFont(new Font("新細明體", Font.BOLD, 20));
		label_44.setBounds(14, 307, 150, 25);
		pn_balance_2.add(label_44);
		
		JLabel label_45 = new JLabel("\u5305");
		label_45.setFont(new Font("新細明體", Font.BOLD, 20));
		label_45.setBounds(178, 307, 58, 25);
		pn_balance_2.add(label_45);
		
		JLabel label_46 = new JLabel("\u725B\u5976\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_46.setFont(new Font("新細明體", Font.BOLD, 20));
		label_46.setBounds(14, 265, 150, 25);
		pn_balance_2.add(label_46);
		
		JLabel label_47 = new JLabel("\u5319");
		label_47.setFont(new Font("新細明體", Font.BOLD, 20));
		label_47.setBounds(178, 265, 58, 25);
		pn_balance_2.add(label_47);
		
		JLabel label_48 = new JLabel("\u89AA\u5B50\u5357\u74DC\u4E73\u916A\u91AC");
		label_48.setFont(new Font("新細明體", Font.BOLD, 20));
		label_48.setBounds(14, 223, 150, 25);
		pn_balance_2.add(label_48);
		
		JLabel label_49 = new JLabel("\u5319");
		label_49.setFont(new Font("新細明體", Font.BOLD, 20));
		label_49.setBounds(178, 223, 58, 25);
		pn_balance_2.add(label_49);
		
		JLabel label_50 = new JLabel("\u4F4E\u8ABF\u9AD8\u8CB4\u4E73\u916A\u91AC");
		label_50.setFont(new Font("新細明體", Font.BOLD, 20));
		label_50.setBounds(14, 181, 150, 25);
		pn_balance_2.add(label_50);
		
		JLabel label_51 = new JLabel("\u5319");
		label_51.setFont(new Font("新細明體", Font.BOLD, 20));
		label_51.setBounds(178, 181, 58, 25);
		pn_balance_2.add(label_51);
		
		JLabel label_52 = new JLabel("\u8349\u539F\u9752\u96DE\u4E73\u916A\u91AC");
		label_52.setFont(new Font("新細明體", Font.BOLD, 20));
		label_52.setBounds(14, 139, 150, 25);
		pn_balance_2.add(label_52);
		
		JLabel label_53 = new JLabel("\u5319");
		label_53.setFont(new Font("新細明體", Font.BOLD, 20));
		label_53.setBounds(178, 139, 58, 25);
		pn_balance_2.add(label_53);
		
		JLabel label_54 = new JLabel("\u6210\u9577\u56DE\u61B6\u4E73\u916A\u91AC");
		label_54.setFont(new Font("新細明體", Font.BOLD, 20));
		label_54.setBounds(14, 97, 150, 25);
		pn_balance_2.add(label_54);
		
		JLabel label_55 = new JLabel("\u5319");
		label_55.setFont(new Font("新細明體", Font.BOLD, 20));
		label_55.setBounds(178, 97, 58, 25);
		pn_balance_2.add(label_55);
		
		JLabel label_56 = new JLabel("\u8D77\u53F8");
		label_56.setFont(new Font("新細明體", Font.BOLD, 20));
		label_56.setBounds(14, 13, 150, 25);
		pn_balance_2.add(label_56);
		
		JLabel label_57 = new JLabel("\u7247");
		label_57.setFont(new Font("新細明體", Font.BOLD, 20));
		label_57.setBounds(178, 13, 58, 25);
		pn_balance_2.add(label_57);
		
		JLabel label_64 = new JLabel("\u57F9\u6839");
		label_64.setFont(new Font("新細明體", Font.BOLD, 20));
		label_64.setBounds(14, 55, 150, 25);
		pn_balance_2.add(label_64);
		
		JLabel label_63 = new JLabel("\u7247");
		label_63.setFont(new Font("新細明體", Font.BOLD, 20));
		label_63.setBounds(178, 55, 58, 25);
		pn_balance_2.add(label_63);
		
		JLabel label_36 = new JLabel("\u9805\u76EE");
		label_36.setForeground(Color.BLUE);
		label_36.setFont(new Font("新細明體", Font.BOLD, 20));
		label_36.setBounds(54, 9, 64, 25);
		pn_manage.add(label_36);
		
		JLabel label_39 = new JLabel("\u55AE\u4F4D");
		label_39.setForeground(Color.BLUE);
		label_39.setFont(new Font("新細明體", Font.BOLD, 20));
		label_39.setBounds(195, 9, 64, 25);
		pn_manage.add(label_39);
		
		JLabel label_41 = new JLabel("\u5EAB\u5B58");
		label_41.setForeground(Color.BLUE);
		label_41.setFont(new Font("新細明體", Font.BOLD, 20));
		label_41.setBounds(305, 9, 64, 25);
		pn_manage.add(label_41);
		
		JLabel label_43 = new JLabel("\u8ABF\u6574 / \u53D6\u4EE3");
		label_43.setForeground(Color.BLUE);
		label_43.setFont(new Font("新細明體", Font.BOLD, 20));
		label_43.setBounds(430, 9, 103, 25);
		pn_manage.add(label_43);
		
		JLabel label_35 = new JLabel("\u9805\u76EE");
		label_35.setForeground(Color.BLUE);
		label_35.setFont(new Font("新細明體", Font.BOLD, 20));
		label_35.setBounds(710, 9, 64, 25);
		pn_manage.add(label_35);
		
		JLabel label_31 = new JLabel("\u55AE\u4F4D");
		label_31.setForeground(Color.BLUE);
		label_31.setFont(new Font("新細明體", Font.BOLD, 20));
		label_31.setBounds(851, 9, 64, 25);
		pn_manage.add(label_31);
		
		JLabel label_32 = new JLabel("\u5EAB\u5B58");
		label_32.setForeground(Color.BLUE);
		label_32.setFont(new Font("新細明體", Font.BOLD, 20));
		label_32.setBounds(961, 9, 64, 25);
		pn_manage.add(label_32);
		
		JLabel label_33 = new JLabel("\u8ABF\u6574 / \u53D6\u4EE3");
		label_33.setForeground(Color.BLUE);
		label_33.setFont(new Font("新細明體", Font.BOLD, 20));
		label_33.setBounds(1086, 9, 103, 25);
		pn_manage.add(label_33);
		
		JButton btn_update = new JButton("\u8ABF\u6574");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int error=0;
				for(int i=0; i<28; i++)
				{
					try{
						if(balance[i]+Integer.parseInt(tf_update[i].getText())<0)
						{
							JOptionPane.showMessageDialog(frmMadhousePos, "庫存量低於零!", "操作錯誤", JOptionPane.ERROR_MESSAGE);
							error++;
							break;
						}
					}catch(Exception ex){
						if(!tf_update[i].getText().equals(""))
						{
						    JOptionPane.showMessageDialog(frmMadhousePos, "輸入需為整數!", "操作錯誤", JOptionPane.ERROR_MESSAGE);
						    error++;
						    break;
						}
					}
				}
				if(error==0)
				{
					for(int i=0; i<28; i++)
					{
						try{
							balance[i]+=Integer.parseInt(tf_update[i].getText());
							lb_balance[i].setText(balance[i]+"");
							tf_update[i].setText("");
						}catch(Exception ex){}
					}
				}
				
				keepBalanceManagement();
				
			}
		});
		btn_update.setFont(new Font("新細明體", Font.BOLD, 24));
		btn_update.setBounds(667, 619, 110, 45);
		pn_manage.add(btn_update);
		
		JButton btn_replace = new JButton("\u53D6\u4EE3");
		btn_replace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int error=0;
				for(int i=0; i<28; i++)
				{
					try{
						if(Integer.parseInt(tf_update[i].getText())<0)
						{
							JOptionPane.showMessageDialog(frmMadhousePos, "庫存量低於零!", "操作錯誤", JOptionPane.ERROR_MESSAGE);
							error++;
							break;
						}
					}catch(Exception ex){
						if(!tf_update[i].getText().equals(""))
						{
						    JOptionPane.showMessageDialog(frmMadhousePos, "輸入需為整數!", "操作錯誤", JOptionPane.ERROR_MESSAGE);
						    error++;
						    break;
						}
					}
				}
				if(error==0)
				{
					for(int i=0; i<28; i++)
					{
						try{
							balance[i]=Integer.parseInt(tf_update[i].getText());
							lb_balance[i].setText(balance[i]+"");
							tf_update[i].setText("");
						}catch(Exception ex){}
					}
				}
				
				keepBalanceManagement();
				
			}
		});
		btn_replace.setFont(new Font("新細明體", Font.BOLD, 24));
		btn_replace.setBounds(803, 619, 110, 45);
		pn_manage.add(btn_replace);
		
		JButton btn_clear = new JButton("\u6E05\u9664");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<28; i++)
				    tf_update[i].setText("");
			}
		});
		btn_clear.setFont(new Font("新細明體", Font.BOLD, 24));
		btn_clear.setBounds(940, 619, 110, 45);
		pn_manage.add(btn_clear);
		
		JButton btn_all_re = new JButton("\u5168\u90E8\u6B78\u96F6");
		btn_all_re.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<28; i++)
				{
					balance[i]=0;
				    lb_balance[i].setText(balance[i]+"");
				    tf_update[i].setText("");
				}
				
				keepBalanceManagement();
				
			}
		});
		btn_all_re.setFont(new Font("新細明體", Font.BOLD, 24));
		btn_all_re.setBounds(1075, 619, 160, 45);
		pn_manage.add(btn_all_re);

/* 庫存管理控制項 */
		for(int i=0; i<15; i++)
		{
			lb_balance[i]=new JLabel(balance[i]+"");
			lb_balance[i].setBounds(270, 42*i+14, 56, 25);
			pn_balance_1.add(lb_balance[i]);
			lb_balance[i].setHorizontalAlignment(SwingConstants.CENTER);
			lb_balance[i].setFont(new Font("新細明體", Font.BOLD, 20));
		}
		
		for(int i=15; i<28; i++)
		{
			lb_balance[i]=new JLabel(balance[i]+"");
			lb_balance[i].setBounds(270, 42*(i-15)+14, 56, 25);
			pn_balance_2.add(lb_balance[i]);
			lb_balance[i].setHorizontalAlignment(SwingConstants.CENTER);
			lb_balance[i].setFont(new Font("新細明體", Font.BOLD, 20));
		}
		
		for(int i=0; i<15; i++)
		{
			tf_update[i]=new JTextField();
			tf_update[i].setBounds(405, 42*i+11, 100, 30);
			pn_balance_1.add(tf_update[i]);
			tf_update[i].setFont(new Font("新細明體", Font.BOLD, 20));
			tf_update[i].setColumns(10);	
		}
		
		for(int i=15; i<28; i++)
		{
			tf_update[i]=new JTextField();
			tf_update[i].setBounds(405, 42*(i-15)+11, 100, 30);
			pn_balance_2.add(tf_update[i]);
			tf_update[i].setFont(new Font("新細明體", Font.BOLD, 20));
			tf_update[i].setColumns(10);
		}
		
		tabbedPane.setSelectedIndex(0);
		frmMadhousePos.getContentPane().add(tabbedPane);
	}
	
	void locate()
	{	
		btn_add_1.setEnabled(true);btn_add_2.setEnabled(true);btn_add_3.setEnabled(true);btn_add_4.setEnabled(true);btn_add_5.setEnabled(true);
		btn_add_6.setEnabled(true);btn_add_7.setEnabled(true);btn_add_8.setEnabled(true);btn_add_9.setEnabled(true);btn_add_10.setEnabled(true);
		btn_add_11.setEnabled(true);btn_add_12.setEnabled(true);btn_add_13.setEnabled(true);btn_add_14.setEnabled(true);btn_add_15.setEnabled(true);
		btn_add_16.setEnabled(true);btn_add_17.setEnabled(true);btn_add_18.setEnabled(true);btn_add_19.setEnabled(true);
		
		pn_list_1.removeAll();
		pn_list_2.removeAll();
		pn_list_3.removeAll();
		pn_order.updateUI();
		
		y=-1;
		
		for(int i=0; i<qty.length; i++)
		{
			if(qty[i]>0)
			{
				y++;
				if(y<7)
				{
					pn_item[i].setLocation(0, y*68);
					pn_list_1.add(pn_item[i]);
					tabbedPane_list.setSelectedIndex(0);
				}else if(y<14)
				{
					pn_item[i].setLocation(0, (y-7)*68);
					pn_list_2.add(pn_item[i]);
					tabbedPane_list.setSelectedIndex(1);
				}else if(y<20)
				{
					pn_item[i].setLocation(0, (y-14)*68);
					pn_list_3.add(pn_item[i]);
					tabbedPane_list.setSelectedIndex(2);
				}else
				{
					pn_item[i].setLocation(0, (y-14)*68);
					pn_list_3.add(pn_item[i]);
					tabbedPane_list.setSelectedIndex(2);
					
					btn_add_1.setEnabled(false);btn_add_2.setEnabled(false);btn_add_3.setEnabled(false);btn_add_4.setEnabled(false);btn_add_5.setEnabled(false);
					btn_add_6.setEnabled(false);btn_add_7.setEnabled(false);btn_add_8.setEnabled(false);btn_add_9.setEnabled(false);btn_add_10.setEnabled(false);
					btn_add_11.setEnabled(false);btn_add_12.setEnabled(false);btn_add_13.setEnabled(false);btn_add_14.setEnabled(false);btn_add_15.setEnabled(false);
					btn_add_16.setEnabled(false);btn_add_17.setEnabled(false);btn_add_18.setEnabled(false);btn_add_19.setEnabled(false);
				}
			}
		}
		
		if(qty[49]!=0)
		{
			tf_other_name.setEditable(false);
			tf_other_price.setEditable(false);
		}else
		{
			tf_other_name.setEditable(true);
			tf_other_price.setEditable(true);
		}
	}

/* 日記錄  */	
	
	void startRecord()
	{
		Date d=new Date();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMM"), sdf2=new SimpleDateFormat("yyyyMMdd");
		
		String r_time1=sdf1.format(d), r_time2=sdf2.format(d);
		f=new File("C:/Madhouse/"+r_time1+"/"+r_time2+"交易紀錄.csv");
		if(!f.exists())
		{
			try{
				f.getParentFile().mkdirs();
				bw=new BufferedWriter(new FileWriter(f.getAbsolutePath()));
				bw.write("單號,桌號,交易日期,交易時間,");
				for(int i=0; i<item_name.length; i++)
					bw.write(item_name[i]+",");
				bw.write("事由,小計,收,找,備註");
				bw.newLine();
				bw.flush();
			}catch(Exception e){}
		}else
		{
			try{
				br=new BufferedReader(new FileReader("C:/Madhouse/"+r_time1+"/"+r_time2+"交易紀錄.csv"));
				oldRecord+=br.readLine()+"\r\n";
				do{
                    String str=br.readLine();
                    if(str==null)
                        break;
                    oldRecord+=str+"\r\n";
	            }while(true);
	            br.close();
				bw=new BufferedWriter(new FileWriter(f.getAbsolutePath()));
				bw.write(oldRecord);
				bw.flush();
			}catch(Exception e){}	
		}
	}
	
	void keepRecord()
	{
		String table_num="";
		if(rb1.isSelected())
			table_num="外帶";
		else
		{
			if(comboBox.getSelectedIndex()==0)
				table_num="未設定";
			else
			    table_num=comboBox.getSelectedItem().toString();
		}	
		try{
			Date d=new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd"),sdf2=new SimpleDateFormat("HH:mm:ss");
			String r_time1=sdf1.format(d),r_time2=sdf2.format(d);
			bw.append(current_num+","+table_num+","+r_time1+","+r_time2+",");
			for(int i=0; i<qty.length; i++)
			    bw.append(qty[i]+",");
			bw.append(tf_other_name.getText()+","+total+","+pay+","+change+","+tf_comment.getText());
			bw.newLine();
			bw.flush();
		}catch(Exception e){}	
	}

/* 月記錄  */	

	void startRecordMonthly()
	{
		String oldRecord_tmp="";
		Date d=new Date();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMM");
		
		String r_time1=sdf1.format(d);
		f_monthly=new File("C:/Madhouse/"+r_time1+"/"+r_time1+"交易紀錄.csv");
		if(!f_monthly.exists())
		{
			try{
				f_monthly.getParentFile().mkdirs();
				bw_monthly=new BufferedWriter(new FileWriter(f_monthly.getAbsolutePath()));
				bw_monthly.write("單號,桌號,交易日期,交易時間,");
				for(int i=0; i<item_name.length; i++)
					bw_monthly.write(item_name[i]+",");
				bw_monthly.write("事由,小計,收,找,備註");
				bw_monthly.newLine();
				bw_monthly.flush();
			}catch(Exception e){}
		}else
		{
			try{
				BufferedReader br_tmp=new BufferedReader(new FileReader("C:/Madhouse/"+r_time1+"/"+r_time1+"交易紀錄.csv"));
				oldRecord_tmp+=br_tmp.readLine()+"\r\n";
				do{
                    String str=br_tmp.readLine();
                    if(str==null)
                        break;
                    oldRecord_tmp+=str+"\r\n";
	            }while(true);
				br_tmp.close();
				bw_monthly=new BufferedWriter(new FileWriter(f_monthly.getAbsolutePath()));
	            bw_monthly.write(oldRecord_tmp);
	            bw_monthly.flush();
			}catch(Exception e){}	
		}
	}
	
	void keepRecordMonthly()
	{
		String table_num="";
		if(rb1.isSelected())
			table_num="外帶";
		else
		{
			if(comboBox.getSelectedIndex()==0)
				table_num="未設定";
			else
			    table_num=comboBox.getSelectedItem().toString();
		}	
		try{
			Date d=new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd"),sdf2=new SimpleDateFormat("HH:mm:ss");
			String r_time1=sdf1.format(d),r_time2=sdf2.format(d);
			
			bw_monthly.append(current_num+","+table_num+","+r_time1+","+r_time2+",");
			for(int i=0; i<qty.length; i++)
				bw_monthly.append(qty[i]+",");
			bw_monthly.append(tf_other_name.getText()+","+total+","+pay+","+change+","+tf_comment.getText());
			bw_monthly.newLine();
			bw_monthly.flush();
		}catch(Exception e){}	
	}
	
	void checkCurrentNumber()
	{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		
		num_time=sdf.format(d);
		f_num=new File("C:/Madhouse/_system/current_number.csv");
		if(!f_num.exists())
		{
			try{
				f_num.getParentFile().mkdirs();
				BufferedWriter bw_tmp=new BufferedWriter(new FileWriter(f_num.getAbsolutePath()));
				bw_tmp.write(num_time+",0");
				bw_tmp.flush();
				bw_tmp.close();
			}catch(Exception e){}
		}else
		{
			try{
				BufferedReader br_tmp=new BufferedReader(new FileReader("C:/Madhouse/_system/current_number.csv"));
	            String str[]=br_tmp.readLine().split(",");
	            br_tmp.close();
				if(str[0].equals(num_time))
				{
					current_num=Integer.parseInt(str[1])+1;
				}else
				{
					BufferedWriter bw_tmp=new BufferedWriter(new FileWriter(f_num.getAbsolutePath()));
					bw_tmp.write(num_time+",0");
					bw_tmp.flush();
					bw_tmp.close();
				}
			}catch(Exception e){}	
		}
		
	}
	
	void makeReceipt()
	{
		String num="";
		
		if(current_num<10)
			num="00"+current_num;
		else if(current_num<100)
			num="0"+current_num;
		else
			num=""+current_num;
		
		String table_num="";
		if(rb1.isSelected())
			table_num="外帶";
		else
		{
			if(comboBox.getSelectedIndex()==0)
				table_num="未設定";
			else
			    table_num=comboBox.getSelectedItem().toString()+" 桌";
		}
		
		try{
			Date d=new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd"),sdf2=new SimpleDateFormat("HH:mm:ss"),sdf3=new SimpleDateFormat("yyyyMM"),sdf4=new SimpleDateFormat("yyyy/MM/dd");
			String r_time1=sdf1.format(d),r_time2=sdf2.format(d),r_time3=sdf3.format(d),r_time4=sdf4.format(d);	
			f_receipt=new File("C:/Madhouse/"+r_time3+"/receipt/"+r_time1+num+".txt");
			f_receipt.getParentFile().mkdirs();
			BufferedWriter bw_tmp=new BufferedWriter(new FileWriter(f_receipt.getAbsolutePath()));
			bw_tmp.append("  【Madhouse 異想料理實驗室 】\r\n\r\n");
			bw_tmp.append("             "+table_num+"\r\n\r\n");	
			bw_tmp.append("單號："+num+"    "+r_time4+" "+r_time2+"\r\n");
			bw_tmp.append("--------------------------------\r\n");
			for(int i=0; i<qty.length; i++)
			{
				if(qty[i]!=0)
				{
					String tmp=String.format("%2d",qty[i]);  
					bw_tmp.append(item_name[i]+" x "+tmp+" = "+small_total[i]+"\r\n");
				}	
			}
			if(qty[49]!=0 && !tf_other_name.getText().equals(""))
				bw_tmp.append("("+tf_other_name.getText()+")\r\n");
			bw_tmp.append("--------------------------------\r\n");
			bw_tmp.append("總共："+total+" 元\r\n");
			bw_tmp.append("支付："+pay+" 元\r\n");
			bw_tmp.append("找零："+change+" 元\r\n\r\n");
			if(!tf_comment.getText().equals(""))
				bw_tmp.append("備註："+tf_comment.getText()+"\r\n");
			bw_tmp.flush();
			bw_tmp.close();
		}catch(Exception e){}
	}
	
	void startBalanceManagement()
	{
		f_balance=new File("C:/Madhouse/_system/balance.csv");
		if(!f_balance.exists())
		{
			try{
				f_balance.getParentFile().mkdirs();
				bw_balance=new BufferedWriter(new FileWriter(f_balance.getAbsolutePath()));
				for(int i=0; i<balance.length; i++)
					bw_balance.write(balance[i]+",");
				bw_balance.flush();
			}catch(Exception e){}
		}else
		{
			try{
				BufferedReader br_tmp=new BufferedReader(new FileReader("C:/Madhouse/_system/balance.csv"));
				String tmp[]=br_tmp.readLine().split(",");
				for(int i=0; i<balance.length; i++)
					balance[i]=Integer.parseInt(tmp[i]);
				br_tmp.close();
			}catch(Exception e){}	
		}
	}
	
	void keepBalanceManagement()
	{
		f_balance=new File("C:/Madhouse/_system/balance.csv");
		try{
			bw_balance=new BufferedWriter(new FileWriter(f_balance.getAbsolutePath()));
			for(int i=0; i<balance.length; i++)
				bw_balance.write(balance[i]+",");
			bw_balance.flush();
		}catch(Exception e){}
	}
	
	void updateBalanceLabel()
	{
		for(int i=0; i<balance.length; i++)
			lb_balance[i].setText(balance[i]+"");
	}
	
	void checkBalance()
	{
		btn_add_1.setEnabled(true);btn_add_2.setEnabled(true);btn_add_3.setEnabled(true);btn_add_4.setEnabled(true);btn_add_5.setEnabled(true);
		btn_add_6.setEnabled(true);btn_add_7.setEnabled(true);btn_add_8.setEnabled(true);btn_add_9.setEnabled(true);btn_add_10.setEnabled(true);
		btn_add_11.setEnabled(true);btn_add_12.setEnabled(true);btn_add_13.setEnabled(true);btn_add_14.setEnabled(true);btn_add_15.setEnabled(true);
		btn_add_16.setEnabled(true);btn_add_17.setEnabled(true);btn_add_18.setEnabled(true);btn_add_19.setEnabled(true);

		checkBox_1.setEnabled(true);checkBox_2.setEnabled(true);checkBox_3.setEnabled(true);checkBox_4.setEnabled(true);checkBox_5.setEnabled(true);
		checkBox_6.setEnabled(true);checkBox_7.setEnabled(true);checkBox_8.setEnabled(true);checkBox_9.setEnabled(true);checkBox_10.setEnabled(true);
		checkBox_11.setEnabled(true);checkBox_12.setEnabled(true);checkBox_13.setEnabled(true);checkBox_14.setEnabled(true);checkBox_15.setEnabled(true);
		checkBox_16.setEnabled(true);checkBox_17.setEnabled(true);checkBox_18.setEnabled(true);checkBox_19.setEnabled(true);
		
		if(balance[0]<1)
		{
			btn_add_1.setEnabled(false);btn_add_2.setEnabled(false);btn_add_3.setEnabled(false);
		}
		if(balance[1]<2)
		{
			checkBox_1.setEnabled(false);checkBox_1.setSelected(false);
			if(balance[1]<1)
			{
			    btn_add_1.setEnabled(false);btn_add_5.setEnabled(false);
			}
		}
		if(balance[2]<2)
		{
			checkBox_4.setEnabled(false);checkBox_4.setSelected(false);
			if(balance[2]<1)
			{
			    btn_add_2.setEnabled(false);btn_add_6.setEnabled(false);
			}
		}
		if(balance[3]<2)
		{
			checkBox_7.setEnabled(false);checkBox_7.setSelected(false);
			if(balance[3]<1)
			{
			    btn_add_3.setEnabled(false);btn_add_7.setEnabled(false);
			}
		}
		if(balance[4]<1)
		{
			btn_add_1.setEnabled(false);btn_add_2.setEnabled(false);btn_add_3.setEnabled(false);
		}
		if(balance[5]<1)
		{
			btn_add_1.setEnabled(false);btn_add_2.setEnabled(false);btn_add_3.setEnabled(false);
		}
		if(balance[6]<1)
		{
			btn_add_1.setEnabled(false);btn_add_2.setEnabled(false);btn_add_3.setEnabled(false);
		}
		if(balance[7]<1)
		{
			btn_add_1.setEnabled(false);
		}
		if(balance[8]<1)
		{
			btn_add_2.setEnabled(false);
		}
		if(balance[9]<1)
		{
			btn_add_3.setEnabled(false);
		}
		if(balance[10]<1)
		{
			checkBox_10.setEnabled(false);checkBox_11.setEnabled(false);checkBox_12.setEnabled(false);checkBox_13.setEnabled(false);checkBox_14.setEnabled(false);
			btn_add_1.setEnabled(false);btn_add_2.setEnabled(false);btn_add_3.setEnabled(false);btn_add_4.setEnabled(false);btn_add_5.setEnabled(false);btn_add_6.setEnabled(false);btn_add_7.setEnabled(false);
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(rb1.isSelected())
		{
			comboBox.setSelectedIndex(0);
			comboBox.setEnabled(false);
		}
		if(rb2.isSelected())
		{
			comboBox.setEnabled(true);
		}
		
		for(int i=0; i<qty.length; i++)
		{
			if(e.getSource()==btn_del[i] && qty[i]>0)
			{
				qty[i]--;
				small_total[i]=qty[i]*price[i];
				lb_qty[i].setText(qty[i]+"");
				lb_small_total[i].setText(small_total[i]+"");
				
				total=0;
				for(int j=0; j<qty.length; j++)
					total+=small_total[j];
				tf_total.setText(total+"");
				
				locate();
				
				if(i==0)
				{
					balance[0]++;balance[1]++;balance[4]++;balance[5]++;balance[6]++;balance[7]++;balance[10]++;balance[11]++;
				}
				if(i==1)
				{
					balance[0]++;balance[1]++;balance[4]++;balance[5]++;balance[6]++;balance[7]++;balance[10]++;balance[11]++;balance[1]++;
				}
				if(i==2)
				{
					balance[0]++;balance[1]++;balance[4]++;balance[5]++;balance[6]++;balance[7]++;balance[10]++;balance[11]++;balance[16]++;
				}
				if(i==3)
				{
					balance[0]++;balance[1]++;balance[4]++;balance[5]++;balance[6]++;balance[7]++;balance[10]++;balance[11]++;balance[15]++;
				}
				if(i==4)
				{
					balance[0]++;balance[1]++;balance[4]++;balance[5]++;balance[6]++;balance[7]++;balance[10]++;balance[11]++;balance[1]++;balance[16]++;
				}
				if(i==5)
				{
					balance[0]++;balance[1]++;balance[4]++;balance[5]++;balance[6]++;balance[7]++;balance[10]++;balance[11]++;balance[1]++;balance[15]++;
				}
				if(i==6)
				{
					balance[0]++;balance[1]++;balance[4]++;balance[5]++;balance[6]++;balance[7]++;balance[10]++;balance[11]++;balance[15]++;balance[16]++;
				}
				if(i==7)
				{
					balance[0]++;balance[1]++;balance[4]++;balance[5]++;balance[6]++;balance[7]++;balance[10]++;balance[11]++;balance[1]++;balance[15]++;balance[16]++;
				}
				if(i==8)
				{
					balance[0]++;balance[2]++;balance[4]++;balance[5]++;balance[6]++;balance[8]++;balance[10]++;balance[11]++;
				}
				if(i==9)
				{
					balance[0]++;balance[2]++;balance[4]++;balance[5]++;balance[6]++;balance[8]++;balance[10]++;balance[11]++;balance[2]++;
				}
				if(i==10)
				{
					balance[0]++;balance[2]++;balance[4]++;balance[5]++;balance[6]++;balance[8]++;balance[10]++;balance[11]++;balance[16]++;
				}
				if(i==11)
				{
					balance[0]++;balance[2]++;balance[4]++;balance[5]++;balance[6]++;balance[8]++;balance[10]++;balance[11]++;balance[15]++;
				}
				if(i==12)
				{
					balance[0]++;balance[2]++;balance[4]++;balance[5]++;balance[6]++;balance[8]++;balance[10]++;balance[11]++;balance[2]++;balance[16]++;
				}
				if(i==13)
				{
					balance[0]++;balance[2]++;balance[4]++;balance[5]++;balance[6]++;balance[8]++;balance[10]++;balance[11]++;balance[2]++;balance[15]++;
				}
				if(i==14)
				{
					balance[0]++;balance[2]++;balance[4]++;balance[5]++;balance[6]++;balance[8]++;balance[10]++;balance[11]++;balance[15]++;balance[16]++;
				}
				if(i==15)
				{
					balance[0]++;balance[2]++;balance[4]++;balance[5]++;balance[6]++;balance[8]++;balance[10]++;balance[11]++;balance[2]++;balance[15]++;balance[16]++;
				}
				if(i==16)
				{
					balance[0]++;balance[3]++;balance[4]++;balance[5]++;balance[6]++;balance[9]++;balance[10]++;balance[11]++;
				}
				if(i==17)
				{
					balance[0]++;balance[3]++;balance[4]++;balance[5]++;balance[6]++;balance[9]++;balance[10]++;balance[11]++;balance[3]++;
				}
				if(i==18)
				{
					balance[0]++;balance[3]++;balance[4]++;balance[5]++;balance[6]++;balance[9]++;balance[10]++;balance[11]++;balance[16]++;
				}
				if(i==19)
				{
					balance[0]++;balance[3]++;balance[4]++;balance[5]++;balance[6]++;balance[9]++;balance[10]++;balance[11]++;balance[15]++;
				}
				if(i==20)
				{
					balance[0]++;balance[3]++;balance[4]++;balance[5]++;balance[6]++;balance[9]++;balance[10]++;balance[11]++;balance[3]++;balance[16]++;
				}
				if(i==21)
				{
					balance[0]++;balance[3]++;balance[4]++;balance[5]++;balance[6]++;balance[9]++;balance[10]++;balance[11]++;balance[3]++;balance[15]++;
				}
				if(i==22)
				{
					balance[0]++;balance[3]++;balance[4]++;balance[5]++;balance[6]++;balance[9]++;balance[10]++;balance[11]++;balance[15]++;balance[16]++;
				}
				if(i==23)
				{
					balance[0]++;balance[3]++;balance[4]++;balance[5]++;balance[6]++;balance[9]++;balance[10]++;balance[11]++;balance[3]++;balance[15]++;balance[16]++;
				}
				if(i==24)
				{
					balance[12]++;balance[13]++;balance[10]++;balance[11]++;
				}
				if(i==25)
				{
					balance[12]++;balance[13]++;balance[10]++;balance[11]++;balance[1]++;
				}
				if(i==26)
				{
					balance[12]++;balance[13]++;balance[10]++;balance[11]++;balance[2]++;
				}
				if(i==27)
				{
					balance[12]++;balance[13]++;balance[10]++;balance[11]++;balance[3]++;
				}
				if(i==28)
				{
					balance[14]++;balance[15]++;balance[17]++;
				}
				if(i==29)
				{
					balance[14]++;balance[15]++;balance[17]++;balance[10]++;balance[11]++;
				}
				if(i==30)
				{
					balance[14]++;balance[15]++;balance[18]++;
				}
				if(i==31)
				{
					balance[14]++;balance[15]++;balance[18]++;balance[10]++;balance[11]++;
				}
				if(i==32)
				{
					balance[14]++;balance[15]++;balance[19]++;
				}
				if(i==33)
				{
					balance[14]++;balance[15]++;balance[19]++;balance[10]++;balance[11]++;
				}
				if(i==34)
				{
					balance[14]++;balance[15]++;balance[20]++;
				}
				if(i==35)
				{
					balance[14]++;balance[15]++;balance[20]++;balance[10]++;balance[11]++;
				}
				if(i==36)
				{
					balance[14]++;balance[15]++;balance[21]++;
				}
				if(i==37)
				{
					balance[14]++;balance[15]++;balance[21]++;balance[10]++;balance[11]++;
				}
				if(i==38)
				{
					balance[22]++;
				}
				if(i==39)
				{
					balance[23]+=50;balance[26]+=450;
				}
				if(i==40)
				{
					balance[24]+=50;balance[26]+=450;
				}
				if(i==41)
				{
					balance[23]+=20;balance[24]+=20;balance[25]+=10;balance[26]+=450;
				}
				if(i==42)
				{
					balance[27]+=500;
				}
				if(i==43)
				{
					balance[22]++;
				}
				if(i==44)
				{
					balance[23]+=50;balance[26]+=450;
				}
				if(i==45)
				{
					balance[24]+=50;balance[26]+=450;
				}
				if(i==46)
				{
					balance[23]+=20;balance[24]+=20;balance[25]+=10;balance[26]+=450;
				}
				if(i==47)
				{
					balance[27]+=500;
				}
					
				updateBalanceLabel();
				
				checkBalance();
			}	
		}
		
		if(e.getSource()==btn_checkout)
		{
			
			pay=Integer.parseInt(tf_pay.getText());
			change=pay-total;
			tf_change.setText(change+"");
			if(!tf_total.getText().equals("0") && !tf_pay.getText().equals("") && change>=0 && change<1000)
			{

				isChecked=true;
				keepRecord();
				keepRecordMonthly();
				makeReceipt();
				
				try{
					BufferedWriter bw_tmp=new BufferedWriter(new FileWriter(f_num.getAbsolutePath()));
					bw_tmp.write(num_time+","+current_num);
					bw_tmp.flush();
					bw_tmp.close();
				}catch(Exception ex){}
				
			}else
			    tf_change.setForeground(Color.RED);
		}
		if(e.getSource()==btn_next)
		{
			
			if(isChecked==true)
			{
				tf_change.setForeground(Color.BLACK);
				comboBox.setSelectedIndex(0);
				isChecked=false;
				current_num++;
				for(int i=0; i<qty.length; i++)
				{
					qty[i]=0;
					small_total[i]=0;
					lb_qty[i].setText("0");
					lb_small_total[i].setText("0");
				}
				total=0;
				
				tf_comment.setText("");
				tf_total.setText("0");
				tf_pay.setText("");
				tf_change.setText("0");
				tf_other_name.setText("");
				tf_other_price.setText("");
				if(current_num<10)
				    lb_current_num.setText("單號：00"+current_num);
				else if(current_num<100)
					lb_current_num.setText("單號：0"+current_num);
				else
					lb_current_num.setText("單號："+current_num);
								
				checkBox_1.setSelected(false);checkBox_2.setSelected(false);checkBox_3.setSelected(false);checkBox_4.setSelected(false);checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);checkBox_7.setSelected(false);checkBox_8.setSelected(false);checkBox_9.setSelected(false);checkBox_10.setSelected(false);
				checkBox_11.setSelected(false);checkBox_12.setSelected(false);checkBox_13.setSelected(false);checkBox_14.setSelected(false);checkBox_15.setSelected(false);
				checkBox_16.setSelected(false);checkBox_17.setSelected(false);checkBox_18.setSelected(false);checkBox_19.setSelected(false);
				
				locate();
		
			}
			
		}
		
	}
}