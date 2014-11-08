package j2seExample300.Chapter9Collections;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * Mapʵ�ֵ绰��
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
		this.setTitle("�ҵĵ绰��");
		this.setBounds(400, 300, 300, 200);	
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		JScrollPane sp = new JScrollPane();
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[]{"����","�ֻ�"});
		table.setModel(model);
		sp.setViewportView(table);
		contentPane.add(sp,BorderLayout.CENTER);
	}
	
	public void do_this_windowActivated(WindowEvent e)
	{
		phone = new HashMap<String,String>();
		phone.put("��һ", "33265****");// �򼯺�������Ԫ��
		phone.put("����", "66150****");// �򼯺�������Ԫ��
		phone.put("����", "20427****");// �򼯺�������Ԫ��
		phone.put("����", "98823****");// �򼯺�������Ԫ��
		phone.put("����", "91364****");// �򼯺�������Ԫ��
		phone.put("����", "89259****");// �򼯺�������Ԫ��
		phone.put("����", "12441****");// �򼯺�������Ԫ��
		phone.put("����", "79920****");// �򼯺�������Ԫ��
		phone.put("����", "22721****");// �򼯺�������Ԫ��
		phone.put("��ʮ", "89383****");// �򼯺�������Ԫ��
		Set<String> set = phone.keySet();
		for(Iterator it = set.iterator();it.hasNext();)
		{
			String name = (String)it.next();
			model.addRow(new Object[]{name,phone.get(name)});
		}
	}
}
