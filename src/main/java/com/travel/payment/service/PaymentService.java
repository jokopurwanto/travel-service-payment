package com.travel.payment.service;

import com.travel.payment.model.PaymentModel;
import com.travel.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<PaymentModel> listAll(){
        return paymentRepository.findAll();
    }

    public PaymentModel get(Integer id){
        return paymentRepository.findById(id).get();
    }

    public void save(PaymentModel catalogModel){
        paymentRepository.save(catalogModel);
    }

    public void delete(Integer id){
        paymentRepository.deleteById(id);
    }

}
