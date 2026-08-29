import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingMallAuth {

    static ArrayList<User> users = new ArrayList<>();

    static String[] products = {
        "Shoes",
        "T-Shirt",
        "Watch",
        "Bag",
        "Headphones"
    };

    static int[] prices = {
        1500,
        800,
        2500,
        1200,
        3000
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Shopping Mall =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    users.add(new User(name, email, password));

                    System.out.println("Registration Successful!");
                    break;

                case 2:
                    System.out.print("Enter Email: ");
                    String loginEmail = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String loginPassword = sc.nextLine();

                    boolean found = false;

                    for (User u : users) {

                        if (u.email.equals(loginEmail)
                                && u.password.equals(loginPassword)) {

                            found = true;

                            System.out.println("Login Successful!");
                            System.out.println("Welcome " + u.name);

                            while (true) {

                                System.out.println("\n===== Shopping Menu =====");
                                System.out.println("1. Browse Products");
                                System.out.println("2. Add to Cart");
                                System.out.println("3. View Cart");
                                System.out.println("4. Checkout");
                                System.out.println("5. Logout");
                                System.out.print("Enter Choice: ");

                                int ch = sc.nextInt();
                                sc.nextLine();

                                switch (ch) {

                                    case 1:
                                        System.out.println("\nAvailable Products");

                                        for (int i = 0; i < products.length; i++) {
                                            System.out.println(
                                                (i + 1) + ". " + products[i]
                                                + " - Rs." + prices[i]
                                            );
                                        }
                                        break;

                                    case 2:
                                        System.out.println("\nAvailable Products");

                                        for (int i = 0; i < products.length; i++) {
                                            System.out.println(
                                                (i + 1) + ". " + products[i]
                                                + " - Rs." + prices[i]
                                            );
                                        }

                                        System.out.print("Enter Product Number: ");
                                        int p = sc.nextInt();
                                        sc.nextLine();

                                        if (p >= 1 && p <= products.length) {
                                            u.cart.add(products[p - 1]);

                                            System.out.println(
                                                products[p - 1] + " Added to Cart."
                                            );
                                        } else {
                                            System.out.println("Invalid Product");
                                        }
                                        break;

                                    case 3:
                                        if (u.cart.isEmpty()) {
                                            System.out.println("Cart is Empty");
                                        } else {
                                            System.out.println("\nYour Cart");

                                            for (String item : u.cart) {
                                                System.out.println(item);
                                            }
                                        }
                                        break;

                                    case 4:
                                        if (u.cart.isEmpty()) {
                                            System.out.println("Cart is Empty");
                                        } else {

                                            int total = 0;

                                            System.out.println("\n===== Checkout =====");

                                            for (String item : u.cart) {

                                                for (int i = 0; i < products.length; i++) {

                                                    if (item.equals(products[i])) {

                                                        System.out.println(
                                                            item + " - Rs." + prices[i]
                                                        );

                                                        total += prices[i];
                                                    }
                                                }
                                            }

                                            System.out.println(
                                                "Total Amount = Rs." + total
                                            );

                                            System.out.println(
                                                "Order Placed Successfully!"
                                            );

                                            u.cart.clear();
                                        }
                                        break;

                                    case 5:
                                        System.out.println("Logged Out!");
                                        break;

                                    default:
                                        System.out.println("Invalid Choice");
                                }

                                if (ch == 5) {
                                    break;
                                }
                            }

                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid Email or Password");
                    }
                    break;

                case 3:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}