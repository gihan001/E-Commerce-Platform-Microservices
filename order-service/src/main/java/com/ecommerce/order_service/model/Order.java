package com.ecommerce.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId; // ඇණවුම කළ පාරිභෝගිකයාගේ හැඳුනුම් අංකය
    private double totalAmount; // මුළු මුදල
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;      // ඇණවුමේ තත්ත්වය
}