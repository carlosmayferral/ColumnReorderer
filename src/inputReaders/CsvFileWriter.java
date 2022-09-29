package inputReaders;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvFileWriter {
	
	private PrintWriter pw;
	
	public CsvFileWriter() {
		
	};
	
	public void createFile(String path) throws IOException {
		pw = new PrintWriter(new FileOutputStream(new File(path)));
	}
	
	public void writeLine(List<String> line) {
		String joinedLine = String.join(",", line);
		pw.println(joinedLine);
	}

	public void setPrintWriter(PrintWriter pw) {
		this.pw = pw;
	}
	
	public void saveFile() {
		pw.close();
	}
	

}
