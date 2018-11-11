package com.gojek.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.gojek.parking.exception.ParkingLotException;
import com.gojek.parking.helper.ProcessCommandLineArguments;


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

		ProcessCommandLineArguments processCommandLineArgument = new ProcessCommandLineArguments();

		/**
		 * Check with Interactive or File approach is required to Solve problem. 	
		 */

		try
		{
			if (args.length ==0 )
			{


				/**
				 * Keep interactive mode alive.
				 */
				while(true)
				{
					try {


						log.info("Please Enter New Action");
						BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
						String inputCommand = bufferRead.readLine();

						if(inputCommand.toLowerCase().equals("exit"))
						{
							log.info("Go Jek Parking Programm Terminating. Bye.");
							break;
						}
						else
						{
							processCommandLineArgument.ProcessCommandLineArguments(inputCommand);
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
				/**
				 * Process Parking Lot Based on File Input
				 */
				processCommandLineArgument.commandLineFileParser(args[0]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ParkingLotException("Unkonw Exception Occured while processing . Please contact Administrator" + e.getMessage());

		}



	}




}
