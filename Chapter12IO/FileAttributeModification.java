package j2seExample300.Chapter12IO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/*
 * 设置Windows系统的文件属性
 */

public class FileAttributeModification extends JFrame{
	private JPanel contentPane;
	private JLabel label;
	private JTextField tf;
	private JButton b1,b2,b3;
	private JCheckBox cb1,cb2,cb3,cb4;
	private File file;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				FileAttributeModification fam = new FileAttributeModification();
				fam.setVisible(true);
			}
		});
	}

	public FileAttributeModification()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("设置Windows系统的文件属性");
		this.setBounds(300,300, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		label = new JLabel("文件路径:");
		label.setBounds(30, 20, 60, 20);
		contentPane.add(label);
		
		tf = new JTextField();
		tf.setBounds(100, 20, 150, 20);
		contentPane.add(tf);
		
		b1 = new JButton("选择文件");
		b1.setBounds(260, 20, 100, 20);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
			
		});
		contentPane.add(b1);
		
		cb1 = new JCheckBox("只读");
		cb1.setBounds(80, 60, 60, 20);
		contentPane.add(cb1);

		cb2 = new JCheckBox("存档");
		cb2.setBounds(140, 60, 60, 20);
		contentPane.add(cb2);
		
		cb3 = new JCheckBox("系统");
		cb3.setBounds(200, 60, 60, 20);
		contentPane.add(cb3);
		
		cb4 = new JCheckBox("隐藏");
		cb4.setBounds(260, 60, 60, 20);
		contentPane.add(cb4);
		
		b2 = new JButton("设置");
		b2.setBounds(120, 100, 60, 20);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
			
		});
		contentPane.add(b2);

		b3 = new JButton("关闭");
		b3.setBounds(190, 100, 60, 20);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b3_actionPerformed(e);
			}
			
		});
		contentPane.add(b3);
	}
	
	public void do_b1_actionPerformed(ActionEvent e)
	{
		JFileChooser fc = new JFileChooser();
		int option = fc.showOpenDialog(this);
		if(option == fc.APPROVE_OPTION)
		{
			file = fc.getSelectedFile();
			tf.setText(file.getName());
		}
	}
	
	public void do_b2_actionPerformed(ActionEvent e)
	{
		StringBuilder command = new StringBuilder();
		command.append("attrib");
		if(cb1.isSelected())
		{
			command.append(" +R ");
		}
		if(cb2.isSelected())
		{
			command.append(" +A ");
		}
		if(cb3.isSelected())
		{
			command.append(" +S ");
		}
		if(cb4.isSelected())
		{
			command.append(" +H ");
		}
		command.append(file.getAbsolutePath());
		try {
			Runtime.getRuntime().exec(command.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(this, "文件属性设置成功");
	}
	
	public void do_b3_actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
