package com.kostars.newtroshop.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemsStatusRequestDto {

    private Long orderItemsStatusId;

    private String orderItemsStatus;
}
