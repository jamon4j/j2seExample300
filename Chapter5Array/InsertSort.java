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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/*
 * 直接插入排序算法对数组排序
 */
public class InsertSort extends JFrame {
	private JPanel contentPane;
	private JTextArea ta1,ta2;
	private JButton b1,b2;
	private GridBagLayout bal;
	private int[] arr;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				InsertSort is = new InsertSort();
				is.setVisible(true);
			}
			
		});
	}

	public void initFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("使用快速排序法对数组排序");
		this.setBounds(400, 250, 380, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		this.add(contentPane);
	}
	
	public InsertSort()
	{
		initFrame();
		ta1 = new JTextArea();
		ta1.setBounds(10,10,100,280);
		contentPane.add(ta1);
		
		b1 = new JButton("生成随机数组");
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
		});

		b1.setBounds(130,75,120,20);
		contentPane.add(b1);
		
		ta2 = new JTextArea();
		ta2.setBounds(270,10,90,300);
		contentPane.add(ta2);
		
		b2 = new JButton("排序");
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
		});
		b2.setBounds(130,160,120,20);
		contentPane.add(b2);
	}
	
	protected void do_b1_actionPerformed(ActionEvent e)
	{
		ta1.setText("");
		Random r = new Random();
		arr = new int[10];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = r.nextInt(50);
			ta1.append(arr[i]+"\n");
		}
	}
	
	protected void do_b2_actionPerformed(ActionEvent e)
	{
		ta2.setText("");
		insertSort(arr);
	}
	
	/*
	 * 直接插入排序算法对数组排序
	 */
	protected void insertSort(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			int j;
			int temp = arr[i]; 	
			for(j=i-1;j>=0 && temp<arr[j];j--)
			{
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
		
		for(int i=0;i<arr.length;i++)
		{
			ta2.append(arr[i]+"\n");
		}
	}
}
