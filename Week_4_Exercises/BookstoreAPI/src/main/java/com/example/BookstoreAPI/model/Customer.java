package com.example.BookstoreAPI.model;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long Id;
    @NonNull
    private String Name;

    @NonNull
    private String email;
    private String password;
	public Customer(Long Id, String Name, String email, String password) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.email = email;
		this.password = password;
	}
	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(Object email2) {
		// TODO Auto-generated method stub
		
	}

}
