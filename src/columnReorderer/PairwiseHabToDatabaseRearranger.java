package columnReorderer;

import java.util.ArrayList;
import java.util.List;

public class PairwiseHabToDatabaseRearranger implements ColumnRearranger {
	
	private static final int TOTAL_INPUT_SIZE = 24;

	@Override
	public List<String> rearrange(List<String> original) throws WrongSpreadSheetFormatException {
		if(original.size() != TOTAL_INPUT_SIZE) {
			throw new WrongSpreadSheetFormatException("Input spreadsheet is not the correct size: got size: " + original.size() + " but expected " + TOTAL_INPUT_SIZE);
		}
		ArrayList<String> newList = new ArrayList<>(original);
		
		//shift animal id from 1 to 0
		newList.add(0, newList.remove(1));
		
		//insert new column in place 13, response latency will be filled with nans
		newList.add(13,"" + Double.NaN);
		
		//move reward latency to 14
		newList.add(14,newList.remove(16));
		
		//move fbb to 15
		newList.add(15,newList.remove(23));
		
		//move bbb to 16
		newList.add(16,newList.remove(24));
		
		//move tbb to 17
		newList.add(17,newList.remove(24));
		
		//Remove indexes 2,3,4
		newList.remove(2);
		newList.remove(2);
		newList.remove(2);
		
		return newList;
	}

}
