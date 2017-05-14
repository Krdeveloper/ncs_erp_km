package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Employee;

public interface EmployeeMapper {
	List<Employee> selectEmployeeByAll();
	int insertEmployeeItem (Employee employee);//db table입력
	int updateEmployeeItem (Employee employee);//db table 값수정
	int deleteEmployeeItem (Employee employee);//delete one of the table's item
	Employee selectByNo(Employee employee);
}
