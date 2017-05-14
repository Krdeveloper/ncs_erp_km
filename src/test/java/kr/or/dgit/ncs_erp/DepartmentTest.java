package kr.or.dgit.ncs_erp;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.ncs_erp.dto.Department;
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
	/*@Test
	public void testInsert() {
		Department department = new Department("6", "deptins1",99);
		int res=departmentService.getInstance().insertDepartmentItem(department);
		Assert.assertEquals(1, res);
	}*/
	/*@Test
	public void testUpdate() {
		Department department = new Department("6", "deptup1",88);
		int res=departmentService.getInstance().updateDepartmentItem(department);
		Assert.assertEquals(1, res);
	}*/
	/*@Test
	public void testDelete() {
		Department department = new Department();
		department.setNo("6");
		int res=departmentService.getInstance().deleteDepartmentItem(department);
		Assert.assertEquals(1, res);
	}*/


}
