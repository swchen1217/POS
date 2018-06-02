import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class POS {
	private File f;
    private BufferedWriter bw;
    
    private JPanel pn;
    private JFrame fm;        
    
    private JLabel lb_title[]=new JLabel[5];
    private JLabel lb_name[]=new JLabel[4];
    private JLabel lb_price[]=new JLabel[4];
    private JLabel lb_others[]=new JLabel[6];        
    
    private JTextField tf_qty[]=new JTextField[4];
    private JTextField tf_sum[]=new JTextField[4];
    private JTextField tf_total;
    private JTextField tf_pay;
    private JTextField tf_change;        
    
    private JButton btn_plus[]=new JButton[4];
    private JButton btn_minus[]=new JButton[4];
    private JButton btn_checkout, btn_clear;
    
    private ImageIcon icon, checkout, clear;
    
    private String name1[]={"品名","單價","數量","增/減","小計"};
private String name2[]={"QQ蛋","炭烤三明治","珍珠奶茶","彈珠汽水"};
    
private int qty[]=new int[]{0,0,0,0};
    private int sum[]=new int[]{0,0,0,0};
    private int price[]=new int[]{22,49,29,12};
    private int tot=0;
    private int pay;
    private int money;
	
	public POS(){
		initialize();
        record();
	}

	private void record()
    {
            
    }
    private void initialize() {
    	
    		icon=new ImageIcon(POS.class.getResource("pic/icon.png"));
            
            fm=new JFrame();
            fm.setVisible(true);
            fm.setResizable(false);
            fm.setIconImage(icon.getImage());
            fm.setTitle("POS系統");
            fm.setBounds(100, 100, 1500, 750);
            fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fm.setLayout(null);    
    }
	public static void main(String[] args) {
		new POS();

	}

}
