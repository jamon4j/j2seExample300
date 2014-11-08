package j2seExample300.Chapter5Array;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/*
 * ��Ŀ��ѡ����������С���������棩
 * �ؼ���JPanel,JFrame.../��һ���ַ�����ת��Ϊ����/ȥ�����ּ䲻�����ո�������ʽ��
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
		this.setTitle("��ȡһά�������Сֵ");
		
		textField = new JTextField();
		textField.setBounds(6, 36, 414, 30);
		textField.setColumns(10);
		contentPane.add(textField);
		
		button = new JButton("����");
		button.setBounds(16, 76, 90, 30);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
			
		});
		contentPane.add(button);
		
		label = new JLabel("��Сֵ��");
		label.setBounds(116, 82, 304, 18);
		contentPane.add(label);
		
		label_1 = new JLabel("�����ı������������������Կո�Ϊ�ָ��������磺3 5 2 262 125");
		label_1.setBounds(6,6,442,18);
		contentPane.add(label_1);		
	}
	
	protected void do_button_actionPerformed(ActionEvent e){
		String arrayStr = textField.getText().trim();
		if(arrayStr.equals(""))
		{
			JOptionPane.showMessageDialog(null, "��������������");
			return;
		}
		for(int i=0;i<arrayStr.length();i++)
		{
			char charAt = arrayStr.charAt(i);
			if(!Character.isDigit(charAt)&&charAt!=' ')
			{
				JOptionPane.showMessageDialog(null, "�����������������");
				textField.setText("");
				return;
			}
		}
		String[] numStrs = arrayStr.split(" {1,}");//ʹ��������ʽ�ָ�����ո�
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
		
		label.setText("�����е���С���ǣ�"+min);
	}
}
