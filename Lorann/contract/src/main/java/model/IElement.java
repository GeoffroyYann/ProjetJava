package model;


import java.awt.Image;

import showboard.ISquare;
/**
 * <h1>The Interface IElement.</h1>
 * 
 */

public interface IElement extends ISquare {
    
	 /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();
    
    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();
    
    Image getImage();


}
