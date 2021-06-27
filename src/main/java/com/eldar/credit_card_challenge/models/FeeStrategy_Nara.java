package com.eldar.credit_card_challenge.models;

import java.util.Calendar;

public class FeeStrategy_Nara implements FeeStrategy {

	public Double operationFee() {
		return FeeStrategy.minMax((Double.valueOf(currentDate.get(Calendar.DATE))) * 0.5);
	};

}
