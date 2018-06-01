
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
    Image BG = null;
    Image note = null;
    Image slider = null;
    Image keyLight1 = null;
    Image keyLight2 = null;
    Image keyLight3 = null;
    Image keyLight4 = null;
    Image musicBG = null;
    Image hit300 = null;
    Image hit100 = null;
    Image hit50 = null;
    Image hit0 = null;
    Note[] notesOnScreen = new Note[20]; // Tableau regroupant toutes les notes affichées à l'écran à un moment donné (attention max 20, a augmenter si nécessaire)
    int[] keysPressed = new int[8]; // Les touches appuyées par les joueurs à un moment donné et un peu après
    int[][] scoreEffets = new int[8][2]; // Les effets de couleur quand une note est cliquée, en fonction de la valeur en points
    int keyX, sliderLength;

    Panneau(String musicBGfile){
        try { // On charge les images nécessaires au jeu
            this.musicBG = ImageIO.read(new File(musicBGfile));
            this.BG = ImageIO.read(new File("Ressources/BG.png"));
            this.note = ImageIO.read(new File("Ressources/RectangleQuiDescend.png"));
            this.slider = ImageIO.read(new File("Ressources/Slider.png"));
            this.keyLight1 = ImageIO.read(new File("Ressources/KeyLight1.png"));
            this.keyLight2 = ImageIO.read(new File("Ressources/KeyLight2.png"));
            this.keyLight3 = ImageIO.read(new File("Ressources/KeyLight3.png"));
            this.keyLight4 = ImageIO.read(new File("Ressources/KeyLight4.png"));
            this.hit300 = ImageIO.read(new File("Ressources/hit300.png"));
            this.hit100 = ImageIO.read(new File("Ressources/hit100.png"));
            this.hit50 = ImageIO.read(new File("Ressources/hit50.png"));
            this.hit0 = ImageIO.read(new File("Ressources/hit0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // On set les tableaux comme il faut
        for(int i=0; i<20; i++){
            notesOnScreen[i] = new Note(-1);
        }
        for(int i=0; i<8; i++){
            keysPressed[i] = 0;
        }
    }

    public void paintComponent(Graphics g){ // Méthode appelée à chaque fois que l'écran est rafraîchi
        g.drawImage(musicBG, 0, 0, this.getWidth(), this.getHeight(), this);
        g.drawImage(BG, 0, 0, this.getWidth(), this.getHeight(), this);
        for(int i=0; i<8; i++){
            if(keysPressed[i] > 0){ // On affiche les effets visuels quand une touche est appuyée
                keyX = 0;
                if(i>3){
                    keyX += 80;
                }
                keyX += 60*i + 121;
                if(keysPressed[i] <= 2) {
                    g.drawImage(keyLight4, keyX, 545, 59, 58, this);
                }
                if((keysPressed[i] > 2)&&(keysPressed[i] <= 4)) {
                    g.drawImage(keyLight3, keyX, 545, 59, 58, this);
                }
                if((keysPressed[i] > 4)&&(keysPressed[i] <= 7)) {
                    g.drawImage(keyLight2, keyX, 545, 59, 58, this);
                }
                if(keysPressed[i] > 7) {
                    g.drawImage(keyLight1, keyX, 545, 59, 58, this);
                }
                keysPressed[i] -= 1;
            }
        }
        for(int i=0; i<8; i++){
            if(scoreEffets[i][0] > 0){
                if(scoreEffets[i][1] == 300){
                    if(i<4) {
                        g.drawImage(hit300, 60 * i + 120, 543, 59, 34, this);
                    } else {
                        g.drawImage(hit300, 60 * i + 200, 543, 59, 34, this);
                    }
                }
                if(scoreEffets[i][1] == 100){
                    if(i<4) {
                        g.drawImage(hit100, 60 * i + 120, 543, 59, 34, this);
                    } else {
                        g.drawImage(hit100, 60 * i + 200, 543, 59, 34, this);
                    }
                }
                if(scoreEffets[i][1] == 50){
                    if(i<4) {
                        g.drawImage(hit50, 60 * i + 120, 543, 59, 34, this);
                    } else {
                        g.drawImage(hit50, 60 * i + 200, 543, 59, 34, this);
                    }
                }
                if(scoreEffets[i][1] == 0){
                    if(i<4) {
                        g.drawImage(hit0, 60 * i + 120, 543, 59, 34, this);
                    } else {
                        g.drawImage(hit0, 60 * i + 200, 543, 59, 34, this);
                    }
                }
                scoreEffets[i][0] --;
            }
        }
        for(int i=0; i<20; i++) { // On affiche les notes à l'écran
            if(this.notesOnScreen[i].duree == 0) {
                if(this.notesOnScreen[i].y < 650) {
                    g.drawImage(note, this.notesOnScreen[i].x1, this.notesOnScreen[i].y, 59, 30, this);
                    g.drawImage(note, this.notesOnScreen[i].x2, this.notesOnScreen[i].y, 59, 30, this);
                }
            } else {
                g.drawImage(slider, this.notesOnScreen[i].x1 + 10, this.notesOnScreen[i].y + 30 - this.notesOnScreen[i].duree*sliderLength, 39, this.notesOnScreen[i].duree*sliderLength, this);
                g.drawImage(note, this.notesOnScreen[i].x1, this.notesOnScreen[i].y - this.notesOnScreen[i].duree*sliderLength, 59, 30, this);
                g.drawImage(note, this.notesOnScreen[i].x1, this.notesOnScreen[i].y, 59, 30, this);
                g.drawImage(slider, this.notesOnScreen[i].x2 + 10, this.notesOnScreen[i].y + 30 - this.notesOnScreen[i].duree*sliderLength, 39, this.notesOnScreen[i].duree*sliderLength, this);
                g.drawImage(note, this.notesOnScreen[i].x2, this.notesOnScreen[i].y - this.notesOnScreen[i].duree*sliderLength, 59, 30, this);
                g.drawImage(note, this.notesOnScreen[i].x2, this.notesOnScreen[i].y, 59, 30, this);
            }
        }


    }

    public void updateNotes(int vitesse, Score score1, Score score2){ // Méthode qui actualise l'ordonnée des notes entre 2 rafraîchissements
        for(int i=0; i<20; i++){
            this.notesOnScreen[i].y += vitesse;
            if((!this.notesOnScreen[i].hitByP1)&&(this.notesOnScreen[i].colonne != -1)&&(this.notesOnScreen[i].x1 != 1000)&&  (((this.notesOnScreen[i].duree == 0)&&(this.notesOnScreen[i].y > 620)) || ((this.notesOnScreen[i].duree != 0)&&(this.notesOnScreen[i].y > 620 + this.notesOnScreen[i].duree*sliderLength)))){
                if((!this.notesOnScreen[i].hitByP1)&&(this.notesOnScreen[i].preScore1 != 0)){
                    score1.addNote(50);
                    this.scoreEffets[notesOnScreen[i].colonne][0] = 10;
                    this.scoreEffets[notesOnScreen[i].colonne][1] = 50;
                    this.notesOnScreen[i].hitByP1 = true;
                } else {
                    score1.addNote(0);
                    this.scoreEffets[notesOnScreen[i].colonne][0] = 10;
                    this.scoreEffets[notesOnScreen[i].colonne][1] = 0;
                    this.notesOnScreen[i].hitByP1 = true;
                }
            }
            if((!this.notesOnScreen[i].hitByP2)&&(this.notesOnScreen[i].colonne != -1)&&(this.notesOnScreen[i].x2 != 1000)&&  (((this.notesOnScreen[i].duree == 0)&&(this.notesOnScreen[i].y > 620)) || ((this.notesOnScreen[i].duree != 0)&&(this.notesOnScreen[i].y > 620 + this.notesOnScreen[i].duree*sliderLength)))){
                if((!this.notesOnScreen[i].hitByP2)&&(this.notesOnScreen[i].preScore2 != 0)){
                    score2.addNote(50);
                    this.scoreEffets[notesOnScreen[i].colonne + 4][0] = 10;
                    this.scoreEffets[notesOnScreen[i].colonne + 4][1] = 50;
                    this.notesOnScreen[i].hitByP2 = true;
                } else {
                    score2.addNote(0);
                    this.scoreEffets[notesOnScreen[i].colonne + 4][0] = 10;
                    this.scoreEffets[notesOnScreen[i].colonne + 4][1] = 0;
                    this.notesOnScreen[i].hitByP2 = true;
                }
            }
        }
    }

}
