package j2seExample300.Chapter5Array;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * 题目:用数组设置JTable列表的列名与列宽
 * 关键：设置表格的数据模型和访问列模型，用DefaultTableModel类创建数据模型对象
 * 用TableColumnModel类访问列
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
		this.setTitle("用数组设置JTable列表的列名与列宽");
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
			//定义列名数组
			String[] columns = {"ID","姓名","性吧","出生日期","邮箱","居住地","备注"};
			//定义列宽数组
			int[] columnsWidth = {10,30,10,40,70,60,70};
			//创建表格数据模型
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
