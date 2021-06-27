package com.eldar.credit_card_challenge.controllers;

public class Wrapper_brand_operationAmount {

    private String brand;

    private Double operationAmount;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(String operationAmount) {
        this.operationAmount = Double.parseDouble(operationAmount);
    }

}
