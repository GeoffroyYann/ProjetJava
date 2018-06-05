package facade;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import element.mobile.Energy_Ball;
import element.mobile.FireBall;
import element.mobile.Gate;
import element.mobile.Monster_1;
import element.mobile.Monster_2;
import element.mobile.Monster_3;
import element.mobile.Monster_4;
import element.motionless.MotionlessFactory;
import model.IElement;
import model.ILevel;
import model.IMobile;
import modeldao.LorannDAO;

/** The level class.
 * 
 * @author Yann GEOFFROY
 *
 */
public class Level extends Observable implements ILevel {
	
	/** Constant width of the map */
	private final int width = 20;
	/** Constant height of the map */
	private final int height = 12;
	/** Array which contains the elements of the level */
	private IElement[][] onTheLevel;
	/** Position of Lorann */
	private Point lorannPos;
	/** Array of all the monsters */
	private ArrayList<IMobile> monsters;
	/** Array of all purses */
	private ArrayList<IMobile> purses;
	/** The key */
	private IMobile energy_Ball;
	/** The gate */
	private IMobile gate;
	/** The fireBall */
	private IMobile fireBall;
	/** Instantiate a new level object
	 * 
	 * @param level
	 * ID field of database
	 */
	public Level(int level) {
		super();
		monsters = new ArrayList<>();
		purses = new ArrayList<>();
		
		try {
			this.loadLevel(level);
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
			
		}
		
	}
	/** Gets the width */
	public int getWidth() {
		return this.width;
	}
	/** Gets the height */
	public int getHeight() {
		return this.height;
	}
	/** Gets an element on the map
	 * 
	 */
	public IElement getOnTheLevelXY(int x, int y) {
		return onTheLevel[x][y];
	}
	/** Gets an element on the map
	 * 
	 */
	public void setOnTheLevelXY(int x, int y, IElement element) {
		this.onTheLevel[x][y] = element;
	}
	/** Gets the Observal object */
	public Observable getObservable() {
		return this;
	}
	/** Notifies the observer the element has changed */
	public void setElementHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	/** Load the level from the database
	 * 
	 * @param level
	 * ID of the level in the database
	 * @throws SQLException
	 * If the query fails
	 * @throws IOException
	 * if the image doesn't exist
	 */
	private void loadLevel(int level) throws SQLException, IOException {
		String levelText = LorannDAO.chooseLevel(level);
		this.onTheLevel = new IElement[this.getWidth()][this.getHeight()];
		String[] levelArray = levelText.split(",");
		for(int y = 0; y < 12; y++) {
			for(int x = 0; x < 20; x++) {
				switch(levelArray[y].toCharArray()[x]) {
				case 'A':
					this.setLorannPos(new Point(x, y));
					this.setOnTheLevelXY(x, y, MotionlessFactory.createEmpty());
					break;
				case 'C':
					this.energy_Ball = new Energy_Ball(x,y, this);
					this.setOnTheLevelXY(x, y, MotionlessFactory.createEmpty());
					break;
				case 'D':
					this.gate = new Gate(x, y,this);
					this.setOnTheLevelXY(x, y, MotionlessFactory.createEmpty());
					break;
				case 'I':
					this.monsters.add(new Monster_1(this, x, y));
					this.setOnTheLevelXY(x, y, MotionlessFactory.createEmpty());
					break;
				case 'J':
					this.monsters.add(new Monster_2(this, x, y));
					this.setOnTheLevelXY(x, y, MotionlessFactory.createEmpty());
					break;
				case 'K':
					this.monsters.add(new Monster_3(this, x, y));
					this.setOnTheLevelXY(x, y, MotionlessFactory.createEmpty());
					break;
				case 'L':
					this.monsters.add(new Monster_4(this, x, y));
					this.setOnTheLevelXY(x, y, MotionlessFactory.createEmpty());
					break;
				default:
					this.setOnTheLevelXY(x, y, MotionlessFactory.createEmpty());
					break;
				}
			}
		}
		this.fireBall = new FireBall(this, 0, 0,0, this.getOnTheLevelXY(0, 0).getSprite());
	}
	
	/** Gets the position of Lorann*/
	public Point getLorannPos() {
		return this.lorannPos;
	}
	/** Sets the position of Lorann */
	private void setLorannPos(Point pos) {
		this.lorannPos = pos;
	}
	
	/** Gets the position of all purses */
	public IMobile[] getPurses() {
		IMobile[] result = new IMobile[this.purses.size()];
		for(int i = 0; i < result.length; i++ ) {
			result[i] = purses.get(i);
			
		}
		return result;
	}
	
	/** Gets the position of all monsters */
	public IMobile[] getMonsters() {
		IMobile[] result = new IMobile[this.monsters.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = monsters.get(i);
		}
		return result;
	}
	/** Gets the energy_Ball */
	public IMobile getEnergy_Ball() {
		return energy_Ball;
	}
	/** Gets the gate */
	public IMobile getGate() {
		return gate;
	}
	/** Gets the FireBall */
	public IMobile getFireBall() {
		return fireBall;
	}
	
	
	
	
	
	
	

}
