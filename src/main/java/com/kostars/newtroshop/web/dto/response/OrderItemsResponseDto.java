package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.product.Product;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"products"})
public class OrderItemsResponseDto {

    private Long orderItemsId;

    private BigDecimal orderPrice;

    private Integer orderQuantity;

    private Integer rmaNumber;

    private LocalDateTime rmaIssuedDate;

    private String rmaIssuedBy;

    private Long prductId;

    private Long orderId;

    private Long orderItemsStatusId;

    private Product products;

}
