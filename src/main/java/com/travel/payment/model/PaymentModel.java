package com.travel.payment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_payment")
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "payment_type")
    private String payment_type;

    public PaymentModel() {
    }

    public PaymentModel(Integer id, String payment_type) {
        this.id = id;
        this.payment_type = payment_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
}
