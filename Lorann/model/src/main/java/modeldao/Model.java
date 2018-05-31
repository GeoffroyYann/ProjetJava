package modeldao;

import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

import element.mobile.FireBall;
import element.mobile.Lorann;
import element.mobile.Monster1;
import element.mobile.Monster2;
import element.mobile.Monster3;
import element.mobile.Monster4;
import element.motionless.Bone;
import element.motionless.Empt;
import element.motionless.Energy_Ball;
import element.motionless.Gate_Closed;
import element.motionless.Gate_Open;
import element.motionless.Horizontal_Bone;
import element.motionless.Purse;
import element.motionless.Vertical_Bone;
import model.Example;
import model.IModel;

public class Model extends Observable implements IModel{
    
    private String map;
    private int score = 0;

    public IElement element(){
        
        this.map = "";
        
        private int x = 0;
        private int y = 0;
        x++;
        
        for (int i = 0; i != 240 ; i++){
            char c = (!map.equals("")) ? map.charAt(i) : ' ';
            if (c == '\n') {
                y++;
                x = 0;
            }
            switch (c){
            case 'A':
                this.lorann = new Lorann(x*32, y*32);
                break;
            case 'B':
                this.fireball = new FireBall(x*32, y*32);
                break;
            case 'C':
                this.energy_ball = new Energy_Ball(x*32, y*32);
                break;
            case 'D':
                this.gate_closed = new Gate_Closed(x*32, y*32);
                break;
            case 'E':
                this.gate_open = new Gate_Open(x*32, y*32);
                break;
            case 'F':
                this.bone = new Bone(x*32, y*32);
                break;
            case 'G':
                this.horizontal_bone = new Horizontal_Bone(x*32, y*32);
                break;
            case 'H':
                this.vertical_bone = new Vertical_Bone(x*32, y*32);
                break;
            case 'I':
                this.monster1 = new Monster1(x*32, y*32);
                break;
            case 'J':
                this.monster2 = new Monster2(x*32, y*32);
                break;
            case 'K':
                this.monster3 = new Monster3(x*32, y*32);
                break;
            case 'L':
                this.monster4 = new Monster4(x*32, y*32);
                break;
            case 'M':
                this.purse = new Purse(x*32, y*32);
                break;
            case 'N':
                this.empt = new Empt(x*32, y*32);
                break;
            }
        }
    }
    
    public String getMap(){
        return this.map;
    }
    
    private void setMap(final String map){
        this.map = map;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void loadMap(final String key){
        try{
            final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
            this.setMap(daoMap.find(key).getMap());
        } catch (final SQLException e){
            e.printStackTrace();
        }
    }
    
    public Observable getObservable(){
        return this;
    }

   public void upNameAndScore(final int score, final String nickname){
       try {
           final DAOUploadScore daoUploadScore = new DAOUploadScore(DBConnection.getInstance().getConnection());
           daoUploadScore.upNameAndScore(score, nickname);
       }
       catch (final SQLException e){
           e.printStackTrace();
       }
       return null;
   }
}
