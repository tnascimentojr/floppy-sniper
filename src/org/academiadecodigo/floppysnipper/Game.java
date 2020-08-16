package org.academiadecodigo.floppysnipper;

import org.academiadecodigo.floppysnipper.elements.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Game {

    private Background background;
    private Menu menu;
    private Sniper sniper;
    private Cursor cursor;
    private Controller mouse;
    private int delay;
    private boolean status;

    private Element[] airElementsArray;
    private Element[] groundElementsArray;

    private int counter = 1;
    private int counterImages = 1;
    private int numberOfElements = 10;
    private Integer killCounter = 0;

    private Picture buttonBack;

    public Game(Background background, Cursor cursor, Menu menu, Controller mouse, int delay) {

        this.background = background;
        this.cursor = cursor;
        this.menu = menu;
        this.mouse = mouse;
        this.sniper = new Sniper(background);

        mouse.init(background, sniper, cursor);

        this.delay = delay;
        status = false;

        this.buttonBack = new Picture(457, 415, "resources/backButton.png");
    }

    public void init() throws InterruptedException {

        while (!status) {
            menu.show();
            switch (menu.checkOption()) {
                case 1:
                    menu.hide();
                    background.show();
                    sniper.show();
                    status = true;
                    break;

                case 2:
                    menu.hide();
                    menu.help();

                    while (!((cursor.getPreviousX() > buttonBack.getX() &&
                            cursor.getPreviousX() < (buttonBack.getX() + buttonBack.getWidth())) &&
                            (cursor.getPreviousY() > buttonBack.getY() &&
                                    cursor.getPreviousY() < (buttonBack.getY() + buttonBack.getHeight())))) {

                        background.delete();        // this loop requires clicking buttonBack to proceed
                    }
                    menu.helpDelete();
                    break;

                case 3:
                    exit(0);
                    break;
            }
        }

        status = false;
        start();
    }

    public void start() throws InterruptedException {

        int random = (int) Math.random() * 5;

        airElementsArray = new Element[random + numberOfElements];
        groundElementsArray = new Element[3];

        for (int i = 0; i < numberOfElements; i++) {
            airElementsArray[i] = ElementFactory.getNewElement(background);
        }

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                groundElementsArray[i] = new Cat(Background.PADDING + 10);
            } else if (i == 1) {
                groundElementsArray[i] = new Cat(background.getWidth() - 35);
            } else {
                groundElementsArray[i] = new Cat(550);
            }
        }

        while (!checkGameOverCondition()) {
            Thread.sleep(delay);
            moveElements();
            checkShoot();
            checkGameOverCondition();
        }

        gameOver();
    }

    public void moveElements() {
        if (counterImages != airElementsArray.length) {
            if (counter % 40 == 0) {
                counterImages++;
            }
        }

        for (int i = 0; i < counterImages; i++) {
            airElementsArray[i].move();
            airElementsArray[i].show();

            if (counterImages != airElementsArray.length) {
                counter++;
            }
        }

        boolean showCats = false;

        if (counter > 280) {
            showCats = true;
        }

        if (counter < 100) {
            showCats = true;
        }

        if (showCats) {

            for (int i = 0; i < groundElementsArray.length; i++) {
                groundElementsArray[i].show();
            }

        } else {

            for (int i = 0; i < groundElementsArray.length; i++) {
                groundElementsArray[i].delete();
            }
        }

    }

    public void checkShoot() {
        if (cursor.getShotOn()) {

            for (Element i : airElementsArray) {
                if (cursor.getPreviousX() >= i.getImageStartX() && cursor.getPreviousX() <= i.getImageFinalX() &&
                        cursor.getPreviousY() >= i.getImageStartY() && cursor.getPreviousY() < i.getImageFinalY()) {

                    i.setIsDead();

                    if(i instanceof Enemy) {
                        killCounter++;
                    }

                    System.out.println(" ");

                }
            }
            for (Element i : groundElementsArray) {
                if (cursor.getPreviousX() >= i.getImageStartX() && cursor.getPreviousX() <= i.getImageFinalX() &&
                        cursor.getPreviousY() >= i.getImageStartY() && cursor.getPreviousY() < i.getImageFinalY()) {

                    i.setIsDead();
                    killCounter++;
                    System.out.println(" ");
                }
            }
            System.out.println(" ");

            cursor.setShotOn(false);
        }
    }

    public boolean checkGameOverCondition() {

        for (Element i : airElementsArray) {
            if (i instanceof Friend) {
                if (i.isDead()) {
                    return true;
                }
            }
            if (i instanceof Enemy) {
                if (!i.isDead()) {
                    return false;
                }
            }
        }
        for (Element i : groundElementsArray) {
            if (!i.isDead()) {
                return false;
            }
        }

        return true;
    }

    public void gameOver() throws InterruptedException {
        menu.gameOverMenuShow();

        String kills = killCounter.toString();

        Text numberKills = new Text(650,100, kills);

        numberKills.setColor(Color.WHITE);
        numberKills.grow(42,42);
        numberKills.draw();

        while (!status) {
            switch (menu.checkGameOverOptions()) {
                case 1:
                    System.out.println(" ");
                    exit(0);
                    break;
                case 2:
                    System.out.println(" ");
                    status = true;
                    break;
                default:
                    System.out.println(" ");
                    status = false;
                    break;
            }
        }


        numberKills.delete();
        menu.gameOverMenuDelete();

        for (Element i : airElementsArray) {
            i.delete();
        }
        for (Element i : groundElementsArray) {
            i.delete();
        }

        killCounter = 0;
        counter = 0;
        counterImages = 0;
        status = false;
        init();

    }

}

