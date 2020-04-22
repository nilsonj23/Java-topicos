package nisonj._ProjetoWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nisonj._ProjetoWeb.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}