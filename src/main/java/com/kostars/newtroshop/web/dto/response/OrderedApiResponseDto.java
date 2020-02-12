package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.order.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderedApiResponseDto {


    private Long orderId;

    private String orderDetails;

    private LocalDateTime createdAt;

    private Long Id;

    private Long orderStatusId;

    private List<OrderItems> orderItemsList;

}

