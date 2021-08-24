package entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Commands {

    private final CommandType tipo;
    private final String nome;
    private Set<String> alias;
    private boolean usabile;

    public Commands(CommandType tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public Commands(CommandType tipo, String nome, Set<String> alias) {
        this.tipo = tipo;
        this.nome = nome;
        this.alias = alias;
    }
    
    public CommandType getType() {
        return tipo;
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

    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }

    public boolean isUsabile() {
        return usabile;
    }

    public void setUsabile(boolean usabile) {
        this.usabile = usabile;
    }
}
