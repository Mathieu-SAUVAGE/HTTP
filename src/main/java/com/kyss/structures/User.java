package com.kyss.structures;

import java.security.Timestamp;

/**
 * @author Mathieu SAUVAGE
 */
public class User extends Person{
	public String username;
	public String password;
	public Timestamp expireDate;

	public User(String firstname, String lastname, String username, String password) {
		super(firstname,
			  lastname);
		this.username = username;
		this.password = password;
	}

	public User(String firstname, String lastname, String username, String password, Timestamp expireDate) {
		this(firstname, lastname, username, password);
		this.expireDate = expireDate;
	}
}
