package j2seExample300.Chapter5Array;

import java.awt.*;


import javax.swing.*;

/*
 * 计算器界面实现
 */
public class ButtonArrayExample extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				ButtonArrayExample bae = new ButtonArrayExample();
				bae.setVisible(true);
			}
			
		});
	}
	
	public ButtonArrayExample()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("按钮数组实现计算器界面");
		this.setBounds(500, 250, 300, 200);
		contentPane = new JPanel();	
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
	
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);//设置水平对齐右对齐
		textField.setPreferredSize(new Dimension(12,25));
		contentPane.add(textField,BorderLayout.NORTH);
		
		/*使用网格布局，以及字符串数组和JButton数组*/
		final GridLayout gl = new GridLayout(0,4);
		gl.setHgap(5);
		gl.setVgap(5);
		JPanel panel = new JPanel();
		panel.setLayout(gl);
		contentPane.add(panel,BorderLayout.CENTER);
		String[][] names = {{"1","2","3","+"},{"4","5","6","-"},
				{"7","8","9","*"},{".","0","=","%"}};
		JButton[][] buttons = new JButton[4][4];
		for(int row=0;row<names.length;row++)
			for(int col=0;col<names.length;col++)
			{
				buttons[row][col] = new JButton(names[row][col]);
				panel.add(buttons[row][col]);
			}
	}
}
