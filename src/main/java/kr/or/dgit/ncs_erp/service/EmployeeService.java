package kr.or.dgit.ncs_erp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs_erp.dao.EmployeeMapper;
import kr.or.dgit.ncs_erp.dao.EmployeeMapperImpl;
import kr.or.dgit.ncs_erp.dto.Employee;
import kr.or.dgit.nrc_erp.util.MyBatisSqlSessionFactory;

public class EmployeeService {
	public static final EmployeeService instance = new EmployeeService();
	public EmployeeService() {}
	public static EmployeeService getInstance(){
		return instance;
	}
	
	public List<Employee> selectEmployeeByAll() {//Employee 테이블 모든값
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			return employeeMapper.selectEmployeeByAll();
		} 
	}
	
	public int insertEmployeeItem(Employee employee) {//db table에 입력
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			int res= employeeMapper.insertEmployeeItem(employee);
			sqlSession.commit();
			return res;
		} 
	}

	public int updateEmployeeItem(Employee employee) {//db table값수정
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			int res= employeeMapper.updateEmployeeItem(employee);
			sqlSession.commit();
			return res;
		} 
	}
	public int deleteEmployeeItem(Employee employee) {//delete one of the table's item
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			int res= employeeMapper.deleteEmployeeItem(employee);
			sqlSession.commit();
			return res;
		} 
	}
	public Employee selectByNo(Employee employee) {//no통해 검색
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			return employeeMapper.selectByNo(employee);
		} 
	}
}
