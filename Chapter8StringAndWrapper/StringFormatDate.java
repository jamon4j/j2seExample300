package j2seExample300.Chapter8StringAndWrapper;

import java.util.Date;
import java.util.Locale;

public class StringFormatDate {

	public static void main(String[] args) {
		Date today = new Date();
		String a = String.format(Locale.US,"%tb", today);
		System.out.println("��ʽ��Locale.US,%tb���ַ���Ϊ�·ݵ�Ӣ����д��"+a);
		String b = String.format(Locale.US,"%tB", today);
		System.out.println("��ʽ��Locale.US,%tB���ַ���Ϊ�·ݵ�Ӣ��ȫд��"+b);
		String c = String.format("%ta", today);
		System.out.println("��ʽ��%ta���ַ���Ϊ���ڣ�"+c);
		String d = String.format("%tA", today);
		System.out.println("��ʽ��%tA���ַ���Ϊ���ڣ�"+d);
		String e = String.format("%tm", today);
		System.out.println("��ʽ��%tm���ַ���Ϊ��λ���·�ֵ��"+e);
		String f = String.format("%tY", today);
		System.out.println("��ʽ��%tY���ַ���Ϊ4λ����ݣ�"+f);
		String g = String.format("%ty", today);
		System.out.println("��ʽ��%ty���ַ���Ϊ2λ����ݣ�"+g);
	}

}
