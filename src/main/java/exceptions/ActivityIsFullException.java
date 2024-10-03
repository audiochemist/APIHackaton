package exceptions;

public class ActivityIsFullException extends RuntimeException {
    public ActivityIsFullException(String message) {
        super(message);
    }
}
