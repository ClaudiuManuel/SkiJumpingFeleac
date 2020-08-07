import java.util.Arrays;
import java.util.Random;

/**
 * @author calia
 */
public class Votes {


    private int[] voturi;

    public Votes() {
        //Five judges vote for each jump (a vote is a random number between 10-20)

        this.voturi = new int[5];
        Random r = new Random();
        int low = 10;
        int high = 20;
        int result;
        for (int i = 0; i < 5; i++) {
            result = r.nextInt(high - low) + low;
            voturi[i] = result;
        }
        Arrays.sort(voturi);
    }

    public int sumaVoturi() {
        //The judge decision takes into consideration only three judge votes: the smallest and the greatest votes are not taken into account
        int suma = 0;
        suma += voturi[1] + voturi[2] + voturi[3];
        return suma;
    }

    public void printVotes() {
        System.out.print("[");
        for (int i = 0; i < 5; i++) {
            if (i != 4)
                System.out.print(voturi[i] + ",");
            else System.out.print(voturi[i] + "]");
        }
    }


}