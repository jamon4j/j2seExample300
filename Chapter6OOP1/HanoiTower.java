package j2seExample300.Chapter6OOP1;

public class HanoiTower {
	public static void moveDish(int level,char A,char B,char C)
	{
		if(level == 1)
		{
			System.out.println("��"+A+"�ƶ�����1�ŵ�"+C);
		}
		else
		{
			moveDish(level-1,A,C,B);
			System.out.println("��"+A+"�ƶ�����"+level+"�ŵ�"+C);
			moveDish(level-1,B,A,C);
		}
	}
}
