package inputReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvSpreadsheetReader implements SpreadsheetFileReader {
	
	private static final String DELIMITER = ",";
	private BufferedReader br;
	
	
	
	public CsvSpreadsheetReader (String path) throws FileNotFoundException{
		
		br = new BufferedReader(new FileReader(new File(path)));
	}

	/**
	 * For testing only
	 */
	public CsvSpreadsheetReader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> readLine() throws IOException {
		String[] delimited = br.readLine().split(DELIMITER);
		return Arrays.asList(delimited);
	}

	@Override
	public boolean hasData() throws IOException {
		return br.ready();
	}

	public void setBufferedReader(BufferedReader br) {
		this.br = br;
	}


}
