package control.game;

import java.util.HashSet;
import java.util.Set;

import boundary.GameOutput;
import boundary.MinigameOutput;
import boundary.StoryOutput;
import entity.Commands;
import entity.Player;
import entity.AdvObject;
import entity.CommandType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ParserOutput;

public class Chapter3 extends Chapter {

    private class Riddle {

        private String indovinello;
        private Set<String> aliasSoluzione;
        private long tempoAttesa;

        private class SolutionGetter extends Thread {

            private boolean indovinelloRisolto;

            public SolutionGetter() {
                indovinelloRisolto = false;
            }

            public boolean isIndovinelloRisolto() {
                return indovinelloRisolto;
            }

            @Override
            public void run() {
                String risposta;
                boolean flag = false;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                while (!flag) {
                    try {

                        while (!br.ready()) {
                            attendi_interruzione((short) 100);
                        }

                        risposta = br.readLine().trim().toLowerCase();

                        if (aliasSoluzione.contains(risposta)) {
                            indovinelloRisolto = true;
                            flag = true;
                        } else {
                            MinigameOutput.mostra_errore_ind();
                        }

                    } catch (InterruptedException ex) {
                        flag = true;
                    } catch (IOException ex) {
                        System.err.println("\n\nERRORE:\tAcquisizione input fallita, thread interrotto.\n\n");
                        Logger.getLogger(SolutionGetter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            private void attendi_interruzione(short tempoAttesa) throws InterruptedException {
                Thread.sleep(tempoAttesa);
            }

        }

        private class Hourglass extends Thread {

            private boolean attesaInCorso;

            public Hourglass() {
                attesaInCorso = false;
            }

            public boolean isAttesaInCorso() {
                return attesaInCorso;
            }

            @Override
            public void run() {
                attesaInCorso = true;
                try {

                    Thread.sleep(tempoAttesa);
                    attesaInCorso = false;
                    MinigameOutput.mostra_tempo_scaduto();

                } catch (InterruptedException ex) {
                    ex.toString();
                }
            }

        }

        public Riddle() {
            this.indovinello = "";
            this.tempoAttesa = 0;
        }

        public Riddle(String indovinello, Set<String> aliasSoluzione) {
            this.indovinello = indovinello.trim();
            this.aliasSoluzione = aliasSoluzione;
            this.tempoAttesa = 0;
        }

        public Riddle(String indovinello, Set<String> aliasSoluzione, float tempoAttesa) {
            this.indovinello = indovinello.trim();
            this.aliasSoluzione = aliasSoluzione;
            if (tempoAttesa >= 0) {
                this.tempoAttesa = (long) (tempoAttesa * 1000);
            } else {
                this.tempoAttesa = 0;
            }
        }

        public String getIndovinello() {
            return indovinello;
        }

        public void setIndovinello(String indovinello) {
            this.indovinello = indovinello.trim();
        }

        public Set<String> getAliasSoluzione() {
            return aliasSoluzione;
        }

        public void setAliasSoluzione(Set<String> aliasSoluzione) {
            this.aliasSoluzione = aliasSoluzione;
        }

        public float getTempoAttesa() {
            return (float) (tempoAttesa / 1000);
        }

        public void setTempoAttesa(float tempoAttesa) {
            if (tempoAttesa >= 0) {
                this.tempoAttesa = (long) (tempoAttesa * 1000);
            }
        }

        public boolean gioca_indovinello() {
            boolean flag = false;
            Hourglass timer = new Hourglass();
            SolutionGetter raccogliRisposta = new SolutionGetter();
            MinigameOutput.stampa_output_minigioco(indovinello);
            MinigameOutput.richiedi_inserimento_ind();

            if (!indovinello.isEmpty() && aliasSoluzione != null && tempoAttesa > 0) {
                raccogliRisposta.start();
                timer.start();

                while (!flag) {
                    if (!raccogliRisposta.isAlive() || !timer.isAlive()) {
                        flag = true;
                        timer.interrupt();
                        raccogliRisposta.interrupt();
                    }
                }

                flag = raccogliRisposta.isIndovinelloRisolto() && timer.isAttesaInCorso();
            }

            return flag;
        }

    }

    public Chapter3(Player giocatore) {
        super(giocatore);
    }

    @Override
    protected void init_lists() {
        setNumeroFasi(8);
        Commands inventario = new Commands(CommandType.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv", "i", "I"});
        getComandi().add(inventario);
        Commands osserva = new Commands(CommandType.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"controlla", "analizza", "guarda", "vedi", "ispeziona", "esamina"});
        getComandi().add(osserva);
        getComandi().get(1).setUsabile(true);
        Commands cammina = new Commands(CommandType.CAMMINA, "cammina");
        cammina.setAlias(new String[]{"avanza", "prosegui", "continua", "vai", "corri", "avvicinati"});
        getComandi().add(cammina);
        getComandi().get(2).setUsabile(true);
        Commands prendi = new Commands(CommandType.PRENDI, "prendi");
        prendi.setAlias(new String[]{"raccogli", "acquisisci", "conserva", "leggi"});
        getComandi().add(prendi);
        Commands apri = new Commands(CommandType.APRI, "apri");
        apri.setAlias(new String[]{""});
        getComandi().add(apri);
        Commands help = new Commands(CommandType.HELP, "aiuto");
        help.setAlias(new String[]{"comandi?", "listacomandi", "help", "mostracomandi", "aiutocomandi"});
        getComandi().add(help);

        getOggetti().add(crea_giornale());
        getOggetti().add(crea_elmo());
        getOggetti().add(crea_baule());
        getOggetti().add(crea_stanza());
        getOggetti().add(crea_mucchio());
    }

    @Override
    protected String[] init_output() {
        String[] outCapitolo2 = new String[28];

        outCapitolo2[0] = " " + getGiocatore().getNome() + " :\n\tWOW! E' una stanza enorme... Il pavimento qui e' diverso, le pietre non sono \n"
                + "\ttutte scure, ma si alternano con alcune chiare. Sembra di camminare su una\n"
                + "\tscacchiera. Al centro di questo posto c'e' una testa gigante che occupa \n"
                + "\tquasi un quarto dello spazio.\n ";
        outCapitolo2[1] = " " + getGiocatore().getNome() + " :\n\tChi sei? Dove mi trovo? Che vuoi da me?\n\n"
                + " Kekko4K_Designer :\n\t'Avrai pure sconfitto me, ma non riuscirai mai a vincere \n"
                + "\tcontro gli altri due. Non ritornerai mai piu' indietro, rimarrai bloccato \n"
                + "\tqui con noi per sempre. AHAHAHAH!'\n ";
        outCapitolo2[2] = " " + getGiocatore().getNome() + " :\n\tLa testa si sta sbriciolando in tanti piccoli zero e uno. Di questo passo \n"
                + "\tnon potra' rispondere a nessuna delle mie domande. Meglio avvicinarsi\n"
                + "\til prima possibile.\n";
        outCapitolo2[3] = " " + getGiocatore().getNome() + " :\n\tE' troppo tardi. Non e' rimasto piu' di un mucchio di numeri. Ma cosa spunta dalle ceneri?\n";
        outCapitolo2[4] = " " + getGiocatore().getNome() + " :\n\tUn giornale, chissa' cosa c'e' scritto.\n";
        outCapitolo2[5] = " " + getGiocatore().getNome() + " :\n\tMa sono ritornato nella stanza con il baule... Per fortuna ho ancora il giornale. Inizio a leggere.\n";
        outCapitolo2[6] = " " + getGiocatore().getNome() + " :\n\t'Grave incidente: colpiti in tre, ricoverati in gravi condizioni. Il luogo del...'\n";
        outCapitolo2[7] = " " + getGiocatore().getNome() + " :\n\t'NO!'\n"
                + getGiocatore().getNome() + " :\n\tNon sono riuscito a leggere nulla. Il giornale e' scomparso dalle mie mani.\n";
        outCapitolo2[8] = " " + getGiocatore().getNome() + " :\n\tE ora cosa faccio? Questa stanza adesso e' un po' diversa...\n";
        outCapitolo2[9] = " " + getGiocatore().getNome() + " :\n\tIl baule l'avevo lasciato aperto, adesso e' chiuso...  ed esce un bagliore.\n";
        outCapitolo2[10] = " " + getGiocatore().getNome() + " :\n\tUn fulgido elmo! Mi fanno male gli occhi a guardarlo, non riesco a vederne i dettagli.\n";
        outCapitolo2[11] = " " + getGiocatore().getNome() + " :\n\t'Esci fuori, noi due dobbiamo parlare.'\n\n"
                + " Kekko4K_Designer :\n\t'Adesso devi solo pensare velocemente.'\n";
        outCapitolo2[12] = " " + getGiocatore().getNome() + " :\n\t'Che succede?'\n\n"
                + " " + getGiocatore().getNome() + " :\n\tLa porta dietro di me e' scomparsa. Il soffitto ha iniziato a brillare di un blu intenso. \n\tCi e' apparsa su una scritta... BOSS FIGHT. Ma allora sono davvero in un gioco...\n";
        outCapitolo2[13] = " " + getGiocatore().getNome() + " :\n\tQuesto blu ha illuminato la stanza. E' piu' piccola di quella di prima. \n"
                + "\tHa le pareti di un rosso spento e il pavimento e' fatto di pietre scure. \n"
                + "\tCi sono anche due quadri: quello a destra rappresenta il mare, quello sulla \n"
                + "\tsinistra un vulcano che sta eruttando. \n";
        outCapitolo2[14] = " " + getGiocatore().getNome() + " :\n\tE ora perche' il soffitto sta lampeggiando? E' come se volesse attirare \n"
                + "\tla mia attenzione. Stanno comparendo delle lettere su di esso... Si stanno \n"
                + "\tallineando componendo una frase: 'Tutti lo sanno aprire ma nessuno lo sa chiudere...\n"
                + "\tCos'e'?'\n";
        outCapitolo2[15] = " " + getGiocatore().getNome() + " :\n\t'Che vorrebbe dire? E' una sorta di indovinello?'\n";
        outCapitolo2[16] = " " + getGiocatore().getNome() + " :\n\tChe rumore frastornante! Adesso sembra che la stanza si stia restringendo.\n"
                + "\tFisso una parete: e' proprio cosi'! Le pareti si stanno lentamente avvicinando.\n";
        outCapitolo2[17] = " " + getGiocatore().getNome() + " :\n\t'Finiro' schiacciato! Devo rispondere all'indovinello prima che sia troppo tardi'\n";
        outCapitolo2[18] = " " + getGiocatore().getNome() + " :\n\tLe pareti si sono bloccate. Ci e' mancato poco. Ora ritornano nella loro posizione originaria. Sarei potuto diventare un hamburger!\n"
                + " " + getGiocatore().getNome() + " :\n\tOra posso stare tranquillo. OH NO, ancora! Il soffitto lampeggia di nuovo e altre lettere si stanno posizionando:\n \n";
        outCapitolo2[19] = " " + getGiocatore().getNome() + " :\n\tPerche' ho i piedi bagnati... ACQUA? Sgorga dal quadro che raffigura il mare!\n"
                + "\tSe continua cosi' si allaghera' tutto, devo rispondere in fretta. \n";
        outCapitolo2[20] = " " + getGiocatore().getNome() + " :\n\tL'acqua ha smesso di salire. Ho dato la risposta esatta quindi. Ora ci vorra'\n"
                + "\tuna vita per asciugarmi. Spero che questi indovinelli siano finti. \n";
        outCapitolo2[21] = " " + getGiocatore().getNome() + " :\n\tOh no, ancora! Spero sia l'ultimo: \n";
        outCapitolo2[22] = " " + getGiocatore().getNome() + " :\n\tChe caldo... cosa?!? LAVA? Dal quadro a sinistra sta\n"
                + "\tcolando della lava! Finiro' bruciato se non rispondo subito!\n";
        outCapitolo2[23] = " " + getGiocatore().getNome() + " :\n\tCi e' mancato poco...la lava si e' improvvisamente pietrificata.\n"
                + "\t Per il momento sono salvo, forse... devo andarmene\n"
                + "\tda qui alla svelta.\n ";
        outCapitolo2[24] = " " + getGiocatore().getNome() + " :\n\tSi e' aperto un altro varco li' davanti.\n";
        outCapitolo2[25] = " " + getGiocatore().getNome() + " :\n\tOh no!! STO PER ESSERE SCHIACCIATO!\n";
        outCapitolo2[26] = " " + getGiocatore().getNome() + " :\n\t'L'acqua! E' trop... BLBLORGH BLBLP'\n";
        outCapitolo2[27] = " " + getGiocatore().getNome() + " :\n\tAIUTO!!! E' arrivata la lavaaa!!! NOOOOOOO!!!!!!\n";

        return outCapitolo2;

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
        alias.add("albaule");
        alias.add("allacassa");
        baule.setAlias(alias);

        return baule;

    }

    private AdvObject crea_mucchio() {
        AdvObject mucchio = new AdvObject("mucchio");
        Set<String> alias = new HashSet<>();
        alias.add("ilmucchio");
        alias.add("cenere");
        alias.add("ceneri");
        alias.add("iceneri");
        alias.add("lacenere");
        alias.add("numeri");
        alias.add("inumeri");
        mucchio.setAlias(alias);

        return mucchio;

    }

    private AdvObject crea_giornale() {
        AdvObject giornale = new AdvObject("giornale");
        Set<String> alias = new HashSet<>();
        alias.add("ilgiornale");
        alias.add("carta");
        alias.add("lacarta");
        alias.add("carte");
        alias.add("lecarte");
        giornale.setAlias(alias);
        return giornale;
    }

    private AdvObject crea_elmo() {
        AdvObject elmo = new AdvObject("elmo");
        Set<String> alias = new HashSet<>();
        alias.add("l'elmo");
        alias.add("casco");
        alias.add("ilcasco");
        elmo.setAlias(alias);
        return elmo;
    }

    private AdvObject crea_stanza() {
        AdvObject giornale = new AdvObject("stanza");
        Set<String> alias = new HashSet<>();
        alias.add("lastanza");
        alias.add("camera");
        alias.add("lacamera");
        giornale.setAlias(alias);
        return giornale;
    }

    @Override
    protected int gioca_avventura(ParserOutput p, StoryOutput storia, int i) {
        switch (i) {
            case 0://cammina - osserva
                storia.mostra(12);
                storia.mostra(13);
                GameOutput.pausa_output();
                getJukeBox().setFadeTimeLapse(1000);
                getJukeBox().setFadeVolGap((short) 1);
                getJukeBox().setTitle("New-Game");
                getJukeBox().play();
                getJukeBox().setVol(-60);
                getJukeBox().fade_vol(getJukeBox().getVol(), -30);
                getJukeBox().repeat(1000);
                storia.mostra(14);
                storia.mostra(15);
                storia.mostra(16);
                GameOutput.pausa_output();
                storia.mostra(17);
                storia.mostra(18);
                GameOutput.pausa_output();
                Set<String> sol = new HashSet<>();
                sol.add("uovo");
                sol.add("uova");
                sol.add("le uova");
                sol.add("l'uovo");
                sol.add("l' uovo");
                sol.add("l uovo");
                Riddle indo = new Riddle("- \tTutti lo sanno aprire ma nessuno lo sa chiudere... Cos'e'?", sol, 180);
                getJukeBox().setFadeVolGap((short) 2);
                getJukeBox().fade_vol(getJukeBox().getVol(), -40);
                if (indo.gioca_indovinello()) {
                    storia.mostra(19);
                    storia.mostra(20);
                    GameOutput.pausa_output();
                    sol.clear();
                    sol.add("tempo");
                    sol.add("il tempo");
                    indo.setAliasSoluzione(sol);
                    indo.setTempoAttesa(120);
                    indo.setIndovinello("-\t'Questa cosa tutto divora, \n"
                            + "\tcio' che ha vita, la fauna e la flora;\n"
                            + "\ti re abbatte, e così le citta', \n"
                            + "\trode il ferro e la calce gia' dura; \n"
                            + "\te dei monti pianure fara'.'\n");
                    if (indo.gioca_indovinello()) {
                        storia.mostra(21);
                        storia.mostra(22);
                        storia.mostra(23);
                        GameOutput.pausa_output();
                        sol.clear();
                        sol.add("impronte");
                        sol.add("impronta");
                        sol.add("le impronte");
                        sol.add("l'impronta");
                        sol.add("l' impronta");
                        sol.add("l impronta");
                        indo.setTempoAttesa(60);
                        indo.setAliasSoluzione(sol);
                        indo.setIndovinello("-\t'Piu' ne fai e piu' ne lasci. Che cosa sono?'\n\n");
                        if (indo.gioca_indovinello()) {
                            getJukeBox().fade_vol(getJukeBox().getVol(), getJukeBox().getMinVol());
                            storia.mostra(24);
                            storia.mostra(25);
                        } else {
                            i = -2;
                            storia.mostra(28);
                        }
                    } else {
                        i = -2;
                        storia.mostra(27);
                    }
                } else {
                    i = -2;
                    storia.mostra(26);
                }
                break;

            case 1: //cammina
                storia.mostra(1);
                storia.mostra(2);
                storia.mostra(3);
                getComandi().get(1).setUsabile(false);
                break;
            case 2: //corri - avvicinati
                getJukeBox().arrest();
                storia.mostra(4);
                cambia_stato_oggetto("mucchio", 2, true);
                getComandi().get(2).setUsabile(false);
                break;
            case 3: //osserva mucchio
                storia.mostra(5);
                cambia_stato_oggetto("giornale", 2, true);
                cambia_stato_oggetto("giornale", 8, true);
                break;
            case 4: //raccogli giornale / osserva giornale
                GameOutput.err_codice_binario(2);
                storia.mostra(6);
                storia.mostra(7);
                storia.mostra(8);
                GameOutput.pausa_output();
                getJukeBox().setTitle("Electro-Fever");
                getJukeBox().play();
                getJukeBox().setVol(-60);
                getJukeBox().fade_vol(getJukeBox().getVol(), -37);
                getJukeBox().repeat(1000);
                storia.mostra(9);
                getComandi().get(1).setUsabile(true);
                cambia_stato_oggetto("giornale", 2, false);
                cambia_stato_oggetto("giornale", 8, false);
                cambia_stato_oggetto("stanza", 2, true);
                break;
            case 5:	//osserva - osserva stanza
                storia.mostra(10);
                getComandi().get(1).setUsabile(false);
                cambia_stato_oggetto("stanza", 2, false);
                cambia_stato_oggetto("baule", 2, true);
                cambia_stato_oggetto("baule", 3, true);
                break;
            case 6://osserva baule
                storia.mostra(11);
                cambia_stato_oggetto("elmo", 8, true);
                cambia_stato_oggetto("baule", 2, false);
                cambia_stato_oggetto("baule", 3, false);
                break;
            case 7://raccogli elmo
                if (!getGiocatore().getZaino().ricerca_oggetto("elmo")) {
                    getGiocatore().getZaino().aggiungi_oggetto(crea_elmo(), 1);
                    GameOutput.oggetto_aggiunto(crea_elmo());
                    cambia_stato_oggetto("elmo", 8, false);
                }

                break;
        }
        i++;
        return i;
    }

    @Override
    protected void introduzione_capitolo() {
        System.out.println(" " + getGiocatore().getNome() + " :\n\tHo aperto quest'altra porta, e anche qui e' buio. \n\n"
                + " Kekko4K_Designer :\n\t'AHAHAHAH.'\n");
        System.out.println(" " + getGiocatore().getNome() + " :\n\t'Che risata agghiacciante. Ma la voce mi e' familiare. Sara' uno di quei tipi\n"
                + "\tche mi hanno portato in questo incubo. Ma dove diavolo sono?'\n");

    }
}
