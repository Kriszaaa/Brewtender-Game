package logic;


import java.util.Hashtable;

import javafx.application.Platform;

public class GameLogic {

	private static Timer playerTimer;
	
	private static int playerScore;
			
	public static void init() {

		playerTimer = new Timer(5, 0, 0);
		
	}
	public static void startCountDownTimer(int pl) {

		Thread thread = new Thread(() -> {
			try {
				runCountDownTimer(pl);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		thread.start();
	}
	public static void runCountDownTimer(int pl) throws InterruptedException {
		
	}
	public static void beginTurns(int pl) {

	}
	public static void chooseMode() {
		
	}
}
