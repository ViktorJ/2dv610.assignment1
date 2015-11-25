import java.io.PrintWriter;


public class QuizView {
	
	public static final String WELCOME = "Welcome to JavaQuiz!";
	public static final String CATEGORY_OPTIONS = "What category of questions do you want? [1] Sport, [2] Movies";
	public static final String QUIZTYPE_OPTION = "What type of quiz do you want? [1] No alternatives, [2] Multiple alternatives";
	
	private PrintWriter console;

	public QuizView(PrintWriter console){
		this.console = console;
	}

	public void showWelcomeMsg() {
		console.println(WELCOME);
	}

	public void showCategoryOptions() {
		console.println(CATEGORY_OPTIONS);
	}
	
	public void showQuizTypeOption(){
		console.println(QUIZTYPE_OPTION);
	}

	public void showResults(int score) {
	console.println("You got 0 points. Shame on you!");
	}

}
