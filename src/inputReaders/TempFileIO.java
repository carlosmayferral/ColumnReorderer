package inputReaders;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Reads and writes objects from and to disk.
 * @author Carlos May
 *
 */
public class TempFileIO {
	
	private static final String FILENAME = "temp";
	
	private ObjectOutputStream oos;
	
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
	
	public void write(ArrayList<String> line) {
		try {
			oos.writeObject(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-10);
		}
	}
	
	
	
}