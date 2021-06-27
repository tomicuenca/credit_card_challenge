package com.eldar.credit_card_challenge;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eldar.credit_card_challenge.models.CreditCardModel;

public class Exercise1 {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(CreditCardChallengeApplication.class);

		// object 1
		CreditCardModel visaCreditCard = context.getBean("creditCard_Visa", CreditCardModel.class);

		// object 2
		CreditCardModel naraCreditCard = context.getBean("creditCard_Nara", CreditCardModel.class);

		// object 3
		CreditCardModel amexCreditCard = context.getBean("creditCard_Amex", CreditCardModel.class);

		// test object for equal credit card test
		CreditCardModel amexCreditCard2 = context.getBean("creditCard_Amex", CreditCardModel.class);

		Exercise1.init(visaCreditCard, naraCreditCard, amexCreditCard, amexCreditCard2);

		System.out.println("\nCredit card challenge - Exercise one");

		System.out.println("---------------------------");

		// "Invocar un método que devuelva toda la información de una tarjeta"
		System.out.println(visaCreditCard.getInfo());

		System.out.println("---------------------------");

		// "Informar si una operación es valida"
		if (naraCreditCard.validateOperation(3500.5)) {
			System.out.println("La operación es válida");
		} else {
			System.out.println("La operación no es válida");
		}

		System.out.println("---------------------------");

		// "Informar si una tarjeta es válida para operar"

		if (amexCreditCard.validateCreditCard()) {
			System.out.println("La tarjeta es válida para operar");
		} else {
			System.out.println("La tarjeta no es válida para operar");
		}

		System.out.println("---------------------------");

		// "Identificar si una tarjeta es distinta a otra"
		if (amexCreditCard.equals(amexCreditCard2)) {
			System.out.println("Ambas tarjetas son iguales");
		} else {
			System.out.println("Las tarjetas son distintas");
		}

		System.out.println("---------------------------");

		// "Obtener por medio de un método la tasa de una operación informando marca e
		// importe"
		System.out.println(visaCreditCard.operationFee(7500.0));

		System.out.println("\n");

	}

	private static void init(CreditCardModel visaCreditCard, CreditCardModel naraCreditCard,
			CreditCardModel amexCreditCard, CreditCardModel amexCreditCard2) {

		Calendar exampleDate = new GregorianCalendar(2015, 11, 11);

		visaCreditCard.setCreditCardNumber("4000 1643 2209 8437");

		visaCreditCard.setCardholder("Samuel Rodriguez");

		visaCreditCard.setExpirationDate(exampleDate.getTime());

		exampleDate = new GregorianCalendar(2022, 10, 4);

		naraCreditCard.setCreditCardNumber("5895 8734 7243 8723");

		naraCreditCard.setCardholder("Hugo Perez");

		naraCreditCard.setExpirationDate(exampleDate.getTime());

		exampleDate = new GregorianCalendar(2019, 3, 12);

		amexCreditCard.setCreditCardNumber("3759 4782 1323 8473");

		amexCreditCard.setCardholder("Lucía Gali");

		amexCreditCard.setExpirationDate(exampleDate.getTime());

		amexCreditCard2.setCreditCardNumber("3759 4782 1323 8473");

		amexCreditCard2.setCardholder("Lucía Gali");

		amexCreditCard2.setExpirationDate(exampleDate.getTime());

	}

}