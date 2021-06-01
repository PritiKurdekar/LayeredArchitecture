package com.cg.customerwithoutdb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.cg.customerwithoutdb.entities.Customer;
public class AppMain {
	private HashMap<Integer, Customer> store=new HashMap<>();
	
	public static void main(String args[]){
        AppMain app=new AppMain();
        app.start();
	}
	 int generatedId;

	 public int generateId(){
	        return ++generatedId;
	 } 
	 private void start() {
		Customer priti=new Customer("Priti",22);
		Customer tom=new Customer("Tom",25);
		addCustomer(priti);
		addCustomer(tom);
        System.out.println("Display all Customers");
        List<Customer>all= findAll();
        displayCustomers(all);

        System.out.println("Find Customer by id");
        int pritiId=priti.getId();
        Customer fetched=findById(pritiId);
        display(fetched);
		
	}
	 public void addCustomer(Customer customer){
	        int newId=generateId();
	        customer.setId(newId);
	        store.put(newId,customer);
	    }

	    public Customer findById(int id){
	    	Customer customer =store.get(id);
	       return customer;
	    }	   
	    public List<Customer> findAll(){
	        Collection<Customer>customers =store.values();
	        List<Customer>list=new ArrayList<>(customers);
	        return list;
	     }
	    void display(Customer customer){
	        System.out.println(customer.getId()+"-"+customer.getName()+"-"+ customer.getAge());
	    }
	    void displayCustomers(Collection<Customer>customers){
	        for(Customer cus:customers){
	            display(cus);
	        }
	    }
	
}
