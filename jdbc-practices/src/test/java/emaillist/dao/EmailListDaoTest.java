package emaillist.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import emaillist.vo.EmaillistVo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmailListDaoTest {
	private static int count = 0;

	@BeforeAll
	public static void setUp() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		count = list.size();
	}
	
	@Test
	@Order(1)
	public void testInsert() {
		EmaillistVo vo = new EmaillistVo();
		vo.setFirstName("둘");
		vo.setLastName("리");
		vo.setEmail("dooly@gmail.com");
		
		boolean result = new EmaillistDao().insert(vo);
		assertTrue(result);
	}
	
	@Test
	@Order(2)
	public void testFindAll() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		assertEquals(count+1, list.size());
	}
	
	@Test
	@Order(3)
	public void testDeleteByEmail() {
		boolean result = new EmaillistDao().deleteByEmail("dooly@gmail.com");
		assertTrue(result);
	}

	@AfterAll
	public static void cleanup() {
	}
}
