package j2seExample300.Chapter8StringAndWrapper;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class CharacterASCII extends JFrame {
	private JPanel contentPane,panel;
	private JTextField tf1,tf2,tf4;
	private JFormattedTextField tf3;
	private JButton b1,b2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				CharacterASCII ca = new CharacterASCII();
				ca.setVisible(true);
			}
			
		}
	);
	}
	
	public CharacterASCII()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("字符与编码的转换");
		this.setBounds(400, 400, 450, 120);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "字符与Unicode编码转换", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(60,60,60)));
		panel.setLayout(new GridLayout(0,3,10,20));
		contentPane.add(panel,BorderLayout.CENTER);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setPreferredSize(new Dimension(50,120));
		panel.add(tf1);		
		b1 = new JButton("转换为unicode码");
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
			
		});
		panel.add(b1);
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setEditable(false);
		panel.add(tf2);
		tf3 =  new JFormattedTextField(NumberFormat.getIntegerInstance());
		panel.add(tf3);
		b2 = new JButton("转换为字符");
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_b2_actionPerformed(e);
			}
			
		});
		panel.add(b2);
		tf4 = new JTextField();
		tf4.setEditable(false);
		panel.add(tf4);
	}
	
	protected void do_b1_actionPerformed(ActionEvent e)
	{
		String text = tf1.getText();
		char[] arr = text.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c:arr){
			sb.append((int)c+" ");
		}
		tf2.setText(sb.toString());
	}
	
	protected void do_b2_actionPerformed(ActionEvent e)
	{
		Number value = (Number)tf3.getValue();
		long code = value.longValue();
		tf4.setText((char)code+"");
	}
}
