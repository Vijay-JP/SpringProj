package com.spring.model;

public class UniqueInvestments {

    public String portal;
    public float amount;
    
    public String getPortal() {
        return portal;
    }
    public void setPortal(String portal) {
        this.portal = portal;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    public UniqueInvestments(String portal, float amount) {
        this.portal = portal;
        this.amount = amount;
    }
    
}