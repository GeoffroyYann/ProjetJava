package element.mobile;

import java.io.IOException;

import model.ILevel;
import model.IMonster;
import model.Permeability;
import model.Sprite;

public abstract class Monster extends Mobile implements IMonster{
    
    private static Sprite deadSprite = new Sprite('M', "floor");
    
    public Monster(Sprite sprite, ILevel level, int x, int y) {
        super(sprite, Permeability.MONSTER, level, x, y);
        try {
            deadSprite.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public abstract void move();
    
    public int collect() {
        this.die();
		return 0;
    }
    
    public void die() {
    	super.die();
    	this.setSprite(deadSprite);
    }
}
