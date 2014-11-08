package j2seExample300.Chapter8StringAndWrapper;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 抓取网页的Email地址
 */
public class GrabEmail {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\1396\\Desktop\\留下你的email地址_les吧_百度贴吧.htm"));
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
