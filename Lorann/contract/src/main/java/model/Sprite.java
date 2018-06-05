package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
    private Image image;
    private String imageName;
    private boolean imageLoaded;
    private char consoleImage;
    
    public Sprite(final char character, final String imageName) {
        this.setConsoleImage(character);
        this.setImageName(imageName);
    }
    
    public Sprite(final char character) {
        this(character, "noimage.jpg");
    }
    
    public final Image getImage() {
        return this.image;
    }
    
    public final void setImage(final Image image) {
        this.image = image;
    }
    
    public final String getImageName() {
        return this.imageName;
    }
    
    public void setImageName(final String imageName) {
        this.imageName = imageName;
    }
    
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }
    
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded ;
    }
    public char getConsoleImage() {
        return this.consoleImage;
    }
    
    public void setConsoleImage(char consoleImage) {
        this.consoleImage = consoleImage;
    }
    
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
