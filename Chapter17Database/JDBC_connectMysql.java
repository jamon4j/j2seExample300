package j2seExample300.Chapter17Database;

import java.sql.*;

public class JDBC_connectMysql {
	public static Connection conn;
	public static Statement stmt;
	public static ResultSet rs;
	
	public static void main(String[] args) {
		query();
	}
	
	public static void query()
	{
		conn = getConnection();
		
		String sql = "select * from student";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("��ѯ�Ľ��Ϊ��");
			while(rs.next())
			{
				String number = rs.getString("number");
				String name = rs.getString("name");
				String age = rs.getString("age");
				
				System.out.println(number+" "+name+" "+age+" ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���ݿ��������سɹ�");
			String url = "jdbc:mysql://localhost:3306/my_test";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("�ѳɹ�����MYSQL���ݿ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��"+e.getMessage());
		}
		return conn;
	}
}
