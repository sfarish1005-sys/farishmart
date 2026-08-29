import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        User user = new User(name, email, password);

        System.out.println("\nRegistration Successful!");
        System.out.println("Name: " + user.name);
        System.out.println("Email: " + user.email);

        sc.close();
    }
}