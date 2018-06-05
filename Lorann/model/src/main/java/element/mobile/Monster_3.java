package element.mobile;

import java.util.Random;

import model.ILevel;
import model.Sprite;

/** The monster_3 class
 * 
 * @author Yann GEOFFROY
 *
 */
public class Monster_3 extends Monster{
	/** Sprite of the monster */
    private static Sprite sprite = new Sprite('K', "monster_3");
    /** 
     * Monster_3 constructor
     * @param level
     * @param x
     * @param y
     */
    public Monster_3(ILevel level, int x, int y) {
        super(sprite, level, x, y);
    }
    
    @Override
    public void doNothing() {
        
    }
    
    @Override
    public void move() {
        Random random = new Random();
        
        boolean hasMoved = false;
        
        while(!hasMoved) {
            switch(random.nextInt(4) + 1) {
            case 1:
                hasMoved = moveUp();
                break;
            case 2:
                hasMoved = moveDown();
                break;
            case 3:
                hasMoved = moveLeft();
                break;
            case 4:
                hasMoved = moveRight();
                break;
            }
        }
    }
}
