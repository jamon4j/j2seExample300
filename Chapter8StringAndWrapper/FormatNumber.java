package j2seExample300.Chapter8StringAndWrapper;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 * �����ָ�ʽ��Ϊ�����ַ���
 */
public class FormatNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("������һ������");
		double number = s.nextDouble();
		System.out.println("��������Locale��ĳ�����Ϊ��ʽ������Ĺ������������ò�ͬ�Ļ��Ҹ�ʽ");
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
		System.out.println("Locale.CHINA:"+nf.format(number));
		nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Locale.US:"+nf.format(number));
		nf = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
		System.out.println("Locale.ENGLISH:"+nf.format(number));
		nf = NumberFormat.getCurrencyInstance(Locale.ITALIAN);
		System.out.println("Locale.ITALY:"+nf.format(number));
	}
}
