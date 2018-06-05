package controller;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;

import model.IElement;
import model.MobileOrder;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {

    
    void start() throws SQLException, InterruptedException, IOException;
    
    ControllerEnum getOrderPerformer();
}
