package controller;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
    public void orderPerform (final ControllerOrder controllerOrder) {
    	switch (controllerOrder) {
    	case Map1:
    		//this.model.loadMap("MAP1");
    		break;
    	case Map2:
    		//this.model.loadMap("MAP1");
    		break;
    	case Map3:
    		//this.model.loadMap("MAP1");
    		break;
    	case Map4:
    		//this.model.loadMap("MAP1");
    		break;
    	case Map5:
    		//this.model.loadMap("MAP1");
    		break;
    	case MooveUp:
    		break;
    	case MooveDown:
    		break;
    	case MooveRight:
    		break;
    	case MooveLeft:
    		break;
    	case MooveRightUp:
    		break;
    	case MooveRightDown:
    		break;
    	case MooveLeftUp:
    		break;
    	case MooveLeftDown:
    		break;
    	case Shot:
    		break;
    	case Error:
    		break;
    	}
    }

	@Override
	public void control() {
		this.view.printMap("Press the key ‘A’, ‘Z’, ‘E’, ‘R’ or ‘T’ to choose a map. \nUse the keys Up, Down, Left or Right to move Lorann. \nUse the space key to make some crazy fireworks. \nEnjoy !");
	}

}
