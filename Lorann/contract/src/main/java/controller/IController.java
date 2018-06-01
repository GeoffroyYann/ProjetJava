package controller;

import java.awt.Point;
import model.IElement;
import model.MobileOrder;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {

    
    void orderPerform(ControllerEnum controllerEnum);
    
    IElement[][] getTileMap();
    
    int getScore();
    
    Point computeNextPos(MobileOrder direction, Point currentPos);
    
    int getLevel();
    
    IElement[][] parser(String tilemap);
    
    String[][] getScores();


}
