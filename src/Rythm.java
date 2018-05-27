//Taille fenêtre :816, 642


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;

public class Rythm {
    public static MyListener start;
    public static volatile boolean launchTheGame = false;
    public static volatile int mapType;
    public static Map map = new Map();


    public static void main(String[] args) {

        start = new MyListener();

        Clip musique = null;
        try {
            musique = AudioSystem.getClip();
            musique.open(AudioSystem.getAudioInputStream(new File("Ressources/welcome.wav")));
            musique.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

        while (launchTheGame == false)
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        start.c1.show(start.cards, start.listContent[1]);

        Score score1 = new Score(1);
        Score score2 = new Score(2);
        Fenetre win = new Fenetre();
        MyListener.launchMap(map.chichiWoMoge,win,score1,score2);
        start.theWindow.setVisible(false);



        }

    }
