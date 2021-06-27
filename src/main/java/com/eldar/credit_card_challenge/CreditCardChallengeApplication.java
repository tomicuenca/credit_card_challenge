package com.eldar.credit_card_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import com.eldar.credit_card_challenge.models.*;

@SpringBootApplication
public class CreditCardChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardChallengeApplication.class, args);
	}

	@Bean
	@Scope("prototype")
	public CreditCardModel creditCard_Visa(){
		return CreditCardModel.creditCard_Visa();
	}

	@Bean
	@Scope("singleton")
	public CreditCardModel creditCard_Generic_Visa(){
		return CreditCardModel.creditCard_Visa();
	}

	@Bean
	@Scope("prototype")
	public CreditCardModel creditCard_Nara(){
		return CreditCardModel.creditCard_Nara();
	}

	@Bean
	@Scope("singleton")
	public CreditCardModel creditCard_Generic_Nara(){
		return CreditCardModel.creditCard_Nara();
	}

	@Bean
	@Scope("prototype")
	public CreditCardModel creditCard_Amex(){
		return CreditCardModel.creditCard_Amex();
	}

	@Bean
	@Scope("singleton")
	public CreditCardModel creditCard_Generic_Amex(){
		return CreditCardModel.creditCard_Amex();
	}

}
