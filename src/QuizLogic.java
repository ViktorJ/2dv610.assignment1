import java.io.IOException;
import java.io.InputStream;


public class QuizLogic {
	private int counter;
	private int score;
	private InputStream scan;
	
	public QuizLogic(InputStream scan){
		counter = 0;
		score = 0;
		this.scan = scan;
	}

	public int getCounter() {
		return counter;
	}

	public void increaseCounter() {
		counter++;
	}

	public void resetCounter() {
		counter = 0;
	}

	public boolean isFinnished() {
		return getCounter() == 10;
	}

	public void gameLoop() {
		while(!isFinnished()){
			increaseCounter();
			//future logic
		}
	}

	public int getScore() {
		return score;
	}

	public void increaseScore() {
		score++;
	}

	public int readLine() throws IOException {
		return scan.read();
	}

	public boolean getAlternatives(int input) {
		if(input == 1 || input == 2){
			return input == 2;
		} else {
			throw new IllegalArgumentException("Input must be 1 or 2.");
		}
	}

	public String getQuestionsCategory(int input) {
		String questions = "";
		if(input == 1){
			questions = "sportquestions.json";
		} else if(input == 2){
			questions = "moviequestions.json";
		} else {
			throw new IllegalArgumentException("Input must be 1 or 2.");
		}
		return questions;
		
	}

}
