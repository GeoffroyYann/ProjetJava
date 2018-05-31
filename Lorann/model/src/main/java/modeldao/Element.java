package modeldao;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import model.IElement;

public abstract class Element implements IElement{
    
    protected BufferedImage image = null;
    protected boolean permeability;
    static HashMap<String, BufferedImage> images = new HashMap<String, BufferedImage>();
    
    public Element(String path, boolean permeability){
        if(!path.equals("")){
            this.image = Element.loadSprite(path);
        }
        this.permeability = permeability;
    }
    
    static protected BufferedImage loadSprite(String path){
        if(path == null)
            return null;
        
        if(!Element.images.containsKey(path)){
            System.out.printf("Load '%s'%n", path);
            try{
                Element.images.put(path, ImageIO.read(Element.class.getResource(String.format("/sprite/%s", path))));
            } catch (IOException e){
                e.printStackTrace();
                System.out.printf("Pathname is '%s'%n", path);
            }
        }
        return Element.images.get(path);
    }
    
    public BufferedImage getImage(){
        return this.image;
    }
    
    public boolean getPermeability(){
        return permeability;
    }

}
