package stock;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class Stock {

	private JFrame fm_stock;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock window = new Stock();
					window.fm_stock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Stock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fm_stock = new JFrame();
		fm_stock.setTitle("Madhouse POS-庫存管理");
		fm_stock.setResizable(false);
		fm_stock.setBounds(100, 100, 990, 575);
		//fm_stock.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/Madhouse.png")));
		fm_stock.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 20));
		fm_stock.getContentPane().setLayout(null);
		fm_stock.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//fm_stock.setVisible(false);
		
		JLabel lb_stock_title1 = new JLabel("\u9805\u76EE");
		lb_stock_title1.setForeground(Color.BLUE);
		lb_stock_title1.setBounds(20, 10, 45, 25);
		lb_stock_title1.setFont(new Font("新細明體", Font.PLAIN, 20));
		fm_stock.getContentPane().add(lb_stock_title1);
		
		JLabel lb_stock_title2 = new JLabel("\u55AE\u4F4D");
		lb_stock_title2.setBounds(275, 10, 45, 25);
		lb_stock_title2.setFont(new Font("新細明體", Font.PLAIN, 20));
		fm_stock.getContentPane().add(lb_stock_title2);
		lb_stock_title2.setForeground(Color.BLUE);
		
		JLabel lb_stock_title3 = new JLabel("\u5EAB\u5B58");
		lb_stock_title3.setBounds(355, 10, 45, 25);
		lb_stock_title3.setFont(new Font("新細明體", Font.PLAIN, 20));
		fm_stock.getContentPane().add(lb_stock_title3);
		lb_stock_title3.setForeground(Color.BLUE);
		
		JLabel lb_stock_title4 = new JLabel("\u8ABF\u6574");
		lb_stock_title4.setBounds(429, 10, 45, 25);
		lb_stock_title4.setFont(new Font("新細明體", Font.PLAIN, 20));
		fm_stock.getContentPane().add(lb_stock_title4);
		lb_stock_title4.setForeground(Color.BLUE);
		
		JLabel lb_stock_title5 = new JLabel("\u9805\u76EE");
		lb_stock_title5.setForeground(Color.BLUE);
		lb_stock_title5.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_stock_title5.setBounds(520, 10, 45, 25);
		fm_stock.getContentPane().add(lb_stock_title5);
		
		JLabel lb_stock_title6 = new JLabel("\u55AE\u4F4D");
		lb_stock_title6.setForeground(Color.BLUE);
		lb_stock_title6.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_stock_title6.setBounds(775, 10, 45, 25);
		fm_stock.getContentPane().add(lb_stock_title6);
		
		JLabel lb_stock_title7 = new JLabel("\u5EAB\u5B58");
		lb_stock_title7.setForeground(Color.BLUE);
		lb_stock_title7.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_stock_title7.setBounds(855, 10, 45, 25);
		fm_stock.getContentPane().add(lb_stock_title7);
		
		JLabel lb_stock_title8 = new JLabel("\u8ABF\u6574");
		lb_stock_title8.setForeground(Color.BLUE);
		lb_stock_title8.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_stock_title8.setBounds(929, 10, 45, 25);
		fm_stock.getContentPane().add(lb_stock_title8);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 45, 230, 25);
		fm_stock.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(275, 45, 50, 25);
		fm_stock.getContentPane().add(lblNewLabel_2);
		
		JLabel label_7 = new JLabel("");
		label_7.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_7.setBounds(355, 45, 50, 25);
		fm_stock.getContentPane().add(label_7);
		
		textField = new JTextField();
		textField.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField.setBounds(430, 44, 50, 25);
		fm_stock.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_11 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_11.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_11.setBounds(20, 75, 230, 25);
		fm_stock.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("500ml");
		label_12.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_12.setBounds(275, 75, 50, 25);
		fm_stock.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("10000");
		label_13.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_13.setBounds(355, 75, 50, 25);
		fm_stock.getContentPane().add(label_13);
		
		textField_2 = new JTextField();
		textField_2.setText("10000");
		textField_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(430, 75, 50, 25);
		fm_stock.getContentPane().add(textField_2);
		
		JLabel label_14 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_14.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_14.setBounds(20, 105, 230, 25);
		fm_stock.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("500ml");
		label_15.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_15.setBounds(275, 105, 50, 25);
		fm_stock.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("10000");
		label_16.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_16.setBounds(355, 105, 50, 25);
		fm_stock.getContentPane().add(label_16);
		
		textField_3 = new JTextField();
		textField_3.setText("10000");
		textField_3.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(430, 105, 50, 25);
		fm_stock.getContentPane().add(textField_3);
		
		JLabel label_17 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_17.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_17.setBounds(20, 165, 230, 25);
		fm_stock.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("500ml");
		label_18.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_18.setBounds(275, 135, 50, 25);
		fm_stock.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("10000");
		label_19.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_19.setBounds(355, 135, 50, 25);
		fm_stock.getContentPane().add(label_19);
		
		textField_4 = new JTextField();
		textField_4.setText("10000");
		textField_4.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(430, 135, 50, 25);
		fm_stock.getContentPane().add(textField_4);
		
		JLabel label_20 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_20.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_20.setBounds(20, 135, 230, 25);
		fm_stock.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("500ml");
		label_21.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_21.setBounds(275, 165, 50, 25);
		fm_stock.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("10000");
		label_22.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_22.setBounds(355, 165, 50, 25);
		fm_stock.getContentPane().add(label_22);
		
		textField_5 = new JTextField();
		textField_5.setText("10000");
		textField_5.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(430, 165, 50, 25);
		fm_stock.getContentPane().add(textField_5);
		
		JLabel label_23 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_23.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_23.setBounds(20, 195, 230, 25);
		fm_stock.getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_24.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_24.setBounds(20, 225, 230, 25);
		fm_stock.getContentPane().add(label_24);
		
		JLabel label_26 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_26.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_26.setBounds(20, 285, 230, 25);
		fm_stock.getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_27.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_27.setBounds(20, 315, 230, 25);
		fm_stock.getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("500ml");
		label_28.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_28.setBounds(275, 315, 50, 25);
		fm_stock.getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("500ml");
		label_29.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_29.setBounds(275, 285, 50, 25);
		fm_stock.getContentPane().add(label_29);
		
		JLabel label_30 = new JLabel("500ml");
		label_30.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_30.setBounds(275, 255, 50, 25);
		fm_stock.getContentPane().add(label_30);
		
		JLabel label_31 = new JLabel("500ml");
		label_31.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_31.setBounds(275, 225, 50, 25);
		fm_stock.getContentPane().add(label_31);
		
		JLabel label_32 = new JLabel("500ml");
		label_32.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_32.setBounds(275, 195, 50, 25);
		fm_stock.getContentPane().add(label_32);
		
		JLabel label_33 = new JLabel("10000");
		label_33.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_33.setBounds(355, 195, 50, 25);
		fm_stock.getContentPane().add(label_33);
		
		JLabel label_34 = new JLabel("10000");
		label_34.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_34.setBounds(355, 225, 50, 25);
		fm_stock.getContentPane().add(label_34);
		
		JLabel label_35 = new JLabel("10000");
		label_35.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_35.setBounds(355, 255, 50, 25);
		fm_stock.getContentPane().add(label_35);
		
		JLabel label_36 = new JLabel("10000");
		label_36.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_36.setBounds(355, 285, 50, 25);
		fm_stock.getContentPane().add(label_36);
		
		JLabel label_37 = new JLabel("10000");
		label_37.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_37.setBounds(355, 315, 50, 25);
		fm_stock.getContentPane().add(label_37);
		
		textField_6 = new JTextField();
		textField_6.setText("10000");
		textField_6.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(430, 315, 50, 25);
		fm_stock.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("10000");
		textField_7.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(430, 285, 50, 25);
		fm_stock.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("10000");
		textField_8.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(430, 255, 50, 25);
		fm_stock.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("10000");
		textField_9.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(430, 225, 50, 25);
		fm_stock.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("10000");
		textField_10.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_10.setColumns(10);
		textField_10.setBounds(430, 195, 50, 25);
		fm_stock.getContentPane().add(textField_10);
		
		JLabel label_38 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_38.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_38.setBounds(20, 345, 230, 25);
		fm_stock.getContentPane().add(label_38);
		
		JLabel label_39 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_39.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_39.setBounds(20, 375, 230, 25);
		fm_stock.getContentPane().add(label_39);
		
		JLabel label_40 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_40.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_40.setBounds(20, 405, 230, 25);
		fm_stock.getContentPane().add(label_40);
		
		JLabel label_41 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_41.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_41.setBounds(20, 435, 230, 25);
		fm_stock.getContentPane().add(label_41);
		
		JLabel label_42 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_42.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_42.setBounds(20, 465, 230, 25);
		fm_stock.getContentPane().add(label_42);
		
		JLabel label_43 = new JLabel("500ml");
		label_43.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_43.setBounds(275, 465, 50, 25);
		fm_stock.getContentPane().add(label_43);
		
		JLabel label_44 = new JLabel("500ml");
		label_44.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_44.setBounds(275, 435, 50, 25);
		fm_stock.getContentPane().add(label_44);
		
		JLabel label_45 = new JLabel("500ml");
		label_45.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_45.setBounds(275, 405, 50, 25);
		fm_stock.getContentPane().add(label_45);
		
		JLabel label_46 = new JLabel("500ml");
		label_46.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_46.setBounds(275, 375, 50, 25);
		fm_stock.getContentPane().add(label_46);
		
		JLabel label_47 = new JLabel("500ml");
		label_47.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_47.setBounds(275, 345, 50, 25);
		fm_stock.getContentPane().add(label_47);
		
		JLabel label_48 = new JLabel("10000");
		label_48.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_48.setBounds(355, 345, 50, 25);
		fm_stock.getContentPane().add(label_48);
		
		JLabel label_49 = new JLabel("10000");
		label_49.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_49.setBounds(355, 375, 50, 25);
		fm_stock.getContentPane().add(label_49);
		
		JLabel label_50 = new JLabel("10000");
		label_50.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_50.setBounds(355, 405, 50, 25);
		fm_stock.getContentPane().add(label_50);
		
		JLabel label_51 = new JLabel("10000");
		label_51.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_51.setBounds(355, 435, 50, 25);
		fm_stock.getContentPane().add(label_51);
		
		JLabel label_52 = new JLabel("10000");
		label_52.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_52.setBounds(355, 465, 50, 25);
		fm_stock.getContentPane().add(label_52);
		
		textField_11 = new JTextField();
		textField_11.setText("10000");
		textField_11.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_11.setColumns(10);
		textField_11.setBounds(430, 465, 50, 25);
		fm_stock.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("10000");
		textField_12.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_12.setColumns(10);
		textField_12.setBounds(430, 435, 50, 25);
		fm_stock.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("10000");
		textField_13.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_13.setColumns(10);
		textField_13.setBounds(430, 405, 50, 25);
		fm_stock.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("10000");
		textField_14.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_14.setColumns(10);
		textField_14.setBounds(430, 375, 50, 25);
		fm_stock.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("10000");
		textField_15.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_15.setColumns(10);
		textField_15.setBounds(430, 344, 50, 25);
		fm_stock.getContentPane().add(textField_15);
		
		JLabel label_53 = new JLabel("");
		label_53.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_53.setBounds(515, 45, 230, 25);
		fm_stock.getContentPane().add(label_53);
		
		JLabel label_54 = new JLabel("");
		label_54.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_54.setBounds(770, 45, 50, 25);
		fm_stock.getContentPane().add(label_54);
		
		JLabel label_55 = new JLabel("");
		label_55.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_55.setBounds(850, 45, 50, 25);
		fm_stock.getContentPane().add(label_55);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_16.setColumns(10);
		textField_16.setBounds(925, 44, 50, 25);
		fm_stock.getContentPane().add(textField_16);
		
		JLabel label_56 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_56.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_56.setBounds(515, 75, 230, 25);
		fm_stock.getContentPane().add(label_56);
		
		JLabel label_57 = new JLabel("500ml");
		label_57.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_57.setBounds(770, 75, 50, 25);
		fm_stock.getContentPane().add(label_57);
		
		JLabel label_58 = new JLabel("10000");
		label_58.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_58.setBounds(850, 75, 50, 25);
		fm_stock.getContentPane().add(label_58);
		
		textField_17 = new JTextField();
		textField_17.setText("10000");
		textField_17.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_17.setColumns(10);
		textField_17.setBounds(925, 75, 50, 25);
		fm_stock.getContentPane().add(textField_17);
		
		JLabel label_59 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_59.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_59.setBounds(515, 105, 230, 25);
		fm_stock.getContentPane().add(label_59);
		
		JLabel label_60 = new JLabel("500ml");
		label_60.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_60.setBounds(770, 105, 50, 25);
		fm_stock.getContentPane().add(label_60);
		
		JLabel label_61 = new JLabel("10000");
		label_61.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_61.setBounds(850, 105, 50, 25);
		fm_stock.getContentPane().add(label_61);
		
		textField_18 = new JTextField();
		textField_18.setText("10000");
		textField_18.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_18.setColumns(10);
		textField_18.setBounds(925, 105, 50, 25);
		fm_stock.getContentPane().add(textField_18);
		
		JLabel label_62 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_62.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_62.setBounds(515, 165, 230, 25);
		fm_stock.getContentPane().add(label_62);
		
		JLabel label_63 = new JLabel("500ml");
		label_63.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_63.setBounds(770, 135, 50, 25);
		fm_stock.getContentPane().add(label_63);
		
		JLabel label_64 = new JLabel("10000");
		label_64.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_64.setBounds(850, 135, 50, 25);
		fm_stock.getContentPane().add(label_64);
		
		textField_19 = new JTextField();
		textField_19.setText("10000");
		textField_19.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_19.setColumns(10);
		textField_19.setBounds(925, 135, 50, 25);
		fm_stock.getContentPane().add(textField_19);
		
		JLabel label_65 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_65.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_65.setBounds(515, 135, 230, 25);
		fm_stock.getContentPane().add(label_65);
		
		JLabel label_66 = new JLabel("500ml");
		label_66.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_66.setBounds(770, 165, 50, 25);
		fm_stock.getContentPane().add(label_66);
		
		JLabel label_67 = new JLabel("10000");
		label_67.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_67.setBounds(850, 165, 50, 25);
		fm_stock.getContentPane().add(label_67);
		
		textField_20 = new JTextField();
		textField_20.setText("10000");
		textField_20.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_20.setColumns(10);
		textField_20.setBounds(925, 165, 50, 25);
		fm_stock.getContentPane().add(textField_20);
		
		JLabel label_68 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_68.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_68.setBounds(515, 195, 230, 25);
		fm_stock.getContentPane().add(label_68);
		
		JLabel label_69 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_69.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_69.setBounds(515, 225, 230, 25);
		fm_stock.getContentPane().add(label_69);
		
		JLabel label_70 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_70.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_70.setBounds(515, 255, 230, 25);
		fm_stock.getContentPane().add(label_70);
		
		JLabel label_71 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_71.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_71.setBounds(515, 285, 230, 25);
		fm_stock.getContentPane().add(label_71);
		
		JLabel label_72 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_72.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_72.setBounds(515, 315, 230, 25);
		fm_stock.getContentPane().add(label_72);
		
		JLabel label_73 = new JLabel("500ml");
		label_73.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_73.setBounds(770, 315, 50, 25);
		fm_stock.getContentPane().add(label_73);
		
		JLabel label_74 = new JLabel("500ml");
		label_74.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_74.setBounds(770, 285, 50, 25);
		fm_stock.getContentPane().add(label_74);
		
		JLabel label_75 = new JLabel("500ml");
		label_75.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_75.setBounds(770, 255, 50, 25);
		fm_stock.getContentPane().add(label_75);
		
		JLabel label_76 = new JLabel("500ml");
		label_76.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_76.setBounds(770, 225, 50, 25);
		fm_stock.getContentPane().add(label_76);
		
		JLabel label_77 = new JLabel("500ml");
		label_77.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_77.setBounds(770, 195, 50, 25);
		fm_stock.getContentPane().add(label_77);
		
		JLabel label_78 = new JLabel("10000");
		label_78.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_78.setBounds(850, 195, 50, 25);
		fm_stock.getContentPane().add(label_78);
		
		JLabel label_79 = new JLabel("10000");
		label_79.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_79.setBounds(850, 225, 50, 25);
		fm_stock.getContentPane().add(label_79);
		
		JLabel label_80 = new JLabel("10000");
		label_80.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_80.setBounds(850, 255, 50, 25);
		fm_stock.getContentPane().add(label_80);
		
		JLabel label_81 = new JLabel("10000");
		label_81.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_81.setBounds(850, 285, 50, 25);
		fm_stock.getContentPane().add(label_81);
		
		JLabel label_82 = new JLabel("10000");
		label_82.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_82.setBounds(850, 315, 50, 25);
		fm_stock.getContentPane().add(label_82);
		
		textField_21 = new JTextField();
		textField_21.setText("10000");
		textField_21.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_21.setColumns(10);
		textField_21.setBounds(925, 315, 50, 25);
		fm_stock.getContentPane().add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setText("10000");
		textField_22.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_22.setColumns(10);
		textField_22.setBounds(925, 285, 50, 25);
		fm_stock.getContentPane().add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setText("10000");
		textField_23.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_23.setColumns(10);
		textField_23.setBounds(925, 255, 50, 25);
		fm_stock.getContentPane().add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setText("10000");
		textField_24.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_24.setColumns(10);
		textField_24.setBounds(925, 225, 50, 25);
		fm_stock.getContentPane().add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setText("10000");
		textField_25.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_25.setColumns(10);
		textField_25.setBounds(925, 195, 50, 25);
		fm_stock.getContentPane().add(textField_25);
		
		JLabel label_83 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_83.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_83.setBounds(515, 345, 230, 25);
		fm_stock.getContentPane().add(label_83);
		
		JLabel label_84 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_84.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_84.setBounds(515, 375, 230, 25);
		fm_stock.getContentPane().add(label_84);
		
		JLabel label_85 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_85.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_85.setBounds(515, 405, 230, 25);
		fm_stock.getContentPane().add(label_85);
		
		JLabel label_86 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_86.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_86.setBounds(515, 435, 230, 25);
		fm_stock.getContentPane().add(label_86);
		
		JLabel label_87 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_87.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_87.setBounds(515, 465, 230, 25);
		fm_stock.getContentPane().add(label_87);
		
		JLabel label_88 = new JLabel("500ml");
		label_88.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_88.setBounds(770, 465, 50, 25);
		fm_stock.getContentPane().add(label_88);
		
		JLabel label_89 = new JLabel("500ml");
		label_89.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_89.setBounds(770, 435, 50, 25);
		fm_stock.getContentPane().add(label_89);
		
		JLabel label_90 = new JLabel("500ml");
		label_90.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_90.setBounds(770, 405, 50, 25);
		fm_stock.getContentPane().add(label_90);
		
		JLabel label_91 = new JLabel("500ml");
		label_91.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_91.setBounds(770, 375, 50, 25);
		fm_stock.getContentPane().add(label_91);
		
		JLabel label_92 = new JLabel("500ml");
		label_92.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_92.setBounds(770, 345, 50, 25);
		fm_stock.getContentPane().add(label_92);
		
		JLabel label_93 = new JLabel("10000");
		label_93.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_93.setBounds(850, 345, 50, 25);
		fm_stock.getContentPane().add(label_93);
		
		JLabel label_94 = new JLabel("10000");
		label_94.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_94.setBounds(850, 375, 50, 25);
		fm_stock.getContentPane().add(label_94);
		
		JLabel label_95 = new JLabel("10000");
		label_95.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_95.setBounds(850, 405, 50, 25);
		fm_stock.getContentPane().add(label_95);
		
		JLabel label_96 = new JLabel("10000");
		label_96.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_96.setBounds(850, 435, 50, 25);
		fm_stock.getContentPane().add(label_96);
		
		JLabel label_97 = new JLabel("10000");
		label_97.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_97.setBounds(850, 465, 50, 25);
		fm_stock.getContentPane().add(label_97);
		
		textField_26 = new JTextField();
		textField_26.setText("10000");
		textField_26.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_26.setColumns(10);
		textField_26.setBounds(925, 465, 50, 25);
		fm_stock.getContentPane().add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setText("10000");
		textField_27.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_27.setColumns(10);
		textField_27.setBounds(925, 435, 50, 25);
		fm_stock.getContentPane().add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setText("10000");
		textField_28.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_28.setColumns(10);
		textField_28.setBounds(925, 405, 50, 25);
		fm_stock.getContentPane().add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setText("10000");
		textField_29.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_29.setColumns(10);
		textField_29.setBounds(925, 375, 50, 25);
		fm_stock.getContentPane().add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setText("10000");
		textField_30.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_30.setColumns(10);
		textField_30.setBounds(925, 344, 50, 25);
		fm_stock.getContentPane().add(textField_30);
		
		JLabel label_25 = new JLabel("\u725B\u5976\u6D77\u6D0B\u88E1\u7684\u9BAD\u9B5A\u4E73\u916A\u91AC");
		label_25.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_25.setBounds(20, 255, 230, 25);
		fm_stock.getContentPane().add(label_25);
		
		JPanel pn_stock = new JPanel();
		pn_stock.setBackground(Color.WHITE);
		pn_stock.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pn_stock.setBounds(10, 40, 975, 455);
		fm_stock.getContentPane().add(pn_stock);
		pn_stock.setLayout(null);
		
		JButton btn_stock_exit = new JButton("\u96E2\u958B");
		btn_stock_exit.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_stock_exit.setBounds(885, 500, 87, 40);
		fm_stock.getContentPane().add(btn_stock_exit);
		
		JButton btn_stock_reset = new JButton("\u6B78\u96F6");
		btn_stock_reset.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_stock_reset.setBounds(795, 500, 87, 40);
		fm_stock.getContentPane().add(btn_stock_reset);
		
		JButton btn_stock_replace = new JButton("\u53D6\u4EE3");
		btn_stock_replace.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_stock_replace.setBounds(705, 500, 87, 40);
		fm_stock.getContentPane().add(btn_stock_replace);
		
		JButton btn_stock_revise = new JButton("\u8ABF\u6574");
		btn_stock_revise.setFont(new Font("新細明體", Font.PLAIN, 26));
		btn_stock_revise.setBounds(615, 500, 87, 40);
		fm_stock.getContentPane().add(btn_stock_revise);
		
	}
}
