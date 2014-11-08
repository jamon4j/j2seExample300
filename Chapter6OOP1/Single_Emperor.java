package j2seExample300.Chapter6OOP1;

/*
 * ����ģʽ������
 */
public class Single_Emperor {
	private String name = "������";
	private static Single_Emperor emperor = null;
	private Single_Emperor()
	{
		;
	}
	
	public static Single_Emperor getInstance()
	{
		if(emperor == null)
		{
			emperor = new Single_Emperor();
		}
		return emperor;
	}
	
	public void getName()
	{
		System.out.println("�ʵ���"+name);
	}
}
