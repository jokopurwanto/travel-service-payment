package com.travel.payment.controller;

import com.travel.payment.model.PaymentModel;
import com.travel.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment")
    public List<PaymentModel> list(){
        return paymentService.listAll();
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<PaymentModel> get(@PathVariable Integer id){
        try {
            PaymentModel paymentModel = paymentService.get(id);
            return new ResponseEntity<PaymentModel>(paymentModel, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<PaymentModel>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/payment")
    public void add(@RequestBody PaymentModel catalogModel){
        paymentService.save(catalogModel);
    }

    @PutMapping("/payment/{id}")
    public ResponseEntity<?> update(@RequestBody PaymentModel catalogModel, @PathVariable Integer id){
        try {
            PaymentModel existPayment = paymentService.get(id);
            paymentService.save(catalogModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/payment/{id}")
    public void delete(@PathVariable Integer id) {
        paymentService.delete(id);
    }
}
