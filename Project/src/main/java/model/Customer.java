package model;

import utils.CustomerType;

import javax.naming.Name;


public class Customer {
    private String name;
    private int numberOfCarsBought;
    private CustomerType customerType;
    private boolean rebateAllowed;
    private boolean bankApproved;

    public Customer(String name, CustomerType customerType, boolean rebateAllowed, int numberOfCarsBought) {
        this.name = name;
        this.numberOfCarsBought = numberOfCarsBought;
        this.customerType = customerType;
        this.rebateAllowed = rebateAllowed;
    }

    private Customer(Builder builder) {
        this.name = builder.name;
        this.numberOfCarsBought = builder.numberOfCarsBought;
        this.customerType = builder.customerType;
        this.rebateAllowed = builder.rebateAllowed;
        this.bankApproved = builder.bankApproved;
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

    public static class Builder {
        private String name;
        private int numberOfCarsBought;
        private CustomerType customerType;
        private boolean rebateAllowed;
        private boolean bankApproved;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder numberOfCarsBought(int numberOfCarsBought) {
            this.numberOfCarsBought = numberOfCarsBought;
            return this;
        }

        public Builder customerType(CustomerType customerType) {
            this.customerType = customerType;
            return this;
        }

        public Builder rebateAllowed(boolean rebateAllowed) {
            this.rebateAllowed = rebateAllowed;
            return this;
        }

        public Builder bankApproved(boolean bankApproved) {
            this.bankApproved = bankApproved;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "---- " + name + " ---- \n" +
                "Customer Type: " + customerType + "\n" +
                "Number of cars bought: " + numberOfCarsBought + "\n" +
                "Rebate allowed: " + rebateAllowed + "\n" +
                "Bank approved: " + bankApproved + "\n";
    }
}