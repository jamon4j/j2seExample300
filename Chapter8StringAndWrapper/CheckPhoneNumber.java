package j2seExample300.Chapter8StringAndWrapper;

import java.util.Scanner;
import java.util.regex.*;

public class CheckPhoneNumber {

	public static void main(String[] args) {
		System.out.println("������绰����");
		Scanner scan = new Scanner(System.in);
		String phone = scan.nextLine();
		Pattern p = Pattern.compile("\\d{3,4}-?\\d{8}");
		Matcher m = p.matcher(phone);
		if(m.matches()) System.out.println("����绰����Ϸ�");
		else System.out.println("����绰���벻�Ϸ�");
	}

}
