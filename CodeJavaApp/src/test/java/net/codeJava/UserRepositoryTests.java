package net.codeJava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration;
import org.springframework.test.annotation.Rollback;

import net.codeJava.User;
import net.codeJava.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("alex@gmail.com");
		user.setPassword("alex45");
		user.setFirstName("momi");
		user.setLastName("Kumar");

		User savedUser = userRepo.save(user);

		User existUser = entityManager.find(User.class, savedUser.getId());

		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

	}

	@Test
	public void testFindUserByEmail() {
		String email = "nam@codejava.net";
		User user = userRepo.findByEmail(email);
		assertThat(user).isNotNull();
	}

	@Test
	public void testAddRoleToNewUser() {

		User user = new User();
		user.setEmail("nip@gmail.com");
		user.setPassword("ovi12");
		user.setFirstName("Ovi");
		user.setLastName("Sarker");
		Role roleUser = roleRepo.findByName("User");
		user.addRole(roleUser);
		User saveUser = userRepo.save(user);
		assertThat(saveUser.getRoles().size()).isEqualTo(1);

	}

	@Test
	public void testAddRolesToExistingUser() {
		User user = userRepo.findById(1L).get();

		Role roleUser = roleRepo.findByName("User");
		user.addRole(roleUser);
		
		Role roleAdmin= new Role(3);
		user.addRole(roleAdmin);
		User saveUser=userRepo.save(user);
		assertThat(saveUser.getRoles().size()).isEqualTo(2);

		
	}
}
