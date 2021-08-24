package entity;

import java.io.Serializable;
import java.util.HashMap;
import boundary.GameOutput;

public class Inventory implements Serializable {

    private boolean disponibilitaInv;
    private final HashMap<AdvObject, Integer> inventario;
    private final int CAPIENZA_ZAINO = 15;
    private final int CAPIENZA_PER_OGGETTO = 5;
    private int numOggetti;

    public Inventory() {
        this.disponibilitaInv = false;
        inventario = new HashMap<>();
        this.numOggetti = 0;
    }

    public Inventory(Inventory inv) {
        this.disponibilitaInv = inv.disponibilitaInv;
        this.inventario = new HashMap<>(inv.inventario);
        this.numOggetti = inv.numOggetti;
    }

    public int getNumOggetti() {
        return numOggetti;
    }

    public void setNumOggetti(int numOggetti) {
        this.numOggetti = numOggetti;
    }

    public void setDisponibilitaInv(boolean disponibilitaInv) {
        this.disponibilitaInv = disponibilitaInv;
    }

    public boolean getDisponibilitaInv() {
        return disponibilitaInv;
    }

    public void aggiungi_oggetto(AdvObject oggetto, int quantita) {
        if (getDisponibilitaInv() == true && getNumOggetti() < CAPIENZA_ZAINO) {
            Integer q = inventario.get(oggetto);
            if (q == null) {
                if (quantita <= CAPIENZA_PER_OGGETTO) {
                    inventario.put(oggetto, quantita);
                    setNumOggetti(numOggetti + quantita);
                } else {
                    inventario.put(oggetto, CAPIENZA_PER_OGGETTO);
                    setNumOggetti(numOggetti + CAPIENZA_PER_OGGETTO);
                }
            } else {
                if (q < CAPIENZA_PER_OGGETTO) {
                    if (q + quantita < CAPIENZA_PER_OGGETTO) {
                        inventario.put(oggetto, q + quantita);
                        setNumOggetti(numOggetti + q + quantita);
                    } else if (q + quantita >= CAPIENZA_PER_OGGETTO) {
                        inventario.put(oggetto, CAPIENZA_PER_OGGETTO);
                        setNumOggetti(numOggetti + CAPIENZA_PER_OGGETTO);
                    }
                } else {
                    GameOutput.inventario_pieno();
                }
            }
        } else if (getDisponibilitaInv() == false && getNumOggetti() <= CAPIENZA_ZAINO) {
            GameOutput.assenza_inventario();
        } else if (getNumOggetti() >= CAPIENZA_ZAINO && getDisponibilitaInv() == true) {
            GameOutput.inventario_pieno();
        }
    }

    public void rimuovi_oggetto(AdvObject oggetto, int quantita) {
        if (!inventario.isEmpty() && quantita <= CAPIENZA_PER_OGGETTO) {
            Integer q = inventario.get(oggetto);
            if (q != null) {
                if (q == quantita) {
                    inventario.remove(oggetto);
                    setNumOggetti(numOggetti - quantita);
                } else if (q > quantita) {
                    inventario.put(oggetto, q - quantita);
                }
            }
        } else {
            GameOutput.oggetto_assente();
        }
    }

    public AdvObject cerca_oggetto(String key) {
        AdvObject risultato = null;
        for (AdvObject oggetto : inventario.keySet()) {
            if (oggetto.getNome().equals(key.trim())) {
                risultato = oggetto;
            }
        }
        return risultato;
    }

    public boolean ricerca_oggetto(String key) {
        boolean risultato = false;
        for (AdvObject oggetto : inventario.keySet()) {
            if (oggetto.getNome().equals(key.trim())) {
                risultato = true;
            }
        }
        return risultato;
    }

    public int quantita_oggetto(AdvObject oggetto) {
        Integer q = inventario.get(oggetto);
        return q;
    }

    public HashMap<AdvObject, Integer> getInv() {
        return inventario;
    }

}
