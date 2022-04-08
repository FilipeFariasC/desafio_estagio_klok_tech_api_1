package tech.klok.challenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.klok.challenge.model.User;

@Repository
public interface UserRepository extends	JpaRepository<User, Long>{
	
	public Optional<User> findByUsername(@Param("username") String username);
}