package element.mobile;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;

public class Gate extends Mobile {
    
    private static Sprite closed = new Sprite('D', "gate_closed");
    private static Sprite opened = new Sprite('E', "gate_open");
    public Gate(int x, int y, ILevel level) throws IOException {
        super(closed, Permeability.COLLECTIBLE, level, x, y);
        opened.loadImage();
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
        this.setSprite(opened);
    }
}
