package element.mobile;

import java.io.IOException;

import model.ILevel;
import model.IMonster;
import model.Permeability;
import model.Sprite;

/** The monster abstract class.
 * 
 * @author Yann GEOFFROY
 *
 */
public abstract class Monster extends Mobile implements IMonster{
    /** the sprite of the dead monster*/
    private static Sprite deadSprite = new Sprite('M', "floor");
    
    /** Instantiate a new Monster
     * 
     * @param sprite
     * @param level
     * @param x
     * @param y
     */
    public Monster(Sprite sprite, ILevel level, int x, int y) {
        super(sprite, Permeability.MONSTER, level, x, y);
        try {
            deadSprite.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** Generic behavior for the monster's movement */
    public abstract void move();
    
    public int collect() {
        this.die();
		return 0;
    }
    /** The monster DIIIIIE */
    public void die() {
    	super.die();
    	this.setSprite(deadSprite);
    }
}
