package inputReaders;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvSpreadsheetReaderTest {
	
	private CsvSpreadsheetReader sr;

	@BeforeEach
	void setUp() throws Exception {
		sr = new CsvSpreadsheetReader();
		sr.setBufferedReader(new BufferedReader(new StubReader("Hello,this,is,a,test")));
	}

	@Test
	void spreadsheetReaderParsesCommaDelimitedString() throws IOException {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Hello");
		expected.add("this");
		expected.add("is");
		expected.add("a");
		expected.add("test");
		assertEquals(expected,sr.readLine());
	}

}
