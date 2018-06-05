package element.mobile;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;

public class Purse extends Mobile {
    
    private static Sprite purseSprite = new Sprite('M', "purse");
    private static Sprite collected = new Sprite('N', "empty");
    
    private static int points = 100;
    public Purse (int x, int y, ILevel level) throws IOException {
        super(purseSprite, Permeability.COLLECTIBLE, level, x, y);
        collected.loadImage();
    }
    public void doNothing() {
        
    }
    
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


