package com.kostars.newtroshop.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemsRequestDto {

    private Long orderItemsId;

    private BigDecimal orderPrice;

    private Integer orderQuantity;

    private Integer rmaNumber;

    private LocalDateTime rmaIssuedDate;

    private String rmaIssuedBy;

    private Long productId;

    private Long orderId;

    private Long orderItemsStatusId;


}
