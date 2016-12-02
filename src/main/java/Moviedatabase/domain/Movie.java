package Moviedatabase.domain;

import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie {

@Id
@GeneratedValue (strategy=GenerationType.AUTO)
		private long id;
		private String title;
		private String director;
		private Integer year;
		private String isbn;
		private Integer rating;


		
		@ManyToOne
		@JsonIgnore
		@JoinColumn (name ="genreid")
		private Genre genre;
		
		public Movie(){};
		
		public Movie(String title, String director, Integer year,
				String isbn, Integer rating, Genre genre) {
			super();
			this.title = title;
			this.director = director;
			this.year = year;
			this.isbn = isbn;
			this.rating = rating;
			this.genre = genre;
		
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDirector() {
			return director;
		}

		public void setDirector(String director) {
			this.director = director;
		}

		public Integer getYear() {
			return year;
		}

		public void setYear(Integer year) {
			this.year = year;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public Integer getRating() {
			return rating;
		}

		public void setRating(Integer rating) {
			this.rating = rating;
		}
		
		public Genre getGenre() {
			return genre;
		}

		public void setGenre(Genre genre) {
			this.genre = genre;
		}


		@Override
		public String toString() {
			if (this.genre != null)
			return "Movie [Id=" + id + ", Title=" + title + ", Director=" + director + ", Year=" + year + ", Isbn=" + isbn + ", Rating=" + rating + ", Category=" + this.getGenre() + "]";
		else 
			return "Movie [Id=" + id + ", Title=" + title + ", Director=" + director + ", Year=" + year + ", Isbn=" + isbn + ", Rating=" + rating + "]";
		}
		
		
		
}