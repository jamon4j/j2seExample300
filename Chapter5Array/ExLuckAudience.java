package j2seExample300.Chapter5Array;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 *	题目：抽取幸运观众
 *  关键：JScrollPane,TitledBorder/JTextFiled内容添加到JTextArea
 *  	  /正则表达式分割字符串文本/将观众姓名生成数组，再随机抽取下标获取观众
 */

public class ExLuckAudience extends JFrame{
	
	private JPanel contentPanel;
	private JButton button_extract,button_exit;
	private JTextField nameField;
	private JScrollPane scrollPane;
	private JTextArea nameArea,resultArea;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				ExLuckAudience ela_Frame = new ExLuckAudience();
				ela_Frame.setVisible(true);
			}
			
		});
	}
	
	
	public ExLuckAudience()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(50, 50, 500, 400);
		this.setTitle("利用数组随机抽取幸运观众");
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5,5,5,5));
		this.setContentPane(contentPanel);
		
		//界面左侧文本框实现
		JPanel panel_left = new JPanel();
		panel_left.setBorder(new TitledBorder(null, "输入在场观众姓名按回车", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50,50,200)));
		panel_left.setBounds(10, 10, 180, 300);
		contentPanel.add(panel_left);
		panel_left.setLayout(new BorderLayout(0,5));
		
		nameField = new JTextField();
		nameField.addKeyListener(new KeyAdapter()
		{

			public void keyPressed(KeyEvent e) {
				do_textField_keyPerformed(e);
			}
			
		});
		
		panel_left.add(nameField,BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		panel_left.add(scrollPane);
		nameArea = new JTextArea();
		nameArea.setEditable(false);
		scrollPane.setViewportView(nameArea);
		
		//界面右侧文本框实现
		JPanel panel_right = new JPanel();
		panel_right.setBorder(new TitledBorder(null, "选取结果", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50,50,200)));
		panel_right.setBounds(200, 10, 180, 300);
		contentPanel.add(panel_right);
		panel_right.setLayout(new BorderLayout());
		
		JScrollPane sp = new JScrollPane();
		panel_right.add(sp);
		
		resultArea = new JTextArea();
		resultArea.setEnabled(false);
		sp.setViewportView(resultArea);
		
		button_extract = new JButton("抽取");
		button_extract.setBounds(400, 200, 60, 30);
		contentPanel.add(button_extract);
		button_extract.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					do_button_actionPerformed(e);
				}
			});
		button_exit = new JButton("退出");
		button_exit.setBounds(400, 250, 60, 30);
		button_exit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					do_button1_actionPerformed(e);
				}
				
			});
		contentPanel.add(button_exit);
	}
	
	protected void do_textField_keyPerformed(KeyEvent e)
	{
		if(e.getKeyChar() != '\n')
			return;
		
		String name = nameField.getText();
		if(name.isEmpty()) return;
		
		nameArea.append(name + '\n');
		nameField.selectAll();
	}
	
	protected void do_button_actionPerformed(ActionEvent e)
	{
		String nameString = nameArea.getText();
		String[] nameArray = nameString.split("\n{1,}");
		int index = (int)(Math.random()*nameArray.length);
		String formatArg = "本次抽奖观众人员：\n\t%1$s\n恭喜%1$5s成为本次观众抽奖的大奖得主。";
		String info = String.format(formatArg,nameArray[index]);
		resultArea.setText(info);
	}
	
	protected void do_button1_actionPerformed(ActionEvent e)
	{
		dispose();
	}
}
