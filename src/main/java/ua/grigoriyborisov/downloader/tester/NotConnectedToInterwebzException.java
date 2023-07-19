package ua.grigoriyborisov.downloader.tester;

public class NotConnectedToInterwebzException extends Exception {
    public NotConnectedToInterwebzException(Exception exception) {
        super(exception.getMessage());
    }
}
