package j2seExample300.Chapter8StringAndWrapper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserSort extends JFrame {
	private JPanel contentPane,p_east;
	private JScrollPane panel;
	private JList list;
	private JButton b1,b2,b3;
	private String[] names = new String[]{ "lzw", "anti", "zzk", "lyf",
            "liuxin", "dongdayong", "gulili", "coolBoy", "newgirl", "myBoy",
            "redsky", "pankaihua", "blueBoy"};
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				UserSort us = new UserSort();
				us.setVisible(true);
			}
		}
	);
	}

	public UserSort()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("用户排序");
		this.setBounds(400, 400, 350, 250);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		panel = new JScrollPane();
		panel.setColumnHeaderView(new JLabel("用户列表"));
		list = new JList();
		list.setFixedCellHeight(18);
		list.setSelectionBackground(new Color(133,123,222));
		list.setModel(new DefaultListModel(){
			public int getSize(){
				return names.length;
			}
			
			public Object getElementAt(int index) {
				return names[index];
			}
		}
		);
		panel.setViewportView(list);		 
		contentPane.add(panel,BorderLayout.CENTER);
		
		p_east = new JPanel();
		p_east.setLayout(new GridLayout(8,1));
		contentPane.add(p_east,BorderLayout.EAST);
		b1 = new JButton("升序");
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
			
		});
		b2 = new JButton("降序");
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
			
		});
		b3 = new JButton("关闭");
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		p_east.add(b1);
		p_east.add(b2);
		p_east.add(b3);
	}
	
	protected void do_button_actionPerformed(final ActionEvent e)
	{
		new Thread()
		{
			public void run()
			{
				for(int i=1;i<names.length;i++)
				{
					for(int j=0;j<names.length-i;j++)
					{
						boolean compare = names[j].compareToIgnoreCase(names[j+1])>0;
						if(compare&&e.getSource()==b1 || !compare&&e.getSource()==b2)
						{
							String temp = names[j];
							names[j] = names[j+1];
							names[j+1] = temp;
							list.repaint();
						}
					}
				}
				
			}
		}.start();
		
			
	}
}
