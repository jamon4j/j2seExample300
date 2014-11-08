package j2seExample300.Chapter5Array;

import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;

/*
 * ͨ����ѡ������ʵ����Ӷ����ѡ��ؼ�
 */
public class CheckBoxArray extends JFrame {
	private JPanel contentPane;
	private JLabel label;
	private JPanel panel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				CheckBoxArray cba = new CheckBoxArray();
				cba.setVisible(true);
			}
		});
	}
	
	public CheckBoxArray()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(500, 250, 300, 200);
		this.setTitle("ͨ����ѡ��ؼ�����ʵ����Ӷ����ѡ��ؼ�");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		label = new JLabel("��İ�������Щ");
		label.setHorizontalAlignment(SwingConstants.LEADING);
		contentPane.add(label,BorderLayout.NORTH);
		contentPane.add(getPanel(),BorderLayout.CENTER);
		
	}
	
	public JPanel getPanel()
	{
		panel = new JPanel();
		final GridLayout gl = new GridLayout(0,4);
		gl.setHgap(5);
		gl.setVgap(5);
		panel.setLayout(gl);
		
		String[] names = {"����","����","��ë��","ƹ����",
							"����","����","�黭","����",
							"����","С˵","�ֻ�","����",
							"���Ӿ�","��Ӱ","����","����"};
		
		Checkbox[] cb = new Checkbox[names.length];
		
		for(int i=0;i<names.length;i++)
		{
			cb[i] = new Checkbox(names[i]);
			panel.add(cb[i]);
		}
		return panel;
	}
}
