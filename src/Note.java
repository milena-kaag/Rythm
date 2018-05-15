
public class Note {

    int colonne, x1, x2, y, duree, dureeRestante, score1;
    boolean hitByP1 = true;
    boolean hitByP2 = true;

    public Note (int colonne){
        this.colonne = colonne; // La colonne a laquelle la note appartient
        this.x1 = this.colonne*60+120; // L'abscisse correspondante pour le joueur 1
        this.x2 = this.colonne*60+440; // L'abscisse correspondante pour le joueur 2
        this.y = 650; // L'ordonnée
    }

}
