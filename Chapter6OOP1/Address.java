package j2seExample300.Chapter6OOP1;

public class Address implements Cloneable{
	private String state;
	private String province;
	private String city;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(String state, String province, String city) {
		super();
		this.state = state;
		this.province = province;
		this.city = city;
	}
	
	public String toString() {
		StringBuilder sb = new  StringBuilder();
		sb.append("国家："+state);
		sb.append("省："+province);
		sb.append("市："+city);
		return sb.toString();
	}
	
	protected Address clone() throws CloneNotSupportedException {
		Address addr = null;
		addr = (Address)super.clone();
		return addr;
	}
	
}
