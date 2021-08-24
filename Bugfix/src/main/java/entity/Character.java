package entity;

import java.util.Set;

public class Character {

    private String nome;
    private Set<String> alias;
    private boolean interagibile;
    private boolean attaccabile;

    public Character(String nome) {

        this.nome = nome;
        interagibile = false;

    }

    public boolean isAttaccabile() {
        return attaccabile;
    }

    public void setAttaccabile(boolean attaccabile) {
        this.attaccabile = attaccabile;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }

    public boolean isInteragibile() {
        return interagibile;
    }

    public void setInteragibile(boolean Interagibile) {
        this.interagibile = Interagibile;
    }

}
