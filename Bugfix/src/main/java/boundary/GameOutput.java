package boundary;

import entity.Player;
import entity.AdvObject;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class GameOutput {

    public static void titolo() {
        System.out.println("\n\n\n =========================================================================================================================================");
        System.out.println("                                                                                                                                          ");
        System.out.println("                                                                                                                                          ");
        System.out.println("             1        ^       ^         1                                                                                                 ");
        System.out.println("              1         01111          1                                                                                                  ");
        System.out.println("               0      1__BUG__1       0                010101001011                                                                       ");
        System.out.println("            0    0__01101000100110__0    0            110101010100                                                                        ");
        System.out.println("           0  0   000110100010101010   0  0            0111           1110                                                                ");
        System.out.println("          1     0 Massafra Francesco 0     1          10110100       0001                                                                 ");
        System.out.println("         1     001111010101110001010100     1          01001011                  0101     1010                                            ");
        System.out.println("               11 Ricchiuti Alberto 001               1000            0011         1011011110                                             ");
        System.out.println("           0   101010010101101001000011   0            0111          1000             0011                                                ");
        System.out.println("          0  0  011 Scavo Beatrice 110  0  0          1010            0101         101010100                                              ");
        System.out.println("         0       00010101010010100100       0          0101          1010        0111      0101                                           ");
        System.out.println("        0          0101010010101010          0                                                                                            ");
        System.out.println("       1                010100                1                                                                                           ");
        System.out.println("      1                                        1                                                                                          ");
        System.out.println("                                                                                                       by   LSD!                          ");
        System.out.println("                                                                                                                                          ");
        System.out.println(" =========================================================================================================================================");
    }

    public static void separatore() {
        separatore(160);
    }

    public static void separatore(int lunghezza) {
        int i;

        System.out.print("\n\n<");
        for (i = 0; i < lunghezza; i++) {
            System.out.print("=");
        }
        System.out.print(">\n\n\n");
    }

    public static void nome_giocatore() {
        System.out.println("\t- INSERISCI IL TUO NOME:");
    }

    public static void inventario_equipaggiato() {
        System.out.println("\t- HAI OTTENUTO INVENTARIO!\n");
    }

    public static void assenza_inventario() {
        System.out.println("\t- NESSUN INVENTARIO DISPONIBILE!\n");
    }

    public static void oggetto_aggiunto(AdvObject oggetto) {
        System.out.println("\t\t- OGGETTO: " + oggetto.getNome() + " AGGIUNTO ALL'INVENTARIO.\n");
    }

    public static void oggetto_rimosso(AdvObject oggetto) {
        System.out.println("\t\t- OGGETTO: " + oggetto.getNome() + " RIMOSSO DALL'INVENTARIO.\n");
    }

    public static void oggetto_unico() {
        System.out.println("\t\t- OGGETTO GIA' PRESENTE NELL'INVENTARIO.\n");

    }

    public static void oggetto_assente() {
        System.out.println("\t\t- L'OGGETTO NON E' PRESENTE NELL'INVENTARIO.\n");
    }

    public static void inventario_pieno() {
        System.out.println("\t- L'INVENTARIO E' PIENO, NON PUOI AGGIUNGERE ALTRO!\n");
    }

    public static void mostra_inventario(Player giocatore) {
        if (!giocatore.getZaino().getInv().isEmpty() && giocatore.getZaino().getDisponibilitaInv()) {
            System.out.println("\t\t\tINVENTARIO:\n");
            BiConsumer<AdvObject, Integer> inv = (oggetto, quantita)
                    -> System.out.println("\t" + oggetto.getNome() + "\t " + quantita);
            giocatore.getZaino().getInv().forEach(inv);
        } else if (giocatore.getZaino().getInv().isEmpty() && giocatore.getZaino().getDisponibilitaInv()) {
            System.out.println("\t\t\tINVENTARIO VUOTO.\n");
        } else if (!giocatore.getZaino().getDisponibilitaInv()) {
            assenza_inventario();
        }
    }

    public static void blocco_ritorno() {
        System.out.println("\n\tOra non e' possibile tornare indietro...\n");
    }

    public static void err_comando_gioco() {
        Random rand = new Random();
        String[] messaggi = new String[]{"Non e' possibile ora.", "Adesso e' impossibile.", "Che senso avrebbe?", "Non posso farlo.", "Non penso abbia senso.",
            "Non funzionerebbe.", "Non e' il momento adatto.", "Non sarebbe opportuno.", "E come dovrei fare?!?", "Cosa?!?", "Come potrei farlo?"};

        System.out.println("\n\t" + messaggi[rand.nextInt(messaggi.length)] + "\n");
    }

    public static void err_codice_binario(int versione) {
        int i, numeroCaratteri = 0, lunghezzaRigo = 0;
        String spazio_ = "";
        Random rand = new Random();

        switch (versione) {
            case 1:
                numeroCaratteri = 300;
                lunghezzaRigo = 150;
                break;
            case 2:
                numeroCaratteri = 500;
                lunghezzaRigo = 100;
                spazio_ = " ";
                break;
            case 3:
                numeroCaratteri = 1688;
                lunghezzaRigo = 211;
                spazio_ = " ";
            default:
                break;
        }

        System.out.println("\n");
        for (i = 1; i <= numeroCaratteri; i++) {
            System.out.print(rand.nextInt(2) + spazio_);
            if (i % lunghezzaRigo == 0) {
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }

    public static String sequenza_binaria(int lunghezza) {
        int i;
        String codice = "";
        Random rand = new Random();

        for (i = 0; i < lunghezza; i++) {
            codice = codice.concat(Integer.toString(rand.nextInt(2)));
        }

        return codice;
    }

    public static void pausa_output() {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.print("#");
        System.out.println();
        System.out.flush();

        do {
            input = scan.nextLine();
            System.out.flush();
        } while (!input.isEmpty());

        System.out.println("\n");
    }

    public static void mostra_help_comandi() {
        System.out.println("\n\n- GUIDA AL GIOCO E AI COMANDI:\n");
        System.out.println("- Il comando deve essere composto da <azione> <oggetto/personaggio> o eventualmente soltanto da <azione>.");
        System.out.println("  L'azione deve essere scritta in forma imperativa per il corretto uso del comando.");
        System.out.println("  Per esempio:  usa chiave, osserva il quadro, cammina, parla.");
        System.out.println("\n- Il carattere '#' indica che per proseguire e' necessario premere il tasto invio.");
        System.out.println("\n- Per richiamare questa guida digitare 'aiuto' come comando.");
        System.out.println("\n- Per uscire dal gioco inserire, quando possibile, in input '#esci'.");
        System.out.println("\n- Durante l'avventura, l'utente non potra' tornare indietro liberamente. Sara' permesso\n"
                + "  esclusivamenteb in alcuni casi con il comando 'torna indietro', per recuperare determinati oggetti.\n"
                + "  Dopo aver fatto cio', il personaggio ritornera' automaticamente al punto in cui si trovava prima di aver eseguito tale comando.");
        System.out.println("\n- Per mostrare il contenuto dell'inventario, quando ne sei in possesso, usa il comando 'inventario'.");
        System.out.println("\n- Il gioco salva i dati automaticamente ad ogni fine capitolo. Se il tuo personaggio muore");
        System.out.println("  o si esce dal gioco prima della fine di un capitolo, i progressi andranno persi");
        System.out.println("  ed il gioco ripartira' dall'ultimo salvataggio.\n");
        System.out.println("\n\tBUON DIVERTIMENTO!!\t:)\n");
    }

    public static void mostra_game_over() {
        System.out.println("\n\n\t\tGAME_OVER!\t:(((\n\n");
    }

    public static void mostra_errore_finale() {
        System.out.println("\n\nOps... Qualcosa e' andato storto... A quanto pare non hai con te una cosa importante.\n\n"
                + "Ma che peccato, e' andata male, questa volta non hai proprio nessun modo di salvarti...\n\n\n"
                + "La prossima volta sii piu' sveglio\t\t(o forse servirebbe dormire ..?)\n\n\n"
                + "La tua Anima e' persa per sempre ormai.\n\n\nE la tua partita finisce qui cavaliere !\t\t:))) \n");
    }

    public static void mostra_the_end() {
        System.out.println("\n\nCongratulazioni!\tHai finito il gioco!!!\n\n"
                + "Speriamo che Bugfix ti sia piaciuto e di tornare presto all'avventura con te.\n\nGrazie di aver giocato!\n\n"
                + "Arrivederci\tdai tuoi amichevoli informatici fantasma.\n\n\nCIAO! :)");
    }

}
