package com.example.BookstoreAPI.model;

import java.util.List;

import com.example.BookstoreAPI.dto.BookDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Fixed: Correct annotation usage
    private Long Id;
    private String title;
    private String author;
    private double price;
    private String isbn;
//	public Book(Long id, String title, String author, double price, String isbn) {
//		super();
//		this.id = Id;
//		this.title = Title;
//		this.author = Author;
//		this.price = Price;
//		this.isbn = Isbn;
//	}
	
	@Version
    private Long version;

	public void setTitle(Object Title2) {
		// TODO Auto-generated method stub
		
	}

	public void setAuthor(Object Author2) {
		// TODO Auto-generated method stub
		
	}

	public void setPrice(Object Price2) {
		// TODO Auto-generated method stub
		
	}

	public void setIsbn(Object Isbn2) {
		// TODO Auto-generated method stub
		
	}

	public List<BookDTO> getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BookDTO> getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

}
