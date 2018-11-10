package com.gojek.parking;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.gojek.parking.doa.Car;
import com.gojek.parking.exception.ParkingLotException;


/**
 * @author Shashi Vishwakarma
 * @Desciption : Program to allocate Parking Slot.
 *
 */
public class ParkinglotAllocator 
{
	final static Logger log = Logger.getLogger(ParkinglotAllocator.class);

	public static void main( String[] args ) throws IOException ,ParkingLotException
	{

		log.info("Welcome to GoJek Parking Lot");	

		/**
		 * Check with Interactive or File approach is required to Solve problem. 	
		 */
		if (args.length ==0 )
		{

			/**
			 * Keep interactive mode alive.
			 */
			while(true)
			{
				try {


					log.info("Please Enter New Action");
					Scanner inputScanner = new Scanner(System.in);
					String inputCommand = inputScanner.next();

					if(inputCommand.toLowerCase().equals("exit"))
					{
						log.info("Go Jek Parking Programm Terminating. Bye.");
						break;
					}
					if(inputCommand == "")
					{
						//Do Nothing
					}
					else
					{
						log.info(inputCommand);



						/**
						 * Write Logic Here
						 */



					}
				}

				catch (Exception e)
				{
					throw new ParkingLotException("Unkown Exception Occured. Please contact Administartor" + e.getMessage());
				}
			}


		}
		else
		{

		}


	}




}
