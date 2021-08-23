package entity;

import java.io.Serializable;

public class Player implements Serializable {

    private String nome;
    private int checkPoint;
    private Inventory zaino;

    private String salvataggio;
    private String path;

    public Player() {
        checkPoint = 0;
        zaino = new Inventory();
        salvataggio = "salvataggio-" + Integer.toString(checkPoint);
        path = "gameData/";
    }

    public Player(String nome) {
        this.nome = nome;
        checkPoint = 0;
        zaino = new Inventory();
        salvataggio = "salvataggio-" + Integer.toString(checkPoint);
        path = "gameData/";
    }

    public Player(Player giocatore) {
        this.nome = giocatore.nome;
        this.checkPoint = giocatore.checkPoint;
        this.zaino = new Inventory(giocatore.zaino);
        this.salvataggio = giocatore.salvataggio;
        this.path = giocatore.path;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(int checkPoint) {
        this.checkPoint = checkPoint;
    }

    public Inventory getZaino() {
        return zaino;
    }

    public void setZaino(Inventory zaino) {
        this.zaino = zaino;
    }

    public String getSalvataggio() {
        return salvataggio;
    }

    public void setSalvataggio(String salvataggio) {
        this.salvataggio = salvataggio;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
