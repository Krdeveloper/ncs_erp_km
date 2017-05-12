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
}
