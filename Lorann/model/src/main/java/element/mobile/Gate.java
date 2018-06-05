package element.mobile;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;

/** The Gate class.
 * 
 * @author Yann GEOFFROY
 *
 */
public class Gate extends Mobile {
    
	/** Sprite of the gate when it's closed*/
    private static Sprite closed = new Sprite('D', "gate_closed");
    /** Sprite of the opened gate */
    private static Sprite opened = new Sprite('E', "gate_open");
    /**
     * Instantiate a new Gate.
     * @param x
     * @param y
     * @param level
     * The level in which the gate is.
     * @throws IOException
     * If an image doesn't exist.
     */
    public Gate(int x, int y, ILevel level) throws IOException {
        super(closed, Permeability.COLLECTIBLE, level, x, y);
        opened.loadImage();
    }
    public void doNothing() {
        
    }
    
    /** Opens the gate */
    public int collect() {
        if(this.isAlive()) {
            this.die();
        }
        return 0;
    }
    
    public void die() {
        super.die();
        this.setSprite(opened);
    }
}
