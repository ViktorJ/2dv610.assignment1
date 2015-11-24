import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QuestionsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/*
	@Test
	public void getQuestion_returnFirstQuestionFromJSONFile() {
		Questions sut = new Questions();
		assertEquals(sut.getQuestion(0), "What was Zlatan Ibrahimovic first proffesional club after Malmo FF?");
	}
	*/
	
	@Test(expected = FileNotFoundException.class)
	public void getQuestion_shouldThrowExceptionWhenNoFile(){
		Questions sut = new Questions();
		sut.getQuestion();	
	}

}
