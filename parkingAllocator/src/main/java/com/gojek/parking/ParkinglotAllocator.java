package com.gojek.parking;

import java.util.Scanner;

import org.apache.log4j.Logger;


/**
 * @author Shashi Vishwakarma
 * @Desciption : Program to allocate Parking Slot.
 *
 */
public class ParkinglotAllocator 
{
	final static Logger log = Logger.getLogger(ParkinglotAllocator.class);

	public static void main( String[] args )
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
					
				}
				else
				{
					log.info(inputCommand);
				}
				
					
				
			}


		}
		else
		{

		}


	}
}
