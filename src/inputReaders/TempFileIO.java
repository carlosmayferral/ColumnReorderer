package inputReaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Reads and writes objects from and to disk.
 * @author Carlos May
 *
 */
public class TempFileIO {
	
	private static final String FILENAME = "temp";
	
	private ObjectOutputStream oos;
	
	private ObjectInputStream ois;
	
	private FileInputStream fis;
	
	public TempFileIO() {
		
	}
	
	public void createFile() {
		try {
			oos = new ObjectOutputStream( new FileOutputStream(FILENAME));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-10);
		}
	}
	
	public void saveFile() {
		try {
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-10);
		}
	}
	
	public void write(List<String> list) {
		try {
			oos.writeObject(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-10);
		}
	}

	public void openFile() throws IOException {
		fis = new FileInputStream(new File(FILENAME));
		ois = new ObjectInputStream(fis);
	}
	
	public List<String> readStringList() throws IOException {
		try {
			return (List<String>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-10);
			return null;
			}
	}
	
	public boolean hasData() throws IOException {
		return fis.available()>0;
	}
	
	public void closeFile() throws IOException {
		ois.close();
	}

	public void deleteTempFile() {
		new File(FILENAME).delete();
	}
	
	
	
}
