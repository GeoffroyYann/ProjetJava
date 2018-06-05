package element.mobile;

import java.io.IOException;
import java.util.ArrayList;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;

/** The FireBall class
 * 
 * @author Yann GEOFFROY
 *
 */
public class FireBall extends Mobile {
    /** First sprite*/
    private static Sprite sprite_1 = new Sprite(' ', "fireball_1");
    /** Second sprite */
    private static Sprite sprite_2 = new Sprite(' ', "fireball_2");
    /** Third sprite*/
    private static Sprite sprite_3 = new Sprite(' ', "fireball_3");
    /** Fourth sprite*/
    private static Sprite sprite_4 = new Sprite(' ', "fireball_4");
    /** Fifth sprite */
    private static Sprite sprite_5 = new Sprite(' ', "fireball_5");
    /** Sprite of the death*/
    private static Sprite sprite_dead;
    /** List of all the sprites of the spell */
    private Sprite[] sprites;
    
    /** Direction of the spell
     * 
     */
    private int direction;
    
    /** List of all monsters */
    private ArrayList<IMobile> monsters;
    
    /** Instantiate a new FireBall 
     * 
     * @param level
     * @param x
     * @param y
     * @param direction
     * @param deadSprite
     * @throws IOException
     */
    public FireBall(ILevel level ,int x, int y, int direction, Sprite deadSprite) throws IOException {
        super(deadSprite, Permeability.FIREBALL, level, x, y);
        FireBall.sprite_dead = deadSprite;
        FireBall.sprite_1.loadImage();
        FireBall.sprite_2.loadImage();
        FireBall.sprite_3.loadImage();
        FireBall.sprite_4.loadImage();
        FireBall.sprite_5.loadImage();
        
        this.sprites = new Sprite[5];
        
        this.sprites[0] = sprite_1;
        this.sprites[1] = sprite_2;
        this.sprites[2] = sprite_3;
        this.sprites[3] = sprite_4;
        this.sprites[4] = sprite_5;
        
        this.collect();
        
        monsters = new ArrayList<>();
    }
    
    @Override
    public void move() {
        if(this.isAlive()) {
            
            switch (direction) {
                case 1: // Up
                    if(!moveUp()) {
                        moveDown();
                        direction = 2;
                    }
                    break;
                case 2: // Down
                    if(!moveDown()) {
                        moveUp();
                        direction = 1;
                    }
                    break;
                case 3: // Right
                    if(!moveRight()) {
                        moveLeft();
                        direction = 4;
                    }
                    break;
                case 4: // Left
                    if(!moveLeft()) {
                        moveRight();
                        direction = 3;
                    }
                    break;
            }
            
            int index = 0;
            for(int i = 0; i < sprites.length; i++) {
                if(sprites[i] == this.getSprite()) {
                    index = i;
                }
            }
            
            if(index < 4)
                this.setSprite(sprites[index + 1]);
            else
                this.setSprite(sprites[0]);
            
            for (IMobile monster : monsters) {
                if(monster.getPos().getX() == this.getX() && monster.getPos().getY() == this.getY())
                {
                    monster.collect();
                    this.collect();
                    break;
                }
            }
            
        }
    }
    
    @Override
    public void doNothing() {
        
    }
    
    @Override
    public int collect() {
        this.die();
        return 0;
    }
    
    @Override
    public void die() {
        super.die();
        this.setSprite(sprite_dead);
        this.getPos().x = 0;
        this.getPos().y = 0;
    }
    
    /** Make the FireBall spawn
     * 
     * @param x
     * @param y
     * @param direction
     */
    public void spawn(int x, int y, int direction) {
        if(this.setPos(x, y)) {
            this.direction = direction;
            this.setSprite(sprite_1);
            this.revive();
        }
    }
    
    /** Add a monster
     * 
     * @param monster
     */
    public void addMonster(IMobile monster) {
        this.monsters.add(monster);
    }
}