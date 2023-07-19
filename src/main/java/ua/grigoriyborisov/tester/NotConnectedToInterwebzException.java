package ua.grigoriyborisov.tester;

public class NotConnectedToInterwebzException extends Exception {
    public NotConnectedToInterwebzException(Exception exception) {
        super(exception.getMessage());
    }
}
