package control.game;

import boundary.AppInput;
import boundary.AppOutput;
import boundary.GameOutput;
import boundary.MinigameOutput;
import boundary.StoryOutput;
import entity.Commands;
import entity.Player;
import entity.AdvObject;
import entity.CommandType;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import utils.ParserOutput;

public class Chapter7 extends Chapter {

    public Chapter7(Player giocatore) {
        super(giocatore);
    }

    @Override
    protected void init_lists() {
        setNumeroFasi(1);
        Commands help = new Commands(CommandType.HELP, "aiuto");
        help.setAlias(new String[]{"comandi?", "listacomandi", "help", "mostracomandi", "aiutocomandi", "lista"});
        getComandi().add(help);
        Commands inventario = new Commands(CommandType.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv", "i", "I"});
        getComandi().add(inventario);
        Commands chiama = new Commands(CommandType.CHIAMA, "chiama");
        chiama.setAlias(new String[]{});
        chiama.setUsabile(true);
        getComandi().add(chiama);

        getOggetti().add(crea_ascensore());
        cambia_stato_oggetto("ascensore", 6, true);
    }

    private AdvObject crea_ascensore() {
        AdvObject ascensore = new AdvObject("ascensore");
        Set<String> alias = new HashSet<>();
        alias.add("l'ascensore");
        ascensore.setAlias(alias);

        return ascensore;
    }

    @Override
    protected String[] init_output() {
        String[] outCapitolo7 = new String[139];

        outCapitolo7[0] = " " + getGiocatore().getNome() + " :\n\tSono riuscito a superare quell' angusto passaggio. Adesso... Ma?! Ma questo invece sbaglio o e' un ascensore?\n\t"
                + "Cosa ci fa qui? Chissa' dove porta, sembra che io non possa fare altro che prenderlo, quindi lo scopriro' presto,\n\t"
                + "qui non c'e' altro... Non mi resta che chiamarlo.";

        outCapitolo7[1] = " " + getGiocatore().getNome() + " :\n\tNon promette bene, l'interno e' tutto nero e la luce che lo illumina e' di un rosso sangue.\n\t"
                + "Credo di non avere altra scelta che entrarci. Un attimo ma qui dentro...\n\t'Ahhhh!!!'\n";
        outCapitolo7[2] = " " + getGiocatore().getNome() + " :\n\tLa porta si e' chiusa di colpo, e questo coso non ha nessun pulsante,\n\tne' per uscire ne' per scegliere a quale piano andare.\n\t"
                + "Oh no si sta iniziando a muovere, speriamo bene. Ma che movimenti bruschi!\n\tQuest'affare va davvero velocissimo... Sto scendendo chissa' dove.\n";
        outCapitolo7[3] = " " + getGiocatore().getNome() + " :\n\t...E adesso cosa succede? Mi sembra che non si stia muovendo piu’ solo in verticale\n\tma anche in orizzontale.\n\t"
                + "Che razza di ascensore e'? Va sempre piu' veloce e il mio stomaco non la sta prendendo bene,\n\t"
                + "mi sento come se fossi su una giostra. Maledetto ascensore!\n";
        outCapitolo7[4] = " " + getGiocatore().getNome() + " :\n\t'Aiutoooo!!!'\n\t"
                + "Sembra che stia facendo dei giri della morte. Segue una traiettoria assurda!\n\t"
                + "Mi sta letteralmente strapazzando, vengo sballottato dappertutto. Adesso sembra addirittura che stia andando a zig zag,\n\t"
                + "ma poi quanto dura il tratto ancora, questa trappola di metallo si sta prendendo gioco di me!\n\t"
                + "'Bastaaaaa!'\n";
        outCapitolo7[5] = " " + getGiocatore().getNome() + " :\n\tOh, incredibile, si e' improvvisamente fermato, menomale.\n\t"
                + "La  porta si e' aperta. Ora di fronte a me vedo un'altra stanza, dove saro' finito?\n\t"
                + "Non sono mai stato cosi' felice di scendere da un ascensore in tutta la mia vita, vado subito avanti.\n";
        outCapitolo7[6] = " " + getGiocatore().getNome() + " :\n\tChe posto strano. Questa stanza e' disturbante.\n\tUn bianco spento la ricopre tutta, indistintamente. Sembra davvero enorme.\n\t"
                + "E' anche completamente vuota, fatta eccezione di una sedia, caduta a  terra, al suo centro.\n\t"
                + "C'e' un silenzio tombale.\n";
        outCapitolo7[7] = " AlbooDev :\n\t'Sei in ritardo cavaliere...'\n";
        outCapitolo7[8] = " " + getGiocatore().getNome() + " :\n\t'CHE SPAVENTO! Mi hai fatto prendere un colpo.'\n";
        outCapitolo7[9] = " " + getGiocatore().getNome() + " :\n\tQuesto tipo dovrebbe essere AlbooDev. E' improvvisamente  sbucato fuori dall'ascensore alle mie spalle.\n\t"
                + "Sembra proprio un ragazzino. Ha un aspetto cosi'... Normale. Capelli neri come la pece, felpa, jeans e nike.\n\t"
                + "Eppure e' strano, ha uno sguardo cosi' perso ed un volto cosi' triste.\n";
        outCapitolo7[10] = " " + getGiocatore().getNome() + " :\n\t'Ma quale ritardo, ero qui da prima che tu arrivassi...\n\t"
                + "Con quella specie di ascensore infernale.'\n";
        outCapitolo7[11] = " AlbooDev :\n\t'Essere puntuale non mi riesce bene, lo imparerai anche tu...\n\tE Che vorresti dire dell'ascensore?'\n";
        outCapitolo7[12] = " " + getGiocatore().getNome() + " :\n\t'Quel coso mi ha sballottato da una parte all'altra, stavo per vomitare!\n\tE non sarebbe la prima volta da quando sono qui!'\n";
        outCapitolo7[13] = " AlbooDev :\n\t'Lol. E' colpa tua, era in modalita' volo acrobatico\n\te tu non hai cambiato le impostazioni.'\n";
        outCapitolo7[14] = " " + getGiocatore().getNome() + " :\n\t'Che accidenti ne sapevo io, e poi che significa lol?'\n";
        outCapitolo7[15] = " AlbooDev :\n\t'Laughing out loud... Significa che una cosa fa ridere.'\n";
        outCapitolo7[16] = " " + getGiocatore().getNome() + " :\n\t'Ah... ok. Quindi tu saresti Albo?'\n";
        outCapitolo7[17] = " AlbooDev :\n\t'Esatto. Finalmente sei arrivato alla fine eh? Ora batti me e sei libero, no?'\n";
        outCapitolo7[18] = " " + getGiocatore().getNome() + " :\n\t'Spero di tornare il prima possibile nella realta'.'\n";
        outCapitolo7[19] = " AlbooDev :\n\t'Sei noioso pero', non dirmi che non ti sei divertito dai.'\n";
        outCapitolo7[20] = " " + getGiocatore().getNome() + " :\n\t'Sto rischiando la mia vita continuamente, non c'e' nulla di divertente.\n\tQuesto e' un gioco sadico!'\n";
        outCapitolo7[21] = " AlbooDev :\n\t'No, la vita lo e'.'\n";

        outCapitolo7[22] = " AlbooDev :\n\t'La vita e' sadica. Io e gli altri, lo abbiamo sperimentato sulla nostra pelle.\n\t"
                + "Tu non puoi capire. Non puoi capire niente di quello che e' successo,\n\t"
                + "di quello che ci aspettava ancora e della brutalita' con la quale la vita ti tradisce.'\n";
        outCapitolo7[23] = " " + getGiocatore().getNome() + " :\n\t'Ma io ...'\n";
        outCapitolo7[24] = " AlbooDev :\n\t'Non comprendi cosa significhi essere irrisolti\n\t"
                + "perche' la tua partita la puoi ancora giocare, quando e come vuoi.\n\t"
                + "Io sono qui per farti provare cosa vuol dire fare un gioco dove hai una vita sola,\n\t"
                + "un gioco di cui non conosci niente, in cui, da un momento all'altro, puoi perdere\n\t"
                + "e tutto quello che ti rimane dopo non e’ un salvataggio da cui ricominciare\n\t"
                + "ma un game over.'\n";
        outCapitolo7[25] = " " + getGiocatore().getNome() + " :\n\tE' diventato cosi' spaventoso in un attimo, e' terrificante.\n";
        outCapitolo7[26] = " " + getGiocatore().getNome() + " :\n\t'...Tutto questo e' terribile.'\n";
        outCapitolo7[27] = " AlbooDev :\n\t'E' proprio cosi' che deve essere...  Terribile, opprimente e tremendamente ingiusto.\n\t"
                + "Solo cosi' riuscirai ad immaginare quello che ci e' successo.'\n";
        outCapitolo7[28] = " " + getGiocatore().getNome() + " :\n\tDall'essere di fronte a me adesso sta camminando, sta venendo dritto verso di me, cosa vorra'?\n\t"
                + "Io... Ho paura, non accenna a cambiare direzione.\n\t"
                + "Sono paralizzato, mi e' praticamente addosso e viene ancora avanti.\n";
        outCapitolo7[29] = " " + getGiocatore().getNome() + " :\n\t'Ehiii, cosa vuo...?!'\n";
        outCapitolo7[30] = " " + getGiocatore().getNome() + " :\n\tIo... Non ci posso credere. Mi ha attraversato, MI E' PASSATO ATTRAVERSO!\n\t"
                + "CHI DIAVOLO E' QUESTO RAGAZZO?!? Non e' possibile... L'ho sentito passare dentro di me, questa e' roba da fantasmi.\n\t"
                + "Come niente fosse sta proseguendo...\n";
        outCapitolo7[31] = " AlbooDev :\n\t'Certo che sei davvero vuoto dentro.'\n";
        outCapitolo7[32] = " " + getGiocatore().getNome() + " :\n\t'EHI! Ma tu?!? COME HAI FATTO?'\n";
        outCapitolo7[33] = "\n\t--\tBOSS\tFIGHT\t--\n";
        outCapitolo7[34] = " " + getGiocatore().getNome() + " :\n\tE' arrivato al centro della stanza, dove c'e' quella sedia... La sta raccogliendo.\n";
        outCapitolo7[35] = " AlbooDev :\n\t'E' arrivata proprio l'ora di una partitella al mio gioco preferito... l'impiccato.'\n";
        outCapitolo7[36] = " " + getGiocatore().getNome() + " :\n\tIo davvero non posso crederci.\n\t"
                + "Dal soffitto si sta materializzando un cappio che sta scendendo\n\t"
                + "fino ad arrivare alla testa di questo squilibrato, che nel mentre era salito sulla sedia.\n";
        outCapitolo7[37] = " AlbooDev :\n\t'Beh direi che cosi' dovrebbe andare anche se sei un po' piu' alto di me.'\n";
        outCapitolo7[38] = " " + getGiocatore().getNome() + " :\n\tDopo aver provato al suo collo pallido il nodo, con un balzo scende dalla sedia\n\t"
                + "e con uno schiocco di dita e' apparso in piedi sulla sedia un manichino,\n\t"
                + "uno di quelli che ho incontrato in precedenza. \n";
        outCapitolo7[39] = " " + getGiocatore().getNome() + " :\n\t'Cosa hai intenzione di fare? Che dovrei fare io ora?!'\n";
        outCapitolo7[40] = " AlbooDev :\n\t'Le regole le conosci immagino, trova la frase nascosta provando\n\t"
                + "le lettere che meglio credi o la frase per intero. Ad ogni tentativo corretto apparira' la lettera in questione\n\t"
                + "e ad ogni tentativo sbagliato… sorpresa.  :)'\n";
        outCapitolo7[41] = " AlbooDev :\n\t'Il gioco dura fin quando sei ancora in vita. In bocca al lupo e... crepa.\n\t"
                + "Sei andato gia' troppo avanti in questo gioco per i miei gusti,\n\t"
                + "adesso io saro' il tuo Game Over.\n\t"
                + "Inizia o il cappio si avventera' su di te...'\n";
        outCapitolo7[42] = " " + getGiocatore().getNome() + " :\n\tIo sono davvero senza parole, e' tutto cosi' orribile. Mi sento schiacciato.\n\t"
                + "Sono scioccato. Che situazione surreale, questo tipo e' pazzo. Com'e' possibile tutto cio'?\n\t"
                + "Come faccio io adesso a... ARGHH. Devo farmi forza.\n";
        outCapitolo7[43] = " " + getGiocatore().getNome() + " :\n\t'Eh va bene, allora iniziamo!'\n";

        outCapitolo7[44] = " " + getGiocatore().getNome() + " :\n\tBene cosi'.\n";
        outCapitolo7[45] = " " + getGiocatore().getNome() + " :\n\t'Meno male...'\n";
        outCapitolo7[46] = " " + getGiocatore().getNome() + " :\n\t'Dai dai!'\n";
        outCapitolo7[47] = " " + getGiocatore().getNome() + " :\n\tForza!\n";
        outCapitolo7[48] = " " + getGiocatore().getNome() + " :\n\tSperiamo bene.\n";
        outCapitolo7[49] = " AlbooDev :\n\t'Ma che bravo!'\n";
        outCapitolo7[50] = " AlbooDev :\n\t'...Yuppie'!'\n";

        outCapitolo7[51] = " AlbooDev :\n\t'Uhh, bene bene. Guarda un po' che succede adesso.'\n";
        outCapitolo7[52] = " " + getGiocatore().getNome() + " :\n\tOddio, la mia... LA MIA GAMBA!\n\t"
                + "La mia gamba sinistra si e' riempita di zero e uno\n\t"
                + "e poi e' stata scambiata con quella del manichino.\n\t"
                + "Adesso addosso ho la gamba di quel pupazzo, e' una sensazione cosi' strana.\n\t"
                + "Non posso muovermi o cadrei, non devo perdere l'equilibrio.\n\t"
                + "Diamine! La mia gamba invece e' li' immobile attaccata al corpo del manichino. Che scena raccapricciante...\n";
        outCapitolo7[53] = " " + getGiocatore().getNome() + " :\n\t'COSA DIAVOLO MI HAI FATTO?!? CHE RAZZA DI TORTURA E' MAI QUESTA! COME E' POSSIBILE?!'\n";
        outCapitolo7[54] = " AlbooDev :\n\t'Questa e' la sorpresa di cui ti parlavo...\n\t"
                + "Nell'impiccato ogni lettera sbagliata e' una parte di te che ti lascia\n\t"
                + "e compone la fine del gioco e anche la tua.\n\t"
                + "Hai altre 5 possibilita' prima che tutto te stesso sia al posto del manichino\n\t"
                + "e che io butti giu' la sedia su cui ti sorreggerai.\n\tBUONA FORTUNA!'\n";
        outCapitolo7[55] = " " + getGiocatore().getNome() + " :\n\t'E' DISUMANO!'\n";

        outCapitolo7[56] = " " + getGiocatore().getNome() + " :\n\t'AAAAHHRRGGGH! IL MIO BRACCIO! E' STATO SCAMBIATO...'\n";
        outCapitolo7[57] = " AlbooDev :\n\t'Meno uno!'\n";
        outCapitolo7[58] = " " + getGiocatore().getNome() + " :\n\t'SEI UN BASTARDO!'\n";

        outCapitolo7[59] = " AlbooDev :\n\t'E' il turno del troncooo~'\n";
        outCapitolo7[60] = " " + getGiocatore().getNome() + " :\n\t'Dannazione, cosa mi stai facendo... Non e' piu' il mio corpo questo, mi sento cosi' morto adesso.'\n";
        outCapitolo7[61] = " " + getGiocatore().getNome() + " :\n\tChe dolore assurdo, che sensazione indescrivibile. Inizio a non sentire nient'altro che dolore.\n";
        outCapitolo7[62] = " AlbooDev :\n\t'Ti trovo in forma sai?'\n";

        outCapitolo7[63] = " " + getGiocatore().getNome() + " :\n\t'Nooo! Anche il braccio sinistro ora! BASTA!'\n";
        outCapitolo7[64] = " AlbooDev :\n\t'Arto in piu' arto in meno, non e' che fa una grande differenza insomma...'\n";
        outCapitolo7[65] = " " + getGiocatore().getNome() + " :\n\tNon ce la faccio piu'. E' davvero arrivata la fine?\n";

        outCapitolo7[66] = " AlbooDev :\n\t'Vai cosi'. Dai che ci stiamo avvicinando alla conclusione, su su!'\n";
        outCapitolo7[67] = " " + getGiocatore().getNome() + " :\n\t'. . . . .\nti prego.'\n";
        outCapitolo7[68] = " " + getGiocatore().getNome() + " :\n\tAnche la mia gamba destra se n'e' andata ormai... Sto per perdere, per perdere tutto.\n\t"
                + "La prossima e' la testa. Oddio sto per svenire... ahhh.\n";
        outCapitolo7[69] = " AlbooDev :\n\t'Non riesci piu' a reggerti in piedi eh? Che tenero.'\n";
        outCapitolo7[70] = " " + getGiocatore().getNome() + " :\n\tCon sole gambe finte non sono riuscito piu' a reggermi in piedi. Sono a terra.\n\t"
                + "Sono riuscito per fortuna a cadere di lato e riesco ancora a guardare le parole mancanti.\n\t"
                + "Maledizione. Quanto dolore. Ho paura...\n";
        outCapitolo7[71] = " " + getGiocatore().getNome() + " :\n\tVedo anche il 'mio' corpo quasi per intero su quella dannata sedia. Manca davvero poco.\n\tE' la fine.\n";
        outCapitolo7[72] = " AlbooDev :\n\t'SISISISISISISISISISISISISISISISISISISISISISISISISISISISISISI!\n\n\t"
                + "Dai che ci siamo quasi, DAI! Manca cosi' poco~'\n";

        outCapitolo7[73] = " " + getGiocatore().getNome() + " :\n\tE' giunta la mia ora, ho fallito. Ho perso. Moriro' e perdero' la mia anima. Che sofferenza atroce.\n\n\t"
                + "Che tristezza.\n";
        outCapitolo7[74] = " " + getGiocatore().getNome() + " :\n\tMaledizione.\n";
        outCapitolo7[75] = " " + getGiocatore().getNome() + " :\n\tEcco, ora sono di nuovo unito al mio corpo. Sento la corda che stringe il mio collo. Non mi resta nient'altro. Sono paralizzato.\n";
        outCapitolo7[76] = " " + getGiocatore().getNome() + " :\n\tE' finita.\n";
        outCapitolo7[77] = " " + getGiocatore().getNome() + " :\n\tChe agonia...\n";
        outCapitolo7[78] = " AlbooDev :\n\t'Eeeeeeeed eccoti quiii! HAI PERSO!\n\t"
                + "INCONTRA LA TUA SOFFERENZA.\n\n\t"
                + "CHE BELLO! HAI PERSO FINALMENTE LA TUA ANIMA!\n\n\t"
                + "AHAHAHAHAHAHAHAHAHAHAH!\n\n\t"
                + "VERRA’ DIVORATA DA OMBRA E SOLITUDINE!'\n";
        outCapitolo7[79] = "\n\t. . .\n\n\n\n\n AlbooDev :\n\t'Per te la partita e' finitaaa!~'\n\n\n";
        outCapitolo7[80] = "\nLa sedia viene spinta via.\n";
        outCapitolo7[81] = "\nIl corpo cade.\n";
        outCapitolo7[82] = "\nUn tonfo sordo spezza l’ultimo tuo istante di vita\n"
                + "Coronando il silenzio della tua discesa nel nulla.\n";
        outCapitolo7[83] = "\n\n\nIl Buio si sparge ovunque.\n";
        outCapitolo7[84] = "\n AlbooDev :\n\n\n\t' GAME OVER!!! :')))) '\n\n\n\n\n";

        outCapitolo7[85] = " AlbooDev :\n\t'Oh... Hai indovinato. Com'e' possibile. Sei... Stato bravo.'\n";
        outCapitolo7[86] = " " + getGiocatore().getNome() + " :\n\t'...Per fortuna e' andata bene, che sollievo.'\n";
        outCapitolo7[87] = " AlbooDev :\n\t'Io'\n";
        outCapitolo7[88] = " AlbooDev :\n\t'Ho perso.'\n";
        outCapitolo7[89] = " AlbooDev :\n\t'Di nuovo.'\n";
        outCapitolo7[90] = " AlbooDev :\n\t'Tutta questa sofferenza, tutto questo male per niente.'\n\n\n" + getGiocatore().getNome() + " :\n\t'Cosa?'\n";
        outCapitolo7[91] = " AlbooDev :\n\t'Doveva essere la fine, che senso c'e' allora? Cosa significa tutto questo.\n\t"
                + "Doveva finire qui il tuo gioco!\nPerche' e' tutto cosi' nero adesso?!'\n";
        outCapitolo7[92] = " " + getGiocatore().getNome() + " :\n\tSembra star impazzendo, questa persona ha davvero tanto dolore dentro di se'. Non ho capito cosa gli sia successo.\n\t"
                + "Si sta accasciando, ora e' in ginocchio e si sta stringendo la testa fra le mani...\n";
        outCapitolo7[93] = " AlbooDev :\n\t'Non volevo... Non doveva andare cosi'.\n\t"
                + "Adesso che senso ha tutto questo?!?!\n\t"
                + "Tu non capirai mai cos'e' stato ! Non capirai mai quello che si prova a... E' TUTTO SBAGLIATO!'\n";
        outCapitolo7[94] = " " + getGiocatore().getNome() + " :\n\tChe situazione assurda. Adesso sembra che... stia iniziando a piangere.\n";
        outCapitolo7[95] = " AlbooDev :\n\t'Noi... non ci meritavamo questo. C'era cosi' tanto altro da fare.'\n";
        outCapitolo7[96] = " " + getGiocatore().getNome() + " :\n\t'Ma di cosa stai parlando? Io non so nulla, non sto capendo cosa mi stai dicendo.'\n";
        outCapitolo7[97] = " beaTester :\n\t'Forse e' arrivato il momento di spiegare un po' di cose... Dai Alboo su, stai tranquillo, non piangere.'\n";
        outCapitolo7[98] = " " + getGiocatore().getNome() + " :\n\tOh sono comparsi gli altri due...\n";
        outCapitolo7[99] = " " + getGiocatore().getNome() + " :\n\t'Spiegatemi di cosa state parlando. Cos'e' successo?'\n";
        outCapitolo7[100] = " AlbooDev :\n\t.....\n";
        outCapitolo7[101] = " AlbooDev :\n\t'...Fino a qualche tempo fa io, Bea e Kekko eravamo tre studenti universitari delle facolta' di Informatica.\n\t"
                + "Frequentavamo il secondo anno. Avevamo tanta passione per quelle materie e ci impegnavamo come mai prima.\n\t"
                + "Durante un semestre, come esame per uno dei nostri corsi, ci era stato assegnato un progetto di gruppo.\n\t"
                + "Dovevamo creare un gioco...\n";
        outCapitolo7[102] = " Kekko4K_Designer :\n\t'Mi ricordo ancora dell'enstusiasmo.\n\t"
                + "Per noi era qualcosa di fantastico poter realizzare un gioco insieme.'\n";
        outCapitolo7[103] = " AlbooDev :\n\t'Vero... Eravamo cosi' felici.\n\t"
                + "Ci stavamo mettendo tutta la nostra passione, energia ed anima in quel progetto.\n\t"
                + "Amavamo quello che stavamo facendo e amavamo farlo insieme.\n\t"
                + "Doveva essere un'avventura testuale su un reame lontano e la furia di un drago.'\n";
        outCapitolo7[104] = " AlbooDev :\n\t'Poi arrivo' il giorno della consegna. L'ansia ci pervadeva.'\n";
        outCapitolo7[105] = " beaTester :\n\t'Volevamo che fosse tutto perfetto...'\n";
        outCapitolo7[106] = " AlbooDev :\n\t'E continuando a perfezionare la nostra avventura, nel fare gli ultimi ritocchi, perdemmo di vista l'orario.'\n";
        outCapitolo7[107] = " AlbooDev :\n\t'Stavamo mettendo cosi' tanto di noi stessi in quello che facevamo.\n\t"
                + "Ma il tempo scorreva e ce ne rendemmo conto tardi.\n\t"
                + "Eravamo in terribile ritardo per la consegna e dovevamo raggiungere l'universita'.'\n";
        outCapitolo7[108] = " beaTester :\n\t'E' cosi' triste ripensarci...'\n";
        outCapitolo7[109] = " AlbooDev :\n\t'Noi allora... nella fretta, per arrivare in tempo... Iniziamo a correre verso il nostro dipartimento...\n\t"
                + "E mentre eravamo cosi' presi,\n\tcosi' agitati, proprio quando stavamo lottando per quello che amavamo, per quello che avevamo creato...'\n";
        outCapitolo7[110] = " " + getGiocatore().getNome() + " :\n\tSembra davvero stare malissimo...\n\tAlbo durante questo racconto e' rimasto sempre in lacrime.\n\tLo ha fatto finora e non accenna a fermarsi....\n";
        outCapitolo7[111] = " AlbooDev :\n\t‘Proprio quando eravamo cosi'... Vivi.'\n\t"
                + "Attraversando una strada, presi da tutt'altro,\n\t"
                + "non ci siamo accorti che stava per passare un furgone, andava troppo veloce per potersi fermare....\n\t"
                + "E cosi' siamo stati investiti.'\n";
        outCapitolo7[112] = " AlbooDev :\n\t'Ci prese in pieno... Fu tremendo.'\n";
        outCapitolo7[113] = " Kekko4K_Designer :\n\t'E' STATO ORRIBILE.'\n";
        outCapitolo7[114] = " beaTester :\n\t'Che male...'\n";
        outCapitolo7[115] = " AlbooDev :\n\t'Io porto ancora con me il turbolento ricordo di quando morenti ci portarono all'ospedale.\n\t"
                + "Da quello che riuscii a sentire da un dottore, gli altri arrivarono che erano gia' morti.\n\t"
                + "Io mantenni coscienza ancora per qualche altro confuso istante...\n\t"
                + "Mi stavano trasportando con una barella chissa' dove.\n\t"
                + "Vedemmo cosi' la vita abbandonarci, le speranze appassire, i sogni infrangersi.'\n";
        outCapitolo7[116] = " AlbooDev :\n\t'La nostra vita, proprio quando stava per sbocciare, fu persa per sempre. Ci ritrovammo in un profondo e perenne buio.'\n";
        outCapitolo7[117] = " AlbooDev :\n\t'La nostra passione, soffocata. Il nostro futuro, negato. Il nostro corpo, stroncato.'\n";
        outCapitolo7[118] = " Kekko4K_Designer :\n\t'...E poi, successe l'assurdo.'\n\n"
                + " beaTester :\n\t'Qualcosa di impensabile.'\n";
        outCapitolo7[119] = " AlbooDev :\n\t'Quando fummo colpiti dal furgone, stavamo portando con noi il computer di Bea sul quale era presente il progetto...'\n";
        outCapitolo7[120] = " AlbooDev :\n\t'Chiusi per l'ultima volta i nostri occhi... Ne aprimmo per la prima volta degli altri.'\n";
        outCapitolo7[121] = " AlbooDev :\n\t'Ci ritrovammo come digitalizzati dentro il computer, insieme al nostro gioco. Come fosse successo, nessuno riusciva a spiegarlo.'\n";
        outCapitolo7[122] = " AlbooDev :\n\t'Il perche' pero' io credo di saperlo... Quando morimmo, la nostra anima aveva ancora cosi' tanto\n\t"
                + "da fare, da vedere, da scoprire, che voleva disperatamente continuare ad esistere\n\t"
                + "e ad alimentare la sua passione.\n\t"
                + "E dalla prematura perdita del nostro corpo decise di aggrapparsi\n\t"
                + "a quello in cui piu avevamo messo noi stessi.'\n";
        outCapitolo7[123] = " AlbooDev :\n\t'Il computer che hai ordinato\n\t"
                + "e' quello che avevamo con noi nei nostri ultimi momenti, quando eravamo piu' vivi che mai...'\n";
        outCapitolo7[124] = " " + getGiocatore().getNome() + " :\n\tIo non posso credere a quello che sto sentendo, questa storia  e' incredibile.\n\t"
                + "Come avrei mai potuto immaginare cosa si celava tra questi circuiti\n";
        outCapitolo7[125] = " beaTester :\n\t'Abbiamo passato il nostro tempo esplorando il computer e facendolo nostro,\n\t"
                + "imparando cosi' a programmarlo per fargli fare qualsiasi cosa...\n\t"
                + "E attendevamo che qualcuno venisse a giocare con noi.\n\n\t"
                + "Per fare una partita.'\n";
        outCapitolo7[126] = " Kekko4K_Designer :\n\t'Per raccontare la nostra storia a qualcuno, invece che tenerla dentro di noi...'\n";
        outCapitolo7[127] = " AlbooDev :\n\t'E per insegnare una lezione: la vita e' solo una e a volte puo' essere ingiusta,\n\t"
                + "e toccarlo con mano rende il messaggio vivido nella mente.\n\t"
                + "Proprio per questo bisogna affrontarla con coraggio\n\t"
                + "e viverla fino in fondo, tutta, senza dare mai nulla per scontato.'\n";
        outCapitolo7[128] = " " + getGiocatore().getNome() + " :\n\t'Io non posso capire come vi possiate sentire, ma lo immagino.\n\t"
                + "Mi dispiace per quello che vi e' successo e per cio' che state passando.\n\t"
                + "Tuttavia non potete giocare con la vita degli altri.\n\t"
                + "Lo capite o no che volevate fare  a me quello che e' toccato a voi.\n\t"
                + "Questo vi sembra giusto invece? Voi non siete nessuno per decidere della mia vita.\n\t"
                + "La mia non e' stata una fatalita', siete stati voi a mettermi in pericolo.'\n";
        outCapitolo7[129] = " beaTester :\n\t'Se fosse come dici tu, a quest'ora saresti gia' bloccato qui con noi per l'eternita'. Rifletti bene su quello che dici.'\n";
        outCapitolo7[130] = " Kekko4K_Designer :\n\t'Abbiamo fatto in modo che potessi riuscire a salvarti, avevi sempre una maniera di andare avanti nel gioco.'\n";
        outCapitolo7[131] = " " + getGiocatore().getNome() + " :\n\t'Si, ma ho rischiato il tutto per tutto in questa odissea virtuale!\n\t"
                + "Fortunatamente adesso sono arrivato alla fine...'\n";
        outCapitolo7[132] = " beaTester :\n\t'Tu non hai ancora recuperato la tua anima, non e' ancora finita.'\n";
        outCapitolo7[133] = " AlbooDev :\n\t'Il gioco deve finire, e per farlo c'e' un modo soltanto... Devi salvare la principessa.'\n";
        outCapitolo7[134] = " " + getGiocatore().getNome() + " :\n\t'COSA?! Cosa vuol dire?! Liberatemi, vi ho battuto! Sono arrivato alla fine!'\n";
        outCapitolo7[135] = " " + getGiocatore().getNome() + " :\n\t'Questo incubo non puo' continuare!'\n";
        outCapitolo7[136] = " " + getGiocatore().getNome() + " :\n\tAlbo sta continuando a disperarsi e a piangere,\n\t"
                + "deve essere stato orrendo subire un destino del genere, parlarne deve averlo scosso...\n\t"
                + "Tra le sue braccia e' comparsa una grossa spada,\n\t"
                + "sembra far parte dell'armamento che ho trovato in precedenza.\n";
        outCapitolo7[137] = " beaTester :\n\t'Ti rimane ancora un ostacolo. Quella spada e' per te...'\n";
        outCapitolo7[138] = "\n\n\tROOOOAAAAAAARRRRRRRRR!!!\n\n";

        return outCapitolo7;
    }

    @Override
    protected void introduzione_capitolo() {
        StoryOutput intro = new StoryOutput(new String[]{"\n " + getGiocatore().getNome() + " :\n\tSono riuscito a superare quell' angusto passaggio. Adesso... Ma?! Ma questo invece sbaglio o e' un ascensore?\n\t"
            + "Cosa ci fa qui? Chissa' dove porta, sembra che io non possa fare altro che prenderlo, quindi lo scopriro' presto,\n\t"
            + "qui non c'e' altro... Non mi resta che chiamarlo.\n"});
        intro.mostra(1);
    }

    @Override
    protected int gioca_avventura(ParserOutput p, StoryOutput storia, int i) {
        short numErrTot = 0, numErrAgg = numErrTot;
        Random rand = new Random();
        Set<Character> lettereTrovate = new HashSet<>();
        boolean flag = false;
        String inserimento, fraseImpiccato = "Anche i draghi piangono".trim().toLowerCase();

        getComandi().get(2).setUsabile(false);
        cambia_stato_oggetto("ascensore", 6, false);
        mostra_dialoghi_iniziali(storia);
        AppOutput.mostra_nuovo_schermo();

        while (!flag) {
            do {
                MinigameOutput.stampa_turno_imp(fraseImpiccato, lettereTrovate);
                MinigameOutput.richiedi_inserimento_imp();
                inserimento = AppInput.raccogli_input().trim().toLowerCase();
                numErrAgg = gioca_turno_imp(numErrTot, inserimento, fraseImpiccato, lettereTrovate);
                AppOutput.mostra_nuovo_schermo();
            } while (numErrAgg == -3);

            if (lettereTrovate.contains('!')) {
                lettereTrovate.remove('!');
                storia.mostra(rand.nextInt(7) + 45);
            }

            switch (numErrAgg) {
                case -1:
                    i = 1;
                    flag = true;
                    break;
                case -2:
                    i = getNumeroFasi() * -10;
                    flag = true;
                    break;
                case 6:
                    i = -1;
                    flag = true;
                default:
                    if (numErrAgg != numErrTot) {
                        mostra_errore_imp(numErrAgg, storia);
                    }
                    break;
            }
            numErrTot = numErrAgg;
        }

        if (numErrTot == -1) {
            GameOutput.err_codice_binario(2);
            MinigameOutput.mostra_soluzione_imp(fraseImpiccato);
            GameOutput.pausa_output();
            AppOutput.mostra_nuovo_schermo();
            mostra_dialoghi_finali(storia);
        }

        return i;
    }

    private void mostra_dialoghi_iniziali(StoryOutput storia) {
        short i = 2;

        getJukeBox().setFadeTimeLapse(1000);
        getJukeBox().setFadeVolGap((short) 5);
        while (i <= 41) {
            storia.mostra(i);
            if (i == 8 || i == 22 || i == 24 || i == 30 || i == 34 || i == 39) {
                storia.mostra(++i);
            } else if (i == 17) {
                getJukeBox().setTitle("Micro-Cuts-XX");
                getJukeBox().play();
                getJukeBox().setVol(getJukeBox().getMinVol());
                getJukeBox().repeat(10);
                getJukeBox().fade_vol(getJukeBox().getVol(), -20);
            }
            storia.pausa_output();
            i++;
        }

        getJukeBox().setFadeTimeLapse(400);
        getJukeBox().setFadeVolGap((short) 1);
        getJukeBox().fade_vol(getJukeBox().getVol(), getJukeBox().getMinVol());
        storia.mostra(i++);
        storia.pausa_output();
        storia.mostra(i++);
        storia.pausa_output();
        storia.mostra(i++);
        storia.pausa_output();
        getJukeBox().arrest();
    }

    private void mostra_dialoghi_finali(StoryOutput storia) {
        short i = 86;

        while (i <= 139) {
            storia.mostra(i);
            if (i == 99 || i == 101 || i == 106 || i == 112 || i == 114 || i == 117 || i == 119 || i == 121 || i == 123 || i == 130 || i == 133 || i == 135 || i == 138) {
                storia.mostra(++i);
            }
            storia.pausa_output();
            i++;
        }
    }

    private short gioca_turno_imp(short numErrori, String input, String frase, Set<Character> lettereTrovate) {
        short i = 0, numErrAgg = numErrori;
        boolean flag = true;

        if (input.length() > 1) {
            if (input.equals(frase)) {
                numErrAgg = -1;
            } else if (input.equals("#esci")) {
                if (chiudi_capitolo()) {
                    numErrAgg = -2;
                } else {
                    numErrAgg = -3;
                }
            } else if (input.equals("inventario") || getComandi().get(1).getAlias().contains(input)) {
                GameOutput.err_comando_gioco();
                numErrAgg = -3;
            } else if (input.equals("aiuto") || getComandi().get(0).getAlias().contains(input)) {
                GameOutput.mostra_help_comandi();
                GameOutput.pausa_output();
                numErrAgg = -3;
            } else {
                numErrAgg++;
            }
        } else if (input.length() == 1) {
            if (frase.contains(input)) {
                if (!lettereTrovate.contains(input.charAt(0))) {
                    lettereTrovate.add(input.charAt(0));
                    lettereTrovate.add('!');
                    while (i < frase.length() && flag) {
                        if (!Character.isWhitespace(frase.charAt(i)) && !lettereTrovate.contains(frase.charAt(i))) {
                            flag = false;
                        }
                        i++;
                    }

                    if (flag) {
                        numErrAgg = -1;
                    }
                }
            } else {
                numErrAgg++;
            }
        } else {
            numErrAgg++;
        }

        return numErrAgg;
    }

    private void mostra_errore_imp(short errore, StoryOutput storia) {
        short i;

        switch (errore) {
            case 1:
                i = 52;
                while (i <= 56) {
                    storia.mostra(i);
                    storia.pausa_output();
                    i++;
                }
                break;
            case 2:
                i = 57;
                storia.mostra(i++);
                GameOutput.pausa_output();
                storia.mostra(i++);
                GameOutput.pausa_output();
                storia.mostra(i++);
                GameOutput.pausa_output();
                break;
            case 3:
                i = 60;
                storia.mostra(i++);
                storia.mostra(i++);
                GameOutput.pausa_output();
                storia.mostra(i++);
                GameOutput.pausa_output();
                storia.mostra(i++);
                break;
            case 4:
                i = 64;
                storia.mostra(i++);
                GameOutput.pausa_output();
                storia.mostra(i++);
                storia.mostra(i++);
                GameOutput.pausa_output();
                break;
            case 5:
                i = 67;
                while (i <= 73) {
                    storia.mostra(i);
                    if (i == 72) {
                        storia.mostra(++i);
                    }
                    storia.pausa_output();
                    i++;
                }
                break;
            case 6:
                getJukeBox().play();
                getJukeBox().pause();
                getJukeBox().setVol(getJukeBox().getMinVol());
                getJukeBox().setAudioPosition(55);
                getJukeBox().setFadeVolGap((short) 5);
                getJukeBox().go_on();
                getJukeBox().fade_vol(-55, 0);
                getJukeBox().repeat(10);

                i = 74;
                while (i <= 80) {
                    storia.mostra(i);
                    storia.pausa_output();
                    i++;
                }

                AppOutput.mostra_nuovo_schermo();
                getJukeBox().setFadeVolGap((short) 1);
                getJukeBox().fade_vol(getJukeBox().getVol(), getJukeBox().getMinVol());
                storia.mostra(i++);
                storia.mostra(i++);
                storia.mostra(i++);
                storia.pausa_output();
                storia.mostra(i++);
                storia.pausa_output();
                storia.mostra(i++);
                storia.pausa_output();
                AppOutput.mostra_nuovo_schermo();
                break;
            default:
                break;
        }
    }

}
