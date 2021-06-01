package com.cg.customerwithoutdb.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
	public InvalidCustomerIdException(String msg) {
		super(msg);
	}
}
