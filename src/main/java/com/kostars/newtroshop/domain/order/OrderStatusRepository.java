package com.kostars.newtroshop.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Long> {

    Optional<OrderStatus> findByOrderStatusId(Long id);

}
