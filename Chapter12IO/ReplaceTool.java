package j2seExample300.Chapter12IO;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

/*
 * 查找替换文本文件内容
 */
public class ReplaceTool extends JFrame{
	private JLabel l1,l2;
	private JTextField tf1,tf2;
	private JButton b1,b2;
	private JPanel contentPane;
	private String text;
	private File file;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				ReplaceTool rt = new ReplaceTool();
				rt.setVisible(true);
			}
		});
	}
	
	public ReplaceTool()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("查找替换文本文件内容");
		this.setBounds(300, 300, 380, 150);
		contentPane = new JPanel();
		contentPane.setLayout(null);;
		this.setContentPane(contentPane);
		
		l1 = new JLabel("替换前字符串：");
		l1.setBounds(10, 20, 100, 20);
		contentPane.add(l1);
		
		l2 = new JLabel("替换后字符串：");
		l2.setBounds(10, 60, 100, 20);
		contentPane.add(l2);
		
		tf1 = new JTextField();
		tf1.setBounds(110, 20, 120, 20);
		contentPane.add(tf1);
		
		tf2 = new JTextField();
		tf2.setBounds(110, 60, 120, 20);
		contentPane.add(tf2);
		
		b1 = new JButton("选择文件");
		b1.setBounds(240, 20, 100, 20);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
			
		});
		contentPane.add(b1);
		
		b2 = new JButton("开始替换");
		b2.setBounds(240, 60, 100, 20);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
			
		});
		contentPane.add(b2);
	}
	
	public void do_b1_actionPerformed(ActionEvent e)
	{
		JFileChooser fc = new JFileChooser();
		int option = fc.showOpenDialog(this);
		if(option == JFileChooser.APPROVE_OPTION)
		{
			file = fc.getSelectedFile();
			StringBuffer sb = new StringBuffer();
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String temp;
				while((temp = br.readLine()) != null)
				{
					sb.append(temp);
				}
				text = sb.toString();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void do_b2_actionPerformed(ActionEvent e)
	{
		String oldStr = tf1.getText();
		String newStr = tf2.getText();
		String new_text = text.replace(oldStr, newStr);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(new_text);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(this, "字符串替换成功！");
		return;
	}
}
