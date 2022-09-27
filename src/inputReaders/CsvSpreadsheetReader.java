package inputReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CsvSpreadsheetReader implements SpreadsheetFileReader {
	
	private static final String DELIMITER = ",";
	private BufferedReader br;
	
	
	
	public CsvSpreadsheetReader (String path) throws FileNotFoundException{
		
		br = new BufferedReader(new FileReader(new File(path)));
	}

	@Override
	public ArrayList<String> readLine() throws IOException {
		return (ArrayList<String>) Arrays.asList(br.readLine().split(DELIMITER));
	}

	@Override
	public boolean hasData() throws IOException {
		return br.ready();
	}

	public void setBufferedReader(BufferedReader br) {
		this.br = br;
	}


}
