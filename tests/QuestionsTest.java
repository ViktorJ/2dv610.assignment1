import static org.junit.Assert.*;

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

	@Test
	public void getQuestion_returnFirstQuestionFromJSONFile() {
		Questions sut = new Questions();
		assertEqual(sut.getQuestion(0), "What was Zlatan Ibrahimovic first proffesional club after Malmo FF?");
	}

}
