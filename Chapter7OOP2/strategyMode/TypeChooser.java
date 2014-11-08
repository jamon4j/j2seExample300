package j2seExample300.Chapter7OOP2.strategyMode;

public class TypeChooser {
	public static ImageSaver getSave(String type)
	{
		if(type.equalsIgnoreCase("GIF"))
		{
			return new GIFSaver();
		}else if(type.equalsIgnoreCase("JPEG"))
		{
			return new JPEGSaver();
		}
		else return null;
	}
}
