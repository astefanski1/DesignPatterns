package model;

import observer.CustomerNotification;
import observer.Observer;
import utils.CustomerType;


public class Customer implements Observer {
    private String name;
    private Integer numberOfCarsBought;
    private CustomerType customerType;
    private boolean rebateAllowed;
    private boolean bankApproved;
    private Car lastCarRented;
    private CustomerNotification customerNotification;

    private static final String message = "Hi %s, added car: %s";

    public Customer (String name, CustomerType customerType, boolean rebateAllowed, Integer numberOfCarsBought, CustomerNotification customerNotification){
        this.name = name;
        this.numberOfCarsBought = numberOfCarsBought;
        this.customerType = customerType;
        this.rebateAllowed = rebateAllowed;
        this.customerNotification = customerNotification;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public boolean isRebateAllowed() {
        return rebateAllowed;
    }

    public void setRebateAllowed(boolean rebateAllowed) {
        this.rebateAllowed = rebateAllowed;
    }

    public boolean isBankApproved() {
        return bankApproved;
    }

    public void setBankApproved(boolean bankApproved) {
        this.bankApproved = bankApproved;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update() {
        lastCarRented = customerNotification.getCar();
        System.out.println(String.format(message, name, lastCarRented.getId()));
    }
}
