package model;


import java.awt.*;

public interface IMonster extends IMobile {
    
    MobileOrder getDirection(Point lorannPos, IElement[][] tileMap);


}
