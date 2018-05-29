package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import controller.ControllerEnum;
import controller.IController;
import model.IModel;
import view.IView;

public class View implements IView, Runnable {

    private final ViewFrame viewFrame;
    
    public View(final IModel model) {
        this.viewFrame = new ViewFrame(model);
        SwingUtilities.invokeLater(this);
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
                return ControllerEnum.Error;
        }
    }
    
    public void printMap(final String map) {
        this.viewFrame.printMap(map);
    }
    
    public void run() {
        this.viewFrame.setVisible(true);
    }
    
    public void setController(final IController controller) {
        this.viewFrame.setController(controller);
    }

    @Override
    public void displayMessage(String message) {
        // TODO Auto-generated method stub
        
    }
}
