package j2seExample300.Chapter9Collections.Map_twoLinkage;

import j2seExample300.Chapter9Collections.ListDeliverInfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

import javax.swing.*;

public class MainFrame extends JFrame {
	private JPanel contentPane;
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JTextField tf1,tf2,tf3;
	private JComboBox cb1,cb2,cb3;
	private JButton b1,b2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				MainFrame mf = new MainFrame();
				mf.setVisible(true);
			}
		}
	);
	}

	public MainFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("输入指定省/直辖市查询对应的市县");
		this.setBounds(400, 250, 450, 350);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		l1 = new JLabel("姓名:");
		l1.setBounds(20, 20, 50, 20);
		contentPane.add(l1);
		tf1 = new JTextField();
		tf1.setBounds(60, 20, 120, 20);
		contentPane.add(tf1);
		
		l2 = new JLabel("性别:");
		l2.setBounds(20, 50, 50, 20);
		contentPane.add(l2);
		cb1 = new JComboBox();
		cb1.setBounds(60, 50, 50, 20);
		cb1.setModel(new DefaultComboBoxModel(new String[]{"男","女"}));
		contentPane.add(cb1);
		
		l3 = new JLabel("居住地");
		l3.setBounds(20, 80, 50, 20);
		contentPane.add(l3);
		cb2 = new JComboBox();
		cb2.setBounds(20, 100, 100, 20);
		cb2.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				itemChange();
			}
		});
		cb2.setModel(new DefaultComboBoxModel(getProvince()));
		contentPane.add(cb2);
		l4 = new JLabel("省/直辖市");
		l4.setBounds(130, 100, 90, 20);
		contentPane.add(l4);
		cb3 = new JComboBox();
		cb3.setBounds(200, 100, 100, 20);
		cb3.setModel(new DefaultComboBoxModel(new String[]{"北京"}));
		contentPane.add(cb3);
		l5 = new JLabel("市/县");
		l5.setBounds(310, 100, 90, 20);
		contentPane.add(l5);
		
		l6 = new JLabel("详细地址：");
		l6.setBounds(20, 150, 80, 30);
		contentPane.add(l6);
		tf2 = new JTextField();
		tf2.setBounds(90, 150, 300, 30);
		contentPane.add(tf2);
		
		l7 = new JLabel("E-mail：");
		l7.setBounds(30, 200, 80, 30);
		contentPane.add(l7);
		tf3 = new JTextField();
		tf3.setBounds(90, 200, 300, 30);
		contentPane.add(tf3);
		
		b1 = new JButton("保存");
		b1.setBounds(110, 250, 60, 30);
		contentPane.add(b1);
		b2 = new JButton("重置");
		b2.setBounds(220, 250, 60, 30);
		contentPane.add(b2);
	}
	
	public Object[] getProvince()
	{
		Map<String,String[]> map = CityMap.model;
		Set<String> set = map.keySet();
		Object[] province = set.toArray();
		return province;
	}
	
	public String[] getCity(String selectProvince)
	{
		Map<String,String[]> map = CityMap.model;
		String[] arrCity = map.get(selectProvince);
		return arrCity;
	}
	
	private void itemChange(){
		String selectProvince = (String)cb2.getSelectedItem();
		cb3.removeAllItems();
		String[] arrCity = getCity(selectProvince);
		cb3.setModel(new DefaultComboBoxModel(arrCity));
	}
}
