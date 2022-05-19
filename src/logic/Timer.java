 package logic;

public class Timer {
	private static int minute;
	private static int seconds;
	
	public static int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public static int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	private boolean isStop;
	
	public Timer(int m, int s) {
		minute = m;
		seconds = s;
		this.isStop = true;
	}

	public void decrementTimer(int amount) {
		
		if(isTimerEmpty()) {return;}
		
		seconds -= amount;

		while(seconds < 0) {
			if(isTimerEmpty()) { return;}
			seconds+=60;
			minute -= 1;				
		}
	}
	
	public boolean isTimerEmpty() {
		return minute<=0 && seconds<=0 ;
	}
	
	public String toString() {
		return String.format("%02d:%02d",minute, seconds);
	}

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}
}