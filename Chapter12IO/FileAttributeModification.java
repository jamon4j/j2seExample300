package j2seExample300.Chapter12IO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/*
 * ����Windowsϵͳ���ļ�����
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
		this.setTitle("����Windowsϵͳ���ļ�����");
		this.setBounds(300,300, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		label = new JLabel("�ļ�·��:");
		label.setBounds(30, 20, 60, 20);
		contentPane.add(label);
		
		tf = new JTextField();
		tf.setBounds(100, 20, 150, 20);
		contentPane.add(tf);
		
		b1 = new JButton("ѡ���ļ�");
		b1.setBounds(260, 20, 100, 20);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
			
		});
		contentPane.add(b1);
		
		cb1 = new JCheckBox("ֻ��");
		cb1.setBounds(80, 60, 60, 20);
		contentPane.add(cb1);

		cb2 = new JCheckBox("�浵");
		cb2.setBounds(140, 60, 60, 20);
		contentPane.add(cb2);
		
		cb3 = new JCheckBox("ϵͳ");
		cb3.setBounds(200, 60, 60, 20);
		contentPane.add(cb3);
		
		cb4 = new JCheckBox("����");
		cb4.setBounds(260, 60, 60, 20);
		contentPane.add(cb4);
		
		b2 = new JButton("����");
		b2.setBounds(120, 100, 60, 20);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
			
		});
		contentPane.add(b2);

		b3 = new JButton("�ر�");
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
		JOptionPane.showMessageDialog(this, "�ļ��������óɹ�");
	}
	
	public void do_b3_actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
