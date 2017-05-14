package kr.or.dgit.ncs_erp;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.ncs_erp.dto.Employee;
import kr.or.dgit.ncs_erp.service.EmployeeService;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeTest {
	private static  EmployeeService employeeService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		employeeService = new EmployeeService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		employeeService = null;
	}

	
	
	/*@Test
	public void AtestInsert() {
		Employee employee = new Employee("3", "ins1", new Title("3"), 2000000, false, new Department("2"), "2017-03-03");
		int res=employeeService.getInstance().insertEmployeeItem(employee);
		Assert.assertEquals(1, res);
	}*/
	/*@Test
	public void BtestUpdate() {
		Employee employee = new Employee("3", "up1", new Title("2"), 2300000, true, new Department("2"), "2017-03-03");
		int res=employeeService.getInstance().updateEmployeeItem(employee);
		Assert.assertEquals(1, res);
	}*/
	/*@Test
	public void CtestDelete() {
		Employee employee = new Employee();
		employee.setNo("3");
		int res=employeeService.getInstance().deleteEmployeeItem(employee);
		Assert.assertEquals(1, res);
	}*/
	@Test
	public void DtestSelectEmployeeByAll() {
		List<Employee> lists  = employeeService.selectEmployeeByAll();
		Assert.assertNotNull(lists);		
		for(Employee employee : lists){
			Assert.assertNotNull(employee);			
		}
		
	}
	@Test
	public void EtestSelectByNo() {
		Employee employee = new Employee();
		employee.setNo("2");
		
		Employee findEmp = employeeService.selectByNo(employee);
		Assert.assertNotNull(findEmp);
		
		
	}

}
