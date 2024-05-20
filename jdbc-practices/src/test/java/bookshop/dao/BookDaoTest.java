package bookshop.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import bookshop.vo.AuthorVo;
import bookshop.vo.BookVo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookDaoTest {
	private static int count = 0;
	private static AuthorVo mockAuthorVo = new AuthorVo();
	
	private static AuthorDao authorDao = new AuthorDao();
	private static BookDao bookDao = new BookDao();
	
	@BeforeAll
	public static void setUp() {
		mockAuthorVo.setName("칼세이건");
		authorDao.insert(mockAuthorVo);
		
		count = bookDao.findAll().size();
	}
	
	@Test
	public void testInsert() {
		BookVo vo = new BookVo();
		vo.setTitle("코스모스");
		vo.setAuthorNo(mockAuthorVo.getNo());
		bookDao.insert(vo);
		
		assertNotNull(vo.getNo());
	}
	
	public void testFindAll() {
		assertEquals(count + 1, bookDao.findAll().size());
	}
	
	@AfterAll
	public static void cleanUp() {
		// authorDao.deleteByNo(mockAuthorVo.getNo());
	}
}
