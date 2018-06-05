
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Clavier implements KeyListener {

    Fenetre fenetre;
    Clip hitsound = null;
    Score score1, score2;
    int palier300 = 40;
    int palier100 = 60;
    int palier50 = 80;
    int palier0 = 140;

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

    public void keyReleased(KeyEvent e){ // Ce qu'il se passe quand on relache une touche du clavier
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

    public void keyPressManager(int colonne){ // Gere la pression d'une touche en fonction de la colonne associee
        if(this.fenetre.jeSuislePan.keysPressed[colonne] < 7){
            accCheck(colonne%4, 1 + colonne/4);
            hitsound.stop();
            hitsound.setMicrosecondPosition(0);
            hitsound.start();
        }
        this.fenetre.gameKeyboard(colonne);
    }

    public int keyReleaseManager(int colonne){ // Gere le relachement d'une touche en fonction de la colonne associee
        for(int i=0; i<this.fenetre.getNotesOnScreen().length; i++){
            if((this.fenetre.getNotesOnScreen()[i].colonne == colonne%4) && (this.fenetre.getNotesOnScreen()[i].duree != 0)) {
                if (colonne < 4) {
                    accCheckSlider(1, i);
                    return 0;
                } else {
                    accCheckSlider(2, i);
                    return 0;
                }
            }
        }
        return 0;
    }

    public int accCheck (int colonne, int player){ // Calcule le score d'un cercle en fonction du timing. Du meilleur au moins bon : 300, 100, 50, 0
        for(int i=0; i<this.fenetre.getNotesOnScreen().length; i++){
            if((this.fenetre.getNotesOnScreen()[i].colonne == colonne)&&(this.fenetre.getNotesOnScreen()[i].y < 540 + palier0)&&(this.fenetre.getNotesOnScreen()[i].y > 540 - palier0)){
                if((this.fenetre.getNotesOnScreen()[i].y-540 <= palier300)&&(this.fenetre.getNotesOnScreen()[i].y-540 >= -palier300)){
                    if(this.fenetre.getNotesOnScreen()[i].duree == 0) {
                        circle(player, 300, i);
                        this.fenetre.addScoreEffect(colonne, player, 300);
                        return 0;
                    } else {
                        sliderStart(300, i, player);
                        return 0;
                    }
                } else {
                    if((this.fenetre.getNotesOnScreen()[i].y-540 <= palier100)&&(this.fenetre.getNotesOnScreen()[i].y-540 >= -palier100)){
                        if(this.fenetre.getNotesOnScreen()[i].duree == 0) {
                            circle(player, 100, i);
                            this.fenetre.addScoreEffect(colonne, player, 100);
                            return 0;
                        } else {
                            sliderStart(100, i, player);
                            return 0;
                        }
                    } else {
                        if ((this.fenetre.getNotesOnScreen()[i].y - 540 <= palier50) && (this.fenetre.getNotesOnScreen()[i].y - 540 >= -palier50)) {
                            if (this.fenetre.getNotesOnScreen()[i].duree == 0) {
                                circle(player, 50, i);
                                this.fenetre.addScoreEffect(colonne, player, 50);
                                return 0;
                            } else {
                                sliderStart(50, i, player);
                                return 0;
                            }
                        } else {
                            if ((this.fenetre.getNotesOnScreen()[i].y - 540 <= palier0) && (this.fenetre.getNotesOnScreen()[i].y - 540 >= -palier0)) {
                                if (this.fenetre.getNotesOnScreen()[i].duree == 0) {
                                    circle(player, 0, i);
                                    this.fenetre.addScoreEffect(colonne, player, 0);
                                    return 0;
                                } else {
                                    sliderStart(0, i, player);
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public void circle(int player, int score, int i){ // Gere la suppression d'une note cliquee de l'ecran et le lien avec l'objet score
        if((player == 1)&&(this.fenetre.getNotesOnScreen()[i].x1 != 1000)) {
            this.fenetre.getNotesOnScreen()[i].x1 = 1000;
            this.fenetre.getNotesOnScreen()[i].hitByP1 = true;
            this.score1.addNote( score);
        }
        if((player == 2)&&(this.fenetre.getNotesOnScreen()[i].x2 != 1000)){
            this.fenetre.getNotesOnScreen()[i].x2 = 1000;
            this.fenetre.getNotesOnScreen()[i].hitByP2 = true;
            this.score2.addNote( score);
        }
    }

    public void accCheckSlider(int player, int i){ // Verifie si on est au debut ou a la fin d'un slider
        if(((player == 1)&&(!this.fenetre.getNotesOnScreen()[i].hitByP1)) || ((player == 2)&&(!this.fenetre.getNotesOnScreen()[i].hitByP2))) {
            if ((this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 <= palier300) && (this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 >= -palier300)) {
                sliderEnd(player, 300, i);
                hitsound.stop();
                hitsound.setMicrosecondPosition(0);
                hitsound.start();
            } else {
                if ((this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 <= palier100) && (this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 >= -palier100)) {
                    sliderEnd(player, 100, i);
                    hitsound.stop();
                    hitsound.setMicrosecondPosition(0);
                    hitsound.start();
                } else {
                    if ((this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 <= palier50) && (this.fenetre.getNotesOnScreen()[i].y - this.fenetre.getNotesOnScreen()[i].duree * this.fenetre.getSliderLength() - 540 >= -palier50)) {
                        sliderEnd(player, 50, i);
                        hitsound.stop();
                        hitsound.setMicrosecondPosition(0);
                        hitsound.start();
                    } else {
                        if(player == 1){
                            this.fenetre.getNotesOnScreen()[i].preScore1 = 50;
                        } else {
                            this.fenetre.getNotesOnScreen()[i].preScore2 = 50;
                        }
                    }
                }
            }
        }
    }

    public void sliderStart(int score, int i, int player){ // Gere le clic de debut d'un slider
        if(player == 1){
            this.fenetre.getNotesOnScreen()[i].preScore1 = score;
        } else {
            this.fenetre.getNotesOnScreen()[i].preScore2 = score;
        }
    }

    public void sliderEnd(int player, int score, int i){ // Gere la suppression d'un slider termine de l'ecran et le lien avec l'objet score
        if(this.fenetre.getNotesOnScreen()[i].x1 != 1000) {
            int scoreFinal = 0;
            if (player == 1) {
                if ((this.fenetre.getNotesOnScreen()[i].preScore1 <= 50) || (score <= 50)) {
                    scoreFinal = 50;
                }
                if ((this.fenetre.getNotesOnScreen()[i].preScore1 >= 100) && (score >= 100)) {
                    scoreFinal = 300;
                }
                if ((this.fenetre.getNotesOnScreen()[i].preScore1 == 100) && (score == 100)) {
                    scoreFinal = 100;
                }
                this.fenetre.getNotesOnScreen()[i].x1 = 1000;
                this.fenetre.getNotesOnScreen()[i].hitByP1 = true;
                this.score1.addNote(scoreFinal);
                this.fenetre.addScoreEffect(this.fenetre.getNotesOnScreen()[i].colonne, player, scoreFinal);
            }
        }
        if(this.fenetre.getNotesOnScreen()[i].x2 != 1000) {
            int scoreFinal = 0;
            if (player == 2) {
                if ((this.fenetre.getNotesOnScreen()[i].preScore2 <= 50) || (score <= 50)) {
                    scoreFinal = 50;
                }
                if ((this.fenetre.getNotesOnScreen()[i].preScore2 >= 100) && (score >= 100)) {
                    scoreFinal = 300;
                }
                if ((this.fenetre.getNotesOnScreen()[i].preScore2 == 100) && (score == 100)) {
                    scoreFinal = 100;
                }
                this.fenetre.getNotesOnScreen()[i].x2 = 1000;
                this.fenetre.getNotesOnScreen()[i].hitByP2 = true;
                this.score2.addNote(scoreFinal);
                this.fenetre.addScoreEffect(this.fenetre.getNotesOnScreen()[i].colonne, player, scoreFinal);
            }
        }
    }

}

