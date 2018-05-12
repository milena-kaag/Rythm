import javax.swing.*;

//Classe qui définit la fenêtre en elle-même (le cadre)

public class Fenetre extends JFrame {

    public Fenetre(){
        this.setTitle("Jeu vidéal");
        this.setSize(816,642);
        this.setLocationRelativeTo(null); //Fenêtre se place au milieu de l'écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Le programme s'arrête quand le fenêtre est fermée
        this.setResizable(false); // On ne peut pas changer la taille de la fenêtre. Sinon problèmes d'affichage
        this.setAlwaysOnTop(true); // La fenêtre sera toujours au premier plan

    }

}


