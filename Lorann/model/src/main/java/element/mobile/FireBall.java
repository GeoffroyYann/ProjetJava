package element.mobile;

import java.awt.Point;
import model.IFireBall;
import model.MobileOrder;


public class FireBall extends Mobile implements IFireBall {
    
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

	@Override
	public void move(MobileOrder order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MobileOrder getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

}
