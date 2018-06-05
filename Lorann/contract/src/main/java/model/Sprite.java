package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	/** The image*/
    private Image image;
    /** The image name*/
    private String imageName;
    /** The image loaded*/
    private boolean imageLoaded;
    /**the console image*/
    private char consoleImage;
    
    /**
     * Instantiates a new sprite.
     *
     * @param lorann
     *            the character
     * @param imageName
     *            the image name
     */
    public Sprite(final char lorann, final String imageName) {
        this.setConsoleImage(lorann);
        this.setImageName(imageName);
    }
    
    /**
     * Instantiates a new sprite.
     *
     * @param lorann
     *            the character
     */
    public Sprite(final char lorann) {
        this(lorann, "noimage.jpg");
    }
    
    /**
     * Gets the image.
     *
     * @return the image
     */
    public final Image getImage() {
        return this.image;
    }
    
    /**
     * Sets the image.
     *
     * @param image
     *            the new image
     */
    public final void setImage(final Image image) {
        this.image = image;
    }
    
    /**
     * Gets the image name.
     *
     * @return the imageName
     */
    public final String getImageName() {
        return this.imageName;
    }
    
    /**
     * Sets the image name.
     *
     * @param imageName
     *            the imageName to set
     */
    public void setImageName(final String imageName) {
        this.imageName = imageName;
    }
    
    /**
     * Checks if is image loaded.
     *
     * @return true, if is image loaded
     */
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }
    
    /**
     * Sets the image loaded.
     *
     * @param isImageLoaded
     *            the new image loaded
     */
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded ;
    }
    
    /**
     * Get the console image.
     * 
     * @return the console image
     */
    public char getConsoleImage() {
        return this.consoleImage;
    }
    
    /**
     * Sets the console image.
     *
     * @param consoleImage
     *            the console image
     */
    public void setConsoleImage(char consoleImage) {
        this.consoleImage = consoleImage;
    }
    
    /**
     * Loads image.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException {
    	String path = System.getProperty("user.dir") + "\\..\\main\\pack3\\" + this.getImageName() + ".png";

    	try {
    		this.setImage(ImageIO.read(new File(path)));
    	}
    	catch(Exception e){
    		path = System.getProperty("user.dir") + "\\..\\main\\pack3\\floor.png";
    		this.setImage(ImageIO.read(new File(path)));
    	}
    }
}
