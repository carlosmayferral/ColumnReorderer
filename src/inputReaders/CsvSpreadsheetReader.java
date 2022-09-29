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
		String line = br.readLine();
		if(line != null) {
			return Arrays.asList(line.split(DELIMITER));
		}
		else {
			return null;
		}
	}

	@Override
	public boolean hasData() throws IOException {
		return br.ready();
	}

	public void setBufferedReader(BufferedReader br) {
		this.br = br;
	}

	@Override
	public void close() throws IOException {
		br.close();
		
	}

	@Override
	public List<List<String>> readFile() throws IOException {
		//Initialize result container
		List<List<String>> listOfLists = new ArrayList<>();
		//Buffer for testing read
		List<String> line = null;
		//While there is input in stream
		while ((line = readLine())!= null) {
			listOfLists.add(line);
		}
		return listOfLists;
	}


}
