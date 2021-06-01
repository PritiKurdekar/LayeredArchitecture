package com.cg.productwithoutdb.service;

import java.util.List;

import com.cg.productwithoutdb.entities.Product;

public interface IProductService {
	Product add(String name, double price);

	Product changePrice(int pid, int price);

	Product findById(int pid);

	List<Product> findAll();
}
