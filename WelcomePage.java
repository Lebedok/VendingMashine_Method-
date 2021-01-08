package com.techtorial;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static com.techtorial.Instructions.getInstructions;


/*
 * This is your main page where the vending machine application is going to be triggered and
 * all inputs being accepted.
 */
public class WelcomePage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Techtorial sponsored vending machine!");
        System.out.println("What is your name?");

        String name = scanner.next();
        System.out.println("Nice to meet you, " + name);
        System.out.println("Please press 0 for available options...");

        int allOptions = getIntegerInput(scanner, new Integer[] {0});
        getInstructions(allOptions);

        scanner = new Scanner(System.in);
        System.out.println("Enter what you want to do: ");

        int count = 0;

        switch (getIntegerInput(scanner, new Integer[] {1, 2, 3, 4, 5, 6, 7, 8})) {
            case 1:
                // method call for get product list
                Products.listAllProductsNames();
                break;
            case 2:
                System.out.println("Which product's info you want to get");
                String productName4 = scanner.nextLine();
                Products.getProductInfo(productName4);

                break;

            case 3:
                System.out.println("Please select a product:");
                String productName1 = scanner.nextLine();
                Products.selectProduct(productName1);
                String yesOrNO = scanner.next();
                System.out.println(productName1 + " price is" + Products.getProductPrice(productName1) + " Please make the payment for the product");

                if (yesOrNO.equalsIgnoreCase("yes")){
                    int payment = scanner.nextInt();
                    Products.buyAProduct(productName1,payment);
                }
                break;

            case 4:
                System.out.println("Enter the item that you want to get the price: ");
                String productName = scanner.nextLine();
                System.out.println(Products.getProductPrice(productName));
                break;

            case 5:
                Products.listPrices();
                break;

            case 6:
                System.out.println("Please enter your minimum price: ");
                int min =  scanner.nextInt();

                System.out.println("Please enter your max price: ");
                int max = scanner.nextInt();
                Products.setRange(min,max);
                break;

            case 7:
                Products.printLessInventory();
                break;

            case 8:

                count++;

                break;

            case 9:
                System.out.println("Please enter the product name which you want to buy: ");
                String productName2 = scanner.nextLine();
                System.out.println("The price for the " + productName2 + " is "+ Products.getProductPrice(productName2));

                System.out.println("Please make a payment");
                int payment3 = scanner.nextInt();
                Products.buyAProduct(productName2,payment3);
                break;
        }


        System.out.println("Thanks for shopping with us");

    }

    private static int getIntegerInput(Scanner scanner, Integer[] expected) {
        int allOptions = -1;
        for (int i = 1; i <= 3; i++) {
            scanner = new Scanner(System.in);
            int input;
            try {
                input = scanner.nextInt();

                if (!Arrays.asList(expected).contains(input)) {
                    throw new IOException();
                }
            } catch (Exception e) {
                if (i < 3) {
                    System.out.println("Please enter 0");
                    System.out.printf("You have %d more retries", 3 - i);
                    System.out.println();
                } else {
                    System.out.println("Sorry, try next time");
                    System.exit(1);
                }
                continue;
            }
            allOptions = input;
            break;
        }
        return allOptions;
    }
}
