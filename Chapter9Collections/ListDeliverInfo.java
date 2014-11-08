package j2seExample300.Chapter9Collections;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * ��List���ϴ���ѧ����Ϣ
 */

public class ListDeliverInfo extends JFrame {
	private JPanel contentPane;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				ListDeliverInfo ldi = new ListDeliverInfo();
				ldi.setVisible(true);
			}
		}
	);
	}
	
	public ListDeliverInfo()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("��List���ϴ���ѧ����Ϣ");
		this.setBounds(400, 400, 350, 250);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(getTable());
		contentPane.add(sp,BorderLayout.CENTER);
	}
	
	private JTable getTable()
	{
		if(table == null)
		{
			table = new JTable();
			table.setRowHeight(20);
			String[] columns = {"����","�Ա�","��������"};
			DefaultTableModel dtm = new DefaultTableModel(columns,0);
			
			table.setModel(dtm);
			List<Student> students = getStudent();
			for(Student stu:students)
			{
				String[] args = new String[3];
				args[0] = stu.getName();
				args[1] = stu.getSex();
				args[2] = stu.getBirthday();
				dtm.addRow(args);
			}
		}
		return table;
		
	}
	
	private List<Student> getStudent()
	{
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("����","��","1991-12-3"));
		list.add(new Student("�Ϲ�","Ů","1992-1-10"));
		list.add(new Student("����","��","2020-5-10"));
		return list;
	}
}
