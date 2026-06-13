package com.ecommerce.inventory.controller;

import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // 1. POST: අලුත් භාණ්ඩයක තොග මට්ටම ඇතුළත් කිරීමට
    @PostMapping("/stock/init")
    public Inventory initializeStock(@RequestBody Inventory inventory) {
        return inventoryService.initializeStock(inventory);
    }

    // 2. GET: Product ID එක ලබා දී තොග ප්‍රමාණය පරීක්ෂා කිරීමට
    @GetMapping("/stock/{productId}")
    public ResponseEntity<Inventory> checkStock(@PathVariable Long productId) {
        Optional<Inventory> inventory = inventoryService.getStockByProductId(productId);
        return inventory.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}