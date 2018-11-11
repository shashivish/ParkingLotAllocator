package com.gojek.parking.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.gojek.parking.constans.ParkingLotConstants;
import com.gojek.parking.exception.ParkingLotException;
import com.gojek.parking.service.ProcessParkingRequest;

public class ProcessCommandLineArguments {

	final static Logger log = Logger.getLogger(ProcessCommandLineArguments.class);




	public void ProcessCommandLineArguments(String commandLineArgument) throws NumberFormatException, ParkingLotException
	{
		String[] inputCommand = commandLineArgument.split(" ");
		try
		{
			/**
			 * Create a Parking Space
			 */
			if(inputCommand[0].equals(ParkingLotConstants.CREATE_PARKING_LOT))
			{

				ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();
				newParkingCreator.createParkingLot(Integer.parseInt(inputCommand[1]));
				log.info("New Parking Space has been created sucessfully..!!");

			}
		}catch(Exception e)
		{
			throw new ParkingLotException("Unable to create a Parking lot " + e.getMessage());
		}


		/**
		 * Park Vehicle
		 */
		try {
			if(inputCommand[0].equals(ParkingLotConstants.PARK))
			{

				ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();

				newParkingCreator.parkNewVehicle(inputCommand[1], inputCommand[2]);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ParkingLotException("Unable to Park Vehicle . Please Check input and try again" + e.getMessage());
		}

		/**
		 * Get Status of Parking Area
		 */
		try {
			if(inputCommand[0].equals(ParkingLotConstants.STATUS))
			{

				ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();
				newParkingCreator.getParkingStatus();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ParkingLotException("Unable to get status . Please Check input and try again" + e.getMessage());
		}


		/**
		 * Remove Vehicle from  Parking Area
		 */
		try {
			if(inputCommand[0].equals(ParkingLotConstants.LEAVE))
			{

				ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();
				newParkingCreator.removeParkedVehicle(Integer.parseInt( inputCommand[1]));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ParkingLotException("Unable to Remove Vehicle . Please Check input and try again" + e.getMessage());
		}

		/**
		 * Get Registration number by color
		 */
		try {
			if(inputCommand[0].equals(ParkingLotConstants.REGISTRATION_NUMBERS_FOR_CAR_WITH_COLORS))
			{

				ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();
				newParkingCreator.getRegistrationNumberByColor(( inputCommand[1]));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new ParkingLotException("Unable to get registrations numbers by color . Please Check input and try again" + e.getMessage());
		}


		/**
		 * Get slots by color
		 */
		try {
			if(inputCommand[0].equals(ParkingLotConstants.SLOT_NUMBERS_FOR_CAR_WITH_COLOR))
			{

				ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();
				newParkingCreator.getSlotsNumberbyColor(( inputCommand[1]));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ParkingLotException("Unable to Slot number by color . Please Check input and try again" + e.getMessage());
		}


		/**
		 * Get Slot number by registration number
		 */
		try {
			if(inputCommand[0].equals(ParkingLotConstants.SLOT_NUMBERS_FOR_REGISTRATION_NUMBER))
			{

				ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();
				newParkingCreator.getSlotNumberByRegistrationNumber(( inputCommand[1]));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ParkingLotException("Unable to get slot number by registration number . Please Check input and try again" + e.getMessage());
		}



	}

	public void commandLineFileParser(String filePath) throws NumberFormatException, ParkingLotException
	{

		
		File inputParkingLotFile = new File(filePath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputParkingLotFile));
			String line;
			try {
				while ((line = br.readLine()) != null) {
					ProcessCommandLineArguments(line.trim());
				}
			} catch (IOException ex)
			{
				ex.printStackTrace();
				throw new ParkingLotException("File IO Exception " + ex.getMessage());

			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new ParkingLotException("File not found " + e.getMessage());

		}
	}
}
