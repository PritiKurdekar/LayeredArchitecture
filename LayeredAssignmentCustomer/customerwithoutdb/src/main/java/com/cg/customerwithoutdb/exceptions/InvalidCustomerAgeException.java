package com.cg.customerwithoutdb.exceptions;

public class InvalidCustomerAgeException extends RuntimeException{
	public InvalidCustomerAgeException(String msg) {
		super(msg);
	}
}
