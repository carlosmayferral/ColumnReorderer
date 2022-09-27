package columnReorderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import inputReaders.ComponentFactory;
import inputReaders.CsvFileWriter;
import inputReaders.FileNotRecognizedException;
import inputReaders.SpreadsheetFileReader;
import inputReaders.TempFileIO;

public class ColumnReorderer {
	
	private SpreadsheetFileReader fileReader;
	private CsvFileWriter filewriter;
	private TempFileIO tempFileIO;
	

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
		}
	}
	
	public ColumnReorderer() {
		this.tempFileIO = new TempFileIO();
	}
	
	/**
	 * Main controller method for the column reorderer.
	 * @param args
	 * @throws InvalidArgumentException 
	 * @throws IOException 
	 */
	public void run(String[] args) throws InvalidArgumentException, IOException {
		
		//Check if correct usage
		if(args.length != 2) {
			throw new InvalidArgumentException("No arguments entered");
		}
		
		//Check second argument
		try {
			ColumnRearrangementType type = ColumnRearrangementType.values()[Integer.parseInt(args[1])];
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
		
		//Read original into temp file
		tempFileIO.createFile();
		try {
			while(fileReader.hasData()){
				tempFileIO.write(fileReader.readLine());
			}
		} catch (IOException e) {
			throw e;
		}
		tempFileIO.saveFile();
		fileReader.close();
		
		//Delete original
		new File(path).delete();
		
		//Create new file
		
		
		//Load in original data
		
		//Use rearranger to rearrange columns
		
		//Write new file
		
		//Write backup old file
		
		
	}
	
	private static void printUsage() {
		System.out.println("Usage: java -jar ColumnReorderer.jar [path to original file] [code for type of rearrangement]");
		System.out.println("Where code is:");
		int i = 0;
		for(ColumnRearrangementType type : ColumnRearrangementType.values()) {
			System.out.print(i + " : ");
			System.out.println(type.name());
		}
	}

}
