package controller;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import controller.ControllerEnum;
import model.IMobile;
import model.IModel;
import model.IMonster;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, ControllerEnum {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    /** The keyEvent. */
    private KeyEvent stackOrder;
    
    /** The speed of the game. */
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
        
        while(this.getModel().getLorann().isAlive()){
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
                    this.getModel().getLorann().shot();
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
    
    /**Store orders.
     * @param userOrder
     * the order
     */
    public void performOrder(KeyEvent userOrder) {
        this.setStackOrder(userOrder);
    }
    
    /**
     * Gets the order.
     *
     * @return the order
     */
    public KeyEvent getStackOrder() {
        return stackOrder;
    }
    /**
     * Set the order.
     * @param stackOrder
     *            the order
     */
    public void setStackOrder(KeyEvent stackOrder) {
        this.stackOrder = stackOrder;
    }
    
    /**
     * Get OrderPerformer
     * 
     * @return the order performer
     */
    public ControllerEnum getOrderPerformer() {
        return this;
    }



}
