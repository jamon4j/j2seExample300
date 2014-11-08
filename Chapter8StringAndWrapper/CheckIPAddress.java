package j2seExample300.Chapter8StringAndWrapper;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang.NumberUtils;

/*
 *	检查IP地址是否合法 
 */

public class CheckIPAddress extends JFrame {
	private JPanel contentPane;
	private JLabel label;
	private JTextField tf;
	private JButton button;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				CheckIPAddress cia = new CheckIPAddress();
				cia.setVisible(true);
			}
		}
	);
	}
	
	public CheckIPAddress()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("判断IP地址有效性");
		this.setBounds(400, 400, 300, 150);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		this.setContentPane(contentPane);
		
		label = new JLabel("输入IP地址：");
		label.setBounds(5, 5, 80, 30);
		contentPane.add(label);
		
		tf = new JTextField();
		tf.setBounds(70, 5, 180, 30);
		contentPane.add(tf);
		
		button = new JButton("验证");
		button.setBounds(120, 50, 80, 30);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
			
		});
		contentPane.add(button);
	}
	
	public void do_button_actionPerformed(ActionEvent e)
	{
		String text = tf.getText();
		Pattern p = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
				+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
		Matcher m = p.matcher(text);
		if(m.matches()){
			JOptionPane.showMessageDialog(null, text+"是一个合法的IP地址");
		}else{
			JOptionPane.showMessageDialog(null, text+"不是一个合法的IP地址");
		}
	}
}
