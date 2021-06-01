package com.cg.productwithoutdb.exceptions;

public class InvalidProductPriceException extends RuntimeException{
	public InvalidProductPriceException(String msg) {
		super(msg);
	}

}
