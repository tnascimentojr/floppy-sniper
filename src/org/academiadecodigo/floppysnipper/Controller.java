package org.academiadecodigo.floppysnipper;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;

public class Controller implements MouseHandler {

    private Mouse mouse;
    private Background background;
    private Cursor cursor;
    private Sniper sniper;
    double clickCoordX;
    double clickCoordY;

    public void init(Background background, Sniper sniper, Cursor cursor) {

        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        this.background = background;
        this.sniper = sniper;
        this.cursor = cursor;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        this.clickCoordX = mouseEvent.getX();
        this.clickCoordY = mouseEvent.getY();

        cursor.target(mouseEvent.getX(), mouseEvent.getY());

    }

}
