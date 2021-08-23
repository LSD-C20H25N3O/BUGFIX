package control.game;

import boundary.AppInput;
import boundary.AppOutput;
import boundary.GameOutput;
import boundary.StoryOutput;
import control.AppLogic;
import entity.Commands;
import entity.Player;
import entity.AdvObject;
import entity.Character;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.Jukebox;
import utils.Parser;
import utils.ParserOutput;

public abstract class Chapter {

    private int numeroFasi;

    private final Player giocatore;

    private final Jukebox jukeBox = new Jukebox();

    private final List<Commands> comandi = new ArrayList<>();

    private final List<AdvObject> oggetti = new ArrayList<>();

    private final List<Character> personaggi = new ArrayList<>();

    private final Scanner scan = new Scanner(System.in);

    private final String exit = "#esci";

    private final String inv = "inventario";

    private final String help = "aiuto";

    public Chapter(Player giocatore) {
        this.giocatore = giocatore;
    }

    public Player getGiocatore() {
        return giocatore;
    }

    public Jukebox getJukeBox() {
        return jukeBox;
    }

    public List<Commands> getComandi() {
        return comandi;
    }

    public List<AdvObject> getOggetti() {
        return oggetti;
    }

    public List<Character> getPersonaggi() {
        return personaggi;
    }

    public int getNumeroFasi() {
        return numeroFasi;
    }

    public void setNumeroFasi(int numeroFasi) {
        if (numeroFasi > 0) {
            this.numeroFasi = numeroFasi;
        }
    }

    protected abstract void init_lists();

    protected abstract String[] init_output();

    protected void cambia_stato_oggetto(String oggetto, int numStato, boolean stato) {
        for (int i = 0; i < oggetti.size(); i++) {
            if (oggetti.get(i).getNome().equals(oggetto) || oggetti.get(i).getAlias().contains(oggetto)) {
                switch (numStato) {
                    case 1:
                        if (oggetti.get(i).isUtilizzabile() != stato) {
                            oggetti.get(i).setUtilizzabile(stato);
                        }
                        break;
                    case 2:
                        if (oggetti.get(i).isAnalizzabile() != stato) {
                            oggetti.get(i).setAnalizzabile(stato);
                        }
                        break;
                    case 3:
                        if (oggetti.get(i).isApribile() != stato) {
                            oggetti.get(i).setApribile(stato);
                        }
                        break;
                    case 4:
                        if (oggetti.get(i).isBevibile() != stato) {
                            oggetti.get(i).setBevibile(stato);
                        }
                        break;
                    case 5:
                        if (oggetti.get(i).isCedibile() != stato) {
                            oggetti.get(i).setCedibile(stato);
                        }
                        break;
                    case 6:
                        if (oggetti.get(i).isChiamabile() != stato) {
                            oggetti.get(i).setChiamabile(stato);
                        }
                        break;
                    case 7:
                        if (oggetti.get(i).isPercorribile() != stato) {
                            oggetti.get(i).setPercorribile(stato);
                        }
                        break;
                    case 8:
                        if (oggetti.get(i).isRaccoglibile() != stato) {
                            oggetti.get(i).setRaccoglibile(stato);
                        }
                        break;
                    case 9:
                        if (oggetti.get(i).isSpostabile() != stato) {
                            oggetti.get(i).setSpostabile(stato);
                        }
                        break;
                    case 10:
                        if (oggetti.get(i).isSpeciale() != stato) {
                            oggetti.get(i).setSpeciale(stato);
                        }
                        break;
                }
            }
        }
    }

    protected abstract int gioca_avventura(ParserOutput p, StoryOutput storia, int i);

    protected abstract void introduzione_capitolo();

    protected boolean chiudi_capitolo() {
        boolean flag;

        AppOutput.richiedi_conferma();
        if (AppInput.raccogli_conferma()) {
            jukeBox.setFadeTimeLapse(375);
            jukeBox.setFadeVolGap((short) 3);
            jukeBox.fade_vol(jukeBox.getVol() - 4, jukeBox.getMinVol());
            AppOutput.mostra_uscita_gioco();
            GameOutput.pausa_output();
            flag = true;
        } else {
            AppOutput.mostra_annullamento_comando();
            flag = false;
        }

        return flag;
    }

    public Player inizia() {
        int i = 0;
        boolean flag = false;
        ParserOutput par;
        String comando;

        init_lists();
        StoryOutput dialoghi = new StoryOutput(init_output());

        introduzione_capitolo();
        while (!flag) {
            comando = scan.nextLine();
            if (comando.trim().equalsIgnoreCase(exit)) {
                flag = chiudi_capitolo();
            } else {
                par = Parser.analizza(comando, comandi, oggetti, personaggi);
                if (par.getComandi() != null && Parser.controllo_azione(par)) {
                    if (par.getComandi().getNome().trim().equalsIgnoreCase(inv) || par.getComandi().getAlias().contains(inv)) {
                        GameOutput.mostra_inventario(giocatore);
                    } else if (par.getComandi().getNome().trim().equalsIgnoreCase(help) || par.getComandi().getAlias().contains(help)) {
                        GameOutput.mostra_help_comandi();
                    } else {
                        i = gioca_avventura(par, dialoghi, i);
                    }

                    if (i >= numeroFasi || i == -1 || i == (numeroFasi * -10)) {
                        jukeBox.setFadeTimeLapse(375);
                        jukeBox.setFadeVolGap((short) 3);
                        jukeBox.fade_vol(jukeBox.getVol() - 4, jukeBox.getMinVol());
                        flag = true;
                    }
                } else {
                    GameOutput.err_comando_gioco();
                }
            }
        }

        if (flag && i >= numeroFasi) {
            giocatore.setCheckPoint(giocatore.getCheckPoint() + 1);
            GameOutput.separatore();
        } else if (flag && i == -1) {
            GameOutput.mostra_game_over();
            GameOutput.pausa_output();
            GameOutput.separatore();
            giocatore.setCheckPoint(-1);
        }

        while (jukeBox.getMinVol() != jukeBox.getMaxVol() && jukeBox.getVol() > -65) {
            AppLogic.pausa_esecuzione(200);
        }

        jukeBox.arrest();

        return giocatore;
    }

}
