package Moviedatabase.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Moviedatabase.domain.GenreRepository;
import Moviedatabase.domain.Movie;
import Moviedatabase.domain.MovieRepository;

@Controller
public class MovieController {

	@Autowired
	private MovieRepository repository;
	@Autowired
	private GenreRepository grepository; 
	
		 @RequestMapping (value="/logon")
		 public String logon() {
			 return "logon";
		 }
		 	// Show all movies
		    @RequestMapping(value="/movielist")
		    public String movielist(Model model) {	
		        model.addAttribute("movies", repository.findAll());
		        return "movielist";
		    }
		    
		    // RESTful service to get all movies
		    @RequestMapping(value="/movies", method = RequestMethod.GET)
		    public @ResponseBody List<Movie> movieListRest() {
		    	return (List<Movie>) repository.findAll();
		    }
		    
		    // RESTful service to get movie by id
		    @RequestMapping(value="/movie/{id}", method = RequestMethod.GET)
		    public @ResponseBody Movie findMovieRest (@PathVariable("id") Long movieId) {
		    	return repository.findOne(movieId);
		    }
		    
		    // add new movie
		    @RequestMapping(value = "/add")
		    public String addmovie(Model model){
		    	model.addAttribute("movie", new Movie());
		    	model.addAttribute("genre",grepository.findAll());
		        return "addmovie";
		    }     
		    
		    @RequestMapping(value = "/save", method = RequestMethod.POST)
		    public String save(Movie movie){
		        repository.save(movie);
		        return "redirect:movielist";
		    }    

		    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		    public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
		    	repository.delete(movieId);
		        return "redirect:../movielist";
		    }     
		}

