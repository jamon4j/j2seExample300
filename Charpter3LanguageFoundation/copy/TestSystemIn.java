package j2seExample300.Charpter3LanguageFoundation.copy;

import java.io.*;

public class TestSystemIn {

	public static void main(String[] args) {
		String ID;
		System.out.println("������������֤�ţ�");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			ID = br.readLine();
			System.out.println(ID);
			System.out.println("���֤λ���ǣ�"+ID.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
