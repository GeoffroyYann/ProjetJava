package controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.parser.Element;
import controller.ControllerEnum;
import model.Example;
import model.IElement;
import model.IMobile;
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
    
    private static int speed = 100;
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model 
     */
    public ControllerFacade(final IView view, final IModel model) {
        super ();
    	this.view = view; 
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException, InterruptedException, IOException {
        
        while(this.getModel().getLorann().isAlive)){
            Thread.sleep(speed);
            
            for(IMobile monster : this.getModel().getMonsters()) {
                ((IMonster)monster).move();
            }
            
            if(this.getStackOrder() != null) {
                switch(this.getStackOrder().getKeyCode()) {
                case KeyEvent.VK_UP:
                    this.getModel().getLorann().moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    this.getModel().getLorann().moveDown();
                    break;
                case KeyEvent.VK_RIGHT:
                    this.getModel().getLorann().moveRight();
                    break;
                case KeyEvent.VK_LEFT:
                    this.getModel().getLorann().moveLeft();
                    break;
                case KeyEvent.VK_SPACE:
                    this.getModel().getLorann().shot(1);
                    break;
                default:
                    this.getModel().getLorann().doNothing();
                    break;    
                }
                this.stackOrder = null;
            }
            else {
                this.getModel().getLorann().doNothing();
            }
        }
        if(this.getModel().hasLorannWon()) {
            this.getView().displayMessage("YEEEEEEEES");
            System.exit(1);
            }
        else
            this.getView().displayMessage("ARGH");
        System.exit(1);
        }
        /*this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());*/
    

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
    
    public void performOrder(KeyEvent userOrder) {
        this.setStackOrder(userOrder);
    }
    
    public KeyEvent getStackOrder() {
        return stackOrder;
    }
    
    public void setStackOrder(KeyEvent stackOrder) {
        this.stackOrder = stackOrder;
    }
    
    public ControllerEnum getControllerEnum() {
        return this;
    }

}
