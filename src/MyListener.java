import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.CardLayout;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class MyListener   {
    //La classe la plus englobante du programme !
    CardLayout c1 = new CardLayout();
    String[] listContent = {"HOME", "CHARA","MAP"};//Liste qui permet de s'y retrouver dans les indices du cardlayout

    JPanel cards = new JPanel(c1); //Panneau qui regroupe l'ensemble des panneaux
    PHome home = new PHome(); //menu d'accueil
    PChara chara = new PChara();//menu sélection des persos
    PMap map = new PMap(); //menu sélection de la map (musique)
    FenetreM theWindow = new FenetreM(); //La Fenêtre qui recevra les panneaux et les affichera




    public MyListener() {

        cards.add(home, listContent[0]);
        cards.add(chara,listContent[1]);
        cards.add(map, listContent[2]);
        theWindow.setContentPane(cards);
        theWindow.setVisible(true);

        ArrayList joueurs = new ArrayList();

        home.bouton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rythm.mapType = 2;
                Rythm.launchTheGame = true;
            }
        });
        home.bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.show(cards, listContent[1]);
            }
        });

        chara.BMiku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                chara.cChara.show(chara.cardsChara,chara.listContent[1]);
            }
            public void mouseExited (MouseEvent e) {
                chara.cChara.show(chara.cardsChara,chara.listContent[0]);
            }
            public void mouseClicked (MouseEvent e) {
                addPerso(joueurs, "Miku", c1, cards,chara);
            }
        });
        chara.BAka.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {


                chara.cChara.show(chara.cardsChara,chara.listContent[2]);

            }
            public void mouseExited (MouseEvent e) {
                Rythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
            }
            public void mouseClicked (MouseEvent e) {
                addPerso(joueurs, "Akatsuki", c1, cards,chara);
            }
        });
        chara.BHatsuse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               chara.cChara.show(chara.cardsChara,chara.listContent[3]);

            }
            public void mouseExited (MouseEvent e) {
                Rythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
            }
            public void mouseClicked (MouseEvent e) {
                addPerso(joueurs, "Hatsuse", c1, cards,chara);
            }
        });
        chara.BKanna.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                chara.cChara.show(chara.cardsChara,chara.listContent[6]);

            }
            public void mouseExited (MouseEvent e) {
                Rythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
            }
            public void mouseClicked (MouseEvent e) {
                addPerso(joueurs, "Kanna", c1, cards,chara);
            }
        });
        chara.BKonata.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                chara.cChara.show(chara.cardsChara,chara.listContent[4]);

            }
            public void mouseExited (MouseEvent e) {
                Rythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
            }
            public void mouseClicked (MouseEvent e) {
                addPerso(joueurs, "Konata", c1, cards,chara);
            }
        });
        chara.BMercury.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                chara.cChara.show(chara.cardsChara,chara.listContent[5]);

            }
            public void mouseExited (MouseEvent e) {
                Rythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
            }
            public void mouseClicked (MouseEvent e) {
                addPerso(joueurs, "Mercury", c1, cards,chara);
            }
        });

        map.firstMap.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[1]);
            }
            public void mouseExited(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[0]);
            }
            public void mouseClicked (MouseEvent e){
                //Lance map
            }
        });
        map.oddsAndEnds.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[2]);
            }
            public void mouseExited(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[0]);
            }
            public void mouseClicked (MouseEvent e){
                //Lance map
            }
        });
        map.himeHime.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[3]);
            }
            public void mouseExited(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[0]);
            }
            public void mouseClicked (MouseEvent e){
                //Lance map
            }
        });
        map.sans.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[4]);
            }
            public void mouseExited(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[0]);
            }
            public void mouseClicked (MouseEvent e){
                //Lance map
            }
        });
        map.sasageyo.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[5]);
            }
            public void mouseExited(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[0]);
            }
            public void mouseClicked (MouseEvent e){
                //Lance map
            }
        });
        }



    public static void addPerso(ArrayList persos, String nameChara, CardLayout c, JPanel cards, PChara chara){
        if (persos.size()==0) {
            Personnage J1 = new Personnage(nameChara);
            persos.add(J1);
            chara.PCharaBlanc.remove(chara.persoJ1);
            chara.PCharaBlanc.add(chara.persoJ2,BorderLayout.NORTH);
        } else if (persos.size()==1){
            Personnage J2 = new Personnage(nameChara);
            persos.add(J2);
            c.next(cards);
        } else{
            c.next(cards);
        }
    }

    public static void launchMap(SongClass map, Fenetre fenetre, Score score1, Score score2) { // Lance la map sélectionnée

        fenetre.setGameScreen(map.BGfileName, (int) (600 / map.vitesseDefilement));
        Clavier clavier = new Clavier(fenetre, score1, score2);
        fenetre.addKeyListener(clavier);

        // On setup un effet sonore
        Clip hitsound = null;
        try {
            hitsound = AudioSystem.getClip();
            hitsound.open(AudioSystem.getAudioInputStream(new File("Ressources/NormalHitclap.wav")));
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

        System.out.println("Playing : " + map.musicFileName); // On joue la musique
        Clip musique = null;
        Clip beatSound = null;
        try {
            musique = AudioSystem.getClip();
            musique.open(AudioSystem.getAudioInputStream(new File(map.musicFileName)));
            musique.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

        try { // On attend pour passer l'offset
            Thread.sleep((long) (map.offset - map.vitesseDefilement * map.beatDuration));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Boucle qui dure pendant la map
        int beatNB = 1;
        int[] avancement = new int[4];
        for (int i = -map.vitesseDefilement; i < (map.duree * 1000 / map.beatDuration); i++) {

            affichageInfos(map, i, beatNB, musique, score1, score2, fenetre);


            for (int note = 0; note < 20; note++) { // Un chti bruit a chaque note qui arrive au point où il faut appuyer
                if (fenetre.getNotesOnScreen()[note].y == 545) {
                    hitsound.stop();
                    hitsound.setMicrosecondPosition(0);
                    hitsound.start();
                }
                if (fenetre.getNotesOnScreen()[note].dureeRestante > 0) {
                    fenetre.getNotesOnScreen()[note].dureeRestante--;
                }
            }

            for (int colonne = 0; colonne < 4; colonne++) { // On place les nouvelles notes
                if (map.beats[colonne][avancement[colonne]][0] == beatNB) {
                    fenetre.spawnNote(colonne, findSpace(fenetre), map.beats[colonne][avancement[colonne]][1]);
                    avancement[colonne]++;
                }
            }

            fenetre.repaint();
            fenetre.getContentPane().repaint();


            beatNB++;
            fenetre.waitForNextBeat(map, 15, i * map.beatDuration + map.offset - musique.getMicrosecondPosition() / 1000, score1, score2);
            //confirmation();
        }
    }

    public static int findSpace(Fenetre fenetre) { // Cherche un emplacement dans le tableau des notes pas encore occupé pour en placer une nouvelle (2 méthodes, laquelle est plus rapide ?)
        int k = 0;
        while ((!fenetre.getNotesOnScreen()[k].hitByP1) && (!fenetre.getNotesOnScreen()[k].hitByP2)) {
            k++;
        }
        return k;
        /*for(int i=0; i<20; i++){
            if(fenetre.getNotesOnScreen()[i].y >= 650){
                return i;
            }
        }
        return 0;*/
    }

    public static void affichageInfos(SongClass map, int i, int beatNB, Clip musique, Score score1, Score score2, Fenetre fenetre) { // Temporaire, affiche des informations pendant l'exécution du jeu pour débug

        // On peut mettre les lignes non désirées dans l'immédiat en commentaire

        //System.out.println("i : " + i + "       beatNB : " + beatNB);
        //System.out.println("Decalage actuel (ms) : " + (musique.getMicrosecondPosition()/1000 - ((beatNB + map.vitesseDefilement)*map.beatDuration)));
        //System.out.println();

        /*for(int j=0; j<20; j++){
            System.out.print(fenetre.getNotesOnScreen()[j].colonne + " " + fenetre.getNotesOnScreen()[j].y + " " + fenetre.getNotesOnScreen()[j].x1 + " " + fenetre.getNotesOnScreen()[j].x2 + "    ");
        }
        System.out.println();*/

        /*for(int j=0; j<score1.avancement; j++){
            System.out.print(score1.notes[j] + " ");
        }
        System.out.println();*/
        /*for(int j=0; j<score1.avancement; j++){
            System.out.print(score2.notes[j] + " ");
        }
        System.out.println();*/

        score1.calculAcc();
        score2.calculAcc();
        System.out.println(score1.acc + " " + score2.acc);

    }
}
