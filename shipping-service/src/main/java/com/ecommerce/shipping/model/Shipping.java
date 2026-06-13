package com.ecommerce.shipping.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shipping")
@Data
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;          // Order Service එකේ ඇති Order ID එක
    private String trackingNumber; // පාරිභෝගිකයාට ඇණවුම ලුහුබැඳීමට දෙන අංකය
    private String status;         // PENDING, SHIPPED, DELIVERED
    private String deliveryAddress;
}