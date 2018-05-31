package model;

import java.awt.Point;

import view.IView;

public interface ILorann {

	Point getPos();

	void move(MobileOrder order, IElement[][] tileMap, IView view);

	MobileOrder getDirection();

}
