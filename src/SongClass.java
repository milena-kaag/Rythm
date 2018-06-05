
public class SongClass {

    int diviseur, offset, vitesseDefilement;
    double bpm, beatDuration, duree;
    String musicFileName, BGfileName;
    int[][][] beats;

    public SongClass(double bpm, int diviseur, int offset, String musicFileName, String BGfileName, double duree, int vitesseDefilement, int[][][] beats){
        this.bpm = bpm; // Vitesse de la musique en bpm
        this.diviseur = diviseur; // En combien la mesure est divisée (pour faire des musiques en ternaire etc)
        this.beatDuration = 60000/((double)(diviseur)*(double)(bpm)); // Durée d'un temps en ms, selon le diviseur de mesure
        this.offset = offset; // Décalage du wav en ms
        this.musicFileName = musicFileName;
        this.BGfileName = BGfileName;
        this.duree = duree; // Duree de la map en s
        this.beats = beats; // Tableau indiquand quelles notes quand
        this.vitesseDefilement = vitesseDefilement; // Vitesse du scroll des notes : nombre de temps entre l'apparition
        // d'une note en haut de l'écran et le moment où il faut appuyer sur la touche. Utiliser un diviseur de 40 de préférence.
    }

}
