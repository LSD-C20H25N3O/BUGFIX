package utils;

import entity.Commands;
import entity.AdvObject;
import entity.Character;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static int trova_comando(String token, List<Commands> comandi) {
        for (int i = 0; i < comandi.size(); i++) {
            if (comandi.get(i).getNome().equals(token) || comandi.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private static int trova_oggetto(String token, List<AdvObject> oggetti) {
        for (int i = 0; i < oggetti.size(); i++) {
            if (oggetti.get(i).getNome().equals(token) || oggetti.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private static int trova_personaggio(String token, List<Character> personaggio) {
        for (int i = 0; i < personaggio.size(); i++) {
            if (personaggio.get(i).getNome().equals(token) || personaggio.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    public static List<String> prepara_comando(String comando) {
        int i;
        List<String> token = new ArrayList<>();
        String[] splitted = comando.toLowerCase().trim().split("\\s+");

        if (splitted.length > 1) {
            for (i = 2; i < splitted.length; i++) {
                splitted[1] = splitted[1].concat(splitted[i]);
            }

            token.add(splitted[0]);
            token.add(splitted[1]);
        } else {
            token.add(splitted[0]);
        }

        return token;
    }

    public static ParserOutput analizza(String comando, List<Commands> comandi, List<AdvObject> oggetti, List<Character> personaggi) {
        List<String> token = prepara_comando(comando);
        if (!token.isEmpty()) {
            int idcomando = trova_comando(token.get(0), comandi);
            if (idcomando > -1) {
                if (token.size() == 1) {
                    return new ParserOutput(comandi.get(idcomando));
                } else {
                    int idoggetto = trova_oggetto(token.get(1), oggetti);
                    if (idoggetto > -1) {
                        return new ParserOutput(comandi.get(idcomando), oggetti.get(idoggetto));
                    } else {
                        int idpersonaggio = trova_personaggio(token.get(1), personaggi);
                        if (idpersonaggio > -1) {
                            return new ParserOutput(comandi.get(idcomando), personaggi.get(idpersonaggio));
                        } else {
                            return new ParserOutput(comandi.get(idcomando));
                        }
                    }
                }
            }
            return new ParserOutput(null);
        }
        return null;
    }

    public static boolean controllo_azione(ParserOutput p) {
        boolean flag = false;

        switch (p.getComandi().getType()) {
            case OSSERVA:
                if ((p.getOggetto() != null && p.getOggetto().isAnalizzabile() == true) || (p.getOggetto() == null && p.getComandi().isUsabile())) {
                    flag = true;
                }
                break;
            case INVENTARIO:
                if (p.getOggetto() == null) {
                    flag = true;
                }

                break;
            case TOCCA:
                if (p.getOggetto() != null && p.getOggetto().isUtilizzabile() == true) {
                    flag = true;
                }
                break;
            case USA:
                if (p.getOggetto() != null && p.getOggetto().isUtilizzabile() == true) {
                    flag = true;
                }
                break;
            case COLLEGA:
                if ((p.getOggetto() != null && p.getOggetto().isUtilizzabile() == true) || (p.getOggetto() == null && p.getComandi().isUsabile())) {
                    flag = true;
                }
                break;
            case SPINGI:
                if (p.getOggetto() != null && p.getOggetto().isSpostabile() == true) {
                    flag = true;
                }
                break;
            case APRI:
                if (p.getOggetto() != null && p.getOggetto().isApribile() == true) {
                    flag = true;
                }
                break;
            case PRENDI:
                if (p.getOggetto() != null && p.getOggetto().isRaccoglibile() == true) {
                    flag = true;
                }
                break;
            case CAMMINA:
                if ((p.getOggetto() != null && p.getOggetto().isPercorribile() == true) || (p.getOggetto() == null && p.getComandi().isUsabile())) {
                    flag = true;
                }
                break;
            case ACCETTA:
                if (p.getOggetto() == null && p.getComandi().isUsabile()) {
                    flag = true;
                }
                break;
            case RIFIUTA:
                if (p.getOggetto() == null && p.getComandi().isUsabile()) {
                    flag = true;
                }
                break;
            case HELP:
                if (p.getOggetto() == null) {
                    flag = true;
                }
                break;
            case BEVI:
                if (p.getOggetto() != null && p.getOggetto().isBevibile() == true) {
                    flag = true;
                }
                break;
            case CEDI:
                if (p.getOggetto() != null && p.getOggetto().isCedibile() == true) {
                    flag = true;
                }
                break;
            case RIPARA:
                if (p.getOggetto() != null && p.getOggetto().isUtilizzabile() == true) {
                    flag = true;
                }
            case PARLA:
                if (p.getPersonaggi() != null && p.getPersonaggi().isInteragibile()) {
                    flag = true;
                }
                break;
            case TORNA:
                if (p.getOggetto() != null && p.getOggetto().isUtilizzabile() == true) {
                    flag = true;
                }
                break;
            case COSTRUISCI:
                if (p.getOggetto() != null && p.getOggetto().isUtilizzabile() == true) {
                    flag = true;
                }
                break;
            case SPECIALE:
                if (p.getOggetto() != null && p.getOggetto().isSpeciale() == true) {
                    flag = true;
                }
                break;
            case CERCA:
                if (p.getOggetto() != null && p.getOggetto().isUtilizzabile() == true) {
                    flag = true;
                }
                break;
            case ROVESCIA:
                if (p.getOggetto() != null && p.getOggetto().isBevibile() == true) {
                    flag = true;
                }
                break;
            case CHIAMA:
                if (p.getOggetto() != null && p.getOggetto().isChiamabile() == true) {
                    flag = true;
                }
                break;
            case ATTACCA:
                if (p.getPersonaggi() != null && p.getPersonaggi().isAttaccabile()) {
                    flag = true;
                }
        }

        return flag;
    }

}
