package facade;

import model.Customer;
import utils.CustomerType;

public class CustomerBonuses {

    public boolean isRabateAllowed(Customer customer) {
        if (customer.getCustomerType().equals(CustomerType.NEW))
            return false;
        return true;
    }

    public boolean isLeasingAllowed(Customer customer) {
        if (customer.getCustomerType().equals(CustomerType.NEW))
            return false;
        else if (!customer.isBankApproved())
            return false;

        return true;
    }
}
