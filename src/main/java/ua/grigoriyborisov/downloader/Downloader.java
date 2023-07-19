package ua.grigoriyborisov.downloader;

import ua.grigoriyborisov.downloader.tester.ITestable;
import ua.grigoriyborisov.downloader.tester.NotConnectedToInterwebzException;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public final class Downloader implements IDownloader, ITestable {
    private final URL url; // URL of the file to download (URL файлу для завантаження)
    private final File location; // Location to save the downloaded file (Розташування для збереження завантаженого файлу)

    public Downloader(URL url, File location) {
        this.url = url;
        this.location = location;
    }

    @Override
    public void test() throws NotConnectedToInterwebzException {
        try {
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Everything is fine"); // Everything is working properly (Все працює належним чином)
        } catch (IOException e) {
            System.out.println("Everything is not fine"); // Something went wrong (Виникла помилка)
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
        System.out.println("Starting download - " + url.getFile()); // Початок завантаження - назва файлу з URL
        URL url;
        URLConnection con;
        DataInputStream dis;
        FileOutputStream fos;
        byte[] fileData;
        try {
            url = this.url; // File Location goes here (Місце розташування файлу)
            con = url.openConnection(); // open the url connection (відкриття з'єднання за URL)
            dis = new DataInputStream(con.getInputStream());
            fileData = new byte[con.getContentLength()];
            for (int q = 0; q < fileData.length; q++) {
                fileData[q] = dis.readByte();
                System.out.println("Got byte " + q); // Отримано байт номер + q
            }
            dis.close(); // close the data input stream (закриття потоку введення даних)
            System.out.println("Saving " + location); // Збереження + розташування
            fos = new FileOutputStream(location); // FILE Save Location goes here (Місце збереження файлу)
            System.out.println("Writing to " + location); // Запис у файл + розташування
            fos.write(fileData);  // write out the file we want to save (записуємо файл, який хочемо зберегти).
            System.out.println("Closing stream."); // Закриття потоку
            fos.close(); // close the output stream writer (закриття потоку запису)
        }
        catch(Exception m) {
            System.out.println(m);
        }
    }
}
