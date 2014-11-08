package j2seExample300.Chapter7OOP2.reflect;

import java.lang.reflect.*;

/*
 * 以Student类例子作反射各种操作
 */
public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException
	{
		System.out.println("通过Class类获取Student类的信息:");
		Class<?> Stu_class = Class.forName("j2seExample300.Chapter7OOP2.reflect.Student");
		System.out.println("标准名称："+Stu_class.getCanonicalName());
		System.out.println("修饰符："+Modifier.toString(Stu_class.getModifiers()));
		TypeVariable<?>[] typeVariabls = Stu_class.getTypeParameters();
		if(typeVariabls!=null)
		{
			for(TypeVariable type:typeVariabls)
			{
				System.out.println(type);
			}
		}else
		{
			System.out.println("空");
		}
		System.out.println("实现的接口：");
		Type[] interfaces = Stu_class.getInterfaces();
		if(interfaces.length!=0)
		{
			for(Type type:interfaces)
			{
				System.out.println("\t"+type);
			}
		}else{
			System.out.println("空");
		}
		
		System.out.println("直接继承类：");
		Type superClass = Stu_class.getSuperclass();
		if(superClass!=null)
		{
			System.out.println("\t"+superClass);
		}else{
			System.out.println("空");
		}
		
		/*动态设置类的私有域*/
		Student student = new Student(003,"家坝美");
		try {
			Field id = Stu_class.getDeclaredField("id");
			System.out.println("设置前的ID："+student.getId());
			id.setAccessible(true);			
			id.setInt(student, 27);
			System.out.println("设置后的ID："+student.getId());
			
			Field name = Stu_class.getDeclaredField("name");
			System.out.println("设置前的Name："+student.getName());
			name.setAccessible(true);			
			name.set(student, "张家江");
			System.out.println("设置后的Name："+student.getName());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}	
	
		/*动态调用类中的方法*/
		try {
			System.out.println("使用反射调用Studen类方法");
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
		
		/*动态实例化类*/
		try {
			
			Constructor<Student> constructor = (Constructor<Student>) Stu_class.getDeclaredConstructor(int.class,String.class);
			System.out.println("使用反射创建Studen类对象");
			Student stu = constructor.newInstance(13,"alien");
			System.out.println("ID："+stu.getId()+"\t Name:"+stu.getName());
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
