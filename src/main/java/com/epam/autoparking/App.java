package com.epam.autoparking;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author Pavan_Mugathi App class where execution starts.
 */
public class App {
	/**
	 * constructor not called.
	 */
	public App() {
		// not called
	}

	/**
	 * method to return the car number if valid.
	 * 
	 * @return  carnumber  as string.
	 */
	static String getCarNumber() {
		System.out.printf("enter your car number.%n");
		String carNum;
		while (true) {
			 carNum = in.next();
			if(!VehicleValidator.validateVehicleNumber(carNum)) {
			System.out.printf("enter the valid car number as AP10AB 1234 %n");	
			} else {
				break;
			}
		}
		return carNum;
	}

	/**
	 * CHOICE1 FOR PARKING.
	 */
	private static final int CHOICE_1 = 1;
	/**
	 * CHOICE2 FOR UNPARKING.
	 */
	private static final int CHOICE_2 = 2;
	/**
	 * CHOICE3 FOR CHECKING VEHICLE INFO.
	 */
	private static final int CHOICE_3 = 3;
	/**
	 * CHOICE4 For exit.
	 */
	private static final int CHOICE_4 = 4;
	/**
	 * Scanner class to get input from console.
	 */
	private static Scanner in;
	/**
	 * transaction file reference.
	 */
	private static ITransactionFile transactionFile ;
	/**
	 * log file reference.
	 */
	private static ILogFile logFile ;
	/**
	 * SlotArrangemet reference.
	 */
	private static SlotsArrangement slotsArrangement;
	/**
	 * calender class used to get the time.
	 */
	private static Calendar cal = Calendar.getInstance();

	public void credentialsCheck() {
		in = new Scanner(System.in);
        Credentials login = new Credentials();
		System.out.printf("Please enter your user name%n");
		String username = in.next();
		System.out.printf("Please enter your password%n");
		String pwd = in.next();
		if(username.equals(login.getUserName())&&pwd.equals(login.getPassword())) {
			getNumberofSlots();
		} else {
				System.out.printf("please check the username and password %n");
			System.exit(CHOICE_1);
		}	
	}
	public static void getNumberofSlots() {
		try {
			logFile = new LogFile();
			transactionFile = new TransactionFile();
		int numofslots = transactionFile.numOfSlots();
		if (numofslots == -1) {
			System.out.printf("Enter the number of slots for parking%n");
			numofslots = in.nextInt();
			slotsArrangement = new SlotsArrangement(numofslots);
			transactionFile.addToFile(Integer.toString(numofslots));
		} else {
			System.out.printf("Fetching data from Transaction file.. %n");
			slotsArrangement = new SlotsArrangement(numofslots);
			String[] dataInTransFile = transactionFile.getFromFile();
			for (int i = 1; i < dataInTransFile.length; i++) {
				String[] dataToInsert = dataInTransFile[i].split(",");
				slotsArrangement.map(dataToInsert[0], dataToInsert[1], dataToInsert[2]);
			}
		}
		menu();
		}catch (Exception e) {
			System.out.println(e);
			System.exit(CHOICE_1);
		}
		
	}
	public static void menu() {
		boolean flag = true;
		String carNum = null;
		while (flag) {
			System.out.printf(
					"Enter choice: %n %d parking %n %d unparking %n %d  parking_info %n %d To exit %n", 1, 2,
					3, 4);
			int choice = in.nextInt();
			switch (choice) {
			/**
			 * checks the availabilty of space, assigns if available asks if not.
			 */
			case CHOICE_1:
				if (slotsArrangement.checkAvailability()) {
					carNum = getCarNumber();
					try {
					int slot = slotsArrangement.park(carNum);
					System.out.printf("Your slot number is  %d %n", slot);
					transactionFile.addToFile(
							slot + "," + carNum + "," + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE));
				} catch (Exception e) {
					System.out.printf("%s%n",e);
				}
				}
					else {
					System.out.printf("Sorry.. we dont have space %n");
				}
				break;
			/**
			 * used to unpark the vehicle
			 */
			case CHOICE_2:
				carNum = getCarNumber();
				try {	
				String data = slotsArrangement.unpark(carNum);
					System.out.printf("UnParked%n");
					transactionFile.removeData(data);
					logFile.addToFile(data);
				} catch(Exception e) {
				System.out.println(e);	
				}
				break;

			// To fetch the time stamp of the vehicle that you entered

			case CHOICE_3:
				carNum = getCarNumber();
				try {
				String info = slotsArrangement.getDetails(carNum);
					System.out.printf("%s %n", info);
				} catch(Exception e) {
					System.out.println(e);
				}
				break;
			// to exit.
			case CHOICE_4:
				flag = false;
				break;
			// default case

			default:
				System.out.printf("choose the right option %n");
			}
		}
		try
	{
		System.out.printf("Application has been closed %n");
	} finally {
		in.close();
		transactionFile.close();
	}
}
	/**
         * Main to start the execution.
         * @param args ...
         */
 public static void main(final String[] args) {
	App app = new App();
	app.credentialsCheck();
}
}
