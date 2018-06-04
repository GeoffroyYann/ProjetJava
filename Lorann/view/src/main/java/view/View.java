package view;

import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;

import controller.ControllerEnum;
import controller.IController;
import model.ILorann;
import model.IModel;
import showboard.BoardFrame;
import view.IView;

public class View implements IView, Runnable {

    private final BoardFrame boardFrame;
    
    public View(final IModel model, final IController controller, final ControllerEnum controllerEnum, final ILorann lorann) {
        
    	this.setModel(model);
        this.setLorann(lorann);
        this.keylistener = new KeyListernerUser(eventPerformer);
        this.getPseudo();
        this.getLorann().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, 0, this.getPseudo().getWidth(), this.getPseudo().getHeight));
        
        SwingUtilities.invokeLater(this);
    }

    public int getHeight() {
        return this.boardFrame.getHeight();
    }
    
    public int getWidth() {
        return this.boardFrame.getWidth();
    }
    
    protected static ControllerEnum keyController(final int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_A:
                return ControllerEnum.Map1;
            case KeyEvent.VK_Z:
                return ControllerEnum.Map2;
            case KeyEvent.VK_E:
                return ControllerEnum.Map3;
            case KeyEvent.VK_R:
                return ControllerEnum.Map4;
            case KeyEvent.VK_T:
                return ControllerEnum.Map5;
            case KeyEvent.VK_Y:
                return ControllerEnum.Map6;
            case KeyEvent.VK_U:
                return ControllerEnum.TEST;
            case KeyEvent.VK_M:
                return ControllerEnum.MENU;
            case KeyEvent.VK_W:
                return ControllerEnum.WORKSHOP;
            case KeyEvent.VK_UP:
                return ControllerEnum.MoveUp;
            case KeyEvent.VK_DOWN:
                return ControllerEnum.MoveDown;
            case KeyEvent.VK_RIGHT:
                return ControllerEnum.MoveRight;
            case KeyEvent.VK_LEFT:
                return ControllerEnum.MoveLeft;
            case KeyEvent.VK_SPACE:
                return ControllerEnum.Shot;
            default:
                return null;
        }
    }
    
    public void printMessage(final String message) {
        this.boardFrame.printMessage(message);
    }
    
    public String getPseudo() {
        return this.boardFrame.pseudo();
    }
    
    public void run() {
        this.boardFrame.setVisible(true);
    }
    
    public void repaint() {
        this.boardFrame.validate();
    }

    public void setController(final IController controller) {
        this.boardFrame.setController(controller);
    }

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printMap(String map) {
		// TODO Auto-generated method stub
		
	}
}
