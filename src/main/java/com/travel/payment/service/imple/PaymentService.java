package com.travel.payment.service.imple;

import com.travel.payment.dto.PaymentCreateDto;
import com.travel.payment.dto.PaymentUpdateDto;
import com.travel.payment.handler.PaymentNotFoundException;
import com.travel.payment.paymentdb.model.PaymentModel;
import com.travel.payment.paymentdb.repository.PaymentRepository;
import com.travel.payment.service.IPaymentService;
import com.travel.payment.userdb.model.UserModel;
import com.travel.payment.userdb.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PaymentService implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PaymentModel createPayment(PaymentCreateDto paymentCreateDto) {
        PaymentModel paymentModel = PaymentModel.builder()
                .payment_type(paymentCreateDto.getPayment_type())
                .totalPrice(paymentCreateDto.getTotalPrice())
                .status(paymentCreateDto.isStatus())
                .date(paymentCreateDto.getDate())
                .build();
        return paymentRepository.save(paymentModel);
    }

    @Override
    public PaymentModel updatePayment(PaymentUpdateDto paymentUpdateDto, Integer id) {
        if(paymentRepository.findById(id).isEmpty())
            throw new PaymentNotFoundException("Data payment yang akan di-update tidak ditemukan");

        PaymentModel paymentModel = PaymentModel.builder()
                .id(id)
                .payment_type(paymentUpdateDto.getPayment_type())
                .totalPrice(paymentUpdateDto.getTotalPrice())
                .date(paymentUpdateDto.getDate())
                .status(paymentUpdateDto.isStatus())
                .build();
        paymentRepository.save(paymentModel);
        return paymentRepository.findById(id).get();
    }

    @Override
    public PaymentModel getPayment(Integer id) {
        if(paymentRepository.findById(id).isEmpty())
            throw new PaymentNotFoundException("Data yang dicari tidak ditemukan");
        return paymentRepository.findById(id).get();
    }

    @Override
    public List<PaymentModel> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Map<String, Object> deletePayment(Integer id) {
        if(paymentRepository.findById(id).isEmpty())
            throw new PaymentNotFoundException("Data yang dicari tidak ditemukan");

        PaymentModel paymentModel = paymentRepository.findById(id).get();
        Map<String,Object> response = new HashMap<>();
        response.put("id", paymentModel.getId());
        response.put("payment_type", paymentModel.getPayment_type());
        response.put("total_price", paymentModel.getTotalPrice());
        response.put("date",paymentModel.getDate());
        response.put("status",paymentModel.isStatus());
        paymentRepository.deleteById(id);
        return response;
    }

//    public List<PaymentModel> listAll(){
//        return paymentRepository.findAll();
//    }
//
//    public PaymentModel get(Integer id){
//        return paymentRepository.findById(id).get();
//    }
//
//    public void save(PaymentModel catalogModel){
//        paymentRepository.save(catalogModel);
//    }
//
//    public void delete(Integer id){
//        paymentRepository.deleteById(id);
//    }

}
