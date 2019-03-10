package kr.ayukawa.springaop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
	@Test
	public void testProduct() {
		final String name = "연필";
		final double price = 1000.0;

		// 빈 생성자로 생성 후, Setter/Getter 정상 동작 확인
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);

		assertEquals(name, product.getName());
		assertEquals(price, product.getPrice());

		// 파라미터 있는 생성자로 생성 후, Getter를 이용해 정상 대입되는지 확인
		Product product2 = new Product(name, price);

		assertEquals(name, product2.getName());
		assertEquals(price, product2.getPrice());
	}
}
