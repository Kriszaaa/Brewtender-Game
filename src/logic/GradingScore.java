package logic;

public class GradingScore {
	public static String Grading(int score) {
		if(score >= 15000) {
			return "Perfect";
		}else if(score >= 7500) {
			return "Nice try";
		}else if(score >= 5000) {
			return "Noob";
		}else {
			return "Suits you";
		}
	}
	public static int GradingInt(int score) {
		if(score == 10000) {
			return 1;
		}else if(score >= 7500) {
			return 1;
		}else if(score > 5000) {
			return 2;
		}else {
			return 2;
		}
	}
}
