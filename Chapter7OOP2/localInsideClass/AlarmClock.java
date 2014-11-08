package j2seExample300.Chapter7OOP2.localInsideClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

public class AlarmClock {
	private int delay;
	private boolean flag;
	
	public AlarmClock(int delay, boolean flag) {
		super();
		this.delay = delay;
		this.flag = flag;
	}
	
	public void start()
	{
		class Printer implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
					SimpleDateFormat format = new SimpleDateFormat("k:m:s");
					String result = format.format(new Date());
					System.out.println("��ǰ��ʱ���ǣ�"+result);
					if(flag)
					{
						Toolkit.getDefaultToolkit().beep();
					}
			}
			
		}
		new Timer(delay,new Printer()).start();
	}
}
