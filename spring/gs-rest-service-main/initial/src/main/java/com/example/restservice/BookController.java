package com.example.restservice;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

@RestController
public class BookController {

	private static final String template = "Hello, %s!";
	private static final List<Book> books = new CopyOnWriteArrayList<>();
	private static final AtomicLong counter = new AtomicLong();

	static {
		books.add(new Book(counter.getAndIncrement(), "Book" + counter.get()));
		books.add(new Book(counter.getAndIncrement(), "Book" + counter.get()));
		books.add(new Book(counter.getAndIncrement(), "Book" + counter.get()));
	}

	@GetMapping("/books")
	public List<Book> getBooks() {
		return books;
	}

	@PostMapping("/books")
	public Book addBook(@RequestBody Book book){
		var newBook = new Book(counter.getAndIncrement(), book.title());
		books.add(newBook);
		return newBook;
	}

	@GetMapping("/books/{id}")
	public Book getById(@PathVariable Long id){
		Book foundBook = books.stream()
				.filter(book->id.equals(book.id()))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("ID not found"));

		return foundBook;
	}
}