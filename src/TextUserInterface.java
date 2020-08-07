import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author calia
 */
public class TextUserInterface {
    private Scanner reader;
    private ArrayList<Jumper> lista_schiori;
    private int round;

    public TextUserInterface(Scanner reader) {
        this.reader = reader;
        this.lista_schiori = new ArrayList<Jumper>();
        this.round = 0;
    }

    public void start() {
        String input;
        System.out.println("Feleac ski jumping week");
        System.out.println("");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        while (true) {
            System.out.print("  Participant name: ");
            input = reader.nextLine();
            if (input.isEmpty()) {
                break;
            }
            if (!test_name(lista_schiori, input))    //checking if the current participant is not already enrolled in the race
                lista_schiori.add(new Jumper(input));
        }
        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");

        while (true) {

            System.out.print("Write \"jump\" to jump; otherwise type \"quit\" to quit: ");
            input = reader.nextLine();
            if (input.equals("quit"))
                break;
            if (input.equals("jump")) {
                this.round++;
                System.out.println("");
                System.out.println("Round " + this.round);
                System.out.println("");
                this.print_jumping_order(lista_schiori);
                System.out.println("");
                System.out.println("Results of round " + this.round);
                for (Jumper current : lista_schiori) {
                    current.print_stats();
                }
            }
        }
        System.out.println("");
        System.out.println("Thanks!");
        System.out.println("");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        Collections.sort(lista_schiori);
        printFinish(lista_schiori);
    }


    public boolean test_name(ArrayList<Jumper> lista, String nume) {
        for (Jumper current : lista) {
            if (current.getName().equals(nume))
                return true;
        }
        return false;
    }

    public void print_jumping_order(ArrayList<Jumper> lista) {
        Collections.sort(lista);
        Collections.reverse(lista);   //the one with the lowest score always jumps first
        int i = 0;
        System.out.println("Jumping order:");
        for (Jumper current : lista) {
            i++;
            System.out.println("  " + i + ". " + current);
        }
    }

    public void printFinish(ArrayList<Jumper> lista) {
        int i = 0;
        for (Jumper current : lista) {
            i++;
            System.out.println(i + "           " + current.getName() + " (" + current.getPoints() + " points)");
            System.out.print("            jump lengths:");
            current.print_sarituri();
        }
    }
}