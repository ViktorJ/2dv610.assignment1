import java.io.BufferedInputStream;
import java.io.IOException;


public class QuizMain {

	public static void main(String[] args) throws IOException {
		BufferedInputStream in = new BufferedInputStream(System.in);
		QuizLogic quiz = new QuizLogic(in);
		
		quiz.gameLoop();
	}

}
