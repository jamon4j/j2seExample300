package j2seExample300.Chapter6OOP1;

/*
 * 单例模式构建类
 */
public class Single_Emperor {
	private String name = "瓜兮兮";
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
		System.out.println("皇帝是"+name);
	}
}
