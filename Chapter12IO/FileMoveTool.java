package j2seExample300.Chapter12IO;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/*
 * 快速批量移动文件
 */
public class FileMoveTool extends JFrame{
	private JPanel contentPane;
	private JLabel l1,l2;
	private JTextField tf1,tf2;
	private JButton b1,b2,b3,b4;
	private JTable table;
	private DefaultTableModel model;
	private File[] files;
	private File file;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				FileMoveTool fmt = new FileMoveTool();
				fmt.setVisible(true);
			}
		});
	}

	public FileMoveTool()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("快速批量移动文件");
		this.setBounds(300,300, 450, 280);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		l1 = new JLabel("选择源文件:");
		l1.setBounds(30, 20, 80, 20);
		contentPane.add(l1);
		
		tf1 = new JTextField();
		tf1.setBounds(120, 20, 150, 20);
		contentPane.add(tf1);
		
		b1 = new JButton("选择文件");
		b1.setBounds(280, 20, 120, 20);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
			
		});
		contentPane.add(b1);
		
		l2 = new JLabel("选择目标文件夹:");
		l2.setBounds(30, 50, 100, 20);
		contentPane.add(l2);
		
		tf2 = new JTextField();
		tf2.setBounds(140, 50, 130, 20);
		contentPane.add(tf2);
		
		b2 = new JButton("选择文件夹");
		b2.setBounds(280, 50, 120, 20);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
		});
		contentPane.add(b2);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(30, 80, 400, 100);
		table = new JTable(20,2);
		String[] columns = {"移动文件名称","目标文件夹"};
		model = new DefaultTableModel(columns,0);
		table.setModel(model);
		sp.setViewportView(table);
		contentPane.add(sp);
		
		b3 = new JButton("移动");
		b3.setBounds(150, 200, 60, 20);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b3_actionPerformed(e);
			}
		});
		contentPane.add(b3);
		
		b4 = new JButton("关闭");
		b4.setBounds(230, 200, 60, 20);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b4_actionPerformed(e);
			}
		});
		contentPane.add(b4);
	}
	
	public void do_b1_actionPerformed(ActionEvent e)
	{
		JFileChooser fc = new JFileChooser();
		fc.setMultiSelectionEnabled(true);
		int option = fc.showOpenDialog(this);
		if(option == fc.APPROVE_OPTION)
		{
			files = fc.getSelectedFiles();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<files.length;i++)
			{
				sb.append(files[i].getName()+" ");
			}
			tf1.setText(sb.toString());
		}
	}
	
	public void do_b2_actionPerformed(ActionEvent e)
	{
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(fc.DIRECTORIES_ONLY); 
		int option = fc.showOpenDialog(this);
		if(option == fc.APPROVE_OPTION)
		{
			file = fc.getSelectedFile();
			tf2.setText(file.getName());
		}
	}
	
	public void do_b3_actionPerformed(ActionEvent e)
	{
		if(files == null)
		{
			JOptionPane.showMessageDialog(this, "请选择要移动的文件","警告信息",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(file == null)
		{
			JOptionPane.showMessageDialog(this, "请选择目标文件夹","警告信息",JOptionPane.WARNING_MESSAGE);
			return;
		}
		model = (DefaultTableModel) table.getModel();
		for(File selectFile:files)
		{
			String fileName = file.getAbsolutePath()+File.separator+selectFile.getName();
			selectFile.renameTo(new File(fileName));
			model.addRow(new String[]{selectFile.getName(),file.getAbsolutePath()});
		}
		table.setModel(model);
	}
	
	public void do_b4_actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
