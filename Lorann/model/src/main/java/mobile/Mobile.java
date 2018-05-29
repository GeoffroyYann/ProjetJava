package mobile;

import contract.IMobile;
import contract.IModel;
import contract.MobileOrder;
/*import model.Element;*/

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Mobile extends Elements {
    
    public Point getPod(){
        return pos.getLocation();
    }
    
    protected Point pos = new Point();
    
    protected MobileOrder direction = MobileOrder.Down;
    
    public void setLocation(Point loc) {
        this.pos.setLocation(loc);
    }
    
    public Mobile(String /*lien ver image*/, boolean /*traversable*/, Point pos) {
        super(/*lien ver image*/, /*traversable*/);
        this.pos.setLocation(pos);
    }
    
    public MobileOrder getDirection() {
        return direction;
    }
    
    public void move(MobileOrder order)
    {
        switch (order) {
            case MoveLeft:
                this.pos.setLocation(
                        this.pos.getX() - 1,
                        this.pos.getY()
                        );
                break;
            case MoveRight:
                this.pos.setLocation(
                        this.pos.getX() + 1,
                        this.pos.getY()
                        );
                break;
            case MoveUp:
                this.pos.setLocation(
                        this.pos.getX(),
                        this.pos.getY() + 1
                        );
                break;
            case MoveDown:
                this.pos.setLocation(
                        this.pos.getX(),
                        this.pos.getY() - 1
                        );
                break;
            case MoveUpRight:
                this.pos.setLocation(
                        this.pos.getX() + 1,
                        this.pos.getY() + 1
                        );
                break;
            case MoveUpLeft:
                this.pos.setLocation(
                        this.pos.getX() + 1,
                        this.pos.getY() - 1
                        );
                break;
            case MoveDownRight:
                this.pos.setLocation(
                        this.pos.getX() - 1,
                        this.pos.getY() + 1
                        );
                break;
            case MoveDownLeft:
                this.pos.setLocation(
                        this.pos.getX() - 1,
                        this.pos.getY() - 1
                        );
                break;
        }
        this.direction = order;
        System.out.println("POS : " + pos);
    }

}
