package com.travelpackage.takeatrip;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.travelpackage.takeatrip.passenger.Passenger;
import com.travelpackage.takeatrip.passenger.StandardPassenger;
import com.travelpackage.takeatrip.travelagency.TravelAgency;
import com.travelpackage.takeatrip.travelagency.TravelAgencyImpl;
import com.travelpackage.takeatrip.travelagency.booking.BookingDetails;
import com.travelpackage.takeatrip.travelpackage.TravelPackage;

public class TakeatripApplication {

	public static void main(String[] args) {

		// Create a Travel agency
		TravelAgency vermaTraveler = new TravelAgencyImpl();

		// Initialize a Travel agency with some values
		vermaTraveler.init();
		printSection("Agency INIT()", vermaTraveler.toString());

		// Create a Travel agency
		Passenger passenger1 = new StandardPassenger(0l, "Person 1", new BigDecimal(250));
		printSection("Passenger 1 creation", passenger1.toString());

		// List travel package
		List<TravelPackage> availableTravelPackage = vermaTraveler.listTravelPackages();
		printSection("List avaliable package", availableTravelPackage.toString());

		// Create a list of activity from a package
		List<Long> userActivityList = new ArrayList<>();
		userActivityList.add(0l);
		userActivityList.add(4l);
		userActivityList.add(5l);
		printSection("Chosen activitty", userActivityList.toString());

		// Create a booking
		BookingDetails booking1 = vermaTraveler.bookPackageByID(passenger1, availableTravelPackage.get(0),
				userActivityList);
		printSection("Booking details", booking1.toString());

		// Print passenger list
		System.out.println("\n************** " + "Passenger list" + " Starts Here **************\n");
		vermaTraveler.printPassengerList(availableTravelPackage.get(0));
		System.out.println("\n************** " + "Passenger list" + " Ends Here **************\n");

		// Print passenger full report
		System.out.println("\n************** " + "Passenger report" + " Starts Here **************\n");
		vermaTraveler.printPassengerDetails(passenger1);
		System.out.println("\n************** " + "Passenger report" + " Ends Here **************\n");

		// Print Free activites
		System.out.println("\n************** " + "Free Activities" + " Starts Here **************\n");
		vermaTraveler.printFreeActivitiesInPackage(availableTravelPackage.get(0));
		System.out.println("\n************** " + "Free Activities" + " Ends Here **************\n");

	}

	static void printSection(String sectionMessage, String message) {
		System.out.println("\n************** " + sectionMessage + " Starts Here **************\n");
		System.out.println(message);
		System.out.println("\n************** " + sectionMessage + " Ends Here **************\n");
	}

}
