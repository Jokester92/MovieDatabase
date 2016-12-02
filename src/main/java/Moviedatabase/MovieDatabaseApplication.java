package Moviedatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Moviedatabase.domain.User;
import Moviedatabase.domain.UserRepository;
import Moviedatabase.domain.Genre;
import Moviedatabase.domain.GenreRepository;
import Moviedatabase.domain.Movie;
import Moviedatabase.domain.MovieRepository;

@SpringBootApplication
public class MovieDatabaseApplication {
	private static final Logger log = LoggerFactory.getLogger(MovieDatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MovieDatabaseApplication.class, args);
	}
	@Bean
	public CommandLineRunner movieDemo(MovieRepository repository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of movies");
			grepository.save(new Genre("Horror"));
			grepository.save(new Genre("Drama"));
			grepository.save(new Genre("Fantasy"));
			grepository.save(new Genre("Sci-Fi"));
			grepository.save(new Genre("Action"));
			grepository.save(new Genre("Animation"));
			grepository.save(new Genre("Anime"));
			grepository.save(new Genre("Cartoon"));
			grepository.save(new Genre("Romance"));
			grepository.save(new Genre("Biography"));
			grepository.save(new Genre("Historical/Documentary"));
			grepository.save(new Genre("Thriller"));
			
			repository.save(new Movie("Evil Dead", "Sam Raimi", 1981, "222-111", 4, grepository.findByName("Horror").get(0)));
			repository.save(new Movie("The Lord of the Rings", "Peter Jackson", 2001, "444-333", 5, grepository.findByName("Fantasy").get(0)));
			repository.save(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, "111-222", 5, grepository.findByName("Drama").get(0)));
			repository.save(new Movie("Star Wars The Force Awakens", "J.J. Abrams", 2015, "555-444", 4, grepository.findByName("Sci-Fi").get(0)));
			repository.save(new Movie("Bourne Identity", "Doug Liman", 2002, "666-555", 4, grepository.findByName("Action").get(0)));
			repository.save(new Movie("Despicable Me", "Pierre Coffin, Chris Renaud", 2010, "777-666", 5, grepository.findByName("Animation").get(0)));
			repository.save(new Movie("Spirited Away", "Hayao Miyazaki", 2001, "888-777", 4, grepository.findByName("Anime").get(0)));
			repository.save(new Movie("The Simpsons Movie", "David Silverman", 2007, "999-888", 4, grepository.findByName("Cartoon").get(0)));
			repository.save(new Movie("Dear John", "Lasse Hallström", 2010, "000-999", 3, grepository.findByName("Romance").get(0)));
			repository.save(new Movie("Lawrence of Arabia", "David Lean", 1962, "222-333", 4, grepository.findByName("Biography").get(0)));
			repository.save(new Movie("Schindler's List", "Steven Spielberg", 1993, "333-444", 5, grepository.findByName("Historical/Documentary").get(0)));
			repository.save(new Movie("Don't Breathe", "Fede Alvarez", 2016, "444-555", 3, grepository.findByName("Thriller").get(0)));
			
					User user1 = new User("user", "$2a$08$kjjYBjsbu0l3UwJ5DBahueMpn7MX.0u5tM56K9DGDk1ZFNfto0hLi", "USER");
					User user2 = new User("admin", "$2a$08$vBH9jvdqBk3n5GADtbiuXONcE7hZISFXulw8KNRG83A8FhrxNcam6", "ADMIN");
					urepository.save(user1);
					urepository.save(user2);
			
			log.info("fetch all movies");
			for (Movie movie : repository.findAll()){
				log.info(movie.toString());
			}
		};
}
}