package j2seExample300.Chapter8StringAndWrapper;

import java.io.*;
/*
 * 代码统计程序
 */
public class CodeCounter {
	private static long commentLines=0;
	private static long normalLines=0;
	private static long whiteLines=0;
	public static void main(String[] args) {
		File file = new File("H:\\编程源代码\\javaProject\\TankWar2.8.6\\src\\rj2010\\zjj");
		File[] files = file.listFiles();
		for(File child:files)
		{
			if(child.getName().matches(".*\\.java$"))
				parse(child);
		}
		
		
		System.out.println("normalLines:"+normalLines);
		System.out.println("commentLines:"+commentLines);
		System.out.println("whiteLines:"+whiteLines);
	}
	
	private static void parse(File file)
	{
		BufferedReader br = null;
		boolean comment = false;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";		
			while((line=br.readLine())!=null)
			{			
				line.trim();
				if(line.matches("^[\\s&&[^\\n]]*$")) whiteLines++;
				else if(line.startsWith("/*")&&!line.endsWith("*/")){
					commentLines++;
					comment = true;
				}else if(line.startsWith("/*")&&line.endsWith("*/")){
					commentLines++;
				}else if(comment) {
					commentLines++;
					if(line.endsWith("*/")){ 
						comment = false;
					}
				}else if(line.startsWith("//")){
					commentLines++;
				}else {
					normalLines++;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				br = null;
			}
		}
	}
}
