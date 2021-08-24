package entity;

import java.io.Serializable;
import java.util.Set;

public class AdvObject implements Serializable {

    private final String nome;
    private Set<String> alias;
    private boolean utilizzabile;
    private boolean raccoglibile;
    private boolean analizzabile;
    private boolean apribile;
    private boolean bevibile;
    private boolean spostabile;
    private boolean cedibile;
    private boolean chiamabile;
    private boolean percorribile;

    public boolean isPercorribile() {
        return percorribile;
    }

    public void setPercorribile(boolean percorribile) {
        this.percorribile = percorribile;
    }

    public boolean isChiamabile() {
        return chiamabile;
    }

    public void setChiamabile(boolean chiamabile) {
        this.chiamabile = chiamabile;
    }

    public boolean isBevibile() {
        return bevibile;
    }

    public void setBevibile(boolean bevibile) {
        this.bevibile = bevibile;
    }

    public boolean isSpostabile() {
        return spostabile;
    }

    public void setSpostabile(boolean spostabile) {
        this.spostabile = spostabile;
    }

    public boolean isCedibile() {
        return cedibile;
    }

    public void setCedibile(boolean cedibile) {
        this.cedibile = cedibile;
    }

    public boolean isSpeciale() {
        return speciale;
    }

    public void setSpeciale(boolean speciale) {
        this.speciale = speciale;
    }
    private boolean speciale;

    public boolean isUtilizzabile() {
        return utilizzabile;
    }

    public void setUtilizzabile(boolean utilizzabile) {
        this.utilizzabile = utilizzabile;
    }

    public boolean isRaccoglibile() {
        return raccoglibile;
    }

    public void setRaccoglibile(boolean raccoglibile) {
        this.raccoglibile = raccoglibile;
    }

    public boolean isAnalizzabile() {
        return analizzabile;
    }

    public void setAnalizzabile(boolean analizzabile) {
        this.analizzabile = analizzabile;
    }

    public boolean isApribile() {
        return apribile;
    }

    public void setApribile(boolean apribile) {
        this.apribile = apribile;
    }

    public AdvObject(String nome) {
        this.nome = nome;
        analizzabile = false;
        apribile = false;
        raccoglibile = false;
        utilizzabile = false;
        percorribile = false;
        bevibile = false;
        cedibile = false;
        chiamabile = false;
        spostabile = false;
    }

    public String getNome() {
        return nome;
    }

    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }

}
