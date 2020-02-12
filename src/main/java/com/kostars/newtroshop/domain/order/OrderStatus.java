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
@ToString(exclude = {"orderList"})
    public class OrderStatus {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long orderStatusId;

        private String orderDescription;//주문완료,주문취소,배송중

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderStatus")
        private List<Order> orderList;

}
