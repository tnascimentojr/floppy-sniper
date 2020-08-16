package org.academiadecodigo.floppysnipper;
import org.academiadecodigo.floppysnipper.elements.Element;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    private Picture menuBackground;
    private Picture gameBackground;

    private Picture help;
    private Picture gameOverPicture;
    private Picture button1;
    private Picture button2;
    private Picture exitButton;
    private Picture retryButton;
    private Picture buttonback;
    private Picture rambo;
    private Text score;

    private Cursor cursor;
    private Controller mouse;

    private int PADDING = 10;
    private int selected = 0;

    public Menu(Cursor cursor, Controller mouse) {
        this.cursor = cursor;
        this.mouse = mouse;

        menuBackground = new Picture(PADDING, PADDING, "resources/backgroundInitial.png");
        gameBackground = new Picture(PADDING, PADDING, "resources/backgroundGame.jpg");


        help = new Picture(355, 40, "resources/floppyhelp.png");
        // start button
        button1 = new Picture(283, menuBackground.getHeight() / 3, "resources/startbutton.png");
        // help button
        button2 = new Picture(400, menuBackground.getHeight() / 2, "resources/helpbutton.png");
        // quit button
        exitButton = new Picture(518,menuBackground.getHeight() * 2/3, "resources/exitbutton.png");
        // retry button at the end
        retryButton = new Picture(185, gameBackground.getHeight() * 2.3/4, "resources/retryButton.png");
        // GoBack button in the help menu
        buttonback = new Picture(477, 415, "resources/backbutton2.png");
        // GameOver image
        gameOverPicture = new Picture(PADDING,PADDING, "resources/backgroundGameOver.png");

        // Score text in Game Over menu
        score = new Text(530, 100, "SCORE");
        score.grow(40,40);

        rambo = new Picture(100, 230, "resources/rambogrande.png");

    }

    public void show() {
        menuBackground.draw();
        button1.draw();
        button2.draw();
        exitButton.draw();
    }

    public void hide() {
        menuBackground.delete();
        button1.delete();
        button2.delete();
        exitButton.delete();
    }

    public void help() {
        gameBackground.draw();
        help.draw();
        buttonback.draw();
        rambo.draw();


    }

    public void helpDelete() {
        gameBackground.delete();
        help.delete();
        buttonback.delete();
        rambo.delete();
    }

    public void gameOverMenuShow() {
        gameBackground.draw();
        gameOverPicture.draw();
        retryButton.draw();
        exitButton.draw();

        score.setColor(Color.WHITE);
        score.draw();

    }

    public void gameOverMenuDelete() {
        gameBackground.delete();
        gameOverPicture.delete();
        retryButton.delete();
        exitButton.delete();

        score.delete();
    }

    public int checkOption() {

        if ((cursor.getPreviousX() > button1.getX() && cursor.getPreviousX() < (button1.getX() + button1.getWidth())) &&
                (cursor.getPreviousY() > button1.getY() && cursor.getPreviousY() < (button1.getY() + button1.getHeight()))) {
            return 1;
        }

        if ((cursor.getPreviousX() > button2.getX() && cursor.getPreviousX() < (button2.getX() + button2.getWidth())) &&
                (cursor.getPreviousY() > button2.getY() && cursor.getPreviousY() < (button2.getY() + button2.getHeight()))) {
            return 2;
        }

        if ((cursor.getPreviousX() > exitButton.getX() && cursor.getPreviousX() < (exitButton.getX() + exitButton.getWidth())) &&
                (cursor.getPreviousY() > exitButton.getY() && cursor.getPreviousY() < (exitButton.getY() + exitButton.getHeight()))) {
            return 3;
        }

        return 0;
    }

    public int checkGameOverOptions() {

        if (  (cursor.getPreviousX() > exitButton.getX() && cursor.getPreviousX() < (exitButton.getX() + exitButton.getWidth())) &&
                (cursor.getPreviousY() > exitButton.getY() && cursor.getPreviousY() < (exitButton.getY() + exitButton.getHeight()))  ) {
            System.out.println(" ");

            return 1;
        }

        if (  (cursor.getPreviousX() > retryButton.getX() && cursor.getPreviousX() < (retryButton.getX() + retryButton.getWidth())) &&
                (cursor.getPreviousY() > retryButton.getY() && cursor.getPreviousY() < (retryButton.getY() + retryButton.getHeight()))  ) {
            System.out.println(" ");

            return 2;
        }

        return 3;
    }

}