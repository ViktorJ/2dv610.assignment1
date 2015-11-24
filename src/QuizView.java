import java.io.PrintWriter;


public class QuizView {
	
	public static final String WELCOME = "Welcome to JavaQuiz!";
	
	private PrintWriter console;

	public QuizView(PrintWriter console){
		this.console = console;
	}

	public void showWelcomeMsg() {
		console.println(WELCOME);
	}

	public void showOptions() {
		console.println("What category of questions do you want? [1] Sport, [2] Movies");
	}

}
