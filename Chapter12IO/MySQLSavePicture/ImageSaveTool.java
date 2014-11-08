package j2seExample300.Chapter12IO.MySQLSavePicture;

import j2seExample300.Chapter12IO.TempDeletionTool;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

/*
 * 将图片文件保存到Mysql数据库
 */
public class ImageSaveTool extends JFrame{
	private JPanel contentPane;
	private JLabel label;
	private JTextField tf;
	private JButton b1,b2,b3;
	private File file;
	private Picture picture = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				ImageSaveTool ist = new ImageSaveTool();
				ist.setVisible(true);
			}
		});
	}
	
	public ImageSaveTool()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("将图片文件保存到数据库");
		this.setBounds(300,300, 400, 150);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		label = new JLabel("图片文件名称:");
		label.setBounds(10, 20, 120, 20);
		contentPane.add(label);
		
		tf = new JTextField();
		tf.setBounds(100, 20, 150, 20);
		contentPane.add(tf);
		
		b1 = new JButton("选择图片");
		b1.setBounds(260, 20, 100, 20);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
			
		});
		contentPane.add(b1);
		
		b2 = new JButton("保存");
		b2.setBounds(90, 70, 60, 20);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
			
		});
		contentPane.add(b2);
		
		b3 = new JButton("关闭");
		b3.setBounds(180, 70, 60, 20);
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
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setMultiSelectionEnabled(false);
		int option = fc.showOpenDialog(this);
		if(option == fc.APPROVE_OPTION)
		{
			picture = new Picture();
			picture.setPictureFile(fc.getSelectedFile());
		}
	}
	
	public void do_b2_actionPerformed(ActionEvent e)
	{
		String pictureName = tf.getText();
		if(pictureName.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "请输入图片文件名称！", "警告信息", JOptionPane.WARNING_MESSAGE);
		}
		if(picture == null)
		{
			JOptionPane.showMessageDialog(this, "请输入要保存的图片文件！", "警告信息", JOptionPane.WARNING_MESSAGE);
		}
		picture.setPictureName(pictureName);
		if(DBHelper.savePicture(picture))
		{
			JOptionPane.showMessageDialog(this, "图片文件保存成功！", "警告信息", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "图片文件保存失败！", "警告信息", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void do_b3_actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
