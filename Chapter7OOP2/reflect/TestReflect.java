package j2seExample300.Chapter7OOP2.reflect;

import java.lang.reflect.*;

/*
 * ��Student��������������ֲ���
 */
public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException
	{
		System.out.println("ͨ��Class���ȡStudent�����Ϣ:");
		Class<?> Stu_class = Class.forName("j2seExample300.Chapter7OOP2.reflect.Student");
		System.out.println("��׼���ƣ�"+Stu_class.getCanonicalName());
		System.out.println("���η���"+Modifier.toString(Stu_class.getModifiers()));
		TypeVariable<?>[] typeVariabls = Stu_class.getTypeParameters();
		if(typeVariabls!=null)
		{
			for(TypeVariable type:typeVariabls)
			{
				System.out.println(type);
			}
		}else
		{
			System.out.println("��");
		}
		System.out.println("ʵ�ֵĽӿڣ�");
		Type[] interfaces = Stu_class.getInterfaces();
		if(interfaces.length!=0)
		{
			for(Type type:interfaces)
			{
				System.out.println("\t"+type);
			}
		}else{
			System.out.println("��");
		}
		
		System.out.println("ֱ�Ӽ̳��ࣺ");
		Type superClass = Stu_class.getSuperclass();
		if(superClass!=null)
		{
			System.out.println("\t"+superClass);
		}else{
			System.out.println("��");
		}
		
		/*��̬�������˽����*/
		Student student = new Student(003,"�Ұ���");
		try {
			Field id = Stu_class.getDeclaredField("id");
			System.out.println("����ǰ��ID��"+student.getId());
			id.setAccessible(true);			
			id.setInt(student, 27);
			System.out.println("���ú��ID��"+student.getId());
			
			Field name = Stu_class.getDeclaredField("name");
			System.out.println("����ǰ��Name��"+student.getName());
			name.setAccessible(true);			
			name.set(student, "�żҽ�");
			System.out.println("���ú��Name��"+student.getName());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}	
	
		/*��̬�������еķ���*/
		try {
			System.out.println("ʹ�÷������Studen�෽��");
			Method study = Stu_class.getDeclaredMethod("study", null);
			study.invoke(student, null);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*��̬ʵ������*/
		try {
			
			Constructor<Student> constructor = (Constructor<Student>) Stu_class.getDeclaredConstructor(int.class,String.class);
			System.out.println("ʹ�÷��䴴��Studen�����");
			Student stu = constructor.newInstance(13,"alien");
			System.out.println("ID��"+stu.getId()+"\t Name:"+stu.getName());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
