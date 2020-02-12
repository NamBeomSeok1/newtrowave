package com.kostars.newtroshop.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApiResponseDto {


    private Long orderId;

    private String orderDetails;

    private LocalDateTime createdAt;

    private Long userId;

    private Long orderStatusOrderStatusId;

}
