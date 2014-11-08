package j2seExample300.Chapter7OOP2.strategyMode;

public class GIFSaver implements ImageSaver {

	public void save() {
		System.out.println("保存为GIF格式");
	}

}
