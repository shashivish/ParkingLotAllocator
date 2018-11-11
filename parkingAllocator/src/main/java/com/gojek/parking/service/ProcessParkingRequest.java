package com.gojek.parking.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.gojek.parking.ParkinglotAllocator;
import com.gojek.parking.doa.Car;
import com.gojek.parking.exception.ParkingLotException;

public class ProcessParkingRequest {

	final static Logger log = Logger.getLogger(ProcessParkingRequest.class);

	/**
	 * Create Parking Space Holder - HashMap
	 */
	static Map<Integer,Car> PARKINGSPACEHOLDER  = new HashMap<Integer, Car>();


	/**
	 * Empty Constructor
	 */
	public ProcessParkingRequest()
	{
		//Do Nothing
	}


	/**
	 * Initialize Empty Parking Area
	 * @param parkingLotSize
	 */
	public void createParkingLot(int parkingLotSize) throws ParkingLotException
	{
		/**
		 * Initialize All Parking Space with Null values
		 */
		for(int parkingSpaceCounter =1 ; parkingSpaceCounter <= parkingLotSize ; parkingSpaceCounter ++)
		{
			PARKINGSPACEHOLDER.put(parkingSpaceCounter, null);
		}
		log.info("Created a parking lot with "+parkingLotSize +" slots");


	}

	/**
	 * Park New Vehicle of given Registration Number and Vehicle Color for Granting Ticket
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


			/**
			 * Check which Parking Space is empty
			 */
			if(parkingInformation.getValue()  == null)
			{

				/**
				 * Create a Car Object
				 */
				Car car = new Car();
				car.setCarColor(vehicleColor);
				car.setCarRegistrationNumber(registratioNumber);


				/**
				 * Park a Car in a Empty Parking Space
				 */
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

		Iterator<Entry<Integer, Car>> parkingItr = PARKINGSPACEHOLDER.entrySet().iterator();

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

		Iterator<Entry<Integer, Car>> parkingItr = PARKINGSPACEHOLDER.entrySet().iterator();
		System.out.println("Slot Number \t\t Registration Number \t\t Color ");
		boolean checkIfParkingAreaIsEmpty = true;
		
		/**
		 * Iterator to List all occupied Parking Slot
		 */
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


	/**
	 *  Get Registration number by color
	 * @param color
	 */
	public void getRegistrationNumberByColor(String color)
	{

		Iterator<Entry<Integer, Car>> parkingItr = PARKINGSPACEHOLDER.entrySet().iterator();
		String registration_numbers_for_cars_with_colour = "";
		while(parkingItr.hasNext())
		{
			Entry<Integer , Car > parkingInformation = (Entry<Integer, Car>) parkingItr.next();
			if(parkingInformation.getValue() != null)
			{
				if (parkingInformation.getValue().getCarColor().toString().equals(color))
				{
					registration_numbers_for_cars_with_colour = registration_numbers_for_cars_with_colour + " " + parkingInformation.getValue().getCarRegistrationNumber() + ",";
				}
			}

		}

		if (registration_numbers_for_cars_with_colour == "") {
			log.info("Not Vehicle for Color " + color);

		}

		log.info( registration_numbers_for_cars_with_colour );


	}


	/**
	 * Get Slot number by Color
	 * @param color
	 */
	public void getSlotsNumberbyColor(String color)
	{

		Iterator<Entry<Integer, Car>> parkingItr = PARKINGSPACEHOLDER.entrySet().iterator();
		String slot_numbers_for_cars_with_colour = "";
		while(parkingItr.hasNext())
		{
			Entry<Integer , Car > parkingInformation = (Entry<Integer, Car>) parkingItr.next();
			if(parkingInformation.getValue() != null)
			{
				/**
				 * Check if Color is matching with requested color
				 */
				if (parkingInformation.getValue().getCarColor().toString().equals(color))
				{
					slot_numbers_for_cars_with_colour = slot_numbers_for_cars_with_colour + " " + parkingInformation.getKey() + ",";
				}
			}

		}

		/**
		 * If No color match is found
		 */
		if (slot_numbers_for_cars_with_colour == "") {
			log.info("Slot not found for Color " + color);

		}
		else
			log.info( "Found  : " +slot_numbers_for_cars_with_colour);


	}


	/**
	 * Get Slot Number by Registration number
	 * @param carRegistrationNubmer
	 */
	public void  getSlotNumberByRegistrationNumber(String carRegistrationNubmer)
	{
		Iterator<Entry<Integer, Car>> parkingItr = PARKINGSPACEHOLDER.entrySet().iterator();
		int slot_number_for_registration_number = 0;
		
		
		while(parkingItr.hasNext())
		{
			Entry<Integer , Car > parkingInformation = (Entry<Integer, Car>) parkingItr.next();
			if(parkingInformation.getValue() != null)
			{
				if (parkingInformation.getValue().getCarRegistrationNumber().equals(carRegistrationNubmer))
				{
					slot_number_for_registration_number = parkingInformation.getKey();
				}
			}

		}

		if (slot_number_for_registration_number == 0) {
			log.info("No Vehicle for Registration Number  " + carRegistrationNubmer);

		}
		else	
			log.info ("Found : " +slot_number_for_registration_number);

	}



}
