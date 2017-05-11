package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs_erp.dto.Department;

public class DepartmentMapperImpl implements DepartmentMapper {
	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(DepartmentMapperImpl.class);
	private String nameSpace = "kr.or.dgit.ncs_erp.dao.DepartmentMapper.";
	
	public DepartmentMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Department> selectDepartmentByAll() {
		log.debug("selectDepartmentByAll()");
		return sqlSession.selectList(nameSpace + "selectDepartmentByAll");
	}

}
