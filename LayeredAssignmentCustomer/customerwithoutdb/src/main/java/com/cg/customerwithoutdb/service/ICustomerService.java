package com.cg.customerwithoutdb.service;

import java.util.List;

import com.cg.customerwithoutdb.entities.Customer;

public interface ICustomerService {

	Customer add(String name, int age);

	Customer changeAge(int cid, int age);

	Customer findById(int cid);

	List<Customer> findAll();
}
