package com.travel.payment.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Data
@Builder
public class PaymentCreateDto {

    @NotBlank(message = "Invalid payment type: Empty payment type")
    @NotNull(message = "Invalid payment type: payment type is NULL")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    private String payment_type;

    @NotBlank(message = "Invalid total price: Empty total price")
    @NotNull(message = "Invalid total price: total price is NULL")
    private String totalPrice;

    @NotNull(message = "Invalid date: date is NULL")
    private Date date;

    @NotNull(message = "Invalid status: status is NULL")
    private boolean status;
}
