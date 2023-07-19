package ua.grigoriyborisov.downloader.tester;

public final class NotConnectedToInterwebzException extends Exception {
    public NotConnectedToInterwebzException(Exception exception) {
        super(exception.getMessage());
    }
}
