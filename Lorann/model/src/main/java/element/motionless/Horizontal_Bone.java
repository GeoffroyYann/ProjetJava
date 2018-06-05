package element.motionless;

import model.Permeability;
import model.Sprite;

/** The Horizontal_Bone class.
 * 
 * @author Yann GEOFFROY
 *
 */
public class Horizontal_Bone extends Motionless {
		
	/** The sprite of a horizontal_bone.
	 * 
	 */
    	private static final Sprite SPRITE = new Sprite('0',"horizontal_bone");
       /** Instantiate a new horizontal_bone. */
    	public Horizontal_Bone(){
            super(SPRITE, Permeability.BLOCKING);
        }
}
