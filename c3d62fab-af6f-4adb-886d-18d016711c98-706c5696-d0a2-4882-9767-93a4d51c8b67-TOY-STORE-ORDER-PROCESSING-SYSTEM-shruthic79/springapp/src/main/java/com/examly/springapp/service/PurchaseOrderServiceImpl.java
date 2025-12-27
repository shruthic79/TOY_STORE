package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.repository.PurchaseOrderRepo;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepo repo;

    @Override
    public PurchaseOrder create(PurchaseOrder p) {
        return repo.save(p);
    }

    @Override
    public List<PurchaseOrder> getAll() {
        return repo.findAll();
    }

    @Override
    public PurchaseOrder getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public PurchaseOrder update(Long id, PurchaseOrder p) {
        PurchaseOrder old = repo.findById(id).orElse(null);
        if (old != null) {
            old.setOrderNumber(p.getOrderNumber());
            old.setOrderDate(p.getOrderDate());
            old.setStatus(p.getStatus());
            old.setSupplier(p.getSupplier());
            return repo.save(old);
        }
        return null;
    }
}
