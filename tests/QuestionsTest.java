import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QuestionsTest {
	private Questions sut;

	@Before
	public void setUp() throws Exception {
		sut = new Questions();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected = FileNotFoundException.class)
	public void getQuestion_shouldThrowExceptionWhenNoFile() throws FileNotFoundException{
		sut.getQuestion("", 0);	
	}
	
	@Test
	public void getQuestion_getFirstQuestionFromJSONFile() throws FileNotFoundException{
		String file = "sportquestions.json";
		assertEquals(sut.getQuestion(file, 0), "What was Zlatan Ibrahimovic first proffesional club after Malmo FF?");	
	}

}
