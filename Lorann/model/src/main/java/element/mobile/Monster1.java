package element.mobile;

import java.awt.Point;

import model.IElement;
import model.IMonster;
import model.MobileOrder;

public class Monster1 extends Mobile implements IMonster{
	
	public Monster1(Point pos) {
		super("monster_1.png", true, pos);
	}
	
	public MobileOrder getDirection(Point lorannpos, IElement[][] tileMap) {
		Point pos = this.getPos().getLocation();
		MobileOrder direction = MobileOrder.random();
		int distance = 10000;
		for (MobileOrder dir : MobileOrder.values()) {
			Point aroundPos = MobileOrder.getPos(pos, dir);
			if (tileMap[aroundPos.x][aroundPos.y].getPermeability()) {
				int aroundDist = (lorannpos.x-aroundPos.x)*(lorannpos.x-aroundPos.x) + (lorannpos.y-aroundPos.y)*(lorannpos.y-aroundPos.y);
				if(aroundDist < distance) {
					distance = aroundDist;
					direction = dir;
				}
			}
		}
		return direction;		
	}
}
