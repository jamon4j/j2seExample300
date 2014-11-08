package j2seExample300.Chapter7OOP2.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * �������ʵ���������鳤�ȵķ���
 */
public class VariableArray {
	public static Object increaseArray(Object array)
	{
		Class<?> clazz = array.getClass();
		if(clazz.isArray())
		{
			Class<?> componentType = clazz.getComponentType();
			int length = Array.getLength(array);
			Object newArray = Array.newInstance(componentType, length+5);
			System.arraycopy(array, 0, newArray, 0, length);
			return newArray;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] intArray = new int[10];
		System.out.println("�����ԭʼ�����ǣ�"+intArray.length);
		Arrays.fill(intArray, 8);
		System.out.println("����������ǣ�");
		System.out.println(Arrays.toString(intArray));
		int[] newIntArray = (int[])increaseArray(intArray);
		System.out.println("�������չ�󳤶��ǣ�"+newIntArray.length);
		System.out.println("������չ��������ǣ�");
		System.out.println(Arrays.toString(newIntArray));
	}

}
