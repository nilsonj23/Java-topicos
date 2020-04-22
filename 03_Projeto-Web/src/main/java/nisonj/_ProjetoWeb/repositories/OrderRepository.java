package nisonj._ProjetoWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nisonj._ProjetoWeb.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}