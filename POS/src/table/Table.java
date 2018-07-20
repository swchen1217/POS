package table;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Table {

	private JFrame fm_man_menu_5_set;
	private JTextField tf_menu2_set_name1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	JLabel lb_manu5_set_name,lb_menu5_set_price;
	JButton btn_menu5_set_ok,btn_menu5_set_cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
					window.fm_man_menu_5_set.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fm_man_menu_5_set = new JFrame();
		fm_man_menu_5_set.setTitle("POS-\u5176\u4ED6\u985E\u83DC\u55AE\u8A2D\u5B9A");
		fm_man_menu_5_set.setResizable(false);
		fm_man_menu_5_set.setBounds(100, 100, 300, 260);
		fm_man_menu_5_set.getContentPane().setLayout(null);
		//fm_man_menu_5_set.setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getResource("/pic/icon.png")));
		fm_man_menu_5_set.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		//fm_man_menu_5_set.setVisible(false);
		fm_man_menu_5_set.getContentPane().add(btn_menu5_set_cancel);
		fm_man_menu_5_set.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		lb_manu5_set_name = new JLabel("\u54C1\u540D");
		lb_manu5_set_name.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_manu5_set_name.setBounds(95, 10, 45, 20);
		fm_man_menu_5_set.getContentPane().add(lb_manu5_set_name);
		
		lb_menu5_set_price = new JLabel("\u55AE\u50F9");
		lb_menu5_set_price.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_menu5_set_price.setBounds(238, 10, 45, 20);
		fm_man_menu_5_set.getContentPane().add(lb_menu5_set_price);
		
		tf_menu2_set_name1 = new JTextField();
		tf_menu2_set_name1.setEditable(false);
		tf_menu2_set_name1.setFont(new Font("新細明體", Font.PLAIN, 20));
		tf_menu2_set_name1.setText("\u6BCF\u65E5\u7279\u9910");
		tf_menu2_set_name1.setBounds(10, 35, 215, 27);
		fm_man_menu_5_set.getContentPane().add(tf_menu2_set_name1);
		tf_menu2_set_name1.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_1.setBounds(235, 35, 50, 27);
		fm_man_menu_5_set.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(10, 65, 215, 27);
		fm_man_menu_5_set.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(235, 65, 50, 27);
		fm_man_menu_5_set.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(10, 95, 215, 27);
		fm_man_menu_5_set.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(10, 125, 215, 27);
		fm_man_menu_5_set.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_6.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(235, 95, 50, 27);
		fm_man_menu_5_set.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_7.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(235, 125, 50, 27);
		fm_man_menu_5_set.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(10, 155, 215, 27);
		fm_man_menu_5_set.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_9.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(235, 155, 50, 27);
		fm_man_menu_5_set.getContentPane().add(textField_9);
		
		btn_menu5_set_ok = new JButton("\u78BA\u5B9A");
		btn_menu5_set_ok.setFont(new Font("新細明體", Font.PLAIN, 20));
		btn_menu5_set_ok.setBounds(48, 190, 75, 30);
		fm_man_menu_5_set.getContentPane().add(btn_menu5_set_ok);
		
		btn_menu5_set_cancel = new JButton("\u53D6\u6D88");
		btn_menu5_set_cancel.setFont(new Font("新細明體", Font.PLAIN, 20));
		btn_menu5_set_cancel.setBounds(171, 190, 75, 30);
		
	}
}
