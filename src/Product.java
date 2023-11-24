import java.math.BigDecimal;
import java.time.ZonedDateTime;

public abstract class Product {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private ZonedDateTime createdAt;
    private Product[] products = new Product[0];
    public Product(){

    }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description, BigDecimal price, ZonedDateTime createdAt) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public static void getAllProduct(Product[] products){
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public abstract Product[] AddNewProduct(Product[] products);
    public abstract void Products(Product[] products);

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
