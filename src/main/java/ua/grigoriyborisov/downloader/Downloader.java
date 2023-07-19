package ua.grigoriyborisov.downloader;

import ua.grigoriyborisov.tester.ITestable;
import ua.grigoriyborisov.tester.NotConnectedToInterwebzException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Downloader implements IDownloader, ITestable {
    private final URL url;
    public Downloader(URL url) {
        this.url = url;
    }
    @Override
    public void test() throws NotConnectedToInterwebzException {
        try {
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Everything is fine");
        } catch (IOException e) {
            System.out.println("Everything is not fine");
            throw new NotConnectedToInterwebzException(e);
        }
    }

    @Override
    public void begin() {
        try {
            this.test();
        } catch (NotConnectedToInterwebzException exception) {
            throw new RuntimeException(exception);
        } finally {
            this.download();
        }
    }

    private void download() {
        System.out.println("Starting download - " + url.getFile());
    }
}
