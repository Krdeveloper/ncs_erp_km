package kr.or.dgit.ncs_erp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.ncs_erp.dao.TitleMapper;
import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.service.TitleService;

public class TitleTest {
	private static  TitleService titleService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		titleService = new TitleService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		titleService = null;
	}

	@Test
	public void testSelectTitleByAll() {
		List<Title> lists  = titleService.selectTitleByAll();
		Assert.assertNotNull(lists);		
		for(Title title : lists){
			Assert.assertNotNull(title);			
		}
		
	}

}
