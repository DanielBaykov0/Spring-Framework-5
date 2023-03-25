package baykov.daniel.spring5webapp.repositories;

import baykov.daniel.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
