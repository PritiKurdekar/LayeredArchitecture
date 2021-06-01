package com.cg.customerwithoutdb;

import java.util.Collection;
import java.util.List;

import com.cg.customerwithoutdb.entities.Customer;
import com.cg.customerwithoutdb.exceptions.InvalidCustomerAgeException;
import com.cg.customerwithoutdb.exceptions.InvalidCustomerIdException;
import com.cg.customerwithoutdb.exceptions.InvalidCustomerNameException;
import com.cg.customerwithoutdb.service.CustomerServiceImpl;
import com.cg.customerwithoutdb.service.ICustomerService;

public class LayeredMainUI {
	private ICustomerService service=new CustomerServiceImpl();
	
	public static void main(String[] args) {
		LayeredMainUI app=new LayeredMainUI();
        app.start();

	}

	private void start() {
		try {
	           System.out.println("*** add Customers***");
	           service.add("Priti", 22);
	           Customer john = service.add("John", 19);

	           System.out.println("****all Customers");
	           List<Customer> all = service.findAll();
	           displayCustomers(all);

	           System.out.println("*****change salary");
	           int johnId = john.getId();
	           john = service.changeAge(johnId, 26);

	           System.out.println("***all customers after change");
	           all = service.findAll();
	           displayCustomers(all);

	           System.out.println("*** display customer by id");
	           Customer fetched = service.findById(johnId);
	           display(fetched);

	       }catch(InvalidCustomerAgeException e){
	           System.out.println(e.getMessage());
	       }
	       catch(InvalidCustomerIdException e){
	           System.out.println(e.getMessage());
	       }
	        catch(InvalidCustomerNameException e){
	           System.out.println(e.getMessage());
	        }
		
	}
	 void display(Customer customer){
	        System.out.println(customer.getId()+"-"+customer.getName()+"-"+ customer.getAge());
	    }
	    void displayCustomers(Collection<Customer> customers){
	        for(Customer cus:customers){
	            display(cus);
	        }
	    }

}
