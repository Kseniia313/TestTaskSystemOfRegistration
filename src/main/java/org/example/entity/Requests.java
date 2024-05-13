package org.example.entity;

import lombok.*;
import org.example.dto.StatusRequest;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Component
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "requests")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Integer id;

    @Column(name = "TITLE",nullable = false)
    private String title;

    @Column(name = "TEXT",nullable = false)
    private String description;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusRequest statusRequest;

    @Column(name = "REG_DATE", nullable = false)
    private LocalDateTime creationTime;

    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;
}
