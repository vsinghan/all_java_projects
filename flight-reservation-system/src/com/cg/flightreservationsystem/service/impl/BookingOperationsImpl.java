package com.cg.flightreservationsystem.service.impl;

import java.util.List;

import com.cg.flightreservationsystem.dao.PassengerDao;
import com.cg.flightreservationsystem.dao.PassengerDaoImpl;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.service.BookingOperations;
import com.cg.flightreservationsystem.utility.ExceptionMessages;
import com.cg.flightreservationsystem.utility.PassengerDetailsValidator;
import com.cg.flightreservationsystem.dto.PassengerDTO;
import com.cg.flightreservationsystem.dto.TicketDTO;

public class BookingOperationsImpl implements BookingOperations {

	PassengerDetailsValidator passengerDetailsValidator = new PassengerDetailsValidator();

	PassengerDao passengerDao = new PassengerDaoImpl();

	static int nameCount = 0, ageCount = 0, mobileNoCount = 0, emailCount = 0;

	// this method will book the tickets for passengers
	@Override
	public List<Integer> bookTicket(List<PassengerDTO> passengerList) throws FRSException {
		for (int i = 0; i < passengerList.size(); i++) {
			String passengerName = passengerList.get(i).getName();
			int passengerAge = passengerList.get(i).getAge();
			String mobileNo = passengerList.get(i).getMobileNo();
			String emailId = passengerList.get(i).getEmailId();

			passengerDetailsValidator.isNameValid(passengerName);
			passengerDetailsValidator.isAgeValid(passengerAge);
			passengerDetailsValidator.isMobileNoValid(mobileNo);
			passengerDetailsValidator.isEmailIdValid(emailId);

		}
		return passengerDao.insertPassenger(passengerList);
	}

	// this method will return no. of seats available
	@Override
	public int viewAvailableSeats() throws FRSException {
		return passengerDao.getAvailableSeats();
	}

	// this method will cancel the ticket using ticket id
	@Override
	public void cancelTicket(String ticketId) throws FRSException {
		if (!passengerDetailsValidator.isTicketIdValid(ticketId)) {
			throw new FRSException(ExceptionMessages.MESSAGE1);
		}
		passengerDao.deletePassenger(ticketId);
	}

	// this method will return passenger details
	@Override
	public TicketDTO viewTicket(String ticketId) throws FRSException {
		if (!passengerDetailsValidator.isTicketIdValid(ticketId))
			throw new FRSException(ExceptionMessages.MESSAGE1);
		TicketDTO dto = passengerDao.getPassengerInfo(ticketId);
		return dto;
	}
}
