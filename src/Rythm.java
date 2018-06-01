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
    public static Fenetre win = null;



    public static void main(String[] args) {

        start = new MyListener();
        win = new Fenetre();
        win.setVisible(false);



        Clip musique = null;
        try {
            musique = AudioSystem.getClip();
            musique.open(AudioSystem.getAudioInputStream(new File("Ressources/welcome.wav")));
            musique.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

        while (true)
            if(launchTheGame == false) {
                {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else{
                start.theWindow.setVisible(false);
                //SongClass mappy = map.listMap[mapType];
                win.setVisible(true);
                MyListener.launchMap(map.listMap[mapType],win,start.score1,start.score2);
                launchTheGame=false;
                start.scores = start.new PScore();
                start.cards.add(start.scores, start.listContent[3]);
                start.c1.show(start.cards,start.listContent[3]);
                start.theWindow.setVisible(true);
                win.setVisible(false);
            }

        //start.c1.show(start.cards, start.listContent[1]);


//        start.theWindow.setVisible(false);
//        //SongClass mappy = map.listMap[mapType];
//        win.setVisible(true);
//        MyListener.launchMap(map.listMap[mapType],win,start.score1,start.score2);
//        launchTheGame=false;
//        start.scores = start.new PScore();
//        start.cards.add(start.scores, start.listContent[3]);
//        start.c1.show(start.cards,start.listContent[3]);
//        start.theWindow.setVisible(true);
//        win.setVisible(false);
//        win = null;





        }

    }
