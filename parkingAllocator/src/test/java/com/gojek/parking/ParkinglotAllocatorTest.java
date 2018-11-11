package com.gojek.parking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parking.helper.ProcessCommandLineArguments;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



/**
 * Unit test for ParkingLotAllocator
 */
public class ParkinglotAllocatorTest 
{


	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}



}
