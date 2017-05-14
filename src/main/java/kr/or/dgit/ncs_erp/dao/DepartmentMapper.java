package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Title;

public interface DepartmentMapper {
	List<Department> selectDepartmentByAll();
	int insertDepartmentItem (Department department);//db table입력
	int updateDepartmentItem (Department department);//db table 값수정
	int deleteDepartmentItem (Department department);//delete one of the table's item
}
