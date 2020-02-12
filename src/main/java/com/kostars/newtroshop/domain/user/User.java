package com.kostars.newtroshop.domain.user;

import com.kostars.newtroshop.domain.order.Order;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< Updated upstream
import lombok.experimental.Accessors;
=======
import lombok.ToString;
>>>>>>> Stashed changes
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
<<<<<<< Updated upstream
@Accessors(chain = true)
=======
@ToString(exclude = {"orderList"})
@Table(name = "user" , schema = "newtrowave")
>>>>>>> Stashed changes
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Column
    private String phoneNumber;

    @CreatedDate
    private LocalDateTime registeredAt;

    @LastModifiedDate

    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orderList = new ArrayList<Order>();

    @Builder
    public User(String name, String email, String picture, Role role, String phoneNumber, LocalDateTime registeredAt) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.registeredAt = registeredAt;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
