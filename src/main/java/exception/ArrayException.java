package exception;

public class ArrayException extends Exception {
    public ArrayException() {
        super();
    }

    public ArrayException(String message) {
        super(message);
    }

    public ArrayException(String message, Exception e) {
        super(message, e);
    }

    public ArrayException(Exception e) {
        super(e);
    }
}
