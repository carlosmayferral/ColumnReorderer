package inputReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a class that can read spreadsheet type files, either CSV or excel
 * @author Carlos May
 *
 */
public interface SpreadsheetFileReader {
	
	public ArrayList<String> readLine() throws IOException;
	
	public boolean hasData() throws IOException;


}
