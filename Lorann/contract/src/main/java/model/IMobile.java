package model;


import java.awt.*;

import showboard.IPawn;

public interface IMobile extends IElement, IPawn {
    
    boolean moveUp();
    boolean moveDown();
    boolean moveRight();
    boolean moveLeft();
    void doNothing();
    int getX();
    int getY();
    boolean isAlive();
    boolean isHit(int newX, int newY);
    void setLocation(Point loc);
    void shot(int direction);
    Point getPos();
    int collect();
    
}
