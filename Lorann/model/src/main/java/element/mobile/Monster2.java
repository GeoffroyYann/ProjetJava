package element.mobile;

import java.awt.Point;

import model.IElement;
import model.ILevel;
import model.IMonster;
import model.MobileOrder;
import model.Sprite;

public class Monster2 extends Monster{
    
    private static Sprite sprite = new Sprite('J', "monster_2");
    
    public boolean goingRight = true;
    
    public Monster2(ILevel level, int x, int y) {
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
