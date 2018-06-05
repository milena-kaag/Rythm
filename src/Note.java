
public class Note {

    int colonne, x1, x2, y, duree, // coordonnées et durée de la note (0 pour une note simple ou cercle, 1 ou plus pour un slider)
            preScore1, preScore2; // Scores correspondant au moment ou l'utilisateur appuie sur la touche au début d'un slider, stocké pour déterminer le score final de la note
    // Variables indiquant si la note a été cliquée par le joueur 1 ou 2
    boolean hitByP1 = true;
    boolean hitByP2 = true;

    public Note (int colonne){
        this.colonne = colonne; // La colonne a laquelle la note appartient
        this.x1 = this.colonne*60+120; // L'abscisse correspondante pour le joueur 1
        this.x2 = this.colonne*60+440; // L'abscisse correspondante pour le joueur 2
        this.y = 650; // L'ordonnée
    }

}
