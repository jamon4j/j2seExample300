package j2seExample300.Chapter5Array;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/*
 * 题目：选择数组中最小数（带界面）
 * 关键：JPanel,JFrame.../将一串字符数字转换为数组/去掉数字间不定数空格（正则表达式）
 */
public class ArrayMinValue extends JFrame{
	
	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	private JLabel label;
	private JLabel label_1;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					ArrayMinValue frame = new ArrayMinValue();
					frame.setVisible(true);
				}
			});
	}
	
	public ArrayMinValue()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,149);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(200,200,200,200));
		this.setContentPane(contentPane);
		this.setTitle("获取一维数组的最小值");
		
		textField = new JTextField();
		textField.setBounds(6, 36, 414, 30);
		textField.setColumns(10);
		contentPane.add(textField);
		
		button = new JButton("计算");
		button.setBounds(16, 76, 90, 30);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
			
		});
		contentPane.add(button);
		
		label = new JLabel("最小值：");
		label.setBounds(116, 82, 304, 18);
		contentPane.add(label);
		
		label_1 = new JLabel("请在文本框中输入多个整数，以空格为分隔符。例如：3 5 2 262 125");
		label_1.setBounds(6,6,442,18);
		contentPane.add(label_1);		
	}
	
	protected void do_button_actionPerformed(ActionEvent e){
		String arrayStr = textField.getText().trim();
		if(arrayStr.equals(""))
		{
			JOptionPane.showMessageDialog(null, "请输入数字内容");
			return;
		}
		for(int i=0;i<arrayStr.length();i++)
		{
			char charAt = arrayStr.charAt(i);
			if(!Character.isDigit(charAt)&&charAt!=' ')
			{
				JOptionPane.showMessageDialog(null, "输入包含非数字内容");
				textField.setText("");
				return;
			}
		}
		String[] numStrs = arrayStr.split(" {1,}");//使用正则表达式分割不定量空格
		int[] numArray = new int[numStrs.length];
		
		for(int i=0;i<numStrs.length;i++)
		{
			numArray[i] = Integer.valueOf(numStrs[i]);
		}
		
		int min = numArray[0];
		
		for(int i=0;i<numArray.length;i++)
		{
			if(numArray[i]<min) min = numArray[i];
		}
		
		label.setText("数组中的最小数是："+min);
	}
}
