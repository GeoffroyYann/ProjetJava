package facade;

import java.io.IOException;
import java.sql.*;
import element.mobile.Lorann;
import model.ILevel;
import model.IMobile;
import model.IModel;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public final class ModelFacade implements IModel {

	/** The level */
	private ILevel level;
	/** Lorann */
	private Lorann lorann;
	/** Array of all purses */
	private IMobile[] purses;
	/** Array of all monsters */
	private IMobile[] monsters;
	/** The key */
	private IMobile energy_Ball;
	/** The gate */
	private IMobile gate;
	/** The fireBall */
	private IMobile fireBall;
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade(int level) throws SQLException, IOException {
        super();
        this.setLevel(new Level(level));
        this.setLorann(new Lorann((int)this.level.getLorannPos().getX(), (int)this.level.getLorannPos().getY(), this.level));
        purses = new IMobile[getLevel().getPurses().length];
        monsters = new IMobile[getLevel().getMonsters().length];
        
        for(int i = 0; i < purses.length; i++) {
        	purses[i] = this.getLevel().getPurses()[i];
        	this.getLorann().addPurse(purses[i]);
        }
        
        for(int i = 0; i < monsters.length; i++) {
        	monsters[i] = this.getLevel().getPurses()[i];
        	this.getLorann().addMonster(monsters[i]);
        }
        
        energy_Ball = this.getLevel().getEnergy_Ball();
        ((Lorann)this.getLorann()).addEnergy_Ball(energy_Ball);
        
        gate = this.getLevel().getGate();
        ((Lorann)this.getLorann()).addGate(gate);
        
        fireBall = this.getLevel().getFireBall();
        ((Lorann)this.getLorann()).add_FireBall(fireBall);
        
        
        
    }


    /** gets lorann */
	public Lorann getLorann() {
		return this.lorann;
	}


	/** Gets the level */
	public ILevel getLevel() {
		return this.level;
	}

	/** Sets the level */
	private void setLevel(ILevel level) {
		this.level = level;
	}
	/** Sets Lorann */
	private void setLorann(Lorann lorann) {
		this.lorann = lorann;
	}
	/** Gets all the purses on the map */
	public IMobile[] getPurses() {
		return purses;
	}
	/** Sets all the purses */
	private void setPurses(IMobile[] purses) {
		this.purses = purses;
	}
	
	/** gets all the monsters */
	public IMobile[] getMonsters() {
		return monsters;
	}
	
	/** Set all the monsters */
	private void setMonsters(IMobile[] monsters) {
		this.monsters = monsters;
	}
	
	/** Gets the energy_Ball */
	public IMobile getEnergy_Ball() {
		return this.energy_Ball;
	}
	
	/** Gets the gate */
	public IMobile getGate() {
		return this.gate;
	}
	
	/** Checks if Lorann has won */
	public boolean hasLorannWon() {
		return ((Lorann)this.getLorann()).hasWon();
	}
	
	/** Gets the FireBall */
	public IMobile getFireBall() {
		return this.fireBall;
	}
	


}
