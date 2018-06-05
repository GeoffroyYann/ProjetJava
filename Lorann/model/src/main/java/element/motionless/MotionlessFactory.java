package element.motionless;

/** The MotionlessFactory class.
 * 
 * @author Yann GEOFFROY
 *
 */
public abstract class MotionlessFactory {
	/** Instances a Bone element. */
	private static final Bone bone = new Bone();
	/** Instances a Empty element. */
	private static final Empty empty = new Empty();
	/** Instances a Horizontal_Bone element. */
	private static final Horizontal_Bone horizontal_bone = new Horizontal_Bone();
	/** Instances a Vertical_Bone element. */
	private static final Vertical_Bone vertical_bone = new Vertical_Bone();
	
	/** Array of all instances */
	private static Motionless[] motionlesss = {
			bone,
			empty,
			horizontal_bone,
			vertical_bone
	};
	
	/** Gets the instance of a Bone.
	 * 
	 * @return the instance of a Bone.
	 */
	public static Motionless createBone() {
		return bone;
	}
	/** Gets the instance of an Empty square.
	 * 
	 * @return the instance of an Empty square.
	 */
	public static Motionless createEmpty() {
		return empty;
	}
	/** Gets the instance of a Horizontal_Bone.
	 * 
	 * @return the instance of a Horizontal_Bone.
	 */
	public static Motionless createHorizontal_Bone() {
		return horizontal_bone;
	}
	/** Gets the instance of a Vertical_Bone.
	 * 
	 * @return the instance of a Vertical_Bone.
	 */
	public static Motionless createVertical_Bone() {
		return vertical_bone;
	}
	
	/** Gets the good Motionless element from a symbol.
	 * 
	 * @param fileSymbol
	 * @return the element associed with the file Symbol.
	 */
	public static Motionless getFromFileSymbol(final char fileSymbol) {
		for(final Motionless motionless : motionlesss) {
			if(motionless.getSprite().getConsoleImage() == fileSymbol) {
				return motionless;
			}
		}
		return empty;
	}
}
