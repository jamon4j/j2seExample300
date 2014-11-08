package j2seExample300.Charpter3LanguageFoundation.copy;

import java.util.*;

public class Encryption {
	/*
	 * 加密或解密的简单实现
	 */
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个英文字符串或解密字符串");
		String password = sc.nextLine();
		char[] array = password.toCharArray();
		for(int i=0;i<array.length;i++)
		{
			array[i] = (char)(array[i]^20000);
		}
		System.out.println("加密或解密结果为：");
		System.out.println(new String(array));
	}
}
