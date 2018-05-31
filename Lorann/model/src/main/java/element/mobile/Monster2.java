package element.mobile;

import java.awt.Point;

import model.IElement;
import model.IMonster;
import model.MobileOrder;

public class Monster2 extends Mobile implements IMonster{
	
	public Monster2(Point pos) {
		super("monster_2.png", true, pos);
	}
	
	public MobileOrder getDirection(Point lorannpos, IElement[][] tileMap) {
		MobileOrder direction = MobileOrder.random();
		return direction;
	}    
}
