package element.motionless;

import element.Element;
import model.Permeability;
import model.Sprite;

/** The Motionless abstract class.
 * 
 * @author Yann GEOFFROY
 *
 */
abstract class Motionless extends Element {

	/** Instantiate a new motionless element */
    public Motionless(final Sprite sprite, final Permeability permeability){
        super(sprite, permeability);
    }
}
