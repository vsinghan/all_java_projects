package com.cg.frs.dao;

import java.util.List;

import com.cg.frs.dto.PassengerDTO;
import com.cg.frs.dto.TicketDTO;

public interface PassengerDao {

	List<Integer> insertPassenger(List<PassengerDTO> passengerDTOs, List<Integer> seatNumbers);

	void deletePassenger(int ticketId);

	TicketDTO getPassengerInfo(int ticketId);

	int getAvailableSeats();
}
