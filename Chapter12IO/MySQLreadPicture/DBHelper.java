package j2seExample300.Chapter12IO.MySQLreadPicture;

import java.io.*;
import java.sql.*;

import javax.swing.*;

import j2seExample300.Chapter12IO.MySQLSavePicture.*;

public class DBHelper implements DBConfig{
	public static ImageIcon readPicture(Picture picture)
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select pictureFile from tb_picture where id ="+picture.getId() +" and pictureName = '"+picture.getPictureName()+"';";
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				Blob pictureFile = rs.getBlob("pictureFile");
				return new ImageIcon(pictureFile.getBytes(1, (int)pictureFile.length()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
