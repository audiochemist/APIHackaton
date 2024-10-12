package exceptions;

public class InvalidActivityDataException extends RuntimeException {
    public InvalidActivityDataException(String message) {
        super(message);
    }
}