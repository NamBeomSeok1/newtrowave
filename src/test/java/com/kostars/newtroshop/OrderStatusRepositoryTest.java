package com.kostars.newtroshop;

import com.kostars.newtroshop.domain.order.OrderStatus;
import com.kostars.newtroshop.domain.order.OrderStatusRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderStatusRepositoryTest extends NewtroshopApplicationTests {

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Test
    public void create(){

        OrderStatus os = new OrderStatus( );
        os.setOrderDescription("배송중");

        OrderStatus newOS = orderStatusRepository.save(os);
        Assert.assertNotNull(newOS);
    }

}
