package element.mobile;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;

/** The purse class.
 * 
 * @author Yann GEOFFROY
 *
 */
public class Purse extends Mobile {
    /** The sprite of a purse */
    private static Sprite purseSprite = new Sprite('M', "purse");
    /** the sprite of a collected sprite */
    private static Sprite collected = new Sprite('N', "empty");
    /** The point given by a purse */
    private static int points = 100;
    /** Purse constructor.
     * 
     * @param x
     * @param y
     * @param level
     * @throws IOException
     */
    public Purse (int x, int y, ILevel level) throws IOException {
        super(purseSprite, Permeability.COLLECTIBLE, level, x, y);
        collected.loadImage();
    }
    public void doNothing() {
        
    }
    
    /** Collects the purse and gives points */
    public int collect() {
        if(this.isAlive()) {
            this.die();
            return points;
        }
        return 0;
    }
    
    public void die() {
        super.die();
        this.setSprite(collected);
    }
}


