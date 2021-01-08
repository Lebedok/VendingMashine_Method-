package com.techtorial;

public class Products {

    /*
	 * Please add more vending machine features
	 * - Buy a product
	 * - Search for a product
	 * - Get list of products
	 */

    private static String[] products  = new String[] {"Monitor", "Mouse", "Keyboard", "USB cable", "Charger", "Mouse pad"};
    private static int[]    prices    = new int[] {100, 70, 89, 17, 99, 5};
    private static int[]    inventory = new int[] {4, 10, 5, 10, 5, 7};


    // Get All Prices
    public static String[] getAllPrices() {
        System.err.println("Product: price");
        for (int j = 0; j < products.length; j++) {
            System.out.println(products[j] + " : $ " + prices[j]);
        }
        return products;



    }

    // Get Product Price
    public static int getProductPrice(String productName) {

        /*
        This method returns the price for given product. As you see in the parameter we have the productName
        THis method needs to return price according to the product name.
        For Example: if I give the value of Mouse it needs to return the $70
        If we give the value of Charger it needs to return the $99
         */

        for (int i = 0; i < products.length; i++){
            if (productName.equalsIgnoreCase(products[i])){
                return prices[i];
            }
        }
        return -1;
    }

    // List All Product Names
    public static void listAllProductsNames(){
        for (int i = 0; i < products.length; i++){
            System.out.println(products[i]);
        }
    }


    // Get Product Info
    public static void getProductInfo(String productName){
        for (int i = 0; i < products.length; i++){
            if (productName.equalsIgnoreCase(products[i])){
                System.out.println("The "+ products[i] + " is " + prices[i] + " $. "+ " We have "+ inventory[i] + " "+ products[i]);
            }
        }
    }



    // Select Product
    public static void selectProduct(String productName) {

    	//loop over the product list to find out if it is available in our vending machine
		//if yes find the price (tip: call a specific method)
		//and verify this product is available in inventory
		//ask if customer wants to buy it -> if yes call another method to buy a product
//											-> if no call method to cancel it



       // Select Product
       Products.getProductPrice(productName);
       for (int i = 0; i < products.length; i++){
           if (productName.equalsIgnoreCase(products[i])){
               if (inventory[i] > 0){
                   System.out.println(productName + " is  "+ prices[i] + ".  Would you like to buy this product? ");

               }
           }
       }
    }



    // BUY a PRODUCT
    public static void buyAProduct(String productName, int payment) {
        /*
        Apply payment logic.
        Apply give back change logic
        Apply inventory update logic: if someone buys an item, we should decrement number of available items.
         */

        int productPrice = Products.getProductPrice(productName);

        if (payment > productPrice){
            int change = payment - productPrice;
            System.out.println("Here is your change. " + change);

            for (int i = 0; i < products.length; i++){
                if (productName.equalsIgnoreCase(products[i])){
                    inventory[i] --;
                }
            }

        } else if (payment < productPrice){
            System.out.println("You don't have enough money to buy the product");

        } else if (payment == productPrice){
            System.out.println("You paid exact payment amount");

            for (int i = 0; i < products.length; i++){
                if (productName.equalsIgnoreCase(products[i])){

                    inventory[i] --;
                }
            }
        }


    }
    public static void setRange(int min, int max){
           /*
    Create one method that will set the range for the product. For example if the user set the range
    between $1 to $8 will be able to see only 'Mouse pad' since it is $5.
     */

        for (int i = 0; i < products.length; i++){
            if (prices[i] <= max && prices[i] >= min){
                System.out.println(products[i]);
            }

        }

    }

    public static void printLessInventory(){
         /*
    Create one method that will show only the products that have less than 6 amount in the inventory.
    For example: this method needs to print the Monitor, keyboard and charger since there are less than 6 in the inventory.
     */

        for (int i = 0; i < products.length; i++){
            if (inventory[i] < 6){
                System.out.println(products[i]);
            }
        }
    }


    // LIST of PRICES
    public static void listPrices(){
        for (int i = 0; i < prices.length; i++){
            System.out.println(prices[i]);
        }
    }





}
