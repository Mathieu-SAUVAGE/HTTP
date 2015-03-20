package com.kyss.structures;

/**
 * @author Mathieu SAUVAGE
 */
public class Flight {
	private String number;
	private String departure;
	private String arrival;

	public String getArrival() {
		return arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public String getNumber() {
		return number;
	}

	public Flight(String number, String departure, String arrival) {
		this.number = number;
		this.departure = departure;
		this.arrival = arrival;
	}
}
