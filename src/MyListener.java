import java.awt.*;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

public class MyListener {
    //La classe la plus englobante du programme !
    CardLayout c1 = new CardLayout();
    String[] listContent={"HOME"};//Liste qui permet de s'y retrouver dans les indices du cardlayout

    JPanel cards = new JPanel(c1); //Panneau qui regroupe l'ensemble des panneaux
    PHome home = new PHome(); //menu d'accueil
    Fenetre theWindow = new Fenetre(); //La Fenêtre qui recevra les panneaux et les affichera


    public MyListener(){
        cards.add(home, listContent[0]);
        theWindow.setContentPane(cards);
        theWindow.setVisible(true);


    }
}
