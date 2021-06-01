package com.cg.customerwithoutdb.service;

import com.cg.customerwithoutdb.entities.Customer;
import com.cg.customerwithoutdb.exceptions.InvalidCustomerAgeException;
import com.cg.customerwithoutdb.exceptions.InvalidCustomerIdException;
import com.cg.customerwithoutdb.exceptions.InvalidCustomerNameException;
import com.cg.customerwithoutdb.dao.ICustomerDao;

import java.util.List;

import com.cg.customerwithoutdb.dao.CustomerDaoImp;

public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao dao = new CustomerDaoImp();

	@Override
	public Customer add(String name, int age) {
		validateName(name);
		validateSalary(age);
		Customer customer = new Customer(name, age);
		Customer saved = dao.add(customer);
		return saved;
	}

	@Override
	public Customer changeAge(int cid, int age) {
		validateId(cid);
		validateSalary(age);
		Customer customer = dao.findById(cid);
		customer.setAge(age);
		Customer saved = dao.update(customer);
		return saved;
	}

	@Override
	public Customer findById(int cid) {
		validateId(cid);
		Customer customer = dao.findById(cid);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> list = dao.findAll();
		return list;
	}

	void validateId(int id) {
		if (id < 0) {
			throw new InvalidCustomerIdException("id can't be negative");
		}
	}

	void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidCustomerNameException("Name can't be null or empty");
		}

	}

	void validateSalary(int age) {
		if (age < 0) {
			throw new InvalidCustomerAgeException("Age can't be negative");
		}

	}

}
