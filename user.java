import java.util.ArrayList;
import java.util.Scanner;

class User {
    String name;
    String email;
    String password;
    ArrayList<String> cart = new ArrayList<>();

    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}