package com.cg.customerwithoutdb.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.customerwithoutdb.entities.Customer;

public class CustomerDaoImp implements ICustomerDao {
	private Map<Integer, Customer>store = new HashMap<>();

    private int generatedId;

    int generateId(){
        return ++generatedId;
    }
	@Override
	public Customer add(Customer customer) {
		int newId=generateId();
		customer.setId(newId);
        store.put(newId,customer);
        return customer;
	}

	@Override
	public Customer update(Customer customer) {
		int id=customer.getId();
        store.put(id,customer);
        return customer;
	}

	@Override
	public Customer findById(int id) {
		Customer customer =store.get(id);
        return customer;
	}
	@Override
    public List<Customer> findAll() {
        Collection<Customer>customers =store.values();
        List<Customer>list=new ArrayList<>(customers);
        return list;
    }

}
