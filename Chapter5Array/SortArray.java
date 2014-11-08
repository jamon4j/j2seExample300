package j2seExample300.Chapter5Array;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SortArray extends JFrame {
	private JPanel contentPane;
	private JLabel label;
	private JTextArea ta;
	private JTextField tf;
	private JButton button;
	private GridBagLayout bal;
	private int[] arr;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				SortArray sa= new SortArray();
				sa.setVisible(true);
			}
			
		});
	}
	
	public void initFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ʹ��sort��������������");
		this.setBounds(400, 250, 600, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		this.add(contentPane);
	}
	
	public SortArray()
	{
		initFrame();
		label = new JLabel("�����������ݣ��ո�Ϊ����Ԫ�طָ���");
		label.setBounds(10, 5, 300, 30);
		contentPane.add(label);
		
		tf = new JTextField();
		tf.setBounds(10, 50, 550, 30);
		contentPane.add(tf);
		
		button = new JButton("����");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});
		button.setBounds(250, 90, 100, 30);
		contentPane.add(button);
		
		JScrollPane sp = new JScrollPane();
		ta = new JTextArea();
		sp.setViewportView(ta);
		sp.setBounds(10, 130, 550, 100);
		contentPane.add(sp);
	}
	
	protected void do_button_actionPerformed(ActionEvent e)
	{
		String str = tf.getText();
		String[] s = str.split(" ");
		int[] arr = new int[s.length];
		
		ta.append("����ԭ������\n");
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.valueOf(s[i]);
			ta.append(arr[i]+" ");
		}
		
		Arrays.sort(arr);
		
		ta.append("\n��������������\n");
		for(int i=0;i<arr.length;i++)
		{
			ta.append(arr[i]+" ");
		}
	}
}
