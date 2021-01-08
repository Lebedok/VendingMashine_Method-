package com.techtorial;

public class Instructions {

    /*
     * Vending machine options are:
     * 1 - List all items/products, names of products
     * 2 - Get item/product info (details, availability), price and inventory number
     * 3 - Select a product
     * 4 - Get item/product price
     * 5 - List all prices
     * 6 - Set price range
     * 7-  Less than 6 amount in the inventory
     * 8 - Exit
     * 9 - Buy an item
     */

    public static void getInstructions(int input) {

        switch (input) {
            case 0:
                System.out.println("Press 0 for getting the instructions");
            case 1:
                System.out.println("1 - List all items/products, names of products");
            case 2:
                System.out.println("2 - Get item/product info(details, availability), price and inventory number");
            case 3:
                System.out.println("3 - Select a product");
            case 4:
                System.out.println("4 - Get item/product price");
            case 5:
                System.out.println("5 - List all prices");
            case 6:
                System.out.println("6 - Set price range");
            case 7:
                System.out.println("7 - Less than 6 amount in the inventory");
            case 8:
                System.out.println("8 - Exit");
            case 9:
                System.out.println("9 - Buy an item");
            default:
                System.out.println("Please enter 0");
        }
    }

}
