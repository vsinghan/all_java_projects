package com.cg.frs.service;

public interface IBookingDetails {
	
	//search flights
	void searchFlights();
	
	void enterPassengerDetails();
	
	void bookTicket();
	
	void updateSeatsAvailable();
	
	void cancelTicket();
	
	void downloadTicket();
	
}
