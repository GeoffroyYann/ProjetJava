package element.mobile;

import model.ILevel;
import model.Sprite;

/** the monster_2 class
 * 
 * @author Yann GEOFFROY
 *
 */
public class Monster_2 extends Monster{
    
	/** Sprite of the monster */
    private static Sprite sprite = new Sprite('J', "monster_2");
    /** Boolean that indicate if the monster goes right or left. */
    public boolean goingRight = true;
    /**
     * constructor of Monster_2
     * @param level
     * @param x
     * @param y
     */
    public Monster_2(ILevel level, int x, int y) {
        super(sprite, level, x, y);
    }
    
    @Override
    public void doNothing() {
        
    }
    
    @Override
    public void move() {
        if(this.goingRight) {
            if(!this.moveRight()) {
                this.moveLeft();
                goingRight = false;
            }
        }
        else {
            if(!this.moveLeft()) {
                this.moveRight();
                goingRight = true;
            }
        }
    }
}
