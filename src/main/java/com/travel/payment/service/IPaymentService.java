package com.travel.payment.service;

import com.travel.payment.dto.PaymentCreateDto;
import com.travel.payment.dto.PaymentUpdateDto;
import com.travel.payment.paymentdb.model.PaymentModel;
import com.travel.payment.userdb.model.UserModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IPaymentService {
    public PaymentModel createPayment(PaymentCreateDto paymentCreateDto);
    public PaymentModel updatePayment(PaymentUpdateDto paymentUpdateDto, Integer id) throws ParseException;
    public Map<String, Object> deletePayment(Integer id);
    public PaymentModel getPayment(Integer id);
    public List<PaymentModel> getAllPayment();
    public List<UserModel> getAllUsers();
}
