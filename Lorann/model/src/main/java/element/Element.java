package element;

import java.awt.Image;

import model.IElement;
import model.Permeability;
import model.Sprite;

public class Element implements IElement {
    /** The sprite. */
    private Sprite sprite;
    /** The permeability */
    private Permeability permeability;
    
    /** Instantiate a new element.
     * 
     * @param sprite
     * @param permeability
     */
    public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
}
    /**Get the sprite.
     * @return sprite
     */
    public final Sprite getSprite() {
        return this.sprite;
        
    }
    /**Get the permeability
     * 
     * @return permeability
     */
    public final Permeability getPermeability() {
        return this.permeability;
    }
    
    /** Set the permeability
     * 
     * @param permeability
     */
    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }
    
    /** Set the sprite
     * 
     * @param sprite
     */
    protected final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }

    /** Get the image
     * 
     * @return image
     */
    public final Image getImage() {
        return this.getSprite().getImage();
    }
}
