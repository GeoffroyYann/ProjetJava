package element.mobile;

import java.awt.Point;

import contract.IFireball;
import contract.MobileOrder;
import modeldao.Element;

public class FireBall extends Mobile implements IFireball {
    
    private int step = 1;
    
    public FireBall(Point pos){
        super("fireball.gif", true, pos);
    }
    
    public int getStep(){ 
        return step;
    }
    
    public void setDirection(MobileOrder direction){
        this.direction = direction;
    }

}
