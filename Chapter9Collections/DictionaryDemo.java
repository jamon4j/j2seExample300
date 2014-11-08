package j2seExample300.Chapter9Collections;

import java.awt.EventQueue;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
/*
 * Mapʵ�ֵ��Ӵʵ�
 */
public class DictionaryDemo extends JFrame {
	private JPanel contentPane;
	private JLabel label;
	private JTextField tf;
	private JTextArea ta;
	private JButton button;
	private Map<String,String> words;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				DictionaryDemo dd = new DictionaryDemo();
				dd.setVisible(true);
			}
		});
	}
	
	public DictionaryDemo()
	{
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowActivated(WindowEvent e) {
				super.windowActivated(e);
				do_this_windowActivated(e);
			}
			
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("�ҵĵ��Ӵʵ�");
		this.setBounds(400, 300, 300, 200);	
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		label = new JLabel("������Ҫ��ѯ�ĵ���:");
		label.setBounds(20, 20, 120, 20);
		contentPane.add(label);
		
		tf = new JTextField();
		tf.setBounds(150, 20, 120, 20);
		contentPane.add(tf);
		
		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane();
		sp.setBounds(20,50,250,60);
		sp.setViewportView(ta);
		contentPane.add(sp);
		
		button = new JButton("��ѯ");
		button.setBounds(100,120,80,30);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});
		contentPane.add(button);
	}
	
	public void do_button_actionPerformed(ActionEvent e){
		String english = tf.getText();
		if(english.isEmpty()){
			JOptionPane.showMessageDialog(this, "������Ҫ��ѯ�ĵ��ʣ�",null,JOptionPane.WARNING_MESSAGE);
			return;
		}
		String chinese = words.get(english);
		if(chinese == null){
			JOptionPane.showMessageDialog(this, "Ҫ��ѯ�ĵ��ʲ����ڣ�",null,JOptionPane.WARNING_MESSAGE);
			return;
		}
		ta.setText(chinese);
	}
	
	public void do_this_windowActivated(WindowEvent e){
		words = new HashMap<String,String>();
		words.put("apple", "ƻ��");
		words.put("banana", "�㽶");
		words.put("guitar", "����");
	}
}
