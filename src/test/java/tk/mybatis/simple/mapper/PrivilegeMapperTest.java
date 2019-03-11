package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest {
	
	@Test
	public void testSelectById() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			SysPrivilege sysPrivilege = privilegeMapper.selectById(1l);
			
			Assert.assertNotNull(sysPrivilege);
			Assert.assertEquals("管理员", sysPrivilege.getPrivilegeName());
			
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}

}
