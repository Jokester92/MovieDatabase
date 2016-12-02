package Moviedatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Moviedatabase.web.MovieController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieControllerTests {
	
	@Autowired
	private MovieController controller;
		
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
