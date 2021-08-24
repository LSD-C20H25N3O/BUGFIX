package control.game;

import entity.Player;
import boundary.GameOutput;
import boundary.StoryOutput;
import entity.Commands;
import entity.AdvObject;
import entity.Character;
import entity.CommandType;
import java.util.HashSet;
import java.util.Set;
import utils.ParserOutput;

public class Chapter8 extends Chapter {

    public Chapter8(Player giocatore) {
        super(giocatore);
    }

    @Override
    protected void init_lists() {
        setNumeroFasi(5);
        Commands inventario = new Commands(CommandType.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv", "i", "I"});
        getComandi().add(inventario);
        Commands help = new Commands(CommandType.HELP, "aiuto");
        help.setAlias(new String[]{"comandi?", "listacomandi", "help", "mostracomandi", "aiutocomandi"});
        getComandi().add(help);
        Commands usa = new Commands(CommandType.USA, "usa");
        usa.setAlias(new String[]{"usa", "utilizza"});
        getComandi().add(usa);
        Commands osserva = new Commands(CommandType.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"controlla", "analizza", "guarda", "vedi", "avvicinati", "ispeziona", "esamina"});
        getComandi().add(osserva);
        getComandi().get(3).setUsabile(true);
        Commands prendi = new Commands(CommandType.PRENDI, "prendi");
        prendi.setAlias(new String[]{"raccogli", "acquisisci", "conserva"});
        getComandi().add(prendi);
        Commands cammina = new Commands(CommandType.CAMMINA, "cammina");
        cammina.setAlias(new String[]{"avanza", "prosegui", "continua", "percorri", "vai", "vaiavanti", "corri", "scappa"});
        getComandi().add(cammina);
        getComandi().get(5).setUsabile(true);
        Commands cerca = new Commands(CommandType.CERCA, "cerca");
        cerca.setAlias(new String[]{"ricerca"});
        getComandi().add(cerca);
        Commands attacca = new Commands(CommandType.ATTACCA, "attacca");
        attacca.setAlias(new String[]{"sconfiggi", "colpisci"});
        getComandi().add(attacca);
        Commands parla = new Commands(CommandType.PARLA, "parla");
        parla.setAlias(new String[]{"conversa", "chiaccera", "discuti"});
        getComandi().add(parla);
        Commands cedi = new Commands(CommandType.CEDI, "cedi");
        cedi.setAlias(new String[]{"dai", "dona", "regala"});
        getComandi().add(cedi);

        getOggetti().add(crea_spada());
        getOggetti().add(crea_sogno());
        getPersonaggi().add(crea_alberto());
        getPersonaggi().add(crea_drago());

    }

    @Override
    protected String[] init_output() {
        String[] outCapitolo8 = new String[30];

        outCapitolo8[0] = " " + getGiocatore().getNome() + " :\n\t'Ma io... Io non ho l'occorrente...'\n";
        outCapitolo8[1] = " Kekko4K_Designer :\n\t 'Non sei stato cosi' bravo come credi allora. Hai sprecato la tua occasione.'\n";
        outCapitolo8[2] = " beaTester :\n\t'Ormai quel che e' fatto e' fatto.'\n";
        outCapitolo8[3] = " " + getGiocatore().getNome() + " :\n\tIl drago sta per fare la sua mossa, non posso scappare. Le fauci di Ragnarok danno \n"
                + "\tvoce alle tenebre. Mi ha raggiunto. E' qui per divorare la mia esistenza, l'inferno \n"
                + "\te' ad un passo da me. E' finita... Ho perso.\n";
        outCapitolo8[4] = "\t\t\tROOOOAAAAAAARRRRRRRRR!!!\n";
        outCapitolo8[5] = " AlbooDev :\n\t'GAME OVER!'\n";
        outCapitolo8[6] = " " + getGiocatore().getNome() + " :\n\t'CHE COSA MI ASPETTA! COME POTRO' MAI RIUSCIRE IN  UN'IMPRESA SIMILE!?!'\n";
        outCapitolo8[7] = " " + getGiocatore().getNome() + " :\n\tPer fortuna ho raccolto il necessario, devo solo prendere la spada e... aspetta\n"
                + "\tun attimo. Quella spada e' diversa dal resto dell'armatura, non e' di un bianco \n"
                + "\tsplendente. Al contrario e' di un nero cosi' oscuro che in quella lama \n"
                + "\tsi riesce a vedere l'oblio.'\n";
        outCapitolo8[8] = " " + getGiocatore().getNome() + " :\n\tNon so cosa significhi... Albo e' ancora in preda ai suoi tormenti, sta continuando \n"
                + "\tad agitarsi e versare lacrime, e' fuori controllo. Sembra davvero essere \n"
                + "\tstraziato dalla  sofferenza. In ogni caso mi serve quella spada, devo prenderla...\n";
        outCapitolo8[9] = " " + getGiocatore().getNome() + " :\n\t'Albo, so che e' un momento difficile per te, mi servirebbe la spada.'\n";
        outCapitolo8[10] = " AlbooDev :\n\t'Va bene... Tienila, e' tua.'\n";
        outCapitolo8[11] = " beaTester :\n\t'Ora pero' quella spada non ti servira' a nulla... Ha perso i suoi poteri e la sua luce.'\n\n Kekko4K_Designer :\n\t'Gia'...'\n ";
        outCapitolo8[12] = " " + getGiocatore().getNome() + " :\n\t'Ma come?!? PERCHE'?' \n"
                + " beaTester: 'E' stata corrotta dalla tristezza di Alboo, non ha piu' il suo bagliore.'\n"
                + " Kekko4K_Designer: 'Colui che ti dona le armi della luce deve essere libero dalle\n"
                + "\ttenebre altrimenti lo splendore verra' perso.'\n";
        outCapitolo8[13] = " " + getGiocatore().getNome() + " :\n\t'Oh noo, e adesso come potro' sconfiggere Ragnarok...?'\n\n"
                + " Kekko4K_Designer: 'Solo Albo puo' rianimare la scintilla della tua spada per \n"
                + "\trenderla efficace contro l'oscurita', non c'e' altro modo.'\n"
                + " beaTester: 'La mente di Albo e' infestata da demoni indicibili. Finche' lui \n"
                + "\tnon sara’ sereno tu non riuscirai a scagionare la tua anima e terminare il \n"
                + "\tgioco da vincente.'\n";
        outCapitolo8[14] = " " + getGiocatore().getNome() + " :\n\tHo poco tempo, la mia fine si avvicina. Devo parlargli e aiutarlo a porre fine \n"
                + "\tal suo dolore...\n";
        outCapitolo8[15] = " " + getGiocatore().getNome() + " :\n\t'Albo...'\n"
                + " AlbooDev :\n\t 'Noi... NON E' GIUSTO!!! NON MERITAVAMO QUESTO! E' stato tutto cosi' improvviso, cosi' breve. Non doveva...    FINIRE COSI'!\n"
                + "\tE' terribile. E' tutto finito. C'era ancora cosi' tanto da scoprire... DA VIVERE!  ...inaccettabile, non voglio...\n"
                + "\tNon vogliamo...\n"
                + "\tCi e' stato negato il nostro futuro...\n"
                + "\tNon vogliamo essere subito gia' cosi' SENZA SOGNI!'\n";
        outCapitolo8[16] = " " + getGiocatore().getNome() + " :\n\t...\n " + " " + getGiocatore().getNome() + " :\n\t'Io...'\n";
        outCapitolo8[17] = " " + getGiocatore().getNome() + " :\n\tCOSA!? COSA STA SUCCEDENDO? E' COME SE UN LAMPO CI AVESSE COLPITI...\n";
        outCapitolo8[18] = " " + getGiocatore().getNome() + " :\n\tAlbo ha smesso di piangere... E adesso mi sta sorridendo dolcemente.\n";
        outCapitolo8[19] = " " + getGiocatore().getNome() + " :\n\tI suoi capelli sono improvvisamente diventati di un bianco luminoso, e adesso...\n"
                + "\tANCHE LA SPADA E' TORNATA A SPLENDERE!!\n";
        outCapitolo8[20] = " " + getGiocatore().getNome() + " :\n\t Allora... \n"
                + "\tE giunto il momento... Sono pronto.\n";
        outCapitolo8[21] = " " + getGiocatore().getNome() + " :\n\tMi sento cosi' forte, sicuro e sereno. Le fiamme del drago, grazie all'armatura, \n"
                + "\tnon possono piu' toccarmi. So che mi basta una mossa e... UN FASCIO DI LUCE E' \n"
                + "\tPARTITO DALLA MIA SPADA! Si sta dirigendo contro il drago... IL RAGGIO... HA \n"
                + "\tRAGGIUNTO RAGNAROK... E LO HA TRANCIATO IN DUE! UNA MAREA DI LUCE SI STA \n"
                + "\tSPARGENDO DAPPERTUTTO!!\n"
                + " Shyvana :\n\t 'Grazie, mi hai liberato... Te ne saro' per sempre riconoscente. Ecco a te...  il mio dono.'\n";
        outCapitolo8[22] = " " + getGiocatore().getNome() + " :\n\tLa principessa ha lasciato volare via dal suo petto una piccola scintilla, e' cosi' \n"
                + "\tbrillante, sembra una stella. Sta volando sempre piu' in alto. Sta creando un varco \n"
                + "\tluminoso nell’aria... E... E STA FACENDO VOLARE ANCHE ME! ASSURDO!\n";
        outCapitolo8[23] = " " + getGiocatore().getNome() + " :\n\t Che strana sensazione... Sto fluttuando, mi sto dirigendo sempre piu' su, verso la scintilla.\n";
        outCapitolo8[24] = " Kekko4K_Designer :\n\t 'Adesso sei libero di andare.'\n"
                + " beaTester: Abbiamo finito di giocare insieme... Un po' mi dispiace.' \n";
        outCapitolo8[25] = " Kekko4K_Designer :\n\t 'Ti sei rivelato dal cuore gentile. Continua a vivere anche per noi che non possiamo andare oltre questo punto...\n"
                + "  AlbooDev :\n\t 'Grazie.'\n\n"
                + "  beaTester :\n\t'Ti salutiamo qui noi!'\n";
        outCapitolo8[26] = " Kekko4K_Designer && beaTester && AlbooDev:\n\t: 'CIAOOOO!'\n";
        outCapitolo8[27] = " " + getGiocatore().getNome() + " :\n\t'Oh ciao! ...Ragazzi, noi... Ci rivedremo ancora! Non vi lascerò da soli... \n"
                + "\tMa non fatemi brutti scherzi! Userò sempre questo computer. Se apportate \n"
                + "\tdelle modifiche al gioco, o ne create di nuovi, saro' felicissimo di giocarci \n"
                + "\tancora insieme!! Potremmo scambiare due chiacchiere cosi'. Mi fido di voiiii!'\n"
                + "\t'CIAO RAGAZZI!! A PRESTOOOOO!'\n";
        outCapitolo8[28] = " \tE cosi' attraverso' il varco che collegava i due mondi e ricongiuntosi con la \n"
                + "\tsua anima, tornò a casa. Mantenne la sua promessa e Albo, Bea e Fra riuscirono \n"
                + "\ta giocare ancora con lui, distraendosi da quel vuoto a cui erano stati condannati \n"
                + "\te tornando a sentirsi... VIVI.\n";
        outCapitolo8[29] = "  AlbooDev :\n\t ...Tu ora non hai niente per potermi aiutare...\n\n"
                + " " + getGiocatore().getNome() + " :\n\t In che senso?\n\tOH NO IL DRAGO STA RISPUTANDO IL FUOCO! \n\t AIUTO STO BRUCIANDOO!\n";

        return outCapitolo8;
    }

    private Character crea_alberto() {
        Set<String> alias = new HashSet<>();
        Character alberto = new Character("alberto");
        alias.add("albo");
        alias.add("alboodev");
        alias.add("alboo");
        alias.add("conalbo");
        alias.add("conalboo");
        alias.add("conalboodev");
        alias.add("conalberto");
        alberto.setAlias(alias);

        return alberto;
    }

    private AdvObject crea_spada() {
        AdvObject spada = new AdvObject("spada");
        Set<String> alias = new HashSet<>();
        alias.add("laspada");
        alias.add("l'arma");
        alias.add("arma");
        spada.setAlias(alias);

        return spada;
    }

    private Character crea_drago() {
        Set<String> alias = new HashSet<>();
        Character drago = new Character("drago");
        alias.add("ildrago");
        alias.add("belva");
        alias.add("labelva");
        drago.setAlias(alias);

        return drago;
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

    @Override
    protected int gioca_avventura(ParserOutput p, StoryOutput storia, int i) {

        switch (i) {

            case 0: //corri/scappa o osserva
                if (!getGiocatore().getZaino().ricerca_oggetto("armatura") || !getGiocatore().getZaino().ricerca_oggetto("elmo")) {
                    storia.mostra(1);
                    storia.mostra(2);
                    storia.mostra(3);
                    GameOutput.pausa_output();
                    storia.mostra(4);
                    storia.mostra(5);
                    storia.mostra(6);
                    i = -2;
                } else {
                    storia.mostra(7);
                    storia.mostra(8);
                    GameOutput.pausa_output();
                    storia.mostra(9);
                }
                getComandi().get(3).setUsabile(false);
                getComandi().get(5).setUsabile(false);
                cambia_stato_oggetto("spada", 8, true);
                break;
            case 1://raccogli spada

                getGiocatore().getZaino().aggiungi_oggetto(crea_spada(), 1);
                storia.mostra(10);
                storia.mostra(11);
                GameOutput.oggetto_aggiunto(crea_spada());
                GameOutput.pausa_output();
                storia.mostra(12);
                storia.mostra(13);
                storia.mostra(14);
                GameOutput.pausa_output();
                storia.mostra(15);
                cambia_stato_oggetto("spada", 8, false);

                getPersonaggi().get(0).setInteragibile(true);
                break;
            case 2://parla con alberto
                storia.mostra(16);
                storia.mostra(17);
                getPersonaggi().get(0).setInteragibile(false);
                if (getGiocatore().getZaino().ricerca_oggetto("sogno")) {
                    cambia_stato_oggetto("sogno", 5, true);
                } else {
                    GameOutput.pausa_output();
                    storia.mostra(30);
                    i = -2;
                }
                break;
            case 3://cedi sogno
                storia.mostra(18);
                storia.mostra(19);
                storia.mostra(20);
                storia.mostra(5);
                getJukeBox().setFadeTimeLapse(750);
                getJukeBox().setFadeVolGap((short) 2);
                getJukeBox().setTitle("Uprising");
                getJukeBox().play();
                getJukeBox().setVol(-60);
                getJukeBox().fade_vol(getJukeBox().getVol(), -10);
                getJukeBox().repeat(1000);
                GameOutput.pausa_output();
                storia.mostra(21);

                cambia_stato_oggetto("spada", 1, true);
                getPersonaggi().get(1).setAttaccabile(true);

                break;
            case 4: //usa spada /attacca drago
                getPersonaggi().get(1).setAttaccabile(false);
                cambia_stato_oggetto("spada", 1, false);
                storia.mostra(22);
                GameOutput.pausa_output();
                storia.mostra(23);
                storia.mostra(24);
                storia.mostra(25);
                GameOutput.pausa_output();
                storia.mostra(26);
                storia.mostra(27);
                GameOutput.pausa_output();
                storia.mostra(28);
                GameOutput.pausa_output();
                storia.mostra(29);
                break;
        }

        i++;
        return i;
    }

    @Override
    protected void introduzione_capitolo() {
        System.out.println(" " + getGiocatore().getNome() + " :\n\t'Cos'era questo rumore assordante?!? Era come un...  Ruggito. MA... MA QUELLO E' IL DRAGO! \n"
                + "\tE' APPARSO, COSA SIGNIFICA?!? IL DRAGO STA VENENDO QUI!!'\n");
        System.out.println(" Kekko4K_Designer: \n\t'Dovrai affrontarlo. Avrai bisogno dell'equipaggiamento che hai \n"
                + "\ttrovato in precedenza, senza di quello e' impossibile salvare la tua anima.'\n");
        System.out.println(" beaTester :\n\t'Ti abbiamo lasciato un armamento di luce pura, solo cosi' potrai sconfiggere il morso della solitudine.'\n ");
    }
}
