package com.eldar.credit_card_challenge.models;

import java.util.Calendar;

public interface FeeStrategy {

	static Calendar currentDate = Calendar.getInstance();

	static Double minMax(Double fee) {
		if (fee < 0.3) {
			return 0.3;
		} else if (fee > 5.0) {
			return 5.0;
		} else {
			return fee;
		}
	}

	public abstract Double operationFee();

	default Double operationFeeAmount(Double amount) {
		return (amount * this.operationFee() / 100);
	};

}
