package j2seExample300.Chapter12IO.MySQLSavePicture;
import java.io.*;
public class Picture {
	private int id;
	private String pictureName;
	private File pictureFile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public File getPictureFile() {
		return pictureFile;
	}
	public void setPictureFile(File pictureFile) {
		this.pictureFile = pictureFile;
	}
}
