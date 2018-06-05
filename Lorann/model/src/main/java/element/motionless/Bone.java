package element.motionless;

import model.Permeability;
import model.Sprite;

public class Bone extends Motionless{
    
	private static final Sprite SPRITE = new Sprite('0',"bone");
    public Bone(){
        super(SPRITE, Permeability.BLOCKING);
    }
}
