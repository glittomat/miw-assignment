package com.miw.gildedrose.domain.messaging;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
public class AuthenticationRequest implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3491013264275304308L;
	
//	@Getter @Setter private String username;
//	@Getter @Setter private String password;
    
//	
//	private String username;
//	
//	private String password;
//	
//	
//
//	public AuthenticationRequest(String username, String password) {
//		this.username = username;
//		this.password = password;
//	}
//
//	public AuthenticationRequest() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
	
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }

    public AuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
	
	
	
}
