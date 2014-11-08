package j2seExample300.Chapter5Array;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * ��Ŀ:����������JTable�б���������п�
 * �ؼ������ñ�������ģ�ͺͷ�����ģ�ͣ���DefaultTableModel�ഴ������ģ�Ͷ���
 * ��TableColumnModel�������
 */
public class ArrayCreateJTable extends JFrame{
	private JPanel contentPanel;
	private JScrollPane scrollPane;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				ArrayCreateJTable acj = new ArrayCreateJTable();
				acj.setVisible(true);
			}
			
		});
	}
	
	public ArrayCreateJTable()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("����������JTable�б���������п�");
		this.setBounds(50, 50, 500, 300);
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(getScrollPane(),BorderLayout.NORTH);
		this.setContentPane(contentPanel);
	}
	
	public JScrollPane getScrollPane()
	{
		if(scrollPane == null)
		{
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	
	public JTable getTable()
	{
		if(table == null)
		{
			table = new JTable();
			//������������
			String[] columns = {"ID","����","�԰�","��������","����","��ס��","��ע"};
			//�����п�����
			int[] columnsWidth = {10,30,10,40,70,60,70};
			//�����������ģ��
			DefaultTableModel model = new DefaultTableModel(columns,15);
			table.setModel(model);
			TableColumnModel columnModel = table.getColumnModel();
			int count = columnModel.getColumnCount();
			for(int i=0;i<count;i++)
			{
				TableColumn column = columnModel.getColumn(i);
				column.setPreferredWidth(columnsWidth[i]);
			}
		}
		return table;
	}
	
}
