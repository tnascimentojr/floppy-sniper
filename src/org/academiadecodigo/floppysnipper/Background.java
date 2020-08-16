package org.academiadecodigo.floppysnipper;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture background;
    private int width;
    private int height;
    public static final int PADDING = 10;


    public Background() {
        background = new Picture(PADDING, PADDING, "resources/backgroundGame.jpg");
        this.width = background.getWidth();
        this.height = background.getHeight();
    }

    public void show() {
        background.draw();
    }

    public void delete() {
        background.delete();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
