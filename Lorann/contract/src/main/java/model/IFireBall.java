package model;

import java.awt.Point;

public interface IFireBall {

	Point getPos();

	void setLocation(Point nextPos);

	int getStep();

	MobileOrder getDirection();

	void animate();

	void setDirection(MobileOrder direction);

}
