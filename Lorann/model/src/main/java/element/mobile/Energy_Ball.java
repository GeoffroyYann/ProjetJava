package element.mobile;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;

public class Energy_Ball extends Mobile {
    
    private static Sprite energy_ball= new Sprite('C', "energy_ball");
    private static Sprite collected = new Sprite('N', "empty");
    
    public Energy_Ball (int x, int y, ILevel level) throws IOException {
        super(energy_ball, Permeability.COLLECTIBLE, level, x, y);
        collected.loadImage();
    }
    public void doNothing() {
        
    }
    
    public int collect() {
        if(this.isAlive()) {
            this.die();
        }
        return 0;
    }
    
    public void die() {
        super.die();
        this.setSprite(collected);
    }
}


