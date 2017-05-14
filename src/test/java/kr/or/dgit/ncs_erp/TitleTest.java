package kr.or.dgit.ncs_erp;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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
	/*@Test
	public void testInsert() {
		Title title = new Title("6", "ins1");
		int res=titleService.getInstance().insertTitleItem(title);
		Assert.assertEquals(1, res);
	}*/
	/*@Test
	public void testUpdate() {
		Title title = new Title("6", "up1");
		int res=titleService.getInstance().updateTitleItem(title);
		Assert.assertEquals(1, res);
	}*/
	/*@Test
	public void testDelete() {
		Title title = new Title();
		title.setNo("6");
		int res=titleService.getInstance().deleteTitleItem(title);
		Assert.assertEquals(1, res);
	}*/

}
