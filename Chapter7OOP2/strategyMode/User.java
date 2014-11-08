package j2seExample300.Chapter7OOP2.strategyMode;
/*
 * 策略模式和简单工厂模式组合 应用
 */
public class User {

	public static void main(String[] args) {
		System.out.println("用户选择了GIF格式:");
		ImageSaver is = TypeChooser.getSave("GIF");
		is.save();
		System.out.println("用户选择了JPEG格式:");
		is = TypeChooser.getSave("JPEG");
		is.save();
	}
}
