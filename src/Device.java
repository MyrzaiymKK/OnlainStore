import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Device extends Product{
    private  String brand;
    private String color;
    private String isNew;
    private String memory;
    public Device(){

    }
    public Device(String name, String description, BigDecimal price, String brand, String color, String isNew, String memory) {
        super(name, description, price);
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public Product[] AddNewProduct(Product[] products) {
        this.setId(MyGenerate.generateId());
        while(true){
            System.out.println("Пишите brand: ");
            setBrand(new Scanner(System.in).nextLine());
            if(!getBrand().isEmpty()){
                break;
            }else System.out.println("Brand is empty! please write the brand");
        }
        while(true){
            System.out.println("Пишите название: ");
            setName(new Scanner(System.in).nextLine());
            if(!getName().isEmpty()){
                break;
            }else System.out.println("Name is empty, please write the name");
        }
        while (true){
            System.out.println("Пишите память аксесуара: ");
            setMemory(new Scanner(System.in).nextLine());
            if(!getMemory().isEmpty()){
                break;
            }else System.out.println("Empty memory,please write the memory");
        }
        while (true){
            System.out.println("Пишите цвет аксесуара");
            setColor(new Scanner(System.in).nextLine());
            if(!getColor().isEmpty()){
                break;
            }else System.out.println("Empty color, please write the color");
        }
        while(true){
            System.out.println("Пишите описание: ");
            setDescription(new Scanner(System.in).nextLine());
            if(!getDescription().isEmpty()){
                break;
            }else System.out.println("Empty discription");
        }
        while(true){
            System.out.println("Пишите цену: ");
            setPrice(BigDecimal.valueOf(new Scanner(System.in).nextInt()));
            if(getPrice().compareTo(BigDecimal.ZERO) > 0){
                break;
            }else System.out.println("Empty price,write the price");
        }
        while(true){
            System.out.println("Товар новый или б/у");
            setIsNew(new Scanner(System.in).nextLine());
            if(getIsNew().equalsIgnoreCase("n") || getIsNew().equalsIgnoreCase("by")){
                break;
            }else System.out.println("please use the n or by ");
        }
        setCreatedAt(ZonedDateTime.now());
        System.out.println("Успешно добавлен");
        Product[] newProductsArray = Arrays.copyOf(products,products.length+1);
        newProductsArray[newProductsArray.length - 1] = this;
        return newProductsArray;
    }

    @Override
    public void Products(Product[] products) {
        for (Product product : products) {
            if(product instanceof Device device){
                System.out.println(device);
            }
        }
    }


}
