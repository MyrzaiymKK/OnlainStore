import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Book extends Product{
    private String authorName;
    public Book(){}
    public Book(String name, String description, BigDecimal price, String authorName) {
        super(name, description, price);
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    @Override
    public Product[] AddNewProduct(Product[] products) {
        this.setId(MyGenerate.generateId());
        while (true) {
            System.out.println("Pishite name of book: ");
            this.setName(new Scanner(System.in).nextLine());
            if (!getName().isEmpty()) {
                break;
            }else System.out.println("Empty product name ");
        }
        while(true){
            System.out.println("Enter price");
           this.setPrice(BigDecimal.valueOf(new Scanner(System.in).nextInt()));
            if(getPrice().compareTo(BigDecimal.ZERO) > 0){
                break;
            }else System.out.println("Price is empty");
        }
        while (true){
            System.out.println("Enter author of Book");
            this.setAuthorName(new Scanner(System.in).nextLine());
            if(!getAuthorName().isEmpty()){
                break;
            }else System.out.println("Author is empty");

        }
        setCreatedAt(ZonedDateTime.now());
        System.out.println("Книга успешно добавлено");
        products = Arrays.copyOf(products,products.length+1);
        products[products.length - 1] = this;
        System.out.println(products[0]);
        return products;
    }

    @Override
    public void Products(Product[] products) {
        for (Product product : products) {
            if(product instanceof Book book){
                System.out.println(book);
            }
        }
    }

}





