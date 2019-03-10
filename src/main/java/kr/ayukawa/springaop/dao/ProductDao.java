package kr.ayukawa.springaop.dao;

import kr.ayukawa.springaop.model.Product;

import java.util.List;

public interface ProductDao {
	void insert(Product p);
	void remove(String name);
	Product findByName(String name);
	List<Product> findAllProducts();
}
