import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QuizLogicTest {
	private QuizLogic sut;
	private InputStream scan;

	@Before
	public void setUp() throws Exception {
		scan = mock(InputStream.class);
		sut = new QuizLogic(scan);
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
	
	@Test
	public void getCounter_ValueShouldBeZeroAfterCounterIsReset(){
		sut.increaseCounter();
		sut.resetCounter();
		assertEquals(sut.getCounter(), 0);
	}
	
	@Test
	public void isFinnished_ShouldReturnTrueWhenCounterHasValueTen(){
		for(int i = 0; i < 10; i++){
			sut.increaseCounter();
		}
		assertTrue(sut.isFinnished());
	}
	
	@Test
	public void isFinished_ShouldReturnFalseWhenCounterIsNotTen(){
		for(int i = 0; i < 5; i++){
			sut.increaseCounter();
		}
		assertFalse(sut.isFinnished());
	}
	
	@Test
	public void gameLoop_ShouldLoopUntilCounterIsTen(){
		sut.gameLoop();
		assertEquals(sut.getCounter(), 10);
	}
	
	@Test
	public void getScore_returnScoreWithValueZero(){
		assertEquals(sut.getScore(), 0);
	}
	
	@Test 
	public void getScore_returnScoreWithIncreasedValue(){
		sut.increaseScore();
		assertEquals(sut.getScore(), 1);
	}
	
	@Test
	public void readLine_shouldReturnCorrectInputFromScanner() throws IOException{
		when(scan.read()).thenReturn(1);
		int input = sut.readLine();
		assertEquals(input, 1);
		verify(scan).read();
	}

}
