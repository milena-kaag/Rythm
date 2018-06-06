import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class PMap extends JPanel { //Panneau affichant les différents choix de map ainsi que les informations associées

    private Image back = null;
    public CardLayout cMap = new CardLayout();
    public String[] listMap ={"BLANC","CHICHI","ODDS","HIME","SANS","SASAGEYO","BONE","ASGORE","TRUCALLEMAND"};

    public JPanel cardsMap = new JPanel(cMap); //Panneaux qui va contenir tous les titres de map

    Bouton firstMap = new Bouton("","Ressources/MinChichiWoMoge.png");
    Bouton oddsAndEnds = new Bouton("","Ressources/MiniOddsAndEnds.png");
    Bouton himeHime = new Bouton("","Ressources/MiniHimeHime.png");
    Bouton sans = new Bouton("","Ressources/MiniSans.png");
    Bouton sasageyo = new Bouton("","Ressources/MiniSasageyo.png");
    Bouton bonetrousle = new Bouton ("","Ressources/MiniBonetrousle.png");
    Bouton asgore = new Bouton("","Ressources/MiniAsgore.png");
    Bouton bergentruckung = new Bouton("","Ressources/MiniAsgore.png");


    private TitreMap tFirstMap = new TitreMap("Chichi Wo Moge","Hiroki Takahashi ~ 1:10");
    private TitreMap tWhite = new TitreMap("Select a Map","");
    private TitreMap tOddsAndEnds = new TitreMap("Odds and Ends","ryo(supercell) feat. Hatsune Miku ~ 1:30");
    private TitreMap tHimeHime = new TitreMap("Koi no Hime Pettanko","Tamura Yukari ~ 1:33");
    private TitreMap tSans = new TitreMap("Sans","Toby Fox ~ 0:49");
    private TitreMap tSasageyo = new TitreMap("Shinzou wo Sasageyo !","Linked Horizon ~ 1:29");
    private TitreMap tBonetrousle = new TitreMap("Bonetrousle","Toby Fox ~ 0:59");
    private TitreMap tAsgore = new TitreMap("Asgore","Toby Fox ~ 2:39");
    private TitreMap tBergentruckung = new TitreMap("Bergentrückung","Toby Fox ~ 0:18");

    PMap(){
        try{
            back = ImageIO.read(new File("Ressources/SettingBackStarsBW.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }

        this.setLayout(new BorderLayout());
        Center center = new Center();
        this.add(center,BorderLayout.CENTER);


        cardsMap.add(tWhite,listMap[0]);
        cardsMap.add(tFirstMap,listMap[1]);
        cardsMap.add(tOddsAndEnds,listMap[2]);
        cardsMap.add(tHimeHime,listMap[3]);
        cardsMap.add(tSans,listMap[4]);
        cardsMap.add(tSasageyo,listMap[5]);
        cardsMap.add(tBonetrousle,listMap[6]);
        cardsMap.add(tAsgore,listMap[7]);
        cardsMap.add(tBergentruckung,listMap[8]);

        this.add(cardsMap,BorderLayout.NORTH);

    }

    public class Center extends JPanel{ //Panneau contenant tous les boutons de map
        Center(){
            GridLayout g1 = new GridLayout(3,6,10,72); //Les maps sont classées en ligne : une ligne = une difficulté
            this.setLayout(g1);
            this.add(firstMap);
            this.add(oddsAndEnds);
            this.add(sans);
            this.add(bonetrousle);
            this.add(bergentruckung);
            this.add(Box.createGlue());
            this.add(himeHime);
            for (int i=0;i<5;i++){
                this.add(Box.createGlue());
            }
            this.add(sasageyo);
            this.add(asgore);
            for (int i=0;i<4;i++){
                this.add(Box.createGlue());
            }

            //Bordure de façon à ce que les boutons ne soient pas collés aux bords de la fenêtre
            this.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));

        }

        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(back, 0,0,this.getWidth(),this.getHeight(),this);
        }
    }

    public class TitreMap extends JPanel{
        String name;
        String author;
        TitreMap(String name, String author){
            this.name = name;
            this.author = author;
            this.setPreferredSize(new Dimension(816,70));

        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.black);
            g2d.fillRect(0,0,this.getWidth(),this.getHeight());
            g2d.setColor(Color.white);
            Font police = new Font("Tahoma",Font.PLAIN, 20);
            g2d.setFont(police);
            g2d.drawString(this.name, 5,30);
            g2d.setFont(new Font("Tahoma",Font.ITALIC,15));
            g2d.drawString(this.author,5,50);

        }
    }


}
