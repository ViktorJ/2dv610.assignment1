import static org.junit.Assert.*;
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
	public void showOptions_printCategoryOptions(){
		sut.showOptions();
		verify(console).println("What category of questions do you want? [1] Sport, [2] Movies");
	}

}
