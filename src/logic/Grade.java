package logic;

public class Grade {
	public static String grading(int score) {
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
	public static int gradingInt(int score) {
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