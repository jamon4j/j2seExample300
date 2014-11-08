package j2seExample300.Chapter6OOP1;

public class Employee implements Cloneable{
	private String name;
	private int age;
	private Address address;	
	public Employee(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	
	@Override
	protected Employee clone() throws CloneNotSupportedException {
		Employee empl = null;
		empl = (Employee)super.clone();
		empl.address = address.clone();
		return empl;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("������"+name);
		sb.append("���䣺"+age+"\n");
		sb.append("��ַ��"+"���ң�"+address.getState()+"ʡ��"+address.getProvince()+"�У�"+address.getCity());
		return sb.toString();
	}
}
