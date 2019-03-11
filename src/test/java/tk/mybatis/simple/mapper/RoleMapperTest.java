package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.type.Enabled;

public class RoleMapperTest extends BaseMapperTest{
	
	@Test
	public void testSelectById() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = roleMapper.selectById(1l);
			Assert.assertNotNull(sysRole);
			Assert.assertEquals("管理员", sysRole.getRoleName());
			
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		
		
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<SysRole> sysRoles = roleMapper.selectAll();
			Assert.assertNotNull(sysRoles);
			Assert.assertTrue(sysRoles.size() > 0);
			Assert.assertNotNull(sysRoles.get(0).getRoleName());
			
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
		
		
	}
	
	@Test
	public void testdeleteById() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			int num = roleMapper.deleteById(1l);
			Assert.assertEquals(1l, num);
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRoleByUserIdChoose() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role = roleMapper.selectById(2L);
			//role.setEnabled(0);
			roleMapper.updateById(role);
			List<SysRole> roles = roleMapper.selectRoleByUserIdChoose(1L);
			for (SysRole sysRole : roles) {
				System.out.println("角色名：" + sysRole.getRoleName());
				if(sysRole.getId().equals(1L)) {
					Assert.assertNotNull(sysRole.getPrivilegeList());
					
				}else if (sysRole.getId().equals(2L)) {
					Assert.assertNotNull(sysRole.getPrivilegeList());
					continue;
				}
				for(SysPrivilege privilege : sysRole.getPrivilegeList()) {
					System.out.println("权限名：" + privilege.getPrivilegeName());
				}
			}
			
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testUpdateById() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role = roleMapper.selectById(2L);
			Assert.assertEquals(Enabled.enabled, role.getEnabled());
			role.setEnabled(Enabled.disabled);
			roleMapper.updateById(role);
			
			
		} finally {
			// TODO: handle finally clause
			sqlSession.rollback();
			sqlSession.close();
			
		}
	}

}
