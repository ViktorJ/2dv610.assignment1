import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;

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
	
	@Test
	public void getCorrectAnswer_returnCorrectAnswerFromFirstQuestion() throws FileNotFoundException{
		String file = "sportquestions.json";
		assertEquals(sut.getCorrectAnswer(file, 0), "Ajax");
	}
	
	@Test
	public void getAnswersArray_returnArrayWithSizeFour(){
		String file = "sportquestions.json";
		Array[] testArray = sut.getAnswersArray(file, 0);
		assertEquals(testArray.length, 4);
	}

}
