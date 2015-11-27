import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.*;


public class Questions {
	
	private String getStringFromFile(String file) throws FileNotFoundException{
		if(file == ""){
			throw new FileNotFoundException();
		}
		String strFromFile = "";
		Scanner scan = new Scanner(new File(file));
		
		while(scan.hasNext()){
			strFromFile += scan.nextLine();
		}
		scan.close();
		
		return strFromFile;
	}
	
	public String getQuestion(String file, int number) throws FileNotFoundException {
		String question = "";
		String questionsFromFile = getStringFromFile(file);
		
		JSONObject questions = new JSONObject(questionsFromFile);
		JSONArray qArray = questions.getJSONArray("questions");
		
		question = qArray.getJSONObject(number).getString("question");
		
		return question;
	}

	public Object getCorrectAnswer(String file, int number) throws FileNotFoundException {
		String answer = "";
		String questionsFromFile = getStringFromFile(file);
		
		JSONObject questions = new JSONObject(questionsFromFile);
		JSONArray qArray = questions.getJSONArray("questions");
		
		answer = qArray.getJSONObject(number).getString("correct");
		
		return answer.toLowerCase();
	}

	public String[] getAnswersArray(String file, int number) throws FileNotFoundException {
		String[] answerArray = new String[4];
		
		String questionsFromFile = getStringFromFile(file);
		
		JSONObject questions = new JSONObject(questionsFromFile);
		JSONArray qArray = questions.getJSONArray("questions");
		
		answerArray[0] = qArray.getJSONObject(number).getString("correct");
		
		for(int i = 1; i <= 3; i++){
			answerArray[i] = qArray.getJSONObject(number).getString("wrong" + i);
		}
		
		return answerArray;
	}

}
