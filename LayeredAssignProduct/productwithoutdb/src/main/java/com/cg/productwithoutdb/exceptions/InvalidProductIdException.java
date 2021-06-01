package com.cg.productwithoutdb.exceptions;

public class InvalidProductIdException extends RuntimeException{
	public InvalidProductIdException(String msg) {
		super(msg);
	}

}
