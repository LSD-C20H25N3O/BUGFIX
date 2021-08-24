package control.game;

import boundary.AppInput;
import boundary.GameOutput;
import boundary.MinigameOutput;
import boundary.StoryOutput;
import entity.Commands;
import entity.Player;
import entity.AdvObject;
import entity.Character;
import entity.CommandType;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.ParserOutput;

public class Chapter5 extends Chapter {

    public Chapter5(Player giocatore) {
        super(giocatore);
    }
    private String sequenza;
    private final int POSSIBILITA = 3;
    private int contaTentativi = 0;
    private int monete = 0;

    public String getSequenza() {
        return sequenza;
    }

    public void setSequenza(String sequenza) {
        this.sequenza = sequenza;
    }

    public int getContaTentativi() {
        return contaTentativi;
    }

    public void setContaTentativi(int contaTentativi) {
        this.contaTentativi = contaTentativi;
    }

    public int getMonete() {
        return monete;
    }

    public void setMonete(int monete) {
        this.monete = monete;
    }

    private String fiches() {
        int i;
        String combinazione = "";
        Random num = new Random();

        for (i = 0; i < 3; i++) {
            combinazione = combinazione.concat(Integer.toString(num.nextInt(37)));
            combinazione = combinazione.concat(" ");
        }

        return combinazione;
    }

    private static String tentativo(String comando) {
        String tentativo = comando.concat(" ");
        return tentativo;
    }

    private void conta_monete(Player giocatore) {

        if (giocatore.getZaino().ricerca_oggetto("moneta")) {
            monete = giocatore.getZaino().quantita_oggetto(giocatore.getZaino().cerca_oggetto("moneta"));

        } else {
            monete = 0;
        }
    }

    private int sfida_beaTester(String sequenzaVincente) {
        StoryOutput dialoghi = new StoryOutput(new String[]{" beaTester :\n\t'Qual e' il primo numero?'\n", " beaTester :\n\t'Il secondo?'\n", " beaTester :\n\t'E ora l'ultimo...'\n"});
        int esito;
        String prova = "";
        String numero;
        Pattern pattern = Pattern.compile("\\d+");
        boolean ctrl;

        int i = 0;
        while (i < 3) {
            switch (i) {
                case 0:
                    dialoghi.mostra(1);
                    break;
                case 1:
                    dialoghi.mostra(2);
                    break;
                default:
                    dialoghi.mostra(3);
                    break;
            }

            do {
                numero = AppInput.raccogli_input();
                Matcher matcher = pattern.matcher(numero);
                ctrl = matcher.matches();
            } while (!ctrl);

            prova = prova.concat(Chapter5.tentativo(numero));
            i++;

        }
        if (prova.equalsIgnoreCase(sequenzaVincente)) {
            esito = 15; //vince
        } else {
            esito = 16; //fallisce tentativo
        }

        return esito;
    }

    @Override
    protected void init_lists() {
        setNumeroFasi(24);
        Commands help = new Commands(CommandType.HELP, "aiuto");
        help.setAlias(new String[]{"comandi?", "listacomandi", "help", "mostracomandi", "aiutocomandi"});
        getComandi().add(help);
        Commands inventario = new Commands(CommandType.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv", "i", "I"});
        getComandi().add(inventario);
        Commands usa = new Commands(CommandType.USA, "usa");
        usa.setAlias(new String[]{"usa", "utilizza", "suona"});
        getComandi().add(usa);
        Commands osserva = new Commands(CommandType.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"controlla", "analizza", "guarda", "vedi", "avvicinati", "ispeziona", "esamina"});
        getComandi().add(osserva);
        getComandi().get(3).setUsabile(true);
        Commands cerca = new Commands(CommandType.CERCA, "cerca");
        cerca.setAlias(new String[]{"ricerca"});
        getComandi().add(cerca);
        Commands torna = new Commands(CommandType.TORNA, "torna");
        torna.setAlias(new String[]{"ritorna"});
        getComandi().add(torna);
        Commands tocca = new Commands(CommandType.TOCCA, "tocca");
        tocca.setAlias(new String[]{"palpa", "tangi"});
        getComandi().add(tocca);
        Commands accetta = new Commands(CommandType.ACCETTA, "accetta");
        accetta.setAlias(new String[]{"si", "SI", "certo"});
        getComandi().add(accetta);
        Commands rifiuta = new Commands(CommandType.RIFIUTA, "rifiuta");
        rifiuta.setAlias(new String[]{"no", "NO"});
        getComandi().add(rifiuta);
        Commands parla = new Commands(CommandType.PARLA, "parla");
        parla.setAlias(new String[]{"conversa", "chiaccera", "discuti"});
        getComandi().add(parla);
        Commands rovescia = new Commands(CommandType.ROVESCIA, "rovescia");
        rovescia.setAlias(new String[]{"butta", "capovolgi"});
        getComandi().add(rovescia);
        Commands bevi = new Commands(CommandType.BEVI, "bevi");
        bevi.setAlias(new String[]{"sorseggia"});
        getComandi().add(bevi);

        getOggetti().add(crea_porta_casino());
        getOggetti().add(crea_zaino());
        getOggetti().add(crea_precedente());
        getOggetti().add(crea_slot_machine());
        getOggetti().add(crea_slot_machine());
        getOggetti().add(crea_tavoli_da_gioco());
        getOggetti().add(crea_campanello());
        getOggetti().add(crea_drink());
        getOggetti().add(crea_fiches());
        getOggetti().add(crea_stanza());
        getOggetti().add(crea_bar());
        getOggetti().add(crea_moneta());

        getPersonaggi().add(crea_beatrice());
        getPersonaggi().add(crea_robot());

    }

    private AdvObject crea_porta_casino() {
        AdvObject portaCasino = new AdvObject("portadelcasino");
        Set<String> alias = new HashSet<>();
        alias.add("laportadelcasino");
        alias.add("porta");
        alias.add("laporta");
        portaCasino.setAlias(alias);

        return portaCasino;
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

    private AdvObject crea_moneta() {
        AdvObject moneta = new AdvObject("moneta");
        Set<String> alias = new HashSet<>();
        alias.add("lamoneta");
        alias.add("soldo");
        alias.add("ilsoldo");
        moneta.setAlias(alias);

        return moneta;

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

    private AdvObject crea_slot_machine() {
        AdvObject slotMachine = new AdvObject("slotmachine");
        Set<String> alias = new HashSet<>();
        alias.add("laslotmachine");
        alias.add("slotmachines");
        alias.add("leslotmachines");
        alias.add("macchinetta");
        alias.add("lamacchinetta");
        alias.add("macchinette");
        alias.add("lemacchinette");
        slotMachine.setAlias(alias);

        return slotMachine;
    }

    private AdvObject crea_tavoli_da_gioco() {
        AdvObject tavoloDaGioco = new AdvObject("tavolodagioco");
        Set<String> alias = new HashSet<>();
        alias.add("iltavolodagioco");
        alias.add("tavolidagioco");
        alias.add("itavolidagioco");
        alias.add("tavolo");
        alias.add("iltavolo");
        alias.add("tavoli");
        alias.add("itavoli");
        tavoloDaGioco.setAlias(alias);

        return tavoloDaGioco;
    }

    private AdvObject crea_campanello() {
        AdvObject campanello = new AdvObject("campanello");
        Set<String> alias = new HashSet<>();
        alias.add("ilcampanello");
        campanello.setAlias(alias);
        return campanello;
    }

    private AdvObject crea_drink() {
        AdvObject drink = new AdvObject("drink");
        Set<String> alias = new HashSet<>();
        alias.add("ildrink");
        alias.add("cocktail");
        alias.add("ilcocktail");
        alias.add("bevanda");
        alias.add("labevanda");
        alias.add("bicchiere");
        alias.add("ilbicchiere");
        alias.add("ghiaccio");
        alias.add("ilghiaccio");
        drink.setAlias(alias);

        return drink;
    }

    private AdvObject crea_fiches() {
        AdvObject fiches = new AdvObject("fiches");
        Set<String> alias = new HashSet<>();
        alias.add("lefiches");
        alias.add("inumeri");
        alias.add("numeri");
        alias.add("ilghiaccio");
        alias.add("ghiaccio");
        fiches.setAlias(alias);

        return fiches;
    }

    private AdvObject crea_bar() {
        AdvObject bar = new AdvObject("bar");
        Set<String> alias = new HashSet<>();
        alias.add("ilbar");
        bar.setAlias(alias);

        return bar;
    }

    private Character crea_beatrice() {
        Set<String> alias = new HashSet<>();
        Character beatrice = new Character("beatrice");
        alias.add("conbeatrice");
        alias.add("abeatrice");
        alias.add("conbea");
        alias.add("abea");
        alias.add("bea");
        alias.add("conbeatester");
        alias.add("abeatester");
        alias.add("beatester");
        beatrice.setAlias(alias);

        return beatrice;
    }

    private Character crea_robot() {
        Set<String> alias = new HashSet<>();
        Character robot = new Character("robot");
        alias.add("alrobot");
        alias.add("conilrobot");
        alias.add("conrobot");
        alias.add("conrobo-t");
        alias.add("arobo-t");
        alias.add("robo-t");
        alias.add("conilbarbot");
        alias.add("conbarbot");
        alias.add("albarbot");
        alias.add("barbot");
        robot.setAlias(alias);

        return robot;
    }

    @Override
    protected String[] init_output() {
        String[] outCapitolo5 = new String[51];

        outCapitolo5[0] = " " + getGiocatore().getNome() + " :\n\tDovrebbe essere una porta, ma e' molto diversa dalle altre: e' gialla come l'oro,\n"
                + "\tnon ha maniglie o pomelli e non e' nemmeno una grata. \n"
                + "\tDa' l'impressione di non essere solida, sembra immateriale.\n";
        outCapitolo5[1] = " " + getGiocatore().getNome() + " :\n\tMi devo fare coraggio. Prima la mano.\n"
                + "\tAvevo ragione... Sto toccando una sorta di fluido, piu' denso dell'acqua, ma leggerissimo.\n";
        outCapitolo5[2] = " " + getGiocatore().getNome() + " :\n\t'AAAAAAH'\n"
                + "\tOh noo, inizia a tirarmi dentro\n"
                + "\tNon c'e' niente qui a cui possa aggrapparmi. Non riesco ad allontanarmi, mi sta risucchiando.\n";
        outCapitolo5[3] = " " + getGiocatore().getNome() + " :\n\t'WOOAH'\n"
                + "\tSono passato dall'altra parte, mi gira molto la testa ed ho anche la nausea. \n"
                + "\tMa i miei vestiti... un... ABITO DA SERA?!? Cosa sta succedendo? Devo alzarmi subito.\n"
                + "\tOh no il mio zaino che fine ha fatto? Dov'e' sparito?  E dove sono finito? Devo dare un'occhiata...\n";
        outCapitolo5[4] = " " + getGiocatore().getNome() + " :\n\tMa e' proprio una sala giochi. \n"
                + "\tCi sono tavoli, roulette, due file di slot machine allineate lungo le pareti e persino un bar. \n"
                + "\tMa non ha davvero un senso logico, nessuno. Ero nel torrione, ed ora qui, vestito cosi'.\n";
        outCapitolo5[5] = " beaTester :\n\t'Dove pensi di ficcare il naso tu?'\n";
        outCapitolo5[6] = " " + getGiocatore().getNome() + " :\n\t'MA, quando sei comparsa, prima non c'era nessuno!'\n\tNon ci posso credere. E' sbucata dal nulla al centro della stanza. \n"
                + "\tMa almeno non e' solo un'inquietante testa gigante, e' una figura \n"
                + "\tper meta' umana per meta' robotica anche lei in abito da sera.\n";
        outCapitolo5[7] = " beaTester :\n\t'Ancora con queste osservazioni insensate... \n"
                + "\tAllora devi ancora capire che siamo noi qui a decidere tutto. \n"
                + "\tBasta schioccare le dita e...'\n";
        outCapitolo5[8] = " " + getGiocatore().getNome() + " :\n\tChe sta succedendo alle slot machine, sono impazzite, si sono accese tutte insieme, \n"
                + "\til braccio si e' abbassato a tutte contemporaneamente. \n"
                + "\tSullo schermo di ognuna sta comparendo una lettera. B  -  O  -  S ...\n";
        outCapitolo5[9] = " " + getGiocatore().getNome() + " :\n\t'BOSS FIGHT'\n";
        outCapitolo5[10] = " beaTester :\n\t'Ed eccoci qui. Benvenuto nel mio livello. \n"
                + "\tTi spiego in cosa consiste la mia prova. E' molto semplice.'\n\n"
                + " " + getGiocatore().getNome() + " :\n\tE' spuntata una roulette enorme al centro della stanza.\n";
        outCapitolo5[11] = " beaTester :\n\t'Io lancero' la pallina, e tu dovrai indovinare per tre volte consecutive l'esatto numero, \n"
                + "\tda zero a trentasei, sul quale si fermera'. C'e' un solo vincolo: hai tre tentativi.'\n";
        outCapitolo5[12] = " beaTester :\n\t'Quando ti sentirai pronto, vieni da me. \n"
                + "\tTi chiedero' di riferirmi i tre numeri in ordine di uscita e poi faro' girare la roulette per tre volte. \n"
                + "\tChe la fortuna sia dalla tua parte.'\n";
        outCapitolo5[13] = " " + getGiocatore().getNome() + " :\n\tPerfetto, e' qualcosa di impossibile. Meglio decidere con calma, \n"
                + "\tforse prendere tempo puo' aiutarmi. Cosa faccio adesso? Non ho ancora trovato il mio zaino.\n"
                + "\tDa qui non lo vedo... Ricapitolando, ci sono: delle slotmachines, tavoli da gioco e un bar...\n";
        outCapitolo5[14] = " " + getGiocatore().getNome() + " :\n\tSono fuse con le pareti. Le lettere sullo schermo sono scomparse. \n"
                + "\tQui non c'e' traccia dello zaino, credo bisogni controllare altrove.\n";
        outCapitolo5[15] = " " + getGiocatore().getNome() + " :\n\tNon funzionano, si sono spente.\n";
        outCapitolo5[16] = " " + getGiocatore().getNome() + " :\n\tEccoci davanti ai tavoli.\n"
                + "\tSono dei normalissimi tavoli da gioco, mancano le carte pero'. \n"
                + "\tDovrei cercare lo zaino qui vicino.\n";
        outCapitolo5[17] = " " + getGiocatore().getNome() + " :\n\tEhy, ecco dov'eri... sotto questa sedia.\n";
        outCapitolo5[18] = " " + getGiocatore().getNome() + " :\n\tSono davanti al bar adesso\n"
                + "\tMa quanti liquori ci sono. \n"
                + "\tDalle bottiglie ampollose e cosi' ricche di dettagli direi che sono costosi. \n"
                + "\tIl bancone e' di cristallo, ho quasi paura di toccarlo. Sembra un bel posto. \n"
                + "\tOh guarda, c'e' anche un campanello. E' proprio buffo. Sopra c'e' il disegno di un ingranaggio...\n";
        outCapitolo5[19] = " ROBO-T :\n\t'OH CIELO! OH CIELO! Abbiamo clienti quest'oggi!\n\n"
                + " " + getGiocatore().getNome() + " :\n\t'Ma c'e' qualcuno… anzi qualcosa.'\n\n"
                + " ROBO-T :\n\t'Arrivo subito!'\n\n"
                + " " + getGiocatore().getNome() + " :\n\t'ODDIO...'\n";
        outCapitolo5[20] = " ROBO-T :\n\t'Eccomi! Salve, lei e' proprio una sorpresa! IO sono ROBO-T, il bar-bot piu' \n"
                + "\trichiesto sul mercato che ci sia! Sarei felice di proporle la mia specialita', \n"
                + "\tvuole provarla?'\n";
        outCapitolo5[21] = " " + getGiocatore().getNome() + " :\n\t'Meglio di no, grazie...'\n\n"
                + " ROBO-T :\n\t'Torna quando vuoi!'\n";
        outCapitolo5[22] = " ROBO-T :\n\t'Ottima scelta! OH, mi imbarazza chiederlo, pero'... lei puo' pagarmi, non e' vero?'\n";
        outCapitolo5[23] = " " + getGiocatore().getNome() + " :\n\t'Queste dovrebbero andare bene, credo...'\n";
        outCapitolo5[24] = " ROBO-T :\n\t'Beh, io veramente intendevo una crypto-valuta, sa dei bit-coin magari, \n"
                + "\tma oggi e' il suo giorno fortunato, no? Lei, sir, mi piace, accettero' \n"
                + "\tquesto metodo di pagamento. Ecco qui! Se lo goda fino in fondo, \n"
                + "\te' tutto una delizia vedra', perfino il ghiaccio e' una prelibatezza! \n"
                + "\tSa e' proprio quello il trucco per un cocktail fenomenale, ma se si scioglie e' un guaio!'\n";
        outCapitolo5[25] = " " + getGiocatore().getNome() + " :\n\t'Gr... Grazie mille.'\n\n"
                + " " + getGiocatore().getNome() + " :\n\tMa e' un bicchierone!\n";
        outCapitolo5[26] = " " + getGiocatore().getNome() + " :\n\t'Gr... Grazie mille.'\n"
                + "\tL'ho finito. Beh era molto buono effettivamente ma adesso mi gira un sacco la testa, \n"
                + "\tera davvero pesantissimo, non so se e' stata una buona idea. \n"
                + "\tCerto pero' che il ghiaccio occupa la maggior parte del bicchiere, era davvero tanto. \n"
                + "\tMa che strano.\n";
        outCapitolo5[27] = " " + getGiocatore().getNome() + " :\n\tMa... Sono gia' ubriaco o il ghiaccio e' parecchio strano? \n"
                + "\tMa che diavolo? Sbaglio o ci sono tre fiches dentro i cubetti di ghiaccio... \n"
                + "\tPero' sono strane, sopra mi pare ci sia scritto qualcosa...\n";
        outCapitolo5[28] = " " + getGiocatore().getNome() + " :\n\tMhh, che sia questa la combinazione vincente?\n\n"
                + " ROBO-T :\n\t'Torna quando vuoi! Ma posso servirti solo  se mi paghi...'\n";
        outCapitolo5[29] = " beaTester :\n\t'Vuoi tentare la sorte?'\n";
        outCapitolo5[30] = " beaTester :\n\t'E' il mio turno. Lanciamo la pallina. Les jeux sont faits.'\n";
        outCapitolo5[31] = " beaTester :\n\t'E il primo e' andato, complimenti! Ma sara' stata solo fortuna? Lo scopriremo subito.'\n";
        outCapitolo5[32] = " beaTester :\n\t'Ma sei bravo allora, e' proprio vero che la fortuna e' una dea bendata.'\n";
        outCapitolo5[33] = " beaTester \n\t'A questo punto, direi proprio che hai capito il trucco. Hai fatto Jackpot!!'\n";
        outCapitolo5[34] = " beaTester \n\t'No no, non ci siamo. Ritenta e sarai piu' fortunato.'\n";
        outCapitolo5[35] = " beaTester :\n\t'Ora ti aspetterai risposte da me.'\n";
        outCapitolo5[36] = " " + getGiocatore().getNome() + " :\n\t'Io sono terrorizzato. Mi sono ritrovato QQQUI, \n"
                + "\te ssono tanto triste. Non so che volete da MEE, \n"
                + "\tma io voglio TORNARNIMENE a casa.'\n";
        outCapitolo5[37] = " beaTester :\n\t'Forse sei un po' troppo brillo per affrontare una conversazione. \n"
                + "\tROBO-T fa sempre ottimi cocktail, che a quanto pare tu non reggi proprio. \n"
                + "\tMeglio smettere di fare la vittima, e tu saresti triste? Tutta questa storia ti sia di lezione. \n"
                + "\tIl computer ti ha catturato per un motivo. \n"
                + "\tDevi riconoscere il valore della vita, quella che se perdi una volta, perdi per sempre.'\n";
        outCapitolo5[38] = " beaTester :\n\t'Non abbiamo scelto noi di rimanere intrappolati qui dentro... \n"
                + "\tE' il gioco ad essersi legato a noi. Dopo tutto quello che abbiamo fatto per lui, \n"
                + "\tvoleva che restassimo insieme.'\n";
        outCapitolo5[39] = " " + getGiocatore().getNome() + " :\n\t'ScUSAMi, ma non riesco a SefGUIRE quello che Stai DIcEndo.'\n"
                + "\tNon riesco quasi piu' a resistere, no, non ora. Ho la testa che gira troppo.\n";
        outCapitolo5[40] = " beaTester :\n\t'Nessuno di noi tre meritava questa sorte, avevamo ancora tanto altro da fare, \n"
                + "\te invece improvvisamente... '\n";
        outCapitolo5[41] = " beaTester :\n\t'Vabbe', parlare con te e' inutile. Io vado a bermi qualcosa. \n"
                + "\tSu su, riprenditi, che Albo ti aspetta... Il gioco deve continuare. \n"
                + "\tCiao ciao.'\n";
        outCapitolo5[42] = " beaTester :\n\t'ROBO-T, sei stato grande. Voglio quello che hai dato a lui.'\n";
        outCapitolo5[43] = " ROBO-T :\n\t'Ma come si e' ridotto!! OH CIELO! OH CIELO!'\n";
        outCapitolo5[44] = " " + getGiocatore().getNome() + " :\n\tNon ce la faccio piu'... i miei occhi, si chiud...\n";
        outCapitolo5[45] = " " + getGiocatore().getNome() + " :\n\tDevo cercare qualcosa con cui pagare... \n"
                + "\tForse potrei usare quelle monete che ho visto prima! \n"
                + "\tChissa' se riusciro' ad attraversare ancora quella specie di porta.\n";
        outCapitolo5[46] = " " + getGiocatore().getNome() + " :\n\tDevo recuperare lo zaino prima... \n";
        outCapitolo5[47] = " " + getGiocatore().getNome() + " :\n\tSono riuscito ad attraversare di nuovo la porta. Non ho piu' il mio abito da sera. \n"
                + "\tOra devo affrettarmi a prendere quelle monete e ritornare, potrei avere la soluzione sotto al naso.\n";
        outCapitolo5[48] = " ROBO-T :\n\t'Ehila' viandante, sei gia' di ritorno, e' l'ora di un drink?'\n";
        outCapitolo5[49] = " " + getGiocatore().getNome() + " :\n\tMa che strano, il liquido non cade.\n";
        outCapitolo5[50] = " beaTester :\n\t'Hai tutto il tempo del mondo, o forse no?\n"
                + "\tChissa' se hai capito qualcosa di questo posto,\n"
                + "\tla fortuna non serve,  il caso non esiste.'\n";

        return outCapitolo5;
    }

    @Override
    protected int gioca_avventura(ParserOutput p, StoryOutput storia, int i) {

        if (i > 2 && p.getPersonaggi() == null && p.getOggetto() != null) {
            switch (p.getOggetto().getNome()) {
                case "slotmachine":
                    if (p.getComandi().getNome().equals("osserva")) {
                        i = 3;
                    } else {
                        i = 4;
                    }
                    break;

                case "tavolodagioco":
                    i = 5;
                    break;

                case "zaino":
                    i = 6;
                    break;

                case "bar":
                    i = 7;
                    break;

                case "campanello":
                    i = 8;
                    break;

                case "drink":
                    switch (p.getComandi().getNome()) {
                        case "osserva":
                            i = 12;
                            break;
                        case "bevi":
                            i = 11;
                            break;
                        case "rovescia":
                            i = 18;
                            break;

                    }

                    break;

                case "indietro":
                    i = 17;
                    break;

            }
        } else if (i > 2 && p.getPersonaggi() != null && p.getOggetto() == null) {
            switch (p.getComandi().getNome()) {
                case "parla":
                    if (p.getPersonaggi().getNome().equals("beatrice")) {
                        if (p.getPersonaggi().isInteragibile()) {

                            i = 14;
                        }
                    } else {
                        if (p.getPersonaggi().isInteragibile()) {
                            i = 16;
                        }
                    }

                    break;

            }

        } else if (i > 2 && p.getOggetto() == null && p.getPersonaggi() == null) {
            switch (p.getComandi().getNome()) {
                case "accetta":
                    switch (i) {
                        case 9:
                            i = 10;
                            break;
                        case 10:
                            i = 11;
                            break;
                        case 11:
                            i = 21;
                            break;
                        case 15:
                            i = 15;
                            break;
                        case 17:
                            i = 10;
                            break;

                    }
                    break;

                case "rifiuta":
                    switch (i) {
                        case 9:
                            i = 9;
                            break;
                        case 11:
                            i = 20;
                            break;
                        case 15:
                            i = 19;
                            break;

                        case 17:
                            i = 9;
                            break;

                    }

            }

        }
        switch (i) {
            case 0://osserva
                storia.mostra(1);
                cambia_stato_oggetto("portadelcasino", 2, true);
                cambia_stato_oggetto("portadelcasino", 1, true);
                cambia_stato_oggetto("portadelcasino", 7, true);
                getComandi().get(3).setUsabile(false);
                break;

            case 1: //tocca o osserva porta
                storia.mostra(2);
                GameOutput.pausa_output();
                storia.mostra(3);
                GameOutput.pausa_output();
                storia.mostra(4);
                getJukeBox().setFadeVolGap((short) 1);
                getJukeBox().setTitle("Sweet-Georgia-Brown");
                getJukeBox().play();
                getJukeBox().setVol(-60);
                getJukeBox().fade_vol(getJukeBox().getVol(), -35);
                getJukeBox().repeat(1000);
                cambia_stato_oggetto("portadelcasino", 2, false);
                cambia_stato_oggetto("portadelcasino", 1, false);
                cambia_stato_oggetto("portadelcasino", 7, false);
                cambia_stato_oggetto("stanza", 2, true);
                getGiocatore().getZaino().setDisponibilitaInv(false);
                getComandi().get(3).setUsabile(true);
                break;

            case 2://osserva guarda stanza
                storia.mostra(5);
                cambia_stato_oggetto("stanza", 2, false);
                AppInput.raccogli_input();//qualsiasi comando
                storia.mostra(6);
                GameOutput.pausa_output();
                storia.mostra(7);
                GameOutput.pausa_output();
                storia.mostra(8);
                GameOutput.pausa_output();
                storia.mostra(9);
                storia.mostra(10);
                GameOutput.pausa_output();
                storia.mostra(11);
                GameOutput.pausa_output();
                storia.mostra(12);
                storia.mostra(13);
                GameOutput.pausa_output();
                storia.mostra(14);
                getPersonaggi().get(0).setInteragibile(true);
                cambia_stato_oggetto("slotmachine", 2, true);
                cambia_stato_oggetto("tavolodagioco", 2, true);
                cambia_stato_oggetto("bar", 2, true);
                getComandi().get(3).setUsabile(false);
                getComandi().get(9).setUsabile(true);

                break;

            case 3: //osserva slotmachines
                storia.mostra(15);
                cambia_stato_oggetto("slotmachine", 2, false);
                cambia_stato_oggetto("slotmachine", 1, true);

                break;

            case 4://usa slotmachine
                storia.mostra(16);
                cambia_stato_oggetto("slotmachine", 1, false);
                break;

            case 5://osserva tavoli
                storia.mostra(17);
                cambia_stato_oggetto("tavolodagioco", 2, false);
                cambia_stato_oggetto("zaino", 1, true);
                break;

            case 6: // cerca zaino
                storia.mostra(18);
                getGiocatore().getZaino().setDisponibilitaInv(true);
                GameOutput.inventario_equipaggiato();
                break;

            case 7: //osserva bar
                storia.mostra(19);
                cambia_stato_oggetto("campanello", 1, true);

                break;

            case 8: //usa campanello
                storia.mostra(20);
                GameOutput.pausa_output();
                storia.mostra(21);
                getComandi().get(7).setUsabile(true);
                getComandi().get(8).setUsabile(true);
                getComandi().get(9).setUsabile(true);
                getPersonaggi().get(1).setInteragibile(true);
                break;

            case 9: //rifiuta drink
                storia.mostra(22);
                getPersonaggi().get(1).setInteragibile(true);
                getComandi().get(7).setUsabile(false);
                getComandi().get(8).setUsabile(false);
                break;

            case 10://accetta drink 
                storia.mostra(23);
                getComandi().get(7).setUsabile(true);
                getComandi().get(8).setUsabile(true);
                cambia_stato_oggetto("indietro", 1, true);
                break;

            case 21: //si 
                if (getGiocatore().getZaino().getDisponibilitaInv()) {
                    if (getGiocatore().getZaino().ricerca_oggetto("moneta")) {
                        getGiocatore().getZaino().rimuovi_oggetto(getGiocatore().getZaino().cerca_oggetto("moneta"), 1);
                        storia.mostra(24);
                        storia.mostra(25);
                        storia.mostra(26);
                        cambia_stato_oggetto("drink", 4, true);
                        cambia_stato_oggetto("indietro", 1, false);
                        getComandi().get(8).setUsabile(false);
                        getComandi().get(7).setUsabile(false);
                    } else {
                        storia.mostra(46);
                        getComandi().get(8).setUsabile(false);
                        getComandi().get(7).setUsabile(false);
                    }

                } else {
                    storia.mostra(47);
                    getComandi().get(8).setUsabile(false);
                    getComandi().get(7).setUsabile(false);
                }

                break;

            case 11: //bevi drink o si
                storia.mostra(27);
                cambia_stato_oggetto("drink", 4, false);
                cambia_stato_oggetto("drink", 2, true);
                getComandi().get(8).setUsabile(false);
                getComandi().get(7).setUsabile(false);

                break;

            case 12://osserva drink 
                storia.mostra(28);
                cambia_stato_oggetto("drink", 2, false);
                cambia_stato_oggetto("fiches", 2, true);
                windows.Drink.run();

                break;

            case 13: //osserva fiches
                sequenza = fiches();
                MinigameOutput.stampa_output_minigioco(sequenza);
                cambia_stato_oggetto("fiches", 2, false);
                storia.mostra(29);
                if (monete < POSSIBILITA) {
                    cambia_stato_oggetto("indietro", 1, true);
                }
                break;

            case 14:// parla con bea
                storia.mostra(30);
                getComandi().get(7).setUsabile(true);
                getComandi().get(8).setUsabile(true);

                break;

            case 15: //fai tentativo
                contaTentativi++;

                i = sfida_beaTester(sequenza);
                storia.mostra(31);
                if (i == 15) {//vince
                    storia.mostra(32);
                    GameOutput.pausa_output();
                    storia.mostra(33);
                    GameOutput.pausa_output();
                    storia.mostra(34);
                    storia.mostra(36);
                    GameOutput.pausa_output();
                    storia.mostra(37);
                    storia.mostra(38);
                    GameOutput.pausa_output();
                    storia.mostra(39);
                    storia.mostra(40);
                    GameOutput.pausa_output();
                    storia.mostra(41);
                    storia.mostra(42);
                    GameOutput.pausa_output();
                    storia.mostra(43);
                    storia.mostra(44);
                    storia.mostra(45);
                    i = 23;

                } else {
                    if (contaTentativi < POSSIBILITA) { // fallisce tentativo
                        storia.mostra(35);

                    } else { //muore
                        i = -2;
                    }
                }

                break;

            case 16: //parla con barbot
                storia.mostra(49);
                getComandi().get(7).setUsabile(true);
                getComandi().get(8).setUsabile(true);
                break;

            case 17: // torna indietro
                if (monete < POSSIBILITA) {
                    if (getGiocatore().getZaino().getDisponibilitaInv()) {
                        if (getGiocatore().getZaino().ricerca_oggetto("moneta")) {
                            getGiocatore().getZaino().aggiungi_oggetto(getGiocatore().getZaino().cerca_oggetto("moneta"), POSSIBILITA - monete);
                            monete = POSSIBILITA;
                            storia.mostra(48);
                            GameOutput.oggetto_aggiunto(crea_moneta());
                            cambia_stato_oggetto("indietro", 1, false);
                        } else {
                            getGiocatore().getZaino().aggiungi_oggetto(crea_moneta(), POSSIBILITA);
                            monete = POSSIBILITA;
                            storia.mostra(48);
                            cambia_stato_oggetto("indietro", 1, false);
                            GameOutput.oggetto_aggiunto(crea_moneta());
                        }
                    } else {
                        GameOutput.blocco_ritorno();
                        storia.mostra(47);
                    }
                } else {
                    GameOutput.blocco_ritorno();
                    cambia_stato_oggetto("indietro", 1, false);
                }

                break;

            case 18://rovescia drink
                storia.mostra(50);
                break;

            case 19://rifiuta di giocare
                storia.mostra(51);
                break;

            case 20: // no a non puo' pagare
                storia.mostra(47);
                getComandi().get(7).setUsabile(false);
                getComandi().get(8).setUsabile(false);
                break;

        }

        i++;
        return i;
    }

    @Override
    protected void introduzione_capitolo() {
        System.out.println(" " + getGiocatore().getNome() + " :\n\tDelle scale! Per proseguire mi tocca scendere. La luce che passa dalle feritoie illumina il mio cammino... \n"
                + "\tQuesta volta sembra di essere in un torrione vero e proprio: non ci sono stramberie: \n"
                + "\tle pareti sono interamente in pietra e gli scalini anche, fatta eccezione di qualcuno, dove la pietra, \n"
                + "\tche doveva essersi scheggiata, e' stata sostituita da sottili listelli di legno. \n"
                + "\tLe feritoie sono finite. Adesso ci sono delle torce a guidare i miei passi.\n");

        GameOutput.pausa_output();
        System.out.println(" " + getGiocatore().getNome() + " :\n\tEccomi, sono arrivato alla fine. Saranno stati piu' di duecento scalini.\n"
                + "\t'Rieccoci'\n"
                + "\tDavanti a me ho... Non riesco a capire...\n");

        conta_monete(getGiocatore());
    }

}
