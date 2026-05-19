import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] stocks = {"TCS", "Infosys", "Reliance"};
        int[] prices = {3500, 1500, 2800};

        int balance = 20000;
        int quantity = 0;
        int chosenStock = -1;

        while (true) {

            System.out.println("\n===== Stock Trading Simulator =====");
            System.out.println("1. View Available Stocks");
            System.out.println("2. Buy Shares");
            System.out.println("3. Sell Shares");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nAvailable Stocks:");

                    for (int i = 0; i < stocks.length; i++) {

                        System.out.println((i + 1) + ". "
                                + stocks[i] + " : Rs "
                                + prices[i]);
                    }

                    break;

                case 2:

                    System.out.println("\nSelect Stock Number:");

                    for (int i = 0; i < stocks.length; i++) {

                        System.out.println((i + 1) + ". "
                                + stocks[i] + " : Rs "
                                + prices[i]);
                    }

                    int stockChoice = sc.nextInt();

                    if (stockChoice >= 1 &&
                            stockChoice <= stocks.length) {

                        chosenStock = stockChoice - 1;
                    

                        System.out.print("Enter Quantity: ");
                        quantity = sc.nextInt();

                        int totalCost =
                                prices[chosenStock] * quantity;

                        if (balance >= totalCost) {

                            balance = balance - totalCost;

                            System.out.println(
                                    "\nStock Bought Successfully!");

                        } else {

                            System.out.println(
                                    "\nInsufficient Balance!");
                        }

                    } else {

                        System.out.println(
                                "\nInvalid Stock Choice!");
                    }

                    break;

                case 3:

                    if (quantity > 0) {

                        System.out.print(
                                "\nEnter Quantity To Sell: ");

                        int sellQty = sc.nextInt();

                        if (sellQty <= quantity) {

                            quantity = quantity - sellQty;

                            balance = balance +
                                    (prices[chosenStock] * sellQty);

                            System.out.println(
                                    "\nStock Sold Successfully!");

                        } else {

                            System.out.println(
                                    "\nNot Enough Shares!");
                        }

                    } else {

                        System.out.println(
                                "\nNo Shares To Sell!");
                    }

                    break;

                case 4:

                    System.out.println(
                            "\n===== Portfolio =====");

                    if (chosenStock != -1 &&
                            quantity > 0) {

                        System.out.println(
                                "Stock : "
                                        + stocks[chosenStock]);

                        System.out.println(
                                "Shares : "
                                        + quantity);

                        System.out.println(
                                "Balance : Rs "
                                        + balance);

                    } else {

                        System.out.println(
                                "No Stocks Purchased Yet!");
                    }

                    break;

                case 5:

                    System.out.println(
                            "\nThank You For Using Stock Trading Simulator");

                    System.exit(0);

                default:

                    System.out.println(
                            "\nInvalid Choice!");
            }
        }
    }
} 


    
