package columnReorderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import inputReaders.ComponentFactory;
import inputReaders.CsvFileWriter;
import inputReaders.FileNotRecognizedException;
import inputReaders.SpreadsheetFileReader;

public class ColumnReorderer {
	
	
	private SpreadsheetFileReader fileReader;
	private CsvFileWriter filewriter;
	private ColumnRearranger columnRearranger;
	

	public static void main(String[] args) throws IOException {
		ColumnReorderer columnReorderer = new ColumnReorderer();
		try {
			columnReorderer.run(args);
		}
		catch (InvalidArgumentException e) {
			if(e.getCause() == null) {
				printUsage();
				System.exit(-1);
			}
			else if (e.getCause().getClass().equals(ArrayIndexOutOfBoundsException.class) ) {
				System.out.println("ERROR: Provided code (" + args[1] +") does not match a type of rearrangement.");
				printUsage();
				System.exit(-2);
			}
			else if (e.getCause().getClass().equals(NumberFormatException.class)) {
				System.out.println("ERROR: Code must be an integer.");
				printUsage();
				System.exit(-3);
			}
			else if (e.getCause().getClass().equals(FileNotRecognizedException.class)) {
				System.out.println("ERROR: File extension not recognized");
				System.exit(-4);
			}
			else if (e.getCause().getClass().equals(FileNotFoundException.class)) {
				System.out.println("ERROR: File not found");
				System.out.println(e.getMessage());
				System.exit(-5);
			}
		} catch (WrongSpreadSheetFormatException e) {
			System.out.println("ERROR: Spreadsheet not in expected format");
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ColumnReorderer() {
		this.filewriter = new CsvFileWriter();
	}
	
	/**
	 * Main controller method for the column reorderer.
	 * @param args
	 * @throws InvalidArgumentException 
	 * @throws IOException 
	 * @throws WrongSpreadSheetFormatException 
	 */
	public void run(String[] args) throws InvalidArgumentException, IOException, WrongSpreadSheetFormatException {
		
		//Check if correct usage
		if(args.length != 2) {
			throw new InvalidArgumentException("No arguments entered");
		}
		
		//Check second argument
		try {
			ColumnRearrangementType type = ColumnRearrangementType.values()[Integer.parseInt(args[1])];
			columnRearranger = ComponentFactory.getInstance().getColumnRearranger(type);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new InvalidArgumentException("No such rearrangement index", e);
		} catch (NumberFormatException e) {
			throw new InvalidArgumentException("Rearrangement index is not an integer", e);
		}
		
		//Check first argument
		try {
			fileReader = ComponentFactory.getInstance().getSpreadSheetReader(args[0]);
		} catch(FileNotRecognizedException e) {
			throw new InvalidArgumentException(e.getMessage(),e);
		} catch (FileNotFoundException e) {
			throw new InvalidArgumentException(e.getMessage(),e);
		}
		
		String path = args[0];
		
		//Read original into RAM
		List<List<String>> fileContent = fileReader.readFile();
		fileReader.close();
		
		
//		tempFileIO.createFile();
//		try {
//			while(fileReader.hasData()){
//				List<String> line = fileReader.readLine();
//				tempFileIO.write(line);
//			}
//		} catch (IOException e) {
//			throw e;
//		}
//		tempFileIO.saveFile();
//		fileReader.close();
		
		//Rename original
		new File(path).renameTo(new File(path.replace(".csv", "old.csv")));
		
		//Create new file
		filewriter.createFile(path);
		
//		//Load in original saved data
//		tempFileIO.openFile();
		
		//Use rearranger to rearrange columns from RAM
		for(List<String> line : fileContent) {
			List<String> reorderedStringList = columnRearranger.rearrange(line);
			filewriter.writeLine(reorderedStringList);
		}
		
		
//		while(tempFileIO.hasData()){
//			List<String> originalStringList = tempFileIO.readStringList();
//			List<String> reorderedStringList = columnRearranger.rearrange(originalStringList);
//			filewriter.writeLine(reorderedStringList);
//		}
		
//		tempFileIO.closeFile();
		
		//Write new file
		filewriter.saveFile();
		
//		//Write backup old file
//		String modifiedPath = path.replace(".csv", "old.csv");
//		filewriter.createFile(modifiedPath);
//		tempFileIO.openFile();
//		while(tempFileIO.hasData()){
//			List<String> originalStringList = tempFileIO.readStringList();
//			filewriter.writeLine(originalStringList);
//		}
//		tempFileIO.closeFile();
//		filewriter.saveFile();
//		
//		tempFileIO.deleteTempFile();
//		
	}
	
	private static void printUsage() {
		System.out.println("Usage: java -jar ColumnReorderer.jar [path to original file] [code for type of rearrangement]");
		System.out.println("Where code is:");
		int i = 0;
		for(ColumnRearrangementType type : ColumnRearrangementType.values()) {
			System.out.print(i + " : ");
			System.out.println(type.name());
			i++;
		}
	}

}
