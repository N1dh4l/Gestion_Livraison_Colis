package emploi.com.tn.exceptions;

public class UserNotFoundException extends RuntimeException{

	public  UserNotFoundException(String message) {
		super(message);
	}
}
