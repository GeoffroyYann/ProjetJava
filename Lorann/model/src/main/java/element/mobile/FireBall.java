package element.mobile;

import java.awt.Point;
import java.util.ArrayList;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;


public class FireBall extends Mobile {
    
    private static Sprite sprite_1 = new Sprite(' ', "fireball_1");
    private static Sprite sprite_2 = new Sprite(' ', "fireball_2");
    private static Sprite sprite_3 = new Sprite(' ', "fireball_3");
    private static Sprite sprite_4 = new Sprite(' ', "fireball_4");
    private static Sprite sprite_5 = new Sprite(' ', "fireball_5");
    private static Sprite sprite_dead;
    private Sprite[] sprites;
    
    private int direction;
    
    private ArrayList<IMobile> monsters;
    
    public FireBall(ILevel level ,int x, int y, int direction, Sprite deadSprite) {
        super(deadSprite, Permeability.FIREBALL, level, x, y);
        this.sprite_dead = deadSprite;
        this.sprite_1.loadImage();
        this.sprite_2.loadImage();
        this.sprite_3.loadImage();
        this.sprite_4.loadImage();
        this.sprite_5.loadImage();
        
        this.sprites = new Sprite[5];
        
        this.sprites[0] = sprite_1;
        this.sprites[1] = sprite_2;
        this.sprites[2] = sprite_3;
        this.sprites[3] = sprite_4;
        this.sprites[4] = sprite_5;
        
        direction = 0;
        
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
                if(monster.getPosition().getX() == this.getX() && monster.getPosition().getY() == this.getY())
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
        this.getPosition().x = 0;
        this.getPosition().y = 0;
    }
    
    public void spawn(int x, int y, int direction) {
        if(this.setPosition(x, y)) {
            this.direction = direction;
            this.setSprite(sprite_1);
            this.revive;
        }
    }
    
    public void addMonster(IMobile monster) {
        this.monsters.add(monster);
    }
}