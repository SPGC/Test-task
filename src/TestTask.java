import java.io.*;
import java.lang.*;

public class TestTask {
    public static void main(String[] args) throws IOException {
        final int AMOUNT_OF_DATA = 1024 * 1024;
        for (int k = 0; k < 5; k++) {
            FileOutputStream writer = new FileOutputStream("IO.txt");
            Long timer;
            timer = System.currentTimeMillis();
            for (int i = 0; i < AMOUNT_OF_DATA; i++) {
                writer.write('a');
            }
            writer.close();
            timer = System.currentTimeMillis() - timer;
            System.out.println("Writing time of 1 MB of data is " + timer + " milliseconds");
            FileInputStream reader = new FileInputStream("IO.txt");
            timer = System.currentTimeMillis();
            for (int i = 0; i < AMOUNT_OF_DATA; i++) {
                reader.read();
            }
            reader.close();
            timer = System.currentTimeMillis() - timer;
            System.out.println("Reading time of 1 MB of data is " + timer + " milliseconds\n");
        }
    }
}
