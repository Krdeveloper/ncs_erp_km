package kr.or.dgit.ncs_erp;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import kr.or.dgit.nrc_erp.util.MyBatisSqlSessionFactory;

public class MybatisSqlSessionTest {
	private static SqlSessionFactory factory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = MyBatisSqlSessionFactory.getSqlSessionFactory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		factory = null;
	}


	@Test
	public void testFactory() {
		System.out.println(factory.openSession());		
		Assert.assertNotNull(factory.openSession());
	}

}
