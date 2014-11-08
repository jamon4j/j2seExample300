package j2seExample300.Chapter8StringAndWrapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex_test1 {
	
	public static void main(String[] args) {
		String str = "java Java jAvA javA ilovejavA i hateJaVa JAVA asda";
		Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		int i=0;
		while(m.find())
		{
			i++;
			if(i%2==0) m.appendReplacement(sb, "JAVA");
			else m.appendReplacement(sb, "java");
		}
		m.appendTail(sb);
		p(sb);
	}
	
	public static void p(Object o)
	{
		System.out.println(o);
	}
}
