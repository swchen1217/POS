package wb;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;

import java.awt.FlowLayout;

import javax.swing.SpringLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;

public class pos_wb {

	private JFrame fm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pos_wb window = new pos_wb();
					window.fm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pos_wb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		fm = new JFrame();
		fm.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 20));
		fm.setIconImage(Toolkit.getDefaultToolkit().getImage(pos_wb.class.getResource("/pic/icon.png")));
		fm.setTitle("POS\u7CFB\u7D71");
		fm.setResizable(false);
		fm.setBounds(100, 100, 1200, 750);
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm.getContentPane().setLayout(null);
		
		JTabbedPane tab_menu = new JTabbedPane(JTabbedPane.TOP);
		tab_menu.setFont(new Font("新細明體", Font.PLAIN, 18));
		tab_menu.setBounds(800, 10, 390, 700);
		tab_menu.setForeground(Color.BLACK);
		fm.getContentPane().add(tab_menu);
		
		JPanel pn_menu_1 = new JPanel();
		tab_menu.addTab("\u7570\u60F3\u6F22\u5821", null, pn_menu_1, null);
		
		JPanel pn_menu_2 = new JPanel();
		tab_menu.addTab("\u5BE6\u9A57\u4E73\u916A", null, pn_menu_2, null);
		
		JPanel pn_menu_3 = new JPanel();
		tab_menu.addTab("\u7206\u6F3F\u571F\u53F8", null, pn_menu_3, null);
		
		JPanel pn_menu_4 = new JPanel();
		tab_menu.addTab("\u85E5\u6C34\u98F2\u54C1", null, pn_menu_4, null);
		
		JPanel pn_menu_5 = new JPanel();
		tab_menu.addTab("\u5176\u4ED6", null, pn_menu_5, null);
		
		JTabbedPane tab_order_list = new JTabbedPane(JTabbedPane.LEFT);
		tab_order_list.setBounds(10, 10, 400, 550);
		fm.getContentPane().add(tab_order_list);
		
		JPanel pn_list_1 = new JPanel();
		tab_order_list.addTab("1", null, pn_list_1, null);
		
		JPanel pn_list_2 = new JPanel();
		tab_order_list.addTab("2", null, pn_list_2, null);
		
		JPanel pn_list_3 = new JPanel();
		tab_order_list.addTab("3", null, pn_list_3, null);
		
		JPanel pn_list_4 = new JPanel();
		tab_order_list.addTab("4", null, pn_list_4, null);
		
		JPanel pn_list_5 = new JPanel();
		tab_order_list.addTab("5", null, pn_list_5, null);
		
	}
}
