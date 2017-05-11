package kr.or.dgit.ncs_erp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs_erp.dao.DepartmentMapper;
import kr.or.dgit.ncs_erp.dao.DepartmentMapperImpl;
import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.nrc_erp.util.MyBatisSqlSessionFactory;

public class DepartmentService {
	public static final DepartmentService instance = new DepartmentService();
	public DepartmentService() {}
	public static DepartmentService getInstance(){
		return instance;
	}
	
	public List<Department> selectDepartmentByAll() {//department 테이블 모든값
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			return departmentMapper.selectDepartmentByAll();
		} 
	}
}
