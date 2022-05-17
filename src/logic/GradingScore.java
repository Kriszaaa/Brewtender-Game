package logic;

public class GradingScore {
	public String Grading(int score) {
		if(score == 10000) {
			return "Perfect";
		}else if(score >= 7500) {
			return "Nice try";
		}else if(score > 5000) {
			return "Noob";
		}else {
			return "You better play other games";
		}
	}
}
