package j2seExample300.Chapter9Collections;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * Map实现电话簿
 */
public class PhoneBook extends JFrame {
	private JPanel contentPane;
	private Map<String,String> phone;
	private DefaultTableModel model;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				PhoneBook pb = new PhoneBook();
				pb.setVisible(true);
			}
		});
	}
	
	public PhoneBook()
	{
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowActivated(WindowEvent e) {
				super.windowActivated(e);
				do_this_windowActivated(e);
			}			
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("我的电话簿");
		this.setBounds(400, 300, 300, 200);	
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		JScrollPane sp = new JScrollPane();
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[]{"姓名","手机"});
		table.setModel(model);
		sp.setViewportView(table);
		contentPane.add(sp,BorderLayout.CENTER);
	}
	
	public void do_this_windowActivated(WindowEvent e)
	{
		phone = new HashMap<String,String>();
		phone.put("阿一", "33265****");// 向集合中增加元素
		phone.put("阿二", "66150****");// 向集合中增加元素
		phone.put("阿三", "20427****");// 向集合中增加元素
		phone.put("阿四", "98823****");// 向集合中增加元素
		phone.put("阿五", "91364****");// 向集合中增加元素
		phone.put("阿六", "89259****");// 向集合中增加元素
		phone.put("阿七", "12441****");// 向集合中增加元素
		phone.put("阿八", "79920****");// 向集合中增加元素
		phone.put("阿九", "22721****");// 向集合中增加元素
		phone.put("阿十", "89383****");// 向集合中增加元素
		Set<String> set = phone.keySet();
		for(Iterator it = set.iterator();it.hasNext();)
		{
			String name = (String)it.next();
			model.addRow(new Object[]{name,phone.get(name)});
		}
	}
}
