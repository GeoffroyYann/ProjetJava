package element.motionless;

import element.Element;
import model.Permeability;
import model.Sprite;

abstract class Motionless extends Element {

    public Motionless(final Sprite sprite, final Permeability permeability){
        super(sprite, permeability);
    }
}
