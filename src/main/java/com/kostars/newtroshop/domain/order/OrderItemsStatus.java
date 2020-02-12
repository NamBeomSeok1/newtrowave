package com.kostars.newtroshop.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"orderItemsList"})
public class OrderItemsStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemsStatusId;

    @Column
    private String orderItemsStatus;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "orderItemsStatus")
    private List<OrderItems> orderItemsList;
}
