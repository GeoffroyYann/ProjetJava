package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.ControllerFacade;
import controller.IController;
import facade.ModelFacade;
import model.IModel;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method with menu.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) throws InterruptedException, IOException, SQLException {
    	final Menu menu = new Menu();
    	while (menu.choix == false)
			Thread.sleep(10);
    	final IModel model = new ModelFacade(menu.level);
    	final ViewFacade view = new ViewFacade(model.getLevel(), model.getLorann(), model.getPurses(), model.getMonsters(), model.getEnergy_Ball(), model.getGate(), model.getFireBall());
        final IController controller = new ControllerFacade(view, model);
        
        view.setControllerEnum(controller.getOrderPerformer());
        controller.start();
    }
}
