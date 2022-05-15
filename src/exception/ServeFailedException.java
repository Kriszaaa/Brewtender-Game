package exception;

public class ServeFailedException extends Exception{
	private String message;
	
	public ServeFailedException (String message) {
		super(message);
		this.setMessage(message);
	}
	public void printErrormessage() {
		System.out.print(this.message);
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
