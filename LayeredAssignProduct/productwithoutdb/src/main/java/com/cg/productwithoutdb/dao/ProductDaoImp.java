package com.cg.productwithoutdb.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.productwithoutdb.entities.Product;

public class ProductDaoImp implements IProductDao{
	private Map<Integer, Product>store = new HashMap<>();

    private int generatedId;

    int generateId(){
        return ++generatedId;
    }
	
	@Override
    public List<Product> findAll() {
        Collection<Product>products =store.values();
        List<Product>list=new ArrayList<>(products);
        return list;
    }
	@Override
	public Product add(Product product) {
		int newId=generateId();
		product.setId(newId);
        store.put(newId,product);
        return product;
	}
	@Override
	public Product update(Product product) {
		int id=product.getId();
        store.put(id,product);
        return product;
	}
	@Override
	public Product findById(int id) {
		Product product =store.get(id);
        return product;
	}
}
