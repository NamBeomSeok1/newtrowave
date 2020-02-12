package com.kostars.newtroshop.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Ordered,Long> {

    Optional<Ordered> findById(Long id);
}
