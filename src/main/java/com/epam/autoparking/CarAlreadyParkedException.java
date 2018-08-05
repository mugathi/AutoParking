package com.epam.autoparking;

public class CarAlreadyParkedException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarAlreadyParkedException(String message) {
		super(message);
	}
}
