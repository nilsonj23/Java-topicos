package nisonj._ProjetoWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nisonj._ProjetoWeb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}