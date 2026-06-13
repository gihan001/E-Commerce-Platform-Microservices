package com.ecommerce.shipping.controller;

import com.ecommerce.shipping.model.Shipping;
import com.ecommerce.shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    // 1. POST: බෙදාහැරීමක් පද්ධතියට ඇතුළත් කිරීම (Initiate Delivery)
    @PostMapping
    public Shipping initiateShipping(@RequestBody Shipping shipping) {
        return shippingService.initiateShipping(shipping);
    }

    // 2. GET: Order ID එක ලබා දී Shipping තොරතුරු ලබාගැනීම
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Shipping> getShippingByOrderId(@PathVariable Long orderId) {
        Optional<Shipping> shipping = shippingService.getShippingByOrderId(orderId);
        return shipping.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}