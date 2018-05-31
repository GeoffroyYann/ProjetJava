package element.modeldao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

class DAOMap extends DAOEntity<Map>{
    
    public DAOMap(final Connection connection) throws SQLException{
        super(connection);
    }
    
    public boolean create(final Map entity){
        return false;
    }
    
    public boolean delete(final Map entity){
        return false;
    }
    
    public boolean update(final Map entity){
        return false;
    }
    
    public Map find(final int id){
        Map map = new Map();
        try{
            final String sql = "{call mapById(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()){
                map = new Map(id, resultSet.getString("key"), resultSet.getString("map"));
            }
            return map;            
        } catch (final SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Map find(final String key){
        Map map = new Map();
        try{
            final String sql = "{call mapByKey(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setString(1, key);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()){
                map = new Map(resultSet.getInt("id"), key, resultSet.getString("map"));
            }
            return map;
        } catch (final SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
