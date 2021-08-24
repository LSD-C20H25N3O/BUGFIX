package control.game;

import boundary.StoryOutput;
import boundary.GameOutput;
import entity.Commands;
import entity.Player;
import entity.AdvObject;
import entity.Character;
import entity.CommandType;
import java.util.HashSet;
import java.util.Set;
import utils.ParserOutput;

public class Chapter2 extends Chapter {

    private int Legnetto;

    public int getLegnetto() {
        return Legnetto;
    }

    public void setLegnetto(int Legnetto) {
        this.Legnetto = Legnetto;
    }
    public Chapter2(Player giocatore) {
        super(giocatore);
    }
    
    private void controlla_legnetto(Player giocatore){
    if(giocatore.getZaino().ricerca_oggetto("legnetto")){
        Legnetto=1;
    }else{
        Legnetto=0;
    }
  }

    @Override
    protected void init_lists() {
        setNumeroFasi(17);
        Commands help = new Commands(CommandType.HELP, "aiuto");
        help.setAlias(new String[]{"comandi?", "listacomandi", "help", "mostracomandi", "aiutocomandi"});
        getComandi().add(help);
        Commands inventario = new Commands(CommandType.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv", "i", "I"});
        getComandi().add(inventario);
        Commands usa = new Commands(CommandType.USA, "usa");
        usa.setAlias(new String[]{"usa", "utilizza"});
        getComandi().add(usa);
        Commands osserva = new Commands(CommandType.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"controlla", "analizza", "guarda", "vedi", "avvicinati", "ispeziona", "esamina"});
        getComandi().add(osserva);
        getComandi().get(3).setUsabile(true);
        Commands spingi = new Commands(CommandType.SPINGI, "spingi");
        spingi.setAlias(new String[]{"muovi", "premi", "sposta"});
        getComandi().add(spingi);
        Commands apri = new Commands(CommandType.APRI, "apri");
        apri.setAlias(new String[]{"entra"});
        getComandi().add(apri);
        Commands prendi = new Commands(CommandType.PRENDI, "prendi");
        prendi.setAlias(new String[]{"raccogli", "acquisisci", "conserva"});
        getComandi().add(prendi);
        Commands cammina = new Commands(CommandType.CAMMINA, "cammina");
        cammina.setAlias(new String[]{"avanza", "prosegui", "continua", "percorri", "vai", "attraversa"});
        getComandi().add(cammina);
        Commands costruisci = new Commands(CommandType.COSTRUISCI, "costruisci");
        costruisci.setAlias(new String[]{"fai", "crea", "forma", "combina"});
        getComandi().add(costruisci);
        Commands parla = new Commands(CommandType.PARLA, "parla");
        parla.setAlias(new String[]{"conversa", "chiaccera", "discuti"});
        getComandi().add(parla);
        Commands ripara = new Commands(CommandType.RIPARA, "ripara");
        ripara.setAlias(new String[]{"aggiusta", "incastra", "inserisci", "sistema"});
        getComandi().add(ripara);
        Commands cedi = new Commands(CommandType.CEDI, "cedi");
        cedi.setAlias(new String[]{"dai", "dona", "regala"});
        getComandi().add(cedi);
        Commands torna = new Commands(CommandType.TORNA, "torna");
        torna.setAlias(new String[]{"ritorna"});
        getComandi().add(torna);

        getOggetti().add(crea_fionda());
        getOggetti().add(crea_masso());
        getOggetti().add(crea_pietruzza());
        getOggetti().add(crea_rovine());
        getOggetti().add(crea_ponte());
        getOggetti().add(crea_ghianda());
        getOggetti().add(crea_elastico());
        getOggetti().add(crea_porta_giardino());
        getOggetti().add(crea_albero());
        getOggetti().add(crea_foglie());
        getOggetti().add(crea_numero());
        getOggetti().add(crea_legnetto());
        getOggetti().add(crea_corridoio());
        getPersonaggi().add(crea_scoiattolo());
        getOggetti().add(crea_stanza());
        cambia_stato_oggetto("stanza", 2, true);
        getOggetti().add(crea_precedente());
        cambia_stato_oggetto("indietro", 1, true);
    }

    private AdvObject crea_fionda() {
        AdvObject fionda = new AdvObject("fionda");
        Set<String> alias = new HashSet<>();
        alias.add("lafionda");
        fionda.setAlias(alias);
        fionda.setUtilizzabile(true);

        return fionda;
    }

    private AdvObject crea_masso() {
        AdvObject masso = new AdvObject("masso");
        Set<String> alias = new HashSet<>();
        alias.add("ilmasso");
        alias.add("roccia");
        alias.add("laroccia");
        masso.setAlias(alias);

        return masso;
    }

    private AdvObject crea_pietruzza() {
        AdvObject pietruzza = new AdvObject("pietruzza");
        Set<String> alias = new HashSet<>();
        alias.add("lapietruzza");
        alias.add("roccia");
        alias.add("laroccia");
        alias.add("rocce");
        alias.add("lerocce");
        alias.add("pietra");
        alias.add("lapietra");
        alias.add("pietre");
        alias.add("lepietre");
        alias.add("pietruzze");
        alias.add("lepietruzze");
        alias.add("sasso");
        alias.add("ilsasso");
        alias.add("sassi");
        alias.add("isassi");
        alias.add("sassolino");
        alias.add("ilsassolino");
        alias.add("sassolini");
        alias.add("isassolini");
        pietruzza.setAlias(alias);

        return pietruzza;
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

    private AdvObject crea_rovine() {
        AdvObject rovine = new AdvObject("rovine");
        Set<String> alias = new HashSet<>();
        alias.add("lerovine");
        alias.add("spazzatura");
        alias.add("laspazzatura");
        alias.add("rifiuti");
        alias.add("irifiuti");
        rovine.setAlias(alias);

        return rovine;
    }

    private AdvObject crea_ponte() {
        AdvObject ponte = new AdvObject("ponte");
        Set<String> alias = new HashSet<>();
        alias.add("ilponte");
        ponte.setAlias(alias);

        return ponte;
    }

    private AdvObject crea_ghianda() {
        AdvObject ghianda = new AdvObject("ghianda");
        Set<String> alias = new HashSet<>();
        alias.add("laghianda");
        alias.add("ghiande");
        alias.add("leghiande");
        ghianda.setAlias(alias);

        return ghianda;
    }

    private AdvObject crea_elastico() {
        AdvObject elastico = new AdvObject("elastico");
        Set<String> alias = new HashSet<>();
        alias.add("l'elastico");
        alias.add("cordicella");
        alias.add("lacordicella");
        alias.add("corda");
        alias.add("lacorda");
        elastico.setAlias(alias);

        return elastico;
    }

    private AdvObject crea_porta_giardino() {
        AdvObject portaGiardino = new AdvObject("portagiardino");
        Set<String> alias = new HashSet<>();
        alias.add("portagiardino");
        alias.add("porta");
        alias.add("laporta");
        alias.add("lasequenza");
        portaGiardino.setAlias(alias);

        return portaGiardino;
    }

    private AdvObject crea_albero() {
        AdvObject albero = new AdvObject("albero");
        Set<String> alias = new HashSet<>();
        alias.add("l'albero");
        alias.add("cipresso");
        alias.add("ilcipresso");
        albero.setAlias(alias);
        albero.setAnalizzabile(true);

        return albero;
    }

    private AdvObject crea_foglie() {
        AdvObject foglie = new AdvObject("foglie");
        Set<String> alias = new HashSet<>();
        alias.add("lefoglie");
        alias.add("foglia");
        alias.add("lafoglia");
        alias.add("chioma");
        alias.add("lachioma");
        foglie.setAlias(alias);

        return foglie;
    }

    private AdvObject crea_numero() {
        AdvObject numero = new AdvObject("numero");
        Set<String> alias = new HashSet<>();
        alias.add("ilnumero");
        alias.add("numeri");
        alias.add("inumeri");
        alias.add("cosa");
        alias.add("lacosa");
        alias.add("pezzo");
        alias.add("ilpezzo");
        alias.add("sequenza");
        alias.add("lasequenza");
        numero.setAlias(alias);

        return numero;
    }

    private Character crea_scoiattolo() {
        Set<String> alias = new HashSet<>();
        Character scoiattolo = new Character("scoiattolo");
        alias.add("loscoiattolo");
        alias.add("animale");
        alias.add("conanimale");
        alias.add("l'animale");
        alias.add("animaletto");
        alias.add("l'animaletto");
        alias.add("roditore");
        alias.add("ilroditore");
        alias.add("piccolo");
        alias.add("ilpiccolo");
        alias.add("piccolino");
        alias.add("ilpiccolino");
        alias.add("conloscoiattolo");
        alias.add("conscoiattolo");
        alias.add("conilroditore");
        scoiattolo.setAlias(alias);

        return scoiattolo;
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

    private AdvObject crea_corridoio() {
        AdvObject corridoio = new AdvObject("corridoio");
        Set<String> alias = new HashSet<>();
        alias.add("ilcorridoio");
        corridoio.setAlias(alias);

        return corridoio;
    }

    private AdvObject crea_precedente() {
        AdvObject precedente = new AdvObject("indietro");
        Set<String> alias = new HashSet<>();
        alias.add("nellastanzaprecedente");
        alias.add("allastanzaprecedente");
        alias.add("stanzaprecedente");
        precedente.setAlias(alias);

        return precedente;
    }

    @Override
    protected String[] init_output() {
        String[] outCapitolo2 = new String[26];

        outCapitolo2[0] = " " + getGiocatore().getNome() + " :\n\tAlla mia sinistra vedo una roccia enorme con ai suoi piedi numerose pietruzze mischiate \n"
                + "\tad altri maledetti zeri e uno. Dall'altra parte, a destra, un ammasso di rovine e spazzatura. \n"
                + "\tChe cosa disgustosa.\n";
        outCapitolo2[1] = " " + getGiocatore().getNome() + " :\n\tPer usare la fionda mi servirebbe un elastico... Ed anche qualcosa da lanciare. \n";
        outCapitolo2[2] = " " + getGiocatore().getNome() + " :\n\tQuesto masso e' davvero enorme... e qui? C'e' una marea di sassi e anche di quegli strani numeri.\n"
                + "\tDavvero assurdo, sembrano essere qualcosa di materiale, con una dimensione, mi spaventa troppo toccarli. \n"
                + "\tMai visto niente del genere prima d'ora.\n";
        outCapitolo2[3] = " " + getGiocatore().getNome() + " :\n\tChe schifo... cos'e'? Cibo avariato... delle ghiande... e dei mattoni... \n"
                + "\tMagari spostando qualche masso trovo altro.\n";
        outCapitolo2[4] = " " + getGiocatore().getNome() + " :\n\tOh, ho trovato quello che sembrerebbe un elastico, forse potrei farne un buon uso.\n";
        outCapitolo2[5] = " " + getGiocatore().getNome() + " :\n\tNon e' granche' ma sembrerebbe funzionare.\n"
                + "\t*Tira l'elastico per fare una breve prova* \n";
        outCapitolo2[6] = " " + getGiocatore().getNome() + " :\n\t... Funziona, SI! Ora prendendo bene la mira dovrei... Vai! Sono riuscito a colpire ed attivare la leva.\n"
                + "\tIl ponte si e' abbassato.\n";
        outCapitolo2[7] = " " + getGiocatore().getNome() + " :\n\tSperiamo che queste travi reggano il mio peso. Riecheggia un rumore fortissimo! \n"
                + "\tE' sicuramente questa gigantesca cascata che sgorga della parete sinistra del giardino... \n"
                + "\tAnche la cascata e' cosi' assurda... Inizia con della normalissima acqua ma scorrendo questa \n"
                + "\tsi trasforma in zeri e uno. Non riesco a vedere dove va a finire. \n"
                + "\tE' come se prima di arrivare sul fondo della voragine si smaterializzasse, \n"
                + "\tma fa comunque un enorme frastuono.\n";
        outCapitolo2[8] = " " + getGiocatore().getNome() + " :\n\tFinalmente ho superato il ponte. A destra vedo esserci un cipresso, mentre davanti... \n"
                + "\tOh no, ancora un'altra porta.\n";
        outCapitolo2[9] = " " + getGiocatore().getNome() + " :\n\tHa un fregio particolarissimo: la testa di un drago dall'espressione mansueta.\n"
                + "\tSembra non esserci serratura ed ovviamenete e' bloccata.\n";
        outCapitolo2[10] = " " + getGiocatore().getNome() + " :\n\tNon ha serratura, ma e' comunque chiusa... Ci sara' qualche meccanismo da sbloccare.\n";
        outCapitolo2[11] = " " + getGiocatore().getNome() + " :\n\tMhh, osservando meglio le mura che affiancano la porta, noto una sequenza di numeri che non scorrono come tutti gli altri... \n"
                + "\tSono fissi. La sequenza non si muove minimamente e ad un certo punto e' divisa da una piccola crepa, come se fra quei numeri \n"
                + "\tne mancasse uno. Magari devo cercarlo in giro.\n";
        outCapitolo2[12] = " " + getGiocatore().getNome() + " :\n\tE' proprio un bellissimo albero. Aspetta, qualcosa si muove tra quelle foglie.\n";
        outCapitolo2[13] = " " + getGiocatore().getNome() + " :\n\tUno... Scoiattolo?? Cosa ci fa qui.\n"
                + " " + getGiocatore().getNome() + " :\n\t'Ehi, piccolino, tu non sei fatto di zeri e uno. Stai cercando anche tu di tornare a casa?’\n\n"
                + " Scoiattolo :\n\t'AOO, piccolino a chi?!? Bah... Ormai dovresti aver capito che in questo gioco nulla e' a caso.'\n\n";
        outCapitolo2[14] = " " + getGiocatore().getNome() + " :\n\t'MA TU PARLI?!?'\n";
        outCapitolo2[15] = " Scoiattolo :\n\t'Come se fosse la cosa piu' strana che tu abbia visto qui. Ma parliamo di cose serie, io ho tanta fame. \n"
                + "\tPrima ho trovato questa 'cosa' per terra, vicino a quella porta. L'ho scambiata per una ghianda,\n"
                + "\tma non lo e' affatto, ho provato a rosicchiarla un po',  ma niente. Uffa!'\n";
        outCapitolo2[16] = " " + getGiocatore().getNome() + " :\n\tE' proprio uno di quei numeri che avevo visto ammucchiati all'ingresso, \n"
                + "\tma dice di averlo preso da vicino alla porta, \n"
                + "\tprobabilmente sara' diverso da quelli all'entrata.\n"
                + "\tMhh... Forse ne dovrei parlare con... lui?!?\n";
        outCapitolo2[17] = " " + getGiocatore().getNome() + " :\n\t'Senti, mi sapresti dire qualcosa in piu' sui tre tipi che vivono qui?'\n";
        outCapitolo2[18] = " Scoiattolo :\n\t'Sono molto tristi, non c'e' tanto da dire... Ma bando alle ghiande... Ho detto che ho fame.\n"
                + "\tTi ho visto interessato a questa non-ghianda. Facciamo cosi',\n"
                + "\tse mi porti qualcosa da sgranocchiare, te la daro'.'\n";
        outCapitolo2[19] = " Scoiattolo :\n\t'YEE FINALMENTE! Ora siamo diventati amici, tieni questo.'\n\n"
                + " Scoiattolo :\n\t'Torna quando vuoi. Ma porta sempre delle ghiande con te, mi raccomando.'\n\n"
                + " " + getGiocatore().getNome() + " :\n\tSpero di uscire il prima possibile da questo luogo infernale. \n";
        outCapitolo2[20] = " " + getGiocatore().getNome() + " :\n\tOra non mi rimane che incastrare questo numero nella sequenza. Spero che funzioni. \n"
                + "\tLa porta si sta aprendo... E sono di nuovo in un altro corridoio... Uffa. \n"
                + "\tE' proprio come il primo, non mi resta che  percorrerlo e  vedere dove mi porta. \n";
        outCapitolo2[21] = " " + getGiocatore().getNome() + " :\n\tSono tornato un attimo indietro... controllando meglio, nel baule della stanza precedente\n\tho trovato un legnetto che sembrerebbe l'impugnatura di una fionda. Meglio stare piu' attenti.\n\tOra sono "
                + "ritornato in questo giardino. Devo trovare un modo per abbassare quel ponte... \n";
        outCapitolo2[22] = " " + getGiocatore().getNome() + " :\n\tMi manca ancora un pezzo\n";
        outCapitolo2[23] = " " + getGiocatore().getNome() + " :\n\tNon ho pietre da lanciare \n";
        outCapitolo2[24] = " " + getGiocatore().getNome() + " :\n\tAdesso posso finalmente aprire la porta. \n";
        outCapitolo2[25] = " " + getGiocatore().getNome() + " :\n\tForse quello scoiattolo mi ha appena salvato...\n";

        return outCapitolo2;
    }

    @Override
    protected int gioca_avventura(ParserOutput p, StoryOutput storia, int i) {
        if (p.getPersonaggi() == null && p.getOggetto() != null) {
            switch (p.getOggetto().getNome()) {
                case "stanza":
                    i = 0;
                    break;
                case "masso":
                    i = 1;
                    break;
                case "pietruzza":
                    i = 2;
                    break;
                case "rovine":
                    i = 3;
                    break;
                case "elastico":
                    i = 4;
                    break;
                case "ghianda":
                    if (p.getComandi().getNome().equals("prendi")) {
                        i = 5;
                    } else {
                        i = 13;
                    }
                    break;
                case "fionda":
                    i = 6;
                    break;
                case "ponte":
                    i = 7;
                    break;
                case "portagiardino":
                    i = 8;
                    break;
                case "albero":
                    i = 9;
                    break;
                case "foglie":
                    i = 10;
                    break;
                case "numero":
                    if (p.getComandi().getNome().equals("osserva")) {
                        i = 11;
                    } else {
                        i = 14;
                    }
                    break;

                case "corridoio":
                    i = 16;
                    break;
                case "indietro":
                    if (Legnetto== 0) {
                        i = 15;
                    } else {
                        GameOutput.blocco_ritorno();
                        i = -9;
                        cambia_stato_oggetto("indietro", 1, false);
                    }
                default:
                    break;

            }
        } else if (p.getOggetto() == null && p.getPersonaggi() != null) {
            if (p.getPersonaggi().getNome().equals("scoiattolo")) {
                i = 12;
            }
        } else if (p.getOggetto() == null && p.getPersonaggi() == null) {
            i = 0;
        }

        switch (i) {

            case 0://osserva
                storia.mostra(1);
                cambia_stato_oggetto("masso", 2, true);
                cambia_stato_oggetto("rovine", 2, true);
                cambia_stato_oggetto("stanza", 2, false);
                getComandi().get(3).setUsabile(false);
                break;

            case 1: //osserva masso
                storia.mostra(3);
                cambia_stato_oggetto("pietruzza", 8, true);
                cambia_stato_oggetto("masso", 2, false);
                break;

            case 2:// raccogli pietruzza
                if (!getGiocatore().getZaino().ricerca_oggetto("pietruzza")) {
                    getGiocatore().getZaino().aggiungi_oggetto(crea_pietruzza(), 1);
                    GameOutput.oggetto_aggiunto(crea_pietruzza());
                } else {
                    GameOutput.oggetto_unico();
                }
                break;

            case 3: //osserva spazzatura
                storia.mostra(4);
                storia.mostra(5);
                cambia_stato_oggetto("elastico", 8, true);
                cambia_stato_oggetto("ghianda", 8, true);
                cambia_stato_oggetto("rovine", 2, false);
                break;

            case 4: //raccogli elastico
                if (!getGiocatore().getZaino().ricerca_oggetto("elastico")) {
                    getGiocatore().getZaino().aggiungi_oggetto(crea_elastico(), 1);
                    GameOutput.oggetto_aggiunto(crea_elastico());
                }
                break;

            case 5: // raccogli ghianda
                if (!getGiocatore().getZaino().ricerca_oggetto("ghianda")) {
                    getGiocatore().getZaino().aggiungi_oggetto(crea_ghianda(), 1);
                    GameOutput.oggetto_aggiunto(crea_ghianda());
                } else {
                    GameOutput.oggetto_unico();
                }
                break;

            case 6: // usa fionda
                if (!getGiocatore().getZaino().ricerca_oggetto("elastico")) {
                    storia.mostra(23);
                } else if (!getGiocatore().getZaino().ricerca_oggetto("pietruzza")) {
                    storia.mostra(24);
                }
                if (getGiocatore().getZaino().ricerca_oggetto("elastico") && getGiocatore().getZaino().ricerca_oggetto("legnetto") && getGiocatore().getZaino().ricerca_oggetto("pietruzza")) {
                    getGiocatore().getZaino().rimuovi_oggetto(getGiocatore().getZaino().cerca_oggetto("legnetto"), 1);
                    getGiocatore().getZaino().rimuovi_oggetto(getGiocatore().getZaino().cerca_oggetto("elastico"), 1);
                    getGiocatore().getZaino().rimuovi_oggetto(getGiocatore().getZaino().cerca_oggetto("pietruzza"), 1);
                    storia.mostra(6);
                    storia.mostra(7);
                    getOggetti().remove(crea_fionda());
                    getOggetti().remove(crea_elastico());
                    getOggetti().remove(crea_pietruzza());
                    cambia_stato_oggetto("ponte", 7, true);
                } else if (getOggetti().contains(crea_fionda())) {
                    storia.mostra(2);
                }
                break;

            case 7:// percorri ponte
                storia.mostra(8);
                storia.mostra(9);
                cambia_stato_oggetto("portagiardino", 2, true);
                cambia_stato_oggetto("portagiardino", 3, true);
                cambia_stato_oggetto("albero", 2, true);
                cambia_stato_oggetto("ponte", 7, false);
                break;

            case 8: //osserva porta e apri porta
                storia.mostra(10);
                storia.mostra(11);
                cambia_stato_oggetto("portagiardino", 2, false);
                cambia_stato_oggetto("portagiardino", 3, false);
                storia.mostra(12);
                if (getGiocatore().getZaino().ricerca_oggetto("numero")) {
                    storia.mostra(26);
                }
                break;

            case 9: //guarda albero
                storia.mostra(13);
                cambia_stato_oggetto("foglie", 9, true);
                cambia_stato_oggetto("albero", 2, false);
                break;

            case 10: //sposta foglie
                storia.mostra(14);
                storia.mostra(15);
                GameOutput.pausa_output();
                storia.mostra(16);
                cambia_stato_oggetto("numero", 2, true);
                cambia_stato_oggetto("foglie", 9, false);
                break;

            case 11: //osserva numero 
                storia.mostra(17);
                cambia_stato_oggetto("numero", 2, false);
                getPersonaggi().get(0).setInteragibile(true);
                break;

            case 12: //parla con lo scoiattolo
                storia.mostra(18);
                storia.mostra(19);
                cambia_stato_oggetto("ghianda", 5, true);
                break;

            case 13: // dai ghianda
                if (getGiocatore().getZaino().ricerca_oggetto("ghianda")) {
                    getGiocatore().getZaino().rimuovi_oggetto(getGiocatore().getZaino().cerca_oggetto("ghianda"), 1);
                    getOggetti().remove(crea_ghianda());
                    GameOutput.oggetto_rimosso(crea_ghianda());
                    storia.mostra(20);
                    if (!getOggetti().get(7).isAnalizzabile()) {
                        storia.mostra(25);
                    }
                    getGiocatore().getZaino().aggiungi_oggetto(crea_numero(), 1);
                    cambia_stato_oggetto("numero", 1, true);
                    getPersonaggi().get(0).setInteragibile(false);

                } else {
                    GameOutput.oggetto_assente();
                }

                break;

            case 14: //ripara  - usa numero
                storia.mostra(21);
                if (getGiocatore().getZaino().ricerca_oggetto("numero")) {
                    getGiocatore().getZaino().rimuovi_oggetto(getGiocatore().getZaino().cerca_oggetto("numero"), 1);
                    cambia_stato_oggetto("corridoio", 7, true);
                } else {
                    GameOutput.oggetto_assente();
                }

                break;
            case 15://torna indietro
                cambia_stato_oggetto("indietro", 1, false);
                if (!getGiocatore().getZaino().ricerca_oggetto("legnetto")) {
                    storia.mostra(22);
                    getGiocatore().getZaino().aggiungi_oggetto(crea_legnetto(), 1);
                    GameOutput.oggetto_aggiunto(crea_legnetto());
                }
                break;

            case 16://percorri corridoio

                break;
                
            case -9://torna indietro non disponibile
                break;
        }
        i++;

        return i;
    }

    @Override
    protected void introduzione_capitolo() {
        controlla_legnetto(getGiocatore());
        StoryOutput intro = new StoryOutput(new String[]{" " + getGiocatore().getNome() + " : \n\tSono arrivato alla fine del corridoio. C'e' un’altra porta. La apro, non e' chiusa.\n\n"
            + " " + getGiocatore().getNome() + " : \n\tDove sono ora? Sembra essere una sorta di giardino, finalmente un po' d'aria anche se e' circondato\n"
            + "\tda quei maledetti muri di zeri e uno.  Il giardino e' spaccato a meta' da un'enorme voragine.\n"
            + "\tDall'altro lato della voragine vedo qualcosa... Dovrebbe essere un ponte sollevato. \n"
            + "\tCome faccio ad abbassarlo? Ah no aspetta, accanto vedo una leva, magari serve a far muovere il ponte,\n"
            + "\tma come la attivo?\n", " " + getGiocatore().getNome() + " : \n\tAnche se trovassi qualcosa da lanciare, non riuscirei mai a farla arrivare cosi' lontano... \n\tMi servirebbe qualcosa per lanciare gli oggetti piu' lontano per colpire la leva.\n"
            + "\tForse potrbbe tornarmi utile qulcosa che era in quel vecchio baule.\n"});
        intro.mostra(1);
        intro.mostra(2);

        getJukeBox().setFadeVolGap((short) 1);
        getJukeBox().setTitle("Electro-Fever");
        getJukeBox().play();
        getJukeBox().setVol(-60);
        getJukeBox().fade_vol(getJukeBox().getVol(), -37);
        getJukeBox().repeat(1000);
    }

}
