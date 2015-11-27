import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class QuizLogic {
	private int counter;
	private int score;
	private InputStream scan;
	private Questions questions;
	private QuizView view;
	private PrintWriter console;
	
	public QuizLogic(InputStream scan){
		counter = 0;
		score = 0;
		console = new PrintWriter(System.out, true);
		questions = new Questions();
		view = new QuizView(console);
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

	public void gameLoop() throws IOException {
		int category = 0;
		int alternatives = 0;
		String answer = "";
		view.showWelcomeMsg();
		view.showCategoryOptions();
		category = scanIntWithScanner();
		view.showQuizTypeOption();
		alternatives = scanIntWithScanner();
		
		
		while(!isFinnished()){
			console.println(questions.getQuestion(getQuestionsCategory(category), getCounter()));
			if(getAlternatives(alternatives)){
				console.println(printAnswerAlternatives(getQuestionsCategory(category), getCounter()));
			}
			answer = scanString();
			if(isAnswerCorrect(getQuestionsCategory(category), getCounter(), answer)){
				increaseScore();
			}
			increaseCounter();
		}
		view.showResults(getScore());
	}

	public int getScore() {
		return score;
	}

	public void increaseScore() {
		score++;
	}

	public int scanInt() throws IOException {
		return scan.read();
	}
	
	public int scanIntWithScanner(){
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	public boolean getAlternatives(int input) {
		if(input == 1 || input == 2){
			return input == 2;
		} else {
			throw new IllegalArgumentException("Input must be 1 or 2.");
		}
	}

	public String getQuestionsCategory(int input) {
		if(input == 1){
			return "sportquestions.json";
		} else if(input == 2){
			return "moviequestions.json";
		} else {
			throw new IllegalArgumentException("Input must be 1 or 2.");
		}
	}
	
	public boolean isAnswerCorrect(String category, int questionNr, String answer) throws FileNotFoundException{
		if(answer.equals(questions.getCorrectAnswer(category, questionNr))){
			return true;
		} else {
			return false;
		}
	}

	public String scanString() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
	
		return in.readLine().toLowerCase();
	}

	public String printAnswerAlternatives(String category, int questionNr) throws FileNotFoundException {
		List<String> aList = new ArrayList<>();
		for(String alt : questions.getAnswersArray(category, questionNr)){
			aList.add(alt);
		}
		Collections.shuffle(aList);
		return aList.toString();
	}

}
