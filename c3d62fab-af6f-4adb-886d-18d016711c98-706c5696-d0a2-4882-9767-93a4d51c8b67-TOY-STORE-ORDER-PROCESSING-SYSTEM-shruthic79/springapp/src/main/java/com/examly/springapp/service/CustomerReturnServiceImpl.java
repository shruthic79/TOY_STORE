package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.repository.CustomerReturnRepo;

@Service
public class CustomerReturnServiceImpl implements CustomerReturnService {

    @Autowired
    private CustomerReturnRepo repo;

    @Override
    public CustomerReturn create(CustomerReturn c) {
        return repo.save(c);
    }

    @Override
    public List<CustomerReturn> getAll() {
        return repo.findAll();
    }

    @Override
    public CustomerReturn getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public CustomerReturn update(Long id, CustomerReturn c) {
        CustomerReturn old = repo.findById(id).orElse(null);
        if (old != null) {
            old.setReturnDate(c.getReturnDate());
            old.setQuantity(c.getQuantity());
            old.setReason(c.getReason());
            old.setProduct(c.getProduct());
            return repo.save(old);
        }
        return null;
    }
}
