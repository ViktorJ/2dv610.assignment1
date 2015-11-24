import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QuizViewTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void showWelcomeMsg_printWelcomeText() {
		QuizView sut = new QuizView();
		PrintWriter console = mock(PrintWriter.class);
		
		sut.showWelcomeMsg();
		verify(console).println("Welcome to JavaQuiz!");
	}

}
