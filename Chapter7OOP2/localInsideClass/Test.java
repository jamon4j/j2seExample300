package j2seExample300.Chapter7OOP2.localInsideClass;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		AlarmClock ac = new AlarmClock(1000,true);
		ac.start();
		JOptionPane.showMessageDialog(null, "ÊÇ·ñÍË³ö£¿");
		System.exit(0);
	}

}
