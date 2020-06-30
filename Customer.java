package edu.psu.ist;

import java.util.ArrayList;

public class Customer {

        //Class Level Variables - Protect the data
        private int customerId;
        String customerName;
        String customerPhoneNumber;

        //Constructor Method
        public Customer(int _customerId) {
            this. customerId = _customerId;  //Increments the ID count
        }

        //Setters and Getters
        public int getCustomerId() { return customerId; }
        public void setCustomerId(int _customerId) {this.customerId = _customerId;}

        public String getCustomerName() { return customerName; }
        public void setCustomerName(String _customerName) {this.customerName = _customerName;}

        public String getCustomerPhoneNumber() { return customerPhoneNumber; }
        public void setCustomerPhoneNumber(String _customerPhoneNumber) {this.customerPhoneNumber = _customerPhoneNumber;}

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    '}';
        }

        public static void printCustomer(ArrayList<edu.psu.ist.Customer> cList){
                for (edu.psu.ist.Customer cust: cList){
                    System.out.println("Customer Id:" + cust.getCustomerId());
                    System.out.println("Customer Name:" + cust.getCustomerName());
                    System.out.println("Customer Phone:" + cust.getCustomerPhoneNumber());
                }
            }
}

