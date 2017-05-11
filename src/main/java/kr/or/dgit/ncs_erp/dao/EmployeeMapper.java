package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import kr.or.dgit.ncs_erp.dto.Employee;

public interface EmployeeMapper {
	List<Employee> selectEmployeeByAll();
}
