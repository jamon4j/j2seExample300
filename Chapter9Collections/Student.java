package j2seExample300.Chapter9Collections;

public class Student {
	private String name;
	private String sex;
	private String birthday;
	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, String sex, String birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}