package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long Id;
    private String Name;
    private String email;
	public CustomerDTO(Long Id, String Name, String email) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.email = email;
	}
	@JsonIgnore
	private String password;

}