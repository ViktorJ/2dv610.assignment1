import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QuizLogicTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getCounter_returnCounterWithValueZero() {
		QuizLogic sut = new QuizLogic();
		assertEquals(sut.getCounter(), 0);
	}

}
