package j2seExample300.Chapter12IO;

import j2seExample300.Chapter9Collections.PhoneBook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * ������չ����ʾָ�����͵��ļ�
 */
public class FilesList extends JFrame {
	private JPanel contentPane;
	private JLabel label;
	private JTextField tf;
	private JButton button;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				FilesList fl = new FilesList();
				fl.setVisible(true);
			}
		});
	}
	
	public FilesList()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("��ʾָ�����͵��ļ�");
		this.setBounds(400, 300, 400, 300);	
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		JPanel panel_north = new JPanel(new FlowLayout());
		label = new JLabel("�����ļ���չ����");
		panel_north.add(label);
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(120,20));
		panel_north.add(tf);
		button = new JButton("ѡ���ļ���");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
			
		});
		panel_north.add(button);
		contentPane.add(panel_north,BorderLayout.NORTH);
		
		JScrollPane sp = new JScrollPane();
		table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[]{"�ļ���","�ļ���С","�޸�ʱ��"});
		sp.setViewportView(table);
		contentPane.add(sp,BorderLayout.CENTER);
	}

	public void do_button_actionPerformed(ActionEvent e)
	{
		final String fileType = tf.getText();
		if(fileType.isEmpty()){
			JOptionPane.showMessageDialog(this, "�������ļ����ͣ�","",JOptionPane.WARNING_MESSAGE);
			return;
		}
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setMultiSelectionEnabled(false);
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File[] listFiles = chooser.getSelectedFile().listFiles(new FileFilter(){
				@Override
				public boolean accept(File pathname) {
					if(pathname.getName().endsWith(fileType)){
						return true;
					}else{
						return false;
					}
				}
			});
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(File file:listFiles){
				String name = file.getName();
				long size = file.length();
				String modifyDate = format.format(new Date(file.lastModified()));
				model.addRow(new Object[]{name,""+size,modifyDate});
			}
			table.setModel(model);
		}		
	}
}
