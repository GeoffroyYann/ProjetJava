package element.motionless;

import model.Permeability;
import model.Sprite;

public class Vertical_Bone extends Motionless {

	private static final Sprite SPRITE = new Sprite('0',"vertical_bone");
    public Vertical_Bone(){
        super(SPRITE, Permeability.BLOCKING);
    }
}
