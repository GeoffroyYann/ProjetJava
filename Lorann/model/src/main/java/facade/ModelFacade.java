package facade;

import java.awt.Point;
import java.sql.*;
import java.util.*;

import model.IElement;
import model.IModel;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public final class ModelFacade implements IModel {

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

	@SuppressWarnings("deprecation")
	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadMap(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IElement element(char c, Point pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getHighScore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upNameAndScore(int score, String nickname) {
		// TODO Auto-generated method stub
		
	}
}
