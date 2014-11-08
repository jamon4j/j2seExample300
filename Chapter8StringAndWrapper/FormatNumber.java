package j2seExample300.Chapter8StringAndWrapper;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 * 将数字格式化为货币字符串
 */
public class FormatNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个数字");
		double number = s.nextDouble();
		System.out.println("该数字用Locale类的常量作为格式化对象的构造参数，将获得不同的货币格式");
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
