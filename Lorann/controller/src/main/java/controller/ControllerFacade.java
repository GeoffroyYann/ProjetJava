package controller;

import java.awt.Point;
import java.sql.SQLException;
import java.util.List;
import model.Example;
import model.IElement;
import model.IModel;
import model.MobileOrder;
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
        //super (); Don't know what to do with this...
    	//view = new IView(); can't instantiate ?
    	//model = new IModel(); can't instantiate ?
    	
    	this.view = view; // seems like this one is working
        this.model = model; // seems like this one is working
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

	public void control() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orderPerform(ControllerEnum controllerOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IElement[][] getTileMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point computeNextPos(MobileOrder direction, Point currentPos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IElement[][] parser(String tilemap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getScores() {
		// TODO Auto-generated method stub
		return null;
	}

}
