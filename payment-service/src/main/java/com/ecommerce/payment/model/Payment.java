package com.ecommerce.payment.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;       // Order Service එකේ ඇති Order ID එක
    private double amount;
    private String paymentStatus; // SUCCESS, FAILED
    private String transactionId;
}