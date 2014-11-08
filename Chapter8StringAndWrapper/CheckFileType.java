package j2seExample300.Chapter8StringAndWrapper;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CheckFileType extends JFrame {
	private JPanel contentPane;
	private JLabel label;
	private JTextArea ta;
	private JTextField tf;
	private JButton button;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				CheckFileType cft = new CheckFileType();
				cft.setVisible(true);
			}
		}
	);
	}
	
	public CheckFileType()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("判断文件类型");
		this.setBounds(400, 400, 400, 150);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		this.setContentPane(contentPane);
		
		label = new JLabel("选择文件：");
		label.setBounds(5, 5, 80, 30);
		contentPane.add(label);
		
		tf = new JTextField();
		tf.setBounds(70, 5, 180, 30);
		contentPane.add(tf);
		
		button = new JButton("浏览……");
		button.setBounds(280, 5, 80, 30);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
			
		});
		contentPane.add(button);
		
		ta = new JTextArea();
		ta.setBounds(70, 40, 180, 60);
		ta.setOpaque(false);
		ta.setEditable(false);
		ta.setLineWrap(true);
		contentPane.add(ta);
	}
	
	public void do_button_actionPerformed(ActionEvent e)
	{
		Scanner scan = new Scanner(getClass().getResourceAsStream("extName.inf"));
		JFileChooser chooser = new JFileChooser();
		boolean searched = false;
		int option = chooser.showOpenDialog(this);
		if(option == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			tf.setText(file.getName());
			String name = file.getName();
			while(scan.hasNext())
			{
				String line = scan.nextLine();
				String[] extInfo = line.split("\t");
				if(name.endsWith(extInfo[0]))
				{
					ta.setText(extInfo[1]);
					searched = true;
				}
			}
			scan.close();
		}
		
		if(!searched) ta.setText("你选择的文件类型没有相应的记录，你可以在extName.inf文件中添加该类型的描述");
	}
}
