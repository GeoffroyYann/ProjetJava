package element.mobile;

import element.Element;
import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;

import java.awt.*;


public abstract class Mobile extends Element implements IMobile{
    
    private Point position;
    private boolean alive = true;
    private ILevel level;
    
    protected int lastX = 0;
    protected int lastY = 0;

    public Mobile(Sprite sprite, Permeability permeability, ILevel level) {
        this(sprite, permeability, level, 0, 0);
    }

    public Mobile(Sprite sprite, Permeability permeability, ILevel level, int x, int y) {
        super(sprite, permeability);
        this.level = level;
        this.position = new Point();
        this.getPos().x = x;
        this.getPos().y = y;
    }

    @Override
    public boolean moveUp() {
        if(this.setY(this.getY() - 1)) {
            this.lastY = -1;
            this.lastX = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean moveLeft() {
        if(this.setX(this.getX() - 1)) {
            this.lastX = -1;
            this.lastY = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean moveDown() {
        if(this.setY(this.getY() + 1)) {
            this.lastY = 1;
            this.lastX = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean moveRight() {
        if(this.setX(this.getX() + 1)) {
            this.lastX = 1;
            this.lastY = 0;
            return true;
        }
        return false;
    }
    
    public void setHasMoved() {
        this.level.setElementHasChanged();
    }

    @Override
    public int getX() {
        return this.getPos().x;
    }
    
    public boolean setX(int x) {
        if (!this.isOnWall(x, this.getY())) {
            this.getPos().x = x;
            return true;
        }
        return false;
    }

    @Override
    public int getY() {
        return this.getPos().y;
    }
    
    public boolean setY(int y) {
        if (!this.isOnWall(this.getX(), y)) {
            this.getPos().y = y;
            return true;
        }
        return false;
    }
    
    public void initX(int x) {
        this.getPos().x = x;
    }
    
    public void initY(int y) {
        this.getPos().y = y;
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    public boolean isOnWall(int newX, int newY) {
        return (this.getLevel().getOnTheLevelXY(newX, newY).getPermeability() == Permeability.BLOCKING);
    }
    
    @Override
    public boolean isHit(int newX, int newY) {
        return (this.getLevel().getOnTheLevelXY(newX, newY).getPermeability() == Permeability.MONSTER);
    }

    @Override
    public Point getPos() {
        return this.position;
    }

    public void shot() {
        
    }
    
    public void die() {
        this.alive = false;
        this.setHasMoved();
    }
    
    protected ILevel getLevel() {
        return this.level;
    }
    
    public void move() {
    	
    }
}
