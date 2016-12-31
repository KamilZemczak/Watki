package Zadanie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kamil Zemczak
 */
class BombThread implements Runnable {

    private final File file;
    private final int num;

    public BombThread(int num) {
        this.num = num;
        file = new File(System.getProperty("user.dir") + "/plikBombowy" + num + ".bin");
    }

    private void stworzPlik() {
        FileOutputStream fos = null;
        Random rnd = new Random();
        byte[] data = new byte[1024 * 1024];

        rnd.nextBytes(data);

        try {
            fos = new FileOutputStream(file);
            fos.write(data, 0, data.length);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BombThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {

            }
        }
    }

    @Override
    public void run() {
        stworzPlik();
        System.out.println("Wątek " + num + " zakończył działanie.");
    }
}

public class ZipBomb {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new BombThread(i).run();
        }
    }
}
