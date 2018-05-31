package view;

import controller.IController;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {
    
    void setController(IController controller);
    
    void repaint();
    
    int getHeight();
    
    int getWidth();
    
    String getPseudo();
    
    void printMessage(final String message);

	void displayMessage(String message);

	void printMap(String map);    
    
}