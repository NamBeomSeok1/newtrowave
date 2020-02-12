package com.kostars.newtroshop.domain.order;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"order","orderItemsStatus"})
@Builder
@Accessors(chain = true)
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemsId;

    private Integer orderPrice;

    private Integer orderQuantity;

    @Column(name = "RMA_number")
    private Integer rmaNumber;

    @Column(name = "RMA_issued_date")
    private LocalDateTime rmaIssuedDate;

    @Column(name = "RMA_issued_by")
    private String rmaissuedBy;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name ="order_items_status_id")
    private OrderItemsStatus orderItemsStatus;





}
