package io.sample.springbootproj.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public String addUser(User user) {
		
		try {
			loginRepository.save(user);
			return LoginResponse.SUCCESS.name();
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return LoginResponse.FAILED.name();
		}
	}
	
	public String validateUser(String userName, String password) {
		try {
			User value = loginRepository.findById(userName).get();
			if(value ==null && password != value.getPassword()) return LoginResponse.FAILED.name();
			else return LoginResponse.SUCCESS.name();
		} catch (Exception e) {
			return LoginResponse.FAILED.name();
		}
	}

	public List<User> getAllUsers() {
		try {
			List<User> userList = new ArrayList<User>();
			loginRepository.findAll().forEach(userList::add);
			return userList;
		} catch (Exception e) {
			return new ArrayList<User>();
		}
	}

	public String updateUser(String userName) {
		try {
			
		User user = (User) loginRepository.findById(userName).get();
		user.setStatus(true);
		loginRepository.save(user);
		return LoginResponse.SUCCESS.name();
	} catch (IllegalArgumentException e) {
		return LoginResponse.FAILED.name();
	}
	}

	public void deleteUser(String userName) {
		loginRepository.deleteById(userName);
	}
}

enum LoginResponse {
	SUCCESS, FAILED
}
