package com.kostars.newtroshop.web.dto.request;

import com.kostars.newtroshop.domain.order.OrderStatus;
import com.kostars.newtroshop.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApiRequestDto {

    private Long orderId;

    private String orderDetails;

    private LocalDateTime createdAt;

    private Long userId;

    private Long orderStatusOrderStatusId;

}
