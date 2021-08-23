package control.game;

import boundary.GameOutput;
import boundary.StoryOutput;
import entity.Commands;
import entity.Player;
import entity.AdvObject;
import entity.CommandType;
import java.util.HashSet;
import java.util.Set;
import utils.ParserOutput;

public class Chapter4 extends Chapter {

    public Chapter4(Player giocatore) {
        super(giocatore);
    }

    @Override
    protected void init_lists() {

        setNumeroFasi(14);
        Commands help = new Commands(CommandType.HELP, "aiuto");
        help.setAlias(new String[]{"comandi?", "listacomandi", "help", "mostracomandi", "aiutocomandi", "lista"});
        getComandi().add(help);
        Commands inventario = new Commands(CommandType.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv", "i", "I"});
        getComandi().add(inventario);
        Commands osserva = new Commands(CommandType.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"controlla", "analizza", "guarda", "vedi", "avvicinati", "ispeziona", "esamina"});
        getComandi().add(osserva);
        Commands apri = new Commands(CommandType.APRI, "apri");
        apri.setAlias(new String[]{"entra"});
        getComandi().add(apri);
        Commands prendi = new Commands(CommandType.PRENDI, "prendi");
        prendi.setAlias(new String[]{"raccogli", "acquisisci", "conserva"});
        getComandi().add(prendi);
        Commands cammina = new Commands(CommandType.CAMMINA, "cammina");
        cammina.setAlias(new String[]{"avanza", "prosegui", "continua", "percorri", "vai", "attraversa"});
        getComandi().add(cammina);
        getComandi().get(5).setUsabile(true);
        Commands ripara = new Commands(CommandType.RIPARA, "ripara");
        ripara.setAlias(new String[]{"aggiusta", "sistema"});
        getComandi().add(ripara);
        Commands speciale = new Commands(CommandType.SPECIALE, "spegni&&riaccendi");
        speciale.setAlias(new String[]{"spegni&riaccendi"});
        getComandi().add(speciale);
        Commands accetta = new Commands(CommandType.ACCETTA, "accetta");
        accetta.setAlias(new String[]{"si", "SI", "certo"});
        getComandi().add(accetta);
        Commands rifiuta = new Commands(CommandType.RIFIUTA, "rifiuta");
        rifiuta.setAlias(new String[]{"no", "NO"});
        getComandi().add(rifiuta);

        getOggetti().add(crea_computer());
        getOggetti().add(crea_moneta());
        getOggetti().add(crea_monete());
        getOggetti().add(crea_manichino());
        getOggetti().add(crea_porta_torrione());
        cambia_stato_oggetto("portadeltorrione", 7, true);
        getOggetti().add(crea_mano());

    }

    private AdvObject crea_computer() {
        AdvObject computer = new AdvObject("computer");
        Set<String> alias = new HashSet<>();
        alias.add("ilcomputer");
        alias.add("pc");
        alias.add("ilpc");
        alias.add("portatile");
        alias.add("ilportatile");
        computer.setAlias(alias);

        return computer;
    }

    private AdvObject crea_moneta() {
        AdvObject moneta = new AdvObject("moneta");
        Set<String> alias = new HashSet<>();
        alias.add("lamoneta");
        alias.add("soldo");
        alias.add("ilsoldo");
        moneta.setAlias(alias);

        return moneta;

    }

    private AdvObject crea_monete() {
        AdvObject moneta = new AdvObject("monete");
        Set<String> alias = new HashSet<>();
        alias.add("lemonete");
        alias.add("soldi");
        alias.add("isoldi");
        moneta.setAlias(alias);

        return moneta;

    }

    private AdvObject crea_manichino() {
        AdvObject manichino = new AdvObject("manichino");
        Set<String> alias = new HashSet<>();
        alias.add("ilmanichino");
        alias.add("fantoccio");
        alias.add("ilfantoccio");
        manichino.setAlias(alias);

        return manichino;
    }

    private AdvObject crea_porta_torrione() {
        AdvObject portaTorrione = new AdvObject("portadeltorrione");
        Set<String> alias = new HashSet<>();
        alias.add("laportadeltorrione");
        alias.add("portatorrione");
        alias.add("porta");
        alias.add("laporta");
        alias.add("torrione");
        alias.add("iltorrione");
        portaTorrione.setAlias(alias);

        return portaTorrione;
    }

    private AdvObject crea_mano() {
        AdvObject mano = new AdvObject("mano");
        Set<String> alias = new HashSet<>();
        alias.add("lamano");
        alias.add("mani");
        alias.add("lemani");
        mano.setAlias(alias);

        return mano;
    }

    @Override
    protected String[] init_output() {
        String[] outCapitolo4 = new String[20];
        outCapitolo4[0] = " " + getGiocatore().getNome() + " :\n\tWooow, ora la porta si affaccia su delle mura altissime... Il paesaggio e' davvero spettacolare, \n"
                + "\tho paura di dove mi potrebbe portare questo sentiero ma non credo di avere scelta dopotutto. \n"
                + "\tIl cielo e' di un blu intenso, mi chiedo che ore si saranno fatte.\n";
        outCapitolo4[1] = " " + getGiocatore().getNome() + " :\n\tSe non fosse cosi' strana tutta questa situazione mi godrei meglio la vista, \n"
                + "\te' davvero straordinaria. Ora che guardo meglio, queste mura circondano un enorme castello in rovina. \n"
                + "\tChe sia quello rappresentato nel quadro della stanza precedente? \n"
                + "\tDall'altra parte invece c'e' una buia landa desolata. \n"
                + "\tIl paesaggio sembra cosi' triste, c'e' un silenzio tombale.\n";
        outCapitolo4[2] = " " + getGiocatore().getNome() + " :\n\tCos'e' quello? Dovrei avvicinarmi?\n";
        outCapitolo4[3] = " " + getGiocatore().getNome() + " :\n\tHo le traveggole o quello e' un computer? E' impossibile. \n"
                + "\tNon ci posso credere, ora se ho imparato la lezione non dovrei controllare... Cosa dovrei fare?\n";
        outCapitolo4[4] = " " + getGiocatore().getNome() + " :\n\tIo ne ho proprio abbastanza di computer, ma e' stata la scelta giusta. \n"
                + "\tSembra che lo schermo sia acceso. Potrei provare a vedere se c'e' qualcosa di interessante.\n";
        outCapitolo4[5] = " " + getGiocatore().getNome() + " :\n\t'AAAAAAH!'\n\tUna freccia?!? Una freccia mi ha sfiorato la testa!\n"
                + "\tMa chi sara' stato? Qui non c'e' nessuno. Mi sporgo per dare un'occhiata?\n";
        outCapitolo4[6] = " " + getGiocatore().getNome() + " :\n\tNo, non c'e' proprio nessuno, ma vedo qualcosa li'. \n"
                + "\tAh, e' solo una stupida vecchia moneta incastrata in una crepa di queste mura.\n";
        outCapitolo4[7] = " " + getGiocatore().getNome() + " :\n\tOra meglio ritornare a quello che stavo facendo. Nooo! il computer!\n"
                + "\tLa freccia lo ha centrato in pieno! Ormai e' completamente andato. \n"
                + "\tMeglio cosi', o forse no? Aah ma davvero cosa dovrei fare!?!  \n";
        outCapitolo4[8] = " " + getGiocatore().getNome() + " :\n\tNiente da fare, e' proprio rotto. Eppure un modo ci deve essere...\n";
        outCapitolo4[9] = " " + getGiocatore().getNome() + " :\n\tBeh, di solito questo funziona sempre, ahahahahah...\n\n"
                + "\t\t\tIl miglior BUGFIX in assoluto!\n";
        outCapitolo4[10] = " " + getGiocatore().getNome() + " :\n\tMa quanto di quello che vedo sara' reale... \n"
                + "\tFino ad ora mi e' sembrato tutto una gigantesca simulazione, \n"
                + "\tnon riesco ancora a credere a quello che mi sta capitando. \n";
        outCapitolo4[11] = " " + getGiocatore().getNome() + " :\n\tCome ci sono finito io qui? \n"
                + "\tRimarro' davvero intrappolato o riusciro' ad uscire da questo gioco infernale? \n"
                + "\tSpero che alla fine si riveli essere tutto un brutto sogno. \n"
                + "\tIn ogni caso non sto riuscendo a svegliarmi.\n";
        outCapitolo4[12] = " " + getGiocatore().getNome() + " :\n\tA quanto pare devo assecondare ancora la follia di chi ha creato tutto questo.\n"
                + "\tVorrei tanto tornare a casa. \n"
                + "\tMa c'e' dell'altro qui.\n";
        outCapitolo4[13] = " " + getGiocatore().getNome() + " :\n\tUn manichino... impalato? E' davvero orribile, che scena inquietante.  \n"
                + "\tQuesto coso mi fa venire i brividi. Che strano, ha solo un braccio, ed e' in pessime condizioni.\n"
                + "\tSembra come se qualcuno si fosse accanito contro di lui.\n"
                + "\tCos'ha in mano???\n";
        outCapitolo4[14] = " " + getGiocatore().getNome() + " :\n\tMhh, due monete...\n";
        outCapitolo4[15] = " " + getGiocatore().getNome() + " :\n\tMeglio continuare per la mia strada adesso.\n";
        outCapitolo4[16] = " " + getGiocatore().getNome() + " :\n\tHo cosi' tanti pensieri per la testa, Kekko4K_Designer, che nome! \n"
                + "\tSi e' letterelamente polverizzato dopo che ho superato quella che doveva essere la sua prova,\n"
                + "\tchissa' cosa accadra' piu' avanti. \n"
                + "\tDovrebbero essercene altri due. Cosa avranno escogitato per tenermi bloccato? \n";
        outCapitolo4[17] = " " + getGiocatore().getNome() + " :\n\tMi chiedo chi, o cosa, siano davvero questi tipi, cosa li spinga a comportarsi \n"
                + "\tin questa maniera e come sia possibile questo pandemonio digitale. \n";
        outCapitolo4[18] = " " + getGiocatore().getNome() + " :\n\tPoi quel giornale... Perche' farmelo trovare per poi farlo scomparire \n"
                + "\tnel momento stesso in cui ho iniziato a leggerlo. Parlava di tre malcapitati, che tragedia.\n"
                + "\tQuanti punti interrogativi... Questa storia diventa sempre piu' un mistero.\n";
        outCapitolo4[19] = " " + getGiocatore().getNome() + " :\n\tFinalmente sono arrivato alla fine di questa cinta di mura. \n"
                + "\tOra davanti a me ho un torrione. Cosa si celera' dietro questa porta?\n";

        return outCapitolo4;
    }

    @Override
    protected int gioca_avventura(ParserOutput p, StoryOutput storia, int i) {

        if (i > 0 && p.getOggetto() != null && p.getPersonaggi() == null) {
            switch (p.getOggetto().getNome()) {
                case "computer":
                    if (p.getComandi().getNome().equals("ripara")) {
                        i = 6;
                    } else if (p.getComandi().getNome().equals("spegni&&riaccendi")) {
                        i = 7;
                    }
                case "moneta":
                    if (p.getComandi().getNome().equals("prendi")) {
                        i = 5;
                    }
                    break;

                case "monete":
                    if (p.getComandi().getNome().equals("prendi")) {
                        i = 11;
                    }
                    break;
                case "mano":
                    i = 10;
                    break;

                case "porta":
                    i = 13;
                    break;
            }

        } else if (i >= 0 && p.getOggetto() == null) {
            switch (p.getComandi().getNome()) {
                case "accetta":
                    if (i == 1) {
                        i = 1;
                    } else {
                        i = 3;
                    }
                    break;
                case "rifiuta":
                    if (i == 3) {
                        i = 4;
                    }
                    if (i != 3 && i != 4) {
                        i = 8;
                    } else {
                        i = 4;
                    }

                    break;

                case "cammina":
                    switch (i) {
                        case 1:
                        case 2:
                        case 5:
                        case 7:
                        case 8:
                            i = 8;
                            break;
                        case 3:
                        case 6:
                            i = 4;
                            break;
                        case 11:
                        case 12:
                            i = 12;
                            break;

                    }
                    break;

            }
        }

        switch (i) {
            case 0: // attraversa o attraversa porta
                storia.mostra(1);
                GameOutput.pausa_output();
                storia.mostra(2);
                GameOutput.pausa_output();
                storia.mostra(3);
                cambia_stato_oggetto("portadeltorrione", 7, false);
                getComandi().get(2).setUsabile(true);
                getComandi().get(8).setUsabile(true);
                getComandi().get(9).setUsabile(true);
                break;

            case 1://accetta o osserva
                storia.mostra(4);
                getComandi().get(8).setUsabile(false);
                getComandi().get(2).setUsabile(false);
                cambia_stato_oggetto("computer", 2, true);
                getComandi().get(9).setUsabile(false);

                break;

            case 2://controlla o osserva computer
                storia.mostra(5);
                GameOutput.pausa_output();
                storia.mostra(6);
                getComandi().get(8).setUsabile(true);
                cambia_stato_oggetto("computer", 2, false);
                getComandi().get(2).setUsabile(true);
                getComandi().get(9).setUsabile(true);
                break;

            case 3://dai un occhiata o accetta 
                storia.mostra(7);
                cambia_stato_oggetto("moneta", 8, true);
                break;

            case 4:   //continua senza dare un occhiata 
                storia.mostra(8);
                getComandi().get(8).setUsabile(false);
                cambia_stato_oggetto("computer", 1, true);
                getComandi().get(2).setUsabile(false);
                getComandi().get(9).setUsabile(false);
                break;

            case 5://raccogli moneta
                if (!getGiocatore().getZaino().ricerca_oggetto("moneta")) {
                    getGiocatore().getZaino().aggiungi_oggetto(crea_moneta(), 1);
                    cambia_stato_oggetto("moneta", 8, false);
                } else {
                    getGiocatore().getZaino().aggiungi_oggetto(getGiocatore().getZaino().cerca_oggetto("moneta"), 1);
                    cambia_stato_oggetto("moneta", 8, false);
                }
                GameOutput.oggetto_aggiunto(crea_moneta());
                break;

            case 6:// ripara/ aggiusta computer
                storia.mostra(9);
                cambia_stato_oggetto("computer", 1, false);
                cambia_stato_oggetto("computer", 10, true);
                getComandi().get(7).setUsabile(true);
                break;

            case 7: //spegni&&riaccendi

                getJukeBox().setTitle("Windows-Error-Remix");
                getJukeBox().play();
                getJukeBox().setVol(-30);
                getJukeBox().repeat(1000);
                storia.mostra(10);
                cambia_stato_oggetto("computer", 10, false);
                getComandi().get(7).setUsabile(false);
                break;

            case 8: // continua
                storia.mostra(11);
                GameOutput.pausa_output();
                storia.mostra(12);
                GameOutput.pausa_output();
                storia.mostra(13);
                cambia_stato_oggetto("manichino", 2, true);
                getComandi().get(9).setUsabile(false);
                getComandi().get(8).setUsabile(false);
                getComandi().get(5).setUsabile(false);
                getComandi().get(2).setUsabile(true);
                break;

            case 9: //osserva 
                storia.mostra(14);
                cambia_stato_oggetto("mani", 2, true);
                cambia_stato_oggetto("manichino", 2, false);
                getComandi().get(2).setUsabile(false);

                break;

            case 10: //osserva mani
                storia.mostra(15);
                cambia_stato_oggetto("monete", 8, true);
                getComandi().get(5).setUsabile(true);

                break;

            case 11: //raccogli monete
                if (!getGiocatore().getZaino().ricerca_oggetto("moneta")) {
                    getGiocatore().getZaino().aggiungi_oggetto(crea_moneta(), 2);
                    cambia_stato_oggetto("monete", 8, false);
                } else {
                    getGiocatore().getZaino().aggiungi_oggetto(getGiocatore().getZaino().cerca_oggetto("moneta"), 2);
                    cambia_stato_oggetto("monete", 8, false);
                }
                GameOutput.oggetto_aggiunto(crea_monete());
                break;

            case 12: //continua
                storia.mostra(16);
                storia.mostra(17);
                GameOutput.pausa_output();
                storia.mostra(18);
                storia.mostra(19);
                GameOutput.pausa_output();
                storia.mostra(20);
                cambia_stato_oggetto("portadeltorrione", 3, true);
                break;

            case 13://apri porta

                break;

        }

        i++;

        return i;
    }

    @Override
    protected void introduzione_capitolo() {
        System.out.println(" " + getGiocatore().getNome() + " :\n\tE adesso cosa faccio...? Sono ritornato al punto di partenza. \n"
                + "\tQuesta volta pero' al di la' della porta non vedo lo stesso terrificante corridoio di zeri e uno. \n"
                + "\tMi sembra di intravedere… Il CIELO?!\n");

    }

}
