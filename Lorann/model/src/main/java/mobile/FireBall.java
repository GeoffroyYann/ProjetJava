package mobile;

import contract.IFireball;
import contract.MobileOrder;
import model.Element;

import java.awt.*;

public class FireBall extends Mobile {
    
    public FireBall(Point pos) {
        super("fireball_1.png", true, pos);
    }
    
    public void setDirection(MobileOrder direction) {
        this.direction = direction;
    }
}
