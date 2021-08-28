package com.example.employee.enums;

public enum AccountType {

    CHECKING_ACCOUNT("CHECKING_ACCOUNT"),
    SAVINGS_ACCOUNT("SAVINGS_ACCOUNT"),
    MONEY_MARKET_ACCOUNT("MONEY_MARKET_ACCOUNT"),
    RETIREMENT_ACCOUNT("RETIREMENT_ACCOUNT");

    private String type;

    private AccountType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

}
