package element.mobile;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;

/** The Energy_Ball Class
 * 
 * @author Yann GEOFFROY
 *
 */

public class Energy_Ball extends Mobile {
    
	/** Sprite of the ball
	 * 
	 */
    private static Sprite energy_ball= new Sprite('C', "energy_ball");
    /** Sprite of the floor
     * 
     */
    private static Sprite collected = new Sprite('N', "empty");
    /** Instantiates a new Energy_Ball
     * 
     * @param x
     * @param y
     * @param level
     * the level in which the key is.
     * @throws IOException
     * if the image doesn't exist.
     */
    public Energy_Ball (int x, int y, ILevel level) throws IOException {
        super(energy_ball, Permeability.COLLECTIBLE, level, x, y);
        collected.loadImage();
    }
    public void doNothing() {
        
    }
    
    public int collect() {
        if(this.isAlive()) {
            this.die();
        }
        return 0;
    }
    
    public void die() {
        super.die();
        this.setSprite(collected);
    }
}


