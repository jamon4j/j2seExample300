package j2seExample300.Chapter9Collections;

import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * 动态数组保存学生姓名
 */
public class DynamicArray_deserverStudent extends JFrame{
	private JPanel contentPane,p_east;
	private JScrollPane sp;
	private JList list;
	private JButton b1,b2;
	private JTextField tf;
	private JLabel label;
	private final JPanel panel = new JPanel();
	private ArrayList<Student> arrayList = new ArrayList<Student>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				DynamicArray_deserverStudent da = new DynamicArray_deserverStudent();
				da.setVisible(true);
			}
		}
	);
	}
	
	public DynamicArray_deserverStudent()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("动态数组保存学生姓名");
		this.setBounds(400, 400, 350, 250);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		sp = new JScrollPane();
		list = new JList();
		list.setSelectionBackground(new Color(160,160,160));
		sp.setViewportView(list);
		contentPane.add(sp,BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		label = new JLabel("学生姓名：");
		tf = new JTextField();
		tf.setColumns(10);
		panel_1.add(label);
		panel_1.add(tf);
		sp.setColumnHeaderView(panel_1);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		panel.setPreferredSize(new Dimension(100,100));
		b1 = new JButton("添加学生");
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}

		});
		b2 = new JButton("删除学生");
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}

		});
		panel.add(b1);
		panel.add(b2);
		contentPane.add(panel,BorderLayout.EAST);
	}
	
	protected void do_b1_actionPerformed(ActionEvent e)
	{
		String name = tf.getText();
		if(name.isEmpty()) return;
		Student stu = new Student(name);
		arrayList.add(stu);
		replaceModel();
	}
	
	protected void do_b2_actionPerformed(ActionEvent e)
	{
		String name = tf.getText();
		Iterator it = arrayList.iterator();
		Student stu = null;
		while(it.hasNext()){
			stu = (Student) it.next();
			if(name.equals(stu.getName())) {
				arrayList.remove(stu);
				replaceModel();
				break;
			}
		}				
	}
	
	private void replaceModel() {
		list.setModel(new AbstractListModel() {

			@Override
			public int getSize() {
				return arrayList.size();
			}

			@Override
			public Object getElementAt(int index) {
				return arrayList.get(index).getName();
			}
			
		});
	}
}
