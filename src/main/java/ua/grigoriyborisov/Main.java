package ua.grigoriyborisov;

import ua.grigoriyborisov.downloader.Downloader;
import ua.grigoriyborisov.tester.NotConnectedToInterwebzException;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            final Downloader downloader = new Downloader(new URL("http://www.google.com"));
            downloader.begin();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
