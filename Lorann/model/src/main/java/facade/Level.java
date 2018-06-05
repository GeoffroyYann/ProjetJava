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

public class Level extends Observable implements ILevel {
	
	private final int width = 20;
	
	private final int height = 12;
	
	private IElement[][] onTheLevel;
	
	private Point lorannPos;
	
	private ArrayList<IMobile> monsters;
	
	private ArrayList<IMobile> purses;
	
	private IMobile energy_Ball;
	
	private IMobile gate;
	
	private IMobile fireBall;
	
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
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public IElement getOnTheLevelXY(int x, int y) {
		return onTheLevel[x][y];
	}
	
	public void setOnTheLevelXY(int x, int y, IElement element) {
		this.onTheLevel[x][y] = element;
	}
	
	public Observable getObservable() {
		return this;
	}
	
	public void setElementHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	
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
	
	public Point getLorannPos() {
		return this.lorannPos;
	}
	
	private void setLorannPos(Point pos) {
		this.lorannPos = pos;
	}
	
	public IMobile[] getPurses() {
		IMobile[] result = new IMobile[this.purses.size()];
		for(int i = 0; i < result.length; i++ ) {
			result[i] = purses.get(i);
			
		}
		return result;
	}
	
	public IMobile[] getMonsters() {
		IMobile[] result = new IMobile[this.monsters.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = monsters.get(i);
		}
		return result;
	}
	
	public IMobile getEnergy_Ball() {
		return energy_Ball;
	}
	
	public IMobile getGate() {
		return gate;
	}
	
	public IMobile getFireBall() {
		return fireBall;
	}
	
	
	
	
	
	
	

}
