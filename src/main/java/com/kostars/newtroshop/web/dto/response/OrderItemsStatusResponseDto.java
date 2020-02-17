package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.order.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemsStatusResponseDto {

    private Long orderItemsStatusId;

    private String orderItemsStatus;

    private List<OrderItems> orderItemsList;
}
