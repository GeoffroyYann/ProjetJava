package view;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.IOrderPerformer;
import model.ILevel;
import model.IMobile;
import view.ViewFacade;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Corentin Hangard
 * @version 1.0
 */
public class ViewFacadeTest {
    
    /** The Level. */
    private ILevel level;
    
    /** The character. */
    private IMobile myCharacter;
    
    /** The purses. */
    private IMobile[] purses;
    
    /** The monsters. */
    private IMobile[] monsters;
    
    /** The energy ball. */
    private IMobile energyBall;
    
    /** The door. */
    private IMobile door;
    
    /** The spell. */
    private IMobile spell;
    
    /** The view. */
    private ViewFacade view;
    
    /** The Constant fullView. */
    private Rectangle fullView;
    
    /*
     * Set up the test.
     * 
     */
    @Before
    public void setUp() throws Exception {
        level = new LevelMock();
        myCharacter = new MyCharacterMock();
        purses = new IMobile[1];
        monsters = new IMobile[4];
        energyBall = new EnergyBallMock();
        door = new DoorMock();
        spell = new SpellMock();
        
        fullView = new Rectangle(0, 0, level.getWidth(), level.getHeight());
        
        view = new ViewFacade(level, myCharacter, purses, monsters, energyBall, door, spell);
    }

    /*
     * 
     * 
     */
    @After
    public void tearDown() throws Exception {
    }

    /*
     * Test to get the level.
     * 
     */
    @Test
    public void testGetLevel() {
        assertEquals(this.level, this.view.getLevel());
    }

    /*
     * Test to set the level.
     * 
     */
    @Test
    public void testSetLevel() throws IOException {
        final ILevel expected = new LevelMock();
        this.view.setLevel(expected);
        assertEquals(expected, this.view.getLevel());
    }

    /*
     * Test to get the character.
     * 
     */
    @Test
    public void testGetMyCharacter() {
        assertEquals(this.myCharacter, this.view.getMyCharacter());
    }

    /*
     * Test to set the character.
     * 
     */
    @Test
    public void testSetMyCharacter() {
        final IMobile expected = new MyCharacterMock();
        this.view.setMyCharacter(expected);
        assertEquals(expected, this.view.getMyCharacter());
    }
    
    /*
     * Test to set the orderPerformer.
     * 
     */
    @Test
    public void testSetOrderPerformer() {
        IOrderPerformer orderPerformer = new ControllerFacadeMock();
        this.view.setOrderPerformer(orderPerformer);
        assertEquals(orderPerformer, this.view.getOrderPerformer());
    }

    /*
     * Test to get the fullView.
     * 
     */
    @Test
    public void testGetFullView() {
        assertEquals(this.fullView, this.view.getFullView());
    }

    /*
     * Test to set the fullView.
     * 
     */
    @Test
    public void testSetFullView() {
        final Rectangle expected = new Rectangle(0, 0, level.getWidth(), level.getHeight());
        this.view.setFullView(expected);
        assertEquals(expected, this.view.getFullView());
    }

}