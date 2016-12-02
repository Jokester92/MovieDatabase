package Moviedatabase;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Moviedatabase.domain.Genre;
import Moviedatabase.domain.MovieRepository;
import Moviedatabase.domain.Movie;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTests {

	@Autowired
	private MovieRepository repository;
	
	@Test
	public void findByTitleShouldReturnMovie() {
		List<Movie> movies = repository.findByTitle("The Lord of the Rings");
		assertThat(movies).hasSize(1);
		assertThat(movies.get(0).getIsbn()).isEqualTo("444-333");
	}
	
	
	@Test
	public void createNewMovie() {
		Movie movie = new Movie("The Dark Knight", "Christopher Nolan", 1920, "555-444", 5, new Genre("Action"));
		repository.save(movie);
		assertThat(movie.getId()).isNotNull();
	}

}
