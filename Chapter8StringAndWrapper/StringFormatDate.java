package j2seExample300.Chapter8StringAndWrapper;

import java.util.Date;
import java.util.Locale;

public class StringFormatDate {

	public static void main(String[] args) {
		Date today = new Date();
		String a = String.format(Locale.US,"%tb", today);
		System.out.println("格式化Locale.US,%tb后字符串为月份的英文缩写："+a);
		String b = String.format(Locale.US,"%tB", today);
		System.out.println("格式化Locale.US,%tB后字符串为月份的英文全写："+b);
		String c = String.format("%ta", today);
		System.out.println("格式化%ta后字符串为星期："+c);
		String d = String.format("%tA", today);
		System.out.println("格式化%tA后字符串为星期："+d);
		String e = String.format("%tm", today);
		System.out.println("格式化%tm后字符串为两位的月份值："+e);
		String f = String.format("%tY", today);
		System.out.println("格式化%tY后字符串为4位的年份："+f);
		String g = String.format("%ty", today);
		System.out.println("格式化%ty后字符串为2位的年份："+g);
	}

}
