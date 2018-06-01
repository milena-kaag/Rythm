import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PChara extends JPanel{

    public Bouton BMiku = new Bouton("", "Ressources/persos/ChibiMiku.png");
    public Bouton BAka = new Bouton("", "Ressources/persos/ChibiAkatsuki.png");
    public Bouton BHatsuse = new Bouton("", "Ressources/persos/ChibiHatsuse.png");
    public Bouton BKanna = new Bouton("", "Ressources/persos/ChibiKanna.png");
    public Bouton BKonata = new Bouton("", "Ressources/persos/ChibiKonata.png");
    public Bouton BMercury = new Bouton("", "Ressources/persos/ChibiMercury.png");
    public Bouton[] listeChara = {BMiku, BAka,BHatsuse,BKanna,BKonata,BMercury};
    private JPanel charas = new JPanel();
    private GridLayout g1 = new GridLayout(1, 13);



    public TitreChara persoJ1 = new TitreChara("J1 : Choisir un Chara");
    private Image select = null;
    private ImChara charaBlanc = new ImChara("Ressources/SettingBackBW.jpg", select);
    public JPanel PCharaBlanc = new JPanel();
    public TitreChara persoJ2 = new TitreChara("J2 : Choisir un Chara");


    Image hmiku = null;
    private ImChara miku = new ImChara("Ressources/persos/HatsuneMiku-v2.png", hmiku);
    private TitreChara titreMiku = new TitreChara("Hatsune Miku");
    private JPanel pMiku = new JPanel();

    Image akatsuki = null;
    private ImChara ImAkatsuki = new ImChara("Ressources/persos/AkatsukiAction-v2.png", akatsuki);
    private TitreChara titreAkatsuki = new TitreChara("Akatsuki");
    private JPanel pAkatsuki = new JPanel();

    Image hatsuse = null;
    private ImChara ImHatsuse = new ImChara("Ressources/persos/AzunaHatsuse.png", hatsuse);
    private TitreChara titreHatsuse = new TitreChara("Azuna Hatsuse");
    private JPanel pHatsuse = new JPanel();

    private Image konata = null;
    private ImChara ImKonata = new ImChara("Ressources/persos/IzumiKonata1.png", konata);
    private TitreChara titreKonata = new TitreChara("Izumi Konata");
    private JPanel pKonata = new JPanel();

    Image mercury = null;
    private ImChara ImMercury = new ImChara("Ressources/persos/RoryMercury.png", mercury);
    private TitreChara titreMercury = new TitreChara("Rory Mercury");
    private JPanel pMercury = new JPanel();

    Image kanna = null;
    private ImChara ImKanna = new ImChara("Ressources/persos/KannaKamui-v2.png", kanna);
    private TitreChara titreKanna = new TitreChara("Kanna Kamui");
    private JPanel pKanna = new JPanel();

    public CardLayout cChara = new CardLayout();
    public String[] listContent = {"BLANCJ1", "MIKU","AKATSUKI","Hatsuse","KONATA","MERCURY","KANNA"};//Liste qui permet de s'y retrouver dans les indices du cardlayout

    public JPanel cardsChara = new JPanel(cChara);



    PChara(){
        this.setLayout(new BorderLayout());
        charas.setLayout(g1);
        for(int i=0; i<listeChara.length;i++){
            charas.add(Box.createGlue());
            charas.add(listeChara[i]);
        }
        charas.add(Box.createGlue());
        charas.setBorder(BorderFactory.createLineBorder(Color.black));
        charas.setPreferredSize(new Dimension(816,80));

        PCharaBlanc.setLayout(new BorderLayout());
        PCharaBlanc.add(persoJ1, BorderLayout.NORTH);
        PCharaBlanc.add(charaBlanc, BorderLayout.CENTER);
        cardsChara.add(PCharaBlanc, listContent[0]);

        pMiku.setLayout(new BorderLayout());
        pMiku.add(titreMiku, BorderLayout.NORTH);
        pMiku.add(miku, BorderLayout.CENTER);
        cardsChara.add(pMiku, listContent[1]);

        pAkatsuki.setLayout(new BorderLayout());
        pAkatsuki.add(titreAkatsuki, BorderLayout.NORTH);
        pAkatsuki.add(ImAkatsuki, BorderLayout.CENTER);
        cardsChara.add(pAkatsuki, listContent[2]);

        pHatsuse.setLayout(new BorderLayout());
        pHatsuse.add(titreHatsuse, BorderLayout.NORTH);
        pHatsuse.add(ImHatsuse, BorderLayout.CENTER);
        cardsChara.add(pHatsuse, listContent[3]);

        pKonata.setLayout(new BorderLayout());
        pKonata.add(titreKonata, BorderLayout.NORTH);
        pKonata.add(ImKonata, BorderLayout.CENTER);
        cardsChara.add(pKonata, listContent[4]);

        pMercury.setLayout(new BorderLayout());
        pMercury.add(titreMercury, BorderLayout.NORTH);
        pMercury.add(ImMercury, BorderLayout.CENTER);
        cardsChara.add(pMercury, listContent[5]);

        pKanna.setLayout(new BorderLayout());
        pKanna.add(titreKanna, BorderLayout.NORTH);
        pKanna.add(ImKanna, BorderLayout.CENTER);
        cardsChara.add(pKanna, listContent[6]);

        this.add(charas, BorderLayout.SOUTH);
        this.add(cardsChara);


    }

    public class TitreChara extends JPanel{
        String name;
        TitreChara(String name){
            this.name = name;
            this.setPreferredSize(new Dimension(816,70));

        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.black);
            g2d.fillRect(0,0,this.getWidth(),this.getHeight());
            g2d.setColor(Color.white);
            Font police = new Font("Tahoma", Font.ITALIC, 32);
            g2d.setFont(police);
            g2d.drawString(this.name, 5,40);

        }
    }

    public class ImChara extends JPanel{
        Image image = null;
        ImChara(String pathname, Image im){
            image = im;

            try {
                image = ImageIO.read(new File(pathname)); //bloc try/catch gère les exceptions
            } catch (IOException e){
                e.printStackTrace();
            }
        }


        public void paintComponent(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(image, 0, 0, this.getWidth(),this.getHeight(), this );
        }
    }

}