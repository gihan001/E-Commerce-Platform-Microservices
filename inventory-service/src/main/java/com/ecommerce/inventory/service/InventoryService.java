package com.ecommerce.inventory.service;

import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // 1. අලුත් භාණ්ඩයක තොග මට්ටම ආරම්භ කිරීම (Initialize Stock Level)
    public Inventory initializeStock(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // 2. භාණ්ඩයක පවතින තොග ප්‍රමාණය පරීක්ෂා කිරීම (Check Stock)
    public Optional<Inventory> getStockByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }
}