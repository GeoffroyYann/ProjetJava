package element.mobile;

import element.Element;
import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;

import java.awt.*;

/** The abstract class Mobile.
 * 
 * @author Yann GEOFFROY
 *
 */
public abstract class Mobile extends Element implements IMobile{
    
	/** Position of the Mobile element.
	 * 
	 */
    private Point position;
    /** Defines if the mobile is alive or not */
    private boolean alive = true;
    /** The level in which the element stands */
    private ILevel level;
    /** last movement on X*/
    protected int lastX = 0;
    /** last movement on Y*/
    protected int lastY = 0;

    /** Instantiate a new Mobile Object 
     * 
     * @param sprite
     * @param permeability
     * @param level
     */
    public Mobile(Sprite sprite, Permeability permeability, ILevel level) {
        this(sprite, permeability, level, 0, 0);
    }

    /** Instantiate a new Mobile Object
     * 
     * @param sprite
     * @param permeability
     * @param level
     * @param x
     * @param y
     */
    public Mobile(Sprite sprite, Permeability permeability, ILevel level, int x, int y) {
        super(sprite, permeability);
        this.level = level;
        this.position = new Point();
        this.getPos().x = x;
        this.getPos().y = y;
    }

    @Override
    /** Move up on the level.
     * @return if the mobile has moved.
     */
    public boolean moveUp() {
        if(this.setY(this.getY() - 1)) {
            this.lastY = -1;
            this.lastX = 0;
            return true;
        }
        return false;
    }

    @Override
    /** Move left on the level.
     * @return if the mobile has moved.
     */
    public boolean moveLeft() {
        if(this.setX(this.getX() - 1)) {
            this.lastX = -1;
            this.lastY = 0;
            return true;
        }
        return false;
    }

    @Override
    /** Move down on the level.
     * @return if the mobile has moved.
     */
    public boolean moveDown() {
        if(this.setY(this.getY() + 1)) {
            this.lastY = 1;
            this.lastX = 0;
            return true;
        }
        return false;
    }

    @Override
    /** Move right on the level.
     * @return if the mobile has moved.
     */
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
    
    /** check if the element can move, and move if it can
     * 
     * @param x
     * @return boolean
     * if the element has moved or not
     */
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
    
    /** check if the element can move, and move if it can.
     * 
     * @param y
     * @return boolean
     * if the element has moved or not
     */
    public boolean setY(int y) {
        if (!this.isOnWall(this.getX(), y)) {
            this.getPos().y = y;
            return true;
        }
        return false;
    }
    
    /** Sets the X
     * 
     * @param x
     */
    public void initX(int x) {
        this.getPos().x = x;
    }
    
    /** Sets the Y
     * 
     * @param y
     */
    public void initY(int y) {
        this.getPos().y = y;
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    /** Check if there is a Wall at the next location.
     * 
     * @param newX
     * @param newY
     * @return
     */
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
    
    /** Kill the mobile element.
     * 
     */
    public void die() {
        this.alive = false;
        this.setHasMoved();
    }
    /** Gets the level */
    protected ILevel getLevel() {
        return this.level;
    }
    
    /** Generic behavior of the movement of a mobile.
     * 
     */
    public void move() {
    	
    }
    
    /** revive the mobile Element */
    public void revive() {
    	this.alive = true;
    }
    
    
    public boolean setPos(int x, int y) {
    	if(this.getLevel().getOnTheLevelXY(x, y).getPermeability() != Permeability.BLOCKING) {
    		this.getPos().x = x;
    		this.getPos().y = y;
    		return true;
    	}
    	return false;
    	}
    }
