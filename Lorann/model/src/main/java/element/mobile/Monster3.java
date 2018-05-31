package element.mobile;

import java.awt.Point;

import model.IElement;
import model.IMonster;
import model.MobileOrder;

public class Monster3 extends Mobile implements IMonster{
	
	public Monster3(Point pos) {
		super("monster_3.png", true, pos);
	}
	
	public MobileOrder getDirection(Point lorannpos, IElement[][] tileMap) {
		return MobileOrder.random();
	}    
}
