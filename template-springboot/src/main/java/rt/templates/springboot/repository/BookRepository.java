package rt.templates.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rt.templates.springboot.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByName(String name);
}
