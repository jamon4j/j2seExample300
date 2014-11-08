package j2seExample300.Charpter3LanguageFoundation.copy;
import java.util.*;
public class VariableExchange {
	
	/*
	 * 不借助第3个变量如何实现两个变量的互换
	 */
	public static void main(String[] args) {
		Long a;
		Long b;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入a的值");
		a = sc.nextLong();
		System.out.println("请输入b的值");
		b = sc.nextLong();
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("交换后:a="+a+";b="+b);
	}

}
