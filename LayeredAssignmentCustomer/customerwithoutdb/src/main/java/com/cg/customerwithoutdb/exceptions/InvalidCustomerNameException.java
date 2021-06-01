package com.cg.customerwithoutdb.exceptions;

public class InvalidCustomerNameException extends RuntimeException{
	public InvalidCustomerNameException(String msg) {
		super(msg);
	}
}
