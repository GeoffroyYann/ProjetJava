package controller;

import static org.junit.Assert.*;

import java.awt.Button;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import controller.ControllerFacade;
import model.IMobile;
import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerTest tests the methods of the Controller component.</h1>
 *
 * @author Charlotte Bénard
 * @version 1.0
 */
public class ControllerTest {
    
    /** The controller */
    private ControllerFacade controller;
    
    /** Instantiates a new view mock */
    private IView view = new ViewMock();
    
    /** Instantiates a new model mock */
    private IModel model = new ModelMock();
    
    /** Instantiates a new character */
    private IMobile myCharacter = new MobileMock(10, 10);

    
    /**
     * Instantiates a new controller facade
     * @throws Exception
     *      if the instantiation fails
     */
    @Before
    public void setUp() throws Exception {
        this.controller = new ControllerFacade (view, model);
    }

    /** Tests the getView method */
    @Test
    public void testGetView() {
        assertEquals(this.view, this.controller.getView());
    }
    
    /** Tests the getModel method */
    @Test
    public void testGetModel() {
        assertEquals(this.model, this.controller.getModel());

    }
    
    /** Tests the performOrder method */
    @Test
    public void testPerformOrder() {
        KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
        this.controller.performOrder(keyEvent);
        assertEquals(keyEvent, controller.getStackOrder());
    }
    
    /** Tests the getOrderPerformer method */
    @Test
    public void testGetOrderPerformer() {
        assertEquals(this.controller, this.controller.getOrderPerformer());
    }
    
    /** Tests the getStackOrder method */
    @Test
    public void testGetStackOrder() {
        KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
        this.controller.setStackOrder(keyEvent);
        assertEquals(keyEvent, this.controller.getStackOrder());
    }
    
    /** Tests the setStackOrder method */
    @Test
    public void testSetStackOrder() {
        KeyEvent keyEvent = new KeyEvent(new Button(), 0, 0, 0, KeyEvent.VK_RIGHT);
        this.controller.setStackOrder(keyEvent);
        assertEquals(keyEvent, this.controller.getStackOrder());
    }
    

}