package com.cg.customerwithoutdb.dao;

import java.util.List;

import com.cg.customerwithoutdb.entities.Customer;

public interface ICustomerDao {
	
	Customer add(Customer customer);

	Customer update(Customer customer);

    Customer findById(int id);

	List<Customer> findAll();
}
