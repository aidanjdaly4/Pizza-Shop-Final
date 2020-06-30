package edu.psu.ist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        static int cCount = 1;
        static int oCount = 1;
        static int tCount = 1;
        public static void main(String[] args) {

            edu.psu.ist.Main main = new edu.psu.ist.Main();

            final char EXIT_CODE = 'E';
            final char CUST_CODE = 'C';
            final char MENU_CODE = 'M';
            final char ORDE_CODE = 'O';
            final char TRAN_CODE = 'T';
            final char CUST_PRNT = 'P';
            final char HELP_CODE = '?';
            final char ORDE_PRNT = '$';
            char userAction;
            final String PROMPT_ACTION = "Add 'C'ustomer, 'P'rint Customer, List 'M'enu, Add 'O'rder, Print Order'$', List 'T'ransaction or 'E'xit: ";
            ArrayList<Customer> cList = new ArrayList<>();
            ArrayList<Item> mList = new ArrayList<>();
            ArrayList<Order> oList = new ArrayList<>();
            ArrayList<Transaction> tList = new ArrayList<>();
            ArrayList<Item> custCart = new ArrayList<>();
            double total=0;

            Item item1 = new Item(1, "Plain", 3.00);
            Item item2 = new Item(2, "Meat", 4.00);
            Item item3 = new Item(3, "Extra", 5.00);
            Item item4 = new Item(4, "Veg", 4.00);

            mList.add(item1);
            mList.add(item2);
            mList.add(item3);
            mList.add(item4);

            userAction = getAction(PROMPT_ACTION);

            while (userAction != EXIT_CODE) {
                switch(userAction) {

                    case CUST_CODE :
                        cList.add(main.addCustomer());
                        break;
                    case CUST_PRNT :
                        Customer.printCustomer(cList);
                        break;
                    case MENU_CODE :
                        for(Item i : mList) {
                            System.out.println(i.toString());
                        }
                            break;
                    case ORDE_CODE :
                        custCart = main.addOrders(mList);
                        Order order = new Order(oCount++, custCart);
                        oList.add(order);
                        Transaction trans = new Transaction(tCount++, order, PaymentType.cash);
                        tList.add(trans);
                        total = order.getOrderTotal(custCart);
                        break;
                    case TRAN_CODE :
                        Scanner scnr = new Scanner(System.in);
                        for (Transaction t: tList){
                            System.out.println("How would you like to pay? cash or credit?");
                            String temp = scnr.next();
                            switch(temp){
                                case "cash":
                                    t.setPaymentType(PaymentType.cash);
                                    break;
                                case "credit":
                                    t.setPaymentType(PaymentType.credit);
                                    break;
                            }
                            System.out.println(t.toString());
                        }
                        Customer.printCustomer(cList);
                        break;
                    case ORDE_PRNT :
                        for(Item i : custCart) {
                            System.out.println(i.toString());
                        }
                        System.out.println("Total price: $" + total);
                            break;
                }

                userAction = getAction(PROMPT_ACTION);
            }
        }

        public static char getAction(String prompt) {
            Scanner scnr = new Scanner(System.in);
            String answer = "";
            System.out.println(prompt);
            answer = scnr.nextLine().toUpperCase() + " ";
            char firstChar = answer.charAt(0);
            return firstChar;
        }

        public Customer addCustomer(){
            Customer cust = new Customer(cCount++);
            Scanner scnr = new Scanner(System.in);
            System.out.println("Please Enter your Name: ");
            cust.setCustomerName(scnr.nextLine());
            System.out.println("Please Enter your Phone: ");
            cust.setCustomerPhoneNumber(scnr.nextLine());
            return cust;
        }

        public ArrayList<Item> addOrders(ArrayList<Item> mList){
            Scanner scnr = new Scanner(System.in);
            ArrayList<Item> cartList = new ArrayList<>();
            System.out.println("Type menu ID and press enter to add item to order. Press '0' to quit");
            int temp;
                do {
                    temp = scnr.nextInt();
                    for(Item item : mList){
                        if(item.getItemID() == temp){
                            System.out.println(item.getItemName() + " added");
                            cartList.add(item);
                        }
                    }
                } while(temp!=0);
                return cartList;
        }
}







