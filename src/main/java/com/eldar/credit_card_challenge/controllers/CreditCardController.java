package com.eldar.credit_card_challenge.controllers;

import com.eldar.credit_card_challenge.services.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> operationFee(@RequestBody Wrapper_brand_operationAmount wrapper) {
        String brand = wrapper.getBrand();
        Double operationAmount = wrapper.getOperationAmount();
        return creditCardService.operationFee(brand, operationAmount);
    }

}
