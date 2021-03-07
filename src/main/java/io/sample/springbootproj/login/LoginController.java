package io.sample.springbootproj.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.POST, value ="/signup")
	public String signUp(@RequestBody User user ) {
		user.setStatus(false);
		return loginService.addUser(user);
		 
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(@RequestBody User user) {
		return loginService.validateUser(user.getUserName(),user.getPassword());
	}
	
	@RequestMapping("/users/list")
	public List<User> getAllUsers() {
		return loginService.getAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/signup/request/access/{userName}")
	public String approveUser(@PathVariable("userName") String userName) {
		return loginService.updateUser("userName");
	}
	
	
}
