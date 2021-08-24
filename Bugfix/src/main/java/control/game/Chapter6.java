package control.game;

import entity.Player;
import boundary.GameOutput;
import boundary.StoryOutput;
import entity.Commands;
import entity.AdvObject;
import entity.CommandType;
import java.util.HashSet;
import java.util.Set;
import utils.ParserOutput;

public class Chapter6 extends Chapter {

    public Chapter6(Player giocatore) {
        super(giocatore);
    }

    @Override
    protected void init_lists() {
        setNumeroFasi(23);   
        Commands inventario = new Commands(CommandType.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv", "i", "I"});
        getComandi().add(inventario);
        Commands usa = new Commands(CommandType.USA, "usa");
        usa.setAlias(new String[]{"usa", "utilizza"});
        getComandi().add(usa);
        Commands osserva = new Commands(CommandType.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"controlla", "analizza", "guarda", "vedi", "avvicinati", "ispeziona", "esamina"});
        getComandi().add(osserva);
        getComandi().get(2).setUsabile(true);
        Commands collega = new Commands(CommandType.COLLEGA, "collega");
        collega.setAlias(new String[]{"unisci", "connetti", "inserisci"});
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
        Commands cerca = new Commands(CommandType.CERCA, "cerca");
        cerca.setAlias(new String[]{"ricerca"});
        getComandi().add(cerca);
        Commands help = new Commands(CommandType.HELP, "aiuto");
        help.setAlias(new String[]{"comandi?", "listacomandi", "help", "mostracomandi", "aiutocomandi"});
        getComandi().add(help);

        getOggetti().add(crea_baule());
        getOggetti().add(crea_armatura());
        getOggetti().add(crea_torcia());
        getOggetti().add(crea_porta_muro());
        getOggetti().add(crea_pilastro_centro());
        getOggetti().add(crea_pilastro_destra());
        getOggetti().add(crea_pilastro_sinistra());
        getOggetti().add(crea_quadro_centro());
        getOggetti().add(crea_quadro_destra());
        getOggetti().add(crea_quadro_sinistra());
        getOggetti().add(crea_sogno());
        getOggetti().add(crea_grate());
        getOggetti().add(crea_stanza());
        getOggetti().add(crea_donna());
        getOggetti().add(crea_lucchetto());
        getOggetti().add(crea_stanza_catacombe());

    }

    @Override
    protected String[] init_output() {
        String[] outCapitolo6 = new String[36];

        outCapitolo6[0] = " " + getGiocatore().getNome() + " :\n\tUn'armatura di un bianco splendente! Proprio come l'elmo! Sara'\n"
                + "\tmeglio portarla con me.\n ";
        outCapitolo6[1] = " " + getGiocatore().getNome() + " :\n\tNon ricordo nulla di quello che ha detto beaTester... Accidenti a me che non\n"
                + "\treggo l'alcool. Poteva essere qualcosa di davvero importante. Chissa' cosa\n"
                + "\tci mettono dentro quei drink.\n";
        outCapitolo6[2] = " " + getGiocatore().getNome() + " :\n\tMa poi perche' ritorno sempre qui dentro? La porta anche questa volta e'\n"
                + "\tspalancata. Pero' e' tutto buio...  Forse  prima di proseguire dovrei controllare\n"
                + "\tse ci sia qualcosa di nuovo.\n";
        outCapitolo6[3] = " " + getGiocatore().getNome() + " :\n\tLi' vicino al quadro vedo una torcia attaccata al muro. Prima non c'era.\n"
                + "\tNon c'e' altro di nuovo. Cosa faccio adesso?\n";
        outCapitolo6[4] = " " + getGiocatore().getNome() + " :\n\tOra dovrei poter andare...\n ";
        outCapitolo6[5] = " " + getGiocatore().getNome() + " :\n\tMi manca l'ultima sfida e poi potro' uscire da qui.\n"
                + "\tE' sempre piu' strana questa faccenda, che razza di livello era il\n"
                + "\tprecedente. Anche se non ci ho ancora capito nulla di quei tre. \n"
                + "\tRipensandoci, credo mi dispiaccia per loro, ma mi hanno intrappolato \n"
                + "\tin questo posto....\n";
        outCapitolo6[6] = " " + getGiocatore().getNome() + " :\n\tCaspita ma e' davvero buio. Per fortuna lasciando la porta aperta entra \n"
                + "\tun po' di luce.\n";
        outCapitolo6[7] = " " + getGiocatore().getNome() + " :\n\tCome non detto... Si e' chiusa.  Se solo avessi qualcosa per illuminare...\n";
        outCapitolo6[8] = " " + getGiocatore().getNome() + " :\n\tPer fortuna prima ho preso questa! La porta dietro di me e' scomparsa... \n"
                + "\tNon posso piu' tornare indietro. Allora non tocca che andare avanti. \n"
                + "\tAltre scale da scendere, il buio e' sempre piu' fitto. Sembra che anche \n"
                + "\tle pareti siano nere: non manca semplicemente la luce, e' quasi come \n"
                + "\tse producessero loro l'oscurita'. Se non avessi portato la torcia con \n"
                + "\tme sarei sicuramente rotolato giu'. Ci sono troppi gradini irregolari. \n";
        outCapitolo6[9] = " " + getGiocatore().getNome() + " :\n\tSi e' esaurita la torcia, ho fatto appena in tempo. Sono arrivato ad un muro...\n";
        outCapitolo6[10] = " " + getGiocatore().getNome() + " :\n\tAndro' a tentoni. Piano, piano, oh... Un gradino. Controllo se ce ne sono altri.\n"
                + "\tSembrerebbe di no, ok allora. NOOO!!\n";
        outCapitolo6[11] = " " + getGiocatore().getNome() + " :\n\t'AAAAAHH, NOOOOOOO!! NOOOOO!!! AHIAAA!!'\n";
        outCapitolo6[12] = " " + getGiocatore().getNome() + " :\n\tChe… MALE! Sono rotolato giu' per chissa' quanti gradini! Sono stato \n"
                + "\tbloccato da quello che potrebbe essere un muro.'\n";
        outCapitolo6[13] = " " + getGiocatore().getNome() + " :\n\tChe male... Cosa faccio adesso?\n";
        outCapitolo6[14] = " " + getGiocatore().getNome() + " :\n\tSembra stia succedendo qualcosa. Il muro si e' spostato. Meglio allontanarsi \n"
                + "\tsubito da queste scale, ho la sensazione che l'oscurita' mi stia per inghiottire.\n";
        outCapitolo6[15] = " " + getGiocatore().getNome() + " :\n\tBene... Appena ho attraversato il varco e' apparso un muro di zeri ed uno \n"
                + "\tche mi impedisce di ritornare sui miei passi. Dove mi trovo?\n";
        outCapitolo6[16] = " " + getGiocatore().getNome() + " :\n\tOh no, preferivo il buio a questo! Sono pietrificato. SONO NELLE CATACOMBE \n"
                + "\tDEL REAME! Le pareti sono completamente coperte da crani e omeri posti \n"
                + "\tordinatamente l'uno sopra l'altro. Sul soffitto invece ci sono ancora \n"
                + "\tzeri e uno, mentre il pavimento e' di pietra...\n ";
        outCapitolo6[17] = " " + getGiocatore().getNome() + " :\n\tLa luce soffusa, emanata dalle fiaccole sparse per la stanza, mi permette, \n"
                + "\tpiu' o meno, di vedere quello che c'e' attorno. Posso dire di essere in \n"
                + "\tun vero film dell'orrore.\n";
        outCapitolo6[18] = " " + getGiocatore().getNome() + " :\n\tOsservando le pareti di ossa, mi sono accorto che ci sono due grate, \n"
                + "\tpiu' in la', una accanto all'altra. Molto probabilmente dividono questo \n"
                + "\tposto dall'ambiente circostante. C'e' anche uno spazio meno chiuso con \n"
                + "\ttre pilastri li' in fondo. Da qui e' tutto quello che posso dire, non \n"
                + "\triesco a vedere altro. Dovrei avvicinarmi, proseguendo in questo tunnel \n"
                + "\tdi ossa per poi arrivare in fondo, se voglio vederne i particolari.\n";
        outCapitolo6[19] = " " + getGiocatore().getNome() + " :\n\tEccomi. Ho raggiunto il centro della stanza. Ma che diamine! Nelle tombe \n"
                + "\tvicino questi pilastri non ci sono scheletri, ma persone vive. Chi puo \n"
                + "\tessere questa gente? Sembra che stia… dormendo.  Ci sono anche tre quadri... \n"
                + "\tDevo capirci di piu' di questo posto. Vado verso il pilastro a destra, \n"
                + "\tquello centrale, oppure quello a sinistra?\n";
        outCapitolo6[20] = " " + getGiocatore().getNome() + " :\n\tIl quadro raffigura il castello, la famiglia reale e un drago. Sembrano essere \n"
                + "\ttutti felici… Forse dovrei controllare piu' da vicino, nell'eventualita' in \n"
                + "\tcui ci sia qualche particolare che mi sfugge. Anche le persone nelle tombe \n"
                + "\tsembrano dormire beatamente… Ma cosa c'e' poggiato a lato di questa donna? \n"
                + "\tHa una corona sul capo.\n";
        outCapitolo6[21] = " " + getGiocatore().getNome() + " :\n\tAvevo ragione! Sulla cornice c'e' inciso un numero :16.\n";
        outCapitolo6[22] = " " + getGiocatore().getNome() + " :\n\tQuesta deve essere la regina. E questa cos'e'? E' una specie di sfera luminosa. \n"
                + "\tSembra che si possa vedere qualcosa dentro di essa come se stesse avvenendo \n"
                + "\tal suo interno.\n";
        outCapitolo6[23] = " " + getGiocatore().getNome() + " :\n\tE' la regina che riabbraccia la principessa! Ma cosa sara' questa sfera, \n"
                + "\te' cosi' affascinante... Era di fianco alla testa della regina. Sembra \n"
                + "\tquasi che si possa vedere cosa stia sognando adesso. Che cosa strana...\n";
        outCapitolo6[24] = " " + getGiocatore().getNome() + " :\n\tE' come... Come se fosse un frutto della mente della regina. Come se fosse \n"
                + "\tla rappresentazione nella realta' di un suo sogno... Una versione non piu\n"
                + "\timmaginaria ma fisica di un sogno! Assurdo... \n"
                + "\tCosa ci si pota' fare.\n";
        outCapitolo6[25] = " " + getGiocatore().getNome() + " :\n\tCosa faccio ora?\n";
        outCapitolo6[26] = " " + getGiocatore().getNome() + " :\n\tSul quadro della colonna centrale vi e' rappresentato un castello in fiamme... \n"
                + "\tUna scena di totale devastazione… Dovrei avvicinarmi per osservare meglio, \n"
                + "\tnon si sa mai. Gli abiti delle persone qui sono molto particolari, hanno \n"
                + "\tmille colori e ricami. Chissa' se un giorno si risveglieranno. Cosa faccio?\n";
        outCapitolo6[27] = " " + getGiocatore().getNome() + " :\n\tEcco. In basso a destra c'e' dipinto un numero :18.\n\tE adesso?\n";
        outCapitolo6[28] = " " + getGiocatore().getNome() + " :\n\tNon so se questo... Puo' essere definito un quadro… Sia il soggetto che raffigura, \n"
                + "\tche esso stesso, sono mal ridotti. Comunque provo a capirci qualcosa... \n"
                + "\tE' una specie di castello dissezionato. Ci sono zeri e uno che sbucano \n"
                + "\tda ogni dove. Devo guardare con piu' attenzione se voglio i dettagli.\n";
        outCapitolo6[29] = " " + getGiocatore().getNome() + " :\n\tIn uno squarcio c'e' annotato un numero :13.\n\n"
                + " " + getGiocatore().getNome() + " :\n\tCosa faccio?\n";
        outCapitolo6[30] = " " + getGiocatore().getNome() + " :\n\tSembra che una grata non possa essere aperta… Pero' guardando attraverso \n"
                + "\tle sbarre riesco a capire che e' la continua di questo cimitero enorme. \n"
                + "\tL'altra invece non riesco a vedere dove porta. Ma ha un lucchetto, si puo\n"
                + "\tsbloccare con una combinazione...\n";
        outCapitolo6[31] = " " + getGiocatore().getNome() + " :\n\tDevo inserire la combinazione...\n";
        outCapitolo6[32] = " " + getGiocatore().getNome() + " :\n\tNon saprei come sbloccarlo... Forse nella stanza c'e' qualche indizio\n";
        outCapitolo6[33] = " " + getGiocatore().getNome() + " :\n\tMmmh, non ci siamo...\n";
        outCapitolo6[34] = " " + getGiocatore().getNome() + " :\n\tPerfetto! La grata e' aperta!!\n\n"
                + " " + getGiocatore().getNome() + " :\n\tFinalmente posso vedere cosa c'e' dietro questa grata...\n";
        outCapitolo6[35] = " " + getGiocatore().getNome() + " :\n\tNon ho nulla con cui poter illuminare...\n";

        return outCapitolo6;
    }

    private AdvObject crea_donna() {
        AdvObject donna = new AdvObject("donna");
        Set<String> alias = new HashSet<>();
        alias.add("ladonna");
        alias.add("regina");
        alias.add("laregina");
        donna.setAlias(alias);

        return donna;
    }

    private AdvObject crea_armatura() {
        AdvObject armatura = new AdvObject("armatura");
        Set<String> alias = new HashSet<>();
        alias.add("l'armatura");
        armatura.setAlias(alias);

        return armatura;
    }

    private AdvObject crea_torcia() {
        AdvObject torcia = new AdvObject("torcia");
        Set<String> alias = new HashSet<>();
        alias.add("latorcia");
        torcia.setAlias(alias);

        return torcia;
    }

    private AdvObject crea_porta_muro() {
        AdvObject portaMuro = new AdvObject("porta");
        Set<String> alias = new HashSet<>();
        alias.add("laporta");
        alias.add("ilmuro");
        alias.add("muro");
        alias.add("passaggio");
        alias.add("ilpassaggio");
        alias.add("passaggiosegreto");
        alias.add("ilpassaggiosegreto");
        portaMuro.setAlias(alias);

        return portaMuro;
    }

    private AdvObject crea_pilastro_centro() {
        AdvObject pilastroCentro = new AdvObject("pilastrodelcentro");
        Set<String> alias = new HashSet<>();
        alias.add("ilpilastrodelcentro");
        alias.add("centro");
        alias.add("ilcentro");
        alias.add("alcentro");
        alias.add("pilastroalcentro");
        alias.add("ilpilastroalcentro");
        alias.add("pilastrocentrale");
        alias.add("ilpilastrocentrale");
        pilastroCentro.setAlias(alias);

        return pilastroCentro;
    }

    private AdvObject crea_pilastro_destra() {
        AdvObject pilastroDestra = new AdvObject("pilastrodestro");
        Set<String> alias = new HashSet<>();
        alias.add("ilpilastrodestro");
        alias.add("destra");
        alias.add("adestra");
        alias.add("ilpilastroadestra");
        alias.add("pilastroadestra");
        pilastroDestra.setAlias(alias);

        return pilastroDestra;
    }

    private AdvObject crea_pilastro_sinistra() {
        AdvObject pilastroSinistra = new AdvObject("pilastrosinistro");
        Set<String> alias = new HashSet<>();
        alias.add("ilpilastrosinistro");
        alias.add("sinistra");
        alias.add("asinistra");
        alias.add("ilpilastroasinistra");
        alias.add("pilastroasinistra");
        pilastroSinistra.setAlias(alias);

        return pilastroSinistra;
    }

    private AdvObject crea_quadro_centro() {
        AdvObject quadro = new AdvObject("quadrocentro");
        Set<String> alias = new HashSet<>();
        alias.add("quadro");
        alias.add("ilquadro");
        alias.add("dipinto");
        alias.add("ildipinto");
        alias.add("rappresentazione");
        alias.add("larappresentazione");
        alias.add("raffigurazione");
        alias.add("laraffigurazione");
        alias.add("quadrocentrale");
        alias.add("quadroalcentro");
        alias.add("quadroincentro");
        alias.add("quadroinmezzo");
        alias.add("quadrodavanti");
        alias.add("ilquadrocentrale");
        alias.add("ilquadroalcentro");
        alias.add("ilquadroincentro");
        alias.add("ilquadroinmezzo");
        alias.add("ilquadrodavanti");
        quadro.setAlias(alias);

        return quadro;
    }

    private AdvObject crea_quadro_destra() {
        AdvObject quadro = new AdvObject("quadrodestra");
        Set<String> alias = new HashSet<>();
        alias.add("quadro");
        alias.add("ilquadro");
        alias.add("dipinto");
        alias.add("ildipinto");
        alias.add("rappresentazione");
        alias.add("larappresentazione");
        alias.add("raffigurazione");
        alias.add("laraffigurazione");
        alias.add("quadroadestra");
        alias.add("quadroallamiadestra");
        alias.add("dipintoadestra");
        alias.add("immagineadestra");
        alias.add("quadroalladestra");
        alias.add("ilquadroadestra");
        alias.add("ilquadroallamiadestra");
        alias.add("ildipintoadestra");
        alias.add("l'immagineadestra");
        alias.add("ilquadroalladestra");
        alias.add("quadrodestro");
        alias.add("ilquadrodestro");
        quadro.setAlias(alias);

        return quadro;
    }

    private AdvObject crea_quadro_sinistra() {
        AdvObject quadro = new AdvObject("quadrosinistra");
        Set<String> alias = new HashSet<>();
        alias.add("quadro");
        alias.add("ilquadro");
        alias.add("dipinto");
        alias.add("ildipinto");
        alias.add("rappresentazione");
        alias.add("larappresentazione");
        alias.add("raffigurazione");
        alias.add("laraffigurazione");
        alias.add("quadroasinistra");
        alias.add("quadroallasinistra");
        alias.add("quadroallamiasinistra");
        alias.add("dipintoasinistra");
        alias.add("dipintoallasinistra");
        alias.add("ilquadroasinistra");
        alias.add("ilquadroallasinistra");
        alias.add("ilquadroallamiasinistra");
        alias.add("ildipintoasinistra");
        alias.add("ildipintoallasinistra");
        alias.add("quadrosinistro");
        alias.add("ilquadrosinistro");

        quadro.setAlias(alias);

        return quadro;
    }

    private AdvObject crea_sogno() {
        AdvObject sogno = new AdvObject("sogno");
        Set<String> alias = new HashSet<>();
        alias.add("ilsogno");
        alias.add("sfera");
        alias.add("lasfera");
        alias.add("palla");
        alias.add("lapalla");
        sogno.setAlias(alias);

        return sogno;
    }

    private AdvObject crea_grate() {
        AdvObject grataLucchetto = new AdvObject("grata");
        Set<String> alias = new HashSet<>();
        alias.add("lagrata");
        alias.add("porta");
        alias.add("laporta");
        grataLucchetto.setAlias(alias);

        return grataLucchetto;
    }

    private AdvObject crea_lucchetto() {
        AdvObject lucchetto = new AdvObject("lucchetto");
        Set<String> alias = new HashSet<>();
        alias.add("illucchetto");
        alias.add("combinazione");
        alias.add("lacombinazione");
        lucchetto.setAlias(alias);

        return lucchetto;
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
        baule.setAnalizzabile(true);
        return baule;

    }

    private AdvObject crea_stanza() {
        AdvObject stanza = new AdvObject("stanza");
        Set<String> alias = new HashSet<>();
        alias.add("lastanza");
        alias.add("dintorni");
        alias.add("attorno");
        alias.add("ingiro");
        alias.add("intorno");
        stanza.setAlias(alias);
        return stanza;
    }

    private AdvObject crea_stanza_catacombe() {
        AdvObject stanza = new AdvObject("stanzacatacombe");
        Set<String> alias = new HashSet<>();
        alias.add("stanza");
        alias.add("lastanza");
        alias.add("dintorni");
        alias.add("attorno");
        alias.add("ingiro");
        alias.add("intorno");
        stanza.setAlias(alias);
        return stanza;
    }

    @Override
    protected int gioca_avventura(ParserOutput p, StoryOutput storia, int i) {

        if (p.getPersonaggi() == null && p.getOggetto() != null) {
            switch (p.getOggetto().getNome()) {
                case "stanza":
                    i = 2;
                    break;
                case "torcia":
                    if (p.getComandi().getNome().equals("prendi")) {
                        i = 20;
                    } else if (p.getComandi().getNome().equals("usa")) {
                        if(getGiocatore().getZaino().ricerca_oggetto("torcia")){
                        i = 21;
                        } else{
                            i=4;
                        }
                    }
                    break;
                case "stanzacatacombe":
                    i = 6;
                    break;
                case "muro":
                    i = 5;
                    break;
                case "pilastrodestro":
                    i = 8;
                    break;
                case "quadrodestra":
                    i = 8;
                    break;
                case "donna":
                    i = 9;
                    break;
                case "sfera":
                    i = 10;
                    break;
                case "pilastrodelcentro":
                    i = 12;
                    break;
                case "quadrocentro":
                    i = 12;
                    break;
                case "pilastrosinitro":
                    i = 13;
                    break;
                case "quadrosinistra":
                    i = 13;
                    break;
                case "grata":
                    i = 14;
                    break;
                case "lucchetto":
                    i = 15;
                    break;
                default:
                    break;

            }
        } else if (i >= 0 && p.getOggetto() == null) {
            switch (p.getComandi().getNome()) {
                case "cammina":
                    switch (i) {
                        case 1:
                            i = 2;
                            break;
                        case 2:
                            i = 2;
                            break;
                        case 3:
                            i = 3;
                            break;
                        case 4:
                            if (!getGiocatore().getZaino().ricerca_oggetto("torcia")) {
                                i = 4;
                            } else {
                                i = 21;
                            }
                            break;
                    }
                    break;
            }
        }

        switch (i) {
            case 0: //osserva baule
                getJukeBox().setFadeVolGap((short) 1);
                getJukeBox().setTitle("Electro-Fever");
                getJukeBox().play();
                getJukeBox().setVol(-60);
                getJukeBox().fade_vol(getJukeBox().getVol(), -35);
                getJukeBox().repeat(1000);
                storia.mostra(1);
                cambia_stato_oggetto("baule", 2, false);
                cambia_stato_oggetto("armatura", 8, true);
                getComandi().get(2).setUsabile(false);
                getComandi().get(7).setUsabile(true);
                cambia_stato_oggetto("stanza", 2, true);

                break;
            case 1: //raccogli armatura
                if (!getGiocatore().getZaino().ricerca_oggetto("armatura")) {
                    getGiocatore().getZaino().aggiungi_oggetto(crea_armatura(), 1);
                    GameOutput.oggetto_aggiunto(crea_armatura());
                    cambia_stato_oggetto("armatura", 8, false);
                }
                break;
            case 2: //gurda/ osserva/ esamina/ controlla stanza
                storia.mostra(2);
                storia.mostra(3);
                GameOutput.pausa_output();
                storia.mostra(4);
                cambia_stato_oggetto("stanza", 2, false);
                cambia_stato_oggetto("torcia", 8, true);
                getComandi().get(2).setUsabile(true);
                break;
            case 3: //prosegui/ vai avanti/ 
                storia.mostra(6);
                storia.mostra(7);
                storia.mostra(8);
                cambia_stato_oggetto("torcia", 1, true);
                break;
            case 4:	//avanzare (senza torcia)
                storia.mostra(36);
                storia.mostra(11);
                storia.mostra(12);
                storia.mostra(13);
                storia.mostra(14);
                getComandi().get(7).setUsabile(false);
                cambia_stato_oggetto("muro", 2, true);
                break;
            case 5:	//controlla muro
                storia.mostra(15);
                storia.mostra(16);
                cambia_stato_oggetto("muro", 1, false);
                cambia_stato_oggetto("stanzacatacombe", 2, true);
                getComandi().get(2).setUsabile(true);
                break;
            case 6: //osserva  o  osserva intorno
                storia.mostra(17);
                storia.mostra(18);
                storia.mostra(19);
                cambia_stato_oggetto("stanzacatacombe", 2, false);
                getComandi().get(2).setUsabile(false);
                getComandi().get(7).setUsabile(true);
                break;
            case 7: //avanza 
                storia.mostra(20);
                getComandi().get(7).setUsabile(false);
                cambia_stato_oggetto("pilastrodelcentro", 2, true);
                cambia_stato_oggetto("pilastrodestro", 2, true);
                cambia_stato_oggetto("pilastrosinistro", 2, true);
                cambia_stato_oggetto("quadrocentro", 2, true);
                cambia_stato_oggetto("quadrodestro", 2, true);
                cambia_stato_oggetto("quadrosinistro", 2, true);
                cambia_stato_oggetto("grata", 2, true);
                break;
            case 8: //osserva pilastro destro
                storia.mostra(21);
                storia.mostra(22);
                windows.Balance.run();
                cambia_stato_oggetto("donna", 2, true);
                break;
            case 9://osserva donna
                storia.mostra(23);
                storia.mostra(24);
                cambia_stato_oggetto("donna", 2, false);
                cambia_stato_oggetto("sfera", 2, true);
                break;
            case 10://esamina sfera
                storia.mostra(25);
                cambia_stato_oggetto("sfera", 2, false);
                cambia_stato_oggetto("sfera", 8, true);
                break;
            case 11://raccogli sfera
                if (!getGiocatore().getZaino().ricerca_oggetto("sogno")) {
                    getGiocatore().getZaino().aggiungi_oggetto(crea_sogno(), 1);
                    GameOutput.oggetto_aggiunto(crea_sogno());
                    cambia_stato_oggetto("sfera", 8, false);
                    storia.mostra(26);
                }
                break;
            case 12: //osserva pilastro centrale
                storia.mostra(27);
                storia.mostra(28);
                windows.BurningCastle.run();

                break;
            case 13: //osserva pilastro sinistro
                storia.mostra(29);
                storia.mostra(30);
                windows.Collapse.run();
                break;
            case 14: //osserva grata
                storia.mostra(31);
                cambia_stato_oggetto("lucchetto", 3, true);
                cambia_stato_oggetto("lucchetto", 1, true);
                cambia_stato_oggetto("grata", 2, false);
                break;
            case 15: //apri lucchetto
                windows.Padlock.run();
                if (windows.Padlock.isEsito()) {
                    cambia_stato_oggetto("pilastrodestro", 2, false);
                    cambia_stato_oggetto("quadrodestro", 2, false);
                    cambia_stato_oggetto("pilastrodelcentro", 2, false);
                    cambia_stato_oggetto("quadrocentro", 2, false);
                    cambia_stato_oggetto("pilastrosinistro", 2, false);
                    cambia_stato_oggetto("quadrosinistro", 2, false);
                    cambia_stato_oggetto("lucchetto", 1, false);
                    storia.mostra(35);
                    i = 22;
                } else {
                    storia.mostra(34);
                }
                break;

            case 20: //>raccogli/prendi torcia
                if (!getGiocatore().getZaino().ricerca_oggetto("torcia")) {
                    getGiocatore().getZaino().aggiungi_oggetto(crea_torcia(), 1);
                    GameOutput.oggetto_aggiunto(crea_torcia());
                    cambia_stato_oggetto("torcia", 8, false);
                    i = 2;
                }
                break;
            case 21: //usa torcia
              
                storia.mostra(9);
                storia.mostra(10);
                getGiocatore().getZaino().rimuovi_oggetto(getGiocatore().getZaino().cerca_oggetto("torcia"), 1);
                getComandi().get(7).setUsabile(false);
                cambia_stato_oggetto("muro", 2, true);
                cambia_stato_oggetto("torcia", 1, false);
                i = 4;
                break;

        }
        i++;
        return i;
    }

    @Override
    protected void introduzione_capitolo() {
        System.out.println(" " + getGiocatore().getNome() + " :\n\tMi sono risvegliato di nuovo nella stanza iniziale.\n"
                + "\tAh, oh no nonono! ...Sto per vomitare… nooo...\n"
                + "\tEcco, è successo.\n"
                + "\tStavo per vomitare dentro al baule, ma appena l'ho aperto, sono stato accecato\n"
                + "\t e d'istinto ho girato la testa.\n");
        System.out.println(" " + getGiocatore().getNome() + " :\n\t 'Cosa ci sara' al suo interno?'\n");

    }
}
