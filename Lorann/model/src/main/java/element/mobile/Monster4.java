package element.mobile;

import java.awt.Point;

import model.IElement;
import model.IMonster;
import model.MobileOrder;

public class Monster4 extends Mobile implements IMonster{
	
	public Monster4(Point pos) {
		super("monster_4.png", true, pos);
	}
	
	public MobileOrder getDirection(Point lorannpos, IElement[][] tileMap) {
		return null;
	}

}
