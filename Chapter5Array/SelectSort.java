package j2seExample300.Chapter5Array;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

/*
 * 选择排序，GridBagLayout布局
 */
public class SelectSort extends JFrame {
	private JPanel contentPane;
	private JTextArea ta1,ta2;
	private JButton b_crt,b_sort;
	private int[] arr;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				SelectSort ss = new SelectSort();
				ss.setVisible(true);
			}
		});
	}
	
	public SelectSort()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(500, 250, 400, 400);
		this.setTitle("使用选择排序法对数组排序");
		contentPane = new JPanel();
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0,0};
		gbl_contentPane.columnWeights = new double[]{1.0,Double.MIN_VALUE};
		gbl_contentPane.rowHeights = new int[]{0,0,0,0,0};
		gbl_contentPane.rowWeights = new double[]{1.0,0.0,1.0,0.0,Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setContentPane(contentPane);
		
		JScrollPane sp1 = new JScrollPane();	
		GridBagConstraints gbc_sp1 = new GridBagConstraints();
		gbc_sp1.insets = new Insets(0, 0, 1, 0);
		gbc_sp1.fill = GridBagConstraints.BOTH;
		gbc_sp1.gridx = 0;
		gbc_sp1.gridy = 0;
		contentPane.add(sp1,gbc_sp1);
		
		ta1 = new JTextArea();
		sp1.setViewportView(ta1);
		
		b_crt = new JButton("生成随机数组");
		b_crt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				do_bCrt_actionPerformed(e);
			}
		}
		);
		
		GridBagConstraints gbc_bCrt = new GridBagConstraints();
		gbc_bCrt.insets = new Insets(0,0,5,0);//???
		gbc_bCrt.gridx = 0;
		gbc_bCrt.gridy = 1;
		contentPane.add(b_crt,gbc_bCrt);
		
		JScrollPane sp2 = new JScrollPane();
		GridBagConstraints gbc_sp2 = new GridBagConstraints();
		gbc_sp2.insets = new Insets(0,0,5,0);
		gbc_sp2.fill = GridBagConstraints.BOTH;
		gbc_sp2.gridx = 0;
		gbc_sp2.gridy = 2;
		contentPane.add(sp2,gbc_sp2);
		
		ta2 = new JTextArea();
		sp2.setViewportView(ta2);
		
		b_sort = new JButton("排序");
		b_sort.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				do_bSort_actionPerformed(e);
			}
		}
		);
		
		GridBagConstraints gbc_bSort = new GridBagConstraints();
		gbc_bSort.insets = new Insets(0,0,5,0);
		gbc_bSort.gridx = 0;
		gbc_bSort.gridy = 3;
		contentPane.add(b_sort,gbc_bSort);
	}
	
	public void do_bCrt_actionPerformed(ActionEvent e)
	{
		int len = 10;
		Random r = new Random();
		arr = new int[len];
		for(int i=0;i<len;i++)
		{
			arr[i] = r.nextInt(50);	//生成50以内的随机数
			ta1.append(arr[i]+" ");	//append文本域内容追加
		}
	}
	
	public void do_bSort_actionPerformed(ActionEvent e)
	{
		ta2.setText("");
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length-i;j++)
			{
				if(arr[j]>arr[arr.length-i-1])
				{
					arr[j] = arr[j]^arr[arr.length-i-1];
					arr[arr.length-i-1] = arr[j]^arr[arr.length-i-1];
					arr[j] = arr[j]^arr[arr.length-i-1];
				}
			}
		}
		
		for(int i=0;i<arr.length;i++)
		{
			ta2.append(arr[i]+" ");
		}
	}
}
