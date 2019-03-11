package tk.mybatis.simple.plugin;


import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;



@Intercepts(
		@Signature(
				type=ResultSetHandler.class,
				method="handleResultSets",
				args= {Statement.class}
				)
		)
@SuppressWarnings({"unchecked","rawtypes"})
public class CameHumpInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		List<Object> list = (List<Object>) invocation.proceed();
		for(Object object : list) {
			if(object instanceof Map) {
				processMap((Map)object);
				
			}else {
				break;
			}
		}
		return list;
		
	}
	
	private void processMap(Map<String, Object> map) {
		Set<String> keySet = new HashSet<>(map.keySet());
		for (String key : keySet) {
			if(key.charAt(0) >= 'A' && key.charAt(0) <= 'Z' || key.indexOf("_") >= 0) {
				Object value = map.get(key);
				map.remove(key);
				map.put(underLineToCamelhump(key), value);
			}
		}
	}
	
	public static String underLineToCamelhump(String inputString) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean nextUpperCase = false;
		for(int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			if(c == '_') {
				if(stringBuilder.length() > 0) {
					nextUpperCase = true;
				}
			}else {
				if(nextUpperCase) {
					stringBuilder.append(Character.toUpperCase(c));
					nextUpperCase = false;
				}else {
					stringBuilder.append(Character.toLowerCase(c));
				}
			}
		}
		return stringBuilder.toString();
		
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

}
