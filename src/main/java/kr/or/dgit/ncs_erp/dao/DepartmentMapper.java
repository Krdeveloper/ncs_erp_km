package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import kr.or.dgit.ncs_erp.dto.Department;

public interface DepartmentMapper {
	List<Department> selectDepartmentByAll();
}
