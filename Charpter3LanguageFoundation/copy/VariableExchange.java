package j2seExample300.Charpter3LanguageFoundation.copy;
import java.util.*;
public class VariableExchange {
	
	/*
	 * ��������3���������ʵ�����������Ļ���
	 */
	public static void main(String[] args) {
		Long a;
		Long b;
		Scanner sc = new Scanner(System.in);
		System.out.println("������a��ֵ");
		a = sc.nextLong();
		System.out.println("������b��ֵ");
		b = sc.nextLong();
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("������:a="+a+";b="+b);
	}

}
