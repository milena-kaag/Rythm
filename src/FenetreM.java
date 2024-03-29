import javax.swing.*;

//Classe qui définit la fenêtre en elle-même (le cadre)

public class FenetreM extends JFrame {

    ImageIcon img = new ImageIcon("Ressources/icon.png");

    public FenetreM() {
        this.setTitle("Sweet Girls - Rhythm Project");
        this.setSize(816, 642);
        this.setLocationRelativeTo(null); //Fenêtre se place au milieu de l'écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Le programme s'arrête quand le fenêtre est fermée
        this.setResizable(false); // On ne peut pas changer la taille de la fenêtre. Sinon problèmes d'affichage
        this.setAlwaysOnTop(true); // La fenêtre sera toujours au premier plan
        this.setVisible(true);
        this.setIconImage(img.getImage());
    }
}