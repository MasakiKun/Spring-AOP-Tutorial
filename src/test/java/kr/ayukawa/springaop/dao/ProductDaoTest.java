package kr.ayukawa.springaop.dao;

import kr.ayukawa.springaop.model.Product;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductDaoTest {
	@Test
	public void testProductDao() {
		Product pencil = new Product("연필", 1000);
		Product sharp = new Product("샤프", 1200);
		Product ballpen = new Product("볼펜", 2000);

		ProductDao dao = new ProductDaoImpl();

		// 연필 추가 후 확인
		dao.insert(pencil);
		assertEquals(pencil, dao.findByName("연필"));

		// 샤프 추가 후 확인
		dao.insert(sharp);
		assertEquals(sharp, dao.findByName("샤프"));

		// 볼펜 추가 후 확인
		dao.insert(ballpen);
		assertEquals(ballpen, dao.findByName("볼펜"));

		// 추가된 아이템은 3개인가?
		assertEquals(3, dao.findAllProducts().size());

		// 샤프 삭제 후, 올바르게 삭제되었는지 확인한다
		dao.remove("샤프");
//		assertEquals(new Product().toString(), dao.findByName("샤프").toString());
		assertThrows(Exception.class, () -> dao.findByName("샤프"));

		// 사프를 삭제했으니 아이템은 2개인가?
		assertEquals(2, dao.findAllProducts().size());

		// 연필은 잘 조회되는가?
		assertEquals(pencil.toString(), dao.findByName("연필").toString());
	}
}
