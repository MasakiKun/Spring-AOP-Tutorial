package kr.ayukawa.springaop;

import kr.ayukawa.springaop.config.AppConfig;
import kr.ayukawa.springaop.dao.ProductDao;
import kr.ayukawa.springaop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EntryPoint {
	@Autowired
	ProductDao dao;

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EntryPoint ep = ctx.getBean("entryPoint", EntryPoint.class);
		ep.execute();
	}

	public void execute() {
		Product pencil = new Product("연필", 1000);
		Product sharp = new Product("샤프", 1300);
		Product ballpen = new Product("볼펜", 2000);

		dao.insert(pencil);
		dao.insert(sharp);
		dao.insert(ballpen);

		System.out.println(dao.findAllProducts());
	}
}
