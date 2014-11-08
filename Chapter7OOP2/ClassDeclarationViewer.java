package j2seExample300.Chapter7OOP2;

import java.lang.reflect.Modifier;
import java.lang.reflect.*;
import java.lang.reflect.TypeVariable;

public class ClassDeclarationViewer {

	public static void main(String[] args) throws ClassNotFoundException {
			Class<?> clazz = Class.forName("java.util.ArrayList");
			System.out.println("��ı�׼���ƣ�"+clazz.getCanonicalName());
			System.out.println("������η���"+Modifier.toString(clazz.getModifiers()));
			TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
			System.out.println("��ķ��Ͳ�����");
			if(typeVariables.length!=0)
			{
				for(TypeVariable<?> typeVariable:typeVariables){
					System.out.println(typeVariable+"\t");
				}
			}else{
				System.out.println("��");
			}
			
			Type[] interfaces = clazz.getGenericInterfaces();
			System.out.println("����ʵ�ֵĽӿڣ�");
			if(interfaces.length!=0)
			{
				for(Type type:interfaces)
					System.out.println("\t"+type);
			}else{
				System.out.println("\t"+"��");
			}
			
			Type superClass = clazz.getGenericSuperclass();
			System.out.println("���ֱ�Ӽ̳��ࣺ");
			if(superClass!=null)
			{
				System.out.println(superClass);
			}else{
				System.out.println("��");
			}
	}

}
