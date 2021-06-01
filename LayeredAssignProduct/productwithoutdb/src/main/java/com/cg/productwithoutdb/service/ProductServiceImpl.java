package com.cg.productwithoutdb.service;

import java.util.List;

import com.cg.customerwithoutdb.entities.Customer;
import com.cg.customerwithoutdb.exceptions.InvalidCustomerAgeException;
import com.cg.customerwithoutdb.exceptions.InvalidCustomerIdException;
import com.cg.customerwithoutdb.exceptions.InvalidCustomerNameException;
import com.cg.productwithoutdb.dao.IProductDao;
import com.cg.productwithoutdb.dao.ProductDaoImp;
import com.cg.productwithoutdb.entities.Product;
import com.cg.productwithoutdb.exceptions.InvalidProductIdException;
import com.cg.productwithoutdb.exceptions.InvalidProductNameException;
import com.cg.productwithoutdb.exceptions.InvalidProductPriceException;

public class ProductServiceImpl implements IProductService{
	private IProductDao dao = new ProductDaoImp();
	@Override
	public Product add(String name, double price) {
		validateName(name);
		validatePrice(price);
		Product product = new Product(name, price);
		Product saved = dao.add(product);
		return saved;
	}

	@Override
	public Product changePrice(int pid, int price) {
		validateId(pid);
		validatePrice(price);
		Product product = dao.findById(pid);
		product.setPrice(price);
		Product saved = dao.update(product);
		return saved;
	}

	@Override
	public Product findById(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	void validateId(int id) {
		if (id < 0) {
			throw new InvalidProductIdException("id can't be negative");
		}
	}

	void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidProductNameException("Name can't be null or empty");
		}

	}

	void validatePrice(double price) {
		if (price < 0) {
			throw new InvalidProductPriceException("Price can't be negative");
		}

	}

}
