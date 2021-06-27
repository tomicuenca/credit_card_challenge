package com.eldar.credit_card_challenge.models;

import java.util.Date;

public class CreditCardModel {

	private String brand;

	private String creditCardNumber;

	private String cardholder;

	private Date expirationDate;

	private FeeStrategy feeStrategy;

	public static CreditCardModel creditCard_Visa() {
		return new CreditCardModel("Visa", new FeeStrategy_Visa());
	}

	public static CreditCardModel creditCard_Nara() {
		return new CreditCardModel("Nara", new FeeStrategy_Nara());
	}

	public static CreditCardModel creditCard_Amex() {
		return new CreditCardModel("Amex", new FeeStrategy_Amex());
	}

	private CreditCardModel(String brand, FeeStrategy feeStrategy) {
		this.brand = brand;
		this.feeStrategy = feeStrategy;
	}

	public String getInfo() {
		return "Brand: " + this.brand + "\nCredit card number: " + this.creditCardNumber.toString() + "\nCardholder: "
				+ this.cardholder + "\nExpiration date: " + this.expirationDate.toString();
	}

	public Boolean validateOperation(Double operationAmount) {
		return (operationAmount <= 1000);
	}

	public Boolean validateCreditCard() {
		return this.expirationDate.after(new Date());
	}

	public String operationFee(Double operationAmount) {
		return "Operation fee: " + this.feeStrategy.operationFee() + "% ($"
				+ feeStrategy.operationFeeAmount(operationAmount) + ")";
	}

	@Override
	public boolean equals(Object object) {
		CreditCardModel creditCard = (CreditCardModel) object;
		if (object.getClass().equals(this.getClass())) {
			if ((creditCard.getBrand() == this.brand) && (creditCard.getCreditCardNumber() == this.creditCardNumber)
					&& (creditCard.getCardholder() == this.cardholder)
					&& (creditCard.getExpirationDate().equals(this.expirationDate))) {
				return true;
			}
		}
		return false;
	}

	public String getBrand() {
		return brand;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCardholder() {
		return cardholder;
	}

	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
