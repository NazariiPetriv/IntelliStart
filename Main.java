import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] productId = {1, 2, 3};
        String[] productName = {"Backpack", "Wallet", "Socks"};
        double[] productPrice = {14.9, 6.99, 2.99};

        int[] clientId = {1, 2, 3};
        String[] clientName = {"Andriy Schevchenko", "George Bush", "Volodymyr Kluchko"};
        double[] clientMoney = {99.5, 2, 15.7};

        System.out.println("Welcome to our shop!");
        getListOfClient(clientId, clientName, clientMoney);
        getListOfProducts(productId, productName, productPrice);

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter ID of user who want to buy product and product ID: ");
            int clId = in.nextInt() - 1;
            int prodId = in.nextInt() - 1;

            if (clientMoney[clId] < productPrice[prodId]) {
                System.out.println("He does not have enough money!\n");
            } else {
                clientMoney[clId] -= productPrice[prodId];
                System.out.println("Client " + clientName[clId] + " has successfully purchased - " + productName[prodId] + "\n");
            }
            getListOfClient(clientId, clientName, clientMoney);
            getListOfProducts(productId, productName, productPrice);
        }
    }

    private static void getListOfProducts(int[] productId, String[] productName, double[] productPrice){
        for (int i=0; i<=productId.length - 1; i++) {
            System.out.println("Product ID - " + productId[i] + "; Name - " + productName[i] + "; Price - " + productPrice[i] + "$");
        }
        System.out.print("\n");
    }

    private static void getListOfClient(int[] clientId, String[] clientName, double[] clientMoney){
        for (int i=0; i<=clientId.length - 1; i++) {
            System.out.println("Client ID - " + clientId[i] + "; Name - " + clientName[i] + "; Amount of money - " + clientMoney[i] + "$");
        }
        System.out.print("\n");
    }
}
