package org.academiadecodigo.floppysnipper.elements;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Element {

    private boolean isDead;
    private boolean wentUp;

    private int imageFinalX;
    private int imageStartX;
    private int imageStartY;
    private int imageFinalY;

    private Picture element;

    public Element(Picture element) {
        this.element = element;
        imageStartX = element.getX();
        imageFinalX = imageStartX + element.getWidth();
        imageStartY = element.getY();
        imageFinalY = imageStartY + element.getHeight();

    }

    public void move() {

        if (imageFinalX >= 870) {

            if (!wentUp) {
                element.translate(-700,70);
                wentUp = true;

            } else {
                element.translate(-700, -70);
                wentUp = false;
            }
        }

        int random = element.getWidth() + (int) Math.ceil(Math.random() * 4);

        element.translate(7, 0);

        imageStartX = element.getX();
        imageFinalX = imageStartX + element.getWidth();
    }

    public void show() {
        if(!isDead) {
            element.draw();
        }
    }

    public void delete() {
        element.delete();
    }

    public void setIsDead() {
        element.delete();
        isDead = true;
    }
    public boolean isDead() {
        return isDead;
    }

    public int getImageStartX() {
        return imageStartX;
    }

    public int getImageFinalX() {
        return imageFinalX;
    }

    public int getImageStartY() {
        return imageStartY;
    }

    public int getImageFinalY() {
        return imageFinalY;
    }

}