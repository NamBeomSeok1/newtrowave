package com.kostars.newtroshop.domian.posts;

import com.kostars.newtroshop.NewtroshopApplicationTests;
import com.kostars.newtroshop.domain.order.*;
import com.kostars.newtroshop.domain.product.ProductRepository;
import com.kostars.newtroshop.domain.user.User;
import com.kostars.newtroshop.domain.user.UserRepository;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public class OrderedRepositoryTest extends NewtroshopApplicationTests {

    @Autowired
    OrderedRepository orderedRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderItemsStatusRepository orderItemsStatusRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void orderitemcreate() {

        OrderItems orderItems = new OrderItems();

        orderItems.setOrdered(orderedRepository.getOne(2L));
        orderItems.setOrderItemsStatus(orderItemsStatusRepository.getOne(2L));
        orderItems.setOrderPrice(productRepository.findById(4L).get().getProductPrice());
        orderItems.setOrderQuantity(1);
        orderItems.setProduct(productRepository.findById(3L).get());

        OrderItems newOI = orderItemsRepository.save(orderItems);

    }

    @Test
    @Transactional
    public void read() {


        orderedRepository.findById(2L).ifPresent(e -> {
            System.out.println(e.getOrderItemsList());
        });


    }
}
