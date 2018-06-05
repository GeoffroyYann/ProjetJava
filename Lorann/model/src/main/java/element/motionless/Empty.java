package element.motionless;

import model.Permeability;
import model.Sprite;

public class Empty extends Motionless{

	private static final Sprite SPRITE = new Sprite('0',"empty");
    public Empty(){
        super(SPRITE, Permeability.BLOCKING);
    }
}
