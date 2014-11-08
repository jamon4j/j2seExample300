package j2seExample300.Chapter12IO;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
/*
 * 删除文件夹中的.tmp文件
 */
public class TempDeletionTool extends JFrame{
	private JPanel contentPane;
	private JLabel label;
	private JTextField tf;
	private JButton b1,b2;
	private JTable table;
	private DefaultTableModel model;
	private File[] files;
	private File directory;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				TempDeletionTool tdt = new TempDeletionTool();
				tdt.setVisible(true);
			}
		});
	}
	
	public TempDeletionTool()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("删除文件夹中的.tmp文件");
		this.setBounds(300,300, 450, 350);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		label = new JLabel("选择文件夹:");
		label.setBounds(10, 20, 80, 20);
		contentPane.add(label);
		
		tf = new JTextField();
		tf.setBounds(100, 20, 150, 20);
		contentPane.add(tf);
		
		b1 = new JButton("选择文件夹");
		b1.setBounds(260, 20, 100, 20);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
			
		});
		contentPane.add(b1);
		
		b2 = new JButton("清理");
		b2.setBounds(370, 20, 60, 20);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
			
		});
		contentPane.add(b2);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(20, 60, 400, 200);
		table = new JTable();
		String[] column = {"文件名称","文件大小","修改时间","文件状态"};
		model = new DefaultTableModel(column,0);
		table.setModel(model);
		sp.setViewportView(table);
		contentPane.add(sp);
	}
	
	public void do_b1_actionPerformed(ActionEvent e)
	{
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(fc.DIRECTORIES_ONLY);
		int option = fc.showOpenDialog(this);
		if(option == fc.APPROVE_OPTION)
		{
			directory = fc.getSelectedFile();
			tf.setText(directory.getAbsolutePath());
			files = directory.listFiles(new FileFilter(){
				@Override
				public boolean accept(File pathname) {
					String filename = pathname.getName();
					if(filename.endsWith("tmp")||filename.endsWith("TMP"))
					{
						return true;
					}else{
						return false;
					}		
				}
			});
		}
		model = (DefaultTableModel) table.getModel();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for(File tempFile:files)
		{
			model.addRow(new Object[]{tempFile.getName(),tempFile.length(),format.format(new Date(tempFile.lastModified())),"未处理"});
		}
		table.setModel(model);
	}
	
	public void do_b2_actionPerformed(ActionEvent e)
	{
		if(files == null)
		{
			JOptionPane.showMessageDialog(this, "选择的文件夹中未包含tmp文件！", "警告信息", JOptionPane.WARNING_MESSAGE);
		}
		model = (DefaultTableModel) table.getModel();
		for(int i=0;i<files.length;i++)
		{
			if(files[i].delete())
			{
				model.setValueAt("已处理",i,3);
			}
		}
	}
}
