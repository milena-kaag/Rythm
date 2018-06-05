import java.awt.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class MyListener   {
    //La classe la plus englobante du programme !
    CardLayout c1 = new CardLayout();
    String[] listContent = {"HOME", "CHARA","MAP","SCORE","INFOS"};//Liste qui permet de s'y retrouver dans les indices du cardlayout

    JPanel cards = new JPanel(c1); //Panneau qui regroupe l'ensemble des panneaux
    PHome home = new PHome(); //menu d'accueil
    PChara chara = new PChara();//menu sélection des persos
    PMap map = new PMap(); //menu sélection de la map (musique)
    PScore scores;
    PHome.PInfos infos = home.new PInfos();
    FenetreM theWindow = new FenetreM(); //La Fenêtre qui recevra les panneaux et les affichera

    Score score1 = new Score(1);
    Score score2 = new Score(2);
    Personnage[] joueurs = new Personnage[2];
    int creationPersos = 0;




    public MyListener() {

        cards.add(home, listContent[0]);
        cards.add(chara,listContent[1]);
        cards.add(map, listContent[2]);
        cards.add(infos,listContent[4]);
        theWindow.setContentPane(cards);
        theWindow.setVisible(true);



        home.bouton2.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    c1.show(cards,listContent[4]);

            }
        });
        home.bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.show(cards, listContent[1]);
            }
        });
        infos.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.show(cards, listContent[0]);
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
                creationPersos = addPerso(joueurs, "Miku", c1, cards,chara,creationPersos);
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

                creationPersos=addPerso(joueurs, "Akatsuki", c1, cards,chara,creationPersos);
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

                creationPersos=addPerso(joueurs, "Hatsuse", c1, cards,chara,creationPersos);
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

                creationPersos=addPerso(joueurs, "Kanna", c1, cards,chara,creationPersos);
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

                creationPersos= addPerso(joueurs, "Konata", c1, cards,chara,creationPersos);
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

                creationPersos=addPerso(joueurs, "Mercury", c1, cards,chara,creationPersos);
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
                //Lance la Map
                Rythm.mapType = 0;
                Rythm.launchTheGame = true;
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
                Rythm.mapType = 1;
                Rythm.launchTheGame = true;
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
                Rythm.mapType = 5;
                Rythm.launchTheGame = true;
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
                Rythm.mapType = 2;
                Rythm.launchTheGame = true;
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
                Rythm.mapType = 6;
                Rythm.launchTheGame = true;
            }
        });
        map.bonetrousle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[6]);
            }
            public void mouseExited(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[0]);
            }
            public void mouseClicked (MouseEvent e){
                //Lance map
                Rythm.mapType = 3;
                Rythm.launchTheGame = true;
            }
        });
        map.asgore.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[7]);
            }
            public void mouseExited(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[0]);
            }
            public void mouseClicked (MouseEvent e){
                //Lance map
                Rythm.mapType = 7;
                Rythm.launchTheGame = true;
            }
        });
        map.bergentruckung.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[8]);
            }
            public void mouseExited(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[0]);
            }
            public void mouseClicked (MouseEvent e){
                //Lance map
                Rythm.mapType = 4;
                Rythm.launchTheGame = true;
            }
        });
        }



    public static int addPerso(Personnage[] persos, String nameChara, CardLayout c, JPanel cards, PChara chara, int creationPersos){
        if (creationPersos==0) {
            Personnage J1 = new Personnage(nameChara);
            persos[0] =J1;
            chara.PCharaBlanc.remove(chara.persoJ1);
            chara.PCharaBlanc.add(chara.persoJ2,BorderLayout.NORTH);
        } else if (creationPersos==1){
            Personnage J2 = new Personnage(nameChara);
            persos[1]=J2;
            c.next(cards);
        } else{
            c.next(cards);
        }
        creationPersos++;
        return creationPersos;
    }

    public static void launchMap(SongClass map, Fenetre fenetre, Score score1, Score score2) { // Lance la map sélectionnée

        fenetre.setGameScreen(map.BGfileName, (int)(600/map.vitesseDefilement));
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
        try {
            musique = AudioSystem.getClip();
            musique.open(AudioSystem.getAudioInputStream(new File(map.musicFileName)));
            musique.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

        try { // On attend pour passer l'offset
            Thread.sleep((long)(map.offset-map.vitesseDefilement*map.beatDuration));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Boucle qui dure pendant la map
        int beatNB = 1;
        int[] avancement = new int[4];
        for(int i=-map.vitesseDefilement; i<(map.duree*1000/map.beatDuration); i++) {

            affichageInfos(map, i, beatNB, musique, score1, score2, fenetre);



            for(int note=0; note<20; note++) { // Un chti bruit a chaque note qui arrive au point où il faut appuyer
                if (fenetre.getNotesOnScreen()[note].y == 545) {
                    hitsound.stop();
                    hitsound.setMicrosecondPosition(0);
                    hitsound.start();
                }
            }

            for(int colonne=0; colonne<4; colonne++) { // On place les nouvelles notes
                if (map.beats[colonne][avancement[colonne]][0] == beatNB) {
                    fenetre.spawnNote(colonne, findSpace(fenetre), map.beats[colonne][avancement[colonne]][1]);
                    avancement[colonne]++;
                }
            }



            beatNB++;
            fenetre.waitForNextBeat(map, 15, i*map.beatDuration + map.offset - musique.getMicrosecondPosition()/1000, score1, score2);
            //confirmation();
        }

        score1.calculComboMax();
        score2.calculComboMax();
        System.out.println(score1.combos + " " + score2.combos);

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

    public class PScore extends JPanel {

        GridLayout g1 = new GridLayout(12, 3, 8, 8);
        Bouton next = new Bouton ("Suivant","Ressources/fondBoutonR.jpg");
        Image life;
        Clip song;
        Clip applause;
        Clip sectionPass;


        PScore (){
            try {
                applause = AudioSystem.getClip();
                applause.open(AudioSystem.getAudioInputStream(new File("Ressources/Applause sound effect.wav")));
                applause.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }


            try {
                song = AudioSystem.getClip();
                song.open(AudioSystem.getAudioInputStream(new File("Ressources/Victory Theme.wav")));
                song.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
            this.setLayout(g1);
            score1.calculAcc();
            score1.calculScore();
            score1.calculComboMax();
            score2.calculAcc();
            score2.calculScore();
            score2.calculComboMax();
            score1.calculDegats(joueurs[0],joueurs[1]);
            score2.calculDegats(joueurs[1],joueurs[0]);
            joueurs[0].finPartie(score1);
            joueurs[1].finPartie(score2);
            joueurs[0].gestionPv(joueurs[1]);

            try{
                life = ImageIO.read(new File("Ressources/life.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }



            if((joueurs[0].pv > 0)&&(joueurs[1].pv > 0)){
                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        c1.show(cards,listContent[2]);
                        scores=null;
                        score1.getToInit();
                        score2.getToInit();
                        applause.stop();
                        song.stop();
                    }
                });

            } else {
                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            applause.stop();
                            song.stop();
                            sectionPass = AudioSystem.getClip();
                            sectionPass.open(AudioSystem.getAudioInputStream(new File("Ressources/sectionpass.wav")));
                            sectionPass.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException f) {
                            f.printStackTrace();
                        }
                        System.exit(0);
                        scores = null;
                    }
                });
            }
            for(int i=0;i<34;i++){
                this.add(Box.createGlue());
            }
            this.add(next);
        }

        public void paintComponent(Graphics g) {
            Image img=null;
            try{
                img = ImageIO.read(new File("Ressources/score.png"));
            }catch (IOException e){
                e.printStackTrace();
            }
            g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
            Font police = new Font("Tahoma", Font.BOLD, 25);
            g.setFont(police);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(score1.points),80,160);
            g.drawString(String.valueOf((double)Math.round(score1.acc*100)/(100)),80,250);
            g.drawString(String.valueOf(score1.combos),80,340);
            g.drawString(String.valueOf(score1.degats),80,445);

            g.drawString(String.valueOf(score2.points),500,160);
            g.drawString(String.valueOf((double)Math.round(score2.acc*100)/(100)),500,250);
            g.drawString(String.valueOf(score2.combos),500,340);
            g.drawString(String.valueOf(score2.degats),500,445);

            if (joueurs[0].pv>0) {
                g.drawImage(life, 92, 517, (joueurs[0].pv * 200) / joueurs[0].maxPv, 22, this);
            }
            if(joueurs[1].pv>0){
                g.drawImage(life,498,517,(joueurs[1].pv*200)/joueurs[1].maxPv,22,this);

            }

        }

    }
}
