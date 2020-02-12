package com.kostars.newtroshop.web.dto.request;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderItemsRequestDto {

    private Long orderItemsId;

    private BigDecimal orderPrice;

    private Integer orderQuantity;

    private Integer rmaNumber;

    private LocalDateTime rmaIssuedDate;

    private String rmaIssuedBy;

    private Long prductId;

    private Long orderId;

    private Long orderItemsStatusId;


}
