package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.ControllerEnum;
import controller.IController;
import model.ILevel;
import model.IMobile;
import showboard.BoardFrame;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, KeyListener, Runnable {
	
	/** The Level. */
	private ILevel level;
	/** Lorann. */
	private IMobile lorann;
	/** The controller performer */
	private ControllerEnum controllerEnum;
	/** The constant squareSize */
	private static final int squareSize = 64;
	/** The constant fullView. */
	private Rectangle fullView;
	/** The purses */
	private IMobile[] purses;
	/** The monsters */
	private IMobile[] monsters;
	/** The key */
	private IMobile energy_Ball;
	/** The gate */
	private IMobile gate;
	/** The fireBall */
	private IMobile fireBall;

    /** Instantiate a new ViewFacade
     * 
     * @param level
     * @param Lorann
     * @param purses
     * @param monsters
     * @param energy_Ball
     * @param gate
     * @param fireBall
     */
    public ViewFacade(ILevel level, IMobile Lorann, IMobile[]purses, IMobile[]monsters, IMobile energy_Ball, IMobile gate, IMobile fireBall) {
        try {
        	this.setLevel(level);
        } catch (IOException e1) {
        	e1.printStackTrace();
        }
        this.setLorann(lorann);
        try {
        	this.getLorann().getSprite().loadImage();
        } catch (IOException e1) {
        	this.setFullView(new Rectangle(0,0, this.getLevel().getWidth(), this.getLevel().getHeight()));
        	SwingUtilities.invokeLater(this);
        	
        	this.purses = purses;
        	this.monsters = monsters;
        	this.energy_Ball = energy_Ball;
        	this.gate = gate;
        	this.fireBall = fireBall;
        }
        
    }
    
    /** The game loop
     * 
     */
    public void run() {
    	BoardFrame boardFrame = new BoardFrame("Lorann", false);
    	boardFrame.setDimension(new Dimension(this.getLevel().getWidth(), this.getLevel().getHeight()));
    	boardFrame.setDisplayFrame(this.fullView);
    	boardFrame.setSize(this.fullView.width * squareSize - 32, this.fullView.height * squareSize);
    	boardFrame.setHeightLooped(false);
    	boardFrame.addKeyListener(this);
    	boardFrame.setFocusable(true);
    	
    	for (int x = 0; x < this.getLevel().getWidth(); x++) {
    		for (int y = 0; y < this.getLevel().getHeight(); y++) {
    			boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
    		}
    	}
    	for (IMobile purse : purses) {
    		try {
    			purse.getSprite().loadImage();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		boardFrame.addPawn(purse);
    	}
    	for(IMobile monster : monsters) {
    		try {
    			monster.getSprite().loadImage();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		boardFrame.addPawn(monster);
    	}
    	
    	try {
    		this.energy_Ball.getSprite().loadImage();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	try {
    		this.gate.getSprite().loadImage();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	try {
    		this.fireBall.getSprite().loadImage();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	boardFrame.addPawn(this.energy_Ball);
        boardFrame.addPawn(this.gate);
        boardFrame.addPawn(this.lorann);
        boardFrame.addPawn(this.fireBall);

    }
    
    public void keyPressed(KeyEvent keyEvent) {
    	this.getControllerEnum().performOrder(keyEvent);
    }
    /** Gets the level */
    public ILevel getLevel() {
    	return this.level;
    }
    /** Sets the level */
    public void setLevel(ILevel level) throws IOException {
    	this.level = level;
    	int y = 0;
    	int x = 0;
    	for (y = 0; y < this.getLevel().getHeight(); y++) {
    		for (x = 0; x < this.getLevel().getWidth(); x++) {
    			this.getLevel().getOnTheLevelXY(x, y).getSprite().loadImage();
    		}
    	}
    }
    /** Gets Lorann */
    public IMobile getLorann() {
    	return this.lorann;
    }
    /** Sets Lorann */
    public void setLorann(IMobile lorann) {
    	this.lorann = lorann;
    }
    
    /** Gets the Controller Enum*/
    public ControllerEnum getControllerEnum() {
    	return this.controllerEnum;
    }
    /** Sets the ControllerEnum */
    public void setControllerEnum(ControllerEnum orderPerformer) {
    	this.controllerEnum = orderPerformer;
    }
    /** Gets the fullView of a Rectangle */
    public Rectangle getFullView() {
    	return this.fullView = fullView;
    }
    /** Sets the fullView of a rectangle */
    public void setFullView(Rectangle fullView) {
    	this.fullView = fullView;
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		
	}

}
