package j2seExample300.Chapter6OOP1;

public class Test {

	public static void main(String[] args) {
//		/*����Book��*/
//		Book book = new Book("��java�����ŵ���ͨ��","���տƼ�",59.5);
//		System.out.println("����:"+book.getBookName());
//		System.out.println("����:"+book.getWriter());
//		System.out.println("�۸�:"+book.getPrice());
//		
//		/*���Ե���ģʽ:Single_Emperor*/
//		Single_Emperor se = Single_Emperor.getInstance();
//		se.getName();
//		
//		/*���Ժ�ŵ��:HanoiTower*/
//		HanoiTower ht = new HanoiTower();
//		ht.moveDish(3, 'A','B','C');
		
		
		/*���Կ�¡�������ࣺEmployee��Address*/
		Address addr1 = new Address("�й�","����","��˳");
		Employee emp1 = new Employee("�ź���",23,addr1);
		try {
			Employee emp2 = emp1.clone();
			emp2.setName("���Ϲ�");
			emp2.setAge(22);
			Address addr2 = new Address("�й�","�Ĵ�","�Ű�");
			emp2.setAddress(addr2);
			System.out.println("Ա��1����Ϣ��"+emp1);
			System.out.println("Ա��2����Ϣ��"+emp2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		
	}

}
