package j2seExample300.Charpter3LanguageFoundation.copy;

import java.util.*;

public class Encryption {
	/*
	 * ���ܻ���ܵļ�ʵ��
	 */
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ��Ӣ���ַ���������ַ���");
		String password = sc.nextLine();
		char[] array = password.toCharArray();
		for(int i=0;i<array.length;i++)
		{
			array[i] = (char)(array[i]^20000);
		}
		System.out.println("���ܻ���ܽ��Ϊ��");
		System.out.println(new String(array));
	}
}
