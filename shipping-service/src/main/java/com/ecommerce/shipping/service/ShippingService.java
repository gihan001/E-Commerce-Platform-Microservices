package com.ecommerce.shipping.service;

import com.ecommerce.shipping.model.Shipping;
import com.ecommerce.shipping.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    // 1. බෙදාහැරීමේ කටයුතු ආරම්භ කිරීම (Initiate Delivery)
    public Shipping initiateShipping(Shipping shipping) {
        shipping.setStatus("PENDING");
        // ස්වයංක්‍රීයව SHIP-XXXXX ආකාරයේ Tracking අංකයක් සෑදීම
        String randomTrackNum = "SHIP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        shipping.setTrackingNumber(randomTrackNum);
        return shippingRepository.save(shipping);
    }

    // 2. Order ID එක මඟින් Shipping තත්ත්වය පරීක්ෂා කිරීම
    public Optional<Shipping> getShippingByOrderId(Long orderId) {
        return shippingRepository.findByOrderId(orderId);
    }
}