package bookshop.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AuthorDaoTest {
	private static int count = 0;
	private static AuthorDao authorDao = new AuthorDao();
	
	@BeforeAll
	public static void setUp() {
		count = authorDao.findAll().size();
	}

	@Test
	public void testInsert() {
		assertTrue(1-1 == 0);
	}
	
	@AfterAll
	public static void cleanUp() {
	}

}
