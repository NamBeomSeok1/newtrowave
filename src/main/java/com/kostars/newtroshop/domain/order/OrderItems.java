package com.kostars.newtroshop.domain.order;

import com.kostars.newtroshop.domain.product.Product;
import lombok.*;
import lombok.experimental.Accessors;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"ordered","orderItemsStatus","product"})
@Builder
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemsId;

    private BigDecimal orderPrice;

    private Integer orderQuantity;

    @Column(name = "RMA_number")
    private Integer rmaNumber;

    @Column(name = "RMA_issued_date")
    private LocalDateTime rmaIssuedDate;

    @Column(name = "RMA_issued_by")
    private String rmaIssuedBy;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Ordered ordered;

    @ManyToOne
    @JoinColumn(name ="order_items_status_id")
    @JsonIgnore
    private OrderItemsStatus orderItemsStatus;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonIgnore
    private Product product;





}
