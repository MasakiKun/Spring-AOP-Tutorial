package kr.ayukawa.springaop.dao;

import kr.ayukawa.springaop.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("productDao")
public class ProductDaoImpl implements ProductDao {
	private List<Product> repo = new ArrayList<>();

	@Override
	public void insert(final Product p) {
		repo.add(p);
	}

	@Override
	public void remove(final String name) {
		Product product = repo.stream()
				.filter(p -> p.getName().equals(name))
				.findFirst()
				.orElse(null);
		this.repo.remove(product);
	}

	@Override
	public Product findByName(final String name) {
		return repo.stream()
				.filter(p -> p.getName().equals(name))
				.findFirst()
				//.orElse(new Product());
				.orElseThrow();
	}

	@Override
	public List<Product> findAllProducts() {
		return List.copyOf(this.repo);
	}
}
