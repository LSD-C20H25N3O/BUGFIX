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
import windows.Home;

public class Chapter1 extends Chapter {

    public Chapter1(Player gctr) {
        super(gctr);
    }

    @Override
    protected void init_lists() {
        setNumeroFasi(14);
        Commands inventario = new Commands(CommandType.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv", "i", "I"});
        getComandi().add(inventario);
        Commands usa = new Commands(CommandType.USA, "usa");
        usa.setAlias(new String[]{"usa", "utilizza"});
        getComandi().add(usa);
        Commands osserva = new Commands(CommandType.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"controlla", "analizza", "guarda", "vedi", "avvicinati", "ispeziona", "esamina"});
        getComandi().add(osserva);
        Commands tocca = new Commands(CommandType.TOCCA, "tocca");
        tocca.setAlias(new String[]{"palpa", "tangi"});
        getComandi().add(tocca);
        Commands collega = new Commands(CommandType.COLLEGA, "collega");
        collega.setAlias(new String[]{"unisci", "connetti"});
        getComandi().add(collega);
        Commands spingi = new Commands(CommandType.SPINGI, "spingi");
        spingi.setAlias(new String[]{"muovi", "respingi", "premi", "sposta"});
        getComandi().add(spingi);
        Commands apri = new Commands(CommandType.APRI, "apri");
        apri.setAlias(new String[]{"entra"});
        getComandi().add(apri);
        Commands prendi = new Commands(CommandType.PRENDI, "prendi");
        prendi.setAlias(new String[]{"raccogli", "acquisisci", "conserva"});
        getComandi().add(prendi);
        Commands cammina = new Commands(CommandType.CAMMINA, "cammina");
        cammina.setAlias(new String[]{"avanza", "prosegui", "continua", "percorri", "vai", "vaiavanti"});
        getComandi().add(cammina);
        Commands help = new Commands(CommandType.HELP, "aiuto");
        help.setAlias(new String[]{"comandi?", "listacomandi", "help", "mostracomandi", "aiutocomandi"});
        getComandi().add(help);

        getOggetti().add(crea_pavimento_iniziale());
        getOggetti().add(crea_cavo());
        getOggetti().add(crea_porta_ingresso_home());
        getOggetti().add(crea_baule());
        getOggetti().add(crea_legnetto());
        getOggetti().add(crea_zaino());
        getOggetti().add(crea_quadro_home());
        getOggetti().add(crea_chiave_home());
        getOggetti().add(crea_porta_uscita_home());
        getOggetti().add(crea_stanza());
        getOggetti().add(crea_corridoio());

    }

    @Override
    protected String[] init_output() {
        String[] outCapitolo1 = new String[14];

        outCapitolo1[0] = " " + getGiocatore().getNome() + " :\n\tMa dove sono finito... E' tutto buio, non sono piu' nella mia stanza.\n"
                + "\tChe dicevano quei tipi?! Di che parlavano?! Non ho avuto nemmeno il tempo  di\n"
                + "\trealizzare cosa stesse succedendo... Mi sento cosi'... Vuoto.\n";
        outCapitolo1[1] = " " + getGiocatore().getNome() + " :\n\tDavvero, non riesco a capire. Mi sembra di essere in un sogno. Sara\n"
                + "\tmai vero quello che mi hanno detto? Mi sento davvero strano. Non ho nulla \n"
                + "\ta che fare con quei tre... Volevo solamente provare quel dannato gioco. Guarda \n"
                + "\tdove sono finito!\n";
        outCapitolo1[2] = " " + getGiocatore().getNome() + " :\n\tCi devo capire qualcosa, ma prima sarebbe il caso di riuscire a vedere \n"
                + "\tdove mi trovo. Ho la schiena appoggiata ad un muro, sembra che vibri. Saro'\n"
                + "\tsicuramente in una stanza. Cos'ho sotto i piedi?  E' il caso di controllare.\n";
        outCapitolo1[3] = " " + getGiocatore().getNome() + " :\n\tToccando sembrano essere dei cavi, forse due spinotti. Sono staccati. \n"
                + "\tNon so se dovrei collegarli...cosa faccio?\n";
        outCapitolo1[4] = " " + getGiocatore().getNome() + " :\n\tOH, finalmente un po' di luce. Meglio guardare un po' in giro. \n\n"
                + " " + getGiocatore().getNome() + " :\n\tMA DOVE SONO?! Sono circondato da pareti assurde: sono di un \n"
                + "\tprofondo nero nel quale scorrono infinite cascate di zeri e uno di\n"
                + "\tun verde intenso. Il soffitto ed il pavimento sono fatti allo stesso\n"
                + "\tmodo. Sono chiuso in questa specie di scatola stramba e agghiacciante.\n"
                + "\tNon ho null'altro intorno. Il cavo che ho collegato prima sta pian\n"
                + "\tpiano venendo inghiottito dalla parete. Che paura!\n"
                + "\tLa stanza e' totalmente vuota. Vedo una piccola luce provenire dal\n"
                + "\tmuro di fronte. Ci sara' qualche porta nascosta?\n";
        outCapitolo1[5] = " " + getGiocatore().getNome() + " :\n\tQuesto pezzo di parete sembra essere rientrante. Magari \n"
                + "\tporta da qualche parte.\n";
        outCapitolo1[6] = " " + getGiocatore().getNome() + " :\n\tSi e' spostato, avevo ragione.\n"
                + "\tMa che posto sara' mai questo? Un'altra stanza\n"
                + "\tmai vista prima d'ora.\n";
        outCapitolo1[7] = " " + getGiocatore().getNome() + " :\n\tE' piu' grande della prima. Sembra essere entrati in un castello, ma \n"
                + "\tsui muri ci sono squarci che mostrano pareti come quelle della stanza\n"
                + "\tprecedente. Sulla destra ho una porta. Poi ci sono degli oggetti: \n"
                + "\tun quadro, uno zaino ed  baule. Cosa faccio?\n ";
        outCapitolo1[8] = " " + getGiocatore().getNome() + " :\n\tE' davvero un vecchio baule. Aprendolo ne ho rotto i cardini.\n"
                + "\tDentro c'e' uno strano pezzo di legno a forma di Y, sembra \n"
                + "\tessere l'impugnatura di una FIONDA. \n";
        outCapitolo1[9] = " " + getGiocatore().getNome() + " :\n\tE' un quadro raffigurante un castello, con in primo piano quelli che devono \n"
                + "\tessere il re, la regina e forse la principessa. Ma della principessa non \n"
                + "\triesco a vederne il volto... C'e' uno squarcio, lo stesso delle pareti della \n"
                + "\tstanza. Come anche in altri punti del dipinto.\n";
        outCapitolo1[10] = " " + getGiocatore().getNome() + " :\n\tHo sentito uno strano rumore. Come se qualcosa fosse caduto.\n"
                + "\tPer terra c'e' una CHIAVE!	\n ";
        outCapitolo1[11] = " " + getGiocatore().getNome() + " :\n\tE' una vecchia sacca, e' molto spaziosa, dopo potrebbe tornarmi utile.\n ";
        outCapitolo1[12] = " " + getGiocatore().getNome() + " :\n\tLa porta e' chiusa.\n";
        outCapitolo1[13] = " " + getGiocatore().getNome() + " :\n\tForse questa chiave aprira' la porta. \n"
                + "\tE' proprio cosi'. La porta adesso si e' aperta. Davanti a me c'e'\n"
                + "\tun corridoio lungo e stretto. Anche qui ci sono pareti nere, ma \n"
                + "\tquesta volta il tutto e' illuminato dagli zeri e uno, che sono di\n"
                + "\tun verde vivido e brillante.\n";

        return outCapitolo1;

    }

    private AdvObject crea_pavimento_iniziale() {
        AdvObject pavimento = new AdvObject("pavimento");
        Set<String> alias = new HashSet<>();
        alias.add("ilpavimento");
        alias.add("piede");
        alias.add("ilpiede");
        alias.add("piedi");
        alias.add("ipiedi");
        alias.add("terra");
        alias.add("aterra");
        alias.add("perterra");
        alias.add("terreno");
        alias.add("ilterreno");
        pavimento.setAlias(alias);
        pavimento.setAnalizzabile(true);

        return pavimento;
    }

    private AdvObject crea_cavo() {
        AdvObject cavo = new AdvObject("cavo");
        Set<String> alias = new HashSet<>();
        alias.add("ilcavo");
        alias.add("cavi");
        alias.add("icavi");
        alias.add("filo");
        alias.add("ilfilo");
        alias.add("fili");
        alias.add("ifili");
        alias.add("spinotto");
        alias.add("lospinotto");
        alias.add("spinotti");
        alias.add("glispinotti");
        cavo.setAlias(alias);

        return cavo;

    }

    private AdvObject crea_porta_ingresso_home() {
        AdvObject portaIngressoHome = new AdvObject("portad'ingresso");
        Set<String> alias = new HashSet<>();
        alias.add("laportad'ingresso");
        alias.add("muro");
        alias.add("ilmuro");
        alias.add("parete");
        alias.add("laparete");
        alias.add("luce");
        alias.add("laluce");
        portaIngressoHome.setAlias(alias);

        return portaIngressoHome;
    }

    private AdvObject crea_baule() {
        AdvObject baule = new AdvObject("baule");
        Set<String> alias = new HashSet<>();
        alias.add("ilbaule");
        alias.add("scrigno");
        alias.add("loscrigno");
        alias.add("contenitore");
        alias.add("ilcontenitore");
        alias.add("cassa");
        alias.add("lacassa");
        alias.add("scatola");
        alias.add("lascatola");
        baule.setAlias(alias);

        return baule;

    }

    private AdvObject crea_legnetto() {
        AdvObject legnetto = new AdvObject("legnetto");
        Set<String> alias = new HashSet<>();
        alias.add("illegnetto");
        alias.add("bastoncino");
        alias.add("ilbastoncino");
        alias.add("legno");
        alias.add("illegno");
        alias.add("impugnatura");
        alias.add("l'impugnatura");
        alias.add("rametto");
        alias.add("ilrametto");
        legnetto.setAlias(alias);

        return legnetto;

    }

    private AdvObject crea_zaino() {
        AdvObject zaino = new AdvObject("zaino");
        Set<String> alias = new HashSet<>();
        alias.add("lozaino");
        alias.add("zainetto");
        alias.add("lozainetto");
        alias.add("sacca");
        alias.add("lasacca");
        alias.add("borsa");
        alias.add("laborsa");
        alias.add("cartella");
        alias.add("lacartella");
        zaino.setAlias(alias);

        return zaino;
    }

    private AdvObject crea_stanza() {
        AdvObject stanza = new AdvObject("stanza");
        Set<String> alias = new HashSet<>();
        alias.add("lastanza");
        alias.add("dintorni");
        alias.add("attorno");
        alias.add("ingiro");
        stanza.setAlias(alias);
        stanza.setAnalizzabile(true);

        return stanza;
    }

    private AdvObject crea_quadro_home() {
        AdvObject quadro = new AdvObject("quadro");
        Set<String> alias = new HashSet<>();
        alias.add("ilquadro");
        alias.add("dipinto");
        alias.add("ildipinto");
        alias.add("rappresentazione");
        alias.add("larappresentazione");
        alias.add("raffigurazione");
        alias.add("laraffigurazione");
        quadro.setAlias(alias);

        return quadro;
    }

    private AdvObject crea_chiave_home() {
        AdvObject chiaveHome = new AdvObject("chiave");
        Set<String> alias = new HashSet<>();
        alias.add("lachiave");
        alias.add("lechiavi");
        alias.add("chiavi");
        chiaveHome.setAlias(alias);

        return chiaveHome;
    }

    private AdvObject crea_porta_uscita_home() {
        AdvObject portaUscitaHome = new AdvObject("portad'uscita");
        Set<String> alias = new HashSet<>();
        alias.add("laportad'uscita");
        alias.add("porta");
        alias.add("laporta");
        alias.add("portone");
        alias.add("ilportone");
        portaUscitaHome.setAlias(alias);

        return portaUscitaHome;
    }

    protected AdvObject crea_corridoio() {
        AdvObject corridoio = new AdvObject("corridoio");
        Set<String> alias = new HashSet<>();
        alias.add("ilcorridoio");
        corridoio.setAlias(alias);

        return corridoio;

    }

    @Override
    protected int gioca_avventura(ParserOutput p, StoryOutput storia, int i) {
        if (i > 4 && p.getPersonaggi() == null && p.getOggetto() != null) {
            switch (p.getOggetto().getNome()) {
                case "baule":
                    i = 5;
                    break;
                case "legnetto":
                    i = 6;
                    break;
                case "quadro":
                    if (p.getComandi().getNome().equals("osserva")) {
                        i = 7;
                    } else {
                        i = 8;
                    }
                    break;
                case "chiave":
                    if (p.getComandi().getNome().equals("prendi")) {
                        i = 9;
                    } else {
                        i = 12;
                    }
                    break;
                case "zaino":
                    i = 10;
                    break;
                case "portad'uscita":
                    i = 11;
                    break;

                case "corridoio":
                    i = 13;
                    break;
                default:
                    break;
            }
        }

        switch (i) {
            case 0: //tocca pavimento
                storia.mostra(4);
                cambia_stato_oggetto("cavo", 1, true);
                cambia_stato_oggetto("stanza", 1, false);
                cambia_stato_oggetto("pavimento", 2, false);
                getComandi().get(4).setUsabile(true);
                getComandi().remove(3);

                break;
            case 1://collega cavi
                storia.mostra(5);
                cambia_stato_oggetto("portad'ingresso", 2, true);
                getComandi().get(3).setUsabile(false);
                getComandi().get(2).setUsabile(true);
                break;
            case 2://osserva muro
                storia.mostra(6);
                cambia_stato_oggetto("portad'ingresso", 9, true);
                getComandi().get(2).setUsabile(false);
                break;
            case 3://spingi muro
                storia.mostra(7);
                getComandi().get(2).setUsabile(true);
                break;
            case 4: //osserva stanza
                Home.run();
                storia.mostra(8);
                cambia_stato_oggetto("baule", 3, true);
                cambia_stato_oggetto("baule", 2, true);
                cambia_stato_oggetto("zaino", 2, true);
                cambia_stato_oggetto("zaino", 8, true);
                cambia_stato_oggetto("quadro", 2, true);
                cambia_stato_oggetto("portad'uscita", 2, true);
                cambia_stato_oggetto("portad'uscita", 3, true);
                getComandi().get(2).setUsabile(false);
                break;
            case 5:// apri baule
                storia.mostra(9);
                cambia_stato_oggetto("baule", 3, false);
                cambia_stato_oggetto("baule", 2, false);
                cambia_stato_oggetto("legnetto", 8, true);
                break;
            case 6:// prendi legnetto
                if (getGiocatore().getZaino().getDisponibilitaInv()) {
                    if (!getGiocatore().getZaino().ricerca_oggetto("legnetto")) {
                        getGiocatore().getZaino().aggiungi_oggetto(crea_legnetto(), 1);
                        GameOutput.oggetto_aggiunto(crea_legnetto());
                    } else {
                        GameOutput.oggetto_unico();
                    }
                } else {
                    GameOutput.assenza_inventario();
                }
                break;
            case 7:// osserva quadro
                storia.mostra(10);
                cambia_stato_oggetto("quadro", 9, true);
                break;
            case 8://sposta quadro
                storia.mostra(11);
                cambia_stato_oggetto("chiave", 8, true);
                cambia_stato_oggetto("quadro", 9, false);
                break;
            case 9://prendi chiave
                if (getGiocatore().getZaino().getDisponibilitaInv()) {
                    if (!getGiocatore().getZaino().ricerca_oggetto("chiave")) {
                        getGiocatore().getZaino().aggiungi_oggetto(crea_chiave_home(), 1);
                        GameOutput.oggetto_aggiunto(crea_chiave_home());
                    } else {
                        GameOutput.oggetto_unico();
                    }
                } else {
                    GameOutput.assenza_inventario();
                }
                break;
            case 10:// prendi zaino
                if (!getGiocatore().getZaino().getDisponibilitaInv()) {
                    storia.mostra(12);
                    getGiocatore().getZaino().setDisponibilitaInv(true);
                    GameOutput.inventario_equipaggiato();
                } else {
                    GameOutput.oggetto_unico();
                }
                break;
            case 11://apri porta
                storia.mostra(13);
                cambia_stato_oggetto("chiave", 1, true);
                break;
            case 12:// usa chiave
                if (getGiocatore().getZaino().ricerca_oggetto("chiave")) {
                    getGiocatore().getZaino().rimuovi_oggetto(getGiocatore().getZaino().cerca_oggetto("chiave"), 1);
                    getOggetti().remove(crea_chiave_home());
                    GameOutput.oggetto_rimosso(crea_chiave_home());
                    storia.mostra(14);
                    cambia_stato_oggetto("corridoio", 7, true);

                } else {
                    GameOutput.oggetto_assente();
                }
                break;
            case 13:// percorri corridoio
                break;
        }
        i++;

        return i;
    }

    @Override
    protected void introduzione_capitolo() {
        StoryOutput dialoghi = new StoryOutput(init_output());

        dialoghi.mostra(1);
        GameOutput.pausa_output();
        dialoghi.mostra(2);
        GameOutput.pausa_output();
        dialoghi.mostra(3);
        getJukeBox().setFadeVolGap((short) 1);
        getJukeBox().setTitle("Electro-Fever");
        getJukeBox().play();
        getJukeBox().setVol(-60);
        getJukeBox().fade_vol(getJukeBox().getVol(), -35);
        getJukeBox().repeat(1000);
    }

}
