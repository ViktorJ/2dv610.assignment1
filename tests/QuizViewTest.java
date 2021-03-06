import static org.mockito.Mockito.*;

import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QuizViewTest {
	private PrintWriter console;
	private QuizView sut;

	@Before
	public void setUp() throws Exception {
		console = mock(PrintWriter.class);
		sut = new QuizView(console);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void showWelcomeMsg_printWelcomeText() {
		sut.showWelcomeMsg();
		verify(console).println(QuizView.WELCOME);
	}
	
	@Test
	public void showCategoryOptions_printCategoryOptions(){
		sut.showCategoryOptions();
		verify(console).println(QuizView.CATEGORY_OPTIONS);
	}
	
	@Test
	public void showQuizTypeOption_printQuizTypeOption(){
		sut.showQuizTypeOption();
		verify(console).println(QuizView.QUIZTYPE_OPTION);
	}
	
	@Test
	public void showResults_shouldPrintMessageOnZero(){
		sut.showResults(0);
		verify(console).println("You got 0 points. Shame on you!");
	}
	
	@Test
	public void showResults_shouldPrintMessageOnOneToThree(){
		int num = 1;
		String msg = "You got " + num + " points. Not very good...";
		sut.showResults(num);
		verify(console).println(msg);
	}
	
	@Test
	public void showResults_shouldPrintMessageOnFourToSix(){
		int num = 4;
		String msg = "You got " + num + " points. Ok, but not more.";
		sut.showResults(num);
		verify(console).println(msg);
	}
	
	@Test
	public void showResults_shouldPrintMessageOnSevenToNine(){
		int num = 7;
		String msg = "You got " + num + " points. Thats a real good score!";
		sut.showResults(num);
		verify(console).println(msg);
	}
	
	@Test
	public void showResults_shouldPrintMessageOnTen(){
		int num = 10;
		String msg = "You got " + num + " points. Thats fantastic! You Rock!";
		sut.showResults(num);
		verify(console).println(msg);
	}

}
