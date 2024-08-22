package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long Id;

    @Nonnull

    private String Title;

    @Nonnull

    private String Author;

    @Nonnull

    private Double Price;

    @Nonnull

    private String Isbn;

	public Object getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getIsbn() {
		// TODO Auto-generated method stub
		return null;
	}

}

