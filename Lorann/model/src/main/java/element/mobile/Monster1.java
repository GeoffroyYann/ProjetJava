package element.mobile;

import java.awt.Point;

import model.IElement;
import model.ILevel;
import model.IMonster;
import model.MobileOrder;
import model.Sprite;

public class Monster1 extends Monster{
    
    private static Sprite sprite = new Sprite('I', "monster_1");
    
    public boolean goingUp = true;
    
    public Monster1(ILevel level, int x, int y) {
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
