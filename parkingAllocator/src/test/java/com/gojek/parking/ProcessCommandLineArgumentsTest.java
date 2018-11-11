package com.gojek.parking;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojek.parking.helper.ProcessCommandLineArguments;

/**
 * Unit Test for Command Line Input
 * @author shashi
 *
 */
public class ProcessCommandLineArgumentsTest {

	
	ProcessCommandLineArguments parkingLot = new ProcessCommandLineArguments();
	
	
	@Test
	public void testcreateParkingLot() throws Exception {

		parkingLot.ProcessCommandLineArguments("create_parking_lot 6");

	}
	
	@Test
	public void testparkVehicle() throws Exception {

		parkingLot.ProcessCommandLineArguments("park KA-01-HH-1234 White");

	}
	
	@Test
	public void testgetStatus() throws Exception {

		parkingLot.ProcessCommandLineArguments("status");

	}
	
	
	@Test
	public void testremoveVehicle() throws Exception {

		parkingLot.ProcessCommandLineArguments("leave 1");

	}
	
	@Test
	public void testgetregistrationbyColor() throws Exception {

		parkingLot.ProcessCommandLineArguments("registration_numbers_for_cars_with_colour White");

	}
	
	@Test
	public void testslotbyColor() throws Exception {

		parkingLot.ProcessCommandLineArguments("slot_numbers_for_cars_with_colour White");

	}
	
	@Test
	public void testslotbyRegistrationNumber() throws Exception {

		parkingLot.ProcessCommandLineArguments("slot_number_for_registration_number KA-01-HH-3141");

	}
	
	

}
