package net.codeJava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	
	@Autowired
	private UserService service;
	@GetMapping("")
	public String viewHomePage() {

		return "index";

	}

	@GetMapping("/register")
	public String showSignUpForm(Model model) {

		model.addAttribute("user", new User());
		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegistration(User user) {
		service.saveUserWithDefaultRole(user);
		return "register_success";

	}

	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);

		return "users";
	}
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Long id,Model model){
		User user=service.get(id);
		List<Role> listRoles=service.getRoles();
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);

		return "user_form";
	}
	@PostMapping("/users/save")
	public String saveUser(User user)
	{
		service.save(user);
		return "redirect:/list_users" ;
	}
	

}
