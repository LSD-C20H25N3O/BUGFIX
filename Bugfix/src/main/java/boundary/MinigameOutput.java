package boundary;

import java.util.Set;

public class MinigameOutput {

    public static void richiedi_inserimento_imp() {
        System.out.println("\nIndovina la frase nascosta o inserisci una lettera che credi sia presente in essa...\n\n");
    }

    public static void stampa_turno_imp(String frase, Set<Character> lettere) {
        short i;

        for (i = 0; i < frase.length(); i++) {
            if (!Character.isWhitespace(frase.charAt(i))) {
                if (lettere.contains(frase.charAt(i))) {
                    System.out.print(frase.charAt(i) + " ");
                } else {
                    System.out.print("_ ");
                }
            } else {
                System.out.print("   ");
            }
        }
        System.out.println("\n");
    }

    public static void mostra_soluzione_imp(String frase) {
        System.out.println("\n...La frase da scoprire e':\n\t" + frase + "...\n\n");
    }

    public static void stampa_output_minigioco(String elemMinigioco) {
        System.out.println("\n" + elemMinigioco + "\n");
    }

    public static void richiedi_inserimento_ind() {
        System.out.println("\nInserisci la soluzione all'indovinello...\n");
    }

    public static void mostra_errore_ind() {
        System.out.println("\n\nQuesta risposta e' errata.\n\n");
    }

    public static void mostra_tempo_scaduto() {
        System.out.println("\n\nIl tempo e' scaduto. . .\n\n\n");
    }
}
