package tk.mybatis.simple.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class EnabledTypeHandler implements TypeHandler<Enabled> {
	
	private final Map<Integer, Enabled> enabledMap = new HashMap<>();
	
	

	public EnabledTypeHandler() {
		for(Enabled enabled : Enabled.values()) {
			enabledMap.put(enabled.getValue(), enabled);
		}
	}

	@Override
	public Enabled getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		Integer value = rs.getInt(columnName);
		return enabledMap.get(value);
	}

	@Override
	public Enabled getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		Integer value = rs.getInt(columnIndex);
		
		return enabledMap.get(value);
	}

	@Override
	public Enabled getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		Integer value = cs.getInt(columnIndex);
		return enabledMap.get(value);
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Enabled parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ps.setInt(i, parameter.getValue());
		
	}

	
}
