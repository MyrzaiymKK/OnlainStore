import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[0];
        User currentUser = null;
        boolean n = true;
      while (true){
         System.out.println("""
                 1.Регистрация
                 2.Пользователи
                 3.Войти
                 4.Выйти
                 Выберите команду: 
                 """);
         switch (scanner.nextLine().toLowerCase()){
             case "1","Register" -> {
                 User user = new User();
             User registerUser = user.register(user);
             users  = User.addUser(users,registerUser);
                 System.out.println("Вы успешно зарегистрированы!");
             }
             case "2" -> {
                 System.out.println(Arrays.toString(users));
             }
             case "3" -> {
                 User LoginUser = User.login(users);
                 currentUser = LoginUser;
                 System.out.println("Login success!");

                 InnerLoop:
                 while (true){
                     System.out.println("""
                             0ю Выйти
                             1.Добавить продукт
                             2.Все продукты
                             3.Книги
                             4.Гаджеты
                             """);
                     switch (scanner.nextLine().toLowerCase()){
                         case "0" ->{
                            break InnerLoop;
                         }
                         case "1" ->{
                             System.out.println("Книга-1 или Гаджет-2");
                             switch (scanner.nextLine().toLowerCase()){
                                 case "1" -> {
                                     Book product = new Book();
                                     if (currentUser != null) {
                                         currentUser.setProducts(product.AddNewProduct(currentUser.getProducts()));
                                     }
                                 }
                                 case "2" ->{
                                     Device product = new Device();
                                     if (currentUser != null) {
                                         currentUser.setProducts(product.AddNewProduct(currentUser.getProducts()));
                                     }
                                 }
                             }
                         }
                         case "2" -> {
                             if(currentUser != null) Product.getAllProduct(currentUser.getProducts());
                         }
                         case "3" -> {
                           new Book().Products(currentUser.getProducts());
                         }
                         case "4" -> {
                             new Device().Products(currentUser.getProducts());
                         }
                     }
                 }
             }
             case "4" ->{
             n = false;
             }
         }
      }
    }
}