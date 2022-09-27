package columnReorderer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CPTtoDatabaseRearrangerTest {
	
	private CPTtoDatabaseRearranger rearranger;
	
	private List<String> input;

	@BeforeEach
	void setUp() throws Exception {
		rearranger = new CPTtoDatabaseRearranger();
		String delimited = "Schedule,Animal_Id,Group_Id,User,Weight,Date,Time,Database,Chamber,Session_Id,Day,TimeStamp,Trial_Number,Correct_Image,Correction_Trial,Image_Displayed,Stimulus_Duration,Stimulus_Contrast,ITI_Duration,Distracted_Trial,Congruent_Distracter,Correct,Center_Touches_ITI,Total_Touches_SD,Total_Touches_LH,Total_Touches_Post_Trial,Response_Latency,Reward_Collection_Latency,Front_Beam_Breaks,Back_Beam_Breaks,Tray_Beam_Breaks";
		input = Arrays.asList(delimited.split(","));
	}

	@Test
	void index0() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Animal_Id";
		int atIndex = 0;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index1() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Schedule";
		int atIndex = 1;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index2() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Date";
		int atIndex = 2;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index3() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Time";
		int atIndex = 3;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index4() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Database";
		int atIndex = 4;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index5() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Chamber";
		int atIndex = 5;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index6() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Session_Id";
		int atIndex = 6;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index7() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Day";
		int atIndex = 7;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index8() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "TimeStamp";
		int atIndex = 8;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index9() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Trial_Number";
		int atIndex = 9;
		assertEquals(expected,orderedLine.get(atIndex));
	}
	
	@Test
	void index10() throws WrongSpreadSheetFormatException {
		List<String> orderedLine = rearranger.rearrange(input);
		String expected = "Response_Latency";
		int atIndex = 10;
		assertEquals(expected,orderedLine.get(atIndex));
	}

}
