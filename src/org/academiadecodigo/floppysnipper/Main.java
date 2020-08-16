package org.academiadecodigo.floppysnipper;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Background background = new Background();
        Cursor cursor = new Cursor(background);
        Controller mouse = new Controller();
        Menu menu = new Menu(cursor, mouse);

        Game DuckHunt = new Game(background, cursor, menu, mouse, 60);

        DuckHunt.init();
    }
}
