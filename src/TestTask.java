import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class TestTask {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final int MODE = in.nextInt();
        final int AMOUNT_OF_DATA = in.nextInt();
        final int AMOUNT_OF_TESTS = 5;
        Long averageReading = 0L;
        Long averageWriting = 0L;
        Long timer;
        FileOutputStream writer;
        FileInputStream reader;
        if (MODE == 1) {
            for (int k = 0; k < AMOUNT_OF_TESTS; k++) {
                writer = new FileOutputStream("IO.txt");
                for (int i = 0; i < AMOUNT_OF_DATA; i++) {
                    timer = System.nanoTime();
                    writer.write('a');
                    averageWriting += System.nanoTime() - timer;
                }
                writer.close();
                reader = new FileInputStream("IO.txt");
                for (int i = 0; i < AMOUNT_OF_DATA; i++) {
                    timer = System.nanoTime();
                    reader.read();
                    averageReading += System.nanoTime() - timer;
                }
                reader.close();
            }
            System.out.println("Average writing time of " + AMOUNT_OF_DATA + " bytes byte by byte is " + averageWriting / AMOUNT_OF_TESTS + " nanoseconds");
            System.out.println("Average reading time of " + AMOUNT_OF_DATA + " bytes byte by byte is " + averageReading / AMOUNT_OF_TESTS + " nanoseconds\n");
            File file = new File("IO.txt");
            file.delete();
        } else if(MODE == 2) {
            averageReading = 0L;
            averageWriting = 0L;
            byte[] bytes = new byte[AMOUNT_OF_DATA];
            for (int i = 0; i < AMOUNT_OF_TESTS; i++) {
                Arrays.fill(bytes, (byte) 'a');
                writer = new FileOutputStream("IO.txt");
                timer = System.currentTimeMillis();
                writer.write(bytes);
                writer.close();
                averageWriting += System.currentTimeMillis() - timer;
                reader = new FileInputStream("IO.txt");
                timer = System.currentTimeMillis();
                reader.read(bytes);
                reader.close();
                averageReading += System.currentTimeMillis() - timer;
            }
            System.out.println("Average writing time of " + AMOUNT_OF_DATA + " bytes is " + averageWriting / AMOUNT_OF_TESTS + " milliseconds");
            System.out.println("Average reading time of " + AMOUNT_OF_DATA + " bytes is " + averageReading / AMOUNT_OF_TESTS + " milliseconds");
            File file = new File("IO.txt");
            file.delete();
        } else {
            System.out.println("Wrong input");
        }
    }
}
