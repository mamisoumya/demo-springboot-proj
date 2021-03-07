package io.sample.springbootproj.login;

import org.springframework.data.repository.CrudRepository;
  
public interface LoginRepository extends CrudRepository<User, String> {

}
