package com.booking.booking_system.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table (name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Event {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private String description;

    @Column (nullable = false)
    private LocalDateTime event_date;

    @Column (nullable = false)
    private Integer total_capacity;

    @Column (nullable = false)
    private Integer available_seats;

    @Column (nullable = false)
    private Double prince;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();
}
