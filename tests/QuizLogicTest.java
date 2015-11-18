import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QuizLogicTest {
	private QuizLogic sut;

	@Before
	public void setUp() throws Exception {
		sut = new QuizLogic();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getCounter_returnCounterWithValueZero() {
		assertEquals(sut.getCounter(), 0);
	}
	
	@Test
	public void getCounter_returnCounterWithIncreasedValue(){
		sut.increaseCounter();
		assertEquals(sut.getCounter(), 1);
	}

}
