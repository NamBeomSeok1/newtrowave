package com.kostars.newtroshop.domain.order;

import com.kostars.newtroshop.domain.user.User;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "order" , schema = "newtrowave")
@ToString(exclude = {"orderItemsList","user","orderStatus"})
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column
    private String orderDetails;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="order_status_id")
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderItems> orderItemsList;

}