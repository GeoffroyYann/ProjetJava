package element.mobile;

import model.ILevel;
import model.Sprite;

public class Monster_1 extends Monster{
    
    private static Sprite sprite = new Sprite('I', "monster_1");
    
    public boolean goingUp = true;
    
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
