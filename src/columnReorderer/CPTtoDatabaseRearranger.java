package columnReorderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CPTtoDatabaseRearranger implements ColumnRearranger {
	
	private static final int TOTAL_INPUT_SIZE = 31;
	private static final int TOTAL_OUTPUT_SIZE = 28;
	
	public CPTtoDatabaseRearranger() {
	}

	@Override
	public List<String> rearrange(List<String> original) throws WrongSpreadSheetFormatException {
		if (original.size() != TOTAL_INPUT_SIZE) {
			throw new WrongSpreadSheetFormatException("Input spreadsheet is not the correct size: got size: " + original.size() + " but expected " + TOTAL_INPUT_SIZE);
		}
		ArrayList<String> newList = new ArrayList<>(original);
		//shift animal id from 1 to 0
		newList.add(0, newList.remove(1));
		//shift response latency from 26 to 13
		newList.add(13,newList.remove(26));
		//shift reward latency from 27 to 14
		newList.add(14, newList.remove(27));
		//shift fbb from 28 to 15
		newList.add(15, newList.remove(28));
		//shift bbb from 29 to 16
		newList.add(16, newList.remove(29));
		//shift tbb from 30 to 17
		newList.add(17, newList.remove(30));
		//Remove indexes 3 4 and 5
		newList.remove(2);
		newList.remove(2);
		newList.remove(2);
		return newList;
	}

}
