
public class QuizLogic {
	private int counter;
	
	public QuizLogic(){
		counter = 0;
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
		if(getCounter() == 10){
			return true;
		} else {
			return false;
		}
	}

}
