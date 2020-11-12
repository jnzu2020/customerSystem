package view;

import bean.Customer;
import service.CustomerList;
import util.CMUtility;

/**
 * CustomerView is the main module, for displaying menus and handling user actions
 */
public class CustomerView {
    private final CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer test = new Customer("aaa", 'm', 30, "123456", "123@gmail.com");
        customerList.addCustomer(test);
    }

    /**
     * show the menu
     */
    public void enterMainMenu() {
        boolean loop = true;
        while (loop){
            System.out.println("\n----------Customer Information Management System----------");
            System.out.println("            1 Add Customer");
            System.out.println("            2 Modify Customer");
            System.out.println("            3 Delete Customer");
            System.out.println("            4 List Customers");
            System.out.println("            5 Exit");
            System.out.print("            Please select (1-5): ");

            char selection = CMUtility.readMenuSelection();
            switch (selection) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("Do you want to exit? (Y/N) ");
                    char c = CMUtility.readConfirmSelection();
                    if (c == 'Y') {
                        loop = false;
                    }
            }
        }
    }

    /**
     * Add new customer
     */
    private void addNewCustomer() {
        System.out.println("\n----------Add Customer----------");
        System.out.print("Name: ");
        String name = CMUtility.readString(10);
        System.out.print("Gender (f/m): ");
        char gender = CMUtility.readChar();
        System.out.print("Age: ");
        int age = CMUtility.readInt();
        System.out.print("Phone: ");
        String phone = CMUtility.readString(13);
        System.out.print("Email: ");
        String email = CMUtility.readString(30);
        Customer newCustomer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(newCustomer);
        if (isSuccess) {
            System.out.println("\n----------Add Succeed----------");
        } else {
            System.out.println("\n----------Add Failed----------");
        }
    }

    /**
     * Change the information of customer
     */
    private void modifyCustomer() {
        System.out.println("\n----------Modify Customer----------");
        Customer customer;
        int num;
        while (true) {
            System.out.print("Please input the id of the customer whose information you want to modify " +
                    "(input -1 to exit): ");
            num = CMUtility.readInt();
            if (num == -1) {
                return;
            }
            customer = customerList.getCustomer(num - 1);
            if (customer == null) {
                System.out.println("Can not find this customer");
            } else {
                break;
            }
        }
        System.out.print("Name (" + customer.getName() + "): ");
        String name = CMUtility.readString(10, customer.getName());

        System.out.print("Gender (" + customer.getGender() + "): ");
        char gender = CMUtility.readChar(customer.getGender());

        System.out.print("Age (" + customer.getAge() + "): ");
        int age = CMUtility.readInt(customer.getAge());

        System.out.print("Phone (" + customer.getPhone() + "): ");
        String phone = CMUtility.readString(13, customer.getPhone());

        System.out.print("Email (" + customer.getEmail() + "): ");
        String email = CMUtility.readString(30, customer.getEmail());

        Customer newCustomer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.replaceCustomer(num - 1, newCustomer);
        if (isSuccess) {
            System.out.println("\n----------Modify Succeed----------");
        } else {
            System.out.println("\n----------Modify Failed----------");
        }
    }

    /**
     * Delete a customer
     */
    private void deleteCustomer() {
        System.out.println("\n----------Delete Customer----------");
        Customer customer;
        int num;
        while (true) {
            System.out.print("Please input the id of the customer you want to delete " +
                    "(input -1 to exit): ");
            num = CMUtility.readInt();
            if (num == -1) {
                return;
            }
            customer = customerList.getCustomer(num - 1);
            if (customer == null) {
                System.out.println("Can not find this customer");
            } else {
                break;
            }
        }

        System.out.print("Do you want to delete this customer? (Y/N)");
        char c = CMUtility.readConfirmSelection();
        if (c == 'Y') {
            boolean isSuccess = customerList.deleteCustomer(num - 1);
            if (isSuccess) {
                System.out.println("\n----------Delete Succeed----------");
            } else {
                System.out.println("\n----------Delete Failed----------");
            }
        }
    }

    /**
     * Show information of all customers
     */
    private void listAllCustomers() {
        System.out.println("\n----------List of Customers----------");

        if (customerList.getTotal() == 0) {
            System.out.println("No record");
        } else {
            System.out.println("Id\tName\tGender\tAge\t\tPhone\t\tEmail");
            Customer[] allCustomers = customerList.getAllCustomers();
            int id = 1;
            for (Customer customer : allCustomers) {
                System.out.println(id + "\t" + customer.getName() + "\t\t" + customer.getGender() + "\t\t" +
                        customer.getAge() + "\t\t" + customer.getPhone() + "\t\t" + customer.getEmail());
                id++;
            }
        }

        System.out.println("-------------End of List-------------");
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}
