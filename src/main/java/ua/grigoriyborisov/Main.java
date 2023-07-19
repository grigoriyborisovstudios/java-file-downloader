package ua.grigoriyborisov;

import ua.grigoriyborisov.downloader.Downloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                final Downloader downloader;
                try {
                    downloader = new Downloader(new URL("http://www.java2s.com/Code/JarDownload/vecmath/vecmath.jar.zip"), new File("vecmath.zip"));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                downloader.begin();
            }
        }.start();
    }
}

