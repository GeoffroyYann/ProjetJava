package model;


import java.awt.*;
import java.util.Hashtable;
import java.util.Observable;


/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    Observable getObservable();
    
    String getMap();
    
    void loadMap(String key);
    
    IElement element(char c, Point pos);
    
    String[][] getHighScore();
    
    void upNameAndScore(final int score, final String nickname);

}
