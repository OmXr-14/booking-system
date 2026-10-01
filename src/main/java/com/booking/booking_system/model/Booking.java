package com.booking.booking_system.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import java.time.LocalDateTime;

@Entity
@Table (name = "bookings")
@Getter
@Setter
@NoArgsConstructor
public class Booking {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "user_id", nullable = false)
    private User user;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "event_id", nullable = false)
    private Event event;

    @Column (nullable = false)
    private Integer seats_booked;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private BookingStatus status = BookingStatus.CONFIRMED;

    @Column (nullable = false)
    private LocalDateTime created_at = LocalDateTime.now();

    
    public enum BookingStatus {
        CONFIRMED, CANCELLED
    }

}
