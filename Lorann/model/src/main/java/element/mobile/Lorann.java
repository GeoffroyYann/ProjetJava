package element.mobile;

import java.awt.*;

import model.IElement;
import model.ILorann;
import view.IView;
import model.MobileOrder;
import modeldao.Element;

public class Lorann extends Mobile implements ILorann {
    
    public Lorann(Point pos){
        super("lorann.gif", true, pos);
    }
    
    public void move(MobileOrder order, IElement[][] tileMap, IView view){
        switch (order){
            case Left:
                if(this.direction == MobileOrder.Left && this.pos.y > 0 && tileMap[this.pos.x][this.pos.y - 1].getPermeability()){
                    this.pos.setLocation(this.pos.getX(), this.pos.getY() - 1);
                }
                break;
            case Right:
                if(this.direction == MobileOrder.Right && this.pos.y < view.getWidth() / 32 - 1 && tileMap[this.pos.x][this.pos.y + 1].getPermeability()){
                    this.pos.setLocation(this.pos.getX(), this.pos.getY() + 1);
                }
                break;
            case Up:
                if(this.direction == MobileOrder.Up && this.pos.x > 0 && tileMap[this.pos.x - 1][this.pos.y].getPermeability()){
                    this.pos.setLocation(this.pos.getX() - 1, this.pos.getY());
                }
                break;
            case Down:
                if(this.direction == MobileOrder.Down && this.pos.x < view.getHeight() / 32 - 1 && tileMap[this.pos.x + 1][this.pos.y].getPermeability()){
                    this.pos.setLocation(this.pos.getX() + 1, this.pos.getY());
                }
                break;
        }
        this.direction = order;
    }
}
