import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product playStation = new Product(1, "PlayStation", 1000.00);
        Product xbox = new Product(2, "Xbox", 900.00);
        Product iphone = new Product(3, "Iphone", 150.00);

        List<Product> products = new ArrayList<>();
        products.add(playStation);
        products.add(xbox);
        products.add(iphone);

        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: "
                    + product.getPrice() + ".");
        }
        System.out.print("\n");

        User steve = new User(1, "Steve", "Jobs", 1500.00);
        User donald = new User(2, "Donald", "Trump", 600.00);
        User george = new User(3, "George", "Bush", 150.00);

        List<User> users = new ArrayList<>();
        users.add(steve);
        users.add(donald);
        users.add(george);

        for (User user : users) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getFirstName() + " " + user.getSecondName()
                    + ", Amount of money: " + user.getMoney());
        }
        System.out.print("\n");


        boolean shouldContinue = false;
        do {
            start(users, products);

            Scanner in = new Scanner(System.in);

            System.out.println("Would you like to continue (yes/no)?");
            String answer = in.nextLine();

            if (answer.equals("yes")) {
                shouldContinue = true;
            } else {
                shouldContinue = false;
            }
        } while (shouldContinue);

    }

    private static void start(List<User> users, List<Product> products) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter user ID: ");
        int userId = in.nextInt();

        System.out.println("Please enter product ID: ");
        int productId = in.nextInt();

        for (User user : users) {
            if (user.getId() == userId) {
                for (Product product : products) {
                    if (product.getId() == productId) {
                        user.purchase(product);
                        product.addUser(user);
                        System.out.println("Customer " + user.getFirstName() + " " + user.getSecondName() +
                                " successfully bought: " + product.getName());
                    }
                }
            }
        }

        for (User user : users) {
            if (user.getProducts().size() > 0) {
                System.out.println("User: " + user.getFirstName() + " " + user.getSecondName() + ", products: " + user.getPrNames());
            }
        }

        for (Product product : products) {
            if (product.getUser().size() > 0) {
                System.out.println(("Product: " + product.getName() + " was bought: "  + product.getUrNames()));
            }
        }
    }

    public static class Product {
        private final Integer id;
        private final String name;
        private final Double price;
        private final List<User> users = new ArrayList<>();

          public Product(Integer id, String name, Double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Double getPrice() {
            return price;
        }

        public List<User> getUser() {
            return users;
        }
        public String getUrNames() {
            String names = "";
            for (User user : users) {
                names = names.concat(user.getFirstName()).concat(" ").concat(user.getSecondName()).concat(", ");
            }

            return names;
        }
        public void addUser(User user) {
              users.add(user);
        }
    }

    public static class User {
        private final Integer id;
        private final String firstName;
        private final String secondName;
        private Double money;
        private final List<Product> products = new ArrayList<>();

        public User(Integer id, String firstName, String secondName, Double money) {
            this.id = id;
            this.firstName = firstName;
            this.secondName = secondName;
            this.money = money;
        }

        public Integer getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public Double getMoney() {
            return money;
        }

        public List<Product> getProducts() {
            return products;
        }
        public String getPrNames() {
            String names = "";
            for (Product product : products) {
                names = names.concat(product.getName()).concat(", ");
            }

            return names;
        }

        public void purchase(Product product) {
            money = money - product.getPrice();
            products.add(product);
        }
    }
}

