package tk.mybatis.simple.mapper;


import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.Country;
import tk.mybatis.simple.model.CountryExample;


public class CountryMapperTest extends BaseMapperTest {
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			List<Country> countryList = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
			printCountryList(countryList);
		
		} finally {
			sqlSession.close();
		}
			
	}
	
	private void printCountryList(List<Country> countryList) {
		for(Country country : countryList) {
			System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
		}
	
	}
	
	@Test
	public void testExample() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
			//创建Example对象
			CountryExample example = new CountryExample();
			example.setOrderByClause("id desc, countryname asc");
			example.setDistinct(true);
			//创建条件
			CountryExample.Criteria criteria = example.createCriteria();
			//id>=1
			criteria.andIdGreaterThanOrEqualTo(1);
			criteria.andIdLessThan(4);
			criteria.andCountrycodeLike("%U%");
			
			CountryExample.Criteria or = example.or();
			or.andCountrynameEqualTo("中国");
			
			//执行查询
			List<Country> countries = countryMapper.selectByExample(example);
			printCountryList(countries);
			
			
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
			
		}
	}
	
	
	
	

}
