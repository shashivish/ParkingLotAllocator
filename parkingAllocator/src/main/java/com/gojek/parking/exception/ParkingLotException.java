package com.gojek.parking.exception;

/**
 * This class provides a convenient and customized exception for instances of invalid configuration options.
 *
 * @author Shashi Vishwakarma
 */

public class ParkingLotException extends Exception{

	private static final long serialVersionUID = 1L;

	public ParkingLotException(String message) {
		super(message);
	}

}
