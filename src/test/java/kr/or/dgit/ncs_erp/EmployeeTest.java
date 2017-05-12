package kr.or.dgit.ncs_erp;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.ncs_erp.dto.Employee;
import kr.or.dgit.ncs_erp.service.EmployeeService;

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

	@Test
	public void testSelectEmployeeByAll() {
		List<Employee> lists  = employeeService.selectEmployeeByAll();
		Assert.assertNotNull(lists);		
		for(Employee employee : lists){
			Assert.assertNotNull(employee);			
		}
		
	}

}
