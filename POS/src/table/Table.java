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

	private JFrame fm_man_table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
					window.fm_man_table.setVisible(true);
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
		fm_man_table = new JFrame();
		fm_man_table.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		fm_man_table.setTitle("POS\u7CFB\u7D71-桌位管理");
		fm_man_table.setResizable(false);
		fm_man_table.setBounds(100, 100, 1005, 790);
		fm_man_table.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fm_man_table.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 250, 150);
		fm_man_table.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("00");
		label.setBounds(10, 10, 40, 40);
		label.setFont(new Font("新細明體", Font.PLAIN, 40));
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("\u55AE\u865F : ");
		lblNewLabel.setBounds(65, 40, 60, 20);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u72C0\u614B : ");
		lblNewLabel_2.setBounds(55, 65, 60, 20);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u65B0\u55AE");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 19));
		btnNewButton.setBounds(10, 100, 70, 40);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u9910\u7562");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setFont(new Font("新細明體", Font.PLAIN, 19));
		button.setBounds(80, 100, 70, 40);
		panel.add(button);
		
		JButton button_1 = new JButton("\u5B8C\u6210");
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setFont(new Font("新細明體", Font.PLAIN, 19));
		button_1.setBounds(150, 100, 70, 40);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField.setText("999");
		textField.setBounds(120, 40, 35, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("\u6E05\u6F54\u4E2D");
		textField_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_1.setBounds(115, 65, 65, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 150, 250, 150);
		fm_man_table.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 300, 250, 150);
		fm_man_table.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(0, 450, 250, 150);
		fm_man_table.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 607, 250, 150);
		fm_man_table.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel label_1 = new JLabel("\u5916\u5E36");
		label_1.setFont(new Font("新細明體", Font.PLAIN, 40));
		label_1.setBounds(10, 10, 85, 40);
		panel_4.add(label_1);
		
		JButton button_2 = new JButton("\u65B0\u55AE");
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setFont(new Font("新細明體", Font.PLAIN, 19));
		button_2.setBounds(80, 100, 70, 40);
		panel_4.add(button_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBounds(250, 0, 250, 150);
		fm_man_table.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_7.setBounds(250, 150, 250, 150);
		fm_man_table.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_8.setBounds(250, 300, 250, 150);
		fm_man_table.getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_9.setBounds(250, 450, 250, 150);
		fm_man_table.getContentPane().add(panel_9);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_10.setBounds(500, 0, 250, 150);
		fm_man_table.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_12.setBounds(500, 150, 250, 150);
		fm_man_table.getContentPane().add(panel_12);
		panel_12.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_13.setBounds(500, 300, 250, 150);
		fm_man_table.getContentPane().add(panel_13);
		panel_13.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_14.setBounds(500, 450, 250, 150);
		fm_man_table.getContentPane().add(panel_14);
		panel_14.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(750, 0, 250, 150);
		fm_man_table.getContentPane().add(panel_15);
		panel_15.setLayout(null);
		panel_15.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(750, 150, 250, 150);
		fm_man_table.getContentPane().add(panel_17);
		panel_17.setLayout(null);
		panel_17.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(750, 300, 250, 150);
		fm_man_table.getContentPane().add(panel_18);
		panel_18.setLayout(null);
		panel_18.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(750, 450, 250, 150);
		fm_man_table.getContentPane().add(panel_19);
		panel_19.setLayout(null);
		panel_19.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btn_table_exit = new JButton("\u96E2\u958B");
		btn_table_exit.setFont(new Font("新細明體", Font.PLAIN, 50));
		btn_table_exit.setBounds(250, 600, 250, 150);
		fm_man_table.getContentPane().add(btn_table_exit);
	}
}
