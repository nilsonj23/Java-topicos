package nisonj._ProjetoWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nisonj._ProjetoWeb.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}