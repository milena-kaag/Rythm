//Classe qui permet de créer des boutons personnalisés (avec une image de fond)


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bouton extends JButton {
    private String name; //Ce qu'il sera inscrit sur le bouton
    private Image img; //Image de fond

    Bouton(String str, String pathName){
        this.name =str;
        try {
            img = ImageIO.read(new File(pathName)); //bloc try/catch gère les exceptions
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void paintComponent(Graphics g) { //personnalisation du design
        Graphics2D g2d = (Graphics2D) g; // Objet qui permet d'avoir d'avantage de contrôle sur l'affichage 2D
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); // Fond du bouton
        g2d.setColor(Color.black); //Couleur de la police
        Font police = new Font("Ink Free", Font.PLAIN, 20); //Police utilisée pour donner son nom au bouton
        g2d.setFont(police);
        g2d.drawString(this.name, (this.getWidth() / 2 - this.getWidth() / 2 / 4), (this.getHeight() / 2) + 5);//Centrage approximatif du texte au milieu du bouton
    }
}

