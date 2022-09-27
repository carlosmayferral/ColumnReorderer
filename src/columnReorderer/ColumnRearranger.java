package columnReorderer;

import java.util.List;

public interface ColumnRearranger {

	List<String> rearrange(List<String> original) throws WrongSpreadSheetFormatException;

}
