package j2seExample300.Chapter5Array;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QuickSort extends JFrame {
	private JPanel contentPane;
	private JTextArea ta1,ta2;
	private JButton b1,b2;
	private GridBagLayout bal;
	private int[] arr;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				QuickSort qs = new QuickSort();
				qs.setVisible(true);
			}
			
		});
	}
	
	public void initFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("使用快速排序法对数组排序");
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

	public QuickSort()
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
		quickSort(0,arr.length-1);
	}
	
	/*
	 * 快速排序算法对数组排序
	 */
	protected void quickSort(int start,int end)
	{
		if(start<end)
		{
			int low = start;
			int high = end;
			int key = arr[low];
			while(low<high)
			{
				while(low<high&&arr[high]>=key) high--;
				arr[low] = arr[high];
				while(low<high&&arr[low]<=key) low++;
				arr[high] = arr[low];
			}
			arr[low] = key;
			for(int i=0;i<arr.length;i++)
			{
				if(i==low) 
				{
					ta2.append("["+arr[i]+"]"+" ");
				}
				else ta2.append(arr[i]+" ");
			}
			ta2.append("\n");
			quickSort(start,low-1);
			quickSort(low+1,end);
		}
	}
}
