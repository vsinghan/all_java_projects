package com.cg.flightreservationsystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.flightreservationsystem.dto.FlightDTO;
import com.cg.flightreservationsystem.dto.PassengerDTO;
import com.cg.flightreservationsystem.dto.RouteDTO;
import com.cg.flightreservationsystem.dto.ScheduleDTO;
import com.cg.flightreservationsystem.dto.TicketDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.utility.ExceptionMessages;

public class PassengerDaoImpl implements PassengerDao {

	// private String pnrNo, passengerId;
	int i = 0;

	// EntityManager entityManager;

	/*
	 * this persistenceUnitName is loading the driver and connecting to the database
	 */
	// String persistenceUnitName =
	// entityManager.getEntityManagerFactory().getProperties()
	// .get("hibernate.ejb.persistenceUnitName").toString();

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("booking");

	/*
	 * it manages the entities
	 */
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	// EntityTransaction entityTransaction = entityManager.getTransaction();

	// Random randomNo = new Random();

	public List<Integer> insertPassenger(List<PassengerDTO> passengerDTOs) throws FRSException {
		// Connection connection = DBConnection.getConnection();
		// List<String> tickets = new ArrayList<>();
		// PreparedStatement preparedStatement = null;
		List<Integer> tickets = new ArrayList<>();
		for (PassengerDTO passengerDTO : passengerDTOs) {
			// entityManager.getTransaction().begin();
			// entityManager.persist(passengerDTO);
			// entityManager.getTransaction().commit();

			// //how i will get above committed row?
			// PassengerDTO passengerDTO = entityManager.find(PassengerDTO.class,
			// passengerDTO.getId());
			// String passengerId = passengerDTO.getId();
			// //String passengerName = passengerDTO.getName();
			//
			// //flightId, I will get when customer selects a flght
			// FlightDTO flightDTO = entityManager.find(FlightDTO.class, flightId)
			//
			// TicketDTO ticketDTO = new TicketDTO();
			// ticketDTO.setPassengerId(passengerId);
			// //flightId, I will get when customer selectis a flght
			// ticketDTO.setFlightId("fa-101");
			TicketDTO ticketDTO = new TicketDTO();
			ticketDTO.setPassengerDTO(passengerDTO);

			// entityManager.getTransaction().begin();
			// entityManager.persist(ticketDTO);
			// entityManager.getTransaction().commit();

			FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());

			entityManager.getTransaction().begin();

			entityManager.persist(passengerDTO);
			entityManager.persist(ticketDTO);
			flightDTO.setCapacity(flightDTO.getCapacity() - 1);

			entityManager.getTransaction().commit();

			tickets.add(ticketDTO.getPnr());
		}

		return tickets;
	}

	// PassengerDTO passengerDTO = entityManager.find(PassengerDTO.class,
	// passengerDTO.getId());
	//
	// String passengerId = passengerDTO.getId();
	//
	// TicketDTO ticketDTO = new TicketDTO();
	//
	// ticketDTO.s

	// try {
	// preparedStatement = connection.prepareStatement(DBQueries.query1);
	//
	// passengerId = (randomNo.nextInt(180) + 1) + "";
	// if (passengerId.length() == 1) {
	// passengerId += "00";
	// }
	// if (passengerId.length() == 2) {
	// passengerId += "0";
	// }
	// passengerDTO.setId("PI" + passengerId);
	//
	// preparedStatement.setString(1, passengerDTO.getId());
	// preparedStatement.setString(2, passengerDTO.getName());
	// preparedStatement.setString(3, passengerDTO.getAge());
	// preparedStatement.setString(4, passengerDTO.getMobileNo());
	// preparedStatement.setString(5, passengerDTO.getEmailId());
	// i = preparedStatement.executeUpdate();
	//
	// if (i == 1) {
	// try {
	// TicketDTO ticketDTO = new TicketDTO();
	// preparedStatement = connection.prepareStatement(DBQueries.query2);
	// pnrNo = (randomNo.nextInt(180) + 1) + "";
	// ticketDTO.setPnrNo(pnrNo);
	// preparedStatement.setString(1, passengerDTO.getId());
	// preparedStatement.setString(2, ticketDTO.getPnrNo());
	// i = preparedStatement.executeUpdate();
	//
	// if (i == 1) {
	// connection.commit();
	// tickets.add(ticketDTO.getPnrNo());
	// } else {
	// throw new FRSException(ExceptionMessages.MESSAGE5);
	// }
	// } catch (SQLException ex) {
	// throw new FRSException(ExceptionMessages.MESSAGE5);
	// }
	// } else {
	// throw new FRSException(ExceptionMessages.MESSAGE4);
	// }
	// } catch (SQLException ex) {
	// throw new FRSException(ExceptionMessages.MESSAGE8);
	// }
	// }
	// return tickets;

	public void deletePassenger(String ticketId) throws FRSException {

		TicketDTO ticketDTO = entityManager.find(TicketDTO.class, ticketId);
		// PassengerDTO passengerDTO = ticketDTO.getPassengerDTO();
		// String passengerId = passengerDTO.getId();

		if (ticketDTO != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(ticketDTO);
			entityManager.getTransaction().commit();
		} else {
			throw new FRSException(ExceptionMessages.MESSAGE9);
		}

		// PassengerDTO passengerDTO = entityManager.find(PassengerDTO.class,
		// passengerId);
		//
		// if (passengerDTO != null) {
		// entityTransaction.begin();
		// entityManager.remove(passengerDTO);
		// entityTransaction.commit();
		// }

		// Connection connection = DBConnection.getConnection();
		//
		// try {
		// PreparedStatement preparedStatement =
		// connection.prepareStatement(DBQueries.query6);
		// preparedStatement.setString(1, ticketId);
		// ResultSet resultSet = preparedStatement.executeQuery();
		//
		// String passengerId = "";
		// if (resultSet.next()) {
		// passengerId = resultSet.getString(1);
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE9);
		// }
		//
		// preparedStatement = connection.prepareStatement(DBQueries.query7);
		// preparedStatement.setString(1, ticketId);
		// int i = preparedStatement.executeUpdate();
		// if (i == 1) {
		// preparedStatement = connection.prepareStatement(DBQueries.query8);
		// preparedStatement.setString(1, passengerId);
		// i = preparedStatement.executeUpdate();
		// if (i == 1) {
		// connection.commit();
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE10);
		// }
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE11);
		// }
		// } catch (SQLException ex) {
		// throw new FRSException(ExceptionMessages.MESSAGE8);
		// }
	}

	public TicketDTO getPassengerInfo(String ticketId) throws FRSException {

		TicketDTO ticketDTO = entityManager.find(TicketDTO.class, ticketId);
		TicketDTO ticketDTO2 = new TicketDTO();
		// PassengerDTO passengerDTO = entityManager.find(PassengerDTO.class,
		// ticketDTO.getPassengerDTO().getId());
		ticketDTO2.setPassengerName(ticketDTO.getPassengerDTO().getName());
		ticketDTO2.setPnr(ticketDTO.getPnr());
		ticketDTO2.setSeatNo(ticketDTO.getSeatNo());

		FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO2.getFlighTID());
		ScheduleDTO scheduleDTO = flightDTO.getScheduleDTO();
		RouteDTO routeDTO = flightDTO.getRouteDTO();

		ticketDTO2.setSource(routeDTO.getSource());
		ticketDTO2.setDestination(routeDTO.getDestination());
		ticketDTO2.setDepartureDate(scheduleDTO.getDepartureDate());
		ticketDTO2.setDepartureTime(scheduleDTO.getDepartureTime());

		return ticketDTO2;

		// Connection connection = DBConnection.getConnection();
		// PreparedStatement preparedStatement = null;
		// try {
		// preparedStatement = connection.prepareStatement(DBQueries.query4);
		// preparedStatement.setString(1, ticketId);
		// ResultSet resultSet = preparedStatement.executeQuery();
		//
		// if (resultSet.next()) {
		// PassengerDTO dto = new PassengerDTO();
		// dto.setId(resultSet.getString("id"));
		// dto.setName(resultSet.getString("name"));
		// dto.setAge(resultSet.getString("age"));
		// dto.setMobileNo(resultSet.getString("mobile_no"));
		// dto.setEmailId(resultSet.getString("email_id"));
		//
		// return dto;
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE9);
		// }
		// } catch (SQLException ex) {
		// throw new FRSException(ExceptionMessages.MESSAGE8);
		// }
	}

	public int getAvailableSeats() throws FRSException {

		TicketDTO ticketDTO = new TicketDTO();
		FlightDTO flightDTO;
		try {
			flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new FRSException(ExceptionMessages.MESSAGE6);
		}
		// Connection connection = DBConnection.getConnection();
		// int noOfPassengers = 0;
		// Statement statement = null;
		// try {
		// statement = connection.createStatement();
		// ResultSet resultSet = statement.executeQuery(DBQueries.query5);
		//
		// if (resultSet.next()) {
		// noOfPassengers = resultSet.getInt(1);
		// }
		// } catch (SQLException ex) {
		// throw new FRSException(ExceptionMessages.MESSAGE7);
		// }
		return flightDTO.getCapacity();
	}
}