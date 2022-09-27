package inputReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a class that can read spreadsheet type files, either CSV or excel
 * @author Carlos May
 *
 */
public interface SpreadsheetFileReader {
	
	public List<String> readLine() throws IOException;
	
	public boolean hasData() throws IOException;


}
