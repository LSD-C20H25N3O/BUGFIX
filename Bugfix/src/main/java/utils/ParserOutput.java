package utils;

import entity.Commands;
import entity.AdvObject;
import entity.Character;

public class ParserOutput {

    private Commands comandi;
    private AdvObject oggetto;
    private Character personaggi;

    public ParserOutput(Commands comandi) {
        this.comandi = comandi;
        this.oggetto = null;
        this.personaggi = null;
    }

    public ParserOutput(Commands comandi, AdvObject oggetto) {
        this.comandi = comandi;
        this.oggetto = oggetto;
        this.personaggi = null;
    }

    public ParserOutput(Commands comandi, Character personaggi) {
        this.comandi = comandi;
        this.oggetto = null;
        this.personaggi = personaggi;
    }

    public Commands getComandi() {
        return comandi;
    }

    public void setComandi(Commands comandi) {
        this.comandi = comandi;
    }

    public AdvObject getOggetto() {
        return oggetto;
    }

    public void setOggetto(AdvObject oggetto) {
        this.oggetto = oggetto;
    }

    public Character getPersonaggi() {
        return personaggi;
    }

    public void setPersonaggi(Character personaggi) {
        this.personaggi = personaggi;
    }
}
