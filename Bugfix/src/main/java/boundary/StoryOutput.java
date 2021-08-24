package boundary;

import java.util.Scanner;

public class StoryOutput {
    String invioIn;
    String[] stampa;
    Scanner scan = new Scanner(System.in);

    public StoryOutput(String... capitolo) {
        this.stampa = capitolo;
    }

    public void mostra(int i) {
        if (i - 1 >= 0 && i - 1 < stampa.length) {
            System.out.println(stampa[i - 1]);
        }
    }

    public void pausa_output() {
        System.out.print("#");
        System.out.println();
        System.out.flush();

        do {
            invioIn = scan.nextLine();
            System.out.flush();
        } while (!invioIn.isEmpty());

        System.out.println("\n");
    }
}
