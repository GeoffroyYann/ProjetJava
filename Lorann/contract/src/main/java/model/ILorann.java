package model;

import view.IView;

public interface ILorann extends IMobile {
    
    void move(MobileOrder order, IElement[][] tileMap, IView view);

}
