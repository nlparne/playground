package rt.templates.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import rt.templates.springboot.model.Book;
import rt.templates.springboot.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping("/books")
	public Iterable<Book> findBooks(@RequestParam(required = false) String name) {
		if (name == null || name.isBlank()) {
			return repository.findAll();
		} else {
			return repository.findByName(name);
		}
	}

	@PostMapping("/books")
	public Book saveBook(@RequestParam String name) {
		return repository.save(new Book(name));
	}

	@GetMapping("/books/{id}")
	public Book findBook(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
