package login;



import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

	JFrame fm_login;
	JLabel lb_login_icon,lb_login_name1,lb_login_name2,lb_login_name3,lb_login_un,lb_login_pw;
	JTextField tf_login_un,tf_login_pw;
	JButton btn_login_login,btn_login_exit;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fm_login = new JFrame();
		fm_login.setTitle("Madhouse POS-登入系統");
		fm_login.setResizable(false);
		fm_login.setBounds(100, 100, 250, 210);
		fm_login.getContentPane().setLayout(null);
		fm_login.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 22));
		fm_login.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		lb_login_icon = new JLabel("");
		lb_login_icon.setIcon(new ImageIcon(Login.class.getResource("/pic/Madhouse2.png")));
		lb_login_icon.setBounds(10, 10, 70, 70);
		fm_login.getContentPane().add(lb_login_icon);
		
		lb_login_name1 = new JLabel("Madhouse");
		lb_login_name1.setFont(new Font("新細明體", Font.BOLD, 20));
		lb_login_name1.setBounds(120, 7, 85, 25);
		fm_login.add(lb_login_name1);
		
		lb_login_name2 = new JLabel("\u7570\u60F3\u6599\u7406\u5BE6\u9A57\u5BA4");
		lb_login_name2.setFont(new Font("新細明體", Font.BOLD, 20));
		lb_login_name2.setBounds(90, 30, 150, 25);
		fm_login.add(lb_login_name2);
		
		lb_login_name3 = new JLabel("POS-\u767B\u5165\u7CFB\u7D71");
		lb_login_name3.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_login_name3.setBounds(100, 55, 120, 25);
		fm_login.add(lb_login_name3);
		
		lb_login_un = new JLabel("\u5E33\u865F : ");
		lb_login_un.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_login_un.setBounds(10, 90, 55, 25);
		fm_login.add(lb_login_un);
		
		lb_login_pw = new JLabel("\u5BC6\u78BC : ");
		lb_login_pw.setFont(new Font("新細明體", Font.PLAIN, 20));
		lb_login_pw.setBounds(10, 115, 55, 25);
		fm_login.add(lb_login_pw);
		
		tf_login_un = new JTextField();
		tf_login_un.setBounds(65, 90, 155, 25);
		fm_login.add(tf_login_un);
		tf_login_un.setColumns(10);
		
		tf_login_pw = new JTextField();
		tf_login_pw.setColumns(10);
		tf_login_pw.setBounds(65, 115, 155, 25);
		fm_login.add(tf_login_pw);
		
		btn_login_login = new JButton("\u767B\u5165");
		btn_login_login.setFont(new Font("新細明體", Font.PLAIN, 19));
		btn_login_login.setBounds(25, 150, 90, 25);
		fm_login.add(btn_login_login);
		
		btn_login_exit = new JButton("\u96E2\u958B");
		btn_login_exit.setFont(new Font("新細明體", Font.PLAIN, 19));
		btn_login_exit.setBounds(125, 150, 90, 25);
		fm_login.add(btn_login_exit);
	}
}
