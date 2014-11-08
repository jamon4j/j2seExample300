package j2seExample300.Charpter3LanguageFoundation.copy;

import java.io.*;
import java.util.*;

public class RedirectOutputStream {

	public static void main(String[] args) {
		String dir1 = "test1";
		String dir2 = "test2";
		String separator = File.separator;
		String path = dir1 + separator + dir2;
		String filename = "test_log.txt";
		File f = new File(path);
		if(!f.exists())
		{
			f.mkdirs();
		}
		f = new File(path,filename);
		if(!f.exists())
		{
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("program start!");
		System.out.println("----"+new Date()+"----");
	}
}
