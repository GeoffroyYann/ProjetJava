package element.motionless;

import model.Permeability;
import model.Sprite;

/** The Vertical_Bone class.
 * 
 * @author Yann GEOFFROY
 *
 */
public class Vertical_Bone extends Motionless {

	/** The sprite of a Vertical_Bone */
	private static final Sprite SPRITE = new Sprite('0',"vertical_bone");
	/** Instantiate a new Vertical_Bone */
    public Vertical_Bone(){
        super(SPRITE, Permeability.BLOCKING);
    }
}
