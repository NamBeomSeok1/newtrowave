package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.order.Ordered;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderStatusResponseDto {

    private Long orderStatusId;

    private String orderDescription;

    private List<Ordered> orderedList;
}
