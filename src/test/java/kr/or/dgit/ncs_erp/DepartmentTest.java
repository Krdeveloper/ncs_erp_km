package kr.or.dgit.ncs_erp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.service.DepartmentService;

public class DepartmentTest {
	private static  DepartmentService departmentService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		departmentService = new DepartmentService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		departmentService = null;
	}

	@Test
	public void testSelectDepartmentByAll() {
		List<Department> lists  = departmentService.selectDepartmentByAll();
		Assert.assertNotNull(lists);		
		for(Department department : lists){
			Assert.assertNotNull(department);			
		}
		
	}

}
