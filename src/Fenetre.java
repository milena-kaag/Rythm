
import javax.swing.*;


public class Fenetre extends JFrame {

    Panneau jeSuislePan = null;

    public Fenetre() {
        // Paramètres de la fenêtre
        this.setTitle("Super jeu vidéal de ouf");
        this.setSize(816, 642);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
    }

    public void setGameScreen (String BGfilename, int sliderLength) { // Set l'écran de jeu au début d'une map
        jeSuislePan = new Panneau(BGfilename); // Panneau appartenant à la fenêtre, c'est lui qui affiche les graphismes
        jeSuislePan.sliderLength = sliderLength;
        this.setContentPane(jeSuislePan);
        this.setVisible(true);
    }

    public void waitForNextBeat(SongClass map, int vitesse, double tempsAAttendre, Score score1, Score score2){ // Méthode qui rafraîchit l'image en faisant avancer les notes entre 2 rythmes
        //int s = 0;
        double temps = tempsAAttendre;
        if(temps < 0){
            temps = 0;
        }
        //System.out.println(temps);
        for(int i=0; i<600/(map.vitesseDefilement*vitesse); i++) { // Effectue un certain nombre de rafraîchissements en mettant à jour la position des notes, pour créer une fluidité
            jeSuislePan.updateNotes(vitesse, score1, score2);
            jeSuislePan.repaint();
            try {
                Thread.sleep((long) (temps*map.vitesseDefilement*vitesse/600));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //s+=(temps*map.vitesseDefilement*vitesse/600);
        }
        /*try { // On ajoute le temps perdu en imprécisions au-dessus (on ne peut attendre qu'un nombre entier de ms)
            Thread.sleep((long) (map.beatDuration-s));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //System.out.println(s);
    }

    public void spawnNote (int colonne, int note, int duree) { // Place les nouvelles notes au bon endroit
        jeSuislePan.notesOnScreen[note].colonne = colonne;
        jeSuislePan.notesOnScreen[note].x1 = 120+60*(colonne);
        jeSuislePan.notesOnScreen[note].x2 = 440+60*(colonne);
        jeSuislePan.notesOnScreen[note].y = -55;
        jeSuislePan.notesOnScreen[note].duree = duree;
        jeSuislePan.notesOnScreen[note].dureeRestante = duree;
        jeSuislePan.notesOnScreen[note].score1 = 0;
        jeSuislePan.notesOnScreen[note].hitByP1 = false;
        jeSuislePan.notesOnScreen[note].hitByP2 = false;
    }

    public Note[] getNotesOnScreen (){
        return this.jeSuislePan.notesOnScreen;
    }

    public int getSliderLength (){
        return jeSuislePan.sliderLength;
    }

    public void gameKeyboard (int key){ // Transmet au panneau les informations sur les touches pressées
        jeSuislePan.keysPressed[key] = 10;
    }

    public void addScoreEffect(int colonne, int joueur, int points){
        jeSuislePan.scoreEffets[colonne + 4*(joueur-1)][0] = 12;
        jeSuislePan.scoreEffets[colonne + 4*(joueur-1)][1] = points;
    }

}