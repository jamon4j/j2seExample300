package j2seExample300.Chapter7OOP2.strategyMode;
/*
 * ����ģʽ�ͼ򵥹���ģʽ��� Ӧ��
 */
public class User {

	public static void main(String[] args) {
		System.out.println("�û�ѡ����GIF��ʽ:");
		ImageSaver is = TypeChooser.getSave("GIF");
		is.save();
		System.out.println("�û�ѡ����JPEG��ʽ:");
		is = TypeChooser.getSave("JPEG");
		is.save();
	}
}
