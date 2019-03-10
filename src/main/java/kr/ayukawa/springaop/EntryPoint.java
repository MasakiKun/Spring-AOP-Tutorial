package kr.ayukawa.springaop;

import kr.ayukawa.springaop.dao.ProductDao;
import kr.ayukawa.springaop.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntryPoint {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		Product pencil = new Product("연필", 1000);
		Product sharp = new Product("샤프", 1300);
		Product ballpen = new Product("볼펜", 2000);

		ProductDao dao = ctx.getBean("productDao", ProductDao.class);

		dao.insert(pencil);
		dao.insert(sharp);
		dao.insert(ballpen);

		System.out.println(dao.findAllProducts());
	}
}
