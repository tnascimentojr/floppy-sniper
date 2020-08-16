package org.academiadecodigo.floppysnipper.elements;

import org.academiadecodigo.floppysnipper.Background;

public class ElementFactory {

    public static Element getNewElement(Background background) {

        Element element;

        if(Math.random() < 0.75) {
            element = new Enemy(background);
        } else {
            element = new Friend(background);
        }

        return element;
    }
}
