package controller;

import java.awt.*;
import java.util.*;
import java.util.Observer;
import controller.ControllerEnum;
import model.IElement;
import model.IFireBall;
import model.ILorann;
import model.IModel;
import model.IMonster;
import model.MobileOrder;
import view.IView;


@SuppressWarnings("deprecation")
public class Controller implements IController
{
	private IView view;
	private IModel model;
	private IElement[][] tileMap;
	private ILorann lorann;
	private String pseudo;
	private int level = 1;
	private int score = 0;
	private String[][] scores = null;
	private Point posGate = null;
	private HashMap<String, IMonster> monsters = new HashMap<String, IMonster>();
	private IFireBall fireBall;
	private boolean dead = false;
	private boolean parser = false;
	
	private void setModel(final IModel model) {
		this.model = model;
	}
	private void setView(final IView view) {
		this.view = view;
	}
	
	public IElement[][] getTileMap() {
		return tileMap;
	}
	
	public String[][] getScores() {
		return scores;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getScore() {
		return score;
	}
	
	
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		model.getObservable().addObserver();
		this.lorann = (ILorann) model.element('A', new Point());
	}
	
	public void start() {
		this.orderPerform(ControllerEnum.MENU);
		this.pseudo = this.view.getPseudo();
		System.out.println(this.pseudo);
		
		while (true) {
			if(this.fireBall != null && !this.parser) {
				this.moveFireBall();
			}
			if(this.dead) {
				this.model.loadMap("MAP1");
				this.view.printMessage(String.format("You died ! Your score is : %d\nPress OK to restart the game", this.score));
				this.model.upNameAndScore(this.score, this.pseudo);
				this.level = 1;
				this.score = 0;
			}
			if (!this.parser) {
				for (Object o : this.monsters.entrySet()) {
					Map.Entry pair = (Map.Entry) o;
					IMonster monster = (IMonster) pair.getValue();
					this.moveMonster(monster);
				}
			}
			this.view.repaint();
			
			try {
				Thread.sleep(200);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public IElement[][] parser(String tilemap) {
		this.parser = true;
		String[] lines = tilemap.split("\n");
		int x = lines.length;
		int y = lines[0].length();
		IElement[][] map = new IElement[x][y];
		
		this.monsters.clear();
		this.posGate = null;
		
		for(IElement[] row: map)
			Arrays.fill(row, this.model.element(' ', null));
		
		for (int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				char c = lines[i].charAt(j);
				Point pos = new Point(i, j);
				
				IElement element = this.model.element(c, pos);
				if (c == 'A') {
					this.dead = false;
					this.lorann = (ILorann) element;
				}
				else if (c == 'D') {
					this.posGate = pos.getLocation();
				}
				else if (c == 'O') {
					this.scores = this.model.getHighScore();
				}
				if (element != null) {
					map[i][j] = element;
				}
			}
		}
		System.out.println("Parse2");
		this.parser = false;
		return map;
	}
	
	
	
	public void orderPerform(final ControllerEnum controllerEnum) 
	{ if (controllerEnum == null)
		return;
	
		switch (controllerEnum) {
			case MENU:
				this.model.loadMap("MENU");
				this.level = 0;
				break;
			case Map1:
				this.model.loadMap("MAP1");
				this.level = 1;
				break;
			case Map2:
				this.model.loadMap("MAP2");
				this.level = 2;
				break;
			case Map3:
				this.model.loadMap("MAP3");
				this.level = 3;
				break;
			case Map4:
				this.model.loadMap("MAP4");
				this.level = 4;
				break;
			case Map5:
				this.model.loadMap("MAP5");
				this.level = 5;
				break;
			case Map6:
				this.model.loadMap("MAP6");
				this.level = 6;
				break;
			case MoveUp:
				this.moveLorann(MobileOrder.Up);
				break;
			case MoveDown:
				this.moveLorann(MobileOrder.Down);
				break;
			case MoveRight:
				this.moveLorann(MobileOrder.Right);
				break;
			case MoveLeft:
				this.moveLorann(MobileOrder.Left);
				break;
			case Shot:
				this.shot();
				break;
			default:
				break;
		}
	}
	
	private void shot() {
		if(this.fireBall != null)
			return;
		this.destroyFireBall();
		MobileOrder direction = this.lorann.getDirection();
		Point currentPos = this.lorann.getPos().getLocation();
		Point nextPos = this.computeNextPos(direction, currentPos);
		if(!currentPos.equals(nextPos)) {
			this.fireBall = (IFireBall) this.model.element('B', nextPos);
			this.fireBall.setDirection(direction);
			this.swapFireBall(nextPos);
			this.view.repaint();
		}
	}
	
	public void update(@SuppressWarnings("deprecation") Observable o, Object arg) {
		this.tileMap = parser(model.getMap());
		this.view.repaint();
	}
	
	
	
	private void moveFireBall() {
		Point currentPos = this.fireBall.getPos().getLocation();
		MobileOrder direction = this.fireBall.getDirection();
		for (MobileOrder dir : MobileOrder.getValues()) {
			if(!dir.equals(direction)) {
				Point aroundPos = this.computeNextPos(dir, currentPos);
				IElement element = this.tileMap[aroundPos.x][aroundPos.y];
				String elementName = element.getClass().getSimpleName();
				if(elementName.contains("Monster")) {
					this.tileMap[aroundPos.x][aroundPos.y] = model.element('N', aroundPos) ;
					this.monsters.remove(elementName);
					this.destroyFireBall();
					return;
				}
			}
		}
		Point nextPos = this.computeNextPos(this.fireBall.getDirection(), currentPos);
		this.swapFireBall(nextPos);
		this.tileMap[currentPos.x][currentPos.y] = model.element('N', currentPos.getLocation());
		if(this.fireBall != null && this.fireBall.getStep() > 5) {
			this.destroyFireBall();
		}
	}
	
	private void swapFireBall(Point nextPos) {
		String nextElement = this.tileMap[nextPos.x][nextPos.y].getClass().getSimpleName();
		if(nextElement.contains("Monster")) {
			this.fireBall.setLocation(nextPos);
			this.tileMap[nextPos.x][nextPos.y] = this.fireBall;
			this.destroyFireBall();
			IMonster monster = this.monsters.get(nextElement);
			Point monsterPos = monster.getPos().getLocation();
			this.tileMap[monsterPos.x][monsterPos.y] = model.element('N', monsterPos);
			System.out.println("Monster : " + this.monsters.remove(nextElement));
			this.score += 500;
			
		}else if(nextElement.contains("Gate") ||
				nextElement.contains("Purse") ||
				nextElement.contains("Energy")) {
			this.fireBall = null;
		}
		else {
			this.fireBall.setLocation(nextPos);
			this.tileMap[nextPos.x][nextPos.y] = this.fireBall;
		}
	}
	
	private void moveLorann(MobileOrder order) {
		Point pos = this.lorann.getPos();
		this.lorann.move(order, tileMap, this.view);
		this.tileMap[pos.x][pos.y] = model.element('N', pos.getLocation());
		pos = this.lorann.getPos();
		String elementName = this.tileMap[pos.x][pos.y].getClass().getSimpleName();
		if(elementName.contains("Monster")) {
			this.dead = true;
		} else if (elementName.contains("Energy") && this.posGate != null) {
			this.tileMap[this.posGate.x][this.posGate.y] = model.element('E', this.posGate);
			this.score += 100;
		}	else if (elementName.contains("OpenGate")) {
				this.level++;
				if (this.level > 5) {
					this.model.upNameAndScore(this.score, this.pseudo);
					this.view.printMessage(String.format("GOOD JOB %s ! Your score is : %d", this.pseudo, this.score));
					this.score = 0;
					this.level = 1;
				}
				this.model.loadMap(String.format("Map%d", this.level));
				return;
		} else if (elementName.contains("Purse")) {
			this.score += 250;
		}
		this.tileMap[pos.x][pos.y] = this.lorann;
		this.view.repaint();
		}
	
	private void moveMonster (IMonster monster) {
		Point pos = monster.getPos().getLocation();
		Point nextPos = this.computeNextPos(monster.getDirection(this.lorann.getPos().getLocation(),
				this.tileMap),pos);
		if(nextPos != pos) {
			String element = tileMap[nextPos.x][nextPos.y].getClass().getSimpleName();
			if(element.contains("Lorann")) {
				this.dead = true;
			}else if(!element.contains("Monster") &&
					!element.contains("Purse") &&
					!element.contains("Energy") &&
					!element.contains("Gate")) {
				tileMap[pos.x][pos.y] = model.element('N', pos.getLocation());
				monster.setLocation(nextPos);
				tileMap[nextPos.x][nextPos.y] = monster;
			}
		}
	}
	
	public Point computeNextPos(MobileOrder direction, Point currentPos) {
		Point nextPos = currentPos.getLocation();
		
		if(direction == null)
			return nextPos;
		
		switch (direction) {
		case Left:
			if(currentPos.y > 0 &&
					tileMap[currentPos.x][currentPos.y -1].getPermeability())
			{
				nextPos = new Point(currentPos.x, currentPos.y -1);
			}
			break;
		case Right:
			if(currentPos.y < (view.getWidth() / 32) -1 &&
					tileMap[currentPos.x][currentPos.y +1].getPermeability())
		{
			nextPos = new Point(currentPos.x, currentPos.y + 1);
		}
			break;
		case Up:
			if(currentPos.x > 0 &&
					tileMap[currentPos.x -1][currentPos.y].getPermeability())
		{
				nextPos = new Point(currentPos.x -1, currentPos.y);
		}
		case Down:
			if(currentPos.x < (view.getHeight() / 32) -1 &&
					tileMap[currentPos.x +1][currentPos.y].getPermeability()) {
				nextPos = new Point(currentPos.x + 1, currentPos.y);
			}
			break;
		}
		return nextPos;
	}
	private void destroyFireBall() {
		if(this.fireBall != null) {
			Point pos = this.fireBall.getPos().getLocation();
			this.tileMap[pos.x][pos.y] = this.model.element('N', pos);
			this.fireBall = null;
		}
	}
	

	}
	
