package main;

import boundary.AppInput;
import boundary.AppOutput;
import control.AppLogic;

public class Main {

    public static void main(String[] args) {

        boolean flag;

        do {
            AppOutput.mostra_menu_app();
            flag = AppLogic.menu_app(AppInput.raccogli_comando_app(new String[]{"nuovapartita", "mostrasalvataggi", "esci"}));
        } while (!flag);
    }

}
