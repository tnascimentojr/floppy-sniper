package org.academiadecodigo.floppysnipper;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cursor {
    private Picture target;
    private Background background;

    private double previousX;
    private double previousY;
    private Boolean shotOn = false;

    public Cursor(Background background) {
        this.background = background;
        this.target = new Picture(0, 0, "resources/mira2.png");
    }

    public void target(double x, double y) {
        shotOn = true;

        target.translate((x - previousX) - 15, (y - previousY) - 53);

        this.previousX = x - 15;
        this.previousY = y - 53;

        show();
    }

    public void show() {
        target.draw();
    }

    public void hide() {
        target.delete();
    }

    public double getPreviousX() {
        return previousX;
    }

    public double getPreviousY() {
        return previousY;
    }

    public void setShotOn(Boolean shotOn) {
        this.shotOn = shotOn;
    }

    public Boolean getShotOn() {
        hide();
        return shotOn;
    }
}
