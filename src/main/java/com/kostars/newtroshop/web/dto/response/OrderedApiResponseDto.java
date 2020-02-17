package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.order.OrderItems;
import com.kostars.newtroshop.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"orderItemsList"})
public class OrderedApiResponseDto {


    private Long orderId;

    private String orderDetails;

    private LocalDateTime createdAt;

    private Long Id;

    private Long orderStatusId;

    private List<OrderItems> orderItemsList;

    private User user;

}

