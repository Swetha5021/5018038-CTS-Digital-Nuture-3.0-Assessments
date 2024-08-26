package com.swetha.BookStoreAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    private int id;

    private String name;
    private String email;
    private String address;

    @Version
    private int version;

    public Customer() {
    }
    
	public Customer(int id, String name, String email, String address, int version) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
    
}