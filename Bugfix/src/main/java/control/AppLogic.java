package control;

import boundary.AppInput;
import boundary.AppOutput;
import boundary.GameOutput;
import control.game.*;
import entity.Player;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MemoryManager;

public class AppLogic {

    public static boolean menu_app(String comando) {
        boolean flag = false;

        switch (comando) {
            case "nuovapartita":
                nuova_partita();
                break;

            case "mostrasalvataggi":
                carica_salvataggi();
                break;

            case "esci":
                flag = chiudi_app();
                break;

            default:
                AppOutput.mostra_errore_comando1();
                break;
        }

        return flag;
    }

    private static void nuova_partita() {
        String nomeFile;
        Player giocatore = new Player();
        MemoryManager file = new MemoryManager();

        giocatore.setCheckPoint(0);
        AppOutput.mostra_salvataggi(file);
        if (file.getNumFileTot() > 0 && file.getNumFileTot() < file.getMaxNumFileTot()) {

            AppOutput.richiedi_nome_salvataggio();
            do {
                nomeFile = AppInput.raccogli_input();
                if (file.esisteFile(nomeFile)) {
                    AppOutput.mostra_errore_nome_file();
                }
            } while (file.esisteFile(nomeFile));

        } else if (file.getNumFileTot() == 0) {

            AppOutput.richiedi_nome_salvataggio();
            nomeFile = AppInput.raccogli_input();

        } else {

            AppOutput.mostra_limite_file();
            do {
                nomeFile = AppInput.raccogli_input();
                if (!file.esisteFile(nomeFile)) {
                    AppOutput.mostra_errore_nome_file();
                }
            } while (!file.esisteFile(nomeFile));
            file.cancellaFile(nomeFile);
            AppOutput.mostra_cancellazione_file();
            AppOutput.richiedi_nome_salvataggio();
            do {
                nomeFile = AppInput.raccogli_input();
                if (file.esisteFile(nomeFile)) {
                    AppOutput.mostra_errore_nome_file();
                }
            } while (file.esisteFile(nomeFile));

        }

        giocatore.setSalvataggio(nomeFile);
        file.aggiungiFile(nomeFile);
        AppOutput.mostra_nuovo_schermo();
        gioca(giocatore, file);
    }

    private static void carica_salvataggi() {
        boolean flag;
        MemoryManager file = new MemoryManager();

        AppOutput.mostra_salvataggi(file);
        if (file.getNumFileTot() > 0) {
            do {
                AppOutput.mostra_menu_salvataggi();
                if (file.getNumFileTot() > 0) {
                    flag = menu_salvataggi(AppInput.raccogli_comando_app(new String[]{"carica", "rinomina", "cancella", "indietro"}), file);
                } else {
                    flag = true;
                }
            } while (!flag);
        }
    }

    private static boolean menu_salvataggi(String comando, MemoryManager salvataggi) {
        boolean flag = false;

        switch (comando) {
            case "carica":
                carica_partita(salvataggi);
                flag = true;
                break;

            case "rinomina":
                rinomina_partita(salvataggi);
                break;

            case "cancella":
                cancella_partita(salvataggi);
                break;

            case "indietro":
                flag = true;
                break;

            default:
                AppOutput.mostra_errore_comando1();
                break;
        }

        return flag;
    }

    private static void carica_partita(MemoryManager salvataggi) {
        String nomeFile;

        AppOutput.richiedi_nome_file();
        do {
            nomeFile = AppInput.raccogli_input();
            if (!salvataggi.esisteFile(nomeFile)) {
                AppOutput.mostra_errore_nome_file();
            }
        } while (!salvataggi.esisteFile(nomeFile));

        Player giocatore = (Player) salvataggi.caricaFile(nomeFile);
        giocatore.setSalvataggio(nomeFile);
        AppOutput.mostra_nuovo_schermo();
        gioca(giocatore, salvataggi);
    }

    private static void rinomina_partita(MemoryManager salvataggi) {
        int indiceFile;
        String nomeFile, nuovoNomeFile;

        AppOutput.richiedi_numero_file();
        do {
            indiceFile = AppInput.raccogli_numero();
            nomeFile = salvataggi.getNomeFile(indiceFile);
            if (!salvataggi.esisteFile(nomeFile)) {
                AppOutput.mostra_errore_numero_file();
            }
        } while (!salvataggi.esisteFile(nomeFile));

        AppOutput.richiedi_nuovo_nome();
        do {
            nuovoNomeFile = AppInput.raccogli_input();
            if (salvataggi.esisteFile(nuovoNomeFile)) {
                AppOutput.mostra_errore_nome_file();
            }
        } while (salvataggi.esisteFile(nuovoNomeFile));

        salvataggi.setNomeFile(indiceFile, nuovoNomeFile);
        AppOutput.mostra_salvataggi(salvataggi);
    }

    private static void cancella_partita(MemoryManager salvataggi) {
        String nomeFile;

        AppOutput.richiedi_nome_file();
        do {
            nomeFile = AppInput.raccogli_input();
            if (!salvataggi.esisteFile(nomeFile)) {
                AppOutput.mostra_errore_nome_file();
            }
        } while (!salvataggi.esisteFile(nomeFile));

        AppOutput.richiedi_conferma();
        if (AppInput.raccogli_conferma()) {
            salvataggi.cancellaFile(nomeFile);
            AppOutput.mostra_salvataggi(salvataggi);
        } else {
            AppOutput.mostra_annullamento_comando();
        }

    }

    public static boolean chiudi_app() {
        boolean flag;

        AppOutput.richiedi_conferma();
        if (AppInput.raccogli_conferma()) {
            AppOutput.mostra_chiusura_app();
            flag = true;
        } else {
            AppOutput.mostra_annullamento_comando();
            flag = false;
        }

        return flag;
    }

    private static void gioca(Player giocatoreOrigin, MemoryManager salvataggi) {
        Player giocatoreTemp;
        boolean flag = true;

        if (giocatoreOrigin.getCheckPoint() >= 0 && giocatoreOrigin.getCheckPoint() <= 9) {
            do {
                giocatoreTemp = new Player(giocatoreOrigin);

                switch (giocatoreTemp.getCheckPoint()) {
                    case 0:
                        Chapter0 cap0 = new Chapter0(giocatoreTemp);
                        giocatoreTemp = cap0.inizia();
                        break;
                    case 1:
                        Chapter1 cap1 = new Chapter1(giocatoreTemp);
                        giocatoreTemp = cap1.inizia();
                        break;
                    case 2:
                        Chapter2 cap2 = new Chapter2(giocatoreTemp);
                        giocatoreTemp = cap2.inizia();
                        break;
                    case 3:
                        Chapter3 cap3 = new Chapter3(giocatoreTemp);
                        giocatoreTemp = cap3.inizia();
                        break;
                    case 4:
                        Chapter4 cap4 = new Chapter4(giocatoreTemp);
                        giocatoreTemp = cap4.inizia();
                        break;
                    case 5:
                        Chapter5 cap5 = new Chapter5(giocatoreTemp);
                        giocatoreTemp = cap5.inizia();
                        break;
                    case 6:
                        Chapter6 cap6 = new Chapter6(giocatoreTemp);
                        giocatoreTemp = cap6.inizia();
                        break;
                    case 7:
                        Chapter7 cap7 = new Chapter7(giocatoreTemp);
                        giocatoreTemp = cap7.inizia();
                        break;

                    case 8:
                        Chapter8 cap8 = new Chapter8(giocatoreTemp);
                        giocatoreTemp = cap8.inizia();
                        break;

                    default:
                        GameOutput.titolo();
                        GameOutput.mostra_the_end();
                        GameOutput.pausa_output();
                        break;
                }

                if (giocatoreTemp.getCheckPoint() == giocatoreOrigin.getCheckPoint()) {
                    flag = false;
                } else if (giocatoreTemp.getCheckPoint() == (giocatoreOrigin.getCheckPoint() + 1)) {
                    giocatoreOrigin = new Player(giocatoreTemp);
                    salvataggi.salvaFile(giocatoreOrigin, giocatoreOrigin.getSalvataggio());
                    AppOutput.mostra_salvataggio_completato();
                    GameOutput.pausa_output();
                } else if (giocatoreOrigin.getCheckPoint() == 8 && (!giocatoreOrigin.getZaino().ricerca_oggetto("sogno") || !giocatoreOrigin.getZaino().ricerca_oggetto("elmo")
                        || !giocatoreOrigin.getZaino().ricerca_oggetto("armatura")) && giocatoreTemp.getCheckPoint() == -1) {
                    flag = false;
                    salvataggi.cancellaFile(giocatoreOrigin.getSalvataggio());
                    AppOutput.mostra_nuovo_schermo();
                    GameOutput.mostra_errore_finale();
                    GameOutput.pausa_output();
                    AppOutput.mostra_nuovo_schermo();
                    GameOutput.separatore();
                    AppOutput.mostra_errore_caricamento();
                    AppOutput.mostra_errore_caricamento();
                    AppOutput.mostra_errore_caricamento();
                    GameOutput.pausa_output();
                    AppOutput.mostra_nuovo_schermo();
                    GameOutput.err_codice_binario(3);
                    pausa_esecuzione(1500);
                    AppOutput.mostra_nuovo_schermo();
                    GameOutput.mostra_game_over();
                    pausa_esecuzione(2250);
                    AppOutput.mostra_cancellazione_file();
                }

                System.gc();
                AppOutput.mostra_nuovo_schermo();
            } while (flag);
        } else {
            AppOutput.mostra_errore_caricamento();
        }
    }

    public static void pausa_esecuzione(long durata) {
        try {
            Thread.sleep(durata);
        } catch (InterruptedException ex) {
            System.err.println("\n\nERRORE:\tE' avvenuta un'interruzione del processo.\n\n");
            Logger.getLogger(AppLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
