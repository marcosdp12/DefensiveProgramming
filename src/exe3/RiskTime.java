package exe3;

public class RiskTime {
	private int hour;
	private int minute;
	private int second;
	
	RiskTime(int newHour, int newMinute, int newSecond){
		setTime(newHour, newMinute, newSecond);
	}

	void setTime(int newHour, int newMinute, int newSecond) {
		/* mutator implementation */ 
		if(newHour > 23 || newHour < 0 || newMinute > 59 || newMinute < 0 
				|| newSecond > 59 || newSecond < 0){
			throw new IllegalArgumentException();
		}
		else{
			hour = newHour;
			minute = newMinute;
			second = newSecond; 
		}
	}

	int[] getTime() {
		int result[] = { hour, minute, second };
		return result;
	}

	void incrementTime() {
		/* mutator implementation */ 
	}
	
	public static void main(String[] args) {
		RiskTime time = new RiskTime(23,24,0);
	}
}
