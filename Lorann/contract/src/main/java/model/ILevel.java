package model;

import java.awt.Point;
import java.util.Observable;

public interface ILevel {
    int getWidth();
    int getHeight();
    IElement getOnTheLevelXY(int x, int y);
    void setOnTheLevelXY(int x, int y, IElement element);
    boolean setSpellOnTheLevelXY(int x, int y, IElement fireBall);
    Observable getObservable();
    void setElementHasChanged();
    Point getLorannPosition();
    IMobile[] getPurses();
    IMobile[] getMonsters();
    IMobile getEnergy_Ball();
    IMobile[] getGate();

}
