package Moviedatabase;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Moviedatabase.domain.User;
import Moviedatabase.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUserNameShouldReturnRole() {
		User users = repository.findByUsername("admin");
		assertThat(users.getRole()).isEqualTo("ADMIN");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("john", "$2a$08$4AtYGO5/ah5lkgYV5Uti.u6x53Q3hpzLxJSf.rZouvKDoRkpIwv4m", "USER");
		repository.save(user);
		assertThat(user.getRole()).isNotNull();
	}

}

