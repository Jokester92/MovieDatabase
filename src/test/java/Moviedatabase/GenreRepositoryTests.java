package Moviedatabase;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Moviedatabase.domain.Genre;
import Moviedatabase.domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GenreRepositoryTests {

	@Autowired
	private GenreRepository repository;
	
	@Test
	public void findByTitleShouldReturnMovie() {
		List<Genre> genres = repository.findByName("Fantasy");
		assertThat(genres).hasSize(1);
		assertThat(genres.get(0).getGenreid()).isEqualTo("3");
	}
	
	@Test
	public void createNewGenre() {
		Genre genre = new Genre("Sci-fi");
		repository.save(genre);
		assertThat(genre.getGenreid()).isNotNull();
	}

}
