
public class Score {

    int points, combos, avancement, player, degats;
    double acc;
    int[] notes = new int[2000];


    public Score(int player){
        this.player = player;
    }

    public void getToInit(){
        this.points =0;
        this.combos =0;
        this.avancement =0;
        this.acc =0;
        this.degats =0;
    }

    public void addNote(int value){
        this.notes[this.avancement] = value;
        this.avancement++;
    }

    public void calculDegats(Personnage loli, Personnage foe){
        this.degats =(int) (points * 0.002 * acc * 5000 + 0.1 * combos * loli.combo)/(5000 + foe.moe);
    }
    public void calculAcc(){
        int s = 0;
        for(int i = 0; i < this.avancement; i++){
            s += this.notes[i];
        }
        this.acc = (double)(s)/(double)(3*this.avancement);
    }

    public void calculComboMax(){
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

    public void calculScore(){
        for (int i=0;i<notes.length;i++){
            points = points+notes[i];
        }
    }


}
