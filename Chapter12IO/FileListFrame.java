package j2seExample300.Chapter12IO;
import j2seExample300.Chapter12IO.TempDeletionTool;
import j2seExample300.Chapter12IO.MySQLSavePicture.ImageSaveTool;
import j2seExample300.Chapter12IO.MySQLSavePicture.Picture;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;
/*
 * 窗体动态加载磁盘文件
 */
public class FileListFrame extends JFrame{
	private JPanel contentPane;
	private JLabel label;
	private JTextField tf;
	private JButton button;
	private File file;
	private JTable table;
	private DefaultTableModel dtm;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				FileListFrame flf = new FileListFrame();
				flf.setVisible(true);
			}
		});
	}
	
	public FileListFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("窗体动态加载磁盘文件");
		this.setBounds(300,300, 480, 340);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		JPanel panel_north = new JPanel();
		contentPane.add(panel_north,BorderLayout.NORTH);
		
		label = new JLabel("选择文件夹:");
		panel_north.add(label);
		
		tf = new JTextField();
		tf.setColumns(10);
		panel_north.add(tf);
		
		button = new JButton("选择");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
			
		});
		panel_north.add(button);
		
		JPanel panel_center = new JPanel();
		contentPane.add(panel_center,BorderLayout.CENTER);
		
		JScrollPane sp = new JScrollPane();	
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table = new JTable();
		String[] columns = {"文件名","文件大小","修改时间"};
		dtm = new DefaultTableModel(columns,0);
		table.setModel(dtm);
		sp.setViewportView(table);
		panel_center.add(sp);
	}
	
	public void do_b1_actionPerformed(ActionEvent e)
	{
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(fc.DIRECTORIES_ONLY);
		fc.setMultiSelectionEnabled(false);
		int option = fc.showOpenDialog(this);
		if(option == fc.APPROVE_OPTION)
		{
			File dir = fc.getSelectedFile();
			File[] files = dir.listFiles();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			((DefaultTableModel)table.getModel()).getDataVector().clear();
			((DefaultTableModel)table.getModel()).fireTableDataChanged();
			table.updateUI();
			for(int i=0;i<files.length;i++)
			{
				dtm = (DefaultTableModel) table.getModel();
				dtm.addRow(new Object[]{files[i].getName(),files[i].length(),format.format(new Date(files[i].lastModified()))});
			}
			table.setModel(dtm);
		}
	}
}
