package inputReaders;

import java.io.FileNotFoundException;

import columnReorderer.CPTtoDatabaseRearranger;
import columnReorderer.ColumnRearrangementType;
import columnReorderer.ColumnRearranger;

public class ComponentFactory {
	
	private static ComponentFactory instance;
	
	/**
	 * Hide constructor
	 */
	private ComponentFactory() {
		
	}
	
	public static ComponentFactory getInstance() {
		if (instance == null) {
			instance = new ComponentFactory();
		}
		return instance;
	}

	public SpreadsheetFileReader getSpreadSheetReader(String path) throws FileNotRecognizedException, FileNotFoundException {
		if (path.contains(".csv")) {
			return new CsvSpreadsheetReader(path);
		}
		else throw new FileNotRecognizedException("Selected file does not have a recognised extension");
	}

	public ColumnRearranger getColumnRearranger(ColumnRearrangementType type) {
		if (type == ColumnRearrangementType.CPT_DEFAULT_TO_DATABASE) {
			return new CPTtoDatabaseRearranger();
		}
		return null;
	}

}
