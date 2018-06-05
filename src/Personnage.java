public class Personnage {
    
    String name;
    int pv;				//points de vie du personnage
    int puissance;		//force des attaques
    int combo;			//force des dégâts supplémentaires dus aux combos
    int moe;			//plus le moe est élevé, moins les attaques adverses seront fortes
    
    int score;			//score réalisé pendant une partie de jeu de rythme
    double precision;		//taux de précision pendant une partie du jeu de rythme
    int cb;				//taux de combo réalisé pendant une partie du jeu de rythme

    int maxPv;
    
    public Personnage (String name) {
        if (name.equals( "Miku")){ //Différents personnages disponibles et leurs caractéristiques
            this.name = name;
            this.pv = 10000;
            this.puissance = 4000;
            this.combo = 4000;
            this.moe = 2000;
        } else if(name.equals("Akatsuki")){
                this.name = name;
                this.pv = 6000;
                this.puissance = 8000;
                this.combo = 4000;
                this.moe = 8000;

        }else if(name.equals("Hatsuse")){
            this.name = name;
            this.pv = 2000;
            this.puissance = 10000;
            this.combo = 8000;
            this.moe = 10000;
        }else if(name.equals("Kanna")){
            this.name = name;
            this.pv = 4000;
            this.puissance = 8000;
            this.combo = 4000;
            this.moe = 8000;
        }else if(name.equals("Konata")){
            this.name = name;
            this.pv = 8000;
            this.puissance = 6000;
            this.combo = 6000;
            this.moe = 4000;
        }else{
            this.name = name;
            this.pv = 4000;
            this.puissance = 6000;
            this.combo = 10000;
            this.moe = 0;
        }
        maxPv=pv;
    }
    
    public void finPartie (Score score) { //Fonction qui récupère les informations de la partie
		this.score = score.points;
		this.precision = score.acc;
		this.cb = score.combos;
	}
    
    public void gestionPv (Personnage pers) { //Calcul des attaques de la map
        pers.pv = (int) (pers.pv - (this.score * 0.002 * this.precision * 5000 + 0.1 * this.cb * this.combo)/(5000 + pers.moe));
        this.pv = (int) (this.pv - (pers.score * 0.002 * pers.precision * 5000 + 0.1 * pers.cb * pers.combo)/(5000 + this.moe));

    }
    
    /***
     * le score est multiplié par 0.005 fois la puissance et par 0.1 fois la précision.
     * le cb est multiplié par 0.01 fois le combo.
     * le moe est une sorte de protection, il affaiblit les attaques adverses. 
     * ici, si le moe est de 0 alors l'attaque est divisée par 1 (aucun changement) et s'il est de 10 000, l'attaque est divisée par 2.
    */
    
    public String toString() {
        return name + " / Pv = " + this.pv;
    }
}
