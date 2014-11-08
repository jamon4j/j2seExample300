package j2seExample300.Chapter8StringAndWrapper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UpperLowerConvert extends JFrame {
	private JPanel contentPane;
	private JTextField tf1,tf2;
	private JButton button;
	private ButtonGroup bg;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
			{
				public void run() {
					UpperLowerConvert ulc = new UpperLowerConvert();
					ulc.setVisible(true);
				}
				
			}
		);
	}
	
	public UpperLowerConvert()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("字符串大小写转换");
		this.setBounds(300, 300, 300, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.add(contentPane);
		
		tf1 = new JTextField();
		tf1.setBounds(20, 20, 260, 30);
		contentPane.add(tf1);
		
		button = new JButton("转换");
		button.setBounds(20, 70, 80, 30);
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		}
		);
		contentPane.add(button);
		
		bg = new ButtonGroup();
		JRadioButton radioButton1 = new JRadioButton("大写");
		radioButton1.setActionCommand("大写");
		radioButton1.setSelected(true);
		radioButton1.setBounds(130, 70, 80, 20);
		bg.add(radioButton1);
		contentPane.add(radioButton1);
		
		JRadioButton radioButton2 = new JRadioButton("小写");
		radioButton2.setActionCommand("小写");
		radioButton2.setBounds(210, 70, 80, 20);
		bg.add(radioButton2);
		contentPane.add(radioButton2);
		
		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setBounds(20, 120, 260, 30);
		contentPane.add(tf2);
	}
	
	protected void do_button_actionPerformed(ActionEvent e)
	{
		String command = bg.getSelection().getActionCommand();
		boolean upper = command.equals("大写");
		String text = tf1.getText();
		if(upper)
		{
			tf2.setText(text.toUpperCase());
		}else {
			tf2.setText(text.toLowerCase());
		}
	}
}
