import java.util.Arrays;
import java.util.Scanner;

public class User {
    private  String firstName;
    private  String lastName;
    private String email;
    private  String paswword;
    private Product[] products = new Product[0];

    public User() {
    }

    public User(String firstName, String lastName, String email, String paswword, Product[] products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.paswword = paswword;
        this.products = products;
    }

    public static User login(User[] users) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if(user.getEmail().equals(email) && user.getPaswword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaswword() {
        return paswword;
    }

    public void setPaswword(String paswword) {
        this.paswword = paswword;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public static User[] addUser(User[] users, User registerUser){
     users = Arrays.copyOf(users,users.length + 1);
     users[users.length - 1] = registerUser;
     return  users;
    }

    public  User register(User newUser) {
        while (true) {
            System.out.print("Пишите имя: ");
            newUser.setFirstName(new Scanner(System.in).nextLine());
            if (!getFirstName().isBlank()) {
                break;
            } else System.out.println("Поля пустой! Пожалуйста пишите имю");
        }
        while (true) {
            System.out.print("Пишите Фамилию: ");
            newUser.setLastName(new Scanner(System.in).nextLine());
            if (!getLastName().isEmpty()) {
                break;
            } else System.out.println("Поля пустой! Пожалуйста пишите фамилию");
        }

        while (true) {
            System.out.print("Пишите email: ");
            newUser.setEmail(new Scanner(System.in).nextLine());
            if (getEmail().endsWith("@gmail.com")) {
                break;
            } else System.out.println("Use the domain @gmail.com");
        }
        while (true) {
            System.out.print("Пишите пароль: ");
            newUser.setPaswword(new Scanner(System.in).nextLine());
            if (getPaswword().length() >= 4) {
                break;
            } else System.out.println("Пишите больше 4 символа");
        }


        return newUser;

    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", paswword='" + paswword + '\'' +
                '}';
    }
}
