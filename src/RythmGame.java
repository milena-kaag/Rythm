
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner; // Temporaire

public class RythmGame {

    public static void main(String[] args) {

        // Maps hard-codées (à bouger ? Encombrant)
        int[][][] sansBeats = {{{2, 0}, {8, 0}, {16, 0}, {18, 0}, {24, 0}, {29, 2}, {34, 0}, {38, 0}, {43, 0}, {53, 0}, {58, 0}, {62, 0}, {66, 0}, {74, 0}, {79, 0}, {82, 0}, {89, 0}, {93, 0}, {95, 0}, {97, 0}, {104, 0}, {109, 0}, {117, 0}, {122, 0}, {130, 0}, {136, 0}, {139, 0}, {146, 0}, {154, 0}, {158, 0}, {161, 0}, {168, 0}, {172, 0}, {177, 0}, {182, 0}, {186, 0}, {190, 0}, {192, 0}, {194, 0}, {198, 0}, {202, 0}, {206, 0}, {0, 0}},
                                {{5, 0}, {9, 0}, {11, 0}, {15, 0}, {18, 0}, {21, 0}, {25, 0}, {28, 0}, {32, 2}, {37, 0}, {42, 0}, {45, 0}, {49, 0}, {52, 0}, {57, 0}, {61, 0}, {63, 0}, {70, 0}, {75, 0}, {80, 0}, {82, 0}, {86, 0}, {88, 0}, {101, 0}, {105, 0}, {108, 0}, {113, 0}, {116, 0}, {120, 0}, {123, 0}, {127, 0}, {130, 0}, {134, 0}, {137, 0}, {143, 0}, {145, 0}, {148, 0}, {152, 0}, {155, 0}, {159, 0}, {165, 0}, {169, 0}, {173, 2}, {180, 0}, {187, 0}, {0, 0}},
                                {{4, 0}, {10, 0}, {13, 0}, {17, 0}, {22, 0}, {26, 0}, {31, 0}, {36, 0}, {41, 0}, {44, 0}, {48, 0}, {54, 0}, {60, 0}, {64, 0}, {68, 0}, {72, 0}, {77, 2}, {84, 0}, {87, 0}, {91, 0}, {94, 0}, {96, 0}, {100, 0}, {107, 0}, {111, 0}, {114, 0}, {118, 0}, {124, 0}, {128, 2}, {132, 0}, {140, 0}, {144, 0}, {149, 0}, {153, 0}, {156, 0}, {160, 0}, {164, 0}, {170, 0}, {175, 0}, {177, 0}, {180, 0}, {184, 0}, {189, 0}, {191, 0}, {193, 0}, {196, 0}, {200, 0}, {204, 0}, {208, 0}, {0, 0}},
                                {{2, 0}, {6, 0}, {12, 0}, {20, 0}, {27, 0}, {34, 0}, {40, 0}, {47, 0}, {50, 0}, {56, 0}, {59, 0}, {66, 0}, {69, 0}, {76, 0}, {81, 0}, {85, 0}, {90, 0}, {97, 0}, {102, 0}, {106, 0}, {112, 0}, {114, 0}, {121, 0}, {125, 2}, {133, 0}, {138, 0}, {141, 0}, {146, 0}, {150, 0}, {157, 0}, {161, 0}, {166, 0}, {171, 0}, {175, 0}, {178, 0}, {185, 0}, {188, 0}, {0, 0}}};
        SongClass sans = new SongClass(128, 2, 3000, "Files/sans.wav", "Files/sansBG.png", 55, 5, sansBeats);
        int[][][] chichiWoMogeBeats = {{{4, 0}, {14, 0}, {16, 0}, {46, 0}, {62, 0}, {70, 0}, {78, 0}, {94, 0}, {98, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                                        {{2, 0}, {8, 0}, {20, 0}, {26, 0}, {38, 1}, {42, 0}, {54, 0}, {58, 0}, {80, 0}, {92, 0}, {96, 0}, {100, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                                        {{6, 0}, {18, 0}, {24, 0}, {28, 0}, {30, 0}, {36, 1}, {44, 0}, {50, 0}, {56, 0}, {60, 0}, {66, 0}, {72, 0}, {82, 0}, {84, 0}, {90, 0}, {102, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                                        {{10, 0}, {12, 0}, {22, 0}, {34, 1}, {48, 0}, {52, 0}, {64, 0}, {68, 0}, {74, 0}, {76, 0}, {86, 0}, {104, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}};
        SongClass chichiWoMoge = new SongClass(165.2, 1, 6980, "FilesChichiWoMoge.wav", "Files/ChichiWoMogeBG.png", 80, 5, chichiWoMogeBeats);
        int[][][] himeHimeBeats = {{{1, 0}, {17, 0}, {33, 0}, {45, 0}, {57, 4}, {79, 0}, {93, 0}, {125, 4}, {141, 0}, {157, 0}, {177, 10}, {205, 0}, {219, 0}, {237, 0}, {251, 0}, {269, 0}, {283, 0}, {295, 0}, {303, 0}, {311, 0}, {317, 4}, {329, 0}, {337, 0}, {347, 0}, {357, 0}, {369, 0}, {379, 0}, {389, 0}, {407, 0}, {417, 0}, {429, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                                 {{13, 0}, {21, 0}, {37, 0}, {65, 4}, {81, 0}, {111, 0}, {133, 0}, {149, 0}, {165, 0}, {187, 0}, {197, 0}, {209, 0}, {221, 0}, {229, 0}, {241, 0}, {247, 0}, {257, 0}, {265, 0}, {273, 0}, {285, 0}, {293, 0}, {299, 0}, {309, 0}, {321, 0}, {343, 0}, {349, 0}, {361, 0}, {375, 0}, {385, 0}, {401, 0}, {411, 0}, {415, 0}, {427, 0}, {437, 0}, {441, 8}, {0, 0}, {0, 0}, {0, 0}},
                                 {{5, 0}, {29, 0}, {53, 0}, {65, 0}, {97, 0}, {113, 4}, {129, 0}, {145, 0}, {161, 0}, {173, 0}, {189, 0}, {215, 0}, {233, 0}, {245, 0}, {277, 0}, {287, 0}, {291, 0}, {307, 0}, {325, 0}, {373, 0}, {393, 0}, {405, 0}, {413, 0}, {419, 0}, {425, 0}, {431, 0}, {435, 0}, {0, 0}, {439, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                                 {{9, 0}, {25, 0}, {41, 0}, {49, 0}, {61, 4}, {81, 4}, {97, 4}, {113, 0}, {129, 0}, {137, 0}, {153, 0}, {169, 0}, {193, 0}, {201, 0}, {213, 0}, {225, 0}, {253, 0}, {261, 0}, {279, 0}, {297, 0}, {301, 0}, {313, 0}, {333, 0}, {341, 0}, {353, 0}, {365, 0}, {381, 0}, {397, 0}, {411, 0}, {421, 0}, {431, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}};
        SongClass himeHime = new SongClass(178, 4, 1850, "Files/HimeHime.wav", "Files/HimeHimeBG.png", 97, 10, himeHimeBeats);
        int[][][] sasageyoBeats = {{{1, 0}, {17, 0}, {33, 0}, {43, 0}, {55, 0}, {63, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                                    {{7, 0}, {23, 0}, {33, 0}, {39, 0}, {43, 0}, {51, 0}, {55, 0}, {63, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                                    {{3, 0}, {11, 0}, {15, 0}, {19, 0}, {35, 0}, {39, 0}, {47, 0}, {51, 0}, {59, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                                    {{27, 0}, {31, 0}, {35, 0}, {47, 0}, {59, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}};
        SongClass sasageyo = new SongClass(160, 4, 2150, "Files/Sasageyo.wav", "Files/SasageyoBG.png", 89, 8, sasageyoBeats);

        Fenetre fenetre = new Fenetre();
        Score score1 = new Score(1);
        Score score2 = new Score(2);

        // Temporaire
        Scanner kgb = new Scanner(System.in);
        System.out.println("Choisissez une map :");
        System.out.println("1   -   Toby Fox - sans.    -    1*");
        System.out.println("2   -   Takahashi Hiroki - Chichi wo Moge   -   1*");
        System.out.println("3   -   *namirin - Koi no Hime Pettanko    -   2*");
        System.out.println("4   -   Linked Horizon - Shinzou wo Sasageyo !   -   3*");
        int mapChoisie = 0;
        while((mapChoisie < 1)||(mapChoisie > 4)) {
            mapChoisie = kgb.nextInt();
        }

        if(mapChoisie == 1){
            launchMap(sans, fenetre, score1, score2);
        }
        if(mapChoisie == 2){
            launchMap(chichiWoMoge, fenetre, score1, score2);
        }
        if(mapChoisie == 3){
            launchMap(himeHime, fenetre, score1, score2);
        }
        if(mapChoisie == 4){
            launchMap(sasageyo, fenetre, score1, score2);
        }

    }

    public static void launchMap(SongClass map, Fenetre fenetre, Score score1, Score score2){ // Lance la map sélectionnée

        fenetre.setGameScreen(map.BGfileName, (int)(600/map.vitesseDefilement));
        Clavier clavier = new Clavier(fenetre, score1, score2);
        fenetre.addKeyListener(clavier);

        // On setup un effet sonore
        Clip hitsound = null;
        try {
            hitsound = AudioSystem.getClip();
            hitsound.open(AudioSystem.getAudioInputStream(new File("Files/NormalHitclap.wav")));
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
                if(fenetre.getNotesOnScreen()[note].dureeRestante > 0) {
                    fenetre.getNotesOnScreen()[note].dureeRestante --;
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

    public static int findSpace(Fenetre fenetre){ // Cherche un emplacement dans le tableau des notes pas encore occupé pour en placer une nouvelle (2 méthodes, laquelle est plus rapide ?)
        int k=0;
        while((!fenetre.getNotesOnScreen()[k].hitByP1)&&(!fenetre.getNotesOnScreen()[k].hitByP2)){
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

    public static void confirmation(){ // Temporaire, demande qu'on écrive "1" au terminal pour continuer (permet de freeze le programme pour voir ce qu'il se passe)
        Scanner kgb = new Scanner(System.in);
        int n = 0;
        while(n != 1){
            n = kgb.nextInt();
        }
    }

    public static void affichageInfos (SongClass map, int i, int beatNB, Clip musique, Score score1, Score score2, Fenetre fenetre){ // Temporaire, affiche des informations pendant l'exécution du jeu pour débug

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
