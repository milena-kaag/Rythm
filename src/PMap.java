//bandeau nom map 70 px, reste 572
//case 70*70
//77, 44

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class PMap extends JPanel {

    Image back = null;
    public CardLayout cMap = new CardLayout();
    public String[] listMap ={"BLANC","CHICHI","ODDS","HIME","SANS","SASAGEYO"};
    public JPanel cardsMap = new JPanel(cMap);
    Bouton firstMap = new Bouton("","Ressources/MinChichiWoMoge.png");
    Bouton oddsAndEnds = new Bouton("","Ressources/MiniOddsAndEnds.png");
    Bouton himeHime = new Bouton("","Ressources/MiniHimeHime.png");
    Bouton sans = new Bouton("","Ressources/MiniSans.png");
    Bouton sasageyo = new Bouton("","Ressources/MiniSasageyo.png");


    TitreMap tFirstMap = new TitreMap("Chichi Wo Moge","Hiroki Takahashi");
    TitreMap tWhite = new TitreMap("Select a Map","");
    TitreMap tOddsAndEnds = new TitreMap("Odds and Ends","ryo(supercell) feat. Hatsune Miku");
    TitreMap tHimeHime = new TitreMap("Koi no Hime Pettanko","Tamura Yukari");
    TitreMap tSans = new TitreMap("Sans","Toby Fox");
    TitreMap tSasageyo = new TitreMap("Shinzou wo Sasageyo !","Linked Horizon");

    PMap(){
        try{
            back = ImageIO.read(new File("Ressources/SettingBackBW.jpg"));
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

        this.add(cardsMap,BorderLayout.NORTH);

    }

    public class Center extends JPanel{
        Center(){
            GridLayout g1 = new GridLayout(5,6,64,31);
            this.setLayout(g1);
            this.add(firstMap);
            this.add(oddsAndEnds);
            this.add(himeHime);
            this.add(sans);
            this.add(sasageyo);
            for (int i=0;i<25;i++){
                this.add(Box.createGlue());
            }
            this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

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
