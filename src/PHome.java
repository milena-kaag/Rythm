import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class PHome extends JPanel {

    private Bouton bouton = new Bouton("Helloooooo");
    private Bouton bouton2 = new Bouton("Bon");
    GridLayout g1 = new GridLayout(10, 3, 8, 8); //Objet qui permettra d'arranger les objets (boutons) dans l'espace de la fenêtre

    public PHome(){
        this.setLayout(g1);
        for (int i = 0; i < 20; i++) {
            this.add(Box.createGlue());//Objet invisible qui permet de remplir le layout jusqu'à la case d'intéret
        }
        this.add(bouton); // L'objet bouton sera placé dans la 21ème case du layout
        for (int i = 0; i < 5; i++) {
            this.add(Box.createGlue());
        }
        this.add(bouton2);
        this.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        Image img = null;

        {
            try {
                img = ImageIO.read(new File("Ressources/homeBack.jpg"));
            } catch (IOException e) {
                e.printStackTrace(); //Récupérer l'image de fond peut générer une erreur : on entoure la commande d'un bloc try/catch qui peut gérer les exceptions
            }
        }


        g.drawImage(img, 0, 0, this); //L'image est imprimée
    }
}
