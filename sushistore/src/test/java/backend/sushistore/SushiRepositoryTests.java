package backend.sushistore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import backend.sushistore.domain.Category;
import backend.sushistore.domain.CategoryRepository;
import backend.sushistore.domain.Sushi;
import backend.sushistore.domain.SushiRepository;

@DataJpaTest
public class SushiRepositoryTests {

	@Autowired
	SushiRepository repository;
	
	@Autowired
	CategoryRepository crepository;
	
	@Test
	void findAllShouldReturnThreeRowa() {
		Iterable<Sushi> sushis = repository.findAll();
		assertThat(sushis).hasSize(3);
	}
	
	@Test
	public void findByNameShouldReturnSushi() {
		List<Sushi> sushis = repository.findByName("ebi");
		
		assertThat(sushis).hasSize(1);
		assertThat(sushis.get(0).getPrice()).isEqualTo(2);
	}
	
	@Test
	public void createNewSushi() {
		Category category = new Category("maki");
		crepository.save(category);
		Sushi sushi = new Sushi("kappa", "kurkku", 1.5, category);
		repository.save(sushi);
		assertThat(sushi.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewSushi() {
		List<Sushi> sushis = repository.findByName("ebi");
		Sushi sushi = sushis.get(0);
		repository.delete(sushi);
		List<Sushi> newSushis = repository.findByName("ebi");
		assertThat(newSushis).hasSize(0);
	}
}
