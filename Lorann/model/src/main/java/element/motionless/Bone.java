package element.motionless;

import model.Permeability;
import model.Sprite;

/** The bone class
 * 
 * @author Yann GEOFFROY
 *
 */
public class Bone extends Motionless{
    /** Sprite of the bone */
	private static final Sprite SPRITE = new Sprite('0',"bone");
    /** Instantiate a new bone */
	public Bone(){
        super(SPRITE, Permeability.BLOCKING);
    }
}
