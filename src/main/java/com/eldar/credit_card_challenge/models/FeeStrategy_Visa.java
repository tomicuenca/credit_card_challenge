package com.eldar.credit_card_challenge.models;

import java.util.Calendar;

public class FeeStrategy_Visa implements FeeStrategy {

	public Double operationFee() {
		return FeeStrategy.minMax((Double.valueOf(currentDate.get(Calendar.YEAR) - 2000))
				/ (Double.valueOf(currentDate.get(Calendar.MONTH) + 1)));
	}

}