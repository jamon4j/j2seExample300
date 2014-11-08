package j2seExample300.Chapter5Array;

import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;

/*
 * 通过复选框数组实现添加多个复选框控件
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
		this.setTitle("通过复选框控件数组实现添加多个复选框控件");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		label = new JLabel("你的爱好有哪些");
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
		
		String[] names = {"足球","篮球","羽毛球","乒乓球",
							"唱歌","跳舞","书画","下棋",
							"动漫","小说","轮滑","武术",
							"电视剧","电影","吉他","口琴"};
		
		Checkbox[] cb = new Checkbox[names.length];
		
		for(int i=0;i<names.length;i++)
		{
			cb[i] = new Checkbox(names[i]);
			panel.add(cb[i]);
		}
		return panel;
	}
}
