/**
 * 
 */
package net.zjwu.mis.test.service;

import net.zjwu.mis.BaseTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lay
 *
 */
public class TestServiceTest extends BaseTest {

	@Autowired
	private TestService testService;

//	@Test
//	public void testGetTestByNo() {
//		net.zjwu.mis.test.model.Test test = testService.getTestByNo("123");
//		System.out.println("my name is: " + test.getName());
//	}
	
//	@Test
//	@Rollback(false)
//	public void testInsert(){
//		net.zjwu.mis.test.model.Test test = new net.zjwu.mis.test.model.Test();
//		test.setNo("1234");
//		test.setName("test");
//		testService.createTest(test);
//	}
	
//	@Test
//	@Rollback(false)
//	public void testUpdate(){
//		net.zjwu.mis.test.model.Test test = testService.getTestByNo("123");
//		test.setName("test updated");
//		testService.updateTest(test);
//	}
	
	@Test
	@Rollback(false)
	public void testDelete(){
//		net.zjwu.mis.test.model.Test test = testService.getTestByNo("123");
//		testService.deleteTest(test.getId());
		testService.deleteByNo("1234");
	}

}
