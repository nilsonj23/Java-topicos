package nisonj._ProjetoWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nisonj._ProjetoWeb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}