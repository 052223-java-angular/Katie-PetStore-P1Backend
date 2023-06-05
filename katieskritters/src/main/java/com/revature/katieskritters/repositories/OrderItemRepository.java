package com.revature.katieskritters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.katieskritters.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String> {

}
