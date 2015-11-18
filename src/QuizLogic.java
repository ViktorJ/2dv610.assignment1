
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
		return getCounter() == 10;
	}

	public void gameLoop() {
		while(!isFinnished()){
			increaseCounter();
		}
	}

}
