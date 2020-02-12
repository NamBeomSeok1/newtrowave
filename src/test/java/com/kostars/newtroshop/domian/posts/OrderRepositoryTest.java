package com.kostars.newtroshop.domian.posts;

import com.kostars.newtroshop.NewtroshopApplicationTests;
import com.kostars.newtroshop.domain.order.*;
import com.kostars.newtroshop.domain.user.User;
import com.kostars.newtroshop.domain.user.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class OrderRepositoryTest extends NewtroshopApplicationTests {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderItemsStatusRepository orderItemsStatusRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Test
    public void read(){

        userRepository.findById(2L).ifPresent(user -> {
            System.out.println(user.getOrderList().get(0));
        });

    }




}
