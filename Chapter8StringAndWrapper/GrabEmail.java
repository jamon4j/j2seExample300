package j2seExample300.Chapter8StringAndWrapper;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * ץȡ��ҳ��Email��ַ
 */
public class GrabEmail {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\1396\\Desktop\\�������email��ַ_les��_�ٶ�����.htm"));
			String line = "";
			while((line=br.readLine())!=null)
			{
				parse(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void parse(String line)
	{
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(line);
		while(m.find())
		{
			System.out.println(m.group());
		}
	}
}
