package modeldao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;

class DAOUploadScore extends DAOEntityScore<UploadScore>{
    
    public DAOUploadScore(final Connection connection) throws SQLException{
        super(connection);
    }
    
    public boolean update(final UploadScore entity){
        return false;
    }
    
    public String[][] getHighScore(){
        return null;
    }
    
    public void upNameAndScore(final int score, final String nickname){
        try{
            final String sql = "{call AddShowScore(?, ?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, score);
            call.setString(2, nickname);
            final int row = call.executeUpdate();
            if(row > 0);
                System.out.println("The score was uploaded to the db");
        } catch (final SQLException e){
            e.printStackTrace();
        }
    }
}
