package inputReaders;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvSpreadsheetReaderTest {
	
	private CsvSpreadsheetReader sr;

	@BeforeEach
	void setUp() throws Exception {
		sr = new CsvSpreadsheetReader();
	}

	@Test
	void spreadsheetReaderParsesCommaDelimitedString() throws IOException {
		sr.setBufferedReader(new BufferedReader(new StubReader("Hello,this,is,a,test")));
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Hello");
		expected.add("this");
		expected.add("is");
		expected.add("a");
		expected.add("test");
		assertEquals(expected,sr.readLine());
	}
	
	//Read file with 1 row
	@Test
	void readFileParsesOneRow() throws IOException {
		sr.setBufferedReader(new BufferedReader(new StringReader("This,is,the,first,line")));
		String[] expected= {"This","is","the","first","line"};
		assertEquals(Arrays.asList(expected), sr.readFile().get(0));
	}
	
	//Read file with 2 rows
	@Test
	void readFileParsesTwoRows() throws IOException{
		sr.setBufferedReader(new BufferedReader(new StringReader("This,is,the,first,line\r\nThis,is,the,second,line")));
		String[] expected= {"This","is","the","second","line"};
		assertEquals(Arrays.asList(expected), sr.readFile().get(1));
	}

}
