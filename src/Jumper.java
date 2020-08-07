import java.util.Random;

/**
 * @author calia
 */
public class Jumper implements Comparable<Jumper> {
    private String skior;
    private int points;
    private int length;
    private Votes voturi;
    private int[] sir_lungimi;
    private int helper = 0; //tracking the current round

    public Jumper(String name) {

        this.skior = name;
        this.points = 0;
        this.length = 0;
        sir_lungimi = new int[10];

    }

    public void addPoints(int length, Votes voturi) {
        // Jump points are decided in relation to the jump length and judge decision(see Votes class)
        this.points += length + voturi.sumaVoturi();

    }

    public String getName() {
        return this.skior;
    }

    public int getLength() {
        return this.length;
    }

    public Votes getVoturi() {
        return this.voturi;
    }

    public int getPoints() {
        return this.points;
    }

    public void print_sarituri() {
        for (int i = 1; i <= this.helper; i++) {
            if (i != this.helper)
                System.out.print(" " + sir_lungimi[i] + " m,");
            else System.out.print(" " + sir_lungimi[i] + " m\n");
        }
    }

    @Override

    public int compareTo(Jumper jumper) {
        if (this.points == jumper.points)
            return 0;
        else if (this.points < jumper.points)
            return 1;
        return -1;
    }

    public String toString() {
        return this.skior + " " + "(" + this.points + " points)";
    }

    public void print_stats() {
        this.voturi = new Votes();
        Random r = new Random();
        length = r.nextInt(120 - 60) + 60; //jump length is a random integer between 60-120
        helper++;
        sir_lungimi[helper] = length;
        this.addPoints(length, this.voturi);  //adding the current points obtained in this round to his total score
        System.out.println("  " + this.skior);
        System.out.println("    length: " + length);
        System.out.print("    judge votes: ");
        voturi.printVotes();
        System.out.print("\n");
        System.out.println("");
    }


}
