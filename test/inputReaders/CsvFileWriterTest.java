package inputReaders;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvFileWriterTest {
	
	private CsvFileWriter fw;

	@BeforeEach
	void setUp() throws Exception {
		fw = new CsvFileWriter();
	}

	@Test
	void fileWriterWritesCommaDelimitedString() {
		StringWriter sw = new StringWriter();
		fw.setPrintWriter(new PrintWriter(sw));
		ArrayList<String> content = new ArrayList<>();
		content.add("Testing");
		content.add("1");
		content.add("2");
		fw.writeLine(content);
		fw.saveFile();
		assertEquals("Testing,1,2\r\n",sw.toString());
	}

}
