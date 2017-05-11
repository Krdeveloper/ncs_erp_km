package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs_erp.dto.Employee;

public class EmployeeMapperImpl implements EmployeeMapper {
	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(EmployeeMapperImpl.class);
	private String nameSpace = "kr.or.dgit.ncs_erp.dao.EmployeeMapper.";
	
	public EmployeeMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Employee> selectEmployeeByAll() {
		log.debug("selectEmployeeByAll()");
		return sqlSession.selectList(nameSpace + "selectEmployeeByAll");
	}

}
