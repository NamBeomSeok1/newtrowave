package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.order.OrderItems;
import com.kostars.newtroshop.domain.order.Ordered;
import com.kostars.newtroshop.domain.order.OrderedRepository;
import com.kostars.newtroshop.domain.order.OrderStatusRepository;
import com.kostars.newtroshop.domain.user.UserRepository;
import com.kostars.newtroshop.web.dto.request.OrderedApiRequestDto;
import com.kostars.newtroshop.web.dto.response.OrderedApiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements CrudInterface<OrderedApiRequestDto, OrderedApiResponseDto> {

    @Autowired
    private OrderedRepository orderedRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;


    @Override
    public Header<OrderedApiResponseDto> create(Header<OrderedApiRequestDto> request) {

        OrderedApiRequestDto body = request.getData();

        Ordered order = Ordered.builder()
                .orderStatus(orderStatusRepository.getOne(body.getOrderStatusId()))
                .user(userRepository.getOne(body.getId()))
                .createdAt(LocalDateTime.now())
                .build();

        Ordered newOrder = orderedRepository.save(order);

    return Header.OK();

    }

    @Override
    public Header<OrderedApiResponseDto> read(Long id) {

        return orderedRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    @Override
    public Header<OrderedApiResponseDto> update(Header<OrderedApiRequestDto> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<OrderedApiResponseDto> response(Ordered order){

        OrderedApiResponseDto body = OrderedApiResponseDto.builder()
                .orderId(order.getId())
                .Id(order.getUser().getId())
                .orderStatusId(order.getOrderStatus().getOrderStatusId())
                .createdAt(LocalDateTime.now())
                .orderItemsList(order.getOrderItemsList())
                .build();

        return Header.OK(body);
    }
}
