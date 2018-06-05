package element.motionless;

public abstract class MotionlessFactory {
	private static final Bone bone = new Bone();
	private static final Empty empty = new Empty();
	private static final Horizontal_Bone horizontal_bone = new Horizontal_Bone();
	private static final Vertical_Bone vertical_bone = new Vertical_Bone();
	
	private static Motionless[] motionlesss = {
			bone,
			empty,
			horizontal_bone,
			vertical_bone
	};
	
	public static Motionless createBone() {
		return bone;
	}
	
	public static Motionless createEmpty() {
		return empty;
	}
	
	public static Motionless createHorizontal_Bone() {
		return horizontal_bone;
	}
	
	public static Motionless createVertical_Bone() {
		return vertical_bone;
	}
	
	public static Motionless getFromFileSymbol(final char fileSymbol) {
		for(final Motionless motionless : motionlesss) {
			if(motionless.getSprite().getConsoleImage() == fileSymbol) {
				return motionless;
			}
		}
		return empty;
	}
}
