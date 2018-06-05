package element.mobile;

import java.io.IOException;
import java.util.ArrayList;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;

/** The Lorann Class
 * 
 * @author Yann GEOFFROY
 *
 */
public class Lorann extends Mobile {
    
	/** Bottom Sprite*/
    private static Sprite lorann_d = new Sprite(' ', "lorann_d");
    /** Bottom left Sprite*/
    private static Sprite lorann_d_l = new Sprite(' ', "lorann_d_l");
    /** Bottom right Sprite*/
    private static Sprite lorann_d_r = new Sprite(' ', "lorann_d_r");
    /** Left Sprite*/
    private static Sprite lorann_l = new Sprite(' ', "lorann_l");
    /** Left Up Sprite*/
    private static Sprite lorann_l_u = new Sprite(' ', "lorann_l_u");
    /** Right Sprite*/
    private static Sprite lorann_r = new Sprite(' ', "lorann_r");
    /** Right Up Sprite*/
    private static Sprite lorann_r_u = new Sprite(' ', "lorann_r_u");
    /** Up Sprite*/
    private static Sprite lorann_u = new Sprite(' ', "lorann_u");
    
    /** List of all purses. */
    private ArrayList<IMobile> purses;
    /** List of all monsters. */
    private ArrayList<IMobile> monsters;
    /** The key     */
    private IMobile energy_Ball;
    /** The gate */
    private IMobile gate;
    /** The FireBall */
    private IMobile fireBall;
    /** The score */
    private int score = 0;
    /** Indicate if Lorann has the key */
    private boolean hasTheKey = false;
    /** Indicate if Lorann has escaped */
    private boolean won = false;
    /** Array of all sprites */
    private static Sprite[] sprites;
   
    /** Instantiate a Lorann object
     * 
     * @param x
     * @param y
     * @param level
     * The level in which the player is.
     * @throws IOException
     * If an image doesn't exist.
     */
    public Lorann(int x, int y, ILevel level) throws IOException {
    	super(lorann_r, Permeability.BLOCKING, level);
    	sprites = new Sprite[8];
    	lorann_d.loadImage();
    	lorann_d_l.loadImage();
    	lorann_d_r.loadImage();
    	lorann_l.loadImage();
    	lorann_l_u.loadImage();
    	lorann_r.loadImage();
    	lorann_r_u.loadImage();
    	lorann_u.loadImage();
    	
    	sprites[0] = lorann_d;
    	sprites[1] = lorann_d_l;
    	sprites[2] = lorann_l;
    	sprites[3] = lorann_l_u;
    	sprites[4] = lorann_u;
    	sprites[5] = lorann_r_u;
    	sprites[6] = lorann_r;
    	sprites[7] = lorann_d_r;
    	
    	this.initX(x);
    	this.initY(y);
    	
    	this.purses = new ArrayList<>();
    	this.monsters = new ArrayList<>();
    }
    
    public boolean moveLeft() {
    	super.moveLeft();
    	check(this.getX(),this.getY());
    	return true;
    }
    
    public boolean moveRight() {
    	super.moveRight();
    	check(this.getX(),this.getY());
    	return true;
    }
    
    public boolean moveUp() {
    	super.moveLeft();
    	check(this.getX(),this.getY());
    	return true;
    }
    
    public boolean moveDown() {
    	super.moveLeft();
    	check(this.getX(),this.getY());
    	return true;
    }
    /** Check what happens when Lorann hits something.
     * 
     * @param x
     * @param y
     */
    public void check(int x, int y) {
    	if(isHit(this.getX(), this.getY()))
    		this.die();
    	else if(this.isOnKey(x, this.getY())) {
    		energy_Ball.collect();
    		hasTheKey = true;
    		gate.collect();
    	}
    	else if(this.isOnGate(x, this.getY())) {
    		if(hasTheKey) {
    			this.won = true;
    			this.die();
    		}
    	}
    	else if(this.isOnPurse(x, this.getY())) {}
    	else if(this.isOnFireBall(x, this.getY())) {
    		this.fireBall.collect();
    	}
    }
        public void shot() {
        	if(!fireBall.isAlive()) {
        		int direction = lastY != 0 ? (lastY == -1 ? 2 : 1) : (lastX == -1 ? 3 : 4);
        		((FireBall)this.fireBall).spawn(this.getX() - lastX, this.getY() - lastY, direction);
        	}
        }

        /** Check if the player is on the FireBall
         * 
         * @param newX
         * @param newY
         * @return
         */
	private boolean isOnFireBall(int newX, int newY) {
			if(fireBall.getX() == newX && fireBall.getY() == newY) 
				return true;
		return false;
		}
	
		/** Check if the player is on a purse
		 * 
		 * @param newX
		 * @param newY
		 * @return
		 * If the player is on a purse
		 */
	private boolean isOnPurse(int newX, int newY) {
		for(IMobile purse : purses) {
			if(purse.getX() == newX && purse.getY() == newY) {
				purse.collect();
				return true;
			}
		}
		return false;
	}

	/** Check if the player is on the key
	 * 
	 * @param newX
	 * @param newY
	 * @return
	 * If the player is on the key
	 */
	private boolean isOnKey(int newX, int newY) {
			if(energy_Ball.getX() == newX && energy_Ball.getY() == newY) 
				return true;
				
			return false;
	}
	
	/** Check if the player is on the Gate
	 * 
	 * @param newX
	 * @param newY
	 * @return
	 * If the player is on the gate
	 */
	private boolean isOnGate(int newX, int newY) {
		if(gate.getX() == newX && gate.getY() == newY) 
			return true;
			
		return false;
}

	@Override
	public void doNothing() {
		if(isHit(this.getX(), this.getY())) {this.die();}
		else if(this.isOnFireBall(this.getX(), this.getY()))
			this.fireBall.collect();
		
		int index = 0;
		for(int i = 0; i < sprites.length; i++) {
			if(sprites[i] == this.getSprite()) {
				index = i;
			}
		}
		
		if(index > 7)
			this.setSprite(sprites[index + 1]);
		else
			this.setSprite(sprites[0]);
		
		this.setHasMoved();
		
	}
	
	/** Add the purse.
	 * 
	 * @param purse
	 */
	public void addPurse(IMobile purse) {
		purses.add(purse);
	}
	/** Add the key.
	 * 
	 * @param energy_Ball
	 */
	public void addEnergy_Ball(IMobile energy_Ball) {
		this.energy_Ball = energy_Ball;
	}
	/** Add a monster.
	 * 
	 * @param monster
	 */
	public void addMonster(IMobile monster) {
		this.monsters.add(monster);
	}
	/** Add the gate to the player.
	 * 
	 * @param gate
	 */
	public void addGate(IMobile gate) {
		this.gate = gate;
	}
	
	/** Add FireBall to the player.
	 * 
	 * @param fireBall
	 */
	public void add_FireBall(IMobile fireBall) {
		this.fireBall = fireBall;
		for (IMobile monster : monsters) {
			((FireBall)this.fireBall).addMonster(monster);
		}
	}
	/** Check if the playe has won.
	 * 
	 * @return
	 */
	public boolean hasWon() {
		return this.won;
	}
	/** Check if the player is hit by a monster.
	 * 
	 * 
	 */
	public boolean isHit(int newX, int newY) {
		for(IMobile monster : this.monsters) {
			if(monster.getX() == newX && monster.getY() == newY && monster.isAlive()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}
}
