import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuizLogicTest {
	private QuizLogic sut;
	private InputStream scan;
	private BufferedReader in;

	@Before
	public void setUp() throws Exception {
		scan = mock(InputStream.class);
		in = mock(BufferedReader.class);
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
	public void isAnswerCorrect_ShouldReturnTrueWhenAnswerIsCorrect() throws IOException{
		when(in.readLine()).thenReturn("Ajax");
		String input = sut.scanString();
		assertTrue(sut.isAnswerCorrect("sportquestions.json", 0, input));
	}
	
	@Test
	public void readString_ShouldReturnCorrectStringInputFromScanner() throws IOException{
		when(in.readLine()).thenReturn("test");
		String input = sut.scanString();
		assertEquals(input, "test");
	}
	
	@Test
	public void printAnswerAlternatives_shouldPrintAnswerAlternatives() throws FileNotFoundException{
		boolean printed = false;
		String alternatives = sut.printAnswerAlternatives("sportquestions.json", 0);
		if(alternatives.contains("Ajax") && alternatives.contains("Milan") && alternatives.contains("Barcelona") && alternatives.contains("Juventus")){
			printed = true;
		}
		assertTrue(printed);
	}
	
	/*
	@Test
	public void gameLoop_ShouldLoopUntilCounterIsTen() throws IOException{
		sut.gameLoop();
		assertEquals(sut.getCounter(), 10);
	}
	*/
	
	
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
	public void getAlternatives_ShouldReturnFalseIfInputIsOne(){
		assertFalse(sut.getAlternatives(1));
	}
	
	@Test
	public void getAlternatives_ShouldReturnTrueIfInputIsTwo(){
		assertTrue(sut.getAlternatives(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getAlternatives_ShouldThrowExceptionIfInputIsNotOneOrTwo(){
		sut.getAlternatives(3);
	}
	
	@Test
	public void getQuestionsCategory_shouldReturnSportOnInputOne(){
		assertEquals(sut.getQuestionsCategory(1), "sportquestions.json");
	}
	
	@Test
	public void getQuestionsCategory_shouldReturnMoviesOnInputTwo(){
		assertEquals(sut.getQuestionsCategory(2), "moviequestions.json");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getQuestionsCategory_shouldThrowExceptionIfInputIsNotOneOrTwo(){
		sut.getQuestionsCategory(3);
	}

	@Test
	public void scanInt_shouldReturnCorrectInputFromScanner() throws IOException{
		when(scan.read()).thenReturn(1);
		int input = sut.scanInt();
		assertEquals(input, 1);
		verify(scan).read();
	}

}
