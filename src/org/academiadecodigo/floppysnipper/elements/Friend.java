package org.academiadecodigo.floppysnipper.elements;

import org.academiadecodigo.floppysnipper.Background;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Friend extends Element {

    public Friend(Background background) {
        super(new Picture(background.PADDING, background.getHeight() / 3, "resources/floppyResized.png"));
    }


}
