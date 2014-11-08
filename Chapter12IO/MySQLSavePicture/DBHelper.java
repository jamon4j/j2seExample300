package j2seExample300.Chapter12IO.MySQLSavePicture;
import java.io.*;
import java.sql.*;
public class DBHelper implements DBConfig{
	public static boolean savePicture(Picture picture)
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		FileInputStream in = null;
		String sql = "insert into tb_picture(pictureName,pictureFile) values (?,?);";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			in = new FileInputStream(picture.getPictureFile());
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			ps = conn.prepareStatement(sql);
			ps.setString(1, picture.getPictureName());
			ps.setBlob(2, in);
			ps.execute();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
