package j2seExample300.Chapter5Array;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BubbleSort extends JFrame {
	private JPanel contentPane;
	private JTextArea ta1,ta2;
	private JButton b1,b2;
	private GridBagLayout bal;
	private int[] arr;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				BubbleSort bs = new BubbleSort();
				bs.setVisible(true);
			}
			
		});
	}
	
	public void initFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("使用冒泡法对数组排序");
		this.setBounds(400, 250, 300, 300);
		contentPane = new JPanel();
		bal = new GridBagLayout();
		bal.columnWeights = new double[]{1.0,Double.MIN_VALUE};
		bal.columnWidths = new int[]{0,0};
		bal.rowWeights = new double[]{0,0.0,1.0,0.0,Double.MIN_VALUE};
		bal.rowHeights = new int[]{0,0,0,0,0};
		contentPane.setLayout(bal);
		this.add(contentPane);
	}
	
	public BubbleSort()
	{
		initFrame();
		ta1 = new JTextArea();
		GridBagConstraints gbc_ta1 = new GridBagConstraints();
		gbc_ta1.fill = GridBagConstraints.BOTH;
		gbc_ta1.insets = new Insets(0,0,5,0);
		gbc_ta1.gridx = 0;
		gbc_ta1.gridy = 0;
		gbc_ta1.weighty = 0.2;
		contentPane.add(ta1,gbc_ta1);
		
		b1 = new JButton("生成随机数组");
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_b1 = new GridBagConstraints();
		gbc_b1.gridx = 0;
		gbc_b1.gridy = 1;
		gbc_b1.insets = new Insets(0,0,5,0);
		contentPane.add(b1,gbc_b1);
		
		ta2 = new JTextArea();
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(ta2);
		GridBagConstraints gbc_sp = new GridBagConstraints();
		gbc_sp.fill = GridBagConstraints.BOTH;
		gbc_sp.gridx = 0;
		gbc_sp.gridy = 2;
		gbc_sp.insets = new Insets(0,0,5,0);
		contentPane.add(sp,gbc_sp);
		
		b2 = new JButton("排序");
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_b2 = new GridBagConstraints();
		gbc_b2.gridx = 0;
		gbc_b2.gridy = 3;
		contentPane.add(b2,gbc_b2);
	}
	
	protected void do_b1_actionPerformed(ActionEvent e)
	{
		ta1.setText("");
		Random r = new Random();
		arr = new int[10];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = r.nextInt(50);
			ta1.append(arr[i]+" ");
		}
	}
	
	protected void do_b2_actionPerformed(ActionEvent e)
	{
		ta2.setText("");
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<arr.length-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					arr[j] = arr[j] ^ arr[j+1];
					arr[j+1] = arr[j] ^ arr[j+1];
					arr[j] = arr[j] ^ arr[j+1];
				}
			}
			
			for(int j=0;j<arr.length;j++)
			{
				if(j==arr.length - i - 1)
				{
					ta2.append("[ ");
				}
				ta2.append(arr[j] + " ");
			}
			ta2.append(" ]"+"\n");
		}
	}
}
