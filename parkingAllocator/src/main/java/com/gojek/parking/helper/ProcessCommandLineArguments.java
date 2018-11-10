package com.gojek.parking.helper;

import org.apache.log4j.Logger;

import com.gojek.parking.ParkinglotAllocator;
import com.gojek.parking.constans.ParkingLotConstants;
import com.gojek.parking.service.ProcessParkingRequest;

public class ProcessCommandLineArguments {

	final static Logger log = Logger.getLogger(ProcessCommandLineArguments.class);


	public void ProcessCommandLineArguments(String commandLineArgument)
	{
		String[] inputCommand = commandLineArgument.split(" ");

		if(inputCommand[0].equals(ParkingLotConstants.CREATE_PARKING_LOT))
		{

			ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();
			newParkingCreator.createParkingLot(Integer.parseInt(inputCommand[1]));
			log.info("New Parking Space has been created sucessfully..!!");

		}

		if(inputCommand[0].equals(ParkingLotConstants.PARK))
		{

			ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();

			newParkingCreator.parkNewVehicle(inputCommand[1], inputCommand[2]);

		}

		if(inputCommand[0].equals(ParkingLotConstants.STATUS))
		{

			ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();
			newParkingCreator.getParkingStatus();

		}


		if(inputCommand[0].equals(ParkingLotConstants.LEAVE))
		{

			ProcessParkingRequest newParkingCreator = new ProcessParkingRequest();
			newParkingCreator.removeParkedVehicle(Integer.parseInt( inputCommand[1]));

		}



	}
}
