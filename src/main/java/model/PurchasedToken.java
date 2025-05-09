package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchased_tokens")
public class PurchasedToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_id")
    private Meter meter;

    @Column(length = 16)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_status")
    private TokenStatus tokenStatus;

    @Column(name = "token_value_days")
    private int tokenValueDays;

    @Column(name = "purchased_date")
    private LocalDateTime purchasedDate;

    @Column(length = 11)
    private int amount;

}
