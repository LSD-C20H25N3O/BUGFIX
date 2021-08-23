package boundary;

import java.util.Scanner;

public class AppInput {

    public static String raccogli_comando_app(String[] comandiAccettati) {
        int i;
        boolean flag = false;
        String comando;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.flush();
            comando = scan.nextLine().toLowerCase().replaceAll("\\s", "");
            i = 0;
            while (!flag && i < comandiAccettati.length) {
                flag = comando.equals(comandiAccettati[i]);
                i++;
            }

            if (!flag) {
                AppOutput.mostra_errore_comando2();
            }
        } while (!flag);

        return comando;
    }

    public static String raccogli_input() {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println();
        System.out.flush();
        do {
            input = scan.nextLine().trim();
            System.out.flush();
        } while (input.isEmpty());

        return input;
    }

    public static int raccogli_numero() {
        String input;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.flush();
        do {
            input = scan.nextLine().toLowerCase().replaceAll("\\s", "");
            System.out.flush();
            if (!input.matches("\\d+")) {
                AppOutput.mostra_errore_numero_file();
            }
        } while (!input.matches("\\d+"));

        return Integer.parseInt(input);
    }

    public static boolean raccogli_conferma() {
        boolean flag = false, risposta = false;
        String conferma;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.flush();
            conferma = scan.nextLine().toLowerCase().replaceAll("\\s", "");
            if (conferma.equals("si") || conferma.equals("si.") || conferma.equals("sì") || conferma.equals("sì.") || conferma.equals("si'") || conferma.equals("si'.")) {
                flag = true;
                risposta = true;
            } else if (conferma.equals("no") || conferma.equals("no.")) {
                flag = true;
            }

            if (!flag) {
                AppOutput.mostra_errore_comando2();
            }
        } while (!flag);

        return risposta;
    }
    
}
