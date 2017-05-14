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
	
	public int insertDepartmentItem(Department department) {//db table에 입력
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res= departmentMapper.insertDepartmentItem(department);
			sqlSession.commit();
			return res;
		} 
	}

	public int updateDepartmentItem(Department department) {//db table값수정
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res= departmentMapper.updateDepartmentItem(department);
			sqlSession.commit();
			return res;
		} 
	}
	public int deleteDepartmentItem(Department department) {//delete one of the table's item
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res= departmentMapper.deleteDepartmentItem(department);
			sqlSession.commit();
			return res;
		} 
	}
}
