package controller;

import java.awt.Point;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.parser.Element;

import model.Example;
import model.IElement;
import model.IFireBall;
import model.ILorann;
import model.IModel;
import model.IMonster;
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
    IElement tileMap;
    ILorann lorann;
    String pseudo;
    int level;
    int score;
    String[][] scores;
    Point posGate;
    HashMap<String, IMonster> monsters;
    IFireBall fireBall;
    boolean dead;
    boolean parser;
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model 
     */
    public ControllerFacade(final IView view, final IModel model, IElement tileMap) {
        super ();
    	this.view = view; 
        this.model = model;
        this.tileMap = tileMap;
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
