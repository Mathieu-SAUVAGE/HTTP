package com.kyss.structures;

import java.util.Date;

/**
 * @author Mathieu SAUVAGE
 */
public class Person {
	public String firstname;
	public String lastname;
	public Date birthday;
	public Gender gender;
	public String phoneNumber;

	public Person(String lastname, Gender gender) {
		this.lastname = lastname;
		this.gender = gender;
	}

	public Person(String firstname, String lastname, Gender gender) {
		this(lastname,
			 gender);
		this.firstname = firstname;
	}

	public Person(String firstname, String lastname, Date birthday, Gender gender) {
		this(firstname,
			 lastname,
			 gender);
		this.birthday = birthday;
	}

	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public static enum Gender {MALE, FEMALE}
}
