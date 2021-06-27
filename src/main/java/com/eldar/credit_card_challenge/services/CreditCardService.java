package com.eldar.credit_card_challenge.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eldar.credit_card_challenge.models.CreditCardModel;
import com.eldar.credit_card_challenge.CreditCardChallengeApplication;

@Service
public class CreditCardService {

    public ResponseEntity<String> operationFee(String brand, Double operationAmount) {
        try {

            ApplicationContext context = new AnnotationConfigApplicationContext(CreditCardChallengeApplication.class);
            if (operationAmount > 0.0) {
                switch (brand) {
                    case "Visa":
                        CreditCardModel genericVisaCreditCard = context.getBean("creditCard_Generic_Visa",
                                CreditCardModel.class);
                        return new ResponseEntity<String>((genericVisaCreditCard.operationFee(operationAmount)),
                                HttpStatus.OK);
                    case "Nara":
                        CreditCardModel genericNaraCreditCard = context.getBean("creditCard_Generic_Nara",
                                CreditCardModel.class);
                        return new ResponseEntity<String>((genericNaraCreditCard.operationFee(operationAmount)),
                                HttpStatus.OK);
                    case "Amex":
                        CreditCardModel genericAmexCreditCard = context.getBean("creditCard_Generic_Amex",
                                CreditCardModel.class);
                        return new ResponseEntity<String>((genericAmexCreditCard.operationFee(operationAmount)),
                                HttpStatus.OK);
                    default:
                        return new ResponseEntity<String>(("Invalid credit card brand"), HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<String>(("Invalid amount for this operation"), HttpStatus.BAD_REQUEST);
            }
        } catch (RuntimeException e) {
            System.out.println("Error" + e);
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

}
