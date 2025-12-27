// package com.examly.springapp.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/customerreturns")
// public class CustomerReturnController {

//     @GetMapping("/{id}")
//     public String getCustomerReturn(@PathVariable Long id) {
//         return "CustomerReturn";
//     }
// }


package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.service.CustomerReturnService;

@RestController
@RequestMapping("/api/customer-returns")
public class CustomerReturnController {

    @Autowired
    private CustomerReturnService service;

    @PostMapping
    public ResponseEntity<CustomerReturn> create(@RequestBody CustomerReturn c) {
        return new ResponseEntity<>(service.create(c), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerReturn>> getAll() {
        List<CustomerReturn> list = service.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerReturn> getById(@PathVariable Long id) {
        CustomerReturn c = service.getById(id);
        if (c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerReturn> update(@PathVariable Long id, @RequestBody CustomerReturn c) {
        CustomerReturn updated = service.update(id, c);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
