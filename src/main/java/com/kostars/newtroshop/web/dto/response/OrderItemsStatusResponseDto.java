package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.order.OrderItems;

import java.util.List;

public class OrderItemsStatusResponseDto {

    private Long orderItemsStatusId;

    private String orderItemsStatus;

    private List<OrderItems> orderItemsList;
}
