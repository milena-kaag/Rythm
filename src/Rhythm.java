//Taille fenêtre :816, 642


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Rhythm {
    public static MyListener start; //Classe principale du jeu qui gère la succession des panneaux
    public static boolean launchTheGame = false; // Variable qui indique quand lancer le jeu à proprement parlé.
    public static int mapType; //Indique quelle map lancer
    private static Map map = new Map(); //Création des différentes maps
    private static Fenetre win = null; //Fenêtre qui sert au jeu de rythme



    public static void main(String[] args) {

        start = new MyListener();
        win = new Fenetre();
        win.setVisible(false);


        Clip musique;
        try {
            musique = AudioSystem.getClip();
            musique.open(AudioSystem.getAudioInputStream(new File("Ressources/welcome.wav")));
            musique.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }


        while (true) {                          //Boucle du jeu
            if (!launchTheGame) {
                {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                start.theWindow.setVisible(false);
                win.setVisible(true);
                MyListener.launchMap(map.listMap[mapType], win, start.score1, start.score2); //Lance la map
                launchTheGame = false; //Fin de la phase de jeu

                start.scores = start.new PScore(); //Phase de scores
                start.cards.add(start.scores, start.listContent[3]);
                start.c1.show(start.cards, start.listContent[3]);
                start.theWindow.setVisible(true);
                win.setVisible(false);
            }
        }
    }
}
