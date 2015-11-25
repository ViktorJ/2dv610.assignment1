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
		String msg = "";
		if(score == 0){
			msg = "Shame on you!";
		} else if(score >= 1 && score <= 3){
			msg = "Not very good...";
		} else if(score >= 4 && score <= 6){
			msg = "Ok, but not more.";
		} else if(score >= 7 && score <= 9){
			msg = "Thats a real good score!";
		}
		console.println("You got " + score + " points. " + msg);
	}

}
