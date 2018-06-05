package model;


import java.awt.*;
import java.sql.SQLException;
import java.util.Observable;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public interface IModel {

    ILevel getLevel();
    IMobile getLorann();
    IMobile[] getPurses();
    IMobile[] getMonsters();
    IMobile getEnergy_Ball();
    IMobile getGate();
    IMobile getFireBall();
    boolean hasLorannWon();
    
    
}

