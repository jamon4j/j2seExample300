package j2seExample300.Chapter9Collections;

import java.util.*;

public class ListIteratorDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		ListIterator it = list.listIterator();
		for(;it.hasNext();){
			it.next();
		}
		
		for(;it.hasPrevious();){
			System.out.print(it.previous()+" ");
		}
	}

}
