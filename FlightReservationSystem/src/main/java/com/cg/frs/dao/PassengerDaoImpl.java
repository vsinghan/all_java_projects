package com.cg.frs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.frs.dto.FlightDTO;
import com.cg.frs.dto.PassengerDTO;
import com.cg.frs.dto.RouteDTO;
import com.cg.frs.dto.ScheduleDTO;
import com.cg.frs.dto.TicketDTO;

@Repository
@Transactional
public class PassengerDaoImpl implements PassengerDao {

	int i = 0;
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * this method will insert details of passenger and generate the ticket
	 */
	public List<Integer> insertPassenger(List<PassengerDTO> passengerDTOs, List<Integer> seatNumbers) {

		int i = 0;
		List<Integer> tickets = new ArrayList<>();
		for (PassengerDTO passengerDTO : passengerDTOs) {
			TicketDTO ticketDTO = new TicketDTO();
			ticketDTO.setSeatNo(seatNumbers.get(i++));
			ticketDTO.setPassengerDTO(passengerDTO);

			FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());

			entityManager.persist(passengerDTO);
			entityManager.persist(ticketDTO);
			flightDTO.setCapacity(flightDTO.getCapacity() - 1);

			tickets.add(ticketDTO.getPnr());
		}
		return tickets;
	}

	/**
	 * this method will cancel the ticket and delete the passenger details
	 */
	public void deletePassenger(int ticketId) {

		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO = entityManager.find(TicketDTO.class, ticketId);
		FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());

		entityManager.remove(ticketDTO);
		flightDTO.setCapacity(flightDTO.getCapacity() + 1);
	}

	/**
	 * this method will fetch the ticket details
	 */
	public TicketDTO getPassengerInfo(int ticketId) {

		TicketDTO ticketDTO = entityManager.find(TicketDTO.class, ticketId);

		ticketDTO.setPassengerName(ticketDTO.getPassengerDTO().getName());
		ticketDTO.setPnr(ticketDTO.getPnr());
		ticketDTO.setSeatNo(ticketDTO.getSeatNo());

		FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());
		ScheduleDTO scheduleDTO = flightDTO.getScheduleDTO();
		RouteDTO routeDTO = flightDTO.getRouteDTO();

		ticketDTO.setSource(routeDTO.getSource());
		ticketDTO.setDestination(routeDTO.getDestination());
		ticketDTO.setDepartureDate(scheduleDTO.getDepartureDate());
		ticketDTO.setDepartureTime(scheduleDTO.getDepartureTime());

		return ticketDTO;
	}

	/**
	 * this method will fetch the available seats in a particular flight
	 */
	public int getAvailableSeats() {

		TicketDTO ticketDTO = new TicketDTO();
		FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());

		return flightDTO.getCapacity();
	}
}