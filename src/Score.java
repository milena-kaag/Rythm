
public class Score {

    int points, combos, avancement, player, degats; // Avancement : donne la position actuelle dans le tableau notes (donc le nombre de notes depuis le début de la map)
    double acc; // Precision du joueur
    int[] notes = new int[600]; // Stocke tous les scores de notes d'un joueur pendant une map


    public Score(int player){
        this.player = player;
    }

    public void getToInit(){ // Reinitialise l'objet
        this.points =0;
        this.combos =0;
        this.avancement =0;
        this.acc =0;
        this.degats =0;
    }

    public void addNote(int value){ // Ajoute une note dans le tableau
        this.notes[this.avancement] = value;
        this.avancement++;
    }

    public void calculDegats(Personnage loli, Personnage foe){
        this.degats =(int) (0.5 * (10 * points * acc + 0.1 * combos * loli.combo)/(5000 + foe.moe));
    }

    public void calculAcc(){ // Effectue le calcul de precision du joueur
        int s = 0;
        for(int i = 0; i < this.avancement; i++){
            s += this.notes[i];
        }
        this.acc = (double)(s)/(double)(3*this.avancement);
    }

    public void calculComboMax(){ // Effectue le calcul du combo max du joueur
        int maxTemp = 0;
        int max = 0;
        for(int i=0; i<this.avancement; i++){
            if(this.notes[i] != 0){
                maxTemp++;
            } else {
                if(maxTemp > max){
                    max = maxTemp;
                }
                maxTemp = 0;
            }
        }
        if(max == 0){
            this.combos = maxTemp;
        } else {
            this.combos = max;
        }
    }

    public void calculScore(){ // Calcul la somme des scores de notes individuelles
        for (int i=0;i<notes.length;i++){
            points = points+notes[i];
        }
    }


}
