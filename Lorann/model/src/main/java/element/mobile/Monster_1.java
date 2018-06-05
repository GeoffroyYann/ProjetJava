package element.mobile;

import model.ILevel;
import model.Sprite;

/** The monster_1 class
 * 
 * @author Yann GEOFFROY
 *
 */
public class Monster_1 extends Monster{
    
	/** Sprite of the monster */
    private static Sprite sprite = new Sprite('I', "monster_1");
    /** Boolean value that indicate if the monster has to go up or down */
    public boolean goingUp = true;
    /**
     * Monster constructor
     * @param level
     * @param x
     * @param y
     */
    public Monster_1(ILevel level, int x, int y) {
        super(sprite, level, x, y);
    }
    
    @Override
    public void doNothing() {
        
    }
    
    @Override
    public void move() {
        if(this.goingUp) {
            if(!this.moveUp()) {
                this.moveDown();
                goingUp = false;
            }
        }
        else {
            if(!this.moveDown()) {
                this.moveUp();
                goingUp = true;
            }
        }
    }
}
