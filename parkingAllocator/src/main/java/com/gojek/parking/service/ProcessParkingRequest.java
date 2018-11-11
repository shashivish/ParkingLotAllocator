package com.gojek.parking.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.gojek.parking.ParkinglotAllocator;
import com.gojek.parking.doa.Car;

public class ProcessParkingRequest {

	final static Logger log = Logger.getLogger(ProcessParkingRequest.class);
	
	//Creatr Parking Space Object Holder
	static Map<Integer,Car> PARKINGSPACEHOLDER  = new HashMap<Integer, Car>();


	/**
	 * Initialize Empty Parking Area
	 * @param parkingLotSize
	 */
	public void createParkingLot(int parkingLotSize)
	{
		/**
		 * Initialize All Parking Space with Null values
		 */
		for(int parkingSpaceCounter =1 ; parkingSpaceCounter <= parkingLotSize ; parkingSpaceCounter ++)
		{
			PARKINGSPACEHOLDER.put(parkingSpaceCounter, null);
			log.info("Created a parking lot with "+parkingLotSize +" slots");

		}

	}

	/**
	 * Park New Vehicle of given Rgistration Number and Vehicle Color for Granting Ticket
	 * @param registratioNumber
	 * @param vehicleColor
	 */
	public void parkNewVehicle(String registratioNumber , String vehicleColor )
	{
		Iterator parkingItr = PARKINGSPACEHOLDER.entrySet().iterator();
		boolean checkParkingSpaceIsFull = false;

		while(parkingItr.hasNext())
		{
			Entry<Integer , Car > parkingInformation = (Entry<Integer, Car>) parkingItr.next();

			System.out.println("Getting Key " + parkingInformation.getKey());
			System.out.println( "Getting value  " + parkingInformation.getValue());

			if(parkingInformation.getValue()  == null)
			{
				Car car = new Car();
				car.setCarColor(vehicleColor);
				car.setCarRegistrationNumber(registratioNumber);
				PARKINGSPACEHOLDER.put(parkingInformation.getKey(), car);
				checkParkingSpaceIsFull = true;
				log.info("Allocated slot number : " + parkingInformation.getKey());
				break;
			}

		}

		if (checkParkingSpaceIsFull == false)
		{
			log.info("Sorry, parking lot is full");
		}


	}

	/**
	 * Remove Parked vehicle from alloted Parking slot
	 * @param parkingSlotNumber
	 */
	public void removeParkedVehicle(int parkingSlotNumber)
	{

		Iterator parkingItr = PARKINGSPACEHOLDER.entrySet().iterator();
		boolean checkParkingSpaceIsFull = false;

		while(parkingItr.hasNext())
		{
			Entry<Integer , Car > parkingInformation = (Entry<Integer, Car>) parkingItr.next();
			if(parkingInformation.getKey()  == parkingSlotNumber)
			{
				PARKINGSPACEHOLDER.put(parkingInformation.getKey(), null);
				log.info("Slot number " +parkingInformation.getKey() + " is free");
				break;
			}

		}


	}

	/**
	 * Prints Parking status of Parking Area
	 */
	public void getParkingStatus()
	{

		Iterator parkingItr = PARKINGSPACEHOLDER.entrySet().iterator();
		System.out.println("Slot Number \t\t Registration Number \t\t Color ");
		boolean checkIfParkingAreaIsEmpty = true;
		while(parkingItr.hasNext())
		{
			Entry<Integer , Car > parkingInformation = (Entry<Integer, Car>) parkingItr.next();
			if(parkingInformation.getValue() != null)
			{
				System.out.println(parkingInformation.getKey() +"\t\t\t"+ parkingInformation.getValue().getCarRegistrationNumber()
						+ "\t\t\t"+ parkingInformation.getValue().getCarColor());
				checkIfParkingAreaIsEmpty = false;
			}

		}

		if(checkIfParkingAreaIsEmpty)
		{
			log.info("No Vehicle is Parked. Parking area is empty");
		}

	}


	public String getRegistrationNumberByColor(String color)
	{

		return "";
	}

	public int getSlotNumberByRegistrationNumber(String carRegistrationNubmer)
	{
		return 0;

	}




}
