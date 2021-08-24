package utils;

import control.AppLogic;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Jukebox extends Thread {

    private final String estensione = ".wav";
    private final String defaultPath = "sounds/";
    private static short numJb;

    private String nomeJb;
    private String titolo;
    private String path;
    private boolean inRiproduzione;
    private Clip clip = null;
    private long intervalloTempo;
    private FloatControl volManager = null;
    private short differenzaVol;

    private class SoundEffect extends Thread {

        private final float volIniziale;
        private final float volFinale;

        public SoundEffect(float volIniziale, float volFinale) {
            this.volFinale = volFinale;
            this.volIniziale = volIniziale;
        }

        @Override
        public synchronized void run() {
            short i, distanza;
            setVol(volIniziale);
            if (volIniziale > volFinale) {
                distanza = (short) ((volIniziale - volFinale) / differenzaVol);
                for (i = 0; i < distanza; i++) {
                    setVol(volManager.getValue() - differenzaVol);
                    pausa_esecuzione(intervalloTempo);
                }
                if (volFinale == volManager.getMinimum()) {
                    volManager.setValue(volManager.getMinimum());
                }
            } else {
                distanza = (short) ((volFinale - volIniziale) / differenzaVol);
                for (i = 0; i < distanza; i++) {
                    setVol(volManager.getValue() + differenzaVol);
                    pausa_esecuzione(intervalloTempo);
                }
                if (volFinale == volManager.getMaximum()) {
                    volManager.setValue(volManager.getMaximum());
                }
            }
        }

        private void pausa_esecuzione(long durata) {
            try {
                Thread.sleep(durata);
            } catch (InterruptedException ex) {
                System.err.println("\n\nERRORE:\tE' avvenuta un'interruzione del processo.\n\n");
                Logger.getLogger(AppLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Jukebox() {
        nomeJb = "Jukebox-" + Short.toString(numJb);
        path = defaultPath;
        inRiproduzione = false;
        intervalloTempo = 1500;
        differenzaVol = 5;
        numJb++;
    }

    public Jukebox(String titolo) {
        nomeJb = "Jukebox-" + Short.toString(numJb);
        this.titolo = titolo.toLowerCase();
        path = defaultPath;
        inRiproduzione = false;
        intervalloTempo = 1500;
        differenzaVol = 5;
        numJb++;
    }

    public void setJbName(String nomeJb) {
        this.nomeJb = nomeJb;
    }

    public String getJbName() {
        return nomeJb;
    }

    public void setTitle(String nome) {
        this.titolo = nome.toLowerCase();
    }

    public String getTitle() {
        return titolo;
    }

    public void setPath(String path) {
        this.path = path.toLowerCase();
    }

    public String getPath() {
        return path;
    }

    public void setFadeTimeLapse(long intervalloTempo) {
        if (intervalloTempo >= 0) {
            this.intervalloTempo = intervalloTempo;
        }
    }

    public long getFadeTimeLapse() {
        return intervalloTempo;
    }

    public void setFadeVolGap(short differenzaVol) {
        if (differenzaVol > 0 && differenzaVol <= 70) {
            this.differenzaVol = differenzaVol;
        }
    }

    public short getFadeVolGap() {
        return differenzaVol;
    }

    public synchronized void play() {
        if (!inRiproduzione && !titolo.isEmpty()) {
            File fileAudio = new File(path + titolo + estensione);
            AudioInputStream audioStream;
            try {
                audioStream = AudioSystem.getAudioInputStream(fileAudio);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                volManager = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                inRiproduzione = true;
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Jukebox.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public synchronized void arrest() {
        if (inRiproduzione) {
            clip.stop();
            clip.flush();
            clip.close();
            inRiproduzione = false;
        }
    }

    public synchronized void go_on() {
        if (!inRiproduzione && clip != null && clip.isOpen()) {
            clip.start();
            inRiproduzione = true;
        }
    }

    public synchronized void pause() {
        if (inRiproduzione) {
            clip.stop();
            inRiproduzione = false;
        }
    }

    public synchronized void setVol(float vol) {
        if (clip != null && clip.isOpen() && vol <= volManager.getMaximum() && vol >= volManager.getMinimum()) {
            volManager.setValue(vol);
        }
    }

    public synchronized float getVol() {
        float vol = 0;

        if (clip != null && clip.isOpen()) {
            vol = volManager.getValue();
        }

        return vol;
    }

    public float getMaxVol() {
        float vol = 0;

        if (clip != null && clip.isOpen()) {
            vol = volManager.getMaximum();
        }

        return vol;
    }

    public float getMinVol() {
        float vol = 0;

        if (clip != null && clip.isOpen()) {
            vol = volManager.getMinimum();
        }

        return vol;
    }

    public synchronized void repeat(int ripetizioni) {
        if (inRiproduzione && ripetizioni > 0) {
            if (clip.isRunning()) {
                --ripetizioni;
            }
            clip.loop(ripetizioni);
        }
    }

    public synchronized void setAudioPosition(float posizioneSec) {
        long posizioneMicro = (long) (posizioneSec * 1000000);

        if (clip != null && clip.isOpen() && posizioneMicro >= 0 && posizioneMicro <= clip.getMicrosecondLength() && !inRiproduzione) {
            clip.setMicrosecondPosition(posizioneMicro);
        }
    }

    public synchronized float getAudioPosition() {
        float posizioneSec = 0;

        if (clip != null && clip.isOpen()) {
            posizioneSec = (float) (clip.getMicrosecondPosition() / 1000000);
        }

        return posizioneSec;
    }

    public synchronized float getAudioLength() {
        float durataSec = 0;

        if (clip != null && clip.isOpen()) {
            durataSec = (float) (clip.getMicrosecondLength() / 1000000);
        }

        return durataSec;
    }

    public void fade_vol(float volIniziale, float volFinale) {
        if (inRiproduzione && volIniziale != volFinale && volIniziale <= volManager.getMaximum() && volIniziale >= volManager.getMinimum()
                && volFinale >= volManager.getMinimum() && volFinale <= volManager.getMaximum()) {

            Thread sfuma = new SoundEffect(volIniziale, volFinale);
            sfuma.start();

        }
    }

}
