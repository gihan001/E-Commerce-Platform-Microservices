package com.ecommerce.payment.service;

import com.ecommerce.payment.model.Payment;
import com.ecommerce.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        // ගෙවීම් පද්ධතියක් අනුකරණය කිරීම (Mock Payment Processing)
        payment.setPaymentStatus("SUCCESS");
        payment.setTransactionId(UUID.randomUUID().toString()); // අහඹු ට්‍රාන්සැක්ෂන් අංකයක් සෑදීම
        return paymentRepository.save(payment);
    }
}