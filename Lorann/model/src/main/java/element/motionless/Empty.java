package element.motionless;

import model.Permeability;
import model.Sprite;

/** The class Empty 
 * 
 * @author Yann GEOFFROY
 *
 */
public class Empty extends Motionless{
	
	/** The sprite of empty */
	private static final Sprite SPRITE = new Sprite('0',"empty");
    /** Instantiate an empty square */
	public Empty(){
        super(SPRITE, Permeability.BLOCKING);
    }
}
