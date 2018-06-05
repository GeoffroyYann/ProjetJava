package element.mobile;

import java.util.Random;

import model.ILevel;
import model.Sprite;

public class Monster_4 extends Monster{
    
    private static Sprite sprite = new Sprite('L', "monster_4");
    
    public Monster_4(ILevel level, int x, int y) {
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
