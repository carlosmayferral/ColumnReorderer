package columnReorderer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColumnReordererTest {
	
	private ColumnReorderer cr;
	
	@BeforeEach
	void setUp() throws Exception {
		cr = new ColumnReorderer();
	}

	@Test
	void invalidRearrangerIndexThrowsException() throws WrongSpreadSheetFormatException {
		try {
			cr.run(new String[] {
					"test.csv",
					"-1"
			});
		} catch (InvalidArgumentException e) {
			return;
		} catch (IOException e) {
			fail("wrong exception");
		}
		fail("No exception thrown");
	}
	
	@Test
	void invalidRearrangerStringThrowsException() throws WrongSpreadSheetFormatException {
		try {
			cr.run(new String[] {
					"test.csv",
					"Hello"
			});
		} catch (InvalidArgumentException e) {
			return;
		} catch (IOException e) {
			fail("wrong exception");
		}
		fail("No exception thrown");
	}
	
	@Test
	void invalidFileExtensionThrowsException() throws WrongSpreadSheetFormatException {
		try {
			cr.run(new String[] {
					"test.do",
					"0"
			});
		} catch (InvalidArgumentException e) {
			return;
		} catch (IOException e) {
			fail("wrong exception");
		}
		fail("No exception thrown");
	}
	
	@Test
	void nonExistentFileThrowsException() throws WrongSpreadSheetFormatException {
		try {
			cr.run(new String[] {
					"doesNotExist.csv",
					"0"
			});
		} catch (InvalidArgumentException e) {
			return;
		} catch (IOException e) {
			fail("wrong exception");
		}
		fail("No exception thrown");
	}
	
	

}
