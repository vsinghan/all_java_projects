package com.cg.frs.main;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Scanner;

import com.cg.frs.dao.Passenger;

public class Booking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,passengerAge;
		String passengerName,passengerMobileNo,passengerEmailId;
		float luggage,extraLuggage;
		
		Scanner scanner = new Scanner(System.in);
		
		//getNoOfPassenger();
		System.out.println("Enter the no of passengers: ");
		n = scanner.nextInt();
		
		//Passenger passenger[] = new Passenger[n];
		
		List<Passenger> passengerList = new ArrayList<Passenger>();
		
		for(int i = 0; i < n; i++)
		{
			System.out.println("Enter the details of passenger " + (i+1) + " :");
			System.out.println("\nName -  ");
			passengerName = scanner.nextLine();
			System.out.println("\nAge -  ");
			passengerAge = scanner.nextInt();
			System.out.println("\nMobile no. -  ");
			passengerMobileNo = scanner.nextLine();
			System.out.println("\nEmail ID -  ");
			passengerEmailId = scanner.nextLine();
			System.out.println("\nLuggage -  ");
			luggage = scanner.nextFloat();
			System.out.println("\nExtra Luggage -  ");
			extraLuggage = scanner.nextFloat();
			
			passengerList.add(new Passenger(passengerName,passengerAge,passengerMobileNo,passengerEmailId,luggage,extraLuggage));
		}
		
		for(int i = 0; i < n; i++)
		{
			System.out.println(passengerList.get(i).toString());
		}
//		passengerList.add(new Passenger("Vishal Singhaniya",22,"9983077144","vishal@gmail.com",15.02f,3.04f));
//		passengerList.add(new Passenger("Aman",23,"9983077144","Aman@gmail.com",15.02f,3.04f));
//		passengerList.add(new Passenger("Surendran",22,"9983077144","surendran@gmail.com",15.02f,3.04f));
//		passengerList.add(new Passenger("Sakshi",22,"9983077144","sakshi@gmail.com",15.02f,3.04f));
//		passengerList.add(new Passenger("Sita",22,"9983077144","sita@gmail.com",15.02f,3.04f));
		
		//System.out.println(passenger.get(2).getMobileNo());
//		Comparator<Passenger> obj = new Comparator<Passenger>() {
//			public int compare(Passenger p1, Passenger p2)
//			{
//				return (p1.getAge()>p2.getAge()?1:-1);
//			}
//		};
		
		
		
//		Collections.sort(passenger,obj);
		
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("vishal", "73736");
//		map.put("vishu", "737566");
//		map.put("vishnu", "7374556");
//		
//		for(String p : map.keySet())
//		{
//			System.out.println(p + " " + map.get(p));
//		}
		
		
			
			
	}

}
