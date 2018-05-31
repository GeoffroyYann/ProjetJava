package modeldao;

import java.sql.Connection;
import java.sql.SQLException;

abstract class DAOEntityScore<E extends EntityScore>{
    
    private final Connection connection;
    
    public DAOEntityScore(final Connection connection) throws SQLException {
        this.connection = connection;
    }
    
    protected Connection getConnection(){
        return this.connection;
    }
    
    public abstract boolean update(E entityScore);
    
    public abstract String[][] getHighScore();
    
    public abstract void upNameAndScore(final int score, final String nickname);

}
