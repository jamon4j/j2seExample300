package j2seExample300.Chapter8StringAndWrapper;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang.NumberUtils;

public class CheckNumber extends JFrame {
	private JPanel contentPane;
	private JLabel label1,label2;
	private JTextField tf;
	private JButton button;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				CheckNumber cn = new CheckNumber();
				cn.setVisible(true);
			}
		}
	);
	}
	
	public CheckNumber()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("判断是否输入数字");
		this.setBounds(400, 400, 300, 150);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		this.setContentPane(contentPane);
		
		label1 = new JLabel("输入金额：");
		label1.setBounds(5, 5, 80, 30);
		contentPane.add(label1);
		
		tf = new JTextField();
		tf.setBounds(70, 5, 180, 30);
		contentPane.add(tf);
		
		label2 = new JLabel("元");
		label2.setBounds(5, 5, 280, 30);
		contentPane.add(label2);
		
		button = new JButton("判断");
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
		String temp = tf.getText();
		boolean isNum = NumberUtils.isNumber(temp);
		if(isNum){
			JOptionPane.showMessageDialog(null, "输入正确，是数字格式");
		}else{
			JOptionPane.showMessageDialog(null, "输入错误，请确认格式再输入");
		}
	}
}
