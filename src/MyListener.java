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
    //La classe qui gère tout l'affichage et récupère les actions du joueur dans les menus
    CardLayout c1 = new CardLayout(); //Element principal de la classe qui permet de se faire succéder les différents panneaux de sélection
    String[] listContent = {"HOME", "CHARA","MAP","SCORE","INFOS","WINNER"}; //Liste qui permet de s'y retrouver dans les indices du cardlayout

    JPanel cards = new JPanel(c1); //Panneau qui regroupe l'ensemble des panneaux
    private PHome home = new PHome(); //menu d'accueil
    private PChara chara = new PChara(); //menu sélection des persos
    private PMap map = new PMap(); //menu sélection de la map (musique)
    PScore scores; //menu qui affiche les scores, recréé à chaque fois
    private PHome.PInfos infos = home.new PInfos(); //menu qui affiche des instructions à propos du jeu
    FenetreM theWindow = new FenetreM(); //La Fenêtre qui recevra les panneaux et les affichera

    Score score1 = new Score(1);
    Score score2 = new Score(2);
    private Personnage[] joueurs = new Personnage[2];
    private int creationPersos = 0;




    MyListener() {

        cards.add(home, listContent[0]);
        cards.add(chara,listContent[1]);
        cards.add(map, listContent[2]);
        cards.add(infos,listContent[4]);
        theWindow.setContentPane(cards);
        theWindow.setVisible(true);


//Boutons du menu d'accueil
        home.bouton2.addActionListener(new ActionListener() {
            @Override //Permet de redéfinir une méthode, mais avec une syntaxe simplifiée (pas besoin de rédiger tout ce qui est signature de la méthode)
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


//Boutons de sélection des persos
        chara.BMiku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { //Action quand la souris entre dans la zone du bouton
                chara.cChara.show(chara.cardsChara,chara.listContent[1]); //Affiche l'image correspondant au personnage
            }
            public void mouseExited (MouseEvent e) { //Action quand la souris quitte la zone du bouton
                chara.cChara.show(chara.cardsChara,chara.listContent[0]);
            }
            public void mouseClicked (MouseEvent e) { //Action quand on clique sur le bouotn
                creationPersos = addPerso(joueurs, "Miku", c1, cards,chara,creationPersos); //Crée l'objet personnage
            }
        });
        chara.BAka.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {


                chara.cChara.show(chara.cardsChara,chara.listContent[2]);

            }
            public void mouseExited (MouseEvent e) {
                Rhythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
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
                Rhythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
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
                Rhythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
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
                Rhythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
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
                Rhythm.start.chara.cChara.show(chara.cardsChara,chara.listContent[0]);
            }
            public void mouseClicked (MouseEvent e) {

                creationPersos=addPerso(joueurs, "Mercury", c1, cards,chara,creationPersos);
            }
        });


//Boutons de sélection des maps
        map.firstMap.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[1]); //Titres et informations concernant la map
            }
            public void mouseExited(MouseEvent e) {
                map.cMap.show(map.cardsMap, map.listMap[0]);
            }
            public void mouseClicked (MouseEvent e){
                //Lance la Map
                Rhythm.mapType = 0;
                Rhythm.launchTheGame = true;
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
                Rhythm.mapType = 1;
                Rhythm.launchTheGame = true;
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
                Rhythm.mapType = 5;
                Rhythm.launchTheGame = true;
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
                Rhythm.mapType = 2;
                Rhythm.launchTheGame = true;
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
                Rhythm.mapType = 6;
                Rhythm.launchTheGame = true;
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
                Rhythm.mapType = 3;
                Rhythm.launchTheGame = true;
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
                Rhythm.mapType = 7;
                Rhythm.launchTheGame = true;
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
                Rhythm.mapType = 4;
                Rhythm.launchTheGame = true;
            }
        });
        }



    private static int addPerso(Personnage[] persos, String nameChara, CardLayout c, JPanel cards, PChara chara, int creationPersos){
        //Test s'il y a déjà un personnage existant
        if (creationPersos==0) {
            Personnage J1 = new Personnage(nameChara);
            persos[0] =J1; //Tableaux contenant les persos
            chara.PCharaBlanc.remove(chara.persoJ1); //Change l'instruction "J1 choisissez perso" en "J2 Joisissez perso"
            chara.PCharaBlanc.add(chara.persoJ2,BorderLayout.NORTH);
        } else {
            Personnage J2 = new Personnage(nameChara);
            persos[1]=J2;
            c.next(cards); //Passe à l'écran de sélection des maps
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

        //On joue la musique
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





            for(int note=0; note<20; note++) { // Un bruit à chaque note qui arrive au point où il faut appuyer
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
    }

    private static int findSpace(Fenetre fenetre) { // Cherche un emplacement dans le tableau des notes pas encore occupé pour en placer une nouvelle
        int k = 0;
        while ((!fenetre.getNotesOnScreen()[k].hitByP1) && (!fenetre.getNotesOnScreen()[k].hitByP2)) {
            k++;
        }
        return k;

    }


    public class PScore extends JPanel { //Panneau affichant les scores. Placé ici pour hériter des variables du MyListener

        GridLayout g1 = new GridLayout(12, 3, 8, 8);
        Bouton next = new Bouton ("Suivant","Ressources/fondBoutonR.jpg");
        Image life; //Barre de vie
        Clip song;
        Clip applause;
        Clip sectionPass;
        PJwins winScreen;



        PScore(){
//Effets sonores
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


//On ajoute le bouton au panneau
            this.setLayout(g1);
            for(int i=0;i<34;i++){
                this.add(Box.createGlue());
            }
            this.add(next);

//Calcul des différentes valeurs de jeu liées aux deux personnages
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


//Test la vie des deux personnage : situation de milieu de partie ou de fin de partie ?
            if((joueurs[0].pv > 0)&&(joueurs[1].pv > 0)){
                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        scores=null; //Retire le pointeur de l'objet scores pour qu'il soit à therme détruit par le garbage collector
                        score1.getToInit(); //Remet les valeurs de combos, scores,... à zéro
                        score2.getToInit();
                        applause.stop();
                        song.stop();
                        c1.show(cards,listContent[2]); //Milieu de partie : le bouton fait retourner à l'écran de sélection des maps
                    }
                });
            } else {
                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        applause.stop();
                        song.stop();
                        if(joueurs[0].pv>joueurs[1].pv){ //Si le joueur 1 gagne
                            winScreen = new PJwins(1);
                        }else{
                            winScreen = new PJwins(2); //Si le joueur 2 gagne
                        }
                        cards.add(winScreen,listContent[5]);
                        c1.show(cards,listContent[5]);

                        try {
                            sectionPass = AudioSystem.getClip();
                            sectionPass.open(AudioSystem.getAudioInputStream(new File("Ressources/sectionpass.wav")));
                            sectionPass.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }

                        Thread t = new Thread(){
                            public void run(){ //Sleep placé dans une thread différente pour ne pas bloquer l'affichage de winScreen
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException f) {
                                    f.printStackTrace();
                                }
                                System.exit(0); //Fin du programme
                            }
                        };
                        t.start();
                    }
                });
            }
        }

        public void paintComponent(Graphics g) {

//Image de fond
            Image img=null;
            try{
                img = ImageIO.read(new File("Ressources/score.png"));
            }catch (IOException e){
                e.printStackTrace();
            }
            g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);

//Affichage des valeurs de jeu
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

//Affichage de la barre de vie
            if (joueurs[0].pv>0) {
                g.drawImage(life, 92, 518, (joueurs[0].pv * 200) / joueurs[0].maxPv, 22, this);
            }
            if(joueurs[1].pv>0){
                g.drawImage(life,497,518,(joueurs[1].pv*200)/joueurs[1].maxPv,22,this);
            }
        }

        public class PJwins extends JPanel{ //Panneau qui affiche juste l'image de victoire

            Image winner;

            PJwins(int vainqueur){
                if (vainqueur ==1){
                    try{
                        winner = ImageIO.read(new File("Ressources/J1Wins.png"));
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }else{
                    try{
                        winner = ImageIO.read(new File("Ressources/J2Wins.png"));
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

            }
            public void paintComponent(Graphics g){
                g.drawImage(winner,0,0,this.getWidth(),this.getHeight(),this);
            }
        }
    }
}
