package j2seExample300.Chapter6OOP1;

public class HanoiTower {
	public static void moveDish(int level,char A,char B,char C)
	{
		if(level == 1)
		{
			System.out.println("从"+A+"移动盘子1号到"+C);
		}
		else
		{
			moveDish(level-1,A,C,B);
			System.out.println("从"+A+"移动盘子"+level+"号到"+C);
			moveDish(level-1,B,A,C);
		}
	}
}
