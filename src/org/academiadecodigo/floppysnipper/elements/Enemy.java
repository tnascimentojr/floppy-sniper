package org.academiadecodigo.floppysnipper.elements;

import org.academiadecodigo.floppysnipper.Background;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy extends Element{

    public Enemy(Background background) {
        super(new Picture(background.PADDING, background.getHeight() / 3, "resources/queuecumbers2.png"));
    }
}
