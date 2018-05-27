public class Personnage {
    
    String name;
    int pv;				//points de vie du personnage
    int puissance;		//force des attaques
    int combo;			//force des dégâts supplémentaires dus aux combos
    int moe;			//plus le moe est élevé, moins les attaques adverses seront fortes
    
    int score;			//score réalisé pendant une partie de jeu de rythme
    int precision;		//taux de précision pendant une partie du jeu de rythme
    int cb;				//taux de combo réalisé pendant une partie du jeu de rythme
    
    public Personnage (String name) {
        if (name.equals( "Miku")){
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

    }
    
    public void finPartie (int score, int precision, int cb) {
		this.score = score;
		this.precision = precision;
		this.cb = cb;
	}
    
    public void gestionPv (Personnage pers1, Personnage pers2) {
        pers1.pv = (int) (pers1.pv - (pers2.score * 0.1 * pers2.precision * 5000 + 0.1 * pers2.cb * pers2.combo)/(5000 + pers1.moe));
        pers2.pv = (int) (pers2.pv - (pers1.score * 0.1 * pers1.precision * 5000 + 0.1 * pers1.cb * pers1.combo)/(5000 + pers2.moe));
    }
    
    /***
     * pour Miléna et Yann :
     * la gestion de pv a été mise en place pour des score/cb/precision allant de 0 à 10.
     * il suffira de faire une division adéquate des vrais valeurs pour l'ajuster.
     * le score est multiplié par 0.1 fois la puissance et par 0.1 fois la précision.
     * le cb est multiplié par 0.01 fois le combo.
     * le moe est une sorte de protection, il affaiblit les attaques adverses. 
     * ici, si le moe est de 0 alors l'attaque est divisée par 1 (aucun changement) et s'il est de 10 000, l'attaque est divisée par 2.
     * Libre à vous de le modifier selon vos souhaits!
     * la bise ;)
    */
    
    public String toString() {
        return name + " / Pv = " + this.pv;
    }
}
