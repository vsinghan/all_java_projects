package com.cg.flightreservationsystem.dao;

import java.util.List;

import com.cg.flightreservationsystem.dto.PassengerDTO;
import com.cg.flightreservationsystem.dto.TicketDTO;
import com.cg.flightreservationsystem.exception.FRSException;

public interface PassengerDao {

	List<Integer> insertPassenger(List<PassengerDTO> passengerDTOs) throws FRSException;

	void deletePassenger(String ticketId) throws FRSException;

	TicketDTO getPassengerInfo(String ticketId) throws FRSException;

	int getAvailableSeats() throws FRSException;
}
