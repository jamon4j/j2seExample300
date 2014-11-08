package j2seExample300.Chapter12IO.MySQLreadPicture;
import j2seExample300.Chapter12IO.MySQLSavePicture.ImageSaveTool;
import j2seExample300.Chapter12IO.MySQLSavePicture.Picture;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
/*
 * 从Mysql里读取图片到界面上
 */
public class ImageReadTool extends JFrame{
	private JPanel contentPane;
	private JLabel label,label2,picLabel;
	private JTextField tf,tf2;
	private JButton b1,b2,b3;
	private File file;
	private Picture picture = null;
	private JPanel panel_north,panel_center,panel_south;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				ImageReadTool irt = new ImageReadTool();
				irt.setVisible(true);
			}
		});
	}

	public ImageReadTool()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("从MySQL读取图片");
		this.setBounds(300,300, 400, 300);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		panel_north = new JPanel();
		contentPane.add(panel_north,BorderLayout.NORTH);
		
		label = new JLabel("图片ID:");
		panel_north.add(label);
		
		tf = new JTextField();
		tf.setColumns(10);
		panel_north.add(tf);
		
		label2 = new JLabel("图片名称:");
		panel_north.add(label2);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		panel_north.add(tf2);
		
		panel_center = new JPanel();
		contentPane.add(panel_center,BorderLayout.CENTER);
		
		picLabel = new JLabel();
		panel_center.add(picLabel);
		
		panel_south = new JPanel();
		contentPane.add(panel_south,BorderLayout.SOUTH);
		
		b1 = new JButton("查询");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
		});
		panel_south.add(b1);
		
		b2 = new JButton("关闭");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
			
		});
		panel_south.add(b2);
	}
	
	public void do_b1_actionPerformed(ActionEvent e)
	{
		String pid = tf.getText();
		String pictureName = tf2.getText();
		if(pid.isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入图片的id值！", "警告信息", JOptionPane.WARNING_MESSAGE);
		}
		if(pictureName.isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入图片的名称！", "警告信息", JOptionPane.WARNING_MESSAGE);
		}
		Picture picture = new Picture();
		picture.setId(Integer.parseInt(pid));
		picture.setPictureName(pictureName);
		ImageIcon icon = DBHelper.readPicture(picture);
		if(icon == null) {
			JOptionPane.showMessageDialog(this, "图片获取失败", "警告信息", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
			picLabel.setIcon(icon);
		}
	}

	public void do_b2_actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
