package inputReaders;

import java.io.IOException;
import java.io.Reader;

public class StubReader extends Reader {
	
	private String content;
	private boolean hasBeenRead;
	
	public StubReader(String content) {
		this.content = content;
		this.hasBeenRead = false;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		if (this.hasBeenRead) {
			return -1;
		}
		char[] chars = content.toCharArray();
		for (int i=0; i < content.length(); i++) {
			cbuf[i] = chars[i];
		}
		this.hasBeenRead = true;
		return content.length();
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

}
