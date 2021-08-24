package boundary;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MemoryManager;

public class AppOutput {

    public static void mostra_menu_app() {
        System.out.println("\n\t\t-\tBUG  FIX\t-\n\n");
        System.out.println("+ Nuova Partita\n");
        System.out.println("+ Mostra Salvataggi\n");
        System.out.println("+ Esci\n");
        System.out.println("\nInserisci comando. . .\n");
    }

    public static void mostra_salvataggi(MemoryManager salvataggi) {
        if (salvataggi.getNumFileTot() > 0) {
            int i;
            System.out.println("\n- I file-slavataggio sono:\n");
            for (i = 0; i < salvataggi.getNumFileTot(); i++) {
                System.out.println("\n\t" + (i + 1) + "\t" + salvataggi.getNomeFile(i + 1));
            }
            System.out.println("\n");
        } else {
            System.out.println("\nNon ci sono file-salvataggio.\n");
        }
    }

    public static void mostra_menu_salvataggi() {
        System.out.println("\n- Sono possibili le seguenti opzioni:\n");
        System.out.println("+  carica\n");
        System.out.println("+  rinomina\n");
        System.out.println("+  cancella\n");
        System.out.println("+  indietro\n");
        System.out.println("\nInserisci comando. . .\n");
    }

    public static void mostra_errore_comando1() {
        System.out.println("\n- Il comando inserito non e' riconsciuto.\n");
    }

    public static void mostra_errore_comando2() {
        System.out.println("\n- Il comando inserito non e' riconsciuto.\n\tInserisci un nuovo comando. . .\n");
    }

    public static void mostra_errore_caricamento() {
        System.out.println("\n- Errore, file corrotto, impossibile utilizzarlo.\n");
    }

    public static void richiedi_conferma() {
        System.out.println("\nSei sicuro della tua scelta?\n");
    }

    public static void mostra_chiusura_app() {
        System.out.println("\n\n- Il gioco si chiudera'...\n\n\tA presto!!\t:)\n");
    }

    public static void mostra_annullamento_comando() {
        System.out.println("\n- Il comando e' stato annullato.\n");
    }

    public static void richiedi_nome_salvataggio() {
        System.out.println("\nInserire il nome del tuo nuovo file-salvataggio...\n\t\tNB:Non possono esistere files con lo stesso nome.\n");
    }

    public static void richiedi_nome_file() {
        System.out.println("\nInserire il nome del file su cui operare...\n");
    }

    public static void richiedi_numero_file() {
        System.out.println("\nInserire l'indice del file su cui operare...\n");
    }

    public static void mostra_errore_numero_file() {
        System.out.println("\n- L'indice inserito non e' valido, controlla che il numero del file sia corretto...\n");
    }

    public static void mostra_errore_nome_file() {
        System.out.println("\n- Il nome inserito non e' valido, controlla che il nome del file sia corretto...\n");
    }

    public static void richiedi_nuovo_nome() {
        System.out.println("\nInserire il nuovo nome...\n");
    }

    public static void mostra_limite_file() {
        System.out.println("\n- Sei arrivato al numero massimo di file-salvataggio.\n"
                + "Per iniziare una nuova partita devi eliminare uno dei precedenti... Inserisci il nome del file da eliminare.\n");
    }

    public static void mostra_cancellazione_file() {
        System.out.println("\n- Il salvataggio e' stato eliminato.\n");
    }

    public static void mostra_uscita_gioco() {
        System.out.println("\n- Sarai riportato al menu iniziale.\n");
    }

    public static void mostra_salvataggio_completato() {
        System.out.println("\n- Salvataggio automatico partita completato.\n");
    }

    public static void mostra_nuovo_schermo(String... args) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            System.err.println("\n\nERRORE:\tImpossibile creare nuova schermata.\n\n");
            Logger.getLogger(AppOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
