package service;

import bean.Customer;

/**
 * Customerlist is a customer object management module, which manages a set of customer objects with an array
 * and provides the corresponding add, modify, delete and iterate methods
 */
public class CustomerList {
    private final Customer[] customers;
    private int total = 0;

    /**
     * Constructor
     * @param totalCustomer The length of the array
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * Add a new customer to the array
     * @param customer New customer
     * @return true: Add success; false: Add not success
     */
    public boolean addCustomer(Customer customer) {
        if (this.total < customers.length) {
            this.customers[total] = customer;
            this.total++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Replace a customer in the array
     * @param index The index of customer to be replaced
     * @param customer The new customer
     * @return true: Replace success; false: Replace not success
     */
    public boolean replaceCustomer(int index, Customer customer) {
        if (index < 0 || index >= this.total) {
            return false;
        } else {
            this.customers[index] = customer;
            return true;
        }
    }

    /**
     * Delete a customer from the array
     * @param index The index of customer to be replaced
     * @return true: Delete success; false: Delete not success
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= this.total) {
            return false;
        }

        if (total - 1 - index >= 0) {
            System.arraycopy(customers, index + 1, customers, index, total - 1 - index);
        }
        customers[total - 1] = null;
        total--;
        return true;
    }

    /**
     * Get all customers in the array
     * @return custs All customers in the array
     */
    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[this.total];
        if (this.total >= 0) {
            System.arraycopy(this.customers, 0, custs, 0, this.total);
        }
        return custs;
    }

    /**
     * Get only one customer
     * @param index The index of the customer in the array
     * @return this.customers[index]: The found customer; null: The customer not exists
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= this.total) {
            return null;
        }
        return this.customers[index];
    }

    /**
     * Get the total of customers in the array
     * @return this.total The total of customers in the array
     */
    public int getTotal() {
        return this.total;
    }
}
