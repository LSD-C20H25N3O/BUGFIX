package control.game;

import boundary.AppInput;
import boundary.GameOutput;
import boundary.StoryOutput;
import entity.Player;
import utils.ParserOutput;
import windows.Agreement;
import windows.SimulatedError;

public class Chapter0 extends Chapter {

    public Chapter0(Player giocatore) {
        super(giocatore);
    }

    @Override
    protected String[] init_output() {
        String[] outCapitolo0 = new String[13];

        outCapitolo0[0] = "\n\tE' stata proprio una giornata stancante a lavoro, finalmente sono tornato a casa.\n"
                + "\tOggi sarebbe dovuto arrivare il computer che ho ordinato...\n"
                + "\tSi fanno un sacco di affari sul Deep Web.\n";
        outCapitolo0[1] = "\tOh, eccolo! Voglio accenderlo subito, non vedevo l'ora... Inizio proprio a dargli un'occhiata allora.\n"
                + "\tMhh, interessante...\n"
                + "\tMa cosa c'e' qui? Un gioco... Un'avventura testuale? FANTASTICO!!! Beh, dato che non ho altro da fare, vediamo subito\n"
                + "\tdi che si tratta. Sono troppo curioso, non ho mai sentito questo titolo...\n"
                + "\tDoppio click e... SI PARTE!\n";
        outCapitolo0[2] = "\n\n\t\t\t\t\t\t\tRAGNAROK: IL MORSO DELLA SOLITUDINE\n"
                + "\n"
                + "\tC'era una volta, nel lontano Oriente, il solitario Ragnarok, l'ultimo dei draghi. Era il guardiano del reame in cui viveva,\n"
                + "\tl'orgoglio della corona.\n"
                + "\tLa terra sotto di lui lo rispettava e i cieli in cui liberava le sue ali erano sereni. Un giorno, la mente del vecchio Ragnarok,\n"
                + "\tfu corrotta da Solitudine, lo spirito piu' subdolo che potesse esistere. Giorno dopo giorno, il drago sentiva sempre più la mancanza\n"
                + "\tdei suoi simili, di qualcuno che fosse come lui e che lo capisse. Deviato da Solitudine, perse il senno e l'odio inizio' a divampare \n"
                + "\tnel suo animo: quel fuoco che prima portava pace, adesso portava solo distruzione. Nessuno meritava cio' che a lui era stato negato.\n"
                + "\tLa principessa del reame, Shyvana, ignara dell'oscurità che si diffondeva nella mente di Ragnarok, lo incontro' com'era solita fare.\n"
                + "\tQuesta volta, pero', per far tacere Solitudine,  il drago la rapi' e si rifugio' sul monte K4, il piu' alto di tutti i regni.\n"
                + "\tIl re, disperato sia per la condizione del suo popolo, straziato dalla ferocia del drago che aveva decimato il raccolto ed il bestiame,\n"
                + "\tsia perche' aveva portato via la sua unica figlia, decise di incaricare il piu' abile dei suoi cavalieri dell'arduo compito di uccidere\n"
                + "\tRagnarok e riportare Shyvana a casa.\n\n"
                + "\n\n Re :\n\t'Sir ...'\n";
        outCapitolo0[3] = "\n Re : \n\tE' stato incaricato di...\n";
        outCapitolo0[4] = "\t............parole confuse............\n"
                + " ? :\n\t'Chi sara'?'\n\n"
                + " ?? :\n\t 'Ha trovato il computer.'\n\n"
                + " ??? :\n\t 'Lol, adesso ci divertiamo.'\n"
                + "\n";
        outCapitolo0[5] = " ??? :\n\t'Ti va di giocare con noi?'\n";
        outCapitolo0[6] = " ?? :\n\t'Anzi facciamo qualcosa di piu' formale. Dai un'occhiata alla finestra!'\n";
        outCapitolo0[7] = "\n\n ? :\n\t'Ti andava di fare una partitella eh?'\n\n"
                + " ?? :\n\t'Da quanto tempo non incontravamo qualcuno.'\n\n"
                + " ??? :\n\t'Non vedo l'ora di iniziare.'\n\n"
                + " ? :\n\t'Si ma prima dobbiamo presentarci.'\n\n"
                + " ?? :\n\t'Sai questo gioco l'abbiamo creato noi.'\n";
        outCapitolo0[8] = " AlbooDev :\n\t'Eccoci qua, ho cambiato il nickname. Io sono Albo.'\n\n"
                + " beaTester :\n\t'Io invece sono Bea.'\n\n"
                + " Kekko4K_Designer :\n\t'Non rimango che io, Fra.'\n\n"
                + " beaTester :\n\t'Immagino che questo non sia il gioco che ti aspettavi... \n"
                + "\tMettiamo subito le cose in chiaro: adesso sei tu il nostro gioco.'\n";
        outCapitolo0[9] = " AlbooDev :\n\t'Accettando di fare una partita con noi hai fatto un primo passo verso un mondo\n"
                + "\tche non ti appartiene.'\n\n"
                + " Kekko4K_Designer :\n\t'Per rendere tutto più interessante e' stata messa in gioco la tua anima.\n"
                + "\tSe vinci, sarai libero di andare via...'\n\n"
                + " beaTester :\n\t'(Forse)'\n\n"
                + " Kekko4K_Designer :\n\t'...altrimenti rimarrai intrappolato qui per sempre.'\n\n";
        outCapitolo0[10] = " AlbooDev :\n\t'Non e' una cosa molto carina, ma la sorte non e' stata buona nemmeno con noi.'\n\n"
                + " beaTester :\n\t'Vuoi davvero parlarne adesso?'\n\n"
                + " AlbooDev :\n\t'Credo di no, ma voglio almeno fargli capire cosa siamo.'\n\n"
                + " Kekko4K_Designer :\n\t'Questo computer non e' il tuo, e' il nostro.'\n\n"
                + " beaTester :\n\t'Beh, precisamente il mio...'\n\n";
        outCapitolo0[11] = " AlbooDev :\n\t'A volte, quando la morte arriva troppo presto, concede all'anima di rimanere ancora\n"
                + "\ttra i vivi. La nostra e' rimasta tra questi circuiti.'\n\n"
                + " Kekko4K_Designer :\n\t'Adesso anche tu rischi di rimanere bloccato qui.'\n\n"
                + " beaTester :\n\t'Questo gioco l'abbiamo creato noi. Ora, pero', vedrai una versione diversa\n\n"
                + "\tdall'originale.'\n\n"
                + " Kekko4K_Designer :\n\t'Qualche modifica di la', un piccolo bug di qua, e cosi' via.'\n";
        outCapitolo0[12] = " AlbooDev :\n\t'Vediamo se riesci a vincere. In questo istante inizia la tua partita.\n"
                + "\tCi rivedremo presto.'\n";

        return outCapitolo0;
    }

    @Override
    protected void init_lists() {
        setNumeroFasi(0);
    }

    @Override
    protected int gioca_avventura(ParserOutput p, StoryOutput storia, int i) {
        return i;
    }

    @Override
    protected void introduzione_capitolo() {

    }

    @Override
    public Player inizia() {
        StoryOutput dialoghi = new StoryOutput(init_output());

        GameOutput.mostra_help_comandi();
        GameOutput.pausa_output();
        dialoghi.mostra(1);
        GameOutput.pausa_output();
        dialoghi.mostra(2);
        GameOutput.pausa_output();
        GameOutput.separatore();
        dialoghi.mostra(3);
        GameOutput.nome_giocatore();
        getGiocatore().setNome(AppInput.raccogli_input());
        dialoghi.mostra(4);
        GameOutput.err_codice_binario(1);
        dialoghi.mostra(5);
        GameOutput.pausa_output();
        dialoghi.mostra(6);
        dialoghi.mostra(7);
        Agreement.run();
        GameOutput.err_codice_binario(3);
        dialoghi.mostra(8);
        GameOutput.pausa_output();
        dialoghi.mostra(9);
        GameOutput.pausa_output();
        dialoghi.mostra(10);
        GameOutput.pausa_output();
        dialoghi.mostra(11);
        GameOutput.pausa_output();
        dialoghi.mostra(12);
        GameOutput.pausa_output();
        dialoghi.mostra(13);
        getJukeBox().setTitle("Beep-Effect");
        getJukeBox().play();
        getJukeBox().setVol(-30);
        SimulatedError.run();
        getJukeBox().arrest();
        getGiocatore().setCheckPoint(getGiocatore().getCheckPoint() + 1);

        return getGiocatore();
    }

}
