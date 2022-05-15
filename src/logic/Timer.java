 package logic;

public class Timer {
	private int minute;
	private int seconds;
	//private int ms;
	
	private boolean isStop;
	
	public Timer(int m, int s) {
		this.minute = m;
		this.seconds = s;
		//this.ms = ms;
		
		this.isStop = true;
	}
	
	

	public void decrementTimer(int amount) {
		
		if(isTimerEmpty()) {return;}
		
		this.seconds -= amount;

		while(this.seconds < 0) {
			if(isTimerEmpty()) { return;}
			this.seconds+=60;
			this.minute -= 1;	
			
			
		}

	}
	
	public boolean isTimerEmpty() {
		return this.minute<=0 && this.seconds<=0 ;
	}
	
	public String toString() {
		return String.format("%02d:%02d",this.minute, this.seconds);
	}

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}
}