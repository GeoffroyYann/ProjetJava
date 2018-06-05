package element;

import java.awt.Image;

import model.IElement;
import model.Permeability;
import model.Sprite;

public class Element implements IElement {
    
    private Sprite sprite;
    private Permeability permeability;
    
    public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
}
    public final Sprite getSprite() {
        return this.sprite;
        
    }
    
    public final Permeability getPermeability() {
        return this.permeability;
    }
    
    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }
    
    protected final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }

    public final Image getImage() {
        return this.getSprite().getImage();
    }
}
