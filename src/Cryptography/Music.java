package Cryptography;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {
    static Clip clip = null;
    static int state = 0;

    public void setstream(int status) {
        if (status == 0 && state ==1) {
            clip.stop();
            clip.close();
            System.out.println("stop ho gaya");
            state =0;
        }
        if (status == 1 && state ==0) {
            try {
                // getAudioInputStream() accepts a File or InputStream

                //copy absolute path
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File("F:\\NewA\\CryptoLearn\\src\\Cryptography\\Doc\\bg.wav"));
                clip = AudioSystem.getClip();
                clip.open(ais);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            clip.start();
            System.out.println("play ho raha");
            state = 1;
        }
    }

}
