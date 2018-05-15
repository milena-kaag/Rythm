
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Clavier implements KeyListener {

    Fenetre fenetre;
    Clip hitsound = null;
    Score score1, score2;

    public Clavier(Fenetre fenetre, Score score1, Score score2){
        this.fenetre = fenetre;
        this.score1 = score1;
        this.score2 = score2;
        try { // On charge un effet sonore pour quand un joueur appuie sur une touche
            hitsound = AudioSystem.getClip();
            hitsound.open(AudioSystem.getAudioInputStream(new File("Ressources/NormalHitclap2.wav")));
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void keyPressed(KeyEvent e){ // Ce qu'il se passe quand on appuie sur une touche du clavier
        if(e.getKeyCode() == KeyEvent.VK_W) {
            keyPressManager(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_X) {
            keyPressManager(1);
        }
        if(e.getKeyCode() == KeyEvent.VK_C) {
            keyPressManager(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_V) {
            keyPressManager(3);
        }
        if(e.getKeyCode() == KeyEvent.VK_J) {
            keyPressManager(4);
        }
        if(e.getKeyCode() == KeyEvent.VK_K) {
            keyPressManager(5);
        }
        if(e.getKeyCode() == KeyEvent.VK_L) {
            keyPressManager(6);
        }
        if(e.getKeyCode() == KeyEvent.VK_M) {
            keyPressManager(7);
        }
    }

    public void keyTyped(KeyEvent e){}

    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W) {
            keyReleaseManager(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_X) {
            keyReleaseManager(1);
        }
        if(e.getKeyCode() == KeyEvent.VK_C) {
            keyReleaseManager(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_V) {
            keyReleaseManager(3);
        }
        if(e.getKeyCode() == KeyEvent.VK_J) {
            keyReleaseManager(4);
        }
        if(e.getKeyCode() == KeyEvent.VK_K) {
            keyReleaseManager(5);
        }
        if(e.getKeyCode() == KeyEvent.VK_L) {
            keyReleaseManager(6);
        }
        if(e.getKeyCode() == KeyEvent.VK_M) {
            keyReleaseManager(7);
        }
    }

    public void keyPressManager(int colonne){
        accCheck(colonne%4, 1 + colonne/4);
        hitsound.stop();
        hitsound.setMicrosecondPosition(0);
        hitsound.start();
        this.fenetre.gameKeyboard(colonne);
    }

    public void keyReleaseManager(int colonne){
        for(int i=0; i<this.fenetre.getNotesOnScreen().length; i++){
            if((this.fenetre.getNotesOnScreen()[i].colonne == colonne) && (this.fenetre.getNotesOnScreen()[i].duree != 0)) {
                if (colonne < 4) {
                    accCheckSlider(1, i);
                    /*if (!this.fenetre.getNotesOnScreen()[i].hitByP1) {
                        this.score1.addNote(50);
                        this.fenetre.getNotesOnScreen()[i].hitByP1 = true;
                    }*/
                } else {
                    accCheckSlider(2, i);
                    /*if (!this.fenetre.getNotesOnScreen()[i].hitByP2) {
                        this.score2.addNote(50);
                        this.fenetre.getNotesOnScreen()[i].hitByP2 = true;
                    }*/
                }
            }
        }
    }

    public void accCheck (int colonne, int player){
        for(int i=0; i<this.fenetre.getNotesOnScreen().length; i++){
            if((this.fenetre.getNotesOnScreen()[i].colonne == colonne)&&(this.fenetre.getNotesOnScreen()[i].y < 620)&&(this.fenetre.getNotesOnScreen()[i].y > 440)){
                if((this.fenetre.getNotesOnScreen()[i].y-540 <= 40)&&(this.fenetre.getNotesOnScreen()[i].y-540 >= -40)){
                    if(this.fenetre.getNotesOnScreen()[i].duree == 0) {
                        circle(player, 300, i);
                        this.fenetre.addScoreEffect(colonne, player, 300);
                    } else {
                        sliderStart(300, i);
                    }
                } else {
                    if((this.fenetre.getNotesOnScreen()[i].y-540 <= 60)&&(this.fenetre.getNotesOnScreen()[i].y-540 >= -60)){
                        if(this.fenetre.getNotesOnScreen()[i].duree == 0) {
                            circle(player, 100, i);
                            this.fenetre.addScoreEffect(colonne, player, 100);
                        } else {
                            sliderStart(100, i);
                        }
                    } else {
                        if((this.fenetre.getNotesOnScreen()[i].y-540 <= 80)&&(this.fenetre.getNotesOnScreen()[i].y-540 >= -80)){
                            if(this.fenetre.getNotesOnScreen()[i].duree == 0) {
                                circle(player, 50, i);
                                this.fenetre.addScoreEffect(colonne, player, 50);
                            } else {
                                sliderStart(50, i);
                            }
                        }
                    }
                }
            }
        }
    }

    public void circle(int player, int score, int i){
        if((player == 1)&&(this.fenetre.getNotesOnScreen()[i].x1 != 1000)) {
            this.fenetre.getNotesOnScreen()[i].x1 = 1000;
            this.fenetre.getNotesOnScreen()[i].hitByP1 = true;
            //this.score1.addNote( score);
        }
        if((player == 2)&&(this.fenetre.getNotesOnScreen()[i].x2 != 1000)){
            this.fenetre.getNotesOnScreen()[i].x2 = 1000;
            this.fenetre.getNotesOnScreen()[i].hitByP2 = true;
            //this.score2.addNote( score);
        }
    }

    public void accCheckSlider(int player, int i){
        if(this.fenetre.getNotesOnScreen()[i].dureeRestante == 0){
            if((this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 <= 40)&&(this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 >= -40)){
                sliderEnd(player, 300, i);
            } else {
                if ((this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 <= 60) && (this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 >= -60)) {
                    sliderEnd(player, 100, i);
                } else {
                    if ((this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 <= 80) && (this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 >= -80)) {
                        sliderEnd(player, 50, i);
                    }
                }
            }
        } else {
            this.fenetre.getNotesOnScreen()[i].score1 = 0;
        }
    }

    public void sliderStart(int score, int i){
        this.fenetre.getNotesOnScreen()[i].score1 = score;
    }

    public void sliderEnd(int player, int score, int i){
        if(this.fenetre.getNotesOnScreen()[i].x1 != 1000) {
            int scoreFinal = 0;
            if ((this.fenetre.getNotesOnScreen()[i].score1 == 0) || (score == 0)) {
                scoreFinal = 50;
            }
            if ((this.fenetre.getNotesOnScreen()[i].score1 == 0) && (score == 0)) {
                scoreFinal = 0;
            }
            if ((this.fenetre.getNotesOnScreen()[i].score1 != 0) && (score != 0)) {
                scoreFinal = 300;
            }
            if (player == 1) {
                this.fenetre.getNotesOnScreen()[i].x1 = 1000;
                this.fenetre.getNotesOnScreen()[i].hitByP1 = true;
                this.score1.addNote(scoreFinal);
            }
            if (player == 2) {
                this.fenetre.getNotesOnScreen()[i].x2 = 1000;
                this.fenetre.getNotesOnScreen()[i].hitByP2 = true;
                this.score2.addNote(scoreFinal);
            }
            this.fenetre.addScoreEffect(this.fenetre.getNotesOnScreen()[i].colonne, player, scoreFinal);
        }
    }

}

