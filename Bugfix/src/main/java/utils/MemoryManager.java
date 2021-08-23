package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemoryManager {

    private final short defaultMax = 5;
    private final String separator = "/";
    private final String defaultPath = "gameData" + separator;

    private int maxNumFileTot;
    private File[] listaFile;
    private File gameDir;
    private String path;

    public MemoryManager() {
        path = defaultPath;
        gameDir = new File(path);
        if (!gameDir.exists()) {
            gameDir.mkdirs();
        }
        listaFile = gameDir.listFiles();
        if (listaFile.length > defaultMax) {
            maxNumFileTot = listaFile.length;
        } else {
            maxNumFileTot = defaultMax;
        }
    }

    public MemoryManager(String path, int maxNumFile) {
        this.path = path.toLowerCase() + separator;
        gameDir = new File(path);
        if (!gameDir.exists()) {
            gameDir.mkdirs();
        }
        listaFile = gameDir.listFiles();
        if (maxNumFile >= listaFile.length) {
            this.maxNumFileTot = maxNumFile;
        } else {
            this.maxNumFileTot = listaFile.length;
        }
    }

    public int getMaxNumFileTot() {
        return maxNumFileTot;
    }

    public void setMaxNumFileTot(int maxNumFile) {
        if (maxNumFile >= listaFile.length) {
            this.maxNumFileTot = maxNumFile;
        } else {
            this.maxNumFileTot = listaFile.length;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path.toLowerCase() + separator;
        gameDir = new File(path);
        if (!gameDir.exists()) {
            gameDir.mkdirs();
        }
        listaFile = gameDir.listFiles();
        if (listaFile.length > maxNumFileTot) {
            maxNumFileTot = listaFile.length;
        }
    }

    public String getNomeFile(int numFile) {
        int indiceFile = numFile - 1;
        String nomeFile = "";

        if (indiceFile >= 0 && indiceFile < listaFile.length) {
            nomeFile = listaFile[indiceFile].getName();
        }

        return nomeFile;
    }

    public void setNomeFile(int numFile, String nuovoNome) {
        int indiceFile = numFile - 1;
        if (indiceFile >= 0 && indiceFile < listaFile.length && !esisteFile(nuovoNome)) {
            File fileModificato = new File(path + nuovoNome);
            listaFile[indiceFile].renameTo(fileModificato);
            listaFile = gameDir.listFiles();
        }
    }

    public boolean esisteFile(String nomeFile) {
        File controlloFile = new File(path + nomeFile);

        return controlloFile.exists();
    }

    public int getIndiceFile(String nomeFile) {
        int i = 0, indice = 0;
        boolean flag = false;

        while (i < listaFile.length && !flag) {
            if (listaFile[i].getName().equals(nomeFile)) {
                indice = i + 1;
                flag = true;
            }
            i++;
        }

        return indice;
    }

    public int getNumFileTot() {
        return listaFile.length;
    }

    public void salvaFile(Object oggetto, String nomeFile) {
        if (esisteFile(nomeFile)) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path + nomeFile))) {
                out.writeObject(oggetto);
                out.close();
            } catch (FileNotFoundException ex) {
                System.err.println("ERRORE:\tSalvataggio fallito, file non trovato.\n");
                Logger.getLogger(MemoryManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.err.println("ERRORE:\tSalvataggio fallito, operazioni di I/O non riuscite.\n");
                Logger.getLogger(MemoryManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("ERRORE:\tSalvataggio fallito, file non trovato.\n");
        }
    }

    public Object caricaFile(String nomeFile) {
        Object oggetto = null;

        if (esisteFile(nomeFile)) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path + nomeFile))) {
                oggetto = (Object) in.readObject();
                in.close();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("ERRORE:\tCaricamento fallito, operazioni di I/O non riuscite\n\t  o salvataggio corrotto.\n");
                Logger.getLogger(MemoryManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("ERRORE:\tCaricamento fallito, file non trovato.\n");
        }

        return oggetto;
    }

    public void aggiungiFile(String nomeFile) {
        if (listaFile.length < maxNumFileTot && !esisteFile(nomeFile)) {
            File nuovoFile = new File(path + nomeFile);
            try {
                nuovoFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(MemoryManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaFile = gameDir.listFiles();
        }
    }

    public void cancellaFile(String nomeFile) {
        if (esisteFile(nomeFile)) {
            File exFile = new File(path + nomeFile);
            exFile.delete();
            listaFile = gameDir.listFiles();
        }
    }

}
