package model;

public interface IFireBall extends IMobile {
    
    void setDirection(MobileOrder direction);
    
    int getStep();
    
    void animate();

}
