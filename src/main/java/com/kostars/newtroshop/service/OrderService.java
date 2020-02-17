package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.order.*;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.ProductRepository;
import com.kostars.newtroshop.domain.user.UserRepository;
import com.kostars.newtroshop.web.dto.request.OrderItemsRequestDto;
import com.kostars.newtroshop.web.dto.request.OrderedApiRequestDto;
import com.kostars.newtroshop.web.dto.response.OrderItemsResponseDto;
import com.kostars.newtroshop.web.dto.response.OrderedApiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements CrudInterface<OrderedApiRequestDto, OrderedApiResponseDto> {

    @Autowired
    private OrderedRepository orderedRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemsStatusRepository orderItemsStatusRepository;


//ORDER CRUD
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

        OrderedApiRequestDto body = request.getData();
        Optional<Ordered> order =orderedRepository.findById(body.getId());

                order.ifPresent(a->{
                    a.setOrderStatus(orderStatusRepository.getOne(body.getOrderStatusId()));
                    a.setUser(a.getUser());
                });


        return Header.OK();
    }



    @Override
    public Header delete(Long id) {

        System.out.println(id);
        orderedRepository.deleteById(id);

        return Header.OK();
    }

    //ORDER ITEMS  CRD
    public Header<OrderItemsResponseDto> createOrderItem (Header<OrderItemsRequestDto> request) throws Exception {

        OrderItemsRequestDto body = request.getData();
        int quantity = body.getOrderQuantity();
        System.out.println(quantity);

        OrderItems oi = OrderItems.builder()
                .ordered(orderedRepository.getOne(body.getOrderId()))
                .orderItemsStatus(orderItemsStatusRepository.getOne(body.getOrderItemsStatusId()))
                .orderQuantity(quantity)
                .product(productRepository.getOne(body.getProductId()))
                .orderPrice(productRepository.getOne(body.getProductId()).getProductPrice().multiply(BigDecimal.valueOf(quantity)))
                .rmaIssuedBy(body.getRmaIssuedBy())
                .rmaIssuedDate(body.getRmaIssuedDate())
                .rmaNumber(body.getRmaNumber())
                .build();

        OrderItems newoi = orderItemsRepository.save(oi);

        return Header.OK();
    }

    public Header<OrderItemsResponseDto> readOrderItem(Long id){

        OrderItems oi = orderItemsRepository.getOne(id);

        OrderItemsResponseDto body = OrderItemsResponseDto.builder()
                .orderItemsId(oi.getOrderItemsId())
                .orderId(oi.getOrdered().getId())
                .orderItemsStatusId(oi.getOrderItemsStatus().getOrderItemsStatusId())
                .rmaIssuedBy(oi.getRmaIssuedBy())
                .rmaIssuedDate(oi.getRmaIssuedDate())
                .rmaNumber(oi.getRmaNumber())
                .orderPrice(oi.getOrderPrice())
                .orderQuantity(oi.getOrderQuantity())
                .prductId(oi.getProduct().getProductId())
                .products(productRepository.getOne(oi.getProduct().getProductId()))
                .build();


        return Header.OK(body);

    }

    public Header<OrderItemsResponseDto> deleteOrderItem (Long id){

        orderItemsRepository.deleteById(id);
        return Header.OK();
    }

    //etc
    private Header<OrderedApiResponseDto> response(Ordered order){

        OrderedApiResponseDto body = OrderedApiResponseDto.builder()
                .orderId(order.getId())
                .Id(order.getUser().getId())
                .orderStatusId(order.getOrderStatus().getOrderStatusId())
                .createdAt(LocalDateTime.now())
                .orderItemsList(order.getOrderItemsList())
                .user(userRepository.getOne(order.getUser().getId()))
                .build();

        return Header.OK(body);
    }

    private Header<OrderedApiResponseDto> ListItem(List<OrderItems> itemlist){
        OrderedApiResponseDto body = OrderedApiResponseDto.builder()
                .orderItemsList(itemlist)
                .build();

        return Header.OK(body);
    }
}
