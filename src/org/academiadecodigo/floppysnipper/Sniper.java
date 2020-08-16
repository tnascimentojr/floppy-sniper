package org.academiadecodigo.floppysnipper;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sniper {

    private Picture sniper;
    private Background background;

    public Sniper(Background background) {
        this.background = background;
        sniper = new Picture(370, 370, "resources/rambo.png");
        sniper.grow(25,25);
    }

    public void show() {
        sniper.draw();
    }

    public void hide(){
        sniper.delete();
    }

}
