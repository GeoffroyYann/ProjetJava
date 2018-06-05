package element.motionless;

import model.Permeability;
import model.Sprite;

public class Horizontal_Bone extends Motionless {

    	private static final Sprite SPRITE = new Sprite('0',"horizontal_bone");
        public Horizontal_Bone(){
            super(SPRITE, Permeability.BLOCKING);
        }
}
