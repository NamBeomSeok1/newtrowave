package com.kostars.newtroshop.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemsStatusRepository extends JpaRepository<OrderItemsStatus,Long> {

}
