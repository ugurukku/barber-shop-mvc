package az.millisoft.first.exception;

public class MainNotFoundException extends RuntimeException {
    public MainNotFoundException() {
    }

    public MainNotFoundException(String message) {
        super(message);
    }

    public MainNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
