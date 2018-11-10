package com.gojek.parking.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.gojek.parking.doa.Car;

public class ProcessParkingRequest {

	static Map<Integer,Car> PARKINGSPACEHOLDER  = new HashMap<Integer, Car>();


	public void createParkingLot(int parkingLotSize)
	{
		/**
		 * Initialize All Parking Space with Null values
		 */
		for(int parkingSpaceCounter =1 ; parkingSpaceCounter <= parkingLotSize ; parkingSpaceCounter ++)
		{
			PARKINGSPACEHOLDER.put(parkingSpaceCounter, null);

		}

	}

	public void parkNewVehicle(String registratioNumber , String vehicleColor )
	{
		Iterator parkingItr = PARKINGSPACEHOLDER.entrySet().iterator();

		while(parkingItr.hasNext())
		{
			Entry<Integer , Car > pair = (Entry<Integer, Car>) parkingItr.next();

			System.out.println("Getting Key " + pair.getKey());
			System.out.println( "Getting value  " + pair.getValue());


		}

	}


}
