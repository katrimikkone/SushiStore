package backend.sushistore.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long>{
	Optional<Image> findByName(String name);
}
