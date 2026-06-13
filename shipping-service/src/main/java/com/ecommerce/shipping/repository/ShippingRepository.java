package com.ecommerce.shipping.repository;

import com.ecommerce.shipping.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    // Order ID එක භාවිතයෙන් Shipping විස්තර සෙවීමට
    Optional<Shipping> findByOrderId(Long orderId);
}