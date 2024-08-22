package com.example.BookstoreAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long Id) {
        Book book = bookRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + Id));
        return ResponseEntity.ok(bookMapper.toBookDTO(book));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@Validated @RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toBookDTO(savedBook);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @Validated @RequestBody BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + Id));
        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setPrice(bookDTO.getPrice());
        existingBook.setIsbn(bookDTO.getIsbn());
        Book updatedBook = bookRepository.save(existingBook);
        return bookMapper.toBookDTO(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long Id) {
        Book book = bookRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + Id));
        bookRepository.delete(book);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<BookDTO> searchBooks(@RequestParam(required = false) String Title,
                                      @RequestParam(required = false) String Author) {
        // Implement the search logic here based on title and author
        // This method can be expanded based on your search criteria
        return bookRepository.findAll().stream()
                .filter(book -> (title == null || book.getTitle().contains(Title)) &&
                                (author == null || book.getAuthor().contains(Author)))
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
    }
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public BookDTO getBookById(@PathVariable Long id, @RequestHeader(value = "Accept", defaultValue = "application/json") String acceptHeader) {
        Book book = bookRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + Id));
        
        BookDTO bookDTO = bookMapper.toBookDTO(book);
        
        if (acceptHeader.equals("application/xml")) {
            // Convert to XML if required
        }

        return bookDTO;
    }

}
