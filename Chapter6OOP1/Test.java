package j2seExample300.Chapter6OOP1;

public class Test {

	public static void main(String[] args) {
//		/*测试Book类*/
//		Book book = new Book("《java从入门到精通》","明日科技",59.5);
//		System.out.println("书名:"+book.getBookName());
//		System.out.println("作者:"+book.getWriter());
//		System.out.println("价格:"+book.getPrice());
//		
//		/*测试单例模式:Single_Emperor*/
//		Single_Emperor se = Single_Emperor.getInstance();
//		se.getName();
//		
//		/*测试汉诺塔:HanoiTower*/
//		HanoiTower ht = new HanoiTower();
//		ht.moveDish(3, 'A','B','C');
		
		
		/*测试克隆：包括类：Employee，Address*/
		Address addr1 = new Address("中国","贵州","安顺");
		Employee emp1 = new Employee("张呼呼",23,addr1);
		try {
			Employee emp2 = emp1.clone();
			emp2.setName("赖瓜瓜");
			emp2.setAge(22);
			Address addr2 = new Address("中国","四川","雅安");
			emp2.setAddress(addr2);
			System.out.println("员工1的信息："+emp1);
			System.out.println("员工2的信息："+emp2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		
	}

}
