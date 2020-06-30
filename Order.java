package edu.psu.ist;

import java.util.ArrayList;

public class Order {

        //Class Level Variables - Protect the data
        private int orderId;
        private Customer cust;
        public ArrayList<Item> cartList;

        //Constructor Method
        public Order(int _orderId, ArrayList<Item> cartList){
            this.orderId = _orderId;
        }

        public Customer getCust() {
            return cust;
        }

        public void setCust(Customer cust) {
            this.cust = cust;
        }

        public void getCartList(ArrayList<Item> cartList) {
            for (edu.psu.ist.Item item : cartList) {
                System.out.println(item.getItemName());
            }
        }

        public void setCartList(ArrayList<Item> cartList) {
            this.cartList = cartList;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int _orderId) {
            this.orderId = _orderId;
        }

        public static double getOrderTotal(ArrayList<Item> cartList){
            double total = 0;
            for(Item i: cartList){
                total = total + i.getPrice();
            }
            return total;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId;
        }
}


