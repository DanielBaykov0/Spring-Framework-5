package baykov.daniel.spring5webapp.repositories;

import baykov.daniel.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
