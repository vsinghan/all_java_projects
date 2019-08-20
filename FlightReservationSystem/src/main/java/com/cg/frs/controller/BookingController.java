package com.cg.frs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.frs.dto.PassengerDTO;
import com.cg.frs.dto.TicketDTO;
import com.cg.frs.service.BookingOperations;

@RestController
public class BookingController {

	@Autowired
	private BookingOperations bookingOperations;

	/**
	 * this method shows the available seats in a selected flight
	 * 
	 * @return
	 */
	@GetMapping(value = "/viewseats", produces = "application/json")
	public int viewSeats() {
		return bookingOperations.viewAvailableSeats();
	}

	/**
	 * this method takes the details of passenger and return the ticket no.
	 * 
	 * @param passengerList
	 * @return
	 */
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public List<Integer> addPassenger(@RequestBody List<PassengerDTO> passengerList) {
		List<Integer> seatNumbers = new ArrayList<>();
		seatNumbers.add(567);
		// seatNumbers.add(568);
		return bookingOperations.bookTicket(passengerList, seatNumbers);
	}

	/**
	 * this method takes ticket id from passenger and cancel the ticket
	 * 
	 * @param ticketId
	 * @return
	 */
	@GetMapping(value = "/CancelTicket/{ticketId}", produces = "application/json")
	@ResponseBody
	public String removePassenger(@PathVariable("ticketId") int ticketId) {
		bookingOperations.cancelTicket(ticketId);
		return "Your ticket has been cancelled!!!";
	}

	/**
	 * this method takes ticket id from passenger and return the details of ticket
	 * 
	 * @param ticketId
	 * @return
	 */
	@GetMapping(value = "/ViewTicket/{ticketId}", produces = "application/json")
	@ResponseBody
	public TicketDTO viewTicket(@PathVariable("ticketId") int ticketId) {
		return bookingOperations.viewTicket(ticketId);
	}
}
