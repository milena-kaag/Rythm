import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class PHome extends JPanel {

    public Bouton bouton = new Bouton("Jouer", "Ressources/fondBouton.jpg");
    public Bouton bouton2 = new Bouton("Informations","Ressources/fondBouton.jpg");
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


        g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(),this); //L'image est imprimée
    }

    public class PInfos extends JPanel{
        Image img = null;
        Bouton back = new Bouton("Retour", "Ressources/fondBouton.jpg");
        PInfos(){
            try {
                img = ImageIO.read(new File("Ressources/homeFontSelect.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.setLayout(g1);
            for (int i=0;i<29;i++){
                this.add(Box.createGlue());
            }
            this.add(back);
        }
        public void paintComponent(Graphics g){
            g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
        }
    }
}
