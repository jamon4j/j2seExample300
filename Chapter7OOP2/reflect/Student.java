package j2seExample300.Chapter7OOP2.reflect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student implements ActionListener{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void study()
	{
		System.out.println("the student is studying");
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
