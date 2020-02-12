package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.order.Ordered;

import java.util.List;

public class OrderStatusResponseDto {

    private Long orderStatusId;

    private String orderDescription;

    private List<Ordered> orderedList;
}
