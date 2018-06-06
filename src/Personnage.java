public class Personnage {
    
    private String name;
    int pv;				//points de vie du personnage
    public int puissance;		//force des attaques
    int combo;			//force des dégâts supplémentaires dus aux combos
    int moe;			//plus le moe est élevé, moins les attaques adverses seront fortes
    
    private int score;			//score réalisé pendant une partie de jeu de rythme
    private double precision;		//taux de précision pendant une partie du jeu de rythme
    private int cb;				//taux de combo réalisé pendant une partie du jeu de rythme

    int maxPv;
    
    Personnage(String name) {
        //Différents personnages disponibles et leurs caractéristiques
        switch(name){
            case("Miku"):
                this.name = name;
                this.pv = 10000;
                this.puissance = 4000;
                this.combo = 4000;
                this.moe = 2000;
                break;
            case("Akatsuki"):
                this.name = name;
                this.pv = 6000;
                this.puissance = 8000;
                this.combo = 4000;
                this.moe = 8000;
                break;
            case("Hatsuse"):
                this.name = name;
                this.pv = 2000;
                this.puissance = 10000;
                this.combo = 8000;
                this.moe = 10000;
                break;
            case("Kanna"):
                this.name = name;
                this.pv = 4000;
                this.puissance = 8000;
                this.combo = 4000;
                this.moe = 8000;
                break;
            case("Konata"):
                this.name = name;
                this.pv = 8000;
                this.puissance = 6000;
                this.combo = 6000;
                this.moe = 4000;
                break;
            default:
                this.name = name;
                this.pv = 4000;
                this.puissance = 6000;
                this.combo = 10000;
                this.moe = 0;
                break;
            }
        maxPv=pv;
    }
    
    public void finPartie (Score score) { //Fonction qui récupère les informations de la partie
		this.score = score.points;
		this.precision = score.acc;
		this.cb = score.combos;
	}
    
    public void gestionPv (Personnage pers) { //Calcul des attaques de la map
        pers.pv = (int) (pers.pv - 2*(5* this.score * this.precision+this.score*(this.puissance/5000) + 0.1 * this.cb * this.combo)/(5000 + pers.moe));
        this.pv = (int) (this.pv - 2*(5*pers.score * pers.precision +pers.score*(pers.puissance/5000)+ 0.1 * pers.cb * pers.combo)/(5000 + this.moe));

    }
    
    public String toString() {
        return name + " / Pv = " + this.pv;
    }
}
