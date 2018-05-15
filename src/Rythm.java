//Taille fenêtre :816, 642


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Rythm {
    public static void main(String[] args) {

        MyListener start = new MyListener();
        Clip musique = null;
        try {
            musique = AudioSystem.getClip();
            musique.open(AudioSystem.getAudioInputStream(new File("Ressources/welcome.wav")));
            musique.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}