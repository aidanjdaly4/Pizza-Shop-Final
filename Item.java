package edu.psu.ist;

import java.util.ArrayList;

public class Item {

        //Class Level Variables - Protect the data
        int itemID;
        String itemName;
        double price;

        //Constructor Method
        public Item(int _itemID, String _itemName, double price){
            this.price = price;
            this.itemID = _itemID;
            this.itemName = _itemName;
        }

        //Setters and Getters

        public int getItemID() {
            return itemID;
        }

        public void setItemID(int itemID) {
            this.itemID = itemID;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "itemID=" + itemID +
                    ", itemName='" + itemName + '\'' +
                    ", price=" + price +
                    '}';
        }
}


