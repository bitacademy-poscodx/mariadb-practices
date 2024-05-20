package bookshop.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import bookshop.vo.AuthorVo;
import bookshop.vo.BookVo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookDaoTest {
	private static int count = 0;
	private static AuthorVo mockAuthorVo = new AuthorVo();
	private static BookVo mockBookVo = new BookVo();
	
	private static AuthorDao authorDao = new AuthorDao();
	private static BookDao bookDao = new BookDao();
	
	@BeforeAll
	public static void setUp() {
		mockAuthorVo.setName("칼세이건");
		authorDao.insert(mockAuthorVo);
		
		count = bookDao.findAll().size();
	}
	
	@Test
	@Order(1)
	public void testInsert() {
		mockBookVo.setTitle("코스모스");
		mockBookVo.setAuthorNo(mockAuthorVo.getNo());
		bookDao.insert(mockBookVo);
		
		assertNotNull(mockBookVo.getNo());
	}
	
	@Test
	@Order(2)
	public void testFindAll() {
		assertEquals(count + 1, bookDao.findAll().size());
	}
	
	@Test
	@Order(3)
	public void testUpdate() {
		assertEquals(1, bookDao.update(mockBookVo.getNo(), "대여중"));
	}
	
	@AfterAll
	public static void cleanUp() {
		bookDao.deleteByNo(mockBookVo.getNo());
		authorDao.deleteByNo(mockAuthorVo.getNo());
	}
}
