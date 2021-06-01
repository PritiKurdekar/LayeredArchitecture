package com.cg.productwithoutdb.dao;

import java.util.List;

import com.cg.productwithoutdb.entities.Product;

public interface IProductDao {
	Product add(Product customer);

	Product update(Product customer);

	Product findById(int id);

	List<Product> findAll();
}
