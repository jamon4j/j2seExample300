package j2seExample300.Chapter9Collections;

import java.util.*;

/*
 *  Set实现不重复随机数组
 */
public class RandomSortArray {

	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		Random r = new Random();
		int count = 0;
		while(count<10){
			boolean success = ts.add(r.nextInt(100));
			if(success) count++;
		}
		Integer[] array = new Integer[10];
		ts.toArray(array);
		for(int value:array)
		{
			System.out.print(value+" ");
		}
	}
}
