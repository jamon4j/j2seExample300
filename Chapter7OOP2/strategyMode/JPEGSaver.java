package j2seExample300.Chapter7OOP2.strategyMode;

public class JPEGSaver implements ImageSaver {

	@Override
	public void save() {
		System.out.println("����ΪJPEG��ʽ");
	}

}
