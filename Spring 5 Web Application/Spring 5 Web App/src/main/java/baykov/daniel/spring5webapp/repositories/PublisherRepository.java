package baykov.daniel.spring5webapp.repositories;

import baykov.daniel.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
