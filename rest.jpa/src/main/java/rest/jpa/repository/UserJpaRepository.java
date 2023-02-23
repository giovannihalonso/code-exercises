package rest.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import rest.jpa.model.Users;

@Component
public interface UserJpaRepository extends JpaRepository<Users, Long> {

	public Users findByName(String name) ;	
}
