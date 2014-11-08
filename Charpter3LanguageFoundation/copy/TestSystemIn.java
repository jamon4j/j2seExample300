package j2seExample300.Charpter3LanguageFoundation.copy;

import java.io.*;

public class TestSystemIn {

	public static void main(String[] args) {
		String ID;
		System.out.println("请输入你的身份证号：");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			ID = br.readLine();
			System.out.println(ID);
			System.out.println("身份证位数是："+ID.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
