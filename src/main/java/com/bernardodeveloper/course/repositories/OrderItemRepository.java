package com.bernardodeveloper.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bernardodeveloper.course.entities.OrderItem;
import com.bernardodeveloper.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
