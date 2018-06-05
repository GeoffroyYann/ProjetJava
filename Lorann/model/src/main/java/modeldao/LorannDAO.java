package modeldao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.CallableStatement;

public abstract class LorannDAO extends AbstractDAO {
	private static String sqlChooseLevel = "{call ChooseLevel(?)}";
	
	public static String chooseLevel(final int id) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlChooseLevel);
		String level = null;
		callStatement.setInt(1, id);
		if(callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if(result.first()) {
				level = result.getString("text");
			}
			result.close();
		}
		return level;
	}
}
