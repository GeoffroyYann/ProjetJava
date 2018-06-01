package modeldao;

import java.awt.Point;
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
import element.motionless.Empty;
import element.motionless.Energy_Ball;
import element.motionless.Gate_Open;
import element.motionless.Gate_Closed;
import element.motionless.Horizontal_Bone;
import element.motionless.Purse;
import element.motionless.Score;
import element.motionless.Title;
import element.motionless.Vertical_Bone;
import model.Example;
import model.IElement;
import model.IModel;

@SuppressWarnings("deprecation")
public class Model extends Observable implements IModel{
    
    private String map = "";
    private int score = 0; 

    public IElement element(char c, Point pos) {
        
            switch (c){
            case 'A':
                return new Lorann(pos);
            case 'B':
            	return new FireBall(pos);
            case 'C':
                return new Energy_Ball();
            case 'D':
                return new Gate_Closed();
            case 'E':
                return new Gate_Open();
            case 'F':
                return new Bone();
            case 'G':
                return new Horizontal_Bone();
            case 'H':
                return new Vertical_Bone();
            case 'I':
                return new Monster1(pos);
            case 'J':
            	return new Monster2(pos);
            case 'K':
                return new Monster3(pos);
            case 'L':
                return new Monster4(pos);
            case 'M':
                return new Purse();
            case 'N':
            	return new Empty();
            case 'O':
            	return new Score();
            case 'P':
            	return new Title();
            	
            }
			return null;
        }
    
    
    public String getMap(){
        return this.map;
    }
    
    private void setMap(final String map){
        this.map = map;
        this.setChanged();
        this.notifyObservers();
    }
    public Model() {
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
   }
   
   public String[][] getHighScore(){
       try{
           final DAOGetHighscore daoGetHighscore = new DAOGetHighscore(DBConnection.getInstance().getConnection());
           return (daoGetHighscore.getHighScore());
       } catch (final SQLException e){
           e.printStackTrace();
       }
       return null;
   }

@Override
public Example getExampleById(int id) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Example getExampleByName(String name) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Example> getAllExamples() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}
