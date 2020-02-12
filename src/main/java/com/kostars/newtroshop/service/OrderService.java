package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.order.Order;
import com.kostars.newtroshop.domain.order.OrderRepository;
import com.kostars.newtroshop.domain.order.OrderStatusRepository;
import com.kostars.newtroshop.domain.user.UserRepository;
import com.kostars.newtroshop.web.dto.request.OrderApiRequestDto;
import com.kostars.newtroshop.web.dto.response.OrderApiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService implements CrudInterface<OrderApiRequestDto, OrderApiResponseDto> {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;


    @Override
    public Header<OrderApiResponseDto> create(Header<OrderApiRequestDto> request) {

        OrderApiRequestDto body = request.getData();

        Order order = Order.builder()
                .orderStatus(orderStatusRepository.getOne(body.getOrderStatusOrderStatusId()))
                .user(userRepository.getOne(body.getOrderStatusOrderStatusId()))
                .createdAt(LocalDateTime.now())
                .build();

        Order newOrder = orderRepository.save(order);

        return null;


    }

    @Override
    public Header<OrderApiResponseDto> read(Long id) {
        return null;
    }

    @Override
    public Header<OrderApiResponseDto> update(Header<OrderApiRequestDto> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<OrderApiResponseDto> response(Order order){

        OrderApiResponseDto body = OrderApiResponseDto.builder()
                .orderStatusOrderStatusId(order.getUser().getId())
                .userId(order.getOrderStatus().getOrderStatusId())
                .createdAt(LocalDateTime.now())
                .build();

        return Header.OK(body);
    }
}
